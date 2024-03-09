# Getting Started

When you first start in the console you will see the **bearer token** for the following accounts:

`ADMIN` - has access to every controllers

`USER` - only to users

`POST` - only to posts

`ALBUM` - only to albums

**Use that token for any requests**

Don't forget to connect your database in `application.propertires`
```properties
# Database url
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/vkinternship
# Login username of the database.
spring.datasource.username=postgres
# Login password of the database.
spring.datasource.password=root
```

### Controllers

- localhost:8080/users/
- localhost:8080/posts/
- localhost:8080/albums/
- localhost:8080/auth/

Examples:
```http request
### Register user
POST localhost:8080/users/
Authorization: Bearer {{auth-token}}
Content-Type: application/json
{
    "website": "hildegard.org",
    "address": {
        "zipCode": null,
        "geo": {
            "lng": "81.1496",
            "lat": "-37.3159"
        },
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "street": "Kulas Light"
    },
    "phone": "1-770-736-8031 x56442",
    "name": "Leanne Graham",
    "company": {
        "bs": "harness real-time e-markets",
        "catchPhrase": "Multi-layered client-server neural-net",
        "name": "Romaguera-Crona"
    },
    "email": "Sincere@april.biz",
    "username": "Bret"
}

### Get all users
GET localhost:8080/users/
Authorization: Bearer {{auth-token}}

### Get user by id
GET localhost:8080/users/{{id}}
Authorization: Bearer {{auth-token}}

### Delete user
DELETE  localhost:8080/users/{{id}}
Authorization: Bearer {{auth-token}}

### Edit user
PUT localhost:8080/users/{{id}}
Authorization: Bearer {{auth-token}}
Content-Type: application/json
{
    "website": "hildegard.org",
    "email": "Sincere@april.biz",
    "username": "Bret"
}
```

### Used tools

* [Gradle](https://docs.gradle.org)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/3.2.3/gradle-plugin/reference/html/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web.reactive)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.2.3/reference/htmlsingle/index.html#data.sql)