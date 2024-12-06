Nombre: Miguel Antonio Polanco Hurtado
Matricula: 100532563
Sistema CRUD/ORM para Sakila Database
Descripción del Proyecto
Este proyecto implementa un sistema CRUD/ORM en Java para gestionar la base de datos Sakila, un modelo de datos para un sistema de renta de películas. Utiliza una arquitectura orientada a objetos y conexión a la base de datos mediante JDBC, proporcionando una solución escalable y fácil de mantener para manejar entidades relacionadas.
Características
•	Conexión a MySQL: Gestión de conexiones mediante una clase genérica (DatabaseConnection).
•	Modelo Orientado a Objetos: Representación de tablas como clases en Java, con soporte para claves foráneas mediante agregación.
•	Operaciones CRUD: Soporte completo para crear, leer, actualizar y marcar como inactivos registros en la base de datos.
•	Gestión de Relaciones: Manejo de claves foráneas mediante referencias a objetos relacionados.
•	Exportación de Datos: Soporte para exportar datos a formatos CSV y JSON.
•	Arquitectura Modular: Diseño basado en gestores por tabla para facilitar la escalabilidad.
Requisitos
•	Java 11 o superior
•	MySQL Server y MySQL Workbench
•	Base de datos Sakila instalada (incluida con MySQL Full).
•	IDE (Eclipse, IntelliJ IDEA, etc.)
•	Git para la gestión del código fuente.
Instalación y Configuración
1. Configurar la base de datos Sakila
1.	Instala MySQL Server y asegúrate de incluir la base de datos de ejemplo Sakila.
2.	Verifica la instalación ejecutando una consulta simple desde MySQL Workbench
Configurar el proyecto en Java
1.	Clona este repositorio
2.	 Importa el proyecto en tu IDE preferido.
3.	Asegúrate de configurar las credenciales de conexión en la clase 
DatabaseConnection


Estructura del Proyecto

src/
├── com.sakila.controllers/
│   ├── ActorController.java
├── com.sakila.data /
│   ├── ActorDataPost.java
        DatabaseConnection.java
        DataContext.java
        FilmDataPost.java
        IDataPost.java
        RentalDataPost.java
├── Com.sakila.entity/
│   └── Actor.java
        Customer.java
        Film.java
        Rental.java
          com.sakila.models
  Actor.java
  Report.java
    com.sakila.reports
       ReportGenerator.java
       reports/Statistics.java

└── com.sakila1
      ConsoleUI.java
      Main.java

Tecnologías Usadas
•	Java: Lenguaje principal del proyecto.
•	JDBC: Para la conexión con la base de datos.
•	MySQL: Base de datos subyacente.
•	Javadoc: Para la generación de documentación de la API

Diagrama UML:

doc/Diagrama UML.png
