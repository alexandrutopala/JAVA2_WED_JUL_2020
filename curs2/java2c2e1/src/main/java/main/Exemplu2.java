package main;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exemplu2 {

    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/java2c2";

        try (var con = DriverManager.getConnection(url, "root", "")) {
            var sql = "SELECT * FROM produse";

            var stmt = con.prepareStatement(sql);

            var resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var nume = resultSet.getString("nume");

                System.out.println(id + " " + nume);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
