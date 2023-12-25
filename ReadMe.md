# Spring Boot Starter Template with OpenAPI and JWT Auth

This is a starter template for a Spring Boot application that integrates OpenAPI for API documentation and JWT (JSON Web Token) for authentication. The project is containerized using Docker Compose, which starts a PostgreSQL database instance for data persistence.

![Alt text](https://raw.githubusercontent.com/mhabashy/spring-boot-openapi-jwt-template/main/demo.png "Optional title")


## Features

- **Spring Boot**: Java-based framework for creating standalone, production-grade applications.
- **OpenAPI**: Integrated for API documentation, providing a clear understanding of the exposed endpoints.
- **JWT Auth**: Secure your endpoints using JSON Web Tokens for authentication and authorization.
- **Docker Compose**: Containerized PostgreSQL database for data storage, simplifying deployment and scaling.

## Prerequisites

Ensure you have the following installed on your local machine:

- Java 11 or higher
- Maven
- Docker
- Docker Compose

## Getting Started

Follow these steps to set up and run the project:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/spring-boot-openapi-jwt-template.git
   ```
2. **Navigate to Project Directory**

    ```bash
    cd spring-boot-openapi-jwt-template
    ```

3. **Start Docker Compose**

    ```bash
    docker-compose up -d
    ```
 **This will start the PostgreSQL database container.**

4. **Run the Application**

    ```bash
    java -jar target/spring-boot-openapi-jwt-template-0.0.1-SNAPSHOT.jar
    ```
   
5. **Access OpenAPI Documentation**
Open your web browser and navigate to:

    ```bash
    http://localhost:8080/swagger-ui.html
    ```
   
Here, you can explore the API endpoints and test them using the interactive UI provided by Swagger.

Configuration
Update the application.yml or application.properties files under src/main/resources to modify application-specific configurations, database settings, JWT secrets, etc.
Usage
The starter template provides a basic structure with user authentication using JWT. Extend this template by adding your business logic, entities, repositories, services, controllers, etc.
Contributing
Feel free to contribute to this starter template by submitting pull requests or opening issues for any improvements, bug fixes, or features you'd like to see.

License
This project is licensed under the MIT License. See the LICENSE file for details.

