package javaMysqlConnection.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaMysqlConnection.conexion.ConexionBD;
import javaMysqlConnection.modelo.Cliente;

public class ClienteDAO {

    public void createCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nif, nombre, apellido1, apellido2, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNif());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido1());
            statement.setString(4, cliente.getApellido2());
            statement.setString(5, cliente.getDireccion());
            statement.setString(6, cliente.getTelefono());
            statement.setString(7, cliente.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente readCliente(String nif) {
        String sql = "SELECT * FROM clientes WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nif);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Cliente(
                    resultSet.getString("nif"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido1"),
                    resultSet.getString("apellido2"),
                    resultSet.getString("direccion"),
                    resultSet.getString("telefono"),
                    resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, telefono = ?, email = ? WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido1());
            statement.setString(3, cliente.getApellido2());
            statement.setString(4, cliente.getDireccion());
            statement.setString(5, cliente.getTelefono());
            statement.setString(6, cliente.getEmail());
            statement.setString(7, cliente.getNif());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(String nif) {
        String sql = "DELETE FROM clientes WHERE nif = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nif);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}