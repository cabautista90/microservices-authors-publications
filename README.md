# microservices-authors-publications
Aplicación de microservicios para gestión de autores y publicaciones

## Descripción
Proyecto académico desarrollado para la asignatura Arquitectura de Software.
La solución implementa una arquitectura basada en microservicios para la gestión
de autores y publicaciones en una editorial digital.

## Arquitectura
- Microservicio de Autores (Spring Boot)
- Microservicio de Publicaciones (Spring Boot)
- Frontend Web (React + Material UI)
- Base de datos MySQL por microservicio
- Comunicación REST síncrona
- **BPMN**: Modelo de proceso de negocio (Camunda)

## Estructura del Proyecto
/authors-service
/publications-service
/frontend
/bpmn
docker-compose.yml
README.md
## Tecnologías
- Java + Spring Boot
- MySQL
- React
- Material UI
- Docker (fase final)
- Camunda Modeler (BPMN)

## 🔄 BPMN

El proceso BPMN modela:
1. Registro de autor
2. Validación
3. Persistencia
4. Registro de publicación
5. Persistencia

## ▶️ Ejecución

##MICROSERVICIO AUTHORS

cd authors-service

mvn clean

mvn spring-boot:run

##MICROSERVICIO PUBLICATIONS

cd publications-service
mvn clean
mvn spring-boot:run

Frontend:
```bash
npm install
npm run dev
