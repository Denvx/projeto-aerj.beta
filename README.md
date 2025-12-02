🚍 AERJ – Sistema de Gestão de Transporte Escolar
<div align="center">
Mostrar Imagem
Mostrar Imagem
Mostrar Imagem
Mostrar Imagem
Versão Beta – Fase 1 | Back-end + Banco de Dados
</div>

📋 Sumário

Sobre o Projeto
Objetivo Geral
Visão Final do Sistema
Fluxo dos Usuários
Arquitetura
Banco de Dados
Decisões de Design
Comentários do Código
Como Usar
Requisitos
Autor


🎯 Sobre o Projeto
Sistema completo de gerenciamento para transporte escolar universitário da AERJ.
Funcionalidades Principais
MóduloRecursos👥 UsuáriosGestão de estudantes e administradores💰 FinanceiroPagamentos e mensalidades🚐 OperacionalViagens e rotas📢 ComunicaçãoSistema de avisos🔒 SegurançaAutenticação e logs de auditoria

⚠️ Nota Importante: O motorista não utiliza o sistema. Ele é cadastrado por um administrador e recebe a rota/resumo da viagem via WhatsApp.

Status Atual
Este README documenta a Fase 1 do projeto:

✅ Banco de Dados Estruturado
✅ API REST Completa
✅ Regras de Negócio Implementadas


🎯 Objetivo Geral
Construir um sistema seguro, organizado e escalável para gerenciar todo o fluxo logístico e financeiro do transporte universitário da AERJ.
Benefícios

📉 Redução de erros manuais
📊 Organização centralizada de dados
🚀 Base sólida para funcionalidades avançadas no TCC


🚀 Visão Final do Sistema
Funcionalidades Completas (Roadmap)
<table>
<tr>
<td width="50%">
🎓 Portal do Aluno

✔ Visualização de viagens
✔ Consulta de mensalidades
✔ Histórico de pagamentos
✔ Recebimento de avisos
✔ Recuperação de senha

</td>
<td width="50%">
👨‍💼 Portal do Administrador

✔ Gestão completa de usuários
✔ Controle financeiro
✔ Geração automática de mensalidades
✔ Emissão de recibos
✔ Painel em tempo real
✔ Sistema de logs e auditoria

</td>
</tr>
</table>
Recursos Avançados

🤖 Geração automática de viagens baseada em rotas
✅ Controle de presenças
📱 Integração com WhatsApp para motoristas
🔐 Segurança avançada com exclusões lógicas


👥 Fluxo dos Usuários
🎓 Alunos
mermaidgraph LR
    A[Cadastro] --> B[Login]
    B --> C[Visualizar Viagens]
    B --> D[Consultar Mensalidades]
    B --> E[Receber Avisos]
    B --> F[Histórico]
```

**Ações Disponíveis:**
- Fazer cadastro ou ser cadastrado por ADM
- Realizar login seguro
- Visualizar viagens programadas
- Consultar mensalidades e pagamentos
- Receber e visualizar avisos
- Recuperar senha
- Acessar histórico completo

---

### 👨‍💼 Administradores

**Responsabilidades:**
- 📝 Cadastrar alunos, motoristas e veículos
- 🗓️ Gerar e gerenciar viagens
- 📲 Enviar rotas para motoristas (WhatsApp)
- 💰 Acompanhar financeiro
- 📊 Visualizar logs e auditoria
- 📢 Gerenciar sistema de avisos

---

### 🚐 Motoristas

> **Perfil Simplificado:** Não utiliza o sistema diretamente

| Característica | Descrição |
|----------------|-----------|
| Acesso ao Sistema | ❌ Não possui |
| Login | ❌ Não realiza |
| Cadastro | ✅ Feito por ADM |
| Comunicação | 📱 WhatsApp apenas |
| Função | 🚗 Dirigir conforme rota |

---

## 🏗️ Arquitetura

### Stack Tecnológica
```
┌─────────────────────────────────────┐
│         FRONT-END (Futuro)          │
│    React / Angular / Vue.js         │
└──────────────┬──────────────────────┘
               │ REST API
