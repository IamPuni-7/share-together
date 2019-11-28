package com.together.login;

import java.sql.*;
import java.util.*;

/**
 * @author punith
 *
 */
public class Register implements TogetherConstants {
	
	public static void insertUser() 
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email id");
		String email = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter Phone number");
		String phoneNumber = sc.next();
		System.out.println("Enter age");
		int age = sc.nextInt();
		System.out.println("Enter Gender");
		String gender = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String query = "Insert into LoginCredentials (Name, eMail, Phone, Password, Gender, Age) Values ('"+name+"','"+email+"','"+phoneNumber+"','"+password+"','"+gender+"','"+age+"');";
			int count = stmt.executeUpdate(query);
			System.out.println(count + " : User added!!! Thank you!!");
			String sql = "Select id from LoginCredentials where eMail='"+email+"' AND Phone='"+phoneNumber+"';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				int id = rs.getInt(1);
				System.out.println("The unique id for the user : "+name+" is : "+id+" !!! Please save this for future reference");
			}
		 }
		catch (Exception e)
		{
			 e.printStackTrace();
	    }
	}

}
