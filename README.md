# Spring Boot Swagger API example

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

A [Spring Boot](http://projects.spring.io/spring-boot/) example app which showcases the way REST endpoints can be exposed using Springfox Swagger UI, in order to allow users to perform CRUD operations on a remote MySQL database. DTOs are used in order to encapsulate certain aspects of the data which is sent/received. The Tomcat server is embedded into Spring Boot.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Since this is a Spring Boot app, the Tomcat server is embedded and in order to run the app, simply create a new project, add all the files 
and make sure to point the application.properties file to a valid mysql server and provide valid credentials.
Use the following Maven run configuration for running the app:

```shell
mvn spring-boot:run
```

## How it works

The app uses Springfox Swagger UI in order to facilitate the operations performed on the database, allowing users to send GET/PUT/POST/
PATCH/DELETE operations directly from the browser, eliminating the need for a tool such as Postman.
The Springfox suite of java libraries are all about automating the generation of machine and human readable specifications for JSON APIs 
written using the spring family of projects. 

Springfox works by examining an application, once, at runtime to infer API semantics based 
on spring configurations, class structure and various compile time java Annotations.

DTOs (data transfer objects) are used to encapsulate data and therefore hide some elements of the object being sent/received to/from one
subsystem of the application to another.
One main advantage of DTOs are the fact that the data needed for transferring object can be greatly reduced.

<img src="https://i.imgur.com/LJbp2Ax.png"/>

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
