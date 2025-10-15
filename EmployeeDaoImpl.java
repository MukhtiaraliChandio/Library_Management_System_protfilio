package com.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dao.*;
import com.jdbc.connection.ConnectionJdbCCode;
import com.pojos.*;
import com.dao.impl.*;

public class EmployeeDaoImpl implements  EmployeeDao {

	
	ConnectionJdbCCode manage = new ConnectionJdbCCode();
	EmployeePojo emp=new EmployeePojo();
	
	
////////************************************** Start  of   Save  Method **************************////////

//@Override
public int saveEmployee(EmployeePojo emp) {
	Connection con = manage.getCon();
     
    String query="insert into employee (employee_name, f_name, surname, cnic, contact_no, email_id, gender, remarks, user_name, user_password) values ('"+emp.getEmployeeName()+"','"+emp.getfName()+"', '"+emp.getSurname()+"', '"+emp.getCnic()+"','"+emp.getContactNo()+"','"+emp.getEmailId()+"','"+emp.getGender()+"', '"+emp.getRemarks()+"', '"+emp.getUserName()+"', '"+emp.getPassword()+"' )";
    
    System.out.println(query);
    Statement st=null;
    try{
        st=con.createStatement();
        System.out.println(emp);
       int rows=st.executeUpdate(query);
        
        return rows;
                
    }catch(Exception e){
    	e.printStackTrace();
    }	    
	
	return 0;
}

/////************************************** end of   add method **************************////////////////

/////************************************** Start of  Update Method **************************///////////
//@Override
public int updateEmployee(EmployeePojo emp) {
	Connection con = manage.getCon();
	String query="Update employee Set employee_name='"+emp.getEmployeeName()+"', f_name='"+emp.getfName()+"', surname='"+emp.getSurname()+"',  cnic='"+emp.getCnic()+"',  contact_no='"+emp.getContactNo()+"',     remarks='"+emp.getRemarks()+"' where employee_id="+emp.getEmployeeId()+" ";
    System.out.print(query);

        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;

        }catch(Exception e){
        	e.printStackTrace();
        }
 
	
	return 0;
}

////////////////////*********************************end of save method.****************************//////////////////////////////////

//@Override
public  int deleteEmployee(EmployeePojo emp) {
	
	
	Connection con = manage.getCon();
	
	JOptionPane.showMessageDialog(null,""+emp.getEmployeeId());
		
	    
	    String query="delete from employee where employee_id="+emp.getEmployeeId();
		System.out.print(query);

		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;

		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		

	

	
}



////////////////////*********************************Stat of Select Method.****************************//////////////////////////////////
//@Override
public List<EmployeePojo> getEmployees() {
	
	List<EmployeePojo> list = new ArrayList<EmployeePojo>();
	//JOptionPane.showMessageDialog(null, "Employe Query");
	
	Connection con = manage.getCon();
	String sql = "select * from employee";
	System.out.print(sql);

	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
					    
			
			int employeeId = rs.getInt(1);
	               String employeeName=rs.getString(2);
			String fName=rs.getString(3);
			String surname=rs.getString(4);
			String  cnicNo=rs.getString(5);
			String  contactNo=rs.getString(6);
			String  emailId=rs.getString(7);
		    String  gender=rs.getString(8);
		    String  userName=rs.getString(9);
		    String  password=rs.getString(10);
		    String  remarks=rs.getString(11);

		  //JOptionPane.showMessageDialog(null, "List Size : "+);
		    
			EmployeePojo emp1 = new EmployeePojo();
			emp1.setEmployeeId(employeeId);
		    emp1.setEmployeeName(employeeName);
			emp1.setfName(fName);
			emp1.setSurname(surname);
			emp1.setCnic(cnicNo);
			emp1.setContactNo(contactNo);
			emp1.setEmailId(emailId);
		    emp1.setGender(gender);
		    emp1.setUserName(userName);
		    emp1.setPassword(password);
			emp1.setRemarks(remarks);
			
			list.add(emp1);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
		
		
	}
	//JOptionPane.showMessageDialog(null, "List Size : "+list.size());
	return list;
}


////////////////////*********************************end of save method.****************************//////////////////////////////////




////////////////////*********************************Start of Select  CNIC No Method.****************************//////////////////////////////////

//@Override
public EmployeePojo getEmployeeByCNICNumber(String cnicNumber) {
	
	EmployeePojo emp=null;

	Connection con = manage.getCon();
	String sql = "select * from employee where cnic = '"+cnicNumber+"' ";
	
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()){
			int employeeId = rs.getInt("employee_id");
			String employeeName=rs.getString("employee_name");
			String fName=rs.getString("f_name");
			String surname=rs.getString("surname");
			String  cnicNo=rs.getString("cnic");
			String  contactNo=rs.getString("contact_no");
			String  emailId=rs.getString("email_id");
		    String  gender=rs.getString("gender");
		    String  userName=rs.getString("user_name");
		    String  password=rs.getString("user_password");
		    String  remarks=rs.getString("remarks");

			emp=new EmployeePojo();
			
			emp.setEmployeeId(employeeId);
			emp.setEmployeeName(employeeName);
			emp.setfName(fName);
			emp.setSurname(surname);
			emp.setCnic(cnicNo);
			emp.setContactNo(contactNo);
		    emp.setGender(gender);
			emp.setRemarks(remarks);
			emp.setEmailId(emailId);
	        emp.setUserName(userName);
	        emp.setPassword(password);
			//list.add(emp);
			
		}
	} catch (Exception e) {
		
		e.printStackTrace();
		
		
	}
	
	
	
	return emp;
	
}



////////////////////*********************************end of Select CNIC No Method.****************************//////////////////////////////////

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}