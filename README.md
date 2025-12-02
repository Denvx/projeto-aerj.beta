<h1 align="center">🚍 AERJ – Sistema de Gestão de Transporte Escolar</h1> <p align="center"> <img src="https://img.shields.io/badge/Status-Beta%20v1.0-yellow?style=for-the-badge"/> <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java"/> <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot"/> <img src="https://img.shields.io/badge/MySQL-5.7%2B-blue?style=for-the-badge&logo=mysql"/> </p> <p align="center"><strong>Versão Beta – Fase 1</strong> | Back-end + Banco de Dados</p>
📌 Sumário

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

📘 Sobre o Projeto

Sistema completo de gerenciamento para o transporte escolar universitário da AERJ, com foco em controle operacional, financeiro e administrativo.

⭐ Funcionalidades Principais
Módulo	Recursos
Usuários	Gestão de estudantes e administradores
Financeiro	Pagamentos, mensalidades, pendências
Operacional	Viagens, rotas, veículos, motoristas
Comunicação	Sistema de avisos
Segurança	Autenticação JWT e logs de auditoria

⚠️ Motoristas não acessam o sistema. São cadastrados por administradores e recebem rotas via WhatsApp.

🧭 Objetivo Geral

Construir um sistema seguro, escalável e organizado para gestão completa do transporte universitário.

Benefícios:

✔ Centralização completa
✔ Redução de erros manuais
✔ Automação de processos
✔ Base sólida para futuras funcionalidades do TCC

🚀 Visão Final do Sistema (Roadmap)
👨‍🎓 Portal do Aluno

Visualização de viagens

Histórico de pagamentos

Consulta de mensalidades

Recebimento de avisos

Recuperação de senha

🛠 Portal do Administrador

Gestão completa de usuários

Controle financeiro

Geração de mensalidades

Painel de controle

Logs e auditoria

🧪 Recursos Avançados (Futuros)

Geração automática de viagens

Controle de presença

Envio automático das rotas

Exclusões lógicas e histórico completo

🧑‍🤝‍🧑 Fluxo dos Usuários
🧑‍🎓 Alunos — Ações Disponíveis

Cadastro

Login seguro

Visualização de viagens

Consulta de pagamentos

Avisos

Histórico

🧑‍💼 Administradores — Responsabilidades

Cadastrar alunos

Cadastrar motoristas

Gerenciar veículos

Gerenciar rotas e viagens

Controlar finanças

Enviar avisos

Auditoria e logs

🚐 Motoristas – Perfil Simplificado
Característica	Descrição
Acesso ao sistema	❌ Não possui
Cadastro	Feito por administrador
Comunicação	WhatsApp
Função	Conduzir conforme rota definida
🏗 Arquitetura
┌─────────────────────────────────────┐
│             FRONT-END (Futuro)      │
│      React / Angular / Vue.js       │
└───────────────────┬─────────────────┘
                    │ REST API
┌───────────────────┴─────────────────┐
│               BACK-END              │
│     Java 17+ • Spring Boot 3.x      │
│  • Controllers                       │
│  • Services                          │
│  • Repositories                      │
│  • DTOs                              │
└───────────────────┬─────────────────┘
                    │ JDBC
┌───────────────────┴─────────────────┐
│            BANCO DE DADOS           │
│      MySQL / MariaDB (InnoDB)       │
└─────────────────────────────────────┘

🧩 Padrões Adotados

MVC

DTO

Camada Service

Repository Pattern

Value Objects (CPF, Email etc.)

⚡ Real-Time (planejado)

WebSockets

SSE

Logs em tempo real

Atualização de viagens

🗄 Banco de Dados
📌 Convenções
Aspecto	Padrão
Nomenclatura	CamelCase
Engine	InnoDB
Validação	ENUM
Indexação	Manual + automática
Documentação	Comentários em SQL
🧱 Estrutura (Resumo)
Pessoas

Usuários

Alunos

Motoristas

Administradores

Financeiro

Mensalidades

Pagamentos

Operacional

Rotas

Veículos

Viagens

AlunosViagens (N:N)

Auditoria

Logs

Avisos

🎯 Decisões de Design (Essenciais)
🧩 1. Tabela Pessoas como Base

Evita duplicações

Facilita manutenção

Suporte a múltiplos papéis

Diagrama
Pessoas 1──1 Usuarios
   │
   ├──1 Alunos
   ├──1 Motoristas
   └──1 Administradores

🔐 2. Login e Segurança

Login permitido: Aluno e Administrador

Motoristas não acessam

Autenticação via JWT

Senhas com BCrypt

🧮 3. Relacionamentos Principais

Alunos ⇄ Viagens → N:N

Viagens → Motorista (N:1)

Veículos → Viagens (1:N)

🗑 4. Exclusão Lógica

ativo BOOLEAN DEFAULT TRUE

Mantém histórico

Evita perda de dados

🚀 5. Performance e Índices

idx_identificacao

idx_matricula

idx_dataViagem

idx_ativo

📝 Comentários do Código
📌 PessoaModel
/**
 * Tabela base de todos os tipos de usuários do sistema.
 */

📌 UsuarioModel
/**
 * Senha sempre armazenada com BCrypt.
 */

📌 AlunoModel
/**
 * Extensão da tabela Pessoas com dados acadêmicos.
 */

📌 ViagemModel
/**
 * Representa uma viagem real do transporte escolar.
 */

📌 AlunosViagens
/**
 * Tabela N:N contendo presença e observações.
 */

▶️ Como Usar o Projeto
1️⃣ Clonar o Repositório
git clone https://github.com/seu-usuario/aerj-sistema.git
cd aerj-sistema

2️⃣ Configurar o Banco

Ajuste as credenciais em:

src/main/resources/application.properties

3️⃣ Importar no IntelliJ ou Eclipse
4️⃣ Executar
./mvnw spring-boot:run

5️⃣ Testar API (Postman)

Alguns endpoints:

GET  /api/alunos
POST /api/viagens
PUT  /api/mensalidades/{id}


Se quiser, eu gero toda a coleção do Postman para importar.

🧰 Requisitos
<p> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="50"/> </p>
Tecnologia	Versão mínima
Java	17+
Spring Boot	3.x
MySQL	5.7+
MariaDB	10.2+
Maven	3.8+
👤 Autor
<p align="center"><strong>Denver</strong></p> <p align="center">Projeto desenvolvido como parte da evolução acadêmica e do TCC.</p> <p align="center"> <a href="mailto:denver.o.dev@gmail.com"> <img src="https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white"/> </a> <a href="https://github.com/Denvx"> <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/> </a> </p> <p align="center">Encontrou algum problema? Abra uma <a href="https://github.com/Denvx/aerj-sistema/issues">issue</a></p> <p align="center"><strong>AERJ Sistema</strong> © 2024 | Desenvolvido por Denver</p>
