# Microservicio Reservas Hotel

Microservicio desarrollado con Spring Boot para gestionar reservas de hotel.  
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

http://localhost:8081/api/reservas

Endpoints disponibles:

GET /api/reservas  
GET /api/reservas/{id}  
GET /api/reservas/estado/{estado}  
GET /api/reservas/ciudad/{ciudad}  
GET /api/reservas/fecha-entrada?fecha=2026-05-10  
POST /api/reservas  
PUT /api/reservas/{id}  
DELETE /api/reservas/{id}

## HATEOAS

Los endpoints principales devuelven enlaces HATEOAS mediante el atributo `_links`.

## Base de datos

El script de base de datos se encuentra en:

../bd_reservas_hotel.sql

Tabla utilizada:

RESERVAS_HOTEL

## Comandos principales

Ejecutar pruebas unitarias:

mvn clean test

Generar archivo JAR:

mvn clean package

Ejecutar localmente:

mvn spring-boot:run

## Docker

Este microservicio incluye un Dockerfile.  
Desde la carpeta raíz del proyecto general se puede levantar junto al microservicio de citas médicas con:

docker compose up

## Puerto

8081