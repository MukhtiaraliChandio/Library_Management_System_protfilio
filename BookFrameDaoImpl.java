package com.dao.impl;

import java.sql.*;
import java.util.*;

import javax.swing.*;

import com.dao.*;
import com.jdbc.connection.ConnectionJdbCCode;
import com.pojos.*;

public class BookFrameDaoImpl implements BookDao{

	
	
	ConnectionJdbCCode manage = new ConnectionJdbCCode();
	
	BookPojo bkp = new BookPojo ();
//	BookDao
	


@Override
public int saveBookdata(BookPojo bkp) {
		
		Connection con = manage.getCon();
	     
	    String query="insert into book (book_name, book_category, language, author_editor, editor_volume, year_of_publishing, isbn, number_of_pages, remarks) values ('"+bkp.getBookName()+"','"+bkp.getBookCategory()+"', '"+bkp.getLanguage()+"', '"+bkp.getAuthorEditor()+"','"+bkp.getEditorVolume()+"','"+bkp.getYearofPublishing()+"',  '"+bkp.getIsbnNo() +"',    '"+bkp.getNumberofPages()+"',  '"+bkp.getRemarks()+"'  )";
	    
	    System.out.println(query);
	    Statement st=null;
	    try{
	        st=con.createStatement();
	        System.out.println(bkp);
	       int rows=st.executeUpdate(query);
	        
	        return rows;
	                
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		
		
		
		return 0;
		
	}
	
	
public int updateBookData(BookPojo pojo) {
	

     	Connection con = manage.getCon();
	    String query="Update book Set book_name='"+bkp.getBookName()+"',"+ "book_category='"+bkp.getBookCategory()+"', language='"+bkp.getLanguage()+"', "+ " author_editor='"+bkp.getAuthorEditor()+"',  editor_volume='"+bkp.getEditorVolume()+"',   year_of_publishing='"+bkp.getYearofPublishing()+"', isbn='"+bkp.getIsbnNo()+"',  number_of_pages='"+bkp.getNumberofPages()+"', purchase_date='"+"'   remarks='"+bkp.getRemarks()+"' where book_id="+bkp.getBookId()+" ";
	
	     //JOptionPane.showMessageDialog(null,""+emp.getMemberId());
	
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

	public int deleteMember(MemberPojo emp) {
		
		Connection con = manage.getCon();
			
		JOptionPane.showMessageDialog(null,""+bkp.getBookId());
			
		    
		    String query="delete from book where book_id="+bkp.getBookId();
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


public List<BookPojo> getBooks() {

		
		  List<BookPojo> list = new ArrayList<BookPojo>();
		  Connection con = manage.getCon();
		  String sqlQuery = "select * from book";
		  
		  try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sqlQuery);
				System.out.print(sqlQuery);
				while(rs.next()){
					
					int employeeId=rs.getInt("employee_id");
					int bookId=rs.getInt("book_id");
					String bookName=rs.getString("book_name");
					String bookCategory=rs.getString("book_category");
					String language=rs.getString("language");
					String  authorEditor=rs.getString("author_editor");
					String  editorVolume=rs.getString("editor_volume");
					String  yearofPublishing=rs.getString("year_of_publishing");
					String  isbnNo=rs.getString("isbn");
					//String  purchaseFrom=rs.getString("purchase_form");
				    String   numberofPages=rs.getString("number_of_pages");
				    //String   purchase_date=rs.getString("purchase_date");
					String  remarks=rs.getString("remarks");
		
					BookPojo book1=new BookPojo();
					
				
					book1.setEmployeeId(employeeId);
					book1.setBookId(bookId);
					book1.setBookName(bookName);
					book1.setBookCategory(bookCategory);
					book1.setLanguage(language);
					book1.setAuthorEditor(authorEditor);
					book1.setEditorVolume(editorVolume);
					book1.setYearofPublishing(yearofPublishing);
					book1.setIsbnNo(isbnNo);
					book1.setNumberofPages(numberofPages);
					book1.setRemarks(remarks);
					
						
				    list.add(book1);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		
		
	
	}// end of getMembers method.
	
	
public BookPojo getIsbn(String isbn) {
		BookPojo book1 =null;

		Connection con = manage.getCon();
		String sql = "select * from book where isbn='"+isbn+"' ";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()){
								///list.add(m1);
				
				//int memberId=rs.getInt("member_id");
				int employeeId=rs.getInt("employee_id");
				int bookId=rs.getInt("book_id");
				String bookName=rs.getString("book_name");
				String bookCategory=rs.getString("book_category");
				String language=rs.getString("language");
				String  authorEditor=rs.getString("author_editor");
				String  editorVolume=rs.getString("editor_volume");
				String  yearofPublishing=rs.getString("year_of_publishing");
				String  isbnNo=rs.getString("isbn");
			    String   numberofPages=rs.getString("number_of_pages");
				String  remarks=rs.getString("remarks");
	
			      book1=new BookPojo();
				
			  	//book1.setMemberId(memberId);
			    book1.setEmployeeId(employeeId);  
				book1.setBookId(bookId);
				book1.setBookName(bookName);
				book1.setBookCategory(bookCategory);
				book1.setLanguage(language);
				book1.setAuthorEditor(authorEditor);
				book1.setEditorVolume(editorVolume);
				book1.setYearofPublishing(yearofPublishing);
				book1.setIsbnNo(isbnNo);
				book1.setNumberofPages(numberofPages);
				book1.setRemarks(remarks);
				
				//list.add(book1);
				
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return book1;
	}







@Override
public int deleteBook(MemberPojo emp) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public int updateBook(BookPojo bkp) {
	// TODO Auto-generated method stub
	return 0;
}







	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}