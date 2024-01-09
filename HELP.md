# Getting Started

Add the JVM argument -Dspring.profiles.active to activate corresponding profile.

## APIs

POST: http://localhost:8787/app/student

To create student.

SAMPLE REQUEST:
{
    "name": "ABC",
    "emailAddress": "abc@test.com",
    "phoneNumber" : 1234567890,
    "address" : "India"
}

POST:
To add courses to a student.
http://localhost:8787/app/education/1
SAMPLE REQUEST:
[
    {
        "courseId": 1,
        "name": "ECE"
    },
    {
        "courseId": 1,
        "name": "EEE"
    }
]

PUT:
To update courses to a student.
http://localhost:8787/app/education/1
[
    {
        "courseId": 3,
        "name": "Mechanical"
    },
    {
        "courseId": 4,
        "name": "Aeronautical"
    }
]
DELETE:
To delete a student
http://localhost:8787/app/education/1

GET:
To retrieve course assigned to a student
http://localhost:8787/app/education/1

POST:
http://localhost:8787/api/generateToken
To generate JWT tokens

SWAGGER UI:
http://localhost:8787/swagger-ui/index.html
http://localhost:8787/api-docs

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web.security)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

