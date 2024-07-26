# Muralis - Desafio Spring Boot

## Descrição

Este projeto foi desenvolvido como parte do processo seletivo para uma vaga de estágio. O objetivo é demonstrar habilidades técnicas básicas em back-end utilizando Java e o framework Spring Boot. O projeto permite o cadastramento, consulta, exclusão, listagem, pesquisa e alteração de clientes, seguindo uma modelagem específica.

## Modelagem

O sistema é baseado nas seguintes entidades:

### Cliente
- `id` (int): Identificador único do cliente.
- `nome` (String): Nome do cliente.
- `dataCadastro` (String): Data em que o cliente foi cadastrado.

### Contato
- `id` (int): Identificador único do contato.
- `tipo` (String): Tipo de contato (ex.: e-mail, telefone).
- `texto` (String): Informação de contato.

### Relação
- A relação entre Cliente e Contato é de composição, onde um Cliente pode ter vários Contatos.

![Diagrama de classes, representando as classes e sua relação](src/main/resources/assets/Modelagem-desafio-spring-boot.png)


## Funcionalidades

O projeto implementa as seguintes funcionalidades:

- **Cadastro de Clientes**: Permite adicionar novos clientes ao sistema.
- **Consulta de Clientes**: Permite consultar informações de um cliente específico.
- **Exclusão de Clientes**: Permite remover clientes do sistema.
- **Listagem de Clientes**: Permite listar todos os clientes cadastrados.
- **Pesquisa de Clientes**: Permite pesquisar clientes com base em critérios específicos.
- **Alteração de Clientes**: Permite atualizar as informações de um cliente existente.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **PostgreSQL**: Banco de dados utilizado para persistência de dados.
- **Maven**: Gerenciador de dependências e construção do projeto.
- **Postman**: Ferramenta para teste e documentação de APIs. Utilizada para testar os endpoints da API, garantindo que todas as funcionalidades estejam funcionando conforme o esperado e para gerar documentação interativa.

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/devLuanRodrigues/muralis-desafio-spring-boot

2. **Navegue até o repositório do projeto**
   ```bash
   cd muralis-desafio-spring-boot

3. **Compile e execute o projeto com Maven**
   ```bash
   mvn spring-boot:run

4. **Acesse a API**
   A API estará disponível em http://localhost:8080

## Endpoints
**Abaixo estão os principais endpoints da API**

* **POST** /clientes: Cadastrar um novo cliente

![Requisição POST - Cadastro de clientes](src/main/resources/assets/Post1.png)

* **GET** /clientes/{id}: Consultar um cliente por ID

![Requisição GET - Busca de cliente através do ID](src/main/resources/assets/Get2.png)

* **GET** /clientes: Listar todos os clientes

![Requisição GET - Listagem de todos os clientes cadastrados](src/main/resources/assets/Get1.png)

* **PUT** /clientes/{id}: Alterar informações um cliente existente por id

![Requisição PUT - Atualização dos dados dos clientes por ID](src/main/resources/assets/Put.png)

* **DELETE** /clientes/{id}: Excluir um cliente por ID

![Requisição DELETE - Requisição para excluir cliente por ID](src/main/resources/assets/Del1.png)

![Requisição GET - Busca com o id 3 já excluído](src/main/resources/assets/Del2.png)
