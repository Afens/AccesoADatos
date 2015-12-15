package jsonJdbc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Ejer1_1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root");
			Statement sentencia = connection.createStatement();
			File ruta=new File("src\\jsonJdbc\\salida.json");
			FileWriter salida= new FileWriter(ruta);
			ArrayList<DatosSelect> filas = new ArrayList<DatosSelect>();
			Gson conversor=new Gson();
			ResultSet rs = sentencia.executeQuery(
					"SELECT p.codProf, p.nombre, p.fechaDeNacimiento, c.codOe, c.codCurso, count(r.codAsignatura) "
							+ "FROM profesor p,reparto r LEFT JOIN curso c on tutor=codProf "
							+ "WHERE p.codProf=r.codProf GROUP BY p.codProf;");

			while (rs.next()) {
				filas.add(new DatosSelect(rs.getString(1), rs.getString(2), rs.getDate(3),
						rs.getString(4), rs.getString(5), rs.getInt(6)));
			}
			salida.write(conversor.toJson(filas));
            salida.close();
            System.out.println("Se han guardado los datos");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
