/**
 * 
 */
package com.together.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author punith
 *
 */
public class Authentication implements TogetherConstants
{
	public static String authenticateUser(String email , String password , String type)
	{
		String flag = "false";
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql="";
			if(type.equalsIgnoreCase("password"))
			{
			sql = "Select Password from LoginCredentials where eMail='"+email+"' AND Password='"+password+"';";
			}
			else if (type.equalsIgnoreCase("phoneNumber"))
			{
				sql = "Select Password from LoginCredentials where eMail='"+email+"' AND Phone='"+password+"';";	
			}
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				flag = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
}
