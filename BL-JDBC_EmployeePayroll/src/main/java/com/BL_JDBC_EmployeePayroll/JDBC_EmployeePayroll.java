package com.BL_JDBC_EmployeePayroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

import com.mysql.jdbc.Driver;

/*
 * Emplyoee-Payroll program with JDBC-CRUD operations
 * All JDBC CRUD operation done in main method.
 */


public class JDBC_EmployeePayroll 
{
    public static void main( String[] args )
    {
    	Connection connection = null;
		String jdbcURL="jdbc:mysql://localhost:3306/Employee_payroll";
        String uesrName = "root";
        String passward = "root";
            
        //listDriver();
        
        
        try {
        	   	Class.forName("com.mysql.jdbc.Driver"); 
	        	System.out.println("Driver loaded.!"); 
        	}catch (ClassNotFoundException e) {
        		throw new IllegalStateException("Cannot find the driver in classPath...!", e);
               }
   
  
        try {
        	
	        	System.out.println("Connecting to database :" +jdbcURL ); 
	        	connection = DriverManager.getConnection(jdbcURL, uesrName, passward);
	        	System.out.println("Connection is successful :" + connection ); 
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
        System.out.println();
    
  
  
//Insert data into table
		  try (Connection conn = DriverManager.getConnection(jdbcURL, uesrName, passward)) 
		  {
		      	if(conn!= null)
		    	{
		    
		    	String sql = "INSERT INTO Employee_payroll (id, name, gender, salary, start) VALUES (?, ?, ?, ?, ?)";
		    	 
		    	PreparedStatement statement = conn.prepareStatement(sql);
		    	statement.setString(1, "4");
		    	statement.setString(2, "Brouce");
		    	statement.setString(3, "M");
		    	statement.setString(4, "4000000");
		    	statement.setString(5, "2021-09-01");
		    	 
		    	int rowsInserted = statement.executeUpdate();
		    	if (rowsInserted > 0) {
		    	    System.out.println("A new user was inserted successfully!");
		    	}
		    	System.out.println();


    
//Display data into table
		    System.out.println("Displaying employee_payroll database: ");
			String sql1 = "SELECT * FROM Employee_payroll";
			 
			Statement statement1 = conn.createStatement();
			ResultSet result = statement1.executeQuery(sql1);
			 
			int count = 0;
			 
			while (result.next()){
			   // String uesrName1 = result.getString(2);
			   // String passward1 = result.getString(3);
			    String id = result.getString("id");
			    String name = result.getString("name");
			    String gender = result.getString("gender");
			    String salary = result.getString("salary");
			    String start = result.getString("start");
			    
			    String output = "User #%d: %s - %s - %s - %s - %s";
			    System.out.println(String.format(output, ++count, id, name, gender, salary, start));
			}
			System.out.println();   
		    
    
//Update data into table
			System.out.println("Updating employee_payroll database: ");
			String sql2 = "UPDATE Employee_payroll SET id=?, name=?, gender=? WHERE name=?";
			 
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			statement2.setString(1, "4");
			statement2.setString(2, "William");
			statement2.setString(3, "M");
			statement2.setString(4, "Bruce");
			 
			int rowsUpdated = statement2.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			}
			System.out.println();      
		   
 	
//Delete data into table
				System.out.println("Deleting employee_payroll database: ");
				String sql3 = "DELETE FROM Employee_payroll WHERE name=?";
				 
				PreparedStatement statement3 = connection.prepareStatement(sql3);
				statement3.setString(1, "Elena");
				 
				int rowsDeleted = statement3.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("A user was deleted successfully!");
				}
		  }
	}
 catch (SQLException ex) {
			        ex.printStackTrace();
			    }

	}		  
 
//  private static void listDriver() 
//	{
//		Enumeration<Driver> driverList = DriverManager.getDrivers();
//		while(driverList.hasMoreElements())
//		{
//			Driver driverClass = (Driver) driverList.nextElement(); 
//			System.out.println(" " + driverList.getClass().getName());
//		}
//	}
  
   }  
