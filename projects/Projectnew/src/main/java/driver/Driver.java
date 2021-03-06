package driver;


import java.util.List;
import java.util.Scanner;



import daos.OfferDAO;
import daos.OfferPostgres;
import daos.ProductDAO;
import daos.ProductPostgres;
import daos.UserDAO;
import daos.UserInventoryDAO;
import daos.UserInventoryPostgres;
import daos.UserPostgres;
import exceptions.LoginException;
import models.Offer;
import models.Product;
import models.User;
import models.userInventory;
import services.AuthService;
import services.ProductService;
import services.UserService;


public class Driver {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ProductService ps;
	static UserDAO ud = new UserPostgres();
	static ProductDAO pd = new ProductPostgres();
	static OfferDAO od = new OfferPostgres();
	static UserInventoryDAO uid = new UserInventoryPostgres();
	static User u;
	
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		ps = new ProductService();
		u = new User();
		printProducts();
		
		switch (menu1()) {
		//creates a user
		case "1":
			System.out.println("Create, username: ");
			String newUsername = scan.nextLine();
			System.out.println("Create, password");
			String newPassword = scan.nextLine();
			User createNewUser = new User();
			createNewUser.setUsername(newUsername);
			createNewUser.setPassword(newPassword);
			System.out.println(us.createUser(createNewUser));
			System.out.println("Your account has been created");
			scan.nextLine();
			as.login(newUsername, newPassword);
			u.setUsername(newUsername);
			switch (newUsername) {
			case "employee":
				employeeMenu();
				break;
			default:
				customerMenu();
				break;
			}			
			break;
		//logs a existing user in
		case "2":
			System.out.println("Enter your username: ");
			String username = scan.nextLine();
			System.out.println("Enter your password: ");
			String password = scan.nextLine();
			as.login(username, password);
			u.setUsername(username);
			switch (username) {
			case "employee":
				switch (employeeMenu()) {
				case "1":
					System.out.println("Enter new product name:");
					String newProductName = scan.nextLine();
					System.out.println("Enter product description");
					String newProductDescription = scan.nextLine();
					Product createNewProduct = new Product();
					createNewProduct.setProduct_name(newProductName);
					createNewProduct.setProduct_description(newProductDescription);
					System.out.println(ps.createProduct(createNewProduct));
					break;
				case "2":
					printProducts();
					System.out.println("Which product would you like to remove");
					int removeItem = scan.nextInt();
					pd.deleteProductById(removeItem);
					System.out.println("Product" + removeItem +"removed");
				case "3":
					//view pending offers
				default:
					break;
				}
				
				break;
			default:
			break;
			}			
			break;
		//exits program
		case "3":
			System.out.println("Goodbye");
			System.exit(0);
			break;
		//work on looping until valid choice
		default:
			System.out.println("Invalid choice, please try again");
			menu1();
			break;
		}
		switch (customerMenu()) {
		case "1":
			printProducts();
			System.out.println("Which product would you like to make an offer on?");
			int itemInterest = scan.nextInt();
			pd.retrieveProductById(itemInterest);
			System.out.println("Enter Offer:");
			int itemOffer = scan.nextInt();
			Offer newOffer = new Offer();
			newOffer.setProductId(itemInterest);
			newOffer.setOfferAmount(itemOffer);
			newOffer.setUsername(u.getUsername());
			od.createOffer(newOffer);
			System.out.println(newOffer + " has been placed");
			break;
		case "2":
			System.out.println(uid.getUserInventoryByUsername(u.getUsername()));
			

		default:
			break;
		}
		
		}
		
	
	
	public static String menu1() {
		
		System.out.println("Welcome to Lux Auto");
		System.out.println("What would you like to do?");
		System.out.println("1. Create Account");
		System.out.println("2. Sign in");
		System.out.println("3. Exit");
		String menu1 = scan.nextLine();
		return menu1;
	}
	public static void printProducts() {
		List<Product> products = ps.getProducts();
		for(Product p: products) {
			System.out.println(p);
			
		}
		
		
	}
	public static String customerMenu() {
		System.out.println("what would you like to do?");
		System.out.println("1. View Show floor");
		System.out.println("2. View Owned items");
		System.out.println("3. Exit");
		String customerMenu = scan.nextLine();
		return customerMenu;
		
		
	}
	public static String employeeMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a product");
		System.out.println("2. Remove a product");
		System.out.println("3. View pending offers");
		System.out.println("4. View outstanding payments ");
		System.out.println("5. Exit");
		String employeeMenu = scan.nextLine();
		return employeeMenu;
		
	}
	
}

