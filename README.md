# SpringBoot-Microservices-OAuth2-Docker-Example
This is an example of creating microservices by using SpringBoot, Spring Cloud Gateway, Spring Cloud Eureka Discovery Server, Cloud Foundry UAA OAuth2 Server, PostgreSQL and Docker-Compose




## Environmnet Requirement:

 Java 8+ 
 
 Docker
 
 Eclipse
 

## Create and Run the docker images:

 * docker-compose build
 
 * docker-compose up

## URLs:

Eureka Discovery: http://localhost:8083

Gateway: http://localhost:8080

### Username and password for UAA OAuth2 Authorization:

user1/password


### Microservices Endpoints:

http://localhost:8080/api1/items/1

http://localhost:8080/api1/items/2


http://localhost:8080/api2/items/all
