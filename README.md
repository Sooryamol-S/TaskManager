#  Task Manager API

A **Task Manager API** built using **Spring Boot** to manage tasks with notes. It allows users to create, update, and retrieve tasks, along with adding notes to tasks.

##  Features
- Create, update, and delete tasks 
- Add notes to tasks 
- Fetch tasks with or without notes 
- Error handling & validation 

##  Technologies Used
- Java 21 (Spring Boot)
- Spring MVC (REST API)
- In-Memory Storage (HashMap & ArrayList) (No Database)
- Lombok
- ModelMapper
- Postman for API testing

##  API Endpoints

### **Tasks**
| Method | Endpoint | Description |
|--------|---------|------------|
| `GET` | `/tasks` | Fetch all tasks (without notes) |
| `GET` | `/tasks/{id}` | Fetch a task by ID (includes notes) |
| `POST` | `/tasks` | Create a new task |
| `PATCH` | `/tasks/{id}` | Update a task |
| `DELETE` | `/tasks/{id}` | Delete a task |

### **Notes**
| Method | Endpoint | Description |
|--------|---------|------------|
| `GET` | `/tasks/{taskId}/notes` | Fetch all notes for a task |
| `POST` | `/tasks/{taskId}/notes` | Add a note to a task |

##  Setup & Run
1. Clone the repo:  
   ```sh
   git clone <your-repo-link>
   cd task-manager
2.Run the Spring Boot app:
  ```sh
  mvn spring-boot:run
3.Test APIs in Postman at http://localhost:8080/tasks
