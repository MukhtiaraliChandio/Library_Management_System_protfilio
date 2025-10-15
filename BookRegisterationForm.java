package com.jframes.swing;

import java.util.List;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.pojos.*;
import com.dao.*;
import com.dao.impl.*;

public class BookRegisterationForm implements ActionListener{

	
	 BookDao book_dao=new  BookFrameDaoImpl();
	
	JButton addBtn;
	JButton updateBtn;
	JButton clearBtn;
    JButton exitBtn;
	JButton deleteBtn;
	  
	JLabel   bookFromlabel, memberIdlabel, bookIdlabel,bookNamelabel, bookCategorylabel, languageLabel, bookAuthoreditorlabel, editorVolumelabel, quantityLabel,  yearofPublishinglabel,   isbnNolabel, numberofPageslabel,    employeeIdlabel, yearofblishingsLabel, remarksLabel ,showDataLabel; // JLabel declare.

	JTextArea textArea;

	String columns[]  ={" EMPLOYEE  ID",  "BOOK ID",  "BOOK  NAME" ,"BOOK CATEGORY","LANGUAGE","AUTHOR EDITOR", "EDITOR VOLUME", "YEAR OF PUBLISHING", "ISBN NO", "NUMBER OF PAGES",  "REMARKS"};
	JTextField bookIdtextField, bookNametextField, bookCategorytextField, bookAuthoreditorTextfield,  isbnTextfield,  numberofPagestextField,  employeeIdtextField;  // JTextField declare.
	DefaultTableModel model = new DefaultTableModel();
	JTable jt = null;
	  
