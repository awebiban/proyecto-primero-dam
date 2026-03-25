-- COMPROBAMOS QUE EL PRIMER ARCHIVO DE CREACION SE HAYA EJECUTADO
-- SI NO, CREAMOS BBDD Y TABLA NECESARIA PARA INSERCION INCIAL
CREATE DATABASE IF NOT EXISTS TASKMASTER_IVAN_1DAW_CREATION;
USE TASKMASTER_IVAN_1DAW_CREATION;

CREATE TABLE IF NOT EXISTS Estados (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- INSERT IGNORE -> Evita duplicados en insercion, si ya estan insertados
--                  ignora los value
INSERT IGNORE INTO Estados (nombre, descripcion) VALUES
('Pendiente', 'La tarea ha sido creada pero no se ha iniciado.'),
('En progreso', 'Se está trabajando activamente en la tarea.'),
('Completada', 'La tarea se ha finalizado correctamente.'),
('Cancelada', 'La tarea ha sido descartada y no se realizará.');