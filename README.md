# My Bank - Java Version

## Build and run local with Docker:
### Dependencies

- Docker
- Docker Compose

``
docker-compose up --build
``


## Run local:
### Dependencies

- Docker
- Docker Compose
- Java 11

### Run Postgres (optional)

``
docker-compose up postgres
``

### Build Application
``
./gradlew clean b
``
### Run Application
``
java -jar build/libs/mybank-java-0.0.1-SNAPSHOT.jar
``

## Apis

### Swagger

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Account:
#### Create Account
``
curl -X POST "http://localhost:8080/v1/accounts" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"document_number\": \"123456\"}"
``
#### Get Account By Id
``
curl -X GET "http://localhost:8080/v1/accounts/{CREATED_ACCOUNT_ID}" -H "accept: */*"
``

### Transaction:
#### Create Transaction
``
curl -X POST "http://localhost:8080/v1/transactions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"account_id\": \"63ba7653-ffe9-48f0-b861-ef6431566f65\", \"amount\": 5, \"operation_type\": \"BUY_CASH\"}"
``

