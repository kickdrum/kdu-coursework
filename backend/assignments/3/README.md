# Smart Home 

Kickdrum is developing a sophisticated Smart Home Management System, empowering users to seamlessly control and monitor their connected devices through a unified mobile application.

## Problem Statement

Our customer envisions an application with comprehensive features:

1. Users can effortlessly create and manage multiple houses.
2. The creator of a house assumes the role of the admin, wielding control over house-related operations.
3. Exclusive privileges are granted to admins, enabling them to add users to their house securely.
4. Admins can organize their houses by creating distinct rooms.
5. Admins have the capability to incorporate various devices into their house ecosystem.
6. Users enjoy the flexibility to relocate devices within the confines of the same house.
7. A global view is provided for users to list all houses within the system.
8. Detailed insights are available, allowing users to list all rooms and associated devices within a specific house.
9. Users can effortlessly add or update the address associated with their house.
10. The application maintains a meticulous inventory of all manufactured devices, including essential details such as kickston_id, device_username, device_password, manufacture_date_time, and manufacture_factory_place.

## Tasks

To accomplish these objectives, the following tasks are to be undertaken:

- **Database Schema Definition:** Design a robust database schema capable of handling the specified use cases.
- **Database Definition Language (DDL):** Create a DDL statement to initialize the database, tables, and indexes systematically.
- **Database Manipulation Language (DML):** Develop DML statements to populate the inventory table with device details.
- **REST API Implementation:** Craft REST APIs that seamlessly manage all the outlined use cases.

## Best Practices and Implementation Details

To ensure a high-quality and maintainable codebase, developers are expected to adhere to the following best practices:

- **Naming Conventions:** Rigorously follow Java naming conventions for class names, variables, methods, and database entities.
- **Packaging Structure:** Maintain a well-organized packaging structure for the Java Spring application.

### Folder Structure

The folder structure includes the following components:

- **auth:** Authentication-related functionalities.
- **controllers:** Controllers handling the incoming HTTP requests and responses.
- **dto:** Data Transfer Objects for communication between layers.
- **exceptions:** Custom and global exception handling.
- **models:** Entity models representing database tables.
- **repositories:** Data access layer for database operations.
- **services:** Business logic layer for handling application-specific functionality.
- **utils:** Utility classes, including constants and DtoMapper for data mapping.

- **Entity Timestamps:** Include created date, modified date, and deleted date for all entities to track their lifecycle.

### Authentication and Authorization

- **Security Measures:** Leverage JWT tokens and Spring Security for robust authentication and authorization.
- **API Base URL:** The base URL for all APIs is "/api/v1/".

### Technology Stack

- **Backend** Spring Boot (Java and Maven)
- **Database:** PostgreSQL is utilized as the primary database for data storage.
- **API Testing:** Postman is employed for comprehensive API testing.
- **Documentation:** Swagger is integrated for clear and accessible API documentation.
- **Additional Features:** The application boasts Logging functionality, User profiles, Indexing, Data validation, and advanced Security measures such as JWT.

## Getting Started

To kickstart development, follow these steps:

1. Clone the repository to your local machine.
2. Set up a PostgreSQL database and configure the application.properties file with your database credentials.
3. Run the application locally.
4. Access and test the APIs using the provided base URL "/api/v1/".

## API Endpoints

Explore the extensive range of functionalities through the following API endpoints:

- `POST /api/v1/auth/register`: Register a new user.
- `POST /api/v1/house`: Add a new house.
- `POST /api/v1/house/{houseId}/add-user`: Add a user to a house.
- `GET /api/v1/house/`: Retrieve a list of houses.
- `PUT /api/v1/house`: Update the address of a house.
- `GET /api/v1/house/{houseId}`: Retrieve all rooms and devices associated with a specific house.
- `POST /api/v1/room`: Add rooms to a house.
- `GET /api/v1/inventory`: Retrieve the list of items in the inventory.
- `POST /api/v1/inventory`: Add an item to the inventory.
- `POST /api/v1/device/register`: Register a new device.
- `POST /api/v1/device/add`: Add a device to a house.

