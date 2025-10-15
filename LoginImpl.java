package com.dao.impl;

import java.sql.*;

import com.dao.*;
import com.jdbc.connection.ConnectionJdbCCode;
import com.pojos.*;

public class LoginImpl  implements LoginDao{

	ConnectionJdbCCode manage = new ConnectionJdbCCode();

	public EmployeePojo insertLogin(String username) {
		
		EmployeePojo empPojo = null;
	
		Connection con = manage.getCon();
	    
		String query="select * from employee  where  user_name='"+username+"'";
	
		
	    System.out.println(query);
	    Statement st=null;
	    ResultSet rs=null;
	    
	    try{
	        st=con.createStatement();
	        rs=st.executeQuery(query);
	        if(rs.next()) {
	        	empPojo = new EmployeePojo();
	        	String userName=rs.getString("user_name");
	        	String password=rs.getString("user_password");
	        	
	        	empPojo.setUserName(userName);
                empPojo.setPassword(password);
                
	        	
	        }

	    }catch(Exception e){
	    	e.printStackTrace();
	    }	    
     
	    return empPojo;
		
	}// end of int insertLogin method.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}