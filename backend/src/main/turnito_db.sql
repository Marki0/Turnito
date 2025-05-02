-- Crear base de datos
CREATE DATABASE IF NOT EXISTS turnito_db;
USE turnito_db;

-- Tabla Usuario
CREATE TABLE Usuario (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    DNI VARCHAR(20) UNIQUE
);

-- Tabla Administrador
CREATE TABLE Administrador (
    ID INT PRIMARY KEY,
    sector VARCHAR(100),
    FOREIGN KEY (ID) REFERENCES Usuario(ID)
);

-- Tabla Solicitante
CREATE TABLE Solicitante (
    ID INT PRIMARY KEY,
    motivo TEXT,
    FOREIGN KEY (ID) REFERENCES Usuario(ID)
);

-- Tabla Profesional
CREATE TABLE Profesional (
    ID INT PRIMARY KEY,
    especialidad VARCHAR(100),
    matricula VARCHAR(50) UNIQUE,
    FOREIGN KEY (ID) REFERENCES Usuario(ID)
);

-- Tabla Servicio
CREATE TABLE Servicio (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    duracion INT, -- duración en minutos
    estado VARCHAR(50),
    horario VARCHAR(100)
);

-- Tabla Profesional_Servicio (relación muchos a muchos)
CREATE TABLE Profesional_Servicio (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    profesional_id INT NOT NULL,
    servicio_id INT NOT NULL,
    FOREIGN KEY (profesional_id) REFERENCES Profesional(ID),
    FOREIGN KEY (servicio_id) REFERENCES Servicio(ID)
);

-- Tabla Turno
CREATE TABLE Turno (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    estado VARCHAR(50),
    direccion VARCHAR(255),
    profesional_id INT NOT NULL,
    servicio_id INT NOT NULL,
    solicitante_id INT NOT NULL,
    FOREIGN KEY (profesional_id) REFERENCES Profesional(ID),
    FOREIGN KEY (servicio_id) REFERENCES Servicio(ID),
    FOREIGN KEY (solicitante_id) REFERENCES Solicitante(ID)
);
