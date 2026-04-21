# Microservicio simple - Citas Médicas (Semana 3)

Proyecto Spring Boot con datos en memoria y endpoints GET.

## Requisitos
- Java 17 o superior
- Maven

## Ejecutar
```bash
mvn spring-boot:run
```

## Endpoints
- GET `/api/citas`
- GET `/api/citas/{id}`
- GET `/api/citas/estado/{estado}`
- GET `/api/citas/fecha?fecha=2026-04-21`
- GET `/api/citas/horarios-disponibles?fecha=2026-04-21`

## Datos cargados
Se incluyen 8 citas médicas en memoria.
