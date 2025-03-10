# Task's description

Implement application which will serve REST API requests. Application should be
able to handle two requests.
One public endpoint which should accept as an input information about a square and a
line and return information where and if these two objects intersect
The second endpoint should be protected with username/password and should return
information about how many requests are currently being processed by the application.

Deliveries must include:
 source code in git repository
 instructions on how to launch the application
 architectural overview of the application and motivation behind components/libraries used

# Instructions on how to launch the application

Run the application with `./gradlew bootRun`

The application is written in Java 19.

The application can be accessed at http://localhost:8080/,
main endpoints being http://localhost:8080/secure/requests/count and
http://localhost:8080/public/intersections . You can use curl or Postman to test the endpoints.

I have added a deeper/src/main/resources/example-request.json
and deeper/src/main/resources/example-response.json
files which can be used for testing the http://localhost:8080/public/intersections.

# Architectural overview and motivation behind components/libraries used

The application is built on top of Spring Boot and uses Spring Security for authentication.

The main components of the application are:

- `IntersectionService`: responsible for checking if the square and line intersect
- `RequestCounterService`: responsible for saving and retrieving the number of requests being processed
- `CustomUserDetailsService`: responsible for retrieving the user's credentials from the database

The application uses the following libraries:

- `org.springframework.boot:spring-boot-starter-web` - webflux could be used instead, but
- I saw no reason to use reactive approach in this task
- `org.springframework.boot:spring-boot-starter-security` - used for authentication
- `org.springframework.boot:spring-boot-starter-data-jpa` - used for database access
- `com.h2database:h2` - lightweight in-memory database
- `org.springframework.boot:spring-boot-starter-validation` - used for validation
- 'org.springframework.security:spring-security-crypto' - used for password encryption
- 'org.projectlombok:lombok' - used for code generation
-

# Notes

I tried to use jts-core:1.18.2 for geometry operations, but it seemed to return faulty results.
I also started writing a jwt issuer for authentication, but after some consideration decided it was
an overkill and stuck with basic authentication.
I know some people dislike lombok, but I like this library, so I'm using it.