	String yearofPublishing[]={"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};        
	JComboBox combobox4=new JComboBox(yearofPublishing); 
		
	String editorVolume[]={"Volume-1","Volume-2","Volume-3"};        
	JComboBox combobox3=new JComboBox(editorVolume); 
	  
	String language[]={"English","Urdu","Sindhi"};        
	JComboBox combobox2=new JComboBox(language); 
	  
	DefaultListModel<String> listModel = new DefaultListModel<>();  
	JList<String> list = null;
    JList jt1=null;
	  
	
	
BookRegisterationForm(){
    	
	
	JFrame win=new JFrame();
	
	win.setSize(1100,730);//400 width and 500 height  

	
    jt=new JTable(model);
    JScrollPane sp=new JScrollPane(jt);    
     win.add(sp);
    sp.setBounds(20, 50, 1100, 150);
	

	 win.setLayout(null);//using no layout managers  
	 win.setVisible(true);//making the frame visible
    
	
     showDataLabel=new JLabel(" SHOW DATA ");// it is used for jlist label.
	 showDataLabel.setBounds(450,0, 150,50); 
     win.add(showDataLabel);
	 
///////////////////////////******************* Here is Set Bounds of ALL JLabels************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\   
     
     bookFromlabel=new JLabel("  BOOK  FORM  ");
	 bookFromlabel.setBounds(280, 200, 250,50); 
     win.add(bookFromlabel);
     
     employeeIdlabel=new JLabel("EMPLOYEE ID");
	 employeeIdlabel.setBounds(15,230,100,50);
	 win.add(employeeIdlabel);
	 
	  bookIdlabel=new JLabel("BOOK  ID");
	  bookIdlabel.setBounds(310,230, 100,50); 
	  win.add(bookIdlabel);
	 

      bookNamelabel=new JLabel("BOOK  NAME");
      bookNamelabel.setBounds(15,270,150,50);
	  win.add(bookNamelabel);
	  
	  
	  bookAuthoreditorlabel=new JLabel("BOOK AUTHOR EDITOR");
	  bookAuthoreditorlabel.setBounds(275,270, 150,50); 
      win.add(bookAuthoreditorlabel);
      
      
      bookCategorylabel=new JLabel("BOOK CATEGORY");
	  bookCategorylabel.setBounds(15,310,150,50);
	  win.add(bookCategorylabel);
	  
	  languageLabel=new JLabel("LANGUAGE");
	  languageLabel.setBounds(310,310,170,50);
	  win.add(languageLabel);
      
	  
	  editorVolumelabel=new JLabel("EDITOR VOLUME");
      editorVolumelabel.setBounds(15,350,150,50);
	  win.add(editorVolumelabel);
	  
	  yearofPublishinglabel=new JLabel("YEAR OF  PUBLISHING");
	  yearofPublishinglabel.setBounds(290,350,150,50);
	  win.add(yearofPublishinglabel);
	  
	  
	  yearofblishingsLabel=new JLabel(" ISBN NO ");// it is used for jlist label.
	  yearofblishingsLabel.setBounds(650,230, 100,50); 
      win.add(yearofblishingsLabel);
      
      
      
	  isbnNolabel=new JLabel("ISBN No");
	  isbnNolabel.setBounds(15,380,150,50);
	  win.add(isbnNolabel);
	  
	  numberofPageslabel=new JLabel("NUMBER OF PAGES");
	  numberofPageslabel.setBounds(290,385,150,50);
	  win.add(numberofPageslabel);
	  
	  remarksLabel=new JLabel("REMARKS");
	  remarksLabel.setBounds(15,420,150,50);
	  win.add( remarksLabel);
	  
	  addBtn = new JButton("ADD");  
	  updateBtn=new JButton("UPDATE");  
	  clearBtn=new JButton("CLEAR");  
	  exitBtn=new JButton("EXIT");
	  deleteBtn=new JButton("DELETE");
	  
	  
///////////////////////////******************* Here is Set Bounds of ALL Labels************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\   

     
///////////////////////////******************* Here is Set Bounds of ALL JTextField ************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\   

	 
	// memberIdtextField=new JTextField();  
	// memberIdtextField.setBounds(100,250, 100,20);
	 //win.add(memberIdtextField);
     
	 
	 employeeIdtextField=new JTextField();  
	 employeeIdtextField.setBounds(100,250, 200,20);
	 win.add(employeeIdtextField);
	 
	  
     bookIdtextField=new JTextField();  
     bookIdtextField.setBounds(380,250, 200,20);
	 win.add(bookIdtextField);
	 
	  
		 
	 bookNametextField=new JTextField();  
	 bookNametextField.setBounds(100,290, 170,20);
	 win.add(bookNametextField); 
	  
	 
	 bookAuthoreditorTextfield=new JTextField();  
	 bookAuthoreditorTextfield.setBounds(420,290, 170,20);
	 win.add(bookAuthoreditorTextfield);
	 
	
	  
	  bookCategorytextField=new JTextField();  
	  bookCategorytextField.setBounds(130,330, 170,20);
	  win.add(bookCategorytextField);
	 
	 combobox2=new JComboBox(language);    
	 combobox2.setBounds(420, 330, 170,20);    
	 win.add(combobox2);
	
	 
	 combobox3=new JComboBox(editorVolume);    
     combobox3.setBounds(115, 365,170,20);    
	 win.add(combobox3);
	 
	 
	 combobox4=new JComboBox(yearofPublishing);    
	 combobox4.setBounds(420, 370,170,20);    
     win.add(combobox4);
    
	 list = new JList<>(listModel);  
     list.setBounds(610,270, 130,350);  //Show  list bounds.
     win.add(list); 
    
	 isbnTextfield=new JTextField();  
	 isbnTextfield.setBounds(115,400, 170,20);// used for isbn no.
	 win.add(isbnTextfield);
	
	 numberofPagestextField=new JTextField();  
	 numberofPagestextField.setBounds(420,405, 170,20);
	 win.add(numberofPagestextField);
	
	 textArea=new JTextArea();  
	 textArea.setBounds(110,440, 480,120);  
	 win.add(textArea);
	 

	  addBtn.setBounds(100,580,80,40);  
	  win.add(addBtn);
    
	  updateBtn.setBounds(200,580,80,40);  
	  win.add(updateBtn);
	 
	  clearBtn.setBounds(300,580,80,40);  
	  win.add(clearBtn);
	 
	  exitBtn.setBounds(400,580,80,40);  
	  win.add(exitBtn);
	
	  deleteBtn.setBounds(500,580,80,40);  
	  win.add(deleteBtn);
	  
	 
	  addBtn.addActionListener(this);
	  updateBtn.addActionListener(this);
	  clearBtn.addActionListener(this);
	  exitBtn.addActionListener(this);
	  deleteBtn.addActionListener(this);
	
	
	 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 setTableData(model);// 
     setBookDataTableEvent(jt);//it is correct statement.
     actionList(list);
     resizeColumnWidth(jt);
		
     

	 
	  
	  
}// end of constructor.








///////////////////////////////********************* Here is Set Book Data Table Event in  JTable Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
private void setBookDataTableEvent(JTable jt) {

jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

@Override
public void valueChanged(ListSelectionEvent e) {
	
	int rowIn = jt.getSelectedRow();
	
	BookPojo pojo = new BookPojo();
 //String memberId=jt.getValueAt(rowIn, 0).toString();
 String employeeId=jt.getValueAt(rowIn, 0).toString();
 
 String bookId  = jt.getValueAt(rowIn, 1).toString();

 String bookName=jt.getValueAt(rowIn, 2).toString();
 String bookCategory=jt.getValueAt(rowIn, 3).toString();
 String language=jt.getValueAt(rowIn, 4).toString();
 String bookAuthoreditor=jt.getValueAt(rowIn, 5).toString();
 String editorVolume=jt.getValueAt(rowIn, 6).toString();
 String yearofPublishing=jt.getValueAt(rowIn, 7).toString();
 String isbn=jt.getValueAt(rowIn, 8).toString();
 String numberofPages=jt.getValueAt(rowIn,9).toString();
 String remarks=jt.getValueAt(rowIn, 10).toString();
 
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
 combobox2.setSelectedItem(pojo.getLanguage());	
 bookAuthoreditorTextfield.setText(pojo.getAuthorEditor());
 isbnTextfield.setText(pojo.getIsbnNo());
 numberofPagestextField.setText(pojo.getNumberofPages());
 textArea.setText(pojo.getRemarks());
 
 
 //JOptionPane.showMessageDialog(null, "Book ID : "+pojo.getBookId()+"\nBookName:"+pojo.getBookName()+"\nBookCategory:"+pojo.getBookCategory()+"\nLanguage:"+pojo.getLanguage()+"\nBook Author Editor:"+pojo.getAuthorEditor()+"\nIsbn No:"+pojo.getIsbn()+"\nPurchase From :"+pojo.getPurchaseFrom()+"\nNumber of Pages:"+pojo.getNumberofPages()+"\nPurchase Date:"+pojo.getPurchaseDate()+"\nRemarks:"+pojo.getRemarks());

  System.out.print(pojo);


	
}
});
}// end of  setBookDataTableEvent(JTable jt  JTable method.

