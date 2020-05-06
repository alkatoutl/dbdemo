import java.sql.*;
public class Orders {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//Creating table
			String createOrders = "CREATE TABLE Orders(orderNo int, customer_id int, "
					+ "employee_id int, inventory_id int, modelNo int, cost int, date int, "
					+ "paymentType varchar(6), orderType varchar(6), CONSTRAINT PK_Order PRIMARY KEY (inventory_id, modelNo), "
					+ "CONSTRAINT FK_OrderEmployee FOREIGN KEY (employee_id) REFERENCES Employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "CONSTRAINT FK_OrderCustomer FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "CONSTRAINT FK_OrderModel FOREIGN KEY (modelNo) REFERENCES Model(modelNo), "
					+ "CONSTRAINT FK_OrderInventory FOREIGN KEY (inventory_id) REFERENCES Inventory(inventory_id))";
			
			stmt.executeUpdate(createOrders);
			
			//Populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Orders values (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, 130);
			pstmt.setInt(2, 1234);
			pstmt.setInt(3, 4567);
			pstmt.setInt(4, 4562);
			pstmt.setInt(5, 1111);
			pstmt.setInt(6, 40);
			pstmt.setInt(7, 021420);
			pstmt.setString(8, "credit");
			pstmt.setString(9, "store");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 250);
			pstmt.setInt(2, 7869);
			pstmt.setInt(3, 6785);
			pstmt.setInt(4, 2333);
			pstmt.setInt(5, 1244);
			pstmt.setInt(6, 35);
			pstmt.setInt(7, 012620);
			pstmt.setString(8, "credit");
			pstmt.setString(9, "online");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 670);
			pstmt.setInt(2, 5432);
			pstmt.setInt(3, 7845);
			pstmt.setInt(4, 3535);
			pstmt.setInt(5, 1976);
			pstmt.setInt(6, 59);
			pstmt.setInt(7, 022520);
			pstmt.setString(8, "cash");
			pstmt.setString(9, "store");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 400);
			pstmt.setInt(2, 9457);
			pstmt.setInt(3, 2459);
			pstmt.setInt(4, 9876);
			pstmt.setInt(5, 2222);
			pstmt.setInt(6, 20);
			pstmt.setInt(7, 031620);
			pstmt.setString(8, "cash");
			pstmt.setString(9, "store");
			pstmt.executeUpdate();
			
			System.out.println("Table populated");
			
			pstmt.close();
			stmt.close();
			conn.close();
		}
		catch (Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Orders Table Created successfully");
	}
}
