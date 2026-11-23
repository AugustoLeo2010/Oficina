# Oficina Manager

Sistema web de gerenciamento de uma oficina mecânica, desenvolvido para facilitar o controle de clientes, funcionários, veículos, serviços e agendamentos.

## Sobre o projeto

O projeto busca digitalizar o gerenciamento de uma oficina mecânica, substituindo controles manuais por uma aplicação integrada a um banco de dados.

**Público usuário:** funcionários e responsáveis pelo gerenciamento da oficina.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de clientes.
- Cadastro, consulta, atualização e exclusão de funcionários.
- Cadastro, consulta, atualização e exclusão de veículos.
- Cadastro, consulta, atualização e exclusão de serviços.
- Cadastro, consulta, atualização e exclusão de agendamentos.
- Interface web integrada à API REST.
- Armazenamento dos dados no MySQL.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- MySQL
- HTML5
- CSS3
- JavaScript
- Maven
- Postman
- Git e GitHub

## Estrutura do projeto

```text
Oficina/
├── src/
│   └── main/
│       ├── java/_DT/Oficina/
│       │   ├── Controller/
│       │   ├── Entities/
│       │   ├── Exception/
│       │   ├── Repository/
│       │   ├── Service/
│       │   └── OficinaApplication.java
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── styles.css
│           │   └── scripts.js
│           └── application.properties
├── pom.xml
└── README.md
```

## Pré-requisitos

- JDK compatível com a versão Java configurada no projeto.
- MySQL Server.
- MySQL Workbench (opcional).
- IntelliJ IDEA ou outra IDE compatível.

## Configuração do banco de dados

1. Instale e inicie o MySQL Server.
2. Crie o banco de dados:

```sql
CREATE DATABASE oficina;
```

3. Configure as variáveis de ambiente:

```text
DB_URL=jdbc:mysql://localhost:3306/oficina
DB_USERNAME=root
DB_PASSWORD=sua_senha
```

O Hibernate está configurado com `ddl-auto=update`, permitindo atualizar a estrutura das tabelas conforme as entidades da aplicação.

## Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto na IDE.
3. Configure as variáveis de ambiente do banco de dados.
4. Aguarde o Maven baixar as dependências.
5. Execute a classe `OficinaApplication`.
6. Acesse a aplicação:

```text
http://localhost:8080
```

## Endpoints da API

Endereço base:

```text
http://localhost:8080/api
```

| Entidade | Endpoint |
|---|---|
| Clientes | `/clients` |
| Funcionários | `/employees` |
| Veículos | `/vehicles` |
| Serviços | `/services` |
| Agendamentos | `/appointments` |

Todas as entidades possuem as seguintes operações:

| Método HTTP | Rota | Operação |
|---|---|---|
| GET | `/recurso` | Listar registros |
| GET | `/recurso/{id}` | Consultar por ID |
| POST | `/recurso` | Cadastrar |
| PUT | `/recurso/{id}` | Atualizar |
| DELETE | `/recurso/{id}` | Excluir |

As requisições de cadastro e atualização utilizam JSON.

## Testes

Os testes das operações CRUD foram realizados utilizando o Postman, verificando:

- Cadastro de registros.
- Listagem dos registros.
- Consulta por identificador.
- Atualização de informações.
- Exclusão de registros.

## Banco de dados

O projeto utiliza MySQL para persistência dos dados, com entidades gerenciadas pelo Spring Data JPA e Hibernate.

## Créditos

Projeto acadêmico desenvolvido como atividade de integração entre API REST e aplicação Web.
