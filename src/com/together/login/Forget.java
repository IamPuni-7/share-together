/**
 * 
 */
package com.together.login;

import java.util.Scanner;

/**
 * @author punith
 *
 */

public class Forget implements TogetherConstants
{
	public static void searchUser()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email id");
		String email = sc.next();
		System.out.println("Enter Phone number");
		String phone = sc.next();
		
		try
		{
			String output = Authentication.authenticateUser(email, phone, Phone_type);
			if(output.equalsIgnoreCase("false"))
			{
				throw new TogetherException("Enter valid email and phone number!!!!");
			}
			else
			{
				System.out.println("Hi!! Your password is : "+output);
				System.out.println("Select 1 to update new password and 2 for exit");
				if(sc.hasNextInt())
				{
					int i = sc.nextInt();
					switch(i)
					{
					case 1 : System.out.println("Enter new password");
							 String new_pass = sc.next();
							 UpdateUser.updatePassword(email, phone, new_pass, output);
							 break;
					case 2 : System.out.println("Thank you!!!!");
					default : throw new TogetherException("Invalid Selection");
					}
				}
				else
				{
					throw new TogetherException("Entry restricted to only numbers 0-9");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
