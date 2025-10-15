package com.jframes.swing;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.dao.*;
import com.dao.impl.*;
import com.pojos.*;



public class MemberFrame implements ActionListener {

	
	
	


	MemberDao member_dao = new MemberDaoImpl();

	JFrame win = null;
	JButton addBtn;
    JButton updateBtn;
    JButton clearBtn;
    JButton exitBtn;
    JButton deleteBtn;

    ButtonGroup bg;
    JRadioButton r1;
    JRadioButton r2;
    
    String columns[]={"MEMBER ID","MEMBER NAME" ,"FNAME","SURNAME", "CNIC NO", "CONTACT NO", "GUARDIAN OCCUPATION", "ADDRESS","GENDER", "REMARKS"};
    JTextField  memberIdTextField, memberNametextField,   fatherNameTextField, surnameTextfield,cnicNumbertextField,guardianOccupation,
    contactNotextField, addressTextfield;  
    JTextArea area=new JTextArea();
    
	
    JLabel l1,l2, l3, l4, l5, l6, l7, l8, l9, l10,l11, l12, l14; // JLabel declare.
    
    DefaultTableModel model = new DefaultTableModel();
    JTable jt = null;
	
    DefaultListModel<String> listModel = new DefaultListModel<>();  
    JList<String> list = null;
    JList jt1=null;
    
