# Pokémon Project 🐱‍👤

Hey there! 👋  
This is a simple Pokémon tracking API built with **Spring Boot**. Think of it like a mini Pokédex backend — it lets you add, view, and manage Pokémon data using REST APIs. I created this as a hands-on project to learn and demonstrate Spring Boot, JPA, and MySQL integration.

---

## 🚀 What’s inside?

- Java 17 + Spring Boot 3.5
- REST APIs with Spring Web
- Database layer using Spring Data JPA
- MySQL integration
- Maven for build and dependency management

---

## 📦 Dependencies (What this project uses under the hood)

Here’s a quick rundown of the main dependencies and what they’re doing:

- **spring-boot-starter-web**  
  Used to build the REST APIs. It brings in Spring MVC, Jackson (for JSON), and more.

- **spring-boot-starter-data-jpa**  
  Handles all the database interaction. It abstracts out a lot of boilerplate CRUD code using JPA repositories.

- **mysql-connector-j**  
  MySQL JDBC driver – lets the Spring app talk to the MySQL database.

- **spring-boot-devtools**  
  For automatic restarts and live reload during development – makes the dev experience smoother.

- **spring-boot-starter-test**  
  Includes testing tools like JUnit, Mockito, and Spring Test – useful when you start writing test cases.

- **jackson-databind**  
  Handles converting Java objects to JSON and vice versa. It's used internally by Spring Boot when returning JSON responses.

- **json-path (for tests)**  
  Helps in parsing and asserting values from JSON during test cases.

---
**clone this repo**
git clone https://github.com/your-username/PokemonProject.git
cd PokemonProject

--------
**Configure DB connection**
Properties
****spring.datasource.url=jdbc:mysql://localhost:3306/pokemon_db**
**spring.datasource.username=root**
**spring.datasource.password=yourpassword**
**spring.jpa.hibernate.ddl-auto=update**
-----------

Let me know if you'd like this saved as a downloadable `README.md` file or need an example API request section added too.

