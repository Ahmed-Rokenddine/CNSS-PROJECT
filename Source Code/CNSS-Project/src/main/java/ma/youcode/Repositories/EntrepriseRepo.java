package ma.youcode.Repositories;

import ma.youcode.Helpers.Database;
import ma.youcode.Models.Entreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrepriseRepo {
    private Connection connection;

    public EntrepriseRepo() {
        Database dbConnector = new Database();
        connection = dbConnector.getConnection();
    }

    public boolean isValidEntreprise(Entreprise entreprise) {
        String sql = "SELECT * FROM entreprise WHERE name = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, entreprise.getName());
            preparedStatement.setString(2, entreprise.getPassword());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if a matching entreprise record is found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred, return false
        }
    }

    public boolean addEmployee(String name, String password) {
        String sql = "INSERT INTO employee (name, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Returns true if the employee is added successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred while adding the employee
        }
    }
}
