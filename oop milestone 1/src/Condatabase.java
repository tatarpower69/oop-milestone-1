import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Condatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/film";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ramazan20074";

    private static Connection con;

    private Condatabase() {}

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
            }
        }
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
}
