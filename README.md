# 📋 Task Manager — Backend

A REST API built with **Spring Boot**, secured with **JWT Authentication**, connected to **MySQL** database.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.x |
| Security | Spring Security + JWT |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |

---

## ⚙️ Setup & Run

### 1. Clone the project
```bash
git clone https://github.com/your-username/task-manager.git
cd task-manager
```

### 2. Configure Database
Open `src/main/resources/application.properties` and update:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=your_password
jwt.secret=your_secret_key
```

### 3. Run the app
```bash
mvn spring-boot:run
```
API runs on `http://localhost:8080`

---

## 🔐 Authentication Flow


---

## 📡 API Endpoints

### Auth
| Method | Endpoint | Access | Description |
|---|---|---|---|
| POST | /api/auth/register | Public | Register new user |
| POST | /api/auth/login | Public | Login & get JWT token |

### Tasks
| Method | Endpoint | Access | Description |
|---|---|---|---|
| GET | /api/tasks | 🔒 JWT | Get all tasks |
| GET | /api/tasks/{id} | 🔒 JWT | Get task by ID |
| POST | /api/tasks | 🔒 JWT | Create new task |
| PUT | /api/tasks/{id} | 🔒 JWT | Update task |
| DELETE | /api/tasks/{id} | 🔒 JWT | Delete task |

---

## 🔑 How JWT Works Here

1. User calls `POST /api/auth/login` with credentials
2. Server validates and returns a JWT token
3. Client sends token in every request:

4. `JwtRequestFilter` validates token on every request
5. Invalid/missing token → `401 Unauthorized`

---

## 👨‍💻 Developer
Built by **Chethanya**