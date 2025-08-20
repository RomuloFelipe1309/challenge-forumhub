ForumHub API
📄 Descrição
ForumHub é uma API REST para uma plataforma de fórum de discussão, onde os utilizadores podem publicar tópicos sobre diversos cursos, responder a perguntas e interagir com a comunidade. O projeto foi desenvolvido como parte de um desafio para demonstrar competências em desenvolvimento backend com Java e Spring Boot, focando em boas práticas de programação, segurança e arquitetura de software.

✨ Funcionalidades
Autenticação: Sistema de login seguro com autenticação baseada em tokens JWT.

Gestão de Utilizadores (CRUD): Criação, leitura, atualização e desativação de utilizadores.

Gestão de Tópicos (CRUD): Utilizadores autenticados podem criar, ler, atualizar e apagar os seus próprios tópicos.

Gestão de Respostas (CRUD): Possibilidade de publicar, editar e apagar respostas em tópicos.

Gestão de Cursos (CRUD): Operações para administrar os cursos aos quais os tópicos estão associados.

Validações de Negócio: Regras de negócio personalizadas para garantir a integridade dos dados (ex: não permitir tópicos duplicados).

Documentação da API: Documentação interativa gerada automaticamente com Swagger (OpenAPI).

🛠️ Tecnologias Utilizadas
O projeto foi construído com as seguintes tecnologias e ferramentas:

Linguagem: Java 17

Framework: Spring Boot 3

Segurança: Spring Security 6 (Autenticação e autorização com JWT)

Base de Dados:

MySQL (Produção)

H2 (Testes/Desenvolvimento)

Persistência de Dados: Spring Data JPA / Hibernate

Migrações de Base de Dados: Flyway

Gestão de Dependências: Maven

Documentação: SpringDoc (Swagger/OpenAPI)

Utilitários: Lombok

⚙️ Pré-requisitos
Antes de começar, certifique-se de que tem as seguintes ferramentas instaladas na sua máquina:

JDK 17 ou superior

Maven 3.8 ou superior

MySQL Server 8.0 ou superior

Um cliente de API, como o Postman ou Insomnia.

🚀 Instalação e Execução
Siga os passos abaixo para executar o projeto localmente:

1. Clone o repositório:

git clone https://github.com/RomuloFelipe1309/challenge-forumhub.git
cd challenge-forumhub

2. Configure a Base de Dados MySQL:

Crie uma base de dados no seu servidor MySQL:

CREATE DATABASE forumhub;

Abra o ficheiro src/main/resources/application.properties.

Altere as seguintes propriedades com as suas credenciais do MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=seu_usuario_mysql
spring.datasource.password=sua_senha_mysql

3. Execute a aplicação:

Pode executar a aplicação através da sua IDE (IntelliJ, Eclipse, etc.) ou utilizando o Maven no terminal:

./mvnw spring-boot:run

4. A aplicação estará disponível em http://localhost:8080.

🎮 Utilização da API
A documentação completa e interativa da API está disponível no Swagger UI. Após iniciar a aplicação, aceda a:

Swagger UI: http://localhost:8080/swagger-ui.html

Principais Endpoints
A maioria dos endpoints requer um token de autenticação JWT.

1. Autenticação (/login)

POST /login: Autentica um utilizador e retorna um token JWT.

Corpo da Requisição:

{
    "login": "username",
    "password": "user_password"
}

Resposta de Sucesso:

{
    "token": "seu.jwt.token.aqui"
}

2. Tópicos (/topics)

POST /topics: Cria um novo tópico (requer token).

GET /topics: Lista todos os tópicos ativos (paginado).

GET /topics/{id}: Obtém os detalhes de um tópico específico.

PUT /topics/{id}: Atualiza um tópico.

DELETE /topics/{id}: Apaga (logicamente) um tópico.

Para aceder aos endpoints protegidos, inclua o token JWT no cabeçalho Authorization:

Authorization: Bearer seu.jwt.token.aqui

📁 Estrutura do Projeto
O projeto está organizado da seguinte forma:

src/main/java

controller/: Classes que expõem os endpoints da API REST.

domain/: Contém as entidades (Modelos), DTOs, repositórios e validações de negócio.

infra/: Pacote para classes de infraestrutura, como configuração de segurança e tratamento de erros.

src/main/resources

db/migration/: Scripts de migração da base de dados (Flyway).

application.properties: Ficheiro de configuração da aplicação.

✒️ Autor
Rômulo Felipe

LinkedIn: https://www.linkedin.com/in/romulofelipe1309/

GitHub: https://github.com/romulofelipe1309

📜 Licença
Este projeto está sob a licença MIT. Consulte o ficheiro LICENSE para mais detalhes.
