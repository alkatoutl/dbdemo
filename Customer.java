import java.sql.*;

public class Customer {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//Creating table
			String createCustomer = "CREATE TABLE Customer(customer_id int NOT NULL PRIMARY KEY, firstName varchar NOT NULL, "
					+ "lastName varchar NOT NULL, phoneNumber int, email varchar)";
			stmt.executeUpdate(createCustomer);
			
			//creating index
			String customerIndex = "CREATE INDEX idx_customerNames ON Customer(firstName, lastName)";
			stmt.executeUpdate(customerIndex);
			
			//populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Customer VALUES(?,?,?,?,?)");
			pstmt.setInt(1, 1234);
			pstmt.setString(2, "Becky");
			pstmt.setString(3, "Leaf");
			pstmt.setInt(4, 312479867);
			pstmt.setString(5, "beckyleaf@gmail.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 7869);
			pstmt.setString(2, "Alex");
			pstmt.setString(3, "Burn");
			pstmt.setInt(4, 513478952);
			pstmt.setString(5, "alexleaf@gmail.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 5432);
			pstmt.setString(2, "Tim");
			pstmt.setString(3, "Dempsey");
			pstmt.setInt(4, 815678342);
			pstmt.setString(5, "timdempsey@gmail.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 9457);
			pstmt.setString(2, "Sharon");
			pstmt.setString(3, "White");
			pstmt.setInt(4, 815679432);
			pstmt.setString(5, "sharonwhite@gmail.com");
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
		System.out.println("Customer Table Created successfully");
	}
}
