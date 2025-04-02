-- Crear la base de datos
CREATE DATABASE empresa;

-- Usar la base de datos creada
USE empresa;

-- Crear la tabla empleados
CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(100),
    salario DOUBLE
);
