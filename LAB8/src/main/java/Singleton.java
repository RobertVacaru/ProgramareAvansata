import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Singleton {

    private static Connection con;

    public Singleton() {
    }

    public Connection getInstance(){
        if(con ==null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8", "root", "scoobydoo123");
            } catch (
                    SQLException e) {
                System.err.println("Cannot connect to DB: " + e);
            } finally {
                if (con != null) {
                    System.out.println("Connexion created.\n");
                }
            }
        }
        return con;
    }

    public static Connection getCon() {
        return con;
    }
}