# Product Data Management System (PDMS)

This is a simple Spring Boot web application connected to PostgreSQL.

## Requirements

- Java 17
- Maven
- PostgreSQL
- pgAdmin (optional)

## PostgreSQL setup

Create a database named:

```text
pdms
```

Default connection used by this project:

```text
Host: localhost
Port: 5432
Database: pdms
Username: postgres
```

Open `src/main/resources/application.properties` and replace:

```properties
spring.datasource.password=YOUR_POSTGRES_PASSWORD
```

with your PostgreSQL password.

## Run the project

From the project folder, run:

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## Login

```text
Username: admin
Password: admin123
```

## Database tables

When the application starts, Hibernate creates/updates these tables automatically:

- `parts`
- `documents`
- `manufacturers`
- `manufacturer_parts`

Data added through the website is stored in PostgreSQL and remains after the application is restarted.

## Main flow

```text
HTML + CSS
    ↓
Controller
    ↓
Service
    ↓
JPA Repository
    ↓
PostgreSQL
```

## Simple automatic numbers

The application generates simple numbers automatically. You do not enter these numbers in the forms.

- Parts: `100`, `101`, `102`, ...
- Documents: `200`, `201`, `202`, ...
- Manufacturers: `300`, `301`, `302`, ...
- Manufacturer Parts: `400`, `401`, `402`, ...

The next number is calculated from the existing records in PostgreSQL, so the numbering continues after restarting the application.
