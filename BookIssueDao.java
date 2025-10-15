package com.dao;

import java.util.List;

import com.pojos.*;

public interface BookIssueDao {

	
	
	int saveBookIssue(BookIssuePojo bookIssue);
	//int  deleteBookIssue(BookIssuePojo bookIssue);
	int updateBookIssue(BookIssuePojo bookIssue);
	
	List<MemberPojo> getMembers();

	List<BookPojo> getIsbnNo(String isbn);
	
	
	
	
	
}