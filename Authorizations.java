import java.sql.*;

public class Authorizations {

public static void main(String[] args) throws SQLException {
		
		try {
			//create connection
			Class.forName("org.postgresql.Driver"); //load driver
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
			System.out.println("Database Connected...");  //checking for connection
			Statement stmt = conn.createStatement();
			
			//create roles
			String createAdmin = "CREATE ROLE admin";
			stmt.executeUpdate(createAdmin);
			
			String createSales = "CREATE ROLE sales";
			stmt.executeUpdate(createSales);
			
			String createEngineer = "CREATE ROLE engineer";
			stmt.executeUpdate(createEngineer);
			
			String createHR = "CREATE ROLE HR";
			stmt.executeUpdate(createHR);
			
			System.out.println("Roles created");
			
			//grant admin permissions
			String grantAdminEM = "GRANT ALL ON public.Employee TO admin";
			stmt.executeUpdate(grantAdminEM);
			String grantAdminCU = "GRANT ALL ON public.Customer TO admin";
			stmt.executeUpdate(grantAdminCU);
			String grantAdminMO = "GRANT ALL ON public.Model TO admin";
			stmt.executeUpdate(grantAdminMO);
			String grantAdminIN = "GRANT ALL ON public.Inventory TO admin";
			stmt.executeUpdate(grantAdminIN);
			String grantAdminOR = "GRANT ALL ON public.Orders TO admin";
			stmt.executeUpdate(grantAdminOR);
			String grantAdmintTR = "GRANT SELECT ON totalrevenue TO admin";
			stmt.executeUpdate(grantAdmintTR);
			String grantAdminCM = "GRANT SELECT ON customerModel TO admin";
			stmt.executeUpdate(grantAdminCM);
			String grantAdminER = "GRANT SELECT ON expensereport TO admin";
			stmt.executeUpdate(grantAdminER);
			String grantAdminINOR = "GRANT SELECT ON inventoryorder TO admin";
			stmt.executeUpdate(grantAdminINOR);
			//has access to all views automatically
			System.out.println("admin permissions granted");
			
			//grant sales permissions
			String grantSalesCU = "GRANT SELECT, UPDATE ON viewCustomer TO sales";
			stmt.executeUpdate(grantSalesCU);
			String grantSalesOR = "GRANT SELECT, INSERT ON viewOrders TO sales";
			stmt.executeUpdate(grantSalesOR);
			String grantSalesTR = "GRANT SELECT, INSERT ON totalrevenue TO sales";
			stmt.executeUpdate(grantSalesTR);
			String grantSalesCM = "GRANT SELECT ON customerModel TO sales";
			stmt.executeUpdate(grantSalesCM);
			System.out.println("sales permissions granted");
			
			//grant engineer permissions
			String grantEngineerMO = "GRANT SELECT, UPDATE ON viewModel TO engineer";
			stmt.executeUpdate(grantEngineerMO);
			String grantEngineerIN = "GRANT SELECT, UPDATE ON viewInventory TO engineer";
			stmt.executeUpdate(grantEngineerIN);
			String grantEngineerEM = "GRANT SELECT ON limemployeeView TO engineer";
			stmt.executeUpdate(grantEngineerEM);
			String grantEngineerINOR = "GRANT SELECT ON inventoryorder TO engineer";
			stmt.executeUpdate(grantEngineerINOR);
			System.out.println("engineer permissions granted");
			
			//grant HR permissions
			String grantHREM = "GRANT SELECT, UPDATE ON viewEmployee to HR";
			stmt.executeUpdate(grantHREM);
			System.out.println("HR permissions granted");
			
			
			
			

		}
		
		catch(Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
	}

}