///////////////////////////////********************* end of JTable Action  Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


private void actionList(JList list) {

list.addListSelectionListener(new ListSelectionListener() {

@Override
public void valueChanged(ListSelectionEvent e) {
	
String isbn  = (String)list.getSelectedValue();

BookPojo Books = book_dao.getIsbn(isbn);

employeeIdtextField.setText(""+Books.getEmployeeId());
bookIdtextField.setText(""+Books.getBookId());
bookNametextField.setText(Books.getBookName());
bookCategorytextField.setText(Books.getBookCategory());

bookAuthoreditorTextfield.setText(Books.getAuthorEditor());
isbnTextfield.setText(Books.getIsbnNo());
numberofPagestextField.setText(Books.getNumberofPages());


textArea.setText(Books.getRemarks());



}
});

List<BookPojo> pojodata = book_dao.getBooks();
for(BookPojo pojo:pojodata){
listModel.addElement(pojo.getIsbnNo());
System.out.println("This is data"+pojodata);

}// end of for each loop.*/


}// end of actionList method.

///////////////////////////////********************* end of Action List Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

















///////////////////////////////*********************here is  Start Set Table Data  Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

private void  setTableData(DefaultTableModel model) {
	
    System.out.println("set Data");
	List<BookPojo> list = book_dao.getBooks();
	
	for(String column:columns){
		model.addColumn(column);
	}
	
	for(BookPojo Books:list){
		model.addRow(new Object[]{Books.getEmployeeId(), Books.getBookId(),Books.getBookName(), Books.getBookCategory(), Books.getLanguage()  ,Books.getAuthorEditor(),     Books.getEditorVolume(), Books.getYearofPublishing(),  Books.getIsbnNo(),  Books.getNumberofPages(),Books.getRemarks()});
		System.out.print("List Data: "+list);
	
	}
	
	

	

}// end of  setTableData  method.


