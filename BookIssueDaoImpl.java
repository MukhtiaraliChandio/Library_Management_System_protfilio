package com.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

import com.dao.*;
import com.jdbc.connection.ConnectionJdbCCode;
import com.pojos.*;

public class BookIssueDaoImpl implements BookIssueDao {


	
	ConnectionJdbCCode manage = new ConnectionJdbCCode();
	
	BookIssuePojo pojo=new BookIssuePojo();

@Override	
public List<MemberPojo> getMembers() {
		
	List<MemberPojo> list = new ArrayList<MemberPojo>();
	Connection con = manage.getCon();
	String sql = "select * from member";
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

	
public List<BookPojo> getIsbnNo(String isbn){
	
	BookPojo book1 =null;
	
	List<BookPojo> list = new ArrayList<BookPojo>();
	Connection con = manage.getCon();
	String sql = "select * from book where where isbn='"+isbn+"' ";
	try {
				
		   Statement stm = con.createStatement();
		   ResultSet rs = stm.executeQuery(sql);
		   while(rs.next()){
					
		     int employeeId = rs.getInt("employee_id");
			// int memberId=rs.getInt("member_id");
			 int bookId=rs.getInt("book_id");
			 String bookName=rs.getString("book_name");
			 String remarks=rs.getString("remarks");
			 
			 book1=new BookPojo();
			 book1.setEmployeeId(employeeId);
			 //book1.setMemberId(memberId);
			 book1.setBookId(bookId);
			 book1.setBookName(bookName);
			 book1.setRemarks(remarks);
	
	
		   }
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}
	
	return list;
	
}


public String getDateFormate(Date date) {
	String dateStr[] = date.toString().split(" ");
	
	return  dateStr[5]+"-"+getMonthNumbert(dateStr[1])+"-"+dateStr[2];
}

public String getMonthNumbert(String month) {
	String monthNum = "01";
	switch (month) {
	case "Aug":
		monthNum = "08";
		break;
	default:
		break;
	}
	return monthNum;
}
///// 2nd getDate



/*public List<BookPojo> getIsbnNoCompare(String isbnNo){
	
	BookPojo book2 =null;
	
	List<BookPojo> list = new ArrayList<BookPojo>();
	Connection con = manage.getCon();
	String sql = "select * from book where where isbn='"+isbnNo+"' ";
	try {
				
		   Statement stm = con.createStatement();
		   ResultSet rs = stm.executeQuery(sql);
		   while(rs.next()){
					
		     int employeeId = rs.getInt("employee_id");
			// int memberId=rs.getInt("member_id");
			 int bookId=rs.getInt("book_id");
			 String bookName=rs.getString("book_name");
			 String remarks=rs.getString("remarks");
			 
			 book2=new BookPojo();
			 book2.setEmployeeId(employeeId);
			// book2.setMemberId(memberId);
			 book2.setBookId(bookId);
			 book2.setBookName(bookName);
			 book2.setRemarks(remarks);
	
	
		   }
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}
	
	return list;
	
	
	
	
}


/*public String getDateFormateEx(Date date) {
	String dateStr[] = date.toString().split(" ");
	
	return  dateStr[5]+"-"+getMonthNumbert(dateStr[1])+"-"+dateStr[2];
}

public String getMonthNumberExt(String month) {
	String monthNum = "01";
	switch (month) {
	case "Aug":
		monthNum = "08";
		break;
	default:
		break;
	}
	return monthNum;
}*/




@Override
public int saveBookIssue(BookIssuePojo  bookIssue) {
		
	
	Connection con = manage.getCon();

	String query="insert into book_issue(book_id, member_id, date_of_issue,  fine, remarks) values ("+bookIssue.getBookId()+", "+bookIssue.getMemberId()+", '"+getDateFormate(bookIssue.getDateofissue())+"',"+bookIssue.getFine()+" , '"+bookIssue.getRemarks()+"'  ) ";

	System.out.println(query);
	Statement st=null;
	try{
		st=con.createStatement();
		System.out.println(bookIssue);
		int rows=st.executeUpdate(query);

		return rows;

	}catch(Exception e){
		e.printStackTrace();
	}	    


	
		return 0;
	




}

public int updateBookIssue(BookIssuePojo  bookReturn) {


		Connection con = manage.getCon();
		
		String query="update book_issue Set book_id='"+bookReturn.getBookId()+"',  member_id='"+bookReturn.getMemberId()+"',  date_of_return='"+getDateFormate(bookReturn.getDateofreturn())+"', fine='"+bookReturn.getFine()+"', remarks='"+bookReturn.getRemarks()+"' where book_issue_id="+bookReturn.getBookIssueId()+" ";
		
		JOptionPane.showMessageDialog(null,""+bookReturn.getBookIssueId());
		
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


	
//@Override

	

	
	
	
	
	
	
	
	
	
	
}