  public MemberFrame() {
	
	    win=new JFrame();
		win.setSize(950,730);//400 width and 500 height  
	

		List<MemberPojo> pojodata = member_dao.getMembers();
		for(MemberPojo pojo:pojodata){
			listModel.addElement(pojo.getContactNo());
		}
          
          
        
	    
	    list = new JList<>(listModel);  
        list.setBounds(480,90, 170,510);  
        win.add(list); 
        
    	r1=new JRadioButton("A) Male");    
		r2=new JRadioButton("B) Female");  
		bg=new ButtonGroup();   
		
	     area.setBounds(180,500, 270,200);  
	     win.add(area);
		
		 win.setLayout(null);//using no layout managers  
		 win.setVisible(true);//making the frame visible
	    
          addBtn=new JButton("ADD");  
		  updateBtn=new JButton("UPDATE");  
		  clearBtn=new JButton("CLEAR");  
		  exitBtn=new JButton("EXIT");
		  deleteBtn=new JButton("DELETE"); 
		
	  
          jt=new JTable(model);
          
          JScrollPane sp=new JScrollPane(jt);    

          
          win.add(sp);
          sp.setBounds(670, 100, 800, 100);
			
               
        
		  l1=new JLabel("  MEMBER    REGISTERATION    FORM  ");
	      l1.setBounds(260,10, 250,50); 
	      win.add(l1);
		 
		  l2=new JLabel("MEMBER  ID");
	      l2.setBounds(20,60, 150,50); 
	      win.add(l2);
 
		  l3=new JLabel("MEMBER  NAME");
		  l3.setBounds(20,110,150,50);
		  win.add(l3);
		
		  l4=new JLabel("FATHER  NAME");
		  l4.setBounds(20,160,150,50);
		  win.add(l4);
		
		  l5=new JLabel("SURNAME");
		  l5.setBounds(20,210,150,50);
		  win.add(l5);
		
		  l6=new JLabel("CNIC NUMBER");
	      l6.setBounds(20,260, 150,50); 
	      win.add(l6);
	    
	      l7=new JLabel("CONTACT NUMBER");
		  l7.setBounds(20,310,150,50);
		  win.add(l7);
	    
		  
		  l8=new JLabel("GUARDIAN OCCUPATION");
		  l8.setBounds(20,360,150,50);
		  win.add(l8);
		  
		  l9=new JLabel("ADDRESS");
		  l9.setBounds(20,410,200,50);
		  win.add(l9);
		  
		  l10=new JLabel("SELECT  GENDER");
		  l10.setBounds(20,450,200,50);
		  win.add(l10);
		  

		  l11=new JLabel("REMARKS");
		  l11.setBounds(20,480,150,50);
		  win.add(l11);
		  
		  
		  l12=new JLabel(" CONTACT NUMBER ");// it is used for jlist label.
	      l12.setBounds(510,50, 150,50); 
	      win.add(l12);

	      
	      
		  l14=new JLabel(" SHOW DATA ");// it is used for jlist label.
	      l14.setBounds(1130,50, 150,50); 
	      win.add(l14);
	      
	      memberIdTextField=new JTextField();  
	      memberIdTextField.setBounds(180,70, 270,30);
		  win.add(memberIdTextField);
	      
		  
		  memberNametextField=new JTextField();  
		  memberNametextField.setBounds(180,120,270,30);
		  win.add(memberNametextField);
		 
		  fatherNameTextField=new JTextField();  
		  fatherNameTextField.setBounds(180,170, 270,30);
		  win.add(fatherNameTextField);
		  
		  surnameTextfield=new JTextField();  
		  surnameTextfield.setBounds(180,220, 270,30);
		  win.add(surnameTextfield);
			 
		  cnicNumbertextField=new JTextField();  
		  cnicNumbertextField.setBounds(180,270, 270,30);
		  win.add(cnicNumbertextField);
		  
          contactNotextField=new JTextField();  
		  contactNotextField.setBounds(180,320, 270,30);
		  win.add(contactNotextField);
		 
		  guardianOccupation=new JTextField();
		  guardianOccupation.setBounds(180, 370, 270,30);
		  win.add(guardianOccupation);
		  
		  
		  addressTextfield=new JTextField();  
		  addressTextfield.setBounds(180,420, 270,30);
		  win.add(addressTextfield);
		  
		  /*remarksTextarea = new JTextField();
		  remarksTextarea.setBounds(130,480, 280,100);  
		  win.add(remarksTextarea);*/

		  area.setBounds(180,490,280,100);
		  win.add(area);
		  
		  r1.setBounds(180,460,100,30);    
		  r2.setBounds(280,460,100,30); 
	
		  bg.add(r1);
		  bg.add(r2);    
		  win.add(r1);
		  win.add(r2);

	
	     addBtn.setBounds(175,620,80,40);  
		 win.add(addBtn);
	     
		 
		 updateBtn.setBounds(270,620,80,40);  
		 win.add(updateBtn);
		 
		 clearBtn.setBounds(370,620,80,40);  
		 win.add(clearBtn);
		 
		 
		 exitBtn.setBounds(480,620,80,40);  
		 win.add(exitBtn);
		
		 deleteBtn.setBounds(570,620,80,40);  
		 win.add(deleteBtn);
		 
	
		 addBtn.addActionListener(this);
		 updateBtn.addActionListener(this);
		 deleteBtn.addActionListener(this);
		 clearBtn.addActionListener(this);
		 exitBtn.addActionListener(this);
		 
		 
		
		//setMemberData(model);
		actionOnList(list);
		
		
		 
		 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 setMemberData(model);
		 setMemberDataTableEvent(jt);
	   	 actionOnList(list); 
	   	 resizeColumnWidth(jt);
		
		
		
}
////////////////////******************************* it is used for table data to in  textfield *****************************///////////////
private void setMemberDataTableEvent(JTable jt2) {

		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int rowIn = jt.getSelectedRow();
				
				MemberPojo pojo = new MemberPojo();
				String memberId  = jt.getValueAt(rowIn, 0).toString();
				String memberName= jt.getValueAt(rowIn, 1).toString();
				String fName=jt.getValueAt(rowIn, 2).toString();
			    String surname=jt.getValueAt(rowIn, 3).toString();
			    String cnicNo=jt.getValueAt(rowIn, 4).toString();
			    String contactNo=jt.getValueAt(rowIn, 5).toString();
			    String  guardianOccuption=jt.getValueAt(rowIn, 6).toString();
			    String  address=jt.getValueAt(rowIn, 7).toString();
			    String   gender=jt.getValueAt(rowIn, 8).toString();
			    String  remarks=jt.getValueAt(rowIn, 9).toString();
			    
				pojo.setMemberId(Integer.parseInt(memberId));
				pojo.setMemberName(memberName);
				pojo.setfName(fName);
			    pojo.setSurname(surname);
				pojo.setCnic(cnicNo);
				pojo.setContactNo(contactNo);
				pojo.setGuardianOccupation(guardianOccuption);;
			    pojo.setAddress(address);
			    pojo.setGender(gender);
				pojo.setRemarks(remarks);
				
				/*JOptionPane.showMessageDialog(null, "Member ID : "+pojo.getMemberId());
				JOptionPane.showMessageDialog(null, "Member Name : "+pojo.getMemberName());
				JOptionPane.showMessageDialog(null, "fName : "+pojo.getfName());
				JOptionPane.showMessageDialog(null, "Surname : "+pojo.getSurname());
				JOptionPane.showMessageDialog(null, "Cnic No: "+pojo.getCnic());
				JOptionPane.showMessageDialog(null, "Contact No : "+pojo.getContactNo());
				JOptionPane.showMessageDialog(null, "Guardian Occuption : "+pojo.getGuardianOccupation());
				JOptionPane.showMessageDialog(null, "Address: "+pojo.getAddress());
				JOptionPane.showMessageDialog(null, "EMP Gender : "+pojo.getGender());
				JOptionPane.showMessageDialog(null, "Remarks : "+pojo.getRemarks());*/

				
				
				memberIdTextField.setText(""+pojo.getMemberId());
				memberNametextField.setText(pojo.getMemberName());
				fatherNameTextField.setText(pojo.getfName());
				surnameTextfield.setText(pojo.getSurname());
				cnicNumbertextField.setText(pojo.getCnic());
				contactNotextField.setText(pojo.getContactNo());
				addressTextfield.setText(pojo.getAddress());
				guardianOccupation.setText(pojo.getGuardianOccupation());
				if (r1.isSelected()) {
					pojo.setGender(r1.getText());
				}else{
					pojo.setGender(r1.getText());
				}
				
				area.setText(pojo.getRemarks());
				
				
			}
		});

	
	
}// end of setMemberDataTableEvent method. 

