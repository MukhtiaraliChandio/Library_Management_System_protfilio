package com.jframes.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.dao.BookDao;
import com.dao.impl.BookFrameDaoImpl;
import com.pojos.BookPojo;

public class ShowDataBookForm implements ActionListener {

	 BookDao book_dao=new  BookFrameDaoImpl();
	
	String columns[]  ={"MEMBER ID", " EMPLOYEE  ID",  "BOOK ID",  "BOOK  NAME" ,"BOOK CATEGORY","LANGUAGE","AUTHOR EDITOR", "EDITOR VOLUME", "YEAR OF PUBLISHING", "ISBN NO", "NUMBER OF PAGES",  "REMARKS"};
	JTextField bookIdtextField, bookNametextField, bookCategorytextField, bookAuthoreditorTextfield,  isbnTextfield,  numberofPagestextField, memberIdtextField,     employeeIdtextField;  // JTextField declare.
	DefaultTableModel model = new DefaultTableModel();
	JTable jt = null;
	
	JLabel   showDatalabel;
	
	ShowDataBookForm(){
		
		
		
		JFrame win=new JFrame();
		
		win.setSize(1100,730);//400 width and 500 height  

		
	    jt=new JTable(model);
	    JScrollPane sp=new JScrollPane(jt);    
	     win.add(sp);
	    sp.setBounds(50, 80, 800, 280);
		
	    
	    win.setLayout(null);//using no layout managers  
		win.setVisible(true);//making the frame visible
		
	    showDatalabel=new JLabel(" SHOW DATA ");// it is used for jlist label.
		showDatalabel.setBounds(450,30, 150,50); 
	    win.add(showDatalabel);
		
		
		
	}
	

///////////////////////////////********************* Here is Set Book Data Table Event in  JTable Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
private void setBookDataTableEvent(JTable jt) {

jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

@Override
public void valueChanged(ListSelectionEvent e) {

int rowIn = jt.getSelectedRow();

BookPojo pojo = new BookPojo();

String memberId=jt.getValueAt(rowIn, 0).toString();
String employeeId=jt.getValueAt(rowIn, 1).toString();

String bookId  = jt.getValueAt(rowIn, 2).toString();

String bookName=jt.getValueAt(rowIn, 3).toString();
String bookCategory=jt.getValueAt(rowIn, 4).toString();
String language=jt.getValueAt(rowIn, 5).toString();
String bookAuthoreditor=jt.getValueAt(rowIn, 6).toString();
String editorVolume=jt.getValueAt(rowIn, 7).toString();
String yearofPublishing=jt.getValueAt(rowIn, 8).toString();
String isbn=jt.getValueAt(rowIn, 9).toString();
//String purchaseFrom=jt.getValueAt(rowIn, 10).toString();
String numberofPages=jt.getValueAt(rowIn,10).toString();


String remarks=jt.getValueAt(rowIn, 11).toString();

pojo.setEmployeeId(Integer.parseInt(employeeId));

pojo.setBookId(Integer.parseInt(bookId));
pojo.setBookName(bookName);
pojo.setBookCategory(bookCategory);
pojo.setLanguage(language);
pojo.setAuthorEditor(bookAuthoreditor);
pojo.setEditorVolume(editorVolume);
pojo.setYearofPublishing(yearofPublishing);
pojo.setIsbnNo(isbn);

pojo.setNumberofPages(numberofPages);

pojo.setRemarks(remarks);



bookIdtextField.setText(""+pojo.getBookId());

bookNametextField.setText(pojo.getBookName());
//languagetextField.setText(pojo.getLanguage());
bookCategorytextField.setText(pojo.getBookCategory());
//combobox2.setSelectedItem(pojo.getLanguage());	
bookAuthoreditorTextfield.setText(pojo.getAuthorEditor());
isbnTextfield.setText(pojo.getIsbnNo());
numberofPagestextField.setText(pojo.getNumberofPages());
//textArea.setText(pojo.getRemarks());


//JOptionPane.showMessageDialog(null, "Book ID : "+pojo.getBookId()+"\nBookName:"+pojo.getBookName()+"\nBookCategory:"+pojo.getBookCategory()+"\nLanguage:"+pojo.getLanguage()+"\nBook Author Editor:"+pojo.getAuthorEditor()+"\nIsbn No:"+pojo.getIsbn()+"\nPurchase From :"+pojo.getPurchaseFrom()+"\nNumber of Pages:"+pojo.getNumberofPages()+"\nPurchase Date:"+pojo.getPurchaseDate()+"\nRemarks:"+pojo.getRemarks());

System.out.print(pojo);



}
});


List<BookPojo> pojodata = book_dao.getBooks();
for(BookPojo pojo:pojodata){
//listModel.addElement(pojo.getIsbnNo());
System.out.println("This is data"+pojodata);

}// end of for each loop.*/


}// end of  setBookDataTableEvent(JTable jt  JTable method.

///////////////////////////////********************* end of JTable Action  Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	public static void main(String[] args) {
		
		new ShowDataBookForm();

	}
	
	
	
	
	
}
