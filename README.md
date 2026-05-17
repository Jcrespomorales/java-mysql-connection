# Java + MySQL (JDBC)

Proyecto base en Java para conectarse a MySQL usando JDBC y ejecutar operaciones SQL simples.

## Requisitos
- Java 8+ (recomendado Java 11 o superior)
- MySQL Server 5.7+ / 8.x
- Driver JDBC de MySQL (`mysql-connector-j`)

## Configuración de conexión
Define los siguientes parámetros:
- `host` (ej: `localhost`)
- `port` (ej: `3306`)
- `database`
- `user`
- `password`

URL JDBC típica:
`jdbc:mysql://<host>:<port>/<database>?useSSL=false&serverTimezone=UTC`

## Flujo técnico
1. Cargar/usar el driver JDBC de MySQL.
2. Crear `Connection` con `DriverManager.getConnection(...)`.
3. Ejecutar consultas con `PreparedStatement` para evitar inyección SQL.
4. Procesar resultados con `ResultSet`.
5. Cerrar recursos (`ResultSet`, `Statement`, `Connection`) usando *try-with-resources*.

## Buenas prácticas
- No hardcodear credenciales; usar variables de entorno.
- Manejar `SQLException` con mensajes técnicos claros.
- Validar conectividad y timeouts en ambiente local/producción.
