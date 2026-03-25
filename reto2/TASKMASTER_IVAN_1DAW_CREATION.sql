-- ================================================================== --
-- SCRIPT DE CREACIÓN DE BASE DE DATOS: TASKMASTER_IVAN_1DAW_CREATION --
-- ================================================================== --

-- --------------------------------- --
-- 0. Limpieza y Creacion de la BBDD --
-- --------------------------------- --
DROP DATABASE IF EXISTS TASKMASTER_IVAN_1DAW_CREATION;
CREATE DATABASE TASKMASTER_IVAN_1DAW_CREATION CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE TASKMASTER_IVAN_1DAW_CREATION;

DROP USER IF EXISTS 'taskmaster_backend'@'localhost';
CREATE USER 'taskmaster_backend'@'localhost' IDENTIFIED BY 'PasswordSegura123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON TASKMASTER_IVAN_1DAW_CREATION.* TO 'taskmaster_backend'@'localhost';
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS Tareas;
DROP TABLE IF EXISTS Usuarios;
DROP TABLE IF EXISTS Categorias;
DROP TABLE IF EXISTS Estados;

-- ------------------------------------ --
-- 1. Creación de tablas independientes --
-- ------------------------------------ --
CREATE TABLE Estados (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255)
);

-- --------------------------------- --
-- 2. Creación de la tabla principal --
-- --------------------------------- --
CREATE TABLE Tareas (
    id_tarea INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_creacion DATE NOT NULL,
    fecha_limite DATE NOT NULL,
    observaciones TEXT,
    id_usuario INT NOT NULL,
    id_categoria INT NOT NULL,
    id_estado INT NOT NULL,
    
    CONSTRAINT fk_tarea_usuario FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) ON DELETE CASCADE,
    CONSTRAINT fk_tarea_categoria FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria) ON DELETE RESTRICT,
    CONSTRAINT fk_tarea_estado FOREIGN KEY (id_estado) REFERENCES Estados(id_estado) ON DELETE RESTRICT
);