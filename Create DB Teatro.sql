
DROP DATABASE Teatro;
CREATE DATABASE Teatro;
USE Teatro;

CREATE TABLE Cliente (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR(150),
  telefono VARCHAR(20),
  cedula VARCHAR(20),
  fecha_nacimiento DATE
);

CREATE TABLE Entidad (
  id_entidad INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  ruc VARCHAR(50),
  direccion VARCHAR(150),
  telefono VARCHAR(20),
  id_representante INT NOT NULL,
  FOREIGN KEY(id_representante) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Supervisor (
  id_supervisor INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR(150),
  telefono VARCHAR(20),
  cedula VARCHAR(20),
  fecha_nacimiento DATE
);

CREATE TABLE Evento (
  id_evento INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  fecha DATE,
  duracion INT,
  cantidad_personas INT
);

CREATE TABLE Servicio (
  id_servicio INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80),
  precio FLOAT
);

CREATE TABLE Venta_Boleto (
  id_venta_boleto INT PRIMARY KEY AUTO_INCREMENT,
  id_evento INT NOT NULL,
  fecha DATE,
  cantidad_boletos INT,
  FOREIGN KEY(id_evento) REFERENCES Evento(id_evento)
);

CREATE TABLE Salon (
  id_salon INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  capacidad INT,
  precio FLOAT
);

CREATE TABLE Empresa (
  id_empresa INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80),
  direccion VARCHAR(150),
  telefono VARCHAR(20)
);

CREATE TABLE Mantenimiento (
  id_mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
  id_salon INT NOT NULL,
  id_empresa INT NOT NULL,
  id_supervisor INT NOT NULL,
  tipo_mantenimiento VARCHAR(100),
  costo FLOAT,
  FOREIGN KEY(id_salon) REFERENCES Salon(id_salon),
  FOREIGN KEY(id_empresa) REFERENCES Empresa(id_empresa),
  FOREIGN KEY(id_supervisor) REFERENCES Supervisor(id_supervisor)
);

CREATE TABLE Detalle_Evento (
  id_evento INT NOT NULL,
  id_salon INT NOT NULL,
  precio_boleto FLOAT,
  porcent_teatro FLOAT,
  porcent_cliente FLOAT,
  precio_salon FLOAT,
  FOREIGN KEY(id_evento) REFERENCES Evento(id_evento),
  FOREIGN KEY(id_salon) REFERENCES Salon(id_salon),
  PRIMARY KEY(id_evento, id_salon)
);

CREATE TABLE Evento_Servicio (
  id_evento INT NOT NULL,
  id_servicio INT NOT NULL,
  precio FLOAT,
  foreign key(id_evento) references Evento(id_evento),
  foreign key(id_servicio) references Servicio(id_servicio),
  PRIMARY KEY(id_evento, id_servicio)
);
