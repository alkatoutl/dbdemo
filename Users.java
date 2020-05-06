import java.sql.*;

public class Users {

public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//create admin user
			String createadmin = "CREATE USER adminuser WITH PASSWORD '1234'";
			stmt.executeUpdate(createadmin);
			String grantadmin = "GRANT admin TO adminuser";
			stmt.executeUpdate(grantadmin);
			System.out.println("Admin user created");
			
			//create engineer user
			String createngineer = "CREATE USER engineeruser WITH PASSWORD '5678'";
			stmt.executeUpdate(createngineer);
			String grantengingeer = "GRANT engineer TO engineeruser";
			stmt.executeUpdate(grantengingeer);
			System.out.println("Engineer user created");
			
			//create sales user
			String createsales = "CREATE USER salesuser WITH PASSWORD '4321'";
			stmt.executeUpdate(createsales);
			String grantsales = "GRANT sales TO salesuser";
			stmt.executeUpdate(grantsales);
			System.out.println("Sales user created");
			
			//create HR
			String createHR = "CREATE USER hruser WITH PASSWORD '2345'";
			stmt.executeUpdate(createHR);
			String grantHR = "GRANT HR TO hruser";
			stmt.executeUpdate(grantHR);
			System.out.println("HR user created");
			
			stmt.close();
		}
		catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
