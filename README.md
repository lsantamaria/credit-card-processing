# Credit card system

This is a full stack application for adding and retrieving credit cards.
The project is separated in two modules: credit-card-processing-frontend and credit-card-processing-ws.


## Backend

### Requirements

- Java JDK 11

### Installation

Download and install Java JDK 11 from the [Java official webpage](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html). 

Set JAVA_HOME environment variable to point to this installation.

In order to compile/test/run the project, go to credit-card-processing-ws module and execute the provided Maven wrapper.
### Compilation

```
../mvnw -B compile
```
### Test
```
../mvnw -B test
```

### Run
You can run the project either running the JAR or using spring-boot maven plugin:
```
../mvnw spring-boot:run
```
The API will be deployed at http://localhost:8080. You can check the API documentation in http://localhost:8080/swagger-ui.html.

## Frontend

### Requirements

- Angular CLI 7.3
- Node 10.10

In order to compile/test/run the frontend, go to credit-card-processing-frontend module and execute ng commands.

### Installation

```
npm install @angular/cli
```

### Compilation

```
ng build
```
### Test

```
ng test
```
### Run
```
ng serve
```