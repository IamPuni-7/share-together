/**
 * 
 */
package com.together.login;

import java.util.*;

/**
 * @author punith
 *
 */

public class Welcome 
{
	@SuppressWarnings({ "resource"})
	public static void main(String[] args) throws TogetherException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Together!!!");
		System.out.println("Select 1 to Login");
		System.out.println("Select 2 to Register");
		System.out.println("Select 3 for Forget Password");
		System.out.println("Select 4 to Update Password");
		if(sc.hasNextInt())
		{
		int input = sc.nextInt();
		switch (input)
		{
		case 1 : Login.checkUser();
		break;
		case 2 : Register.insertUser();
		break;
		case 3 : Forget.searchUser();
		break;
		case 4 : UpdateUser.updatePassword();
		break;
		default : System.out.println("Not a valid selection!!!!");
		}
		}
		else
		{
			throw new TogetherException("Enter ony numbers, ranging from 1-4(inclusive both)");
		}
	}
}