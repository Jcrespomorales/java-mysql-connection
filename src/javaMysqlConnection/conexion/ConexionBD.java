package javaMysqlConnection.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Crear una clase ConexionBD permite centralizar la gestión de la conexión a la base de datos, 
 * evitar duplicación de código, facilitar el mantenimiento y separar responsabilidades, 
 * haciendo el código más limpio y reutilizable.
 * */

public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión establecida correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al establecer la conexión: " + e.getMessage());
		}
		return connection;
	}
}