package com.dao;

import java.util.List;

import com.pojos.*;

public interface BookDao {

	//int saveBook(BookPojo bkp);
	int updateBook(BookPojo bkp);
    int deleteBook(MemberPojo emp);
	
	List<BookPojo> getBooks();
	BookPojo getIsbn(String isbn);
	//void saveBookdata(BookPojo bkp);
	int saveBookdata(BookPojo bkp);
	
	
	
}