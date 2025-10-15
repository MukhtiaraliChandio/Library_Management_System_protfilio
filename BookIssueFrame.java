package com.jframes.swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.dao.*;
import com.dao.impl.*;
import com.pojos.*;


/*import app.dao.Book_Issue_Dao;
import app.dao.MemberDao;
import appdaoimpl.BookFrameDaoImpl;
import appdaoimpl.Book_IssueDaoImpl;
import appdaoimpl.MemberDaoImp;
import pojos.BookIssuePojo;
import pojos.BookPojo;
import pojos.MemberPojo;*/




public class BookIssueFrame implements ActionListener{

	
	BookIssueDao bookissue_dao=new  BookIssueDaoImpl(); 

	MemberDao member_dao = new MemberDaoImpl();
	
	 BookFrameDaoImpl book_dao=new  BookFrameDaoImpl();

	
	 JFrame win=null;
	 JButton bookIssuebtn;
	 JButton bookReturnbtn;
	 JButton clearBtn;
	 JButton exitBtn;
	 JButton deleteBtn;
	
	 ButtonGroup bg;
	 JRadioButton r1;
	 JRadioButton r2;
	 
	  JLabel l1,l2, l3, l4, l5, l6, l7, l8, l9, l10,l11, l12, l13, l24; // JLabel declare.
	  JTextField  memberIdTextField, memberNametextField,   fatherNameTextField, surnameTextfield,cnicNumbertextField,guardianOccupation,
	  contactNotextField, addressTextfield;
	  
	  JTextArea area=new JTextArea();
	  JTextArea textArea2=new JTextArea();
	  
	  JTextField bookIdtextField, bookNametextField, memberIdtextField2, employeeIdtextField, finetextField;
	  
        
	    DefaultListModel<String> listModel1 = new DefaultListModel<>();  
	    JList<String> list1 = null;
	    JList jt1=null;
	  
	     
	    // JList<String> list2 = new JList<>(l26);  
	      //list2.setBounds(530,450, 100,180);  
	      //win.add(list2); 
	    
