package com.BL_JDBC_EmployeeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionForJDBC 
{
	public static void main(String args[])
	{
		getConnection();
		connectionEstablished();
		EmployeeService.insertToDatabase();
		EmployeeService.updateToDatabase();
		EmployeeService.displayToDatabase();
		EmployeeService.findToDatabase();
		
		
	
	}
//JDBC-Connection = UC-1   
	public static Connection getConnection() 
	{
		Connection c = null;
		String jdbcURL="jdbc:mysql://localhost:3306/Employee_payroll";
        String uesrName = "root";
        String passward = "root";
              
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(jdbcURL, uesrName, passward);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e);
        } catch (SQLException e) {
            System.out.println("SQLException " + e);
        }
        return c;
	}
	
	
	public static void connectionEstablished()
	{
		Connection c= getConnection();
		if(c != null)
		{
			System.out.println("Connection to database is successful");
			System.out.println();
		}
	}
	
	
}	
