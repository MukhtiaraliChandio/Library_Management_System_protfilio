package com.dao.impl;

import java.sql.*;
import java.util.*;

import javax.swing.*;

import com.jdbc.connection.ConnectionJdbCCode;
import com.pojos.MemberPojo;

import com.dao.*;

public class MemberDaoImpl implements MemberDao{


	ConnectionJdbCCode manage = new ConnectionJdbCCode();
    MemberPojo memb=new MemberPojo();


	public int saveMember(MemberPojo emp){

		Connection con = manage.getCon();

		String query="insert into member (member_name, f_name, surname, cnic, contact_no, guardian_occupation,  "
				+ "address, gender, remarks) values ('"+emp.getMemberName()+"','"+emp.getfName()+"', "
				+ "'"+emp.getSurname()+"', '"+emp.getCnic()+"','"+emp.getContactNo()+"',"
				+ "'"+emp.getGuardianOccupation()+"','"+emp.getAddress()+"','"+emp.getGender()+"', '"+emp.getRemarks()+"' )";

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
	}// end of int save member method.


//@Override
public int updateMember(MemberPojo emp) {


	Connection con = manage.getCon();
	String query="Update member Set member_name='"+emp.getMemberName()+"',"+ "f_name='"+emp.getfName()+"', surname='"+emp.getSurname()+"', "+ " cnic='"+emp.getCnic()+"',  contact_no='"+emp.getContactNo()+"',   guardian_occupation='"+emp.getGuardianOccupation()+"', address='"+emp.getAddress()+"', gender='"+emp.getGender()+"', remarks='"+emp.getRemarks()+"' where member_id="+emp.getMemberId()+" ";
	
	JOptionPane.showMessageDialog(null,""+emp.getMemberId());
	
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
///
	//@Override
public int deleteMember(MemberPojo emp) {
		Connection con = manage.getCon();
		
	JOptionPane.showMessageDialog(null,""+emp.getMemberId());
		
	    
	    String query="delete from member where member_id="+emp.getMemberId();
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

///	
	
	//@Override
public List<MemberPojo> getMembers() {

			
		  List<MemberPojo> list = new ArrayList<MemberPojo>();
		  Connection con = manage.getCon();
		  String sql = "select * from member";
		  
		  try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				//System.out.print(sql);
				while(rs.next()){
					int employeeId = rs.getInt("employee_id");
					int memberId=rs.getInt("member_id");
					String memberName=rs.getString("member_name");
					String fName=rs.getString("f_name");
					String surname=rs.getString("surname");
					String  cnicNo=rs.getString("cnic");
					String  contactNo=rs.getString("contact_no");
					String  guardianOccupation=rs.getString("guardian_occupation");
					String  address=rs.getString("address");
					String  gender=rs.getString("gender");
				    String  remarks=rs.getString("remarks");
		
					MemberPojo m1 = new MemberPojo();
					m1.setEmployeeId(employeeId);
				
					
					m1.setMemberId(memberId);
					m1.setMemberName(memberName);
					m1.setfName(fName);
					m1.setSurname(surname);
					m1.setCnic(cnicNo);
					m1.setContactNo(contactNo);
					m1.setGuardianOccupation(guardianOccupation);
				    m1.setAddress(address);
				    m1.setGender(gender);
					m1.setRemarks(remarks);
					
					list.add(m1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		
		
	
	}// end of getMembers method.
	
	
//@Override
public MemberPojo getMembersByContactNumber(String contact) {
		MemberPojo m1 =null;

		Connection con = manage.getCon();
		String sql = "select * from member where contact_no = '"+contact+"' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()){
				int employeeId = rs.getInt("employee_id");
				int memberId=rs.getInt("member_id");
				String memberName=rs.getString("member_name");
				String fName=rs.getString("f_name");
				String surname=rs.getString("surname");
				String  cnicNo=rs.getString("cnic");
				String  contactNo=rs.getString("contact_no");
				String  guardianOccupation=rs.getString("guardian_occupation");
				String  address=rs.getString("address");
				String  gender=rs.getString("gender");
				String  remarks=rs.getString("remarks");

				m1 = new MemberPojo();
				m1.setEmployeeId(employeeId);
				m1.setMemberId(memberId);
				m1.setMemberName(memberName);
				m1.setfName(fName);
				m1.setSurname(surname);
				m1.setCnic(cnicNo);
				m1.setContactNo(contactNo);
				m1.setGuardianOccupation(guardianOccupation);
				m1.setAddress(address);
				m1.setGender(gender);
				m1.setRemarks(remarks);

				///list.add(m1);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return m1;
	}



	
	
	
}