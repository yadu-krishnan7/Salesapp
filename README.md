* Product Sales Management System

This Spring Boot application is designed to manage products and sales, providing a RESTful API for interacting with product and sales data. 
It includes functionalities such as CRUD operations for products, total revenue calculation, authentication and authorization, pagination, and exception handling.

* Features
  
-Product Management: Create, read, update, and delete products.

-Sale Management: Track sales with attributes like product ID.

-Revenue Calculation: Calculate total revenue generated by all sales and by a specific product.

-Authentication and Authorization: Secure the API with Spring Security, allowing only authenticated users with the role of "ADMIN" to perform certain operations. 
Basic Authentication is used for user authentication.

-Pagination: Implement pagination for fetching all products.

-Exception Handling: Handle exceptions gracefully and return appropriate error messages and status codes for invalid requests.

* Setup

Prerequisites

-Java Development Kit (JDK) 8 or higher

-Apache Maven

-MySQL database server

-IDE

* Configuration
  
-Clone this repository to your local machine:  https://github.com/yadu-krishnan7/Salesapp.git

-Navigate to the project directory: cd Salesapp/salesapp

-Update the application.properties file located in the src/main/resources directory with your MySQL database configuration:

-spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name

-spring.datasource.username=your_database_username

-spring.datasource.password=your_database_password

* Build and Run

- Build and run the project using Maven: mvn spring-boot:run

- The application will start running on localhost:8080.

* Authentication
This application uses Basic Authentication with in-memory users for user authentication.
Users must provide their username and password as part of the request headers to access the API endpoints.
Only users with the role of "ADMIN" are authorized to perform certain operations.

* Usage
You can interact with the API using tools like Postman or cURL. Below are some sample endpoints:

-GET /api/products: Get all products.

-GET /api/products/{id}: Get product by ID.

-POST /api/products: Add a new product.

-PUT /api/products/{id}: Update product by ID.

-DELETE /api/products/{id}: Delete product by ID.

-GET /api/products/revenue: Get total revenue.

-GET /api/products/{id}/revenue: Get revenue by product.

