AERJ – Sistema de Gestão de Transporte Escolar
Versão Beta – Fase 1 (Back-end + Banco de Dados)
Sumário

Sobre o Projeto

Objetivo Geral

Como o Sistema Vai Funcionar no Final

Fluxo dos Usuários

Arquitetura Geral

Arquitetura do Banco de Dados

Decisões de Design Importantes

Tabela Pessoas como Base

Login, Senhas e Segurança

Real Time: Como Vai Funcionar

Relacionamentos Principais

Exclusão Lógica

Performance e Índices

Comentários Importantes do Código

Como Usar o Projeto

Requisitos

Autor

Sobre o Projeto

Este é um sistema completo de gerenciamento para transporte escolar universitário da AERJ.

A plataforma controla:

estudantes

administradores

pagamentos

mensalidades

viagens

rotas

avisos

logs de auditoria

segurança e autenticação

O motorista não utiliza o sistema. Ele é cadastrado por um administrador e apenas recebe a rota/resumo da viagem via WhatsApp.

O projeto está sendo desenvolvido em múltiplas fases.
Este README documenta a primeira fase — Banco, API e Regras de Negócio.

Objetivo Geral

Construir um sistema seguro, organizado e escalável para gerenciar todo o fluxo logístico e financeiro do transporte universitário da AERJ, reduzindo erros manuais, organizando dados e preparando terreno para funcionalidades avançadas no TCC.

Como o Sistema Vai Funcionar no Final
Versão Final do Sistema (Visão Macro)

✔ Portal do aluno
✔ Portal do administrador
✔ Controle financeiro completo
✔ Geração automática de mensalidades
✔ Emissão de recibos
✔ Viagens geradas automaticamente com base na rota
✔ Controle de presenças das viagens
✔ Painel em tempo real
✔ Painel de avisos
✔ Sistema completo de logs
✔ Integração com WhatsApp para envio de rotas ao motorista
✔ Segurança avançada, auditoria e exclusões lógicas

A Fase 1 (este projeto) está preparando toda a base estrutural e funcional para isso.

Fluxo dos Usuários
Alunos

fazem cadastro (ou são cadastrados por um ADM)

realizam login

visualizam suas viagens

visualizam mensalidades e pagamentos

recebem avisos

recuperam senha

consultam histórico

Administradores

cadastram alunos

cadastram motoristas

cadastram veículos

geram viagens

enviam rotas para o motorista (via WhatsApp)

acompanham financeiro

veem logs

gerenciam avisos

Motoristas

não usam o sistema

não fazem login

são cadastrados por um ADM

recebem instruções e rota pelo WhatsApp

apenas dirigem a rota informada

Arquitetura Geral
Back-end

Java + Spring Boot

Padrão MVC

Camadas separadas (Controller, Service, Repository)

DTOs para entrada e saída

Entidades limpas e coesas

Banco de Dados

MySQL / MariaDB

InnoDB

100% relacional

integridade referencial com Foreign Keys

exclusão lógica em entidades principais

Real Time

WebSockets ou long-polling no painel do ADM

Sincronização instantânea de viagens, presenças, avisos e alertas

Arquitetura do Banco de Dados
Padrão adotado

CamelCase em tabelas e colunas

Engine InnoDB

Índices manuais + automáticos

Comentários explicando campos sensíveis

Uso de ENUM para evitar valores inválidos

Organização das tabelas
Pessoas (tabela base)
│
├── Alunos
├── Motoristas
├── Administradores
└── Usuarios
└── Enderecos

Financeiro
├── Mensalidades
└── Pagamentos

Operacional
├── Rotas
├── Veiculos
├── Viagens
└── AlunosViagens (N:N)

Auditoria
├── Logs
└── Avisos

Decisões de Design Importantes

Aqui estão as decisões mais relevantes que definem a arquitetura do sistema.

Tabela Pessoas como Base

Uma das decisões mais importantes.

Por que existe a tabela Pessoas?

Porque evita duplicação.

Sem Pessoas:

Alunos teriam email

Motoristas teriam email

Administradores teriam email
→ e tudo isso seria duplicado.

Com Pessoas:

os dados pessoais ficam centralizados

cada pessoa pode ter vários papéis

facilita manutenção

mantém normalização 3FN

