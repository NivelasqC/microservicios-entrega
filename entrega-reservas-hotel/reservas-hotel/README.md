# reservas-hotel-semana6

Microservicio Spring Boot conectado a Oracle para la tabla `RESERVAS_HOTEL`.

## Antes de ejecutar
1. Cambiar `TU_PASSWORD` en `src/main/resources/application.properties`
2. Verificar que Oracle tenga creada la tabla `RESERVAS_HOTEL`
3. Ejecutar:

```bash
mvn clean compile
mvn spring-boot:run
```

## Endpoints
- GET `/api/reservas`
- GET `/api/reservas/{id}`
- GET `/api/reservas/estado/{estado}`
- GET `/api/reservas/ciudad/{ciudad}`
- GET `/api/reservas/fecha-entrada?fecha=2026-05-01`
- POST `/api/reservas`
- PUT `/api/reservas/{id}`
- DELETE `/api/reservas/{id}`
