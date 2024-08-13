CREATE DATABASE Panderia;

CREATE TABLE Funcionario (
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100),
    precio DOUBLE NOT NULL
);

CREATE TABLE Compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT,
    total DOUBLE NOT NULL,
    fecha datetime, 
    FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Compra_Producto (
    id_compra INT,
    id_producto INT,
    cantidad INT NOT NULL,
    PRIMARY KEY (id_compra, id_producto),
    FOREIGN KEY (id_compra) REFERENCES Compra(id_compra),
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);

USE Panaderia;
SELECT * FROM Funcionario;
SELECT * FROM Producto;
SELECT * FROM Compra;
SELECT * FROM Compra_Producto;
SELECT Compra.id_compra, 
       Compra.id_funcionario, 
	   Compra.total, 
	   Compra.fecha, 
       Compra_Producto.id_producto, 
	   Compra_Producto.cantidad,
       Compra_Producto.cantidad * Producto.precio precio_total,
       Producto.nombre
FROM Compra, Compra_Producto, Producto
WHERE Compra.id_compra = Compra_Producto.id_compra
AND Compra_Producto.id_producto = Producto.id_producto;
SELECT sysdate() FROM dual;