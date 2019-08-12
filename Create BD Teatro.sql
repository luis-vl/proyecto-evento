DROP DATABASE Teatro;
CREATE DATABASE Teatro;
USE Teatro;

CREATE TABLE usuario
(
	id_usuario INT AUTO_INCREMENT,
    nombre_usario varchar(20),
    rol varchar(20),
    contrasena varchar(20),
    PRIMARY KEY(id_usuario)
);

INSERT INTO usuario (nombre_usario, rol, contrasena) 
	VALUES
    ('pepe', 'admin', '123'),
    ('maria', 'vendedor', '123');

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
  id_cliente INT NOT NULL,
  FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Supervisor (
  id_supervisor INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  direccion VARCHAR(150),
  telefono VARCHAR(20),
  cedula VARCHAR(20),
  fecha_nacimiento DATE,
  estado bool
);

CREATE TABLE Salon (
  id_salon INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  capacidad INT,
  precio FLOAT,
  estado bool
);

CREATE TABLE Evento (
  id_evento INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  nombre VARCHAR(80),
  fecha_registro DATETIME,
  fecha_evento DATETIME,
  duracion INT,
  cantidad_personas INT,
  id_salon INT NOT NULL,
  precio_boleto FLOAT,
  porcent_cliente FLOAT,
  porcent_teatro FLOAT,
  precio_salon FLOAT,
  foreign key(id_cliente) references Cliente(id_cliente),
  FOREIGN KEY(id_salon) REFERENCES Salon(id_salon)
);

CREATE TABLE Servicio (
  id_servicio INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(80),
  precio FLOAT,
  estado bool
);

CREATE TABLE Venta_Boleto (
  id_venta_boleto INT PRIMARY KEY AUTO_INCREMENT,
  id_evento INT NOT NULL,
  fecha DATE,
  cantidad_boletos INT,
  FOREIGN KEY(id_evento) REFERENCES Evento(id_evento)
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
  fecha_registro DATETIME,
  FOREIGN KEY(id_salon) REFERENCES Salon(id_salon),
  FOREIGN KEY(id_empresa) REFERENCES Empresa(id_empresa),
  FOREIGN KEY(id_supervisor) REFERENCES Supervisor(id_supervisor)
);

CREATE TABLE Evento_Servicio (
  id_evento INT NOT NULL,
  id_servicio INT NOT NULL,
  precio FLOAT,
  fecha_registro DATETIME,
  foreign key(id_evento) references Evento(id_evento),
  foreign key(id_servicio) references Servicio(id_servicio),
  PRIMARY KEY(id_evento, id_servicio)
);

/*INSERTANDO DATOS DE PRUEBA*/
/*tablas de catalogo*/
INSERT INTO cliente(nombre, apellido, direccion, telefono, cedula, fecha_nacimiento) 
	VALUES
    ('pedro','mendoza','la direccion de su casa', '78451265', '46464-65498-56asdf','1980-05-13'),
    ('juan','rivas','la direccion de su casa', '94222253', '46464h546951','1970-3-25'),
    ('jose','perez','la direccion de su casa', '98653245', 'ajgoofdga-56asdf','1960-12-30');
    
INSERT INTO entidad(nombre, ruc, direccion, telefono, id_cliente) 
	VALUES
    ('zumitos','asdf-4646444458', 'Calle altamira asdfasdf', '22568978', 1),
    ('blabla','qwer-4646444458', 'Calle altamira asdfasdf', '2535421', 3);
    
INSERT INTO salon(nombre, capacidad, precio, estado)
	VALUES
    ('sala 1',500,650,1),
    ('sala 2',600,750,0),
    ('sala 3',200,300,1);
    
INSERT INTO servicio(nombre, precio, estado) 
	VALUES
    ('tacos al pastor', 25.50, 1),
    ('parking', 10.50, 1),
    ('audio', 80, 1);

/*tablas de operacion*/

INSERT INTO evento(id_cliente, id_salon, nombre, fecha_registro, fecha_evento, duracion, 
	cantidad_personas, precio_boleto, porcent_cliente, porcent_teatro, precio_salon)
	VALUES
    (1, 2, 'Conferencia de asdf', current_timestamp(), '2019-10-20 12:20', 3, 200, 5, 0.6, 0.4, 300),
    (2, 2, 'Conferencia de asdf', current_timestamp(), '2019-11-20 14:20', 2, 150, 8, 0.8, 0.2, 320);
    
INSERT INTO evento_servicio(id_evento, id_servicio, precio, fecha_registro) 
	VALUES
    (1,1,30,current_timestamp()),
    (1,2,10,current_timestamp()),
    (2,3,80,current_timestamp());
    