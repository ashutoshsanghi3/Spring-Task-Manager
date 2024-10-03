# TaskFlow: Task and Notes Manager

This README provides an overview of the features offered by TaskFlow, including CRUD operations, exception handling, response entities, and data transfer objects (DTOs). 
This API is built using Spring Boot,Spring Data JPA,H2 Database and is designed for managing tasks and notes effectively.

## Features Overview

- **Task Management:** Create, read, update, and delete tasks.
- **Note Management:** Associate notes with specific tasks, allowing for detailed task descriptions.
- **Exception Handling:** Graceful error management with meaningful responses.
- **Response Entities:** Standardized responses for success and error scenarios.
- **Data Transfer Objects:** Efficient data handling between the client and server.

## Architecture

The application follows a layered architecture:

- **Controllers:** Handle incoming HTTP requests and return appropriate responses.
- **Services:** Contain the business logic and interact with the data layer.
- **Repositories:** Interface with the database to perform CRUD operations.
- **Models:** Define the data structure for tasks and notes.

The application utilizes Spring Boot's built-in features for dependency injection, RESTful services, and data management.

## CRUD Operations

### Tasks

1. **Create:** Add a new task using `POST /tasks`.
2. **Read:** Retrieve tasks with:
    - `GET /tasks` for all tasks.
    - `GET /tasks/{id}` for a specific task.
3. **Update:** Modify an existing task using `PATCH /tasks/{id}`.
4. **Delete:** Remove a task with `DELETE /tasks/{id}`.

### Notes

1. **Create:** Add a new note to a task with `POST /tasks/{taskId}/notes`.
2. **Read:** Access notes using:
    - `GET /tasks/{taskId}/notes` for all notes of a task.
    - `GET /tasks/{taskId}/notes/{noteId}` for a specific note.
3. **Update:** Modify an existing task using `PATCH /tasks/{taskId}/notes/{noteId}`.
3. **Delete:** Remove a note with `DELETE /tasks/{taskId}/notes/{noteId}`.

## Exception Handling

The application includes centralized exception handling for:

- **Task Not Found:** Returns a `404 Not Found` response if a task is not found.
- **Note Not Found:** Returns a `404 Not Found` response if a note is not found.

Custom error messages are provided to help identify the issue.


## Data Transfer Objects (DTOs)

The API utilizes the following DTOs for structured data exchange:

- **ErrorResponse DTO:**
    - Structure for error messages.

- **SuccessResponse DTO:**
    - Structure for success messages.

- **TasksResponse DTO:**
    - Structure to represent a collection of tasks, including count and task details.

- **NotesResponse DTO:**
    - Structure to represent a collection of notes, including count and note details.

## Installation

To set up the Task Manager application on your local machine, follow these steps:

### Steps to Install

1. **Clone the Repository:**
   Open your terminal and run the following command to clone the repository:

   ```bash
      git clone https://github.com/ashutoshsanghi3/TaskFlow.git
   ```
2. **Navigate to the Project Directory:**
   Change to the directory of the cloned repository:

    ```bash
      cd your-project-directory
    ```
3. **Build the Project with Maven:**
   Run the following command to build the project:

    ```bash
      mvn clean install
    ```
4. **Run the Application:**
   Start the application using Maven:

    ```bash
      mvn spring-boot:run
    ```