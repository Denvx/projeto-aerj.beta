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

| Módulo | Recursos |
|--------|----------|
| **Usuários** | Gestão de estudantes e administradores |
| **Financeiro** | Pagamentos, mensalidades, pendências |
| **Operacional** | Viagens, rotas, veículos, motoristas |
| **Comunicação** | Sistema de avisos |
| **Segurança** | Autenticação JWT e logs de auditoria |

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
| Característica | Descrição |
|----------------|-----------|
| Acesso ao sistema | Não possui |
| Cadastro | Feito pelo administrador |
| Comunicação | WhatsApp |
| Função | Conduzir conforme rota |

---

## 🏗 Arquitetura

┌─────────────────────────────────────┐
│ FRONT-END (Futuro) │
│ React / Angular / Vue.js │
└───────────────────┬─────────────────┘
│ REST API
┌───────────────────┴─────────────────┐
│ BACK-END │
│ Java 17+ • Spring Boot 3.x │
│ • Controllers │
│ • Services │
│ • Repositories │
│ • DTOs │
└───────────────────┬─────────────────┘
│ JDBC
┌───────────────────┴─────────────────┐
│ BANCO DE DADOS │
│ MySQL / MariaDB (InnoDB) │
└─────────────────────────────────────┘


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
| Aspecto | Padrão |
|---------|--------|
| Nomenclatura | CamelCase |
| Engine | InnoDB |
| Validação | ENUM |
| Indexação | Manual + automática |
| Documentação | Comentários em SQL |

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

## 🎯 Decisões de Design

### 1. Tabela Pessoas como Base
- Evita duplicações
- Facilita manutenção
- Suporte a múltiplos papéis

**Diagrama:**

Pessoas 1──1 Usuarios
│
├──1 Alunos
├──1 Motoristas
└──1 Administradores


### 2. Login e Segurança
- Login permitido: Aluno e Administrador
- Motoristas não possuem acesso
- Autenticação JWT
- Senhas com BCrypt

### 3. Relacionamentos Principais
- Alunos ⇄ Viagens → N:N
- Viagens → Motorista (N:1)
- Veículos → Viagens (1:N)

### 4. Exclusão Lógica
```sql
ativo BOOLEAN DEFAULT TRUE

Mantém histórico sem perda de dados

5. Performance e Índices
idx_identificacao

idx_matricula

idx_dataViagem

idx_ativo

📝 Comentários do Código
PessoaModel

Tabela base de todos os tipos de usuários do sistema.

UsuarioModel

Senha sempre armazenada com BCrypt.

AlunoModel

Extensão da tabela Pessoas com dados acadêmicos.

ViagemModel

Representa uma viagem real do transporte escolar.

AlunosViagens

Tabela N:N contendo presença e observações.

▶️ Como Usar o Projeto
1. Clonar o Repositório

git clone https://github.com/seu-usuario/aerj-sistema.git
cd aerj-sistema

