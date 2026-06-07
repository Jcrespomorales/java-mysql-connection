package javaMysqlConnection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaMysqlConnection.conexion.ConexionBD;
import javaMysqlConnection.modelo.Empleado;


public class EmpleadoDAO {

    public void createEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Empleados (nif, nombre, apellido1, apellido2, direccion, telefono, email, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, empleado.getNif());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getApellido1());
            statement.setString(4, empleado.getApellido2());
            statement.setString(5, empleado.getDireccion());
            statement.setString(6, empleado.getTelefono());
            statement.setString(7, empleado.getEmail());
            statement.setDouble(8, empleado.getSueldo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Empleado readEmpleado(String nif) {
        String sql = "SELECT * FROM Empleado WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nif);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Empleado(
                    resultSet.getString("nif"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido1"),
                    resultSet.getString("apellido2"),
                    resultSet.getString("direccion"),
                    resultSet.getString("telefono"),
                    resultSet.getString("email"),
                    resultSet.getDouble("sueldo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmpleado(Empleado empleado) {
        String sql = "UPDATE Empleado SET nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, telefono = ?, email = ?, sueldo = ? WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido1());
            statement.setString(3, empleado.getApellido2());
            statement.setString(4, empleado.getDireccion());
            statement.setString(5, empleado.getTelefono());
            statement.setString(6, empleado.getEmail());
            statement.setDouble(7, empleado.getSueldo());
            statement.setString(8, empleado.getNif());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmpleado(String nif) {
        String sql = "DELETE FROM Empleado WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nif);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}