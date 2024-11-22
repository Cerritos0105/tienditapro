-- Crear y usa base de datos
create database Punto_Venta;
use Punto_Venta;

-- drop database Punto_Venta;

-- Creación de Tablas de la base de datos
create table Empleados(
Id_Empleado			int				primary key 		auto_increment		not null,
Nombre			 	varchar(50)		not null,
Apellido			varchar(50)		not null,
Usuario			 	varchar(100)	not null,
Contrasena		 	varchar(100)	not null,
Ciudad			 	varchar(50)		not null,
Fecha_Nacimiento 	date			not null,
Cargo			 	varchar(50)		not null,
Foto			 	longblob,			
Telefono		 	char(10)		not	null
);

create table Categorias(
Id_Categoria		int				primary key			auto_increment		not null,
Nombre				varchar(50)		not null,
Descripción			varchar(100)	not null,
Imagen				longblob
);

create table Productos(
Id_Producto			int				primary key			auto_increment		not null,
Id_Categoria		int				not null,
Nombre				varchar(50)		not null,
Descripción			varchar(100)    not null,
Precio				decimal(10,2)   not null,
Imagen				longblob,
Existencia			int				not null,
foreign key Id_Categoria (Id_Categoria) references Categorias (Id_Categoria)
);

create table Ventas(
Id_Venta			int				primary key			auto_increment		not null,
Id_Empleado			int				not null,
Fecha_Venta			datetime		not null,
Caja				enum('1', '2')	not null,
Vendido				decimal(10, 2)	not null,
foreign key Id_Empleado (Id_Empleado) references Empleados (Id_Empleado)
);

create table Detalles_Ventas(
Id_Venta			int 			not null,
Id_Producto			int				not null,
Precio				decimal(10, 2)	not null,
Cantidad			int				not null,
Descuento			float			not null,
foreign key Id_Venta (Id_Venta) references Ventas (Id_Venta),
foreign key Id_Producto (Id_Producto) references Productos (Id_Producto) 	
);

-- Datos Empleados
insert into Empleados values(1, 'Juan Manuel', 'Lopez Almanza', sha1('J1M2L3A4'), sha1('Bloodborne2'), 'Yuriria', "2003-04-15", 'Cajero', LOAD_FILE('/home/jab0n/j.png'),'4452642417');
insert into Empleados values(2, 'Maria', 'Gomez Perez', sha1('M1G2P3M4'), sha1('Cinnamoroll'), 'Uriangato', "2004-07-25", 'Cajero', LOAD_FILE('/home/jab0n/j.png'),'4451649413');
insert into Empleados values(3, 'Fokin', 'Tercero', sha1('F1T2F3T4'), sha1('FokinFokin2'), 'Yuriria', "2020-12-10", 'Gerente', LOAD_FILE('/home/jab0n/j.png'),'4454327395');

-- Datos Categorias
insert into Categorias values(1, 'Bebidas', 'Liquidos que si se pueden tomer', LOAD_FILE('/home/jab0n/j.png'));
insert into Categorias values(2, 'Productos de Limpieza', 'Productos para realizar la limpieza del hogar', LOAD_FILE('/home/jab0n/j.png'));
insert into Categorias values(3, 'Medicinas', 'Medicinas que son casi lo mismo a las originales', LOAD_FILE('/home/jab0n/j.png'));

-- Datos Productos
insert into Productos values(1, 1, 'Coca-Cola_600ml', 'Aguita color petroleo', 22.53, LOAD_FILE('/home/jab0n/j.png'), 1);
insert into Productos values(2, 1, 'Epura_1l', 'Aguita color agua', 15.62, LOAD_FILE('/home/jab0n/j.png'), 1);
insert into Productos values(3, 2, 'Jabon para pisos', 'Jabon para limpiar superficies inferiores', 35.63, LOAD_FILE('/home/jab0n/j.png'), 1);
insert into Productos values(4, 2, 'Cloro', 'Aguita para limpiar pisos (No beber)', 30.57, LOAD_FILE('/home/jab0n/j.png'), 1);
insert into Productos values(5, 3, 'Parecetamol', 'Para curar TODO', 43.54, LOAD_FILE('/home/jab0n/j.png'), 1);
insert into Productos values(6, 3, 'Desenfriolito', 'Curar los problemas de los chamacos', 57.82, LOAD_FILE('/home/jab0n/j.png'), 1);