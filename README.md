# projeto-aerj.beta
Sistema de gerenciamento de transporte escolar desenvolvido para uma associação municipal, destinado ao controle logístico e administrativo do transporte de estudantes universitários entre a cidade de origem e Feira de Santana. O projeto abrange gestão de alunos, motoristas, veículos, rotas, viagens, pagamentos, mensalidades e etc.

# Sistema de Gestão de Transporte Escolar

## Sumário
- [Sobre o Projeto](#sobre-o-projeto)
- [Arquitetura do Banco de Dados](#arquitetura-do-banco-de-dados)
- [Decisões de Design Importantes](#decisões-de-design-importantes)
- [Relacionamentos Principais](#relacionamentos-principais)
- [Segurança e Integridade de Dados](#segurança-e-integridade-de-dados)
- [Exclusão Lógica](#exclusão-lógica)
- [Performance e Índices](#performance-e-índices)
- [Como Usar](#como-usar)
- [Requisitos](#requisitos)

---

## Sobre o Projeto

Sistema de banco de dados relacional desenvolvido para gerenciar operações completas de transporte escolar, incluindo controle de alunos, motoristas, veículos, rotas, viagens, pagamentos e mensalidades.

### Principais Funcionalidades

- Cadastro unificado de pessoas (alunos, motoristas, administradores)
- Gestão completa de veículos e rotas
- Controle de viagens e reserva de assentos
- Sistema de pagamentos e mensalidades
- Logs de auditoria
- Sistema de avisos

---

## Arquitetura do Banco de Dados

### Padrão Adotado: CamelCase

Todas as tabelas e colunas seguem o padrão CamelCase para manter consistência:
- Tabelas: `Pessoas`, `AlunosViagens`, `MetodoPagamentos`
- Colunas: `pessoasId`, `dataNascimento`, `apelidoUsuario`

**Motivo**: Padronização, legibilidade e facilidade de manutenção.

### Engine: InnoDB

**Motivos da escolha**:
- Suporte completo a transações (ACID compliance)
- Suporte a Foreign Keys para integridade referencial
- Bloqueio por linha (melhor performance em ambientes multi-usuário)
- Recuperação automática de falhas
- Padrão moderno do MySQL/MariaDB

### Total de Tabelas: 15

```
Pessoas (base)
├── Alunos
├── Motoristas
├── Administradores
├── Usuarios
└── Enderecos

Operacionais
├── Veiculos
├── Rotas
├── Viagens
├── AlunosViagens (N:N)
└── Assentos

Financeiro
├── Pagamentos
├── Mensalidades
└── MetodoPagamentos

Auditoria
├── Logs
└── Avisos
```

---

## Decisões de Design Importantes

### 1. Tabela Pessoas como Base

**Decisão**: Criar uma tabela `Pessoas` centralizada para armazenar dados comuns.

**Por que?**
- Evita duplicação de dados (name, CPF, telefone, email)
- Uma pessoa pode ter múltiplos papéis (ex: aluno que vira motorista)
- Facilita atualizações de dados pessoais
- Segue o princípio DRY (Don't Repeat Yourself)
- Normalização (3FN)

**Estrutura**:
```sql
Pessoas
├── Alunos (1:N)
├── Motoristas (1:N)
├── Administradores (1:N)
├── Usuarios (1:N)
└── Enderecos (1:N)
```

---

### 2. Campo `tempoEstimado` em Rotas

**Decisão**: Usar `INT` (minutos) ao invés de `TIME`.

**Por que?**
- `TIME` limita-se a 838:59:59 (menos de 35 dias)
- Rotas longas podem exceder 24 horas
- `INT` permite cálculos matemáticos simples
- Flexibilidade para converter em horas, dias, etc.

**Exemplo**:
```sql
-- Rota de 2h30min
tempoEstimado = 150 (minutos)

-- Consulta: converter para horas
SELECT tempoEstimado / 60 AS horas FROM Rotas;
```

---

### 3. Status em Veículos vs Campo Ativo

**Decisão**: Manter ambos `status ENUM` e `ativo BOOLEAN`.

**Por que?**
- `status`: Estado operacional temporário
  - 'Ativo': Disponível para uso
  - 'Manutenção': Temporariamente indisponível
  - 'Reservado': Alocado para viagem específica
  - 'Inativo': Parado mas pode voltar
  
- `ativo`: Desativação permanente
  - FALSE: Veículo vendido, sucateado ou removido da frota
  - Mantém histórico de viagens antigas

**Uso prático**:
```sql
-- Veículos disponíveis AGORA
SELECT * FROM Veiculos WHERE ativo = TRUE AND status = 'Ativo';

-- Todos veículos (incluindo histórico)
SELECT * FROM Veiculos WHERE ativo = FALSE;
```

---

### 4. Relacionamento Alunos e Viagens (N:N)

**Decisão**: Criar tabela intermediária `AlunosViagens`.

**Por que?**
- Um aluno pode participar de várias viagens
- Uma viagem pode ter vários alunos
- Permite armazenar informações específicas da relação (status, descrição)
- Facilita consultas e relatórios

**Estrutura**:
```sql
AlunosViagens
├── alunosId (FK)
├── viagensId (FK)
├── status ENUM('Confirmado', 'Pendente', 'Cancelado', 'Ausente')
└── descricao TEXT
```

---

### 5. Separação Pagamentos e Mensalidades

**Decisão**: Tabelas separadas ao invés de uma única tabela.

**Por que?**
- **Mensalidades**: Valores devidos (obrigação)
- **Pagamentos**: Valores pagos (quitação)
- Permite múltiplos pagamentos para uma mensalidade (parcelamento)
- Facilita controle de inadimplência
- Histórico financeiro mais claro

**Fluxo**:
```
1. Gerar Mensalidade (R$ 200,00) - mês de Outubro
2. Aluno paga R$ 100,00 (Pagamento 1)
3. Aluno paga R$ 100,00 (Pagamento 2)
4. Mensalidade quitada
```

---

## Relacionamentos Principais

### Diagrama Simplificado

```
Pessoas 1───N Alunos
              │
              ├─── 1:N Pagamentos
              ├─── 1:N Mensalidades
              └─── N:M Viagens (via AlunosViagens)

Pessoas 1───N Motoristas 1───N Viagens
                                │
Rotas 1─────N Viagens           │
                │               │
Veiculos 1───N Viagens          │
                                │
                         N:1 Assentos N:1 Usuarios
```

### Constraints de Integridade

**ON DELETE RESTRICT**: Usado em relações financeiras e críticas
- Impede exclusão acidental de dados importantes
- Força verificação antes de deletar
- Protege histórico financeiro

**Exemplos**:
```sql
-- Não pode apagar Aluno com Pagamentos
FOREIGN KEY (alunosId) REFERENCES Alunos(idUser) ON DELETE RESTRICT

-- Não pode apagar Pessoa com Usuarios
FOREIGN KEY (pessoasId) REFERENCES Pessoas(idUser) ON DELETE RESTRICT
```

---

## Segurança e Integridade de Dados

### 1. Campos UNIQUE

Garantem unicidade de dados críticos:
```sql
- identificacao (CPF) - UNIQUE
- matricula - UNIQUE
- cnh - UNIQUE
- placa - UNIQUE
- apelidoUsuario - UNIQUE
```

### 2. Validações via ENUM

Limitam valores aceitos, evitando dados inválidos:
```sql
sexo ENUM('M', 'F', 'Outro', 'Prefiro não informar')
role ENUM('Administrador', 'Motorista', 'Aluno', 'Suporte')
status ENUM('Agendada', 'Em andamento', 'Concluída', 'Cancelada')
```

### 3. Timestamps Automáticos

Rastreiam criação e modificação:
```sql
dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP
dataAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
```

### 4. Comentários em Campos Sensíveis

Documentam formato esperado:
```sql
identificacao VARCHAR(11) COMMENT 'CPF sem pontuação'
cep VARCHAR(8) COMMENT 'CEP sem pontuação'
senhaHash VARCHAR(255) COMMENT 'Senha criptografada'
```

---

## Exclusão Lógica

### O Problema da Exclusão Física

Apagar dados permanentemente causa:
- Perda de histórico financeiro
- Impossibilidade de auditoria
- Violação de requisitos legais (LGPD)
- Relatórios inconsistentes

### A Solução: Campo `ativo`

**Implementação**:
```sql
ativo BOOLEAN DEFAULT TRUE
```

**Tabelas com exclusão lógica**:
- Pessoas
- Alunos
- Motoristas
- Usuarios
- Veiculos

### Como Funciona

**Desativar usuário** (ao invés de DELETE):
```sql
UPDATE Pessoas SET ativo = FALSE WHERE idUser = 1;
UPDATE Usuarios SET ativo = FALSE WHERE pessoasId = 1;
UPDATE Alunos SET ativo = FALSE WHERE pessoasId = 1;
```

**Listar apenas ativos**:
```sql
SELECT * FROM Alunos WHERE ativo = TRUE;
SELECT * FROM Usuarios WHERE ativo = TRUE;
```

**Reativar usuário**:
```sql
UPDATE Pessoas SET ativo = TRUE WHERE idUser = 1;
UPDATE Usuarios SET ativo = TRUE WHERE pessoasId = 1;
```

### Vantagens

1. **Conformidade LGPD**: Mantém dados para fins legais
2. **Histórico completo**: Pagamentos e viagens preservados
3. **Auditoria**: Rastreabilidade total
4. **Reversibilidade**: Pode reativar se necessário
5. **Integridade**: Sem referências quebradas

---

## Performance e Índices

### O que são Índices?

Índices funcionam como o índice de um livro: permitem encontrar informações rapidamente sem ler tudo.

### Índices Criados

**Pessoas**:
```sql
INDEX idx_identificacao (identificacao)  -- Busca por CPF
INDEX idx_nome (name)                    -- Busca/ordenação por name
INDEX idx_ativo (ativo)                  -- Filtragem de ativos
```

**Alunos**:
```sql
INDEX idx_matricula (matricula)          -- Busca por matrícula
INDEX idx_ativo (ativo)                  -- Filtragem de ativos
```

**Viagens**:
```sql
INDEX idx_dataViagem (dataViagem)        -- Consultas por data
INDEX idx_status (status)                -- Filtragem por status
```

### Impacto na Performance

**Sem índice** (100.000 registros):
```sql
SELECT * FROM Pessoas WHERE identificacao = '12345678901';
-- Tempo: ~500ms (lê todos os registros)
```

**Com índice**:
```sql
SELECT * FROM Pessoas WHERE identificacao = '12345678901';
-- Tempo: ~5ms (vai direto ao registro)
```

**Ganho: 100x mais rápido**

### Índices Automáticos

O MySQL cria automaticamente índices em:
- PRIMARY KEY (idUser)
- UNIQUE (identificacao, matricula, cnh, placa)
- FOREIGN KEY (InnoDB cria automaticamente)

---

## Como Usar

### 1. Instalação

**Requisitos**:
- MySQL 5.7+ ou MariaDB 10.2+
- Cliente MySQL (mysql-client, phpMyAdmin, MySQL Workbench)

**Criar banco de dados**:
```bash
mysql -u root -p < schema.sql
```

Ou via cliente:
```sql
SOURCE /caminho/para/schema.sql;
```

### 2. Operações Básicas

**Cadastrar nova pessoa/aluno**:
```sql
-- 1. Inserir pessoa
INSERT INTO Pessoas (name, identificacao, dataNascimento, telefone, email, sexo)
VALUES ('João Silva', '12345678901', '2000-05-15', '71987654321', 'joao@email.com', 'M');

-- 2. Inserir aluno
INSERT INTO Alunos (pessoasId, matricula, curso, instituicao)
VALUES (LAST_INSERT_ID(), 'ALU2024001', 'Engenharia', 'Universidade Federal');

-- 3. Criar usuário
INSERT INTO Usuarios (pessoasId, apelidoUsuario, senhaHash, role)
VALUES (LAST_INSERT_ID(), 'joaosilva', '$2y$10$hash...', 'Aluno');
```

**Cadastrar viagem**:
```sql
INSERT INTO Viagens (rotasId, motoristasId, veiculosId, dataViagem, horarioSaida, status)
VALUES (1, 1, 1, '2024-11-15', '07:00:00', 'Agendada');
```

**Vincular aluno à viagem**:
```sql
INSERT INTO AlunosViagens (alunosId, viagensId, status)
VALUES (1, 1, 'Confirmado');
```

**Registrar pagamento**:
```sql
INSERT INTO Pagamentos (alunosId, dataPagamento, valor, metodoPagamentosId, statusPagamentoId)
VALUES (1, CURDATE(), 200.00, 2, 1);
```

### 3. Consultas Úteis

**Listar alunos ativos com dados pessoais**:
```sql
SELECT 
    a.matricula,
    p.name,
    p.email,
    p.telefone,
    a.curso
FROM Alunos a
INNER JOIN Pessoas p ON a.pessoasId = p.idUser
WHERE a.ativo = TRUE AND p.ativo = TRUE;
```

**Viagens do dia com motorista e veículo**:
```sql
SELECT 
    v.idUser,
    v.horarioSaida,
    r.origem,
    r.destino,
    p.name AS motorista,
    ve.placa,
    ve.modelo
FROM Viagens v
INNER JOIN Rotas r ON v.rotasId = r.idUser
INNER JOIN Motoristas m ON v.motoristasId = m.idUser
INNER JOIN Pessoas p ON m.pessoasId = p.idUser
INNER JOIN Veiculos ve ON v.veiculosId = ve.idUser
WHERE v.dataViagem = CURDATE()
AND v.status = 'Agendada';
```

**Alunos inadimplentes**:
```sql
SELECT 
    p.name,
    a.matricula,
    m.mesReferencia,
    m.valor,
    COALESCE(SUM(pag.valor), 0) AS pago,
    (m.valor - COALESCE(SUM(pag.valor), 0)) AS devido
FROM Mensalidades m
INNER JOIN Alunos a ON m.alunosId = a.idUser
INNER JOIN Pessoas p ON a.pessoasId = p.idUser
LEFT JOIN Pagamentos pag ON pag.alunosId = a.idUser 
    AND MONTH(pag.dataPagamento) = MONTH(m.mesReferencia)
WHERE a.ativo = TRUE
GROUP BY m.idUser, p.name, a.matricula, m.mesReferencia, m.valor
HAVING devido > 0;
```

**Veículos disponíveis**:
```sql
SELECT 
    placa,
    modelo,
    capacidade,
    status
FROM Veiculos
WHERE ativo = TRUE 
AND status IN ('Ativo', 'Reservado')
ORDER BY capacidade DESC;
```

### 4. Desativar Usuário (Exclusão Lógica)

```sql
-- Desativar completamente
UPDATE Pessoas SET ativo = FALSE WHERE idUser = 1;
UPDATE Alunos SET ativo = FALSE WHERE pessoasId = 1;
UPDATE Usuarios SET ativo = FALSE WHERE pessoasId = 1;

-- Ou apenas impedir login
UPDATE Usuarios SET ativo = FALSE WHERE idUser = 1;
```

---

## Requisitos

### Ambiente de Desenvolvimento

- MySQL 5.7+ ou MariaDB 10.2+
- Codificação: UTF-8 (utf8mb4_unicode_ci)
- InnoDB como engine padrão

### Configurações Recomendadas

```ini
[mysqld]
default-storage-engine=InnoDB
character-set-server=utf8mb4
collation-server=utf8mb4_unicode_ci
max_allowed_packet=256M
innodb_buffer_pool_size=1G
```

### Permissões Necessárias

```sql
GRANT ALL PRIVILEGES ON TransporteEscolar.* TO 'usuario'@'localhost';
FLUSH PRIVILEGES;
```

---

## Autor

Desenvolvido como projeto acadêmico para disciplina de Banco de Dados.

## Licença

Este projeto é de uso educacional.