┌──────────────┴──────────────────────┐
│           BACK-END                  │
│   Java 17+ | Spring Boot            │
│   • Controllers (REST)              │
│   • Services (Regras de Negócio)    │
│   • Repositories (JPA)              │
│   • DTOs (Entrada/Saída)            │
└──────────────┬──────────────────────┘
               │ JDBC
┌──────────────┴──────────────────────┐
│        BANCO DE DADOS               │
│   MySQL 5.7+ / MariaDB 10.2+        │
│   • Engine InnoDB                   │
│   • Relacional Normalizado          │
└─────────────────────────────────────┘
```

### Padrões Adotados

- 🎯 **MVC** - Model-View-Controller
- 📦 **DTO** - Data Transfer Objects
- 🔗 **Repository Pattern** - Abstração de dados
- 🧩 **Service Layer** - Lógica de negócio isolada

---

### ⚡ Real Time (Planejado)

**Tecnologias Avaliadas:**
- WebSockets
- Server-Sent Events (SSE)
- Long-polling (fallback)

**Funcionalidades em Tempo Real:**
- ✅ Status de presença dos alunos
- ✅ Atualizações de viagens
- ✅ Alterações de rotas
- ✅ Avisos críticos
- ✅ Logs de auditoria

> ⚠️ **Nota:** Rotas do motorista não são em tempo real — ele recebe via WhatsApp.

---

## 🗄️ Banco de Dados

### Convenções

| Aspecto | Padrão Adotado |
|---------|----------------|
| Nomenclatura | CamelCase |
| Engine | InnoDB |
| Indexação | Manual + Automática |
| Documentação | Comentários SQL |
| Validação | ENUM para campos restritos |

---

### Estrutura das Tabelas
```
📊 PESSOAS (Tabela Base)
│
├─── 👤 Usuarios (Credenciais)
│    └─── 🔑 Login e Senha
│
├─── 🎓 Alunos
│    ├─── Matrícula
│    └─── Curso
│
├─── 🚐 Motoristas
│    ├─── CNH
│    └─── Categoria
│
└─── 👨‍💼 Administradores
     └─── Nível de Acesso

💰 FINANCEIRO
├─── Mensalidades
│    ├─── Valor
│    ├─── Vencimento
│    └─── Status
│
└─── Pagamentos
     ├─── Data
     ├─── Valor
     └─── Método

🚍 OPERACIONAL
├─── Rotas
│    ├─── Origem
│    ├─── Destino
│    └─── Paradas
│
├─── Veículos
│    ├─── Placa
│    ├─── Modelo
│    └─── Capacidade
│
├─── Viagens
│    ├─── Data/Hora
│    ├─── Rota
│    ├─── Veículo
│    └─── Motorista
│
└─── AlunosViagens (N:N)
     ├─── Presença
     └─── Observações

📝 AUDITORIA
├─── Logs
│    ├─── Ação
│    ├─── Usuário
│    └─── Timestamp
│
└─── Avisos
     ├─── Título
     ├─── Mensagem
     └─── Data
```

---

## 💡 Decisões de Design

### 1. 📊 Tabela Pessoas como Base

**Por que centralizar dados pessoais?**

<table>
<tr>
<td width="50%">

#### ❌ Sem Tabela Pessoas
```
Alunos {
  nome, cpf, email, telefone
}
Motoristas {
  nome, cpf, email, telefone
}
Administradores {
  nome, cpf, email, telefone
}
```
**Problema:** Dados duplicados

</td>
<td width="50%">

#### ✅ Com Tabela Pessoas
```
Pessoas {
  nome, cpf, email, telefone
}
Alunos {
  pessoaId → Pessoas
}
Motoristas {
  pessoaId → Pessoas
}
```
**Vantagem:** Dados centralizados

</td>
</tr>
</table>

**Benefícios:**
- ✅ Evita duplicação de dados
- ✅ Uma pessoa pode ter múltiplos papéis
- ✅ Facilita manutenção
- ✅ Mantém normalização 3FN

**Diagrama de Relacionamento:**
```
Pessoas 1───1 Usuarios
   │
   ├──1 Alunos
   │
   ├──1 Motoristas
   │
   └──1 Administradores

