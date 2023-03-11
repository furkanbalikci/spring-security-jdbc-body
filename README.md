# spring-security-jdbc-body

A base model for spring security login configuration. 
- With this model you can use user datas from database.
- You can use custom login config in SecuriyConfig fill, on this project html used for template.
- After succsess login you catch logged user data.
- On this project postgreSql used for db. You should configure for your db. 
- User datas can be various but username and password must. For example you can add gender or birthday. 



## Run Locally

Clone the project

```bash
  git clone https://github.com/furkanbalikci/spring-security-jdbc-body.git
```

Go to the project directory

```bash
  cd security-test
```

Start the server

```bash
  ./mvnw spring-boot:run
```


## API Reference

#### Get default login page. 

```http
  GET /login
```


## Tech Stack

**Server:** Spring Boot 3.0.4 , Spring Security 6.0.x, Spring Data JPA
**Database:** PostgreSQL 14

