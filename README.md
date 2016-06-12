# spring-boot-rest
Example RESTful web service project using the following technologies:

1. Spring Boot - create an opinionated stand-alone Spring application
2. Jetty - embedded web server for hosting the web services
3. JPA - for persisting the domain objects
4. Flywaydb - in-memory database for running in development mode and integration testing
5. Swagger - self documenting REST APIs
6. Maven Checkstyle plugin - enforce coding standards at build time
7. Maven Enforcer plugin - enforce JDK 8+ and prevent JODA library dependency (use java.time instead)
8. TDD - Unit and Integration tests used to drive the design and implementation

## Coding Conventions
Based on the Google Java style guide [https://github.com/google/styleguide](https://github.com/google/styleguide) with a few tweaks:
- 4 char indents
- 140 char line length
- relaxed javadoc requirements
- allow some abbreviations e.g. IT, URL