import java.sql.*;

public class Views {

public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//create views
			String limemployeeView = "CREATE VIEW limemployeeview AS SELECT firstname, lastname, jobtitle, employee_id FROM Public.Employee";
			stmt.executeUpdate(limemployeeView);
			
			String salesemployeeView = "CREATE VIEW salesemploy AS SELECT Orderno, cost, employee_id FROM Public.Orders";
			stmt.executeUpdate(salesemployeeView);
			
			String viewModel = "CREATE VIEW viewModel AS SELECT * FROM Public.Model";
			stmt.executeUpdate(viewModel);
			
			String viewInventory = "CREATE VIEW viewInventory AS SELECT * FROM Public.Inventory";
			stmt.executeUpdate(viewInventory);
			
			String viewOrders = "CREATE VIEW viewOrders AS SELECT * FROM Public.Orders";
			stmt.executeUpdate(viewOrders);
			
			String viewCustomer = "CREATE VIEW viewCustomer AS SELECT * FROM Public.Customer";
			stmt.executeUpdate(viewCustomer);
			
			String viewEmployee = "CREATE VIEW viewEmployee AS SELECT * FROM Public.Employee";
			stmt.executeUpdate(viewEmployee);
			
			String viewTotalrevenue = "CREATE VIEW totalrevenue AS SELECT cost, customer_id, employee_id FROM Public.Orders";
			stmt.executeUpdate(viewTotalrevenue);
			
			String viewcustomerModel = "CREATE VIEW customerModel AS SELECT Orders.customer_id, Orders.modelno, Customer.firstName FROM Public.Orders, Public.Customer WHERE "
					+ "Orders.customer_id = Customer.customer_id";
			stmt.executeUpdate(viewcustomerModel);
			
			String viewexpensereport = "CREATE VIEW expensereport AS SELECT Employee.employee_id, Employee.salary, Orders.cost FROM Public.Employee, Public.Orders WHERE "
					+ "Employee.employee_id = Orders.employee_id";
			stmt.execute(viewexpensereport);
			
			String viewinventoryorder = "CREATE VIEW inventoryorder AS SELECT Orders.*, Inventory.quantity FROM Public.Orders, Public.Inventory WHERE "
					+ "Orders.inventory_id = Inventory.inventory_id";
			stmt.executeUpdate(viewinventoryorder);
			
			stmt.close();
			
			System.out.println("Views created");
		}
		catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