///////////////////////////////********************* end of  Set Table Data  Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




///////////////////////////////********************* here is Start ResizeColumnWidth JTable method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

public void resizeColumnWidth(JTable table) {
final TableColumnModel columnModel = table.getColumnModel();
for (int column = 0; column < table.getColumnCount(); column++) {
   int width = 15; // Min width
   for (int row = 0; row < table.getRowCount(); row++) {
       TableCellRenderer renderer = table.getCellRenderer(row, column);
       Component comp = table.prepareRenderer(renderer, row, column);
       width = Math.max(comp.getPreferredSize().width +1 , width);
   }
   if(width > 300)
       width=300;
   columnModel.getColumn(column).setPreferredWidth(width);
}


}

///////////////////////////////********************* end of  ResizeColumnWidth JTable method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


///////////////////////////////*********************here is Start  Action  List   Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




@Override
public void actionPerformed(ActionEvent e) {
  	 
    if(e.getSource()==addBtn) {
 		

			BookPojo bkp = new BookPojo ();
		
		//	int MemberId = Integer.parseInt(memberIdtextField.getText());
		//	int employeeId = Integer.parseInt(employeeIdtextField.getText());
		//int bookId = Integer.parseInt(bookIdtextField.getText());
			bkp.setBookName(bookNametextField.getText());
			bkp.setBookCategory(bookCategorytextField.getText());
		    bkp.setYearofPublishing(""+combobox4.getSelectedItem());
			bkp.setLanguage(""+combobox2.getSelectedItem());
			bkp.setEditorVolume(""+combobox3.getSelectedItem());
			bkp.setAuthorEditor(bookAuthoreditorTextfield.getText());
			bkp.setIsbnNo(isbnTextfield.getText());
			bkp.setNumberofPages(numberofPagestextField.getText());
			
		
			bkp.setRemarks(textArea.getText());
			
				if(isAnyFieldEmpty(bkp)){
					
					book_dao.saveBookdata(bkp);
					
				}
			 
				JOptionPane.showMessageDialog(null, "Data Save");
				
				
				 book_dao.saveBookdata(bkp);
			
		    /*String isbnNo=isbnTextfield.getText();
		    
		    BookPojo pojo =  book_dao.getIsbn(isbnNo);
		    
		    System.out.println("Isbn From database: "+pojo.getIsbnNo());
		    
		    pojo.setIsbnNo(isbnNo);
		    System.out.println("Isbn From database: "+isbnNo);

		    
		    if (pojo == null) {  //if authentic, navigate user to a new page  
		    	   //JOptionPane.showMessageDialog(null, "Username is Incorrect");
		 		   JOptionPane.showMessageDialog(null, "Data Not Sava Because That isbnNo is already exits in Book Table");

		       }else{  
		    	   if(pojo.getIsbnNo().equals(isbnNo)) {
		    		  // JOptionPane.showMessageDialog(null, "Login Succesful");
			 		   JOptionPane.showMessageDialog(null, "Isbn is New than data save in book table. ");

		    		  
		    		   
		    	   }else {
		    		   JOptionPane.showMessageDialog(null, "Password is Incorrect");
		    	   }
		       }  
		       
		    
			   //if(isbnNo.equals(pojo)&&isbnNo.equals(isbnNo))
		 		  // JOptionPane.showMessageDialog(null, "Data Not Sava Because That isbnNo is already exits in Book Table");
			  // else
		 		   //JOptionPane.showMessageDialog(null, "Isbn is New than data save in book table. ");*/


			
		
				 
			 
		}else if(e.getSource()== updateBtn) {
			
			

			BookPojo bkp = new BookPojo ();
			
			int bookId=Integer.parseInt(bookIdtextField.getText());
			bkp.setBookId(bookId);
			
			bkp.setBookName(bookNametextField.getText());
			bkp.setBookCategory(bookCategorytextField.getText());
		    bkp.setYearofPublishing(""+combobox4.getSelectedItem());
			bkp.setLanguage(""+combobox2.getSelectedItem());
			bkp.setEditorVolume(""+combobox3.getSelectedItem());
			bkp.setAuthorEditor(bookAuthoreditorTextfield.getText());
			bkp.setIsbnNo(isbnTextfield.getText());
			bkp.setNumberofPages(numberofPagestextField.getText());
			//bkp.setPurchaseFrom(purchaseFromtextField.getText());

			bkp.setRemarks(textArea.getText());
			
			
			JOptionPane.showMessageDialog(null, "Update Data");
			
			
			 book_dao.saveBookdata(bkp);

			
			
		}else if(e.getSource()==clearBtn) {
			
			bookIdtextField.setText("");
			bookNametextField.setText("");
		    bookCategorytextField.setText("");
		    bookAuthoreditorTextfield.setText("");
		    isbnTextfield.setText("");
		    numberofPagestextField.setText("");
		   // memberIdtextField.setText("");
		    employeeIdtextField.setText("");
		    textArea.setText("");
			
			
		}else if(e.getSource()==exitBtn) {
			
			System.exit(0);
			
			
		}else if(e.getSource()==deleteBtn) {
			
			
			BookPojo bkp = new BookPojo ();
			
			int bookId=Integer.parseInt(bookIdtextField.getText());
			bkp.setBookId(bookId);

		
			

			JOptionPane.showMessageDialog(null, "Delete Data ");
			
			//member_dao.deleteMember(emp);

			
		}
	  

}// end of main method.

	


