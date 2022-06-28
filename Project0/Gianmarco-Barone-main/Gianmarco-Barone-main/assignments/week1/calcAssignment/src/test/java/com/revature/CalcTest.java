package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
	private static calcAssign sut;
	
	
	 @BeforeAll
	    public static void setUp() {
	        sut = new calcAssign();
	    }

	    @AfterAll
	    public static void tearDown() {
	        System.out.println("Tear down behavior.");
	    }
                     
	    @BeforeEach
	    public void before() {
	        System.out.println("@Before each behavior");
	    }
	   @Test
	    public void addSevenAndThree() {
		   int expected = 10;
		   int actual = sut.add(7, 3);
		   
		   assertEquals(expected,actual);
		   
	   }
	   @Test
	   public void addTwelveandOne() {
		   assertThrows(error13Exception.class, () -> sut.add(12, 1) );
		   
	   }
	   
	   @Test
	   public void subtractTwentyAndOneHundred(){
		   int expected = 80;
		   int actual = sut.subtract(20, 100);
		   
		   assertEquals(expected,actual);
		   
	   }
	   @Test
	   public void subtractSevenAndTen(){
		   int expected = 3;
		   int actual = sut.subtract(7, 10);
		   
		   assertEquals(expected,actual);
	   }
	   @Test
	   public void multiplyFiveAndFive() {
		   int expected = 25;
		   int actual = sut.multiply(5, 5);
		   
		   assertEquals(expected,actual);
		   }
	   @Test
	   public void multiplyNineAndFive() {
		   int expected = 45;
		   int actual = sut.multiply(9, 5);
		   
		   assertEquals(expected,actual);
		   
	   }
	   @Test
	   public void divideOneHundredByFive(){
		   int expected = 20;
		   int actual = sut.divide(100, 5);
		   assertEquals(expected, actual);
		   
	   }
	   @Test
	   public void divideTenByZero() {
		   assertThrows(divideByZeroException.class, () -> sut.divide(10, 0));
		   
	   }
	   @Test
	   public void addArray() {
		   int[] array = {10,10,10};
		   int expected = 30;
		   int actual = sut.arraysum(array);
		   assertEquals(expected,actual);
	   }
	   @Test
	   public void addArray2() {
		   int[] array = {9,9,10};
		   int expected = 28;
		   int actual = sut.arraysum(array);
		   assertEquals(expected,actual);
		   
	   }
}
	