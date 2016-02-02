public class Ejercicio01 {

	public static void main(String[] args) {

		/*
		 * 1. Realizar el modelo entidad-relación de una base de datos objeto-relacional para una tienda 
		 * de productos informáticos. Queremos almacenar la siguiente información:
		 * • Cliente:
		 * 	➢ idCliente
		 * 	➢ nombre
		 * 	➢ nif
		 * 	➢ direccion: compuesta por los siguientes campos:
		 * 		✔ calle
		 * 		✔ número
		 * 		✔ población: compuesta por los siguientes campos:
		 * 			• población
		 * 			• provincia: compuesta por los siguientes campos:
		 * 				◦ provincia
		 * 				◦ comunidad autónoma
		 * 			• país
		 * 		✔ codPostal
		 * 	➢ lista de teléfonos. Cada teléfono está compuesto por los siguientes campos:
		 * 		✔ tipo: fijo_trabajo, movil_trabajo,fijo_personal,movil_personal
		 * 		✔ número de teléfono: compuesto por los siguientes campos:
		 * 			• prefijo del país. Ejemplo: 34 para España
		 * 			• número de teléfono
		 * 
		 * • Venta:
		 * 	➢ idVenta
		 * 	➢ fechaVenta
		 * 	➢ facturada (boolean)
		 * 
		 * • LineasVenta: nos indica la venta de un producto concreto
		 * 	➢ idVenta y numeroLinea como claves primaria
		 * 	➢ cantidad de productos comprados
		 * 
		 * • Producto:
		 * 	➢ idProducto
		 * 	➢ descripción
		 * 	➢ pvp (precio de venta al público)
		 * 	➢ stockActual
		 * 	➢ imagen del producto (BLOB)
		 * 	➢ página web del producto (CLOB)
		 */
		
		/*
			CREATE TYPE t_provincia AS (
				provincia VARCHAR(20),
				comunidad VARCHAR(20)
			);

			CREATE TYPE t_numero AS (
			prefijo INTEGER,
			numero INTEGER
			);

			CREATE TYPE t_telefono AS (
			tipo VARCHAR(10),
			numero t_numero
			);

			CREATE TABLE poblacion (
				poblacion VARCHAR(50),
				provincia t_provincia,
				pais VARCHAR(10)
			);

			CREATE TYPE t_direccion AS (
				calle VARCHAR(30),
				numero INTEGER,
				cp INTEGER,
				poblacion poblacion
			);

			CREATE TABLE producto(
				id_producto INTEGER PRIMARY KEY,
				descripcion VARCHAR(300),
				pvp INTEGER,
				stock INTEGER,
				imagen BYTEA,
				web TEXT
			);

			CREATE TABLE venta (
				id_venta INTEGER PRIMARY KEY,
				fecha_venta DATE,
				facturada BOOLEAN
			);

			CREATE TABLE lineas_venta (
				id_venta INTEGER,
				numero_linea INTEGER,
				cantidad INTEGER,
				CONSTRAINT lineas_venta_pk PRIMARY KEY (id_venta, numero_linea),
				CONSTRAINT fk_lineasventa_producto FOREIGN KEY (numero_linea)
				REFERENCES producto (id_producto) MATCH SIMPLE
			);

			CREATE TABLE cliente (
				id_cliente INTEGER PRIMARY KEY,
				nombre VARCHAR(30),
				nif VARCHAR(9),
				direccion t_direccion,
				telefonos t_telefono ARRAY
			);
		*/

	}

}
