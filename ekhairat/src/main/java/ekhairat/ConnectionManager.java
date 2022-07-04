package ekhairat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	static Connection con;
	String dbURL = "jdbc:postgresql://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
	String user = "olkzesmgaifpnp";
	String pass = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
	
	protected Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }
}
