# 📚 Biblioteca API

Una API REST para gestionar libros y autores, desarrollada con Spring Boot y MySQL.

---

## 🚀 Descripción Breve

Esta API permite realizar operaciones CRUD sobre libros y autores, incluyendo búsquedas filtradas y ordenación. Ideal para sistemas de gestión bibliotecaria o catálogos digitales.

**Características clave**:
- Relación autores-libros (`@OneToMany`/`@ManyToOne`)
- Búsqueda por título y año de publicación
- Ordenación personalizada
- Persistencia en MySQL

---

## 🛠️ Instrucciones para Ejecutar la API

### Requisitos Previos

- Java 17+
- MySQL instalado
- Maven

### Pasos de Configuración

1. **Crear base de datos MySQL**:

   ```sql
   CREATE DATABASE biblioteca_db;
   ```

2. **Configurar credenciales**  
   Edita el archivo `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

---

### ▶️ Ejecutar la Aplicación

```bash
# Clonar repositorio
git clone https://github.com/tu-usuario/biblioteca-api.git
cd biblioteca-api

# Compilar y ejecutar
mvn spring-boot:run
```

---

## 📡 Endpoints Principales

### 📘 Libros

- `GET    /api/v1/libros`          Listar todos los libros  
- `POST   /api/v1/libros`          Crear nuevo libro (JSON en cuerpo)  
- `GET    /api/v1/libros/buscar`   Búsqueda con filtros (`titulo`, `anio`, `sortBy`, `order`)

### ✍️ Autores

- `GET    /api/v1/autores`         Listar todos los autores  
- `POST   /api/v1/autores`         Crear nuevo autor (JSON en cuerpo)

---

## 🔍 Ejemplo de Uso

### Crear autor

```http
POST http://localhost:8080/api/v1/autores
Content-Type: application/json

{
    "nombre": "Isabel Allende",
    "nacionalidad": "Chilena"
}
```

### Crear libro vinculado

```http
POST http://localhost:8080/api/v1/libros
Content-Type: application/json

{
    "titulo": "La casa de los espíritus",
    "isbn": "978-0060531805",
    "anioPublicacion": 1982,
    "autor": {
        "id": 1
    }
}
```

### Buscar libros

```http
GET http://localhost:8080/api/v1/libros/buscar?titulo=espíritus&sortBy=anioPublicacion&order=desc
```

✅ La API estará disponible en: [http://localhost:8080](http://localhost:8080)

---

Este archivo README.md contiene:
1. Nombre del proyecto destacado  
2. Descripción concisa con funcionalidades clave  
3. Instrucciones de instalación paso a paso  
4. Ejemplos prácticos de uso  
5. Formato Markdown limpio y profesional  
6. Todos los requisitos solicitados por el usuario