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
```

Tablas esperadas:

- `usuarios` (PK `cedula`)
- `articulos` (PK `id`, FK `usuario_cedula` → `usuarios.cedula`)

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

Desde la raíz del proyecto:

```bash
mvn spring-boot:run
```

O en el IDE: ejecutar `EjemploSpringApplication`.

Abrir: [http://localhost:8080](http://localhost:8080)

Redirige a `/login`.

## Cómo probar

1. **Login:** cédula (`username`) y clave (`password`) de un registro en `usuarios`.
2. **Menú:** Gestionar Usuarios, Gestionar Articulos, Cerrar Sesión.
3. **CRUD usuarios:** `/usuarios` — agregar, editar, eliminar. Validación de campos vacíos y formato de email.
4. **Consultas usuarios:** por nombre y por email (coincidencias parciales).
5. **CRUD artículos:** `/articulos` — agregar, editar, eliminar. El IVA se calcula al 19 % del precio de venta.
6. **Consultas artículos:** por marca y por categoría.
7. **Recordatorio de clave:** en login → *Olvidé mi clave* → email **exacto** de un usuario. Llega un correo con asunto `Recuperación de Contraseña`.
8. Rutas públicas: `/login`, `/recuperar`. El resto exige sesión.

## Estructura breve

```
src/main/java/.../EjemploSpring/
  controladores/     MVC (vistas HTML, no REST)
  servicio/
  dao/               Spring Data + @Query
  modelo/            Usuario, Articulo
src/main/resources/
  templates/         Thymeleaf
  messages.properties
  application.properties
```
