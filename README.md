# Proyecto de Consulta de Tipo de Cambio - Backend

Este proyecto consiste en la parte backend de una aplicación que permite consultar el tipo de cambio actual utilizando Spring Boot. El backend se conecta a un servicio SOAP para obtener el tipo de cambio y lo expone mediante un endpoint REST. Los datos se almacenan en una base de datos MySQL.

## Estructura del Proyecto

- **Backend**: Spring Boot, se conecta a un servicio SOAP para obtener el tipo de cambio y lo almacena en una base de datos MySQL.

## Tecnologías

- **Java**
- **Spring Boot**
- **MySQL**
- **SOAP**

## Requisitos

- **Java 11** o superior.
- **MySQL**.
- **Maven** (para gestionar las dependencias del backend).

---

## Configuración del Backend

### 1. Clonar el Repositorio

Clona el repositorio en tu máquina local.

```bash
git clone https://github.com/tu-usuario/proyecto-tipo-cambio.git
cd proyecto-tipo-cambio/backend
```

### 2. Configuración de la Base de Datos MySQL

Crea una base de datos en MySQL para almacenar las consultas del tipo de cambio.

### 3. Ejecutar el Backend

Desde el directorio backend, compila y ejecuta la aplicación:

```bash
mvn spring-boot:run
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

### Endpoint

- **GET** [http://localhost:8080/api/tipoCambio/actual](http://localhost:8080/api/tipoCambio/actual): Obtiene el tipo de cambio actual en formato JSON.

## Funcionalidades

- **Consultar tipo de cambio**: Realiza una solicitud SOAP a un servicio externo para obtener el tipo de cambio y lo almacena en MySQL.
- **Endpoint REST**: Exposición de un endpoint REST para obtener la última consulta del tipo de cambio.

## Notas Adicionales

### Configuración CORS en el Backend

Para permitir que el frontend de React se comunique con el backend, asegúrate de tener CORS configurado en el backend.

En `src/main/java/com/ejemplo/TipoCambioBackend/config/WebConfig.java`:

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:3000"); // Ajusta según tu configuración
    }
}
```

## Contribuciones

Este proyecto está abierto a contribuciones. Si deseas mejorar alguna funcionalidad o agregar una nueva, no dudes en hacer un fork del repositorio y enviar un pull request.

## Licencia

