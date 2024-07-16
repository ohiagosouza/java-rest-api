# Java REST API

This project is a RESTful API using Java and Spring Boot.

## Prerequisites

Make sure you have the following prerequisites before starting:

- Java 17 or later installed
- Maven 3 or later installed
- IDE of your choice (I'm using IntelliJ IDEA)
- PostgreSQL

## Installation and Running

Follow these steps to run the project locally:

1. Clone this repository to your local environment:

   ```bash
   git clone https://github.com/ohiagosouza/java-rest-api.git
   ```

2. Navigate to the project directory:

   ```bash
   cd java-rest-api
   ```

3. Configure the database name in `src/main/resources/application.properties`
4. Run `RestApiApplication`

The API will be accessible at `http://127.0.0.1:8080`

## Endpoints

- **GET /users**: Returns all users.
- **POST /users**: Accepts a JSON body to create a user in Database.
-- **PUT /users/{id}**: Accepts a JSON body to update a user.
-- **DELETE /users/{id}**: Accepts an id to delete a user;
  
Example JSON body for POST `/users`:
```json
{
	"username": "ohiagosouza",
	"password": "1234"
}
```

## Project Structure
The project structure is organized as follows:

- `src/main/java`: Contains main Java files.
- `src/main/resources`: Contains configuration files and resources.
- `src/test/java`: Contains unit tests.

## Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request.
