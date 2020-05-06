import java.sql.*;

public class Employee {

	public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//creating table
			String createEmployee = "CREATE TABLE Employee(employee_id int NOT NULL, SSN int, "
					+ "firstName varchar NOT NULL, lastName varchar NOT NULL, salary int CHECK (salary>0), wageType varchar, jobTitle varchar, "
					+ "phoneNumber int, email varchar, CONSTRAINT PK_Employee PRIMARY KEY (employee_id))";
			stmt.executeUpdate(createEmployee);
			
			//creating index
			String employeeIndex = "CREATE INDEX idx_employeeNames ON Employee(firstName, lastName)";
			stmt.executeUpdate(employeeIndex);
			
			//Populating table
			PreparedStatement pstmt = conn.prepareStatement("INSERT into Employee VALUES (?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, 4567);
			pstmt.setInt(2, 4970);
			pstmt.setString(3,"Bob");
			pstmt.setString(4, "Robertson");
			pstmt.setInt(5, 18000);
			pstmt.setString(6, "Hourly");
			pstmt.setString(7, "Cashier");
			pstmt.setInt(8, 555354789);
			pstmt.setString(9, "bobR@corporate.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 6785);
			pstmt.setInt(2, 4302);
			pstmt.setString(3,"Alice");
			pstmt.setString(4, "Jang");
			pstmt.setInt(5, 19000);
			pstmt.setString(6, "Hourly");
			pstmt.setString(7, "Sales associate");
			pstmt.setInt(8, 783456789);
			pstmt.setString(9, "AliceJ@corporate.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 7845);
			pstmt.setInt(2, 3459);
			pstmt.setString(3,"Rick");
			pstmt.setString(4, "Patter");
			pstmt.setInt(5, 50000);
			pstmt.setString(6, "Salary");
			pstmt.setString(7, "Manager");
			pstmt.setInt(8, 312458879);
			pstmt.setString(9, "rickP@corporate.com");
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2459);
			pstmt.setInt(2, 1071);
			pstmt.setString(3,"Cheryl");
			pstmt.setString(4, "Pop");
			pstmt.setInt(5, 18500);
			pstmt.setString(6, "Hourly");
			pstmt.setString(7, "Cashier");
			pstmt.setInt(8, 312458879);
			pstmt.setString(9, "cherylP@corporate.com");
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
		System.out.println("Employee Table Created successfully");
	}
}
