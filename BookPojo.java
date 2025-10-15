package com.pojos;

public class BookPojo {

	

	private int bookId;
	private int employeeId;
	private String bookName;
	private String bookCategory;
	private String language;
	private String authorEditor;
	private String editorVolume;
	private String yearofPublishing;
	private String isbnNo;
	private String numberofPages;
	private String remarks;

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAuthorEditor() {
		return authorEditor;
	}
	public void setAuthorEditor(String authorEditor) {
		this.authorEditor = authorEditor;
	}
	public String getEditorVolume() {
		return editorVolume;
	}
	public void setEditorVolume(String editorVolume) {
		this.editorVolume = editorVolume;
	}
	public String getYearofPublishing() {
		return yearofPublishing;
	}
	public void setYearofPublishing(String yearofPublishing) {
		this.yearofPublishing = yearofPublishing;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		this.isbnNo = isbnNo;
	}
	public String getNumberofPages() {
		return numberofPages;
	}
	public void setNumberofPages(String numberofPages) {
		this.numberofPages = numberofPages;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "BookPojo [ bookId=" + bookId + ", employeeId=" + employeeId + ", bookName="
				+ bookName + ", bookCategory=" + bookCategory + ", language=" + language + ", authorEditor="
				+ authorEditor + ", editorVolume=" + editorVolume + ", yearofPublishing=" + yearofPublishing
				+ ", isbnNo=" + isbnNo + ", numberofPages=" + numberofPages + ", remarks=" + remarks + "]";
	}
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}