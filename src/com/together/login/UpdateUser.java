/**
 * 
 */
package com.together.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author punith
 *
 */
public class UpdateUser implements TogetherConstants
{
	public static void updatePassword()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email id");
		String email = sc.next();
		System.out.println("Enter Phone number");
		String phone = sc.next();
		System.out.println("Enter old Password");
		String password = sc.next();
		System.out.println("Enter new Password");
		String password_new = sc.next();
		
		Connection conn = null;
		Statement stmt = null;
		try
		{
			String output = Authentication.authenticateUser(email, phone, Phone_type);
			if(output.equalsIgnoreCase("false"))
			{
				throw new TogetherException("Invalid user credentilas!!!!");
			}
			else
			{
				if(output.equalsIgnoreCase(password))
				{
					Class.forName(JDBC_DRIVER);
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt = conn.createStatement();
					String sql="Update LoginCredentials set Password='"+password_new+"' where eMail='"+email+"' AND Phone='"+phone+"';";
					int count = stmt.executeUpdate(sql);
					if(count == 1)
					{
						System.out.println("Congrats!!! your password updated from(old) : "+password+" to(new) : "+password_new);
					}
					else
					{
						throw new TogetherException("Password updation failed!!! Try again later...");
					}
				}
				else
				{
					throw new TogetherException("ALERT : Wrong old password!!! Try again...");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void updatePassword(String email , String phone , String new_pass , String old_pass)
	{	
		Connection conn = null;
		Statement stmt = null;
		try
		{
					Class.forName(JDBC_DRIVER);
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					stmt = conn.createStatement();
					String sql="Update LoginCredentials set Password='"+new_pass+"' where eMail='"+email+"' AND Phone='"+phone+"';";
					int count = stmt.executeUpdate(sql);
					if(count == 1)
					{
						System.out.println("Congrats!!! your password updated from(old) : "+old_pass+" to(new) : "+new_pass);
					}
					else
					{
						throw new TogetherException("Password updation failed!!! Try again later...");
					}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
