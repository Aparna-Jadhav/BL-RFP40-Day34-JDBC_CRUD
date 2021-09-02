package com.BL_JDBC_EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeService 
{
//JDBC-Connection = UC-2    
	static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static int st;//status
    
    public static int insertToDatabase() 
    {
//JDBC-Connection = UC-3    
    	System.out.println("INSERTION OPERATION : ");
        con = ConnectionForJDBC.getConnection();
        try
        {
           	if(con!= null)
        	{
        	  	String sql = "INSERT INTO Employee_payroll (id, name, gender, salary, start) VALUES (?, ?, ?, ?, ?)";
		    	 
		    	PreparedStatement statement = con.prepareStatement(sql);
		    	statement.setString(1, "5");
		    	statement.setString(2, "Elena");
		    	statement.setString(3, "F");
		    	statement.setString(4, "5000000");
		    	statement.setString(5, "2021-09-02");
		    	 
		    	int rowsInserted = statement.executeUpdate();
		    	if (rowsInserted > 0) {
		    	    System.out.println("A new user was inserted successfully!");
		    	    System.out.println();
		    	}
        	}
        }catch (SQLException ex) {
	        ex.printStackTrace();
	    }
    	finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }
      
//JDBC-Connection = UC-4        
    public static int updateToDatabase()
    {
    	System.out.println("UPDATION OPERATION : ");
    	 con = ConnectionForJDBC.getConnection();
         try
         {
          	if(con!= null)
         	{
    			String sql = "UPDATE Employee_payroll SET salary=? WHERE name=?";
		 
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, 3000000);
				statement.setString(2, "Terisa");
				
				int rowsUpdated = statement.executeUpdate();
				if (rowsUpdated > 0) {
				    System.out.println("An existing user was updated successfully!");
				    System.out.println();
				}
		      } 
         }catch (SQLException ex) {
		        ex.printStackTrace();
		         }
				finally {
			        try {
			            con.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return st;
    }

  //JDBC-Connection = UC-5    
    public static int displayToDatabase()
    {
    	System.out.println("DISPLAY DATABASE : ");
    	 con = ConnectionForJDBC.getConnection();
         try
         {
         	if(con!= null)
         	{
    			String sql = "SELECT * FROM Employee_payroll";
    			Statement statement = con.createStatement();
    			ResultSet rs = statement.executeQuery(sql);
		 		int count = 0;
	   			 
	   			while (rs.next()){
	   			   
	   			    String id = rs.getString("id");
	   			    String name = rs.getString("name");
	   			    String gender = rs.getString("gender");
	   			    String salary = rs.getString("salary");
	   			    String start = rs.getString("start");
	   			    
	   			    String output = "User #%d: %s - %s - %s - %s - %s";
	   			    System.out.println(String.format(output, ++count, id, name, gender, salary, start));
	   			}
	   			System.out.println();
		      } 
         }catch (SQLException ex) {
		        ex.printStackTrace();
		         }
				finally {
			        try {
			            con.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return st;
    }

//JDBC-Connection = UC-6    
    public static int findToDatabase()
    {
    	System.out.println("FIND MIN MAX SUM AVG FROM DATABASE : ");
   	 	con = ConnectionForJDBC.getConnection();
        try
        {
        	if(con!= null)
        	{
   			String sql = "SELECT MIN(salary), MAX(salary), SUM(salary), AVG(salary), COUNT(salary) FROM Employee_payroll";
   			Statement statement = con.createStatement();
   			ResultSet rs = statement.executeQuery(sql);
		 		int count = 0;
	   			 
	   			while (rs.next()){
	   			   
	   			    int minSalary = rs.getInt(1);
	   			    int maxSalary = rs.getInt(2);
	   			    int sumSalary = rs.getInt(3);
	   			    int avgSalary = rs.getInt(4);
	   			    int countSalary = rs.getInt(5);
	   			    
	   			    String output =("User #%s: %s - %s - %s - %s - %s");
	   			   System.out.println(String.format("User record :  \n MinimumSalary : %d \n MaximumSalary : %d \n SumOfSalary : %d \n AvarageSalary : %d \n CountSalary : %d \n ", minSalary, maxSalary, sumSalary, avgSalary, countSalary));
	   			   System.out.println();
	   			}
		      } 
        }catch (SQLException ex) {
		        ex.printStackTrace();
		         }
				finally {
			        try {
			            con.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    }
			    return st;
    }
    
  
}