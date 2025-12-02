<h1 align="center">AERJ – Sistema de Gestão de Transporte Escolar</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Beta%20v1.0-yellow?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot"/>
  <img src="https://img.shields.io/badge/MySQL-5.7%2B-blue?style=for-the-badge&logo=mysql"/>
</p>

<p align="center"><strong>Versão Beta – Fase 1</strong> | Back-end + Banco de Dados</p>

<p align="center">
  <a href="#-sobre-o-projeto">Sobre o Projeto</a> •
  <a href="#-objetivo-geral">Objetivo Geral</a> •
  <a href="#-visão-final-do-sistema">Visão Final</a> •
  <a href="#-fluxo-dos-usuários">Fluxo dos Usuários</a> •
  <a href="#-arquitetura">Arquitetura</a> •
  <a href="#-banco-de-dados">Banco de Dados</a> •
  <a href="#-decisões-de-design">Decisões de Design</a> •
  <a href="#-comentários-do-código">Comentários</a> •
  <a href="#-como-usar">Como Usar</a> •
  <a href="#-requisitos">Requisitos</a> •
  <a href="#-autor">Autor</a>
</p>

---

## 📘 Sobre o Projeto

Sistema completo de gerenciamento para o transporte escolar universitário da AERJ, com foco em controle operacional, financeiro e administrativo.

### ⭐ Funcionalidades Principais

| Módulo | Recursos |<br>
|--------|----------|<br>
| **Usuários** | Gestão de estudantes e administradores |<br>
| **Financeiro** | Pagamentos, mensalidades, pendências |<br>
| **Operacional** | Viagens, rotas, veículos, motoristas |<br>
| **Comunicação** | Sistema de avisos |<br>
| **Segurança** | Autenticação JWT e logs de auditoria |<br>

**Importante:** Motoristas não acessam o sistema. Eles são cadastrados pelos administradores e recebem rotas via WhatsApp.

---

## 🧭 Objetivo Geral

Construir um sistema seguro, escalável e organizado para gestão completa do transporte universitário.

**Benefícios:**
- Centralização completa
- Redução de erros manuais
- Automação de processos
- Base sólida para futuras funcionalidades do TCC

---

## 🚀 Visão Final do Sistema (Roadmap)

### Portal do Aluno
- Visualização de viagens
- Histórico de pagamentos
- Consulta de mensalidades
- Avisos
- Recuperação de senha

### Portal do Administrador
- Gestão de usuários
- Controle financeiro
- Geração de mensalidades
- Painel de controle
- Logs e auditoria

### Recursos Avançados (Futuro)
- Geração automática de viagens
- Controle de presença
- Envio automático de rotas
- Exclusões lógicas e histórico completo

---

## 🧑‍🤝‍🧑 Fluxo dos Usuários

### Alunos — Ações Disponíveis
- Cadastro
- Login
- Visualização de viagens
- Consultas financeiras
- Avisos
- Histórico

### Administradores — Responsabilidades
- Cadastro de alunos
- Cadastro de motoristas
- Gerenciamento de veículos
- Gestão de rotas e viagens
- Controle financeiro
- Avisos
- Auditoria

### Motoristas — Perfil Simplificado
| Característica | Descrição |<br>
|----------------|-----------|<br>
| Acesso ao sistema | Não possui |<br>
| Cadastro | Feito pelo administrador |<br>
| Comunicação | WhatsApp |<br>
| Função | Conduzir conforme rota |<br>

---

## 🏗 Arquitetura

┌─────────────────────────────────────┐<br>
│ FRONT-END (Futuro)                  │<br>
│ React / Angular / Vue.js            │<br>
└───────────────────┬─────────────────┘<br>
│ REST API<br>
┌───────────────────┴─────────────────┐<br>
│ BACK-END                            │<br>
│ Java 17+ • Spring Boot 3.x          │<br>
│ • Controllers                       │<br>
│ • Services                          │<br>
│ • Repositories                      │<br>
│ • DTOs                              │<br>
└───────────────────┬─────────────────┘<br>
│ JDBC<br>
┌───────────────────┴─────────────────┐<br>
│ BANCO DE DADOS │<br>
│ MySQL / MariaDB (InnoDB) │<br>
└─────────────────────────────────────┘<br>


### Padrões Adotados
- MVC
- DTO
- Camada Service
- Repository Pattern
- Value Objects (CPF, Email etc.)

### Real-Time (Planejado)
- WebSockets
- SSE
- Logs em tempo real
- Atualização automática

---

## 🗄 Banco de Dados

### Convenções
| Aspecto | Padrão |<br>
|---------|--------|<br>
| Nomenclatura | CamelCase |<br>
| Engine | InnoDB |<br>
| Validação | ENUM |<br>
| Indexação | Manual + automática |<br>
| Documentação | Comentários em SQL |<br>