Diagrama do conceito
Pessoas 1───1 Usuarios
│
├──1 Alunos
│
├──1 Motoristas
│
└──1 Administradores

Login, Senhas e Segurança

O login só funciona para:

alunos

administradores

Motoristas não fazem login.

Senha

Armazenada sempre hash (ex: BCrypt).

Campo:

senhaHash VARCHAR(255) COMMENT 'Senha criptografada'

Recuperação de senha

Fluxo:

aluno/adm informa email

sistema gera token temporário

envia link por email

usuário redefine senha

Real Time: Como Vai Funcionar

O painel do administrador receberá notificações instantâneas:

alunos presentes ou ausentes

status das viagens

alterações de rota

avisos importantes

logs críticos

Tecnologias possíveis:

WebSockets

SSE (Server-Sent Events)

Long-polling fallback

Rotas do motorista não são em tempo real — ele recebe via WhatsApp.

Relacionamentos Principais
Alunos ⟷ Viagens (N:N)

Motivo:

um aluno participa de várias viagens

uma viagem inclui vários alunos

Viagens x Motorista

1 motorista por viagem

motorista não acessa sistema

apenas recebe a rota gerada pelo ADM

Veículos x Viagens

cada viagem usa 1 veículo

mas o veículo pode participar de várias viagens

Exclusão Lógica

Implementada nas entidades principais:

Pessoas

Usuarios

Alunos

Motoristas

Veiculos

Campo:

ativo BOOLEAN DEFAULT TRUE


Por que não excluir fisicamente?

mantém histórico

evita quebrar integrações

atende requisitos legais

permite auditoria

permite reativar posteriormente

Performance e Índices

Exemplos:

INDEX idx_identificacao (identificacao)
INDEX idx_matricula (matricula)
INDEX idx_dataViagem (dataViagem)


Motivo:

consultas mais rápidas

filtros mais leves

melhor performance com muitos dados

Comentários Importantes do Código

Agora os comentários que você pediu, explicando os pontos críticos das entidades.

1. PessoaModel
   // Tabela base de todos os tipos de usuários do sistema.
   // Racional: centralizar dados pessoais (nome, CPF, email).
   @Entity
   @Table(name = "pessoas")
   public class PessoaModel {

// CPF sem pontuação, único no banco.
// Evita duplicidades como dois cadastros da mesma pessoa.
@Column(unique = true, length = 11)
private String identificacao;

// Exclusão lógica. Nunca removemos pessoa definitivamente.
private boolean ativo = true;

2. UsuarioModel
   // Representa a credencial de login.
   // Associada diretamente a uma Pessoa.
   @Entity
   @Table(name = "usuario")
   public class UsuarioModel {

// Senha nunca é armazenada em texto puro.
// Sempre vem com BCrypt no campo senhaHash.
private String senhaHash;

// Papel do usuário: Aluno ou Administrador.
// Motorista não possui login.
private String role;

3. AlunoModel
   // Extensão da Pessoa contendo dados específicos de aluno.
   @Entity
   @Table(name = "aluno")
   public class AlunoModel {

// Relacionamento 1:1 com Pessoa.
// O aluno herda nome, CPF, email, etc de Pessoa.
@OneToOne
@JoinColumn(name = "pessoaId")
private PessoaModel pessoa;

4. ViagemModel
   // Representa uma viagem real.
   // Cada viagem tem um motorista, mesmo que ele não use o app.
   @Entity
   @Table(name = "viagem")
   public class ViagemModel {

// FK para Motorista.
// O motorista é cadastrado por um ADM e recebe rota via WhatsApp.
@ManyToOne
@JoinColumn(name = "motoristaId")
private MotoristaModel motorista;

5. AlunosViagens
   // Tabela de junção para relação muitos-para-muitos.
   // Guarda presença, status e descrições da participação do aluno.
   @Entity
   @Table(name = "alunos_viagens")
   public class AlunosViagens {

Como Usar o Projeto

Importar no IntelliJ

Configurar application.properties

Rodar o projeto

Banco será criado automaticamente

Consumir via Postman

Requisitos

Java 17+

Spring Boot

MySQL 5.7+ ou MariaDB 10.2+

JPA / Hibernate

Maven

Autor

Projeto desenvolvido por Denver como parte da evolução acadêmica e desenvolvimento do TCC.