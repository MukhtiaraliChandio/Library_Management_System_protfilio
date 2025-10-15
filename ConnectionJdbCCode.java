package com.jdbc.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pojos.*;

public class ConnectionJdbCCode {



	public  ConnectionJdbCCode(){
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
			System.out.println("COnnection Created");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    private  Connection con;
    

    private static void init() throws Exception{

    	
    }// end of static init method .

	public  Connection getCon() {
		return con;
	}
	
	
	
	
	
	
	
	
	
	
	
}