package main;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exemplu1 {

    public static void main(String[] args) throws SQLException {
        var url = "jdbc:mysql://localhost:3306/java2c2";

        try (var con = DriverManager.getConnection(url, "root", "")) {
            var sql = "INSERT INTO produse VALUES(null, ?)";

            var stmt = con.prepareStatement(sql);

            stmt.setString(1, "ciocolata");

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
