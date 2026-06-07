package javaMysqlConnection.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaMysqlConnection.conexion.ConexionBD;
import javaMysqlConnection.dao.ClienteDAO;
import javaMysqlConnection.dao.CocheDAO;
import javaMysqlConnection.dao.EmpleadoDAO;
import javaMysqlConnection.modelo.Cliente;
import javaMysqlConnection.modelo.Coche;
import javaMysqlConnection.modelo.Empleado;

public class JavaMysql {
	public static void main(String[] args) {
		try (Connection connection = new ConexionBD().getConnection()) {

			// Instancias DAO
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();

			// Insertar clientes
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente1 = new Cliente("12345678A", "Juan", "Pérez", "Gómez", "Calle Ancha 123, Madrid",
					"600123456", "juan.perez@gmail.com");
			Cliente cliente2 = new Cliente("87654321B", "Ana", "López", "Martínez",
					"Avenida Siempre Viva 742, Barcelona", "700987654", "ana.lopez@example.com");
			Cliente cliente3 = new Cliente("11223344C", "Luis", "García", "Fernández", "Plaza Mayor 1, Sevilla",
					"650123789", "luis.garcia@example.com");
			clienteDAO.createCliente(cliente1);
			clienteDAO.createCliente(cliente2);
			clienteDAO.createCliente(cliente3);

			// Insertar coches
			CocheDAO cocheDAO = new CocheDAO();
			Coche coche1 = new Coche("1234ABC", "Toyota Corolla", Coche.TipoVehiculo.NUEVO, 20000.00, "Rojo", 0, 24,
					null);
			Coche coche2 = new Coche("5678DEF", "Ford Fiesta", Coche.TipoVehiculo.SEGUNDA_MANO, 15000.00, "Azul", 30000,
					null, "Juan Pérez");
			Coche coche3 = new Coche("9101GHI", "Honda Civic", Coche.TipoVehiculo.KM0, 18000.00, "Negro", 100, 12,
					null);
			cocheDAO.createCoche(coche1);
			cocheDAO.createCoche(coche2);
			cocheDAO.createCoche(coche3);

			// Insertar empleados
			Empleado empleado1 = new Empleado("44556677F", "Laura", "Gómez", "Sánchez", "Calle Luna 23, Almería",
					"670123456", "laura.gomez@example.com", 1800.00);
			Empleado empleado2 = new Empleado("22334455D", "María", "Hernández", "López", "Calle del Sol 45, Madrid",
					"680123456", "maria.hernandez@example.com", 1600.00);
			Empleado empleado3 = new Empleado("33445566E", "Carlos", "Martín", "Gómez", "Avenida del Mar 12, Almería",
					"690987654", "carlos.martin@example.com", 1700.00);
			empleadoDAO.createEmpleado(empleado1);
			empleadoDAO.createEmpleado(empleado2);
			empleadoDAO.createEmpleado(empleado3);

			// Consultas sobre la base de datos
			// Obtener los empleados de Almería
			System.out.println("\nEmpleados que viven en Almería: ");

			String sqlEmpleadosAlmeria = "SELECT * FROM empleados WHERE direccion LIKE '%Almería%';";
			try (PreparedStatement statement = connection.prepareStatement(sqlEmpleadosAlmeria);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString("nombre") + " " + resultSet.getString("apellido1") + " "
							+ resultSet.getString("apellido2") + " vive en Almería");
				}
			}

			// Obtener el modelo de un coche dada una matrícula XXXXX
			System.out.println("\nLa matrícula dada se corresponde con: ");

			String sqlModeloCoche = "SELECT modelo FROM coches WHERE matricula = ?;";
			try (PreparedStatement statement = connection.prepareStatement(sqlModeloCoche)) {
				statement.setString(1, "5678DEF");
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						System.out.println("Modelo del coche: " + resultSet.getString("modelo"));
					} else {
						System.out.println("No se encontró un coche con esa matrícula.");
					}
				}
			}

			// Seleccionar todos los empleados y su sueldo
			System.out.println("\nLista de empleados y su sueldo: ");
			String sqlEmpleadosSueldos = "SELECT nombre, apellido1, apellido2, sueldo FROM empleados;";
			try (PreparedStatement statement = connection.prepareStatement(sqlEmpleadosSueldos);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					System.out.println(
							"Empleado: " + resultSet.getString("nombre") + " " + resultSet.getString("apellido1") + " "
									+ resultSet.getString("apellido2") + ", Sueldo: " + resultSet.getDouble("sueldo"));
				}
			}

		} catch (Exception e) {
			System.err.println("Error durante la ejecución: " + e.getMessage());
		}
	}
}
