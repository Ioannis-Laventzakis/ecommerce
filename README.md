# E-commerce Platform

Welcome to the E-commerce Platform project! This repository contains the source code for a full-featured e-commerce application built from scratch using Spring Boot and PostgreSQL.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Project Overview

This project aims to develop a scalable and efficient e-commerce platform where users can browse products, add them to a cart, and make purchases. The platform includes both user-facing components and administrative functionalities for managing products, orders, and users.

## Features

- User authentication and authorization
- Product listing and detailed views
- Shopping cart functionality
- Order placement and history tracking
- Admin dashboard for managing products and orders
- Responsive design for various devices

## Technologies Used

- **Backend:**
    - Java 17
    - Spring Boot
    - Spring Data JPA
    - Spring Security
    - PostgreSQL Database

- **Frontend:**
    - Thymeleaf (for server-side rendering)
    - HTML5, CSS3, JavaScript
    - Bootstrap (for responsive design)

- **Build Tool:**
    - Maven

- **Deployment:**
    - Docker
    - AWS EC2
    - Nginx

## Getting Started

Follow these instructions to set up the project locally.

### Prerequisites

Ensure you have the following installed:

- Java 17
- Maven 3.6+
- PostgreSQL 13+
- Docker (if using containerization)

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Ioannis-Laventzakis/E-commerce.git
   cd E-commerce
    ```
2. Configure the database:
    - Create a new PostgreSQL database named `ecommerce`.
    - Update the database connection properties in `src/main/resources/application.properties`.
   ´´´
    - spring.datasource.url=jdbc:postgresql://localhost:5432/nexagigdb
    - spring.datasource.username=postgres
    - spring.datasource.password=postgres
    - spring.jpa.hibernate.ddl-auto=update
    - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ´´´
   3. Install the project dependencies:
   ```bash
    mvn clean install
    ```
    ### Running the Application
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
   The application will be accessible at `http://localhost:8080`.
4. ### Project Structure
5. The project is structured as follows:
   ```plaintext
   E-commerce/
   ├── src/
   │   ├── main/
   │   │   ├── java/
   │   │   │   └── com/
   │   │   │       └── ecommerce/
   │   │   │           ├── controller/
   │   │   │           ├── model/
   │   │   │           ├── repository/
   │   │   │           ├── service/
   │   │   │           └── EcommerceApplication.java
   │   │   └── resources/
   │   │       ├── static/
   │   │       ├── templates/
   │   │       └── application.properties
   │   └── test/
   └── pom.xml
   ```
   - The `controller` package contains the request handlers for the application.
   - The `model` package contains the entity classes for the database.
   - The `repository` package contains the repository interfaces for the database.
   - The `service` package contains the service classes for the application.
   - The `resources` directory contains the static assets and configuration files.
6. ### Contributing
- Contributions are welcome! Here's how you can get started:
   - Fork the repository.
   - Create a new branch (`git checkout -b feature-branch`).
   - Make your changes.
   - Commit your changes (`git commit -am 'Add new feature'`).
   - Push to the branch (`git push origin feature-branch`).
   - Create a new Pull Request.
8. ### License


This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


9. ### Contact
- Email: glaventzakis@gmail.com
- Anna  Assinsting with the project  nexagigs@gmail.com  


[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