2. 🔐 Login e Segurança
Quem Pode Fazer Login?
UsuárioAcesso🎓 Alunos✅ Sim👨‍💼 Administradores✅ Sim🚐 Motoristas❌ Não
Armazenamento de Senhas
sqlsenhaHash VARCHAR(255) COMMENT 'Senha criptografada com BCrypt'
Processo:

Usuário informa senha
Sistema aplica BCrypt
Hash é armazenado
Senha original nunca é salva

Recuperação de Senha
mermaidgraph LR
    A[Usuário solicita] --> B[Sistema gera token]
    B --> C[Envia email]
    C --> D[Usuário acessa link]
    D --> E[Redefine senha]

3. 🔗 Relacionamentos Principais
Alunos ⟷ Viagens (N:N)
Por que muitos-para-muitos?

✅ Um aluno participa de várias viagens
✅ Uma viagem inclui vários alunos

sqlAlunosViagens {
  alunoId → Alunos
  viagemId → Viagens
  presente BOOLEAN
  observacao TEXT
}
Viagens → Motorista (N:1)
Regras:

1 motorista por viagem
Motorista não acessa sistema
Recebe rota via WhatsApp

Veículos → Viagens (1:N)
Lógica:

Cada viagem usa 1 veículo
Um veículo participa de várias viagens


4. 🗑️ Exclusão Lógica
Entidades com Soft Delete:
sqlativo BOOLEAN DEFAULT TRUE
Aplicado em:

✅ Pessoas
✅ Usuarios
✅ Alunos
✅ Motoristas
✅ Veiculos

Por Que Não Excluir Fisicamente?
MotivoBenefício📊 HistóricoMantém dados para relatórios🔗 IntegridadeEvita quebrar relacionamentos⚖️ LegalAtende requisitos de auditoria🔄 ReativaçãoPermite restaurar registros

5. ⚡ Performance e Índices
Índices Estratégicos:
sql-- Busca rápida por CPF
INDEX idx_identificacao (identificacao)

-- Filtro por matrícula
INDEX idx_matricula (matricula)

-- Consultas por data
INDEX idx_dataViagem (dataViagem)

-- Busca por status
INDEX idx_ativo (ativo)
Benefícios:

🚀 Consultas até 100x mais rápidas
📉 Menor carga no servidor
✅ Melhor experiência do usuário


💻 Comentários Importantes do Código
1. PessoaModel
java/**
 * Tabela base de todos os tipos de usuários do sistema.
 * 
 * Racional: centralizar dados pessoais (nome, CPF, email)
 * para evitar duplicação e facilitar manutenção.
 */
@Entity
@Table(name = "pessoas")
public class PessoaModel {
    
    /**
     * CPF sem pontuação, único no banco.
     * Evita duplicidades como dois cadastros da mesma pessoa.
     */
    @Column(unique = true, length = 11)
    private String identificacao;
    
    /**
     * Exclusão lógica. Nunca removemos pessoa definitivamente.
     * Permite histórico e auditoria completos.
     */
    private boolean ativo = true;
}

2. UsuarioModel
java/**
 * Representa a credencial de login.
 * Associada diretamente a uma Pessoa via relacionamento 1:1.
 */
@Entity
@Table(name = "usuario")
public class UsuarioModel {
    
    /**
     * Senha nunca é armazenada em texto puro.
     * Sempre vem com BCrypt no campo senhaHash.
     * 
     * Segurança: BCrypt é resistente a ataques de força bruta
     * e rainbow tables.
     */
    @Column(nullable = false)
    private String senhaHash;
    
    /**
     * Papel do usuário no sistema.
     * Valores possíveis: ALUNO, ADMINISTRADOR
     * 
     * Nota: Motorista não possui login, logo não tem role.
     */
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}

