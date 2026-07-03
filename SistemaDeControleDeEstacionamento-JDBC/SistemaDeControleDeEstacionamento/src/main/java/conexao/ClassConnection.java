package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConnection {

    public static Connection getConnection() throws SQLException {

        try {
            String url = "jdbc:mysql://localhost:3306/controledeestacionamento";
            String usuario = "root";
            String senha = "";
            return DriverManager.getConnection(url, usuario, null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
