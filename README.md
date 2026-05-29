# 📚 Secure Library Management System

A secure backend REST API application built using Java, Spring Boot, Spring Security, PostgreSQL, and Spring Data JPA. This project demonstrates complete CRUD operations with Authentication and Role-Based Authorization using Spring Security.

---

## 🚀 Features

- 🔐 Spring Security Integration
- 👥 Role-Based Authorization (`ADMIN` / `USER`)
- 🔑 Basic Authentication
- 🔒 BCrypt Password Encryption
- 📚 Book Management CRUD APIs
- 🗄️ PostgreSQL Database Integration
- ⚡ Spring Data JPA & Hibernate
- 🧱 Layered Architecture
- ❌ Global Exception Handling
- 🧪 API Testing with Postman

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven
- Postman

---

## 🔑 Authorization Rules

| Operation | Access |
|-----------|--------|
| GET APIs | USER, ADMIN |
| POST APIs | ADMIN |
| PUT APIs | ADMIN |
| DELETE APIs | ADMIN |

---

## 📌 API Endpoints

### 📖 Book APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/book` | USER, ADMIN |
| GET | `/book/{id}` | USER, ADMIN |
| POST | `/book` | ADMIN |
| PUT | `/book` | ADMIN |
| DELETE | `/book/{id}` | ADMIN |

---

## 🔐 Authentication

This project uses **Basic Authentication** with encrypted passwords using BCrypt.

### Example Users

| Username | Role |
|----------|------|
| user | USER |
| admin | ADMIN |

---

## ▶️ Run the Project

```bash
# Clone Repository
git clone <your-repository-link>

# Open Project
Import as Maven Project

# Run Application
SpringBootCrudeOperationApplication.java
```

---

## ⚙️ Database Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/LibraryDB
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Testing

Use Postman to test secured APIs with Basic Authentication.

Authorization → Basic Auth

```text
Username: admin
Password: admin123
```

---

## 📚 Learning Outcomes

- Spring Security Fundamentals
- Authentication & Authorization
- Secure REST API Development
- Role-Based Access Control
- Database Integration with PostgreSQL
- Backend Architecture Design
- API Security Testing

---

## 👨‍💻 Author

Ajay Kumar Karmur
