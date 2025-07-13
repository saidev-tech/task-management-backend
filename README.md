# My Todo App

A simple full-stack web application for managing tasks, built with Java Spring Boot (backend) and Vue.js (frontend).

## Features
- Create, update, delete, and view tasks
- RESTful API backend with Spring Boot
- Frontend built with Vue.js and Axios
- Swagger UI for API documentation
- H2 in-memory database for development
- CORS enabled for frontend-backend communication

## Tech Stack
- **Backend:** Java 17, Spring Boot, Spring Data JPA, H2
- **Frontend:** Vue.js (Vite), Axios
- **API Docs:** Swagger (springdoc-openapi)

## Getting Started

### Backend Setup
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd my-todo-app
   ```
2. Build and run the Spring Boot app:
   ```bash
   mvn spring-boot:run
   ```
3. Access Swagger UI for API docs:
   - [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

### Frontend Setup
1. Go to the frontend directory (if using Vue):
   ```bash
   cd my-todo-frontend
   npm install
   npm run dev
   ```
2. The app will run at [http://localhost:3000](http://localhost:3000) (or your configured port).

## API Endpoints
- `GET /api/tasks` - List all tasks
- `GET /api/tasks/{id}` - Get a task by ID
- `POST /api/tasks` - Create a new task
- `PUT /api/tasks/{id}` - Update a task
- `DELETE /api/tasks/{id}` - Delete a task

## CORS Configuration
CORS is enabled for local development. Update the allowed origins in `WebConfig.java` for production deployments.


## Author
- Sai Teja

---
Feel free to contribute or open issues for improvements!

