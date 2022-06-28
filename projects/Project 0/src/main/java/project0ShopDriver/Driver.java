package project0ShopDriver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;



import project0ShopDaos.CustomerPostgres;
import project0ShopExceptions.LoginException;
import project0ShopModels.customer;
import project0ShopServices.AuthorizeService;
import project0ShopUtil.connectionUtil;


public class Driver {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)   {
		
		  CustomerPostgres test = new CustomerPostgres(); List<customer> name =
		  test.pullCustomers(); System.out.println(name);
		 
		/*try {Connection c = connectionUtil.connectionHardCoded();
			//put what it is you want to retrieve
			System.out.println(c.getMetaData().getDriverName());
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		/*
		 * try {Connection c = connectionUtil.connectionHardCoded();
		 * 
		 * Statement statement = c.createStatement(); String sql =
		 * "SELECT * from customer_account;"; ResultSet result =
		 * statement.executeQuery(sql);
		 * 
		 * while (result.next()) {
		 * 
		 * System.out.println( "Username: " + result.getString("customer_username"));
		 * System.out.println( "Password:" + result.getString("customer_password")); } }
		 * 
		 * catch (SQLException e) { System.out.println(e); }
		 */
	    
			
			switch (mainMenu()) {
			case "1":
				System.out.println("Welcome valued customer");
				System.out.println("Do you have an account with us?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				System.out.println("3. Go back");
				String accountQuestion = sc.nextLine();
				switch (accountQuestion) {
				case "1":
					System.out.println("Welcome back!");
					System.out.println("Please enter your login information");
					System.out.println("Username: ");
					String custUsername = sc.nextLine();
					System.out.println("Password: ");
					String custPassword = sc.nextLine();
					
				
					break;
					
					/*do {
						if (custUsername == "username" && custPassword == "password") {
							boolean x;
							x = false;
							System.out.println("Login Successful!");
							System.out.println("What would you like to do today?");
							
						}else
							System.out.println("Please enter valid credentials");
							
					} while (true); */
					
					
					
					
				case "2":
					System.out.println("To proceed you would need to make an account");
					System.out.println("Would you like to make an account?");
					System.out.println("1. Yes");
					System.out.println("2. No");
				String makeAccountQuestion = sc.nextLine();
					switch (makeAccountQuestion) {
				case "1":
						accountCreationConfirm();
					break;

				default:
					break;
				}
					
					
					
					break;
				case "3":
		
					break;

				default:
					break;
				}
				
				break;
			case "2":
				System.out.println("Welcome valued employee!");
				System.out.println("Please enter your employee login");
				
				break;
			case "3":
				System.out.println("Have a great day!");
				
				break;
				
			default:
				System.out.println("Invalid Selection, Please try again.");
				break;
			}

	}
	static void accountCreationConfirm() {
		
			System.out.println("Great!, lets get started.");
			System.out.println("Please enter your desired username");
			String customerCreateUsername = sc.nextLine();
			System.out.println("Please enter your desired password");
			String customerCreatePassword = sc.nextLine();
			//check database to see if username and password are valid
			System.out.println("Your account has been created!");
			//clear screen
			System.out.println("Welcome " + customerCreateUsername);
			System.out.println("What would you like to do?");
			//view available item and/or purchase one
			System.out.println("1. I would like to purchase an item");
			//view customer inventory and remaining payments on an item
			System.out.println("2. I would like to view the items I own");
			System.out.println("3. Exit");
			String custSelect = sc.nextLine();
			switch (custSelect) {
			case "1":
				System.out.println("Welcome customer, what would you like to look at?");
				//each animal will have their own value range that can be bid on
				System.out.println("1. Cow");
				System.out.println("2. Pig");
				System.out.println("3. Chicken");
				break;
			case "2":
				System.out.println("These are the current items in your inventory:");
				//list item inventory that has be previously bought
				break;
			case "3":
				//return to previous screen function
				break;

			default:
				System.out.println("Invalid Selection, Please try again.");
				break;
			}
			
			
		
	}
	static String mainMenu() {
		System.out.println("Welcome to the the shop!");
		System.out.println("Are you a Customer or an Employee?");
		System.out.println("1.Customer");
		System.out.println("2.Employee");
		System.out.println("3.Exit");
		String whichUser = sc.nextLine();
		
		
		return whichUser;
	}

	/*try {Connection c = connectionUtil.connectionHardCoded();
	//put what it is you want to retrieve
	Statement statement = c.createStatement();
	String sql = "SELECT * customer_account";
	ResultSet result = statement.executeQuery(sql);
	
	while (result.next()) {
		//System.out.println("Customer Id: " + result.getString("customer_id"));
		System.out.println("Username: " + result.getString("customer_username"));
		System.out.println("Password: " + result.getString("customer_password"));
		
		
		
	}
	System.out.println(sql);
	c.close();
} catch (SQLException e) {
	e.printStackTrace();
}*/
}
