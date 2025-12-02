<h1 align="center">🚍 AERJ – Sistema de Gestão de Transporte Escolar</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Status-Beta%20v1.0-yellow?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot"/>
  <img src="https://img.shields.io/badge/MySQL-5.7%2B-blue?style=for-the-badge&logo=mysql"/>
</p>

<p align="center"><strong>Versão Beta – Fase 1</strong> | Back-end + Banco de Dados</p>

---

# 📌 **Sumário**
- [Sobre o Projeto](#sobre-o-projeto)
- [Objetivo Geral](#objetivo-geral)
- [Visão Final do Sistema](#visão-final-do-sistema)
- [Fluxo dos Usuários](#fluxo-dos-usuários)
- [Arquitetura](#arquitetura)
- [Banco de Dados](#banco-de-dados)
- [Decisões de Design](#decisões-de-design)
- [Comentários do Código](#comentários-do-código)
- [Como Usar](#como-usar)
- [Requisitos](#requisitos)
- [Autor](#autor)

---

# 📘 **Sobre o Projeto**

Sistema completo de gerenciamento para o transporte escolar universitário da **AERJ**.

## ⭐ Funcionalidades Principais

| Módulo | Recursos |
|--------|----------|
| **Usuários** | Gestão de estudantes e administradores |
| **Financeiro** | Pagamentos, mensalidades, pendências |
| **Operacional** | Viagens, rotas, veículos, motoristas |
| **Comunicação** | Sistema de avisos |
| **Segurança** | Autenticação e logs de auditoria |

> ⚠️ **Nota:** Motoristas **não utilizam o sistema** — são cadastrados por um administrador e recebem rotas via **WhatsApp**.

---

# 🧭 **Objetivo Geral**

Construir um sistema **seguro**, **escalável** e **organizado** para gestão completa do transporte universitário.

### Benefícios:
✔ Redução de erros manuais  
✔ Centralização total das informações  
✔ Base sólida para futuras funcionalidades do TCC

---

# 🚀 **Visão Final do Sistema (Roadmap)**

## 👨‍🎓 Portal do Aluno
- Visualização de viagens  
- Consulta de mensalidades  
- Histórico de pagamentos  
- Recebimento de avisos  
- Recuperação de senha  

## 🛠 Portal do Administrador
- Gestão completa de usuários  
- Controle financeiro  
- Geração automática de mensalidades  
- Logs e auditoria  
- Painel em tempo real  

## 🧪 Recursos Avançados
- Geração automática de viagens  
- Controle de presença  
- Envio de rotas pelo WhatsApp  
- Exclusões lógicas e histórico completo  

---

# 🧑‍🤝‍🧑 **Fluxo dos Usuários**

## 🧑‍🎓 Alunos — Ações Disponíveis
- Cadastro  
- Login seguro  
- Visualização de viagens  
- Consulta de pagamentos  
- Recebimento de avisos  
- Histórico completo  

---

## 🧑‍💼 Administradores — Responsabilidades
- Cadastrar alunos/motoristas/veículos  
- Controlar finanças  
- Gerar viagens  
- Enviar rotas ao motorista  
- Administrar avisos  
- Acompanhar logs  

---

## 🚐 Motoristas – Perfil Simplificado

| Característica | Descrição |
|----------------|-----------|
| **Acesso ao sistema** | ❌ Não possui |
| **Cadastro** | Feito por ADM |
| **Comunicação** | WhatsApp |
| **Função** | Dirigir conforme rota |

---

# 🏗 **Arquitetura**

┌─────────────────────────────────────┐
│ FRONT-END (Futuro) │
│ React / Angular / Vue.js │
└──────────────┬──────────────────────┘
│ REST API
┌──────────────┴──────────────────────┐
│ BACK-END │
│ Java 17+ | Spring Boot 3.x │
│ • Controllers │
│ • Services │
│ • Repositories │
│ • DTOs │
└──────────────┬──────────────────────┘
│ JDBC
┌──────────────┴──────────────────────┐
│ BANCO DE DADOS │
│ MySQL / MariaDB (InnoDB) │
└─────────────────────────────────────┘

markdown
Copiar código

### 🧩 Padrões Adotados
- MVC  
- DTO  
- Repository Pattern  
- Service Layer  

### ⚡ Real-Time (planejado)
- WebSockets  
- SSE  
- Long Polling  
- Logs, avisos, atualizações de viagens  

---

# 🗄 **Banco de Dados**

## 📌 Convenções

| Aspecto | Padrão |
|--------|--------|
| Nomenclatura | CamelCase |
| Engine | InnoDB |
| Validação | ENUM |
| Indexação | Manual + automática |
| Documentação | Comentários SQL |

---

## 🧱 Estrutura (Resumo)

### **Pessoas**
- Usuários (login)
- Alunos
- Motoristas
- Administradores

### **Financeiro**
- Mensalidades  
- Pagamentos  

### **Operacional**
- Rotas  
- Veículos  
- Viagens  
- AlunosViagens (N:N)  

### **Auditoria**
- Logs  
- Avisos  

---

# 🎯 **Decisões de Design (Essenciais)**

## 🧩 1. Tabela Pessoas como Base
- Evita duplicações  
- Centraliza dados  
- Facilita manutenção  
- Suporte a múltiplos papéis  

### Diagrama
Pessoas 1───1 Usuarios
│
├──1 Alunos
├──1 Motoristas
└──1 Administradores

yaml
Copiar código

---

## 🔐 2. Login e Segurança
- Login permitido: **Aluno, Administrador**  
- Motorista não acessa  
- Senhas com **BCrypt**  
- Senha nunca é armazenada em texto puro  

---

## 🧮 3. Relacionamentos
- Alunos ⇄ Viagens → Muitos-para-muitos  
- Viagens → Motorista (N:1)  
- Veículos → Viagens (1:N)  

---

## 🗑 4. Exclusão Lógica
- `ativo BOOLEAN DEFAULT TRUE`
- Preserva histórico e auditoria  
- Evita perdas irreversíveis  

---

## 🚀 5. Performance e Índices
Ex.:  
```sql
INDEX idx_identificacao (identificacao)
INDEX idx_matricula (matricula)
INDEX idx_dataViagem (dataViagem)
INDEX idx_ativo (ativo)
📝 Comentários do Código
(Seção mantida exatamente como enviada — formatada de forma premium)

📌 PessoaModel
java
Copiar código
/**
 * Tabela base de todos os tipos de usuários do sistema.
 */
📌 UsuarioModel
java
Copiar código
/**
 * Senha sempre vem com BCrypt.
 */
📌 AlunoModel
java
Copiar código
/**
 * Extensão da tabela Pessoas contendo dados acadêmicos.
 */
📌 ViagemModel
java
Copiar código
/**
 * Viagem real do transporte escolar.
 */
📌 AlunosViagens
java
Copiar código
/**
 * Tabela de junção N:N com presença e observações.
 */
▶️ Como Usar o Projeto
1️⃣ Clonar o Repositório
bash
Copiar código
git clone https://github.com/seu-usuario/aerj-sistema.git
cd aerj-sistema
2️⃣ Configurar o Banco
src/main/resources/application.properties

3️⃣ Importar no IntelliJ
4️⃣ Executar
bash
Copiar código
./mvnw spring-boot:run
5️⃣ Testar API (Postman)
bash
Copiar código
GET  /api/alunos
POST /api/viagens
PUT  /api/mensalidades/{id}
🧰 Requisitos
<p> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="50"/> </p>
Tecnologia	Versão Mínima
Java	17+
Spring Boot	3.x
MySQL	5.7+
MariaDB	10.2+
Maven	3.8+

👤 Autor
<p align="center"><strong>Denver</strong></p> <p align="center">Projeto desenvolvido como parte da evolução acadêmica e desenvolvimento do TCC.</p> <p align="center"> <a href="mailto:denver.o.dev@gmail.com"> <img src="https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white"/> </a> <a href="https://github.com/Denvx"> <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"/> </a> </p> <p align="center"> Encontrou algum problema? Abra uma <a href="https://github.com/Denvx/aerj-sistema/issues">issue</a> </p> <p align="center"><strong>AERJ Sistema</strong> © 2024 | Desenvolvido por Denver</p> ```
