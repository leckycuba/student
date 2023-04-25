<h1 align="center">Code Challenge</h1>

## Introduction
The following project allows the management of students through a reactive API that exposes 2 services. The first one allows the registration of a student and the second one allows the listing of active students.

## Execution
To run the app, enter the following command in the root folder where the project was cloned:

```shell
.\gradlew bootRun
```
## Documentation
To obtain the API documentation, go to the following link:

<http://localhost:8080/swagger-ui-custom.html>

In the documentation you can see in which server it is deployed, the exposed endpoints, their types and the objects that they send and receive, as well as their restrictions.

## Test
To test the API, go to the following link: <https://web.postman.co/workspaces>

In it, select or create a new space. Once inside, import the file **Estudiante.postman_collection** that is in the root folder.

Inside the imported collection, there will be two enpoints that can be used as an example to perform the query.

## Unit test report
To obtain the unit test report, execute the following command in the console:

```shell
./gradlew build jacocoTestReport
```
This will generate a report in the **\build\reports\tests\test\index.html** folder where you can see the execution

### Sonarqube
If Sonarqube is installed, you can add the **sonar** task to make it easier to see the report as well as to get more metrics.

```shell
./gradlew build jacocoTestReport sonar
```

#### Note
Before executing the command, the properties found in the **sonarqube** task in the **build.gradle** file must be updated with the values of the project created on the sonar server
