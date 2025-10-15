package com.jframes.swing;

import java.util.List;

import com.dao.BookDao;
import com.dao.MemberDao;
import com.dao.impl.BookFrameDaoImpl;
import com.dao.impl.MemberDaoImpl;
import com.pojos.BookPojo;

public class TestMain {

	
	
	public static void main(String[] args) {

		
		 BookDao book_dao=new  BookFrameDaoImpl();
		 BookFrameDaoImpl obj=new BookFrameDaoImpl();
		 obj.getBooks();
		 System.out.print(obj.getBooks());
		 
	     //MemberDao member_dao = new MemberDaoImpl();
		 System.out.print(book_dao);
		 //List<BookPojo> getBooks();
		 //System.out.println(member_dao);

	}

}
