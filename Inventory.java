import java.sql.*;

public class Inventory {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//creating table
			String createInventory = "CREATE TABLE Inventory(inventory_id int, modelNo int, cateogryType varchar(20), quantity int CHECK(quantity>=0),"
					+ "CONSTRAINT PK_Inventory PRIMARY KEY(inventory_id), CONSTRAINT FK_InventoryModel FOREIGN KEY (modelNo) REFERENCES Model(modelNo) ON DELETE CASCADE)";
			stmt.executeUpdate(createInventory);
			
			//populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Inventory VALUES (?,?,?,?)");
			pstmt.setInt(1, 4562);
			pstmt.setInt(2, 1111);
			pstmt.setString(3, "shoes");
			pstmt.setInt(4, 76);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2333);
			pstmt.setInt(2, 1244);
			pstmt.setString(3, "sweaters");
			pstmt.setInt(4, 50);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3535);
			pstmt.setInt(2, 1976);
			pstmt.setString(3, "dresses");
			pstmt.setInt(4, 12);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 9876);
			pstmt.setInt(2, 2222);
			pstmt.setString(3, "accessories");
			pstmt.setInt(4, 102);
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
		System.out.println("Inventory Table Created successfully");
	}
}