3. AlunoModel
java/**
 * Extensão da Pessoa contendo dados específicos de aluno.
 * Herda nome, CPF, email, etc. da tabela Pessoas.
 */
@Entity
@Table(name = "aluno")
public class AlunoModel {
    
    /**
     * Relacionamento 1:1 com Pessoa.
     * Cada aluno está vinculado a exatamente uma pessoa.
     */
    @OneToOne
    @JoinColumn(name = "pessoaId", nullable = false)
    private PessoaModel pessoa;
    
    /**
     * Matrícula única do aluno na instituição.
     * Usado para controle acadêmico e integração.
     */
    @Column(unique = true, length = 20)
    private String matricula;
}

4. ViagemModel
java/**
 * Representa uma viagem real do transporte escolar.
 * Cada viagem tem motorista, veículo, rota e alunos.
 */
@Entity
@Table(name = "viagem")
public class ViagemModel {
    
    /**
     * FK para Motorista.
     * 
     * Importante: O motorista é cadastrado por um ADM
     * e recebe a rota via WhatsApp. Ele NÃO usa o app.
     */
    @ManyToOne
    @JoinColumn(name = "motoristaId", nullable = false)
    private MotoristaModel motorista;
    
    /**
     * Data e hora programadas para a viagem.
     * Usada para gerar notificações e organizar agenda.
     */
    @Column(nullable = false)
    private LocalDateTime dataHoraViagem;
}

5. AlunosViagens
java/**
 * Tabela de junção para relação muitos-para-muitos.
 * Guarda presença, status e descrições da participação do aluno.
 * 
 * Esta tabela permite:
 * - Registrar se o aluno compareceu
 * - Adicionar observações (ex: "Faltou por motivo de saúde")
 * - Manter histórico completo de participações
 */
@Entity
@Table(name = "alunos_viagens")
public class AlunosViagens {
    
    @ManyToOne
    @JoinColumn(name = "alunoId")
    private AlunoModel aluno;
    
    @ManyToOne
    @JoinColumn(name = "viagemId")
    private ViagemModel viagem;
    
    /**
     * Indica se o aluno compareceu à viagem.
     * NULL = ainda não verificado
     * TRUE = presente
     * FALSE = ausente
     */
    private Boolean presente;
    
    /**
     * Campo livre para observações sobre a presença.
     * Ex: "Chegou atrasado", "Saiu mais cedo", etc.
     */
    @Column(columnDefinition = "TEXT")
    private String observacao;
}

🚀 Como Usar o Projeto
Passo a Passo
1️⃣ Clonar o Repositório
bashgit clone https://github.com/seu-usuario/aerj-sistema.git
cd aerj-sistema
2️⃣ Configurar o Banco de Dados
Edite src/main/resources/application.properties:
properties# Configuração do MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/aerj_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
3️⃣ Importar no IntelliJ IDEA

Abra o IntelliJ
File → Open
Selecione a pasta do projeto
Aguarde o Maven baixar as dependências

4️⃣ Executar o Projeto
bash# Via Maven
./mvnw spring-boot:run

# Ou no IntelliJ
Run → Run 'Application'
O banco será criado automaticamente na primeira execução! 🎉
5️⃣ Testar a API
Usando Postman/Insomnia:
httpGET http://localhost:8080/api/alunos
POST http://localhost:8080/api/viagens
PUT http://localhost:8080/api/mensalidades/{id}

📦 Requisitos
Tecnologias Necessárias
TecnologiaVersão Mínima☕ Java17+🍃 Spring Boot3.x🐬 MySQL5.7+🐳 MariaDB10.2+📦 Maven3.8+
Dependências Principais
xml<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>
    
    <!-- Spring Security (Planejado) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>

👨‍💻 Autor
<div align="center">
Denver
Projeto desenvolvido como parte da evolução acadêmica e desenvolvimento do TCC.
Mostrar Imagem
Mostrar Imagem
</div>

<div align="center">
📞 Suporte
Encontrou algum problema? Abra uma issue

AERJ Sistema © 2024 | Desenvolvido com ❤️ por Denver
</div>
