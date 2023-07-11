package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UDE {

	public static void main(String[] args) {
		System.out.println("Main Started");
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();

			if (un.equals("Deeps") && pwd.equals("pass")) {
				System.out.println("Welcome " + un);
			} else {
				throw new UserNotFoundException();
			}

		}

		catch (UserNotFoundException unf) {
			//System.out.println("From catch unf");
			//System.out.println(unf);
			unf.printStackTrace();
		}

		catch (Exception ae) {
			System.out.println("IO");
		} finally {
			System.out.println("Finally .....");
		}
		System.out.println("Main Ends");

	}

}