///////////////////////////////*********************  Here is Start  Get IsbnNo Compare Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


private boolean isAnyFieldEmpty(BookPojo bkp) {
	
	   boolean b=false;
	
	   if(bkp.getBookName().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter BookName");
	    else if(bkp.getBookCategory().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter BookCategory");
	    else if(bkp.getLanguage().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Language");
	   else if(bkp.getAuthorEditor().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Language");
	   else if(bkp.getEditorVolume().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter EditorVolume");
    else if(bkp.getIsbnNo().isEmpty())     	
	    	JOptionPane.showMessageDialog(null, "Please Enter Isbn No");
    else if(bkp.getAuthorEditor().isEmpty()) 
	    	JOptionPane.showMessageDialog(null, "Please Enter Book Author Editor");
    else if(bkp.getNumberofPages().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter  Number of Pages");
    else if(bkp.getYearofPublishing().isEmpty()) 
	    	JOptionPane.showMessageDialog(null, "Please Enter Year of Publishing");
	   else if(bkp.getRemarks().isEmpty()) 
	         JOptionPane.showMessageDialog(null, "Please Enter Remarks");
    else 
	         b=true;
	    	 
	         return b;
	

}//  end of  boolean isAnyFieldEmpty method. that method used for validation.





private void  getIsbnNoCompare(ActionEvent e) {


String isbnNo=isbnTextfield.getText();
JOptionPane.showMessageDialog(null, "IsbNNo:"+isbnNo);

//if (pojo == null) {  //if authentic, navigate user to a new page  
// JOptionPane.showMessageDialog(null, "Username is Incorrect");
//}else{  

if(isbnNo.equals("11223344567")){
JOptionPane.showMessageDialog(null, "Data Not Sava Because That isbnNo is already exits in Book Table");

MainFrame ob=new MainFrame();

}else if(isbnNo.equals("")) {
JOptionPane.showMessageDialog(null, "Password is Incorrect");
}





}// end of  getIsbnNoCompare method.




///////////////////////////////********************* end ofGet IsbnNo    Method.***************************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



public static void main(String[] args) {
	

	 //System.out.println("Hello World");

	 new BookRegisterationForm();		
			
			
	}// end of main method.











	
	
	
	
}// end of BookRegisterationForm JFrame form class.