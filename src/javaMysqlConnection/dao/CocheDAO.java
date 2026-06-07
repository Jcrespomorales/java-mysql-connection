package javaMysqlConnection.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaMysqlConnection.conexion.ConexionBD;
import javaMysqlConnection.modelo.Coche;
import javaMysqlConnection.modelo.Coche.TipoVehiculo;

public class CocheDAO {

    public void createCoche(Coche coche) {
        String sql = "INSERT INTO coches (matricula, modelo, tipo_vehiculo, precio, color, kilometros, garantia_meses, antiguo_propietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coche.getMatricula());
            statement.setString(2, coche.getModelo());
            statement.setString(3, coche.getTipoVehiculo().name());
            statement.setDouble(4, coche.getPrecio());
            statement.setString(5, coche.getColor());
            statement.setInt(6, coche.getKilometros());
            statement.setObject(7, coche.getGarantiaMeses(), java.sql.Types.INTEGER);
            statement.setString(8, coche.getAntiguoPropietario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Coche readCoche(String matricula) {
        String sql = "SELECT * FROM coches WHERE matricula = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matricula);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Coche(
                    resultSet.getString("matricula"),
                    resultSet.getString("modelo"),
                    TipoVehiculo.valueOf(resultSet.getString("tipo_vehiculo")),
                    resultSet.getDouble("precio"),
                    resultSet.getString("color"),
                    resultSet.getInt("kilometros"),
                    resultSet.getObject("garantia_meses", Integer.class),
                    resultSet.getString("antiguo_propietario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCoche(Coche coche) {
        String sql = "UPDATE coches SET modelo = ?, tipo_vehiculo = ?, precio = ?, color = ?, kilometros = ?, garantia_meses = ?, antiguo_propietario = ? WHERE matricula = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coche.getModelo());
            statement.setString(2, coche.getTipoVehiculo().name());
            statement.setDouble(3, coche.getPrecio());
            statement.setString(4, coche.getColor());
            statement.setInt(5, coche.getKilometros());
            statement.setObject(6, coche.getGarantiaMeses(), java.sql.Types.INTEGER);
            statement.setString(7, coche.getAntiguoPropietario());
            statement.setString(8, coche.getMatricula());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCoche(String matricula) {
        String sql = "DELETE FROM coches WHERE matricula = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matricula);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}