### Estrutura (Resumo)
- **Pessoas**
  - Usuários
  - Alunos
  - Motoristas
  - Administradores
- **Financeiro**
  - Mensalidades
  - Pagamentos
- **Operacional**
  - Rotas
  - Veículos
  - Viagens
  - AlunosViagens (N:N)
- **Auditoria**
  - Logs
  - Avisos

---

markdown
## 🎯 Decisões de Design

### 4. Exclusão Lógica
sql
ativo BOOLEAN DEFAULT TRUE
Mantém histórico sem perda de dados

Facilita recuperação de dados

Melhora performance em consultas

5. Performance e Índices
Índice	Tabela	Campo	Descrição
idx_identificacao	Pessoas	identificacao	Busca rápida por CPF/ID
idx_matricula	Alunos	matricula	Consultas por matrícula
idx_dataViagem	Viagens	data_viagem	Filtros temporais
idx_ativo	Todas	ativo	Consultas de registros ativos
Benefícios dos Índices:

Consultas mais rápidas

Melhor desempenho em operações de JOIN

Otimização de buscas frequentes

📝 Comentários do Código
PessoaModel
Tabela base de todos os tipos de usuários do sistema.

Principais campos:

id: Identificador único

nome: Nome completo

email: E-mail para contato

telefone: Telefone para comunicação

ativo: Status do registro

UsuarioModel
Gerencia autenticação e acesso ao sistema.

Características:

Senha sempre armazenada com BCrypt

Relacionamento 1:1 com Pessoa

Controle de tentativas de login

Data de último acesso

AlunoModel
Extensão da tabela Pessoas com dados acadêmicos.

Campos específicos:

matricula: Número de matrícula

curso: Curso do aluno

periodo: Período atual

turno: Turno das aulas

ViagemModel
Representa uma viagem real do transporte escolar.

Estrutura:

rota: Trajeto da viagem

horario_saida: Horário de partida

horario_chegada: Horário estimado de chegada

motorista_id: Motorista responsável

veiculo_id: Veículo utilizado

AlunosViagens
Tabela de relacionamento N:N contendo presença e observações.

Propósito:

Registro de presença dos alunos

Observações sobre a viagem

Controle de embarque/desembarque

▶️ Como Usar o Projeto
1. Clonar o Repositório
bash
git clone https://github.com/Denvx/aerj-sistema.git
cd aerj-sistema
2. Configurar o Banco de Dados
Edite o arquivo de configuração:

src/main/resources/application.properties

properties
spring.datasource.url=jdbc:mysql://localhost:3306/aerj_sistema
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
3. Importar no IntelliJ ou Eclipse
Abra a IDE de sua preferência

Selecione "Import Project"

Escolha a pasta do projeto

Aguarde a importação das dependências Maven

4. Executar a Aplicação
bash
./mvnw spring-boot:run
5. Testar no Postman
## 📊 Endpoints da API

### 🔍 Endpoints Principais para Teste

| Método | Endpoint | Descrição | Body (Exemplo) |<br>
|--------|----------|-----------|----------------|<br>
| `GET` | `/api/alunos` | Listar todos os alunos | `-` |<br>
| `POST` | `/api/alunos` | Cadastrar novo aluno | `{"nome": "João Silva", "email": "joao@email.com", "matricula": "2024001"}` |<br>
| `GET` | `/api/alunos/{id}` | Buscar aluno por ID | `-` |<br>
| `PUT` | `/api/alunos/{id}` | Atualizar dados do aluno | `{"telefone": "11999999999", "curso": "Engenharia"}` |<br>
| `DELETE` | `/api/alunos/{id}` | Exclusão lógica do aluno | `-` |<br>
| `GET` | `/api/viagens` | Listar todas as viagens | `-` |<br>
| `POST` | `/api/viagens` | Criar nova viagem | `{"rota": "Centro ↔ Campus", "horarioSaida": "07:00", "motoristaId": 1}` |<br>
| `GET` | `/api/viagens/{id}` | Detalhes da viagem | `-` |<br>
| `PUT` | `/api/viagens/{id}` | Atualizar viagem | `{"horarioChegada": "08:30"}` |<br>
| `PUT` | `/api/mensalidades/{id}` | Atualizar mensalidade | `{"status": "PAGO", "dataPagamento": "2024-01-15"}` |<br>
| `GET` | `/api/mensalidades/aluno/{id}` | Mensalidades do aluno | `-` |<br>

