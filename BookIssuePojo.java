package com.pojos;

import java.util.Date;

public class BookIssuePojo {

	

	private int bookId;
	private int bookIssueId;
	private int memberId;
	private Date dateofissue;
	private Date dateofreturn;  
	private int fine;
	private String remarks;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookIssueId() {
		return bookIssueId;
	}
	public void setBookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getRemarks() {
		return remarks;
	}
	public Date getDateofissue() {
		return dateofissue;
	}
	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
	}
	public Date getDateofreturn() {
		return dateofreturn;
	}
	public void setDateofreturn(Date dateofreturn) {
		this.dateofreturn = dateofreturn;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}