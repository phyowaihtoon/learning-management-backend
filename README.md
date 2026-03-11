# Learning Management System - Backend

A Spring Boot-based REST API for managing online learning courses, instructors, students, and sessions.

## Overview

This is the backend service for a comprehensive Learning Management System (LMS) that enables instructors to create and manage courses, and allows students to enroll in and participate in course sessions.

## Tech Stack

- **Java 17+** with Jakarta EE
- **Spring Boot 3.x** - Web framework
- **Spring Security** - Authentication & authorization with JWT
- **Spring Data JPA** - ORM and database access
- **MySQL** - Primary database
- **Maven** - Build tool
- **Lombok** - Boilerplate reduction (optional)

## Project Structure

```
src/main/java/com/creatip/lms/
├── config/              # Configuration classes (Security, Constants, JWT)
├── controller/          # REST API endpoints
├── domain/              # JPA entity models
│   ├── learning/        # Learning domain entities (Course, Lesson, Student, etc.)
│   └── User.java        # User authentication entity
├── repository/          # Data access layer (JpaRepository interfaces)
├── security/            # Security utilities and services
├── service/             # Business logic layer
└── management/          # Metrics and monitoring services
```

## Database Schema

### Core Learning Entities

1. **instructor** - Instructor/trainer information
2. **student** - Student profile (linked to User for authentication)
3. **category** - Course categories
4. **course** - Course details with instructor and category
5. **chapter** - Course chapters/modules
6. **lesson** - Individual lessons with content (video/document)
7. **course_media** - Course marketing media (intro video, images)
8. **course_session** - Scheduled course sessions
9. **session_enrollment** - Student enrollments in sessions

### Data Types

- **status** fields use `INT` for flexible status management
- **course_type** uses `INT` (0: ONLINE, 1: IN_PERSON)
- **content_type** uses `INT` (0: VIDEO, 1: DOCUMENT)
- **media_type** uses `INT` (0: INTRO_VIDEO, 1: IMAGE)

See `Scripts/DomainEntities.sql` for complete DDL.

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd learning-management-backend
```

### 2. Database Setup

Create the database and run migrations:

```bash
mysql -u root -p < Scripts/DomainEntities.sql
```

Update `application.yml` with your database credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_db_user
    password: your_db_password
```

### 3. Build the Project

```bash
./mvnw clean package
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## Configuration

### Application Profiles

- **dev** - Development environment (`application-dev.yml`)
- **prod** - Production environment (`application-prod.yml`)

Activate a profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

### JWT Configuration

Update security configuration in `config/SecurityJwtConfiguration.java` for token generation and validation settings.

## API Endpoints

### Authentication

- `POST /api/authenticate` - Login and get JWT token
- `POST /api/register` - Register new user

### Courses

- `GET /api/courses` - List all courses
- `POST /api/courses` - Create new course (instructor only)
- `GET /api/courses/{id}` - Get course details
- `PUT /api/courses/{id}` - Update course (instructor only)
- `DELETE /api/courses/{id}` - Delete course (instructor only)

### Sessions & Enrollment

- `GET /api/sessions` - List available sessions
- `POST /api/sessions/{id}/enroll` - Enroll in session
- `GET /api/enrollments` - Get student enrollments

## Security

- All endpoints (except `/api/authenticate` and `/api/register`) require valid JWT token
- Passwords are stored as bcrypt hashes
- User activation via email key (optional)
- Password reset functionality available

## Development

### Running Tests

```bash
./mvnw test
```

### Code Style

Follow standard Java conventions. The project includes configuration for IDE formatting.

## Troubleshooting

### Database Connection Issues

- Verify MySQL service is running
- Check database URL, username, password in `application.yml`
- Ensure database exists and migrations are applied

### JWT Token Expired

- Tokens are valid for a configurable duration (default: typically 24 hours)
- Re-authenticate to get a new token

### Port Already in Use

- Default port is 8080. Change it in `application.yml`:

```yaml
server:
  port: 8081
```

## Contributing

1. Create a feature branch from `main`
2. Make your changes with clear commit messages
3. Test your changes
4. Submit a pull request

## License

[Your License Here]

## Contact & Support

For issues or questions, please contact the development team.

## Changelog

### v1.0.0 (March 11, 2026)
- Initial release
- Core learning domain entities
- User authentication with JWT
- Course management
- Session enrollment system
