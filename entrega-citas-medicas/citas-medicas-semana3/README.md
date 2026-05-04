# Microservicio Citas Médicas

Microservicio desarrollado con Spring Boot para gestionar citas médicas.  
El proyecto usa Oracle XE como base de datos, incluye endpoints REST, respuestas con HATEOAS, pruebas unitarias con JUnit y ejecución mediante Docker.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- Oracle XE 21c
- Maven
- JUnit 5
- Mockito
- Spring HATEOAS
- Docker

## Endpoints principales

Base URL:

http://localhost:8080/api/citas

Endpoints disponibles:

GET /api/citas  
GET /api/citas/{id}  
GET /api/citas/estado/{estado}  
GET /api/citas/fecha?fecha=2026-05-10  
GET /api/citas/disponibles?fecha=2026-05-10  
POST /api/citas  
PUT /api/citas/{id}  
DELETE /api/citas/{id}

## HATEOAS

Los endpoints principales devuelven enlaces HATEOAS mediante el atributo `_links`.

## Base de datos

El script de base de datos se encuentra en:

../bd_citas_medicas.sql

Tabla utilizada:

CITAS_MEDICAS

## Comandos principales

Ejecutar pruebas unitarias:

mvn clean test

Generar archivo JAR:

mvn clean package

Ejecutar localmente:

mvn spring-boot:run

## Docker

Este microservicio incluye un Dockerfile.  
Desde la carpeta raíz del proyecto general se puede levantar junto al microservicio de reservas con:

docker compose up

## Puerto

8080
