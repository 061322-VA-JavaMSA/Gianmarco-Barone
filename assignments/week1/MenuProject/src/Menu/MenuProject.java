package Menu;
import java.util.Scanner;


public class MenuProject {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.println("Welcome, please select an option");
		System.out.println("1. generate a random number");
		System.out.println("2. reverse a string");
		System.out.println("Exit");
		String userInput = scan.nextLine();
		

	}

	public static String Menu(String userInput) {
		
		switch(userInput) {
		
		case "1":
			System.out.println((int)(Math.random()*1000));
			break;
		case "2":
			System.out.println("please enter a word");
			String reverseWord = scan.nextLine();
			System.out.println(StringBuilder(reverseWord).reverse().toString());
		case "3":
			
		default:
			System.out.println("Invalid entry, please try again");
		
		}
		
		
		
	}

	
}