	    DefaultListModel<String> listModel2 = new DefaultListModel<>();  
	    JList<String> list2 = null;
	    JList jt2=null;
	    


	    
public  BookIssueFrame() {
			
			win=new JFrame();
				
				win.setSize(1400,730);//400 width and 500 height  
			
				
			    
				//JTextField

			    /*DefaultListModel<String> l14 = new DefaultListModel<>();  
		        l14.addElement("03163134389");  
		        l14.addElement("03368924936");  
		        l14.addElement("03091135133");  
		        l14.addElement("03456675421");*/
				
			

				List<MemberPojo> pojodata1 = member_dao.getMembers();
				for(MemberPojo pojo:pojodata1){
					listModel1.addElement(pojo.getContactNo());
				}
		          
			    
			    JList<String> list1 = new JList<>(listModel1);  
		        list1.setBounds(530,100, 100,300);  
		        win.add(list1); 
		        
		        
		    	
		        
		        
		        
		    	r1=new JRadioButton("A) Male");    
			    r2=new JRadioButton("B) Female");  
				bg=new ButtonGroup();   
				
				
			
				
				  
				//textArea1.setBounds(120,290, 390,110);  
			     //win.add(textArea1);
				
				area.setBounds(120, 290, 390,110);
				win.add(area);
				
				 win.setLayout(null);//using no layout managers  
				 win.setVisible(true);//making the frame visible
			    
				 bookIssuebtn=new JButton("BOOK ISSUE");  
				 bookReturnbtn=new JButton("Book RETURN");  
				  clearBtn=new JButton("CLEAR");  
				  exitBtn=new JButton("EXIT");
				 deleteBtn=new JButton("DELETE"); 
				
			  
				  String data[][]={ {"1","1","1","1/8/2021","5/8/2021","200","ok"},};    
		          String column[]={"BOOK ID","BOOK ISSUE ID" ,"MEMBER ID","DATE OF ISSUE", "DATE OF RETURN", "FINE",  "REMARKS"};         
		          JTable jt=new JTable(data,column);    
		          JScrollPane sp=new JScrollPane(jt);    
		          win.add(sp);
		          sp.setBounds(650, 100, 700, 100);
			  

				  l1=new JLabel("  BOOK  ISSUE   FORM ");
				  l1.setBounds(650,0,150,50);
				  win.add(l1);	
				 
				 
				  l2=new JLabel("  MEMBER    REGISTERATION    FORM  ");
			      l2.setBounds(220,30, 250,50); 
			      win.add(l2);
				 
				  l3=new JLabel("MEMBER  ID");
			      l3.setBounds(20,60, 150,50); 
			      win.add(l3);
			      
			      l4=new JLabel("MEMBER  NAME");
				  l4.setBounds(20,90,150,50);
				  win.add(l4);
				  
				  l5=new JLabel("FATHER  NAME");
				  l5.setBounds(20,125,150,50);
				  win.add(l5);
			      

				  l6=new JLabel("SURNAME");
				  l6.setBounds(280,125,150,50);
				  win.add(l6);
				  

				  l7=new JLabel("CNIC NUMBER");
			      l7.setBounds(20,160, 150,50); 
			      win.add(l7);
			      
			      l8=new JLabel("CONTACT NO");
				  l8.setBounds(280,160,150,50);
				  win.add(l8);
				  
				  l9=new JLabel("GUARDIAN OCCUPATION");
				  l9.setBounds(20,190,150,50);
				  win.add(l9);
				  
				  
				  l10=new JLabel("ADDRESS");
				  l10.setBounds(20,225,150,50);
				  win.add(l10);
				  
				  l11=new JLabel("SELECT GENDER");
				  l11.setBounds(280,225,150,50);
				  win.add(l11);
				  
				  l12=new JLabel("REMARKS");
				  l12.setBounds(20,270,150,50);
				  win.add(l12);
				  
				  l13=new JLabel(" CONTACT NO ");// it is used for jlist label.
			      l13.setBounds(540,60, 150,50); 
			      win.add(l13);
                  
				  l24=new JLabel("  SHOW DATA  ");
				  l24.setBounds(980,50,150,50);
				  win.add(l24);	
			      
			      
				  memberIdTextField=new JTextField();  
				  memberIdTextField.setBounds(120,80, 390,20);
				  win.add(memberIdTextField);
				  
				  memberNametextField=new JTextField();  
				  memberNametextField.setBounds(120,110, 390,20);
				  win.add(memberNametextField);
				  
				  fatherNameTextField=new JTextField();  
				  fatherNameTextField.setBounds(120,140, 150,20);
				  win.add(fatherNameTextField);
				  
		 
				  surnameTextfield=new JTextField();  
				  surnameTextfield.setBounds(360,140, 150,20);
				  win.add(surnameTextfield);
					
				  cnicNumbertextField=new JTextField();  
				  cnicNumbertextField.setBounds(120,175, 150,20);
				  win.add(cnicNumbertextField);
					 
				  
				  
				  guardianOccupation=new JTextField();  
				  guardianOccupation.setBounds(360,175,150,20);
				  win.add(guardianOccupation);
				  
				  
				  contactNotextField=new JTextField();  
				  contactNotextField.setBounds(170,205,340,20);
				  win.add(contactNotextField);
					 
					 
				  addressTextfield=new JTextField();  
				  addressTextfield.setBounds(120,240, 150,20);
				  win.add(addressTextfield);
				  
				  
				 r1.setBounds(390,240,100,20);    
				 r2.setBounds(390,260,100,20); 
				
				 bg.add(r1);
				 bg.add(r2);    
				 win.add(r1);
				 win.add(r2);
				  
				  
				 
				 
				 bookIssuebtn.setBounds(120,650,120,30);  
				 win.add(bookIssuebtn);
			     
				 
				 bookReturnbtn.setBounds(270,650,130,30);  
				 win.add(bookReturnbtn);
				 
				 clearBtn.setBounds(430,650,80,30);  
				 win.add(clearBtn);
				 
				 
				 exitBtn.setBounds(540,650,80,30);  
				 win.add(exitBtn);
				
				 //deleteBtn.setBounds(550,650,80,30);  
				 //win.add(deleteBtn);
				 
					
					//setMemberData(listModel);
					actionOnList(list1);
				  
		 ///////****************Book Issue Frame***********////////////
				 
				 JLabel l15, l16, l17, l18, l19, l20, l21, l22, l25 ; // JLabel declare.
				 JTextField t9,t10, t11,t12,t13, t14, t15, t16; // JTextField declare.
				

			     
			       List<BookPojo> pojodata2 = book_dao.getBooks();
					for(BookPojo pojo:pojodata2){
						listModel2.addElement(pojo.getIsbnNo());
					}
			          
				list2 = new JList<>(listModel2);  
				list2.setBounds(530,450, 100,180);   
			    win.add(list2); 
			        
			      
			      
				 l15=new JLabel("  BOOK  ISSUE  ");
				 l15.setBounds(280,410,100,20);
				 win.add(l15);	
				 
				 
				 l16=new JLabel("  BOOK   ID  ");
				 l16.setBounds(20,430,100,20);
				 win.add(l16);	 
				 
				 
				 l17=new JLabel("  BOOK  NAME  ");
				 l17.setBounds(20,460,100,20);
				 win.add(l17);
				 
				// l18=new JLabel("MEMBER  ID");
			    // l18.setBounds(280,460, 100,20); 
			     //win.add(l18);
			      
				 
				 l19=new JLabel("  EMPLOYEE ID  ");
				 l19.setBounds(20,490,100,20);
				 win.add(l19);
				 
				 
				 //l20=new JLabel("  DATE  OF RETURN  ");
				 //l20.setBounds(270,490,150,20);
				 //win.add(l20);
				 
				 l21=new JLabel("  FINE  ");
				 l21.setBounds(20,520,150,20);
				 win.add(l21);
				 
				 l22=new JLabel("  REMARKS  ");
				 l22.setBounds(20,550,150,20);
				 win.add(l22);
				 

				 l25=new JLabel("  ISBN NO ");// it is used for jlist label.
				 l25.setBounds(540,430,150,20);
				 win.add(l25);
				 
				 
				  
				 textArea2.setBounds(120,550, 390,80);  
			     win.add(textArea2);
				 
				 
			     bookIdtextField=new JTextField();  
			     bookIdtextField.setBounds(120,430, 390,20);
				 win.add(bookIdtextField);
				  
				 bookNametextField=new JTextField();  
				 bookNametextField.setBounds(120,460, 150,20);
				 win.add(bookNametextField);
				  
		 
				 //memberIdtextField2=new JTextField();  
				 //memberIdtextField2.setBounds(360,460, 150,20);
				 //win.add(memberIdtextField2);
					
				 employeeIdtextField=new JTextField();  
				 employeeIdtextField.setBounds(120,490, 390,20);
				 win.add(employeeIdtextField);
					 
				  
				  
			
				  
				  
				 finetextField=new JTextField();  
				 finetextField.setBounds(120,520,390,20);
				  win.add(finetextField);
					 
			

				  bookIssuebtn.addActionListener(this);
				  bookReturnbtn.addActionListener(this);
				 clearBtn.addActionListener(this);
				 exitBtn.addActionListener(this);	 
				 // actionList(list1);
				  actionList(list2);
				  
				 
}// end of constructor. 
	 
/*private void setMemberData(DefaultListModel<String> listModel2) {

			System.out.println("set Data");
			List<MemberPojo> list = member_dao.getMembers();
			
			for(String column:columns){
				model.addColumn(column);
			}
			
			for(MemberPojo member:list){
				model.addRow(new Object[]{member.getEmployeeId(),member.getMemberId(),member.getMemberName(),member.getfName(),member.getSurname(),member.getCnic(),member.getContactNo(),member.getGuardianOccupation(),member.getAddress(),member.getGender(),member.getRemarks()});
			}
			
			
		
	    }// end of  setMemberDataList method.*/
		
		
		 


private void actionOnList(JList list1) {
		
			list1.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
				
					String contact  = (String)list1.getSelectedValue();
					MemberPojo member = member_dao.getMembersByContactNumber(contact);
					JOptionPane.showMessageDialog(null, ""+contact);
					
					
					memberIdTextField.setText(""+member.getMemberId());
			        memberNametextField.setText(member.getMemberName());
					cnicNumbertextField.setText(member.getCnic());
					fatherNameTextField.setText(member.getfName());
					surnameTextfield.setText(member.getSurname());
					cnicNumbertextField.setText(member.getCnic());
					contactNotextField.setText(member.getContactNo());
					guardianOccupation.setText(member.getGuardianOccupation());
					addressTextfield.setText(member.getAddress());
				    area.setText(member.getRemarks());
					
					
				}
			});
		
	    }// end of Jlist action method.

		
