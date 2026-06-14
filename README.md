# 📋 TaskMaster - Proyecto Final 1º DAM

**Autor:** Iván
**Curso:** 1º Desarrollo de Aplicaciones Multiplataforma (DAM)
**Fecha:** Junio 2026

## 🚀 ¿Qué es TaskMaster?
TaskMaster es una aplicación de gestión de tareas por consola (con una propuesta de interfaz web) diseñada para ayudar a los usuarios a organizar su día a día. Permite crear tareas, asignarlas a categorías, ponerles fecha límite y cambiar su estado (Pendiente, En Progreso, Completada, Cancelada).

## 🛠️ Módulos y Tecnologías utilizadas
Este proyecto integra todos los conocimientos aprendidos durante el curso:

* **Bases de Datos:** Diseño del modelo Entidad-Relación y script SQL en MySQL con claves foráneas.
* **Entornos de Desarrollo:** Diseño de diagramas de clases UML, control de versiones con Git/GitHub, pruebas unitarias con JUnit 5 y generación de Javadoc.
* **Programación:** Desarrollo backend en Java puro utilizando el patrón DAO, conexión JDBC a la base de datos y programación orientada a objetos (POO).
* **Lenguajes de Marcas:** Creación de una interfaz web estática responsiva usando HTML5, CSS3, Flexbox y Bootstrap (Inspirada en JetBrains YouTrack).
* **IPE I:** Análisis de riesgos laborales y técnicos durante el desarrollo del proyecto y medidas de prevención.

## ⚙️ Cómo ejecutar el proyecto

Al clonar este repositorio, te descargarás el histórico completo de los retos del curso. Para evaluar la versión final y funcional del proyecto, sigue estos pasos:

1. **Clonar el repositorio:** `git clone [URL_DE_TU_REPOSITORIO]`
2. **Base de Datos:** Ve a la carpeta `/reto2`. Allí encontrarás el script SQL (`.sql`). Ejecútalo en tu servidor MySQL para crear la base de datos y las tablas.
3. **Configuración de Java:** Abre la carpeta `/reto6` en tu IDE (Eclipse, VS Code, IntelliJ), ya que contiene la **versión final y mejorada** del código. Asegúrate de configurar tus credenciales de MySQL en el archivo `application.properties`.
4. **Ejecución del Backend:** Dentro de `/reto6`, ejecuta la clase principal (`Main.java` o la clase que contenga el método *main*) para iniciar el menú por consola.
5. **Visualización del Frontend:** Si deseas ver la propuesta de la interfaz gráfica, ve a la carpeta `/reto5` y abre el archivo `index.html` directamente en cualquier navegador web.

---

## 📂 Estructura de entrega del Repositorio

El proyecto está dividido en carpetas según la evolución de los retos del curso:

* **`/reto1`**: Definición inicial y casos de uso.
* **`/reto2`**: Diseño de la base de datos (Modelo E/R, Relacional y script SQL).
* **`/reto3`**: Diagramas de clases (UML) iniciales.
* **`/reto4`**: Proyecto base en Java (Primera iteración del código y conexión JDBC).
* **`/reto5`**: Vistas básicas de la interfaz web (HTML, CSS y Bootstrap).
* **`/reto6`**: **VERSIÓN FINAL DEL CÓDIGO.** Contiene el proyecto Java refactorizado, optimización de consultas SQL, pruebas unitarias (JUnit) y la documentación técnica (Javadoc).
* **`/reto7`**: Análisis de riesgos laborales y técnicos durante el desarrollo del proyecto.
* **`/reto8`**: Creación de este archivo MarkDown para la representación de todo el trabajo realizado en este proyecto.
* **`/AWS`**: Pruebas y configuraciones relacionadas con despliegues en la nube.
