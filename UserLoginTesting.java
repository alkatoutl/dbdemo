import java.sql.*;

public class UserLoginTesting {

	public static void main(String[] args) throws SQLException{
		try {
			
			Class.forName("org.postgresql.Driver"); //load driver
			
			//test case 1, admin access
			String user = "adminuser";
			String password = "1234";
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, password);
			Statement stmt = conn.createStatement();
			System.out.println("As administrator (before adding tuple): ");
			String selectmodeltable = "SELECT * FROM Public.Model";
			ResultSet rset = stmt.executeQuery(selectmodeltable);
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2)+" "+rset.getInt(3)+" "+rset.getString(4)+" "+rset.getString(5));
			}
			String addTupleModel = "INSERT INTO Model(modelno, cost, year, name, color) VALUES(5555, 65, 2018, 'Trousers', 'Khaki')";
			stmt.executeUpdate(addTupleModel);
			rset = stmt.executeQuery(selectmodeltable);
			System.out.println("As administrator (after adding tuple): ");
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2)+" "+rset.getInt(3)+" "+rset.getString(4)+" "+rset.getString(5));
			}
			//admin total revenue, expense report, customermodel, order inventory access
			System.out.println("Total Revenue view: ");
			String selecttotalreva = "SELECT * FROM totalrevenue";
			rset = stmt.executeQuery(selecttotalreva);
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2)+" "+rset.getInt(3));
			}
			
			System.out.println("Expense report view: ");
			String selectexpensea = "SELECT * FROM expensereport";
			rset = stmt.executeQuery(selectexpensea);
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2)+" "+rset.getInt(3));
			}
			
			System.out.println("customerModel view: ");
			String selectCMa = "SELECT * FROM customerModel";
			rset = stmt.executeQuery(selectCMa);
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2)+" "+rset.getString(3));
			}
			
			System.out.println("Order inventory view: ");
			String selectINORa = "SELECT * FROM inventoryorder";
			rset = stmt.executeQuery(selectINORa);
			while (rset.next()) {
				System.out.println(rset.getInt(1)+" "+rset.getInt(2));
			}
			stmt.close();
			
			
			
			//test case 2, engineer access
			user = "engineeruser";
			password = "5678";
			Connection conn1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, password);
			Statement stmt1 = conn1.createStatement();
			System.out.println("\nAs engineer (before updating tuple): ");
			String selectmodeltable1 = "SELECT * FROM viewModel";
			ResultSet rset1 = stmt1.executeQuery(selectmodeltable1);
			while (rset1.next()) {
				System.out.println(rset1.getInt(1)+" "+rset1.getInt(2)+" "+rset1.getInt(3)+" "+rset1.getString(4)+" "+rset1.getString(5));
			}
			System.out.println("As engineer (after updating tuple): ");
			String updatemodeltable = "UPDATE viewModel SET cost = 35 WHERE name = 'Maxi dress'";
			stmt1.executeUpdate(updatemodeltable);
			rset1 = stmt1.executeQuery(selectmodeltable1);
			while (rset1.next()) {
				System.out.println(rset1.getInt(1)+" "+rset1.getInt(2)+" "+rset1.getInt(3)+" "+rset1.getString(4)+" "+rset1.getString(5));
			}
			//engineer Order inventory access
			System.out.println("Order inventory view: ");
			String selectINORe = "SELECT * FROM inventoryorder";
			rset1 = stmt1.executeQuery(selectINORe);
			while (rset1.next()) {
				System.out.println(rset1.getInt(1)+" "+rset1.getInt(2));
			}
			stmt1.close();
			
			
			//test case 3, sales access
			user = "salesuser";
			password = "4321";
			Connection conn2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, password);
			Statement stmt2 = conn2.createStatement();
			System.out.println("\nAs sales (before updating tuple): ");
			String selectcustable = "SELECT * FROM viewCustomer";
			ResultSet rset2 = stmt2.executeQuery(selectcustable);
			while (rset2.next()) {
				System.out.println(rset2.getInt(1)+" "+rset2.getString(2)+" "+rset2.getString(3)+" "+rset2.getInt(4)+" "+rset2.getString(5));
			}
			System.out.println("As sales (after updating tuple): ");
			String updatecustable = "UPDATE viewCustomer SET email = 'alexburn@gmail.com' WHERE firstname = 'Alex'";
			stmt2.executeUpdate(updatecustable);
			rset2 = stmt2.executeQuery(selectcustable);
			while (rset2.next()) {
				System.out.println(rset2.getInt(1)+" "+rset2.getString(2)+" "+rset2.getString(3)+" "+rset2.getInt(4)+" "+rset2.getString(5));
			}
			//sales total revenue access
			System.out.println("Total Revenue view: ");
			String selecttotalrevs = "SELECT * FROM totalrevenue";
			rset2 = stmt2.executeQuery(selecttotalrevs);
			while (rset2.next()) {
				System.out.println(rset2.getInt(1)+" "+rset2.getInt(2)+" "+rset2.getInt(3));
			}
			stmt2.close();
			
			
			
			//test case 4, HR access
			user = "hruser";
			password = "2345";
			Connection conn3 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, password);
			Statement stmt3 = conn3.createStatement();
			System.out.println("\nAs HR (before updating tuple): ");
			String selectemployeetable = "SELECT * FROM viewEmployee";
			ResultSet rset3 = stmt3.executeQuery(selectemployeetable);
			while (rset3.next()) {
				System.out.println(rset3.getInt(1)+" "+rset3.getInt(2)+" "+rset3.getString(3)+" "+rset3.getString(4)+" "+rset3.getInt(5)+" "+rset3.getString(6)+" "+rset3.getString(7)+" "+rset3.getInt(8)+" "+rset3.getString(9));
			}
			System.out.println("As HR (after updating tuple): ");
			String updateemploy = "UPDATE viewEmployee SET salary = 20000 WHERE firstname = 'Alice'";
			stmt3.executeUpdate(updateemploy);
			rset3 = stmt3.executeQuery(selectemployeetable);
			while (rset3.next()) {
				System.out.println(rset3.getInt(1)+" "+rset3.getInt(2)+" "+rset3.getString(3)+" "+rset3.getString(4)+" "+rset3.getInt(5)+" "+rset3.getString(6)+" "+rset3.getString(7)+" "+rset3.getInt(8)+" "+rset3.getString(9));
			}
			stmt3.close();
			
			
			
			//data validity check
			user = "adminuser";
			password = "1234";
			Connection conna = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", user, password);
			Statement stmta = conna.createStatement();
			String addnegquantity = "INSERT INTO Inventory(inventory_id, modelno, cateogrytype, quantity) VALUES(1234, 7676, 'shoes', -50)";
			stmta.executeUpdate(addnegquantity);
			stmta.close();
			
		}
		catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