private void actionList(JList list12) {
	
               
	list2.addListSelectionListener(new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			String isbn  = (String)list2.getSelectedValue();
			BookPojo Books = book_dao.getIsbn(isbn);
			
			bookIdtextField.setText(""+Books.getBookId());
			employeeIdtextField.setText(""+Books.getEmployeeId());
			//memberIdtextField2.setText(""+Books.get);
			bookNametextField.setText(Books.getBookName());
			// finetextField.setText(Books.g);
			
			textArea2.setText(Books.getRemarks());
	
		}
	});

}
@Override
public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == bookIssuebtn){
			
				BookIssuePojo bkp = new BookIssuePojo();
				
				int bid = Integer.parseInt(bookIdtextField.getText());
				bkp.setBookId(bid);
				bkp.setDateofissue(new Date());
				//bkp.setFine(fine);
				bkp.setRemarks(textArea2.getText());
				
				
				bookissue_dao.saveBookIssue(bkp); 
				
				//JOptionPane.showMessageDialog(null,"Data Add");
				
				/*if(isAnyFieldEmpty(bkp)){
					
					
					bookissue_dao.saveBookIssue(bkp);
					
					
				}*/
				
				
				JOptionPane.showMessageDialog(null,"Data Add");

			
			}else if(e.getSource()==bookReturnbtn) {
				
                 BookIssuePojo bkp = new BookIssuePojo();
				
				int bid = Integer.parseInt(bookIdtextField.getText());
				bkp.setBookId(bid);
				bkp.setDateofreturn(new Date());
				//bkp.setFine(fine);
				bkp.setRemarks(textArea2.getText());
				
				
				bookissue_dao.updateBookIssue(bkp);
				
				JOptionPane.showMessageDialog(null,"Data Update");
				
				
			}else if(e.getSource()==clearBtn) {
				
				memberIdTextField.setText("");
		        memberNametextField.setText("");
				cnicNumbertextField.setText("");
				fatherNameTextField.setText("");
				surnameTextfield.setText("");
				cnicNumbertextField.setText("");
				contactNotextField.setText("");
				guardianOccupation.setText("");
				addressTextfield.setText("");
				area.setText("");
				
				bookIdtextField.setText("");
				employeeIdtextField.setText("");
				//memberIdtextField2.setText("");
				bookNametextField.setText("");
				textArea2.setText("");
		
				
				
				
			}else if(e.getSource()==exitBtn) {
				
				System.exit(0);
				
			}			
			
		}// end of actionPerformed method.
	 
	 
		/*private boolean  isAnyFieldEmpty(BookIssuePojo  bkp) {
			
		    boolean b=false;	
			
		    if(bkp.getBookId() == 0) {
		    	
      		    JOptionPane.showMessageDialog(null, "Please Enter  Correct Book Id");

		    }else if(bkp.getMemberId()==0){
		   	
		    	JOptionPane.showMessageDialog(null, "Please Enter Correct Member Id");

		    }else if(bkp.getEmployeeId()==0) {
		    	
		    }
		    
		    /*else if(bkp.getBookName().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Please Enter  Correct Date of Issue");

		    	
		    }else if(((CharSequence) bkp.getDateofreturn()).isEmpty()) {
			    JOptionPane.showMessageDialog(null, "Please Enter Correct Date of Return");

		    }else if(bkp.getFine()==0) {

			    JOptionPane.showMessageDialog(null, "Please Enter Correct Fine Value");

		    }else if(bkp.getRemarks().isEmpty()) {

		    	JOptionPane.showMessageDialog(null, "Please Enter  Remarks");

		    }
		    
//		    else 
//		    {
//		    	b=true;
//		    	
//		    }
			return b;
			
		
		}*/
		    

		
		
			
	    public static void main(String args[]){
				
				new  BookIssueFrame();
				
				
	   }


	

	
	
	
	
	
}