# EjemploSpring MVC

Aplicación web MVC con Spring Boot y Thymeleaf para gestionar **usuarios** y **artículos**, con validaciones, consultas parametrizadas, autenticación y recordatorio de clave por correo.

El login usa la tabla `usuarios` (cédula + clave). No se usa el usuario generado por Spring Security.

## Requisitos

| Herramienta | Versión |
|---|---|
| Java JDK | **17** |
| Maven | 3.9+ (o el wrapper/IDE) |
| PostgreSQL | 12+ (local o Azure) |
| Navegador | Cualquiera moderno |

También se usa:

- Spring Boot **4.1.1**
- Spring Web MVC + Thymeleaf
- Spring Data JPA
- Spring Security
- Spring Mail
- Lombok

## Configuración de base de datos

Edita `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://HOST:5432/ejercicio_articulo_spring?sslmode=require
spring.datasource.username=USER
spring.datasource.password=PASSWORD
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
````

Tablas esperadas:

* `usuarios` (PK `cedula`)
* `articulos` (PK `id`)

La aplicación **no** crea el esquema (`ddl-auto` no está en `update`). Las tablas deben existir antes de arrancar.

## Variables / propiedades necesarias

Puerto por defecto: `8080` (`server.port`).

### Correo (recordatorio de clave)

Gmail con verificación en dos pasos y **contraseña de aplicación** (no la clave de la cuenta):

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu_correo@gmail.com
spring.mail.password=xxxx xxxx xxxx xxxx
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

No subas contraseñas reales al repositorio.

## Cómo ejecutar

La aplicación ya se encuentra desplegada y disponible en **Azure Web App**, por lo que para probarla no es necesario realizar una instalación local.

### Acceso a la aplicación

Abrir:

https://app-ejemplospring-mjaller-hqa5hjgxerdrgef5.centralus-01.azurewebsites.net

La aplicación redirige a `/login`.

### Ejecución local

Si se desea ejecutar el proyecto localmente, desde la raíz del proyecto:

```bash
mvn spring-boot:run
```

O en el IDE: ejecutar `EjemploSpringApplication`.

Abrir:

http://localhost:8080

## Cómo probar

### Credenciales de acceso

Para ingresar a la aplicación desplegada:

* **Cédula:** `123456789`
* **Contraseña:** `Abcde*`

### Funcionalidades principales

1. **Login:** ingresar con las credenciales indicadas.
2. **Menú:** acceder a Gestionar Usuarios, Gestionar Artículos y Cerrar Sesión.
3. **CRUD usuarios:** crear, consultar, actualizar y eliminar usuarios.
4. **Consultas usuarios:** realizar búsquedas por nombre y por email.
5. **CRUD artículos:** crear, consultar, actualizar y eliminar artículos.
6. **Consultas artículos:** realizar búsquedas por marca y por categoría.
7. **IVA:** verificar que el IVA se calcule automáticamente al **19 % del precio de venta**.
8. **Recordatorio de clave:** desde el login seleccionar *Olvidé mi clave* e ingresar el email exacto de un usuario registrado.
9. **Acceso:** `/login` y `/recuperar` son las rutas públicas. El resto de funcionalidades requiere iniciar sesión.

## Despliegue

La aplicación está publicada en **Microsoft Azure Web App** y puede ser accedida directamente desde Internet:

https://app-ejemplospring-mjaller-hqa5hjgxerdrgef5.centralus-01.azurewebsites.net