private void setMemberData(DefaultTableModel model) {
	
		System.out.println("set Data");
		List<MemberPojo> list = member_dao.getMembers();
		
		
		for(String column:columns){
			model.addColumn(column);
			
		}
		
		
		for(MemberPojo member:list){
			model.addRow(new Object[]{member.getMemberId(),member.getMemberName(),member.getfName(),member.getSurname(),member.getCnic(),member.getContactNo(),member.getGuardianOccupation(),member.getAddress(),member.getGender(),member.getRemarks()});
		}
		
		
	
}// end of jtable  to show data in jtable.
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
	    
	    
}// end of Jtable resize column method.	
	public void actionOnList(JList list){
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				//JOptionPane.showMessageDialog(null,list.getSelectedValue());
				String contact  = (String)list.getSelectedValue();
				MemberPojo member = member_dao.getMembersByContactNumber(contact);
				JOptionPane.showMessageDialog(null, ""+contact);
				//JOptionPane.showMessageDialog(null,member.getMemberName());
				
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
	}

@Override
public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == addBtn){
			
			MemberPojo emp = new MemberPojo ();
			
			emp.setMemberName(memberNametextField.getText());			
			emp.setfName(fatherNameTextField.getText());
			emp.setSurname(surnameTextfield.getText());
			emp.setCnic(cnicNumbertextField.getText());
			emp.setContactNo(contactNotextField.getText());
			emp.setGuardianOccupation(guardianOccupation.getText());
			emp.setAddress(addressTextfield.getText());
			emp.setRemarks(area.getText());
			if (r1.isSelected()) {
				emp.setGender(r1.getText());
			}else{
				emp.setGender(r2.getText());
			}
			
			if(isAnyFieldEmpty(emp)){
				
				member_dao.saveMember(emp);
				
			}
			
			JOptionPane.showMessageDialog(null,"Data Add");
			
		}else if(e.getSource() == updateBtn){
			   
			MemberPojo  emp = new MemberPojo ();
			    
				int memberId=Integer.parseInt(memberIdTextField.getText());
				emp.setMemberId(memberId);
	            emp.setMemberName(memberNametextField.getText());
				emp.setfName(fatherNameTextField.getText());
				emp.setSurname(surnameTextfield.getText());
				emp.setCnic(cnicNumbertextField.getText());
				emp.setContactNo(contactNotextField.getText());
				emp.setGuardianOccupation(guardianOccupation.getText());
			    emp.setAddress(addressTextfield.getText());
				emp.setRemarks(area.getText());
				if (r1.isSelected()) {
					emp.setGender(r1.getText());
				}else{
					emp.setGender(r2.getText());
				}
			
				member_dao.updateMember(emp);
			
				
			
			JOptionPane.showMessageDialog(null, "Update Action Event");
		}
		else if(e.getSource()==clearBtn){
			
		  
			   memberIdTextField.setText("");
			   memberNametextField.setText("");  
			   fatherNameTextField.setText("");
			   surnameTextfield.setText("");
			   cnicNumbertextField.setText("");
			   guardianOccupation.setText("");
			   contactNotextField.setText(""); 
			   addressTextfield.setText("");
			   area.setText("");
			   
			
			
			
			
		}else if(e.getSource()==exitBtn){

			   System.exit(0);
			
		}else if(e.getSource()==deleteBtn) {
			
			MemberPojo  emp = new MemberPojo ();
			
			
			int memberId=Integer.parseInt(memberIdTextField.getText());
			emp.setMemberId(memberId);
			

			JOptionPane.showMessageDialog(null, "Delete Data ");
			
			member_dao.deleteMember(emp);
			
		
			
		 }
		
		
		
		
	}// end of addactionlistiner method.
	
private boolean isAnyFieldEmpty(MemberPojo emp) {
		
	    boolean b=false;	
		
	    if(emp.getMemberName().isEmpty())
	        JOptionPane.showMessageDialog(null, "Please Enter MemberName");
	    else if(emp.getfName().isEmpty())
	         JOptionPane.showMessageDialog(null, "Please Enter FatherName");
	    else if(emp.getSurname().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Surname");
	    else if(emp.getCnic().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter CNIC No");
	    else if(emp.getContactNo().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Contact No");
	    else if(emp.getAddress().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Email Id");
	    else if(emp.getGender().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Gender ");
	    else if(emp.getRemarks().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Remarks");
	    else 
	         b=true;
		     
	         return b;
		
	
	}



  
  
  
  
	

	public static void main(String[] args) {

		new  MemberFrame();
		

	}

	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}