package com.revature;
import java.util.stream.*;
public class calcAssign {

	public static void main(String[] args) {
		/*
		 * Xadd
		 * 	-throw exception if result is 13
		 * Xsubtract
		 * Xmultiply
		 * xdivide
		 * 	-throw exception if dividing by zero
		 * xsum of array
		 */
		
		
		
		
	}

	public int add(int a, int b) {
		int c = a + b;
		if (c == 13) {
			throw new error13Exception();
			
		}
		
		return c;
		
	}
	public int subtract(int a, int b) {
		int c = a + b;
		
		return c;
		
	}
	public  int multiply(int a, int b) {
		int c = a + b;
		
		
		return c;
		
	}
	public int divide(int a, int b)throws divideByZeroException{
		int c = a / b;
		if (b == 0) {
			throw new divideByZeroException();
			
		}
		else
			return c;
		
	}
	public  int arraysum(int[] intadd) {
		
		int arraysum = IntStream.of(intadd).sum();
		return arraysum;
	}
}
