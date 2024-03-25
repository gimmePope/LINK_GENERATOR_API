# LINK_GENERATOR_API

## Introduction

This project, developed by Otulana Olujimi Ayodele, is a robust link generator system designed for generating and managing unique transaction links. These links enable customers to view the details of generated invoices and proceed with payments. The application is built using Spring Boot 3, highlighting the framework's latest advancements.

## Prerequisites

To successfully run this project, the following prerequisites must be met:

- **JDK 17 or later:** The application is developed with JDK 17, leveraging the latest Java features and APIs. Ensure JDK 17 or later is installed on your system.
- **Maven:** The project utilizes Maven for efficient dependency management and project building. Make sure Maven is installed and properly set up on your machine.

## Running the Application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/gimmePope/LINK_GENERATOR_API.git

```

# Build the project using Maven

```sh
mvn clean install
```

# Run the Link-Generator-service Service

```sh
java -jar target/LINK_GENERATOR_API-v1.jar
```

#Features

Invoice Generation: Facilitates the creation of invoices and payment links for companies to send to their customers.

Unique Transaction Links: Generates secure, unique transaction links for accessing invoice details and making payments.

Embedded H2 Database: Utilizes an embedded H2 database for data storage, simplifying setup and deployment.

Test Data Loading: Supports loading test data based on the app.run-command-line variable in application.properties. Set it to true to load test data, or false to skip it.

#Technology Stack

Spring Boot 3: Empowers the application with its simplicity, efficiency, and comprehensive set of features for modern Java application development.

Thymeleaf: Used for creating dynamic HTML views, enhancing the application's user interface.

H2 Database: An in-memory database that provides fast and reliable storage solutions, perfect for development and testing environments.

##Technical Documentation

For detailed API documentation, visit: 


```endpoint
http://[host-ip]:[app-port]/swagger-ui.html
``` 

after running the application. This documentation offers interactive testing capabilities for the API endp

