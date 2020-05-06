import java.sql.*;

public class Model {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//creating table
			String createModel = "CREATE TABLE Model(modelNo int primary key, cost float CHECK (cost>0), year int, name varchar(20), color varchar(10))";
			stmt.executeUpdate(createModel);
			
			//creating index
			String modelIndex = "CREATE INDEX idx_models ON Model(name)";
			stmt.executeUpdate(modelIndex);
			
			//populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Model VALUES(?,?,?,?,?)");
			pstmt.setInt(1, 1111);
			pstmt.setFloat(2,40);
			pstmt.setInt(3, 2020);
			pstmt.setString(4, "Nike sneakers");
			pstmt.setString(5, "Black");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 1244);
			pstmt.setFloat(2,35);
			pstmt.setInt(3, 2019);
			pstmt.setString(4, "Adidas sweater");
			pstmt.setString(5, "Purple");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 1976);
			pstmt.setFloat(2, 59);
			pstmt.setInt(3, 2020);
			pstmt.setString(4, "Maxi dress");
			pstmt.setString(5, "Orange");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2222);
			pstmt.setFloat(2,20);
			pstmt.setInt(3, 2018);
			pstmt.setString(4, "Hoop earrings");
			pstmt.setString(5, "Gold");
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
		System.out.println("Model Table Created successfully");
	}
}
