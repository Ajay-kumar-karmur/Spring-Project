# 📚 Secure Library Management System

A production-ready **REST API** for Library Management built with **Spring Boot**, featuring enterprise-grade security, role-based access control, and complete CRUD operations. This project demonstrates best practices in secure backend development with Java.

![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-green?style=flat-square)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

---

## 📋 Table of Contents

- [✨ Features](#features)
- [🛠️ Tech Stack](#tech-stack)
- [📁 Project Structure](#project-structure)
- [🚀 Getting Started](#getting-started)
- [⚙️ Configuration](#configuration)
- [🔐 Security & Authentication](#security--authentication)
- [📚 API Documentation](#api-documentation)
- [🧪 Testing](#testing)
- [🎯 Learning Outcomes](#learning-outcomes)
- [📝 License](#license)

---

## ✨ Features

### Core Functionality
- ✅ **Complete CRUD Operations** - Create, Read, Update, Delete book records
- 📚 **Book Management** - Full lifecycle management of library books
- 🗄️ **Persistent Storage** - PostgreSQL database integration
- 🔄 **ORM Support** - Hibernate & Spring Data JPA for database operations

### Security Features
- 🔐 **Spring Security Integration** - Enterprise-grade security framework
- 👥 **Role-Based Access Control (RBAC)** - `ADMIN` and `USER` roles
- 🔑 **Basic Authentication** - Username/password authentication
- 🔒 **BCrypt Password Encryption** - Secure password hashing
- 🛡️ **Authorization Rules** - Fine-grained API access control

### Development Features
- ⚡ **Hot Reload** - Spring Boot DevTools for rapid development
- 🏗️ **Layered Architecture** - Controller → Service → Repository pattern
- ❌ **Global Exception Handling** - Centralized error management
- 📊 **SQL Logging** - Debug SQL queries with formatted output
- 🧱 **Modular Design** - Clean, maintainable code structure

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Java 25 |
| **Framework** | Spring Boot 4.0.5 |
| **Security** | Spring Security |
| **Database** | PostgreSQL |
| **ORM** | Hibernate, Spring Data JPA |
| **Build Tool** | Maven |
| **Development** | Spring Boot DevTools, Lombok |
| **Testing** | JUnit, MockMvc |
| **API Testing** | Postman/Insomnia |

---

## 📁 Project Structure

```
Spring-Project/
├── src/
│   ├── main/
│   │   ├── java/jsp/springboot/spring_boot_crude_operation/
│   │   │   ├── SpringBootCrudeOperationApplication.java    # Main application entry point
│   │   │   ├── controller/                                 # REST API endpoints
│   │   │   ├── service/                                    # Business logic layer
│   │   │   ├── repository/                                 # Data access layer
│   │   │   ├── entity/                                     # JPA entities
│   │   │   ├── config/                                     # Security & app configuration
│   │   │   └── exception/                                  # Custom exceptions
│   │   └── resources/
│   │       └── application.properties                       # Configuration file
│   └── test/                                               # Unit & integration tests
├── pom.xml                                                 # Maven dependencies
├── mvnw & mvnw.cmd                                         # Maven wrapper
├── .gitignore & .gitattributes                             # Git configuration
└── README.md                                               # This file
```

### Architecture Pattern

```
┌─────────────────────────────────────────┐
│         REST API (Controller)           │
│  GET/POST/PUT/DELETE /api/book/*        │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│       Business Logic (Service)          │
│    Book CRUD Operations & Validation    │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│    Data Access Layer (Repository)       │
│   Spring Data JPA + Hibernate ORM       │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│     Database (PostgreSQL)               │
│        Persistent Storage               │
└─────────────────────────────────────────┘
```

---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)** - Version 25 or higher
  ```bash
  java -version
  ```
- **PostgreSQL** - Version 12 or higher
  ```bash
  psql --version
  ```
- **Maven** - Version 3.6+ (or use the included Maven wrapper)
  ```bash
  mvn --version
  ```
- **Git** - For cloning the repository
- **Postman/Insomnia** - For API testing

### Installation Steps

#### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Ajay-kumar-karmur/Spring-Project.git
cd Spring-Project
```

#### 2️⃣ Create PostgreSQL Database
```sql
-- Connect to PostgreSQL
psql -U postgres

-- Create database
CREATE DATABASE LibraryDB;

-- List databases (verify creation)
\l

-- Exit psql
\q
```

#### 3️⃣ Configure Application Properties
Edit `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/LibraryDB
spring.datasource.username=postgres
spring.datasource.password=root  # Change to your PostgreSQL password

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Application Name
spring.application.name=spring-boot-crude-operation
```

#### 4️⃣ Build the Project
```bash
# Using Maven wrapper (Linux/Mac)
./mvnw clean install

# Using Maven wrapper (Windows)
mvnw.cmd clean install

# Or using system Maven
mvn clean install
```

#### 5️⃣ Run the Application
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using system Maven
mvn spring-boot:run

# Or run directly via IDE
# Right-click on SpringBootCrudeOperationApplication.java → Run As → Java Application
```

#### 6️⃣ Verify Application Startup
```
Expected output in console:
╔════════════════════════════════════════════╗
║  Spring Boot Application Started           ║
║  Tomcat started on port(s): 8080           ║
║  Application 'spring-boot-crude-operation' ║
╚════════════════════════════════════════════╝
```

---

## ⚙️ Configuration

### Database Configuration
The application uses PostgreSQL with automatic schema generation via Hibernate:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/LibraryDB
spring.datasource.username=postgres
spring.datasource.password=root

# DDL Auto Options:
# create-drop - Creates schema on startup, drops on shutdown (Development)
# create     - Creates schema on startup (Testing)
# update     - Updates existing schema (Production - Current)
# validate   - Validates existing schema (Safe mode)
spring.jpa.hibernate.ddl-auto=update
```

### Security Configuration
The application includes a `SecurityConfig.java` class that:
- Configures HTTP Basic Authentication
- Sets up role-based access control
- Enables BCrypt password encoding
- Manages CORS and CSRF settings

---

## 🔐 Security & Authentication

### Authentication Mechanism
This project uses **HTTP Basic Authentication** with the following flow:

```
1. Client sends credentials in Authorization header:
   Authorization: Basic base64(username:password)

2. Spring Security decodes and validates credentials

3. If valid, request is processed
   If invalid, HTTP 401 Unauthorized response
```

### Role-Based Authorization

| Role | Permissions | Use Case |
|------|------------|----------|
| **USER** | Read-only access (GET) | Library members, readers |
| **ADMIN** | Full access (GET, POST, PUT, DELETE) | Librarians, administrators |

### Access Control Matrix

| Endpoint | Method | USER | ADMIN | Authentication |
|----------|--------|------|-------|-----------------|
| `/book` | GET | ✅ | ✅ | Required |
| `/book/{id}` | GET | ✅ | ✅ | Required |
| `/book` | POST | ❌ | ✅ | Required |
| `/book` | PUT | ❌ | ✅ | Required |
| `/book/{id}` | DELETE | ❌ | ✅ | Required |

### Default Credentials

⚠️ **WARNING**: Change these credentials in production!

| User Type | Username | Password | Role |
|-----------|----------|----------|------|
| Regular User | `user` | `user123` | USER |
| Administrator | `admin` | `admin123` | ADMIN |

---

## 📚 API Documentation

### Base URL
```
http://localhost:8080/book
```

### 📖 Book Management Endpoints

#### 1. Get All Books
```http
GET /book HTTP/1.1
Host: localhost:8080
Authorization: Basic <credentials>
```

**Response (200 OK):**
```json
[
  {
    "bookId": 1,
    "bookName": "Spring in Action",
    "bookAuthor": "Craig Walls",
    "bookPrice": 49.99,
    "bookQuantity": 5
  },
  {
    "bookId": 2,
    "bookName": "Clean Code",
    "bookAuthor": "Robert C. Martin",
    "bookPrice": 39.99,
    "bookQuantity": 3
  }
]
```

#### 2. Get Book by ID
```http
GET /book/1 HTTP/1.1
Host: localhost:8080
Authorization: Basic <credentials>
```

**Response (200 OK):**
```json
{
  "bookId": 1,
  "bookName": "Spring in Action",
  "bookAuthor": "Craig Walls",
  "bookPrice": 49.99,
  "bookQuantity": 5
}
```

#### 3. Create New Book (Admin Only)
```http
POST /book HTTP/1.1
Host: localhost:8080
Authorization: Basic <credentials>
Content-Type: application/json

{
  "bookName": "Effective Java",
  "bookAuthor": "Joshua Bloch",
  "bookPrice": 45.99,
  "bookQuantity": 10
}
```

**Response (201 Created):**
```json
{
  "bookId": 3,
  "bookName": "Effective Java",
  "bookAuthor": "Joshua Bloch",
  "bookPrice": 45.99,
  "bookQuantity": 10
}
```

#### 4. Update Book (Admin Only)
```http
PUT /book HTTP/1.1
Host: localhost:8080
Authorization: Basic <credentials>
Content-Type: application/json

{
  "bookId": 1,
  "bookName": "Spring in Action 6th Edition",
  "bookAuthor": "Craig Walls",
  "bookPrice": 59.99,
  "bookQuantity": 8
}
```

**Response (200 OK):**
```json
{
  "bookId": 1,
  "bookName": "Spring in Action 6th Edition",
  "bookAuthor": "Craig Walls",
  "bookPrice": 59.99,
  "bookQuantity": 8
}
```

#### 5. Delete Book (Admin Only)
```http
DELETE /book/1 HTTP/1.1
Host: localhost:8080
Authorization: Basic <credentials>
```

**Response (204 No Content)**

---

## 🧪 Testing

### Using Postman

#### Step 1: Set Up Basic Authentication
1. Open Postman
2. Create a new request
3. Go to **Authorization** tab
4. Select **Type** → **Basic Auth**
5. Enter:
   - **Username**: `admin`
   - **Password**: `admin123`

#### Step 2: Test Endpoints
```bash
# Get all books
GET http://localhost:8080/book

# Get specific book
GET http://localhost:8080/book/1

# Create book (POST)
POST http://localhost:8080/book
Body (JSON):
{
  "bookName": "Test Book",
  "bookAuthor": "Test Author",
  "bookPrice": 29.99,
  "bookQuantity": 5
}

# Update book (PUT)
PUT http://localhost:8080/book
Body (JSON):
{
  "bookId": 1,
  "bookName": "Updated Name",
  "bookAuthor": "Updated Author",
  "bookPrice": 35.99,
  "bookQuantity": 10
}

# Delete book
DELETE http://localhost:8080/book/1
```

### Unit Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=BookControllerTest

# Run with coverage
mvn test jacoco:report
```

### Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| **401 Unauthorized** | Check credentials and Authorization header format |
| **403 Forbidden** | User role doesn't have permission for this operation |
| **404 Not Found** | Book ID doesn't exist in database |
| **PostgreSQL connection error** | Verify PostgreSQL is running and credentials in application.properties |
| **Port 8080 already in use** | Change port in application.properties: `server.port=8081` |

---

## 🎯 Learning Outcomes

By exploring this project, you'll learn:

### Spring Framework Concepts
- ✅ Spring Boot application setup and configuration
- ✅ Spring MVC and REST API development
- ✅ Spring Data JPA and Hibernate ORM
- ✅ Layered architecture (Controller → Service → Repository)

### Security
- ✅ Spring Security framework fundamentals
- ✅ HTTP Basic Authentication implementation
- ✅ Role-Based Access Control (RBAC)
- ✅ BCrypt password encryption and hashing
- ✅ Authorization filters and interceptors

### Database & ORM
- ✅ PostgreSQL integration
- ✅ Entity mapping and JPA annotations
- ✅ CRUD operations with JPA repository
- ✅ Database schema generation via Hibernate
- ✅ SQL query logging and debugging

### Best Practices
- ✅ REST API design principles
- ✅ Error handling and exception management
- ✅ Separation of concerns
- ✅ Dependency injection and IoC containers
- ✅ Unit testing with JUnit and Mockito

---

## 🔧 Troubleshooting

### Application Won't Start
```bash
# Check Java version
java -version

# Check if PostgreSQL is running
sudo systemctl status postgresql  # Linux
brew services list | grep postgres  # macOS
```

### Database Connection Issues
```bash
# Test PostgreSQL connection
psql -U postgres -h localhost -d LibraryDB

# Reset password (if forgotten)
psql -U postgres
ALTER USER postgres WITH PASSWORD 'new_password';
```

### Maven Build Failures
```bash
# Clear Maven cache
mvn clean

# Rebuild with verbose output
mvn clean install -X

# Check Java compatibility
mvn -version
```

---

## 📞 Support & Contributing

### Getting Help
- 📖 [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- 🔐 [Spring Security Guide](https://spring.io/projects/spring-security)
- 🗄️ [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- 💬 Open an issue on GitHub

### Contributing
Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📝 License

This project is licensed under the **MIT License** - see the LICENSE file for details.

---

## 👨‍💻 Author

**Ajay Kumar Karmur**
- GitHub: [@Ajay-kumar-karmur](https://github.com/Ajay-kumar-karmur)

---

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- PostgreSQL community
- Java developers and the open-source community

---

## 📈 Project Status

- ✅ Core functionality complete
- ✅ Security implemented
- 🔄 Ongoing maintenance and improvements
- 📋 Future enhancements: JWT authentication, Swagger API documentation, Docker containerization

**Last Updated**: May 29, 2026

---

<div align="center">

**⭐ If you found this project helpful, please consider giving it a star!**

[⬆ Back to top](#table-of-contents)

</div>
