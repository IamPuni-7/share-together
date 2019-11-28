/**
 * 
 */
package com.together.login;

import java.util.*;

/**
 * @author punith
 *
 */
public class Login implements TogetherConstants {

	public static void checkUser() 
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email id");
		String email = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		try
		{
			String output = Authentication.authenticateUser(email, password, Password_type);
			if(output.equalsIgnoreCase("false"))
			{
				System.out.println("You are new user!!! Select 1 for Registration");
				if(sc.hasNextInt())
				{
					int input = sc.nextInt();
					switch(input)
					{
					case 1 : Register.insertUser();
					break;
					default : System.out.println("Select only '1' for register!!!");
					}
				}
				else
				{
					throw new TogetherException("Invalid selection!!!!");
				}
			}
			else
			{
				System.out.println("Enter source location");
				String source = sc.next();
				System.out.println("Enter destination location");
				String destination = sc.next();
				System.out.println("Fetching your co-travellers for source : "+source+" and destination : "+destination+"..........");
				System.out.println("Below are the users with same source and destination as your's");
			}
		}
		catch (Exception e)
		{
			 e.printStackTrace();
		}
	}
}
