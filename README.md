# Clustered Data Warehouse

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Build and Run the Application](#build-and-run-the-application)
  * [Using Docker Compose](#using-docker-compose)
  * [Using Makefile](#using-makefile)
- [API](#api)
  * [Swagger](#swagger)
  * [PostMan](#postman)


## Overview
This project is a clustered data warehouse application designed to accept and persist FX deal details into a database. The application is developed using Spring Boot and supports various database systems, including PostgreSQL. The project follows best practices, including validation, exception handling, logging, unit testing, and documentation.

## Requirements
- Java 17
- Maven
- Docker & Docker Compose

## Project Structure
```plaintext
src
 ├── main
 │   └── java
 │       └── org.med.clustereddatawarehouse
 │           ├── config
 │           │   ├── AuditConfig.java
 │           │   └── ModelMapperConfig.java
 │           ├── controller
 │           │   └── FxDealController.java
 │           ├── exception
 │           │   └── ResourceAlreadyExistException.java
 │           ├── model
 │           │   ├── entity
 │           │   │   └── FxDeal.java
 │           │   └── request
 │           │       └── FxDealReqDto.java
 │           ├── repository
 │           │   └── FxDealRepository.java
 │           ├── service
 │           │   ├── FxDealService.java
 │           │   └── impl
 │           │       └── FxDealServiceImpl.java
 │           └── util
 │           │   └── GlobalExceptionHandler.java
 │           └── ClusteredDataWarehouseApplication.java    
 └── test
 │    └── java
 │        └── org.med.clustereddatawarehouse
 │            └── service.impl
 │           │   └── FxDealServiceImplTest.java
 │           └── ClusteredDataWarehouseApplicationTests.java
 │── compose.yaml
 ├── Dockerfile
 ├── Makefile
 ├── pom.xml
 └── README.md
```
## Setup

### Configuration

Create an `.env` file in the root directory with the following content:

```env
POSTGRESDB_USER=yourusername
POSTGRESDB_ROOT_PASSWORD=yourpassword
POSTGRESDB_DATABASE=yourdbname
POSTGRESDB_LOCAL_PORT=5432
POSTGRESDB_DOCKER_PORT=5432
SPRING_LOCAL_PORT=8080
SPRING_DOCKER_PORT=8080
```

## Build and Run the Application

### Using Docker Compose
Build and start the application:
```plaintext
docker-compose up -d
```
Stop the application:
```plaintext
docker-compose down
```
### Using Makefile

#### Build the project:
```plaintext
make build
```
#### Run the application:
```plaintext
make run 
```
#### Stop the application:
```plaintext
make stop
```
## API
### Swagger
Once the app starts, you can open the link below to see and test the API endpoint:

http://localhost:8080/swagger-ui.html
### Postman
Alternatively, you can test the API endpoints using Postman:
- URL: ```http://localhost:8080/api/v1/fxDeal```
- Method: POST
- Body:
````
{
    "id": "ID123",
    "orderingCurrencyIsoCode": "USD",
    "toCurrencyIsoCode": "EUR",
    "dealAmount": 1000.0
}
````
- Responses:
  * 201 Created: Deal successfully saved.
  * 400 Bad Request: Validation failed.

