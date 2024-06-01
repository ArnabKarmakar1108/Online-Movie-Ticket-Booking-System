# Online-Movie-Ticket-Booking-System

This is a web application built with the Spring Boot framework that enables users to book movie tickets online effortlessly. The application adheres to SOLID design principles and employs design patterns such as Facade, Singleton, and Template.

## Features

* User registration/login through the app.
* Users can search for cinema halls in their city and book tickets for movies.
* Admins can add, remove, and update movie and cinema hall details.

## Technologies Used

* Backend: Spring Boot (Java) with Hibernate
* Frontend: JSP
* Database: MySQL
* Build Tool: Maven

## Prerequisites

* JDK 11 or higher
* MySQL database
* Maven

## Setup Guide
### Step 1: Configure the Database

1. Create a MySQL database named movie_ticket_booking.

2. Configure the file `application.properties`:
```yaml
#Database Configrations
spring.datasource.url=jdbc:mysql://localhost:3306/movieTicketSpb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=your_database_password
spring.jpa.database-platform = org.hibernate.dialect.MySQL8Dialect
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto = update

#context Path 
server.servlet.context-path=/Movie-Ticket
```

### Step 2: Set Up Dependencies
Ensure that your `pom.xml` file includes the necessary dependencies.

### Step 3: Run Movie-Ticket.sql for Database Setup

Run the `Movie-Ticket.sql` file in your MySQL database to set up the initial database schema and insert sample data. You can do this using a MySQL client or command line.

Run the following command in your command prompt after navigating to the project directory
`mysql -u your_username -p movieTicketSpb < Movie-Ticket.sql`

### Step 4: Install Dependencies
Navigate to the project directory and run the following command to install the dependencies:

`mvn install`

### Step 5: Run the Application
1. Navigate to the Project Directory:
Open a terminal or command prompt and navigate to the Movie-ticket directory of your project:

`cd path/to/your/project`

2. Run the Application:
Use Maven to run the Spring Boot application:

`mvn spring-boot:run`

### Step 6: Access the Application
Once the application is running, open your web browser and go to:

`http://localhost:8080/Movie-Ticket/`

### Additional Commands

* To clean and build the project:
`mvn clean install`

* To package the application as a WAR file:
`mvn clean package`

### Admin Setup
Since admin details cannot be created through the application interface, you must manually add admin details directly to the database. Here is an example SQL query to insert an admin user:

```sql
INSERT INTO m_user (created_by, created_datetime, modified_by, modified_datetime, first_name, last_name, login, mobile_no, password, role_id) 
VALUES 
('admin', NOW(), 'admin', NOW(), 'Admin', 'User', 'admin@example.com', '1234567890', 'admin_password', 1);
```

### Interface Preview

#### Landing Page
![Landing Page](https://github.com/ArnabKarmakar1108/Online-Movie-Ticket-Booking-System/blob/main/Movie-ticket/images/landing_page.png?raw=true)

#### Theater List
![Theater List](https://github.com/ArnabKarmakar1108/Online-Movie-Ticket-Booking-System/blob/main/Movie-ticket/images/Theater%20List.png?raw=true)

#### Movies List
![Movies List](https://github.com/ArnabKarmakar1108/Online-Movie-Ticket-Booking-System/blob/main/Movie-ticket/images/Movie%20List.png?raw=true)





