# ToDoAPI – Spring Boot 

## Overview

ToDoAPI is a full-stack task management application with user authentication.
Each user can register, log in, and manage their own personal todos securely using JWT authentication.

This project demonstrates a production-style full-stack architecture with authentication, REST APIs, cloud database.

---

## Tech Stack

| Layer            | Technology            |
| ---------------- | --------------------- |
| Backend          | Spring Boot           |
| Security         | Spring Security + JWT |
| Database         | PostgreSQL            |
| ORM              | Spring Data JPA       |
| API Docs         | Swagger               |
| Deployment       | Render                |
| Database Hosting | Neon                  |
| Frontend Hosting | Vercel                |

---

## Features

* User Registration
* User Login (JWT Authentication)
* Create Todo
* View Todos (User-specific)
* Update Todo
* Delete Todo
* Secure APIs
* Swagger API Documentation
* Cloud Database Integration
* Deployment Ready

---

## API Endpoints

### Auth

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /auth/register | Register new user |
| POST   | /auth/login    | Login and get JWT |

### Todo

| Method | Endpoint                 | Description                      |
| ------ | ------------------------ | -------------------------------- |
| GET    | /api/v1/todo             | Get all todos for logged-in user |
| GET    | /api/v1/todo/{id}        | Get todo by id                   |
| POST   | /api/v1/todo/create      | Create new todo                  |
| PUT    | /api/v1/todo/update/{id} | Update todo                      |
| DELETE | /api/v1/todo/delete/{id} | Delete todo                      |

---

## Authentication

All Todo endpoints require JWT token:

```
Authorization: Bearer <your_token>
```

---

## Running Locally

### 1. Clone Repository

```
git clone https://github.com/SaiAmirthesh/ToDoAPI.git
cd ToDoAPI
```

### 2. Set Environment Variables

Create `.env` or set system variables:

```
DB_URL=jdbc:postgresql://localhost:5432/todo
DB_USER=postgres
DB_PASS=yourpassword
JWT_SECRET=your_secret_key
```

### 3. Build and Run

```
./mvnw clean package
java -jar target/ToDoAPI.jar
```

App runs on:

```
http://localhost:8080
```

Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## Deployment

| Service  | Platform        |
| -------- | --------------- |
| Backend  | Render          |
| Frontend | Vercel          |
| Database | Neon PostgreSQL |

Environment variables used in production:

```
DB_URL=
DB_USER=
DB_PASS=
JWT_SECRET=
PORT=8080
```

---

## Project Structure

```
ToDoAPI
│
├── src/main/java/com/SaiAmirthesh/ToDoAPI
│   ├── controller
│   ├── service
│   ├── repository
│   ├── models
│   ├── security
│   └── utils
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
├── mvnw
└── README.md
```

---

## Author

**Sai Amirthesh**
GitHub: [https://github.com/SaiAmirthesh](https://github.com/SaiAmirthesh)
ProjectUrl: [RoadMap.sh](https://roadmap.sh/projects/todo-list-api)
