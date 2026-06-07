# 🚗 Sistema de Gestión de Concesionario (Java + JDBC + MySQL)

Aplicación de consola desarrollada en Java que implementa operaciones CRUD sobre una base de datos MySQL utilizando JDBC y el patrón DAO. El sistema simula la gestión de un concesionario de coches.

---

## 📌 Descripción

Este proyecto permite gestionar la información de un concesionario mediante tres entidades principales:

- Empleados
- Clientes
- Coches

Incluye funcionalidades básicas de acceso a datos (CRUD) aplicando buenas prácticas como:
- Patrón DAO
- Separación de responsabilidades
- Gestión centralizada de la conexión a BD

---

## 🧱 Arquitectura del proyecto

El proyecto sigue una estructura en capas:

JavaMysql (main)
↓
DAO (EmpleadoDAO, ClienteDAO, CocheDAO)
↓
ConexionBD
↓
Base de datos MySQL


- **Modelos (POJO):** representan las tablas (`Empleado`, `Cliente`, `Coche`)
- **DAO:** contienen la lógica de acceso a datos (CRUD)
- **ConexionBD:** gestiona la conexión con la base de datos
- **Main (JavaMysql):** punto de entrada de la aplicación

---

## ⚙️ Tecnologías utilizadas

- ☕ Java SE
- 🗄️ MySQL
- 🔌 JDBC (Java Database Connectivity)
- 📦 MySQL Connector/J (archivo .jar)

---

## 🗃️ Base de datos

El sistema utiliza una base de datos con las siguientes tablas:

- `empleado`
- `cliente`
- `coche`

Cada tabla está representada por una clase Java y su correspondiente DAO.

---

## 🚀 Funcionalidades

- ✔️ Crear registros (INSERT)
- ✔️ Consultar registros (SELECT)
- ✔️ Actualizar datos (UPDATE)
- ✔️ Eliminar registros (DELETE)

---

## 🛠️ Instalación y ejecución

### Requisitos

- JDK 8 o superior  
- MySQL Server  
- Archivo `mysql-connector-java.jar`

---

## 📂 Estructura del proyecto
src/
 └── Paquete/   ← ✅ PAQUETE RAÍZ
      ├── modelo/
      │    ├── Empleado.java
      │    ├── Cliente.java
      │    └── Coche.java
      │
      ├── dao/
      │    ├── EmpleadoDAO.java
      │    ├── ClienteDAO.java
      │    └── CocheDAO.java
      │
      ├── conexion/
      │    └── ConexionBD.java
      │
      └── main/
           └── JavaMysql.java