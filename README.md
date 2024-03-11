
# User Manager Application

This application is a simple system to manage users of some arbitrary information system. It implements REST architecture and all of its services are exposed as REST APIs.

Technologies used are: JPA/Hibernate, Liquibase and MySQL


## Database schema

![dbs-schema](https://github.com/VladO2567/UserManagement_JR/blob/master/src/main/resources/media/usermanagement_schema.png)
## Run Locally

Clone the project

```bash
  git clone https://github.com/VladO2567/UserManagement_JR.git
```

It's recommended to use IntelliJ IDEA to run this project.

Make sure all dependencies in pom.xml file are ready.

Run maven clean and compile Lifecycle methods.

![mavencleanandcompile](https://github.com/VladO2567/UserManagement_JR/blob/master/src/main/resources/media/mavencleanandcmpl.png)

Set username and password for your MySQL server in application.yml and liquibase.yml files.

![usandpassappyml](https://github.com/VladO2567/UserManagement_JR/blob/master/src/main/resources/media/usandpassappyml.png)

![usandpassliquiyml](https://github.com/VladO2567/UserManagement_JR/blob/master/src/main/resources/media/usandpassliquiyml.png)

By running the application empty usermanagement database schema will be created if it already doesn't exist.

![datasourceurl](https://github.com/VladO2567/UserManagement_JR/blob/master/src/main/resources/media/datasourceurl.png)

If your database or MySQL server are set up differently adjust the datasource url.

Liquibase will then generate and insert tables into it. Data for the tables will be inserted from sql files in src/main/resources/db/changelog/seeds folder.

Everything is ready to run the application :D


## Usage/Examples

Postman collection of requests for all services is exported to src/main/resources/postman. After importing this collection to Postman all requests with their body and path variables should be ready. 

Postman Collection

The Postman collection includes the following requests:

User

    Create User: Create a new user with the specified details.
    Get All Users: Retrieve a list of all users.
    Get All Users by Date: Retrieve users created on a specific date.
    Get All Users by Company: Retrieve users belonging to a specific company.
    Get All Deactivated Users: Retrieve a list of all deactivated users.
    Soft Delete User: Soft delete a user by marking them as inactive.
    Delete User: Permanently delete a user.
    Update User: Update the details of an existing user.

City

    Get All Cities: Retrieve a list of all cities.

Country

    Get All Countries: Retrieve a list of all countries.

Company

    Get All Companies: Retrieve a list of all companies.

API Base URL

All API requests are based on the following base URL:

```bash
http://localhost:8070/api/
```

For Update User service body can contain complete or partial information about the user. Examples:

```json
{
    "username": "someUsername",
    "password": "SamplePass1!",
    "email": "dknezevic@gmail.com",
    "firstName": "firstName",
    "lastName": "lastName",
    "dob": "2004-03-19",
    "gender": 0,
    "createdAt": "2023-10-11",
    "isActive": true,
    "cityProxy": {
        "id": 5
    },
    "countryProxy": {
        "id": 5
    },
    "companyProxy": {
        "id": 5
    }
}
```
or

```json
{
  "lastName": "lastName",
    "dob": "2004-03-19"
}
```

For Create User service complete information about the user needs to be provided.
## Author

- Vlado Doderović [@VladO2567](https://github.com/VladO2567)