### 📋 Exemplo de Requisição Completa
**POST /api/alunos**
json
{
  "nome": "Maria Souza",
  "email": "maria@email.com",
  "cpf": "123.456.789-00",
  "telefone": "(11) 99999-8888",
  "matricula": "2024002",
  "curso": "Ciência da Computação",
  "periodo": 3,
  "turno": "MATUTINO"
}
🔐 Endpoints de Autenticação
Método	Endpoint	Descrição
POST	/api/auth/login	Login no sistema
POST	/api/auth/registro	Registro de novo usuário
POST	/api/auth/refresh	Refresh token
POST	/api/auth/logout	Logout do sistema
🛠️ Requisitos Técnicos
<div align="center">
Tecnologia	Versão Mínima	Finalidade	Status
Java	17+	Linguagem principal do backend	✅ Obrigatório
Spring Boot	3.x	Framework de desenvolvimento	✅ Obrigatório
MySQL	5.7+	Banco de dados relacional	✅ Obrigatório
MariaDB	10.2+	Alternativa ao MySQL	✅ Compatível
Maven	3.8+	Gerenciamento de dependências	✅ Obrigatório
Git	2.20+	Controle de versão	✅ Recomendado
Docker	20.10+	Containerização	⚠️ Opcional
Postman	10.0+	Testes de API	⚠️ Opcional
</div>
<br>

## 📊 Compatibilidade de Versões

<div align="center">

### ✅ **Versões Testadas e Validadas**
┌─────────────────────────────────────────────────┐<br>
│ VERSÕES OFICIALMENTE TESTADAS                   │<br>
├─────────────────────────────────────────────────┤<br>
│ • Java: 17, 21                                  │<br>
│ • Spring Boot: 3.1.5, 3.2.0                     │<br>
│ • MySQL: 8.0, 8.2                               │<br>
│ • MariaDB: 10.6, 10.11                          │<br>
│ • Maven: 3.8.6, 3.9.6                           │<br>
└─────────────────────────────────────────────────┘<br>

text

<br>

### 🔄 **Compatibilidade com Versões Posteriores**
Versões mais recentes das tecnologias listadas
também são compatíveis, desde que mantenham
as funcionalidades essenciais utilizadas.

text

<br>

### ⚠️ **Nota Importante sobre Compatibilidade**

> A aplicação foi testada e validada com as versões especificadas acima.  
> Recomenda-se utilizar as versões testadas para garantir estabilidade total.  
> Para versões mais recentes, realize testes preliminares antes do deploy em produção.

</div>

<br>
<br>
<br>

🔧 Stack Tecnológica Completa
<p align="center"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" title="Java 17+" alt="Java"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="60" title="Spring Boot 3.x" alt="Spring Boot"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="60" title="MySQL 5.7+" alt="MySQL"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mariadb/mariadb-original.svg" width="60" title="MariaDB 10.2+" alt="MariaDB"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="60" title="Maven 3.8+" alt="Maven"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="60" title="Git" alt="Git"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" width="60" title="Postman" alt="Postman"/> </p>
Nota: A aplicação foi testada e validada com as versões especificadas acima. Versões mais recentes também são compatíveis.

<h2>👨‍💻 Autor</h2>
 
<h3>🎓 Denver<br></h3>
<p align="center">Desenvolvedor Full-Stack & Acadêmico</p>
<p align="center"> Projeto desenvolvido como parte da evolução acadêmica e do Trabalho de Conclusão de Curso (TCC). </p><div align="center"> <a href="mailto:denver.o.dev@gmail.com"> <img src="https://img.shields.io/badge/📧_Email-D14836?style=for-the-badge&logo=gmail&logoColor=white&labelColor=555555"/> </a> <a href="https://github.com/Denvx"> <img src="https://img.shields.io/badge/🐙_GitHub-100000?style=for-the-badge&logo=github&logoColor=white&labelColor=555555"/> </a> <a href="https://linkedin.com/in/seu-linkedin"> <img src="https://img.shields.io/badge/💼_LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&labelColor=555555"/> </a>
<div align="center">
🎯 Objetivo do Projeto
Criar uma solução robusta e escalável para gestão de transporte universitário, aplicando conceitos avançados de engenharia de software.

📚 Contexto Acadêmico
Este projeto representa a consolidação do conhecimento adquirido durante a graduação, integrando teoria e prática em um sistema real.

</div>
<div align="center"> <p> <strong>🔍 Encontrou algum problema ou tem sugestões?</strong><br> <a href="https://github.com/Denvx/aerj-sistema/issues/new/choose"> <img src="https://img.shields.io/badge/📋_Abrir_Issue-FF6B6B?style=for-the-badge&logo=gitbook&logoColor=white"/> </a> </p> </div>
<div align="center"> <hr style="border: 1px solid #444; width: 50%;"> <h3>🏆 AERJ Sistema © 2024</h3> <p><em>Desenvolvido com ❤️ por Denver</em></p> <p style="font-size: 0.9em; color: #888;"> <strong>Licença:</strong> Uso acadêmico | <strong>Versão:</strong> Beta 1.0 | <strong>Última atualização:</strong> Janeiro 2024 </p> </div></div> 
