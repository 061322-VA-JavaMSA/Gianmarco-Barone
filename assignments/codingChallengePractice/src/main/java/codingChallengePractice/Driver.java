package codingChallengePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Driver {
static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int n = 30;
		int p = 5;
		int q = 4;
		while (n > 0) {
			if (n>= p) {
				System.out.println(n - p);
				System.out.println(n-q);
			}else
				System.out.println("i dont know");
			
		}
	
	
	
		 
		
				
	}
	
	static String reversed(String s) {
		
		char[] letters = new char[s.length()];
		
		int lettersIndex = 0;
		for(int i = s.length() -1; i >= 0; i--) {
			letters[lettersIndex] = s.charAt(i);
			lettersIndex++;
		}
		//WIP
		
		return s;
		
		
	}
	static int reversed(int input) {
		int reversed = 0;
		
		while(input != 0) {
			reversed = reversed * 10 + input % 10;
			input/= 10;
			
		}
		
		
		return reversed;
	}

	
	static void staircase(int n) {
		for(int numSymbols = 1; numSymbols <= n; numSymbols++ ) {
			int numSpaces = n - numSymbols;
			for(int i = 0; i < numSpaces; i++) {
				System.out.print(" ");
				
			}
			for(int i = 0; i < numSymbols; i++) {
				
				System.out.print("#");
			}
			System.out.println();
		}	
		
		
		
	}
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		
		//d1,m1,y1      d2, m2, y2
				//return date	due date
				//if due date is on time or early = 0
				// if off by days 15 per day
				//if off by months 500 per month
				// off by year is 10000
		
		if(y1 <= y2) {
			if(d1 > d2 && m1 == m2 && y1< y2 ) {
				return 0;
			}
			if(d1> d2 && m1 == m2) {
				return (d1 - d2) * 15;
			}
			if(m1 > m2 && y1 == y2) {
				return (m1 - m2) * 500;
			}
			return 0;
		}
		return 10000;	
		
		
	}
	public static int sumOfArray(int array[]) {
		int arSum = 0;
		
		for(int i =0; i<array.length; i++)
			arSum+= array[i];
		
		return arSum;
	}
	public static int camelCase(String s) {
		int numberOfWords = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				
				numberOfWords++;
			}
		}
		numberOfWords += 1;
		
		return numberOfWords;
	}
	

}
