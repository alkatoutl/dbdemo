import java.sql.*;

public class Login {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//creating table
			String createLogin = "CREATE TABLE Login(SSN int, employee_id int, userID varchar, privilege varchar(20), loginTime int, "
					+ "logoutTime int, CONSTRAINT PK_Login PRIMARY KEY(SSN, employee_id), "
					+ "CONSTRAINT FK_LoginEmployee FOREIGN KEY (employee_id) REFERENCES Employee(employee_id))";
			stmt.executeUpdate(createLogin);
			
			//populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Login VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1, 4970);
			pstmt.setInt(2, 4567);
			pstmt.setString(3, "robb");
			pstmt.setString(4,"sales");
			pstmt.setInt(5, 1000);
			pstmt.setInt(6, 1030);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 4302);
			pstmt.setInt(2, 6785);
			pstmt.setString(3, "alicej");
			pstmt.setString(4,"HR");
			pstmt.setInt(5, 800);
			pstmt.setInt(6, 900);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3459);
			pstmt.setInt(2, 7845);
			pstmt.setString(3, "rickp");
			pstmt.setString(4,"admin");
			pstmt.setInt(5, 1400);
			pstmt.setInt(6, 1420);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 1071);
			pstmt.setInt(2, 2459);
			pstmt.setString(3, "cherylp");
			pstmt.setString(4,"engineering");
			pstmt.setInt(5, 730);
			pstmt.setInt(6, 1100);
			pstmt.executeUpdate();
			
			System.out.println("Table Populated");
			
			pstmt.close();
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Login Table Created successfully");
	}
}
