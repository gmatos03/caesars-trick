Caesar's Trick

The purpose of this application is to use Julius Caesar's cryptography to encrypt and decrypt plain text.

Run Spring Boot app using Maven:

mvn spring-boot:run

Run Spring Boot app with java -jar command:

java -jar target/mywebserviceapp-0.0.1-SNAPSHOT.jar

Usage:

Postman settings:

POST method
raW data
JSON format

localhost:8080/api/v1/caesarstrick/cypher

{
    "request": "123Testing"
}

{
    "response": "123whvwlqj"
}


localhost:8080/api/v1/caesarstrick/decypher

{
    "request": "123whvwlqj"
}

{
    "response": "123testing"
}