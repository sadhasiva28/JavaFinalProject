package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOMainClass {

	public static void main(String[] args) {
		System.out.println("Main Started");
		try {
		int x=0;
		int y=0;
		int z=0;
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter x");
		x= Integer.parseInt(br.readLine());
		System.out.println("Enter y");
		y= Integer.parseInt(br.readLine());
		z= x/y;
		System.out.println("z =" +z);
		}
		
		catch(ArithmeticException ae) {
			System.out.println("Dont Divide by 0");
		}
		catch(IOException ae) {
			System.out.println("IO");
		}
		catch(Exception ae) {
			System.out.println("IO");
		}
		finally {
			System.out.println("Finally .....");
		}
		System.out.println("Main Ends");

	}

}
