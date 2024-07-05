# Java-test-task

Test task for junior java developer position. The task is to create a simple REST API with all CRUD operations for a single `Customer` entity.

List of tools used:

- PostgreSQL;
- Java 17 + Spring Boot, also used Lombok, Jackson, and Maven.


## How to start
- Execute SQL script to create tables for a PostgreSQL DB. There is only 1 table that contains all mentioned in the task fields. The script is located in the `src/main/resources/DB` folder;
- Update `application.properties` to match your DB setup;
- Run Java application and test its API with tools like Postman/Insomnia/etc.

## API Documentation

The app contains 5 endpoints for all CRUD operations.

- GET {host}/api/customers - returns all customers with is_active=true.
Does not require any input.\
Example response:\
[\
&emsp;{\
&emsp;&emsp;"id": 6,\
&emsp;&emsp;"fullName": "Super Bober",\
&emsp;&emsp;"email": "superbober@mail.me",\
&emsp;&emsp;"phone": "+12345678548"\
&emsp;}\
]
- GET {host}/api/customers/{id} - returns a single customer by ID.\
`ID` is mandatory and an error will thrown if not provided.\
Example response:\
{\
&emsp;"id": 6,\
&emsp;"fullName": "Super Bober",\
&emsp;"email": "superbober@mail.me",\
&emsp;"phone": "+12345678548"\
}
- POST {host}/api/customers - creates a new customer.\
This call requires a `JSON body` to work. Mandatory request body parameters: `fullName`, `email`. Optional: `phone`.\
Example request:\
{\
&emsp;"fullName": "Mega Bober",\
&emsp;"email": "megabober@mail.me",\
&emsp;"phone": "+12345678548"\
}\
Example response:\
{\
&emsp;"id": 7,\
&emsp;"fullName": "Mega Bober",\
&emsp;"email": "megabober@mail.me",\
&emsp;"phone": "+12345678548"\
}
- PUT {host}/api/customers/{id} - updates a customer.\
This call requires a `JSON body` and `ID` to work. Mandatory request body parameters: `fullName`, `email`. Optional: `phone`.\
Example request:\
{\
&emsp;"fullName": "Mega Bober",\
&emsp;"email": "megabober@mail.me",\
&emsp;"phone": "+12345678548"\
}\
Example response:\
{\
&emsp;"id": 7,\
&emsp;"fullName": "Mega Bober",\
&emsp;"email": "megabober@mail.me",\
&emsp;"phone": "+12345678548"\
}
- DELETE {host}/api/customers/{id} - disables a single customer by ID.\
`ID` is mandatory and an error will thrown if not provided.\
Example response:\
204 No Content

## Project structure
The project has a `controllers` package that contains only one controller available. The `exceptions` package contains 1 custom error and an Exception Handler to deal with this error and validation errors. The `models` package contains only one model for customers with all validation and configurations. The `repositories` package contains repo interface to manage CRUD operations for the model. The `services` package contains service and service implementation that handle the business logic of the project. Also, there is a `Resources` folder with config and DB files.
