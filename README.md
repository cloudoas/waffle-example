# waffle-example

## Introduction

This is an example that demonstrates the usage of [waffle](https://github.com/Waffle/waffle). There are two sub-projects:

1. waffle-example-rest

    This is a sample back-end RESTful service developed using Spring boot and waffle.

2. waffle-example-ui

    This is the client side UI developed using Angular.

## Build

Build the project using the command below.

```
	mvn clean install
```

## Run

start the Spring boot application using the command below and access the application at http://localhost:8080

```
	cd waffle-example-rest
	mvn spring-boot:run
```

## Run the jar
Start the application by running the jar file

```
	cd waffle-example-rest/target
	java -jar waffle-example-rest-0.0.1-SNAPSHOT.jar
```

