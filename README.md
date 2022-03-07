# Bachelorproef - Backend

Gevolgde tutorial: [Getting Started - Spring IO](https://spring.io/guides/gs/accessing-data-mysql/)

[CRUD Spring Boot](https://www.geeksforgeeks.org/spring-boot-crud-operations/)
## Services
1. Authenticatie
2. User management
3. Masterproeven en voorkeuren
4. Communicatie met de gebruikers

## MySQL - *JPA*
Gegevens voor de lokale DB:  
* DB: `masterproef_project`  
* User: `mp_backend`  
* WW: `backend`

## Authenticatie
Aparte package

### Login
| VarType | VarName  |
|---------|----------|
| String  | Email    |
| String  | Password |

### Register
Optie geven om in te schrijven als Student, Promotor/Begeleider/Masterproefcoordinator of Bedrijf

* Student

| VarType | VarName        |
|---------|----------------|
| String  | Email          |
| String  | Name           |
| String  | Surname        |
| String  | Tel            |
| String  | Adress         |
| String  | Field_of_study |
| String  | Campus         |

* Student

| VarType | VarName        |
|---------|----------------|
| String  | Email          |
| String  | Name           |
| String  | Surname        |
| String  | Tel            |
| String  | Adres          |
| String  | Field_of_study |
| String  | Campus         |
| Boolean | Coordinator    |


* Bedrijf

| VarType | VarName         |
|---------|-----------------|
| String  | Email           |
| String  | Company name    |
| String  | Name Contact    |
| String  | Surname Contact |
| String  | Tel             | 
