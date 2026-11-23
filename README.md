# Oficina Manager — API REST

Sistema de gerenciamento de oficinas mecânicas desenvolvido como projeto acadêmico, com uma API REST integrada a uma aplicação web e banco de dados MySQL.

## Sobre o projeto

O Oficina Manager tem como objetivo facilitar o gerenciamento das atividades de uma oficina mecânica, centralizando informações de clientes, funcionários, veículos, serviços e agendamentos.

O sistema permite cadastrar, consultar, atualizar e excluir registros por meio de uma interface web integrada à API.

## Problema e público-alvo

Oficinas mecânicas podem ter dificuldades para organizar informações de clientes, veículos, serviços e horários de atendimento.

O projeto busca oferecer uma solução simples para centralizar esses dados e facilitar sua administração.

**Público-alvo:** pequenas e médias oficinas mecânicas e seus funcionários responsáveis pelo gerenciamento.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de clientes.
- Gerenciamento de funcionários.
- Gerenciamento de veículos.
- Cadastro e gerenciamento de serviços.
- Controle de agendamentos.
- Integração entre frontend, API REST e banco de dados.
- Persistência dos dados no MySQL.

## Tecnologias utilizadas

**Backend**
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

**Frontend**
- HTML5
- CSS3
- JavaScript
- Fetch API

**Banco de dados e testes**
- MySQL
- MySQL Workbench
- Postman
- Git e GitHub

## Estrutura do projeto

```text
Oficina/
├── src/
│   └── main/
│       ├── java/
│       │   └── _DT/Oficina/
│       │       ├── Controller/
│       │       ├── Entities/
│       │       ├── Repository/
│       │       ├── Service/
│       │       └── Exception/
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── styles.css
│           │   └── scripts.js
│           └── application.properties
├── docs/
│   ├── Oficina API.postman_collection.json
│   └── database.sql
├── pom.xml
└── README.md
```

## Banco de dados

O projeto utiliza o MySQL com um banco de dados chamado `oficina`.

Para criar o banco, execute:

```sql
CREATE DATABASE oficina;
```

Em seguida, configure as credenciais de acesso nas variáveis de ambiente utilizadas pela aplicação.

O arquivo `docs/database.sql` contém a estrutura e os dados exportados do banco de dados.

### Entidades

| Entidade | Descrição |
|---|---|
| Client | Armazena informações dos clientes |
| Employee | Armazena informações dos funcionários |
| Vehicle | Armazena informações dos veículos |
| Services | Armazena os serviços oferecidos |
| Appointment | Armazena os agendamentos |

## Como executar o projeto

### Pré-requisitos

- Java JDK compatível com o projeto.
- MySQL instalado e em execução.
- IntelliJ IDEA ou outra IDE compatível.
- Git (opcional).

### 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto.

### 2. Criar o banco de dados

No MySQL, execute:

```sql
CREATE DATABASE oficina;
```

### 3. Configurar as variáveis de ambiente

Configure as seguintes variáveis no ambiente em que a aplicação será executada:

| Variável | Valor de exemplo |
|---|---|
| DB_URL | jdbc:mysql://localhost:3306/oficina |
| DB_USERNAME | root |
| DB_PASSWORD | Sua senha do MySQL |

A aplicação utiliza essas variáveis para estabelecer a conexão com o banco de dados.

**Importante:** não compartilhe ou envie senhas reais para o GitHub
