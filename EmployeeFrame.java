package com.jframes.swing;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;

import com.dao.*;
import com.dao.impl.*;
import com.pojos.*;

public class EmployeeFrame  implements ActionListener{

	EmployeeDao emp_dao = new EmployeeDaoImpl();
	
	JFrame win = null;
	JButton addBtn;
    JButton updateBtn;
    JButton clearBtn;
    JButton exitBtn;
    JButton deleteBtn;

    ButtonGroup bg;
    JRadioButton r1;
    JRadioButton r2;
	
    String columns[]={"EMPLOYEE ID","EMPLOYEE NAME" ,"FNAME","SURNAME", "CNIC NO", "CONTACT NO", "EMAIL ID", "GENDER", "REMARKS", "USER NAME", "USER PASSWORD"};
    
    
    JLabel employeeRigesterationformLabel,employeeIdlabel, employeeNamelabel, fatherNamelabel, surnameLabel, cnicNolabel, contactNolabel, emailIdlabel, selectGenderlabel, remarksLabel,cnicNumberLabel, showDatalabel, userNamelabel, userPasswordlabel; // JLabel declare.
    JTextField  employeeidTextfield, employeeNametextField, fNametextField, surnameTextfield,cnicNumbertextField,contactNotextField, userNametextField, userPasswordtextField, emailIdtextField,genderRadiobtn, remarksTextarea; // JTextField declare.
  
    
    DefaultTableModel model = new DefaultTableModel();
    JTable jt2 = null;
    

    DefaultListModel<String>  listModel= new DefaultListModel<>();  
    JList<String> list = new JList<String>(listModel);
    JList jt1=null;
    
  
    
    
public EmployeeFrame() {
		
			win=new JFrame();
			
			
			win.setSize(1050,730);//400 width and 500 height  
		
			List<EmployeePojo> pojodata = emp_dao.getEmployees();
			for(EmployeePojo pojo:pojodata){
				listModel.addElement(pojo.getCnic());
				System.out.println(pojo.getCnic());
			}
			
		    
		    
		 list.setBounds(430,90, 130,540); ///////////////********************** set bounds of Jlist *************\\\\\\\\\\\\\\\\\\\\\\
	     win.add(list); 
	
	  
	
        
    	 r1=new JRadioButton("A) Male");    
		 r2=new JRadioButton("B) Female");  
		 bg=new ButtonGroup();   
		

	
		  win.setLayout(null);//using no layout managers  
		  win.setVisible(true);//making the frame visible
	    
          addBtn = new JButton("ADD");  
		  updateBtn=new JButton("UPDATE");  
		  clearBtn=new JButton("CLEAR");  
		  exitBtn=new JButton("EXIT");
		  deleteBtn=new JButton("DELETE"); 
		
                   
          jt2=new JTable(model);    
          JScrollPane sp=new JScrollPane(jt2);    
          win.add(sp);
          sp.setBounds(580, 100, 760, 300);///////////////////***********here set of JTable Set Bounds***********************///////////////////////////////
	  
			
          employeeRigesterationformLabel=new JLabel("  EMPLOYEE    REGISTERATION    FORM  ");
          employeeRigesterationformLabel.setBounds(180,10, 250,50); 
	      win.add(employeeRigesterationformLabel);
		 
	      employeeIdlabel=new JLabel("EMPLOYEE  ID");
	      employeeIdlabel.setBounds(20,60, 150,50); 
	      win.add(employeeIdlabel);
 
	      employeeNamelabel=new JLabel("EMPLOYEE  NAME");
	      employeeNamelabel.setBounds(20,110,150,50);
		  win.add(employeeNamelabel);
		
		  fatherNamelabel=new JLabel("FATHER  NAME");
		  fatherNamelabel.setBounds(20,160,150,50);
		  win.add(fatherNamelabel);
		
		  surnameLabel=new JLabel("SURNAME");
		  surnameLabel.setBounds(20,210,150,50);
		  win.add(surnameLabel);
		
		  cnicNolabel=new JLabel("CNIC NUMBER");
		  cnicNolabel.setBounds(20,260, 150,50); 
	      win.add(cnicNolabel);
	    
	      contactNolabel=new JLabel("CONTACT NUMBER");
	      contactNolabel.setBounds(20,310,150,50);
		  win.add(contactNolabel);
	    
		  
		  emailIdlabel=new JLabel("EMAIL ID");
		  emailIdlabel.setBounds(20,360,150,50);
		  win.add(emailIdlabel);
		
		  
		
		  
		  userNamelabel=new JLabel("User Name");
		  userNamelabel.setBounds(20,400,200,50);
		  win.add(userNamelabel);
		  
		  
		  userPasswordlabel=new JLabel("UserPassword");
		  userPasswordlabel.setBounds(20, 450, 200, 50);
          win.add(userPasswordlabel);
		  
		  
		  selectGenderlabel=new JLabel("SELECT  GENDER");
		  selectGenderlabel.setBounds(20,490,200,50);
		  win.add(selectGenderlabel);
		  
		
          
		  remarksLabel=new JLabel("REMARKS");
		  remarksLabel.setBounds(20,520,150,50);
		  win.add(remarksLabel);
		  
		  
		  cnicNumberLabel=new JLabel(" CNIC NUMBER ");// it is used for jlist label.
		  cnicNumberLabel.setBounds(450,50, 150,50); 
	      win.add(cnicNumberLabel);

	      showDatalabel=new JLabel(" SHOW DATA ");// it is used for jlist label.
	      showDatalabel.setBounds(950,50, 150,50); 
	      win.add(showDatalabel);

	      
	      employeeidTextfield=new JTextField();  
	      employeeidTextfield.setBounds(130,70, 280,30);
		  win.add(employeeidTextfield);
		     
			 
		  employeeNametextField=new JTextField();  
		  employeeNametextField.setBounds(130,120, 280,30);
		  win.add( employeeNametextField);
			
		     

		  fNametextField=new JTextField();  
		  fNametextField.setBounds(130,170, 280,30);
		  win.add(fNametextField);
		 
		  
		  surnameTextfield=new JTextField();  
		  surnameTextfield.setBounds(130,220, 280,30);
		  win.add( surnameTextfield);
			
		  
		  cnicNumbertextField=new JTextField();  
		  cnicNumbertextField.setBounds(130,270, 280,30);
		  win.add(cnicNumbertextField);
		 
	 
	      
		  contactNotextField=new JTextField();  
		  contactNotextField.setBounds(130,320, 280,30);
		  win.add(contactNotextField);
		 
		  emailIdtextField=new JTextField();
		  emailIdtextField.setBounds(130,370,280,30);
		  win.add( emailIdtextField);
	
	      userNametextField=new JTextField();
	      userNametextField.setBounds(130, 420, 280, 30);
	      win.add(userNametextField);
		 
	      userPasswordtextField=new JTextField();
	      userPasswordtextField.setBounds(130, 470, 280, 30);
	      win.add(userPasswordtextField);
	      
	      
		  remarksTextarea = new JTextField();
		  remarksTextarea.setBounds(130,550, 280,80);  
		  win.add(remarksTextarea);
			
		 
		 
		  r1.setBounds(180,510,100,30);   /////////////////////// here is setbounds of r1 radio button. //////////////////////////////////////////
		  r2.setBounds(280,510,100,30);   /////////////////////// here is setbounds of r2 radio button. ////////////////////////////////////////// 
	
		  bg.add(r1);
		  bg.add(r2);    
		  win.add(r1);
		  win.add(r2);
		 
		 
	     addBtn.setBounds(20,650,80,40); ///////////////////****************Set Bounds of Add Button*************///////////////////////////////
		 win.add(addBtn);
	     
		 
		 updateBtn.setBounds(120,650,80,40);  ///////////////////****************Set Bounds of Update Button*************///////////////////////////////
		 win.add(updateBtn);
		 
		 clearBtn.setBounds(220,650,80,40);  ///////////////////****************Set Bounds of Clear Button*************///////////////////////////////
		 win.add(clearBtn);
		 
		 
		 exitBtn.setBounds(330,650,80,40); ///////////////////****************Set Bounds of Exit Button*************/////////////////////////////// 
		 win.add(exitBtn);
		
		 deleteBtn.setBounds(460,650,80,40); ///////////////////****************Set Bounds of delete  Button*************/////////////////////////////// 
		 win.add(deleteBtn);
		 
		
		 
		 addBtn.addActionListener(this);
		 updateBtn.addActionListener(this);
		 deleteBtn.addActionListener(this);
		 clearBtn.addActionListener(this);
		 exitBtn.addActionListener(this);
		 
		 
		 jt2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 setEmployeeData(model);
		 setEmployeeDataTableEvent(jt2);
	   	 actionOnList(list); 
	   	 resizeColumnWidth(jt2);
	   	 
}// end of constructor.

private void setEmployeeDataTableEvent(JTable jt) {
	
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int rowIn = jt.getSelectedRow();
				
				EmployeePojo pojo = new EmployeePojo();
				pojo.setEmployeeId(Integer.parseInt(jt.getValueAt(rowIn, 0).toString()));
				pojo.setEmployeeName(jt.getValueAt(rowIn, 1).toString());
				pojo.setfName(jt.getValueAt(rowIn, 2).toString());
			    pojo.setSurname(jt.getValueAt(rowIn, 3).toString());
			    pojo.setCnic(jt.getValueAt(rowIn, 4).toString());
				pojo.setContactNo(jt.getValueAt(rowIn, 5).toString());
		        pojo.setEmailId(jt.getValueAt(rowIn, 6).toString());
		        pojo.setGender(jt.getValueAt(rowIn, 7).toString());
		        pojo.setUserName(jt.getValueAt(rowIn, 8).toString());
		        pojo.setPassword(jt.getValueAt(rowIn, 9).toString());
		        pojo.setRemarks(jt.getValueAt(rowIn, 10).toString());
				
		        
				JOptionPane.showMessageDialog(null, "EMP ID : "+pojo.getEmployeeId());
				JOptionPane.showMessageDialog(null, "EMP Name : "+pojo.getEmployeeName());
				JOptionPane.showMessageDialog(null, "EMP fName : "+pojo.getfName());
				JOptionPane.showMessageDialog(null, "EMP Surname : "+pojo.getSurname());
				JOptionPane.showMessageDialog(null, "EMP Cnic: "+pojo.getCnic());
				JOptionPane.showMessageDialog(null, "EMP ContactNo : "+pojo.getContactNo());
				JOptionPane.showMessageDialog(null, "EMP Email Id : "+pojo.getEmailId());
				JOptionPane.showMessageDialog(null, "EMP Gender : "+pojo.getGender());
				
                JOptionPane.showMessageDialog(null, "EMP User Name : "+pojo.getUserName());
				JOptionPane.showMessageDialog(null, "EMP User Password : "+pojo.getPassword());
				//JOptionPane.showMessageDialog(null, "EMP Remarks : "+pojo.getRemarks());

				
				employeeidTextfield.setText(""+pojo.getEmployeeId());
				employeeNametextField.setText(pojo.getEmployeeName());
				fNametextField.setText(pojo.getfName());
				surnameTextfield.setText(pojo.getSurname());
				cnicNumbertextField.setText(pojo.getCnic());
				contactNotextField.setText(pojo.getContactNo());
				emailIdtextField.setText(pojo.getEmailId());
				
				userNametextField.setText(pojo.getUserName());
				userPasswordtextField.setText(pojo.getPassword());
				
				r1.setText(pojo.getGender());
				r2.setText(pojo.getGender());
				
				if (r1.isSelected()) {
					pojo.setGender(r1.getText());
				}else{
					pojo.setGender(r1.getText());
				}
				
				remarksTextarea.setText(pojo.getRemarks()); 
				
				
			}
		});
		
		
		
}///end of jtable method.

private void actionOnList(JList list) {
		
	
	list.addListSelectionListener(new ListSelectionListener() {

	//////////////////////////****************here is select one value in jlist than to fill all textfield values.		
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				String cnicNo  = (String)list.getSelectedValue();
				EmployeePojo employee = emp_dao.getEmployeeByCNICNumber(cnicNo);
			
				
			    employeeidTextfield.setText(""+employee.getEmployeeId());
				
				employeeNametextField.setText(employee.getEmployeeName());
			    fNametextField.setText(employee.getfName());
			    surnameTextfield.setText(employee.getSurname());
				cnicNumbertextField.setText(employee.getCnic());
				contactNotextField.setText(employee.getContactNo());
				emailIdtextField.setText(employee.getEmailId());
				
				userNametextField.setText(employee.getUserName());
				userPasswordtextField.setText(employee.getPassword());
				remarksTextarea.setText(employee.getRemarks());
				
				if (r1.isSelected()) {
					employee.setGender(r1.getText());
				}else{
					employee.setGender(r1.getText());
				}
				
				
				
				
		       System.out.print(employee);
				
				
			}
		});
		
}// end of actionList method. 
	
private void setEmployeeData(DefaultTableModel model2) {
	
		System.out.println("set Data");
		List<EmployeePojo> list = emp_dao.getEmployees();
		
		for(String column:columns){
			model.addColumn(column);
		}
		
		for(EmployeePojo employee:list){
			System.out.println(employee.getRemarks());
			model.addRow(new Object[]{employee.getEmployeeId(),employee.getEmployeeName(),employee.getfName(),employee.getSurname(),employee.getCnic(),employee.getContactNo(),employee.getEmailId(),employee.getGender(),employee.getRemarks(), employee.getUserName(), employee.getPassword() });
		   //System.out.println((employee.getEmployeeId(),employee.getEmployeeName(),employee.getfName(),employee.getSurname(),employee.getCnic(),employee.getContactNo(),employee.getEmailId(),employee.getGender(),employee.getRemarks(), employee.getUserName(), employee.getPassword()));
		   //System.out.print(););
		}
		
}// end of setMemberData method.

@Override
public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == addBtn){
			
			EmployeePojo emp = new EmployeePojo();
			
			
			//emp.setEmployeeId(employeeidTextfield.getText());
			emp.setEmployeeName(employeeNametextField.getText());
			emp.setfName(fNametextField.getText());
			emp.setSurname(surnameTextfield.getText());
			emp.setCnic(cnicNumbertextField.getText());
			emp.setContactNo(contactNotextField.getText());
			emp.setEmailId(emailIdtextField.getText());
			emp.setUserName(userNametextField.getText());
			emp.setPassword(userPasswordtextField.getText());
			
			if (r1.isSelected()) {
				emp.setGender(r1.getText());
			}else{
				emp.setGender(r1.getText());
			}
			
			
			emp.setRemarks(remarksTextarea.getText());
			
			if(isAnyFieldEmpty(emp)){
				
				
				emp_dao.saveEmployee(emp);
				
				
			}
			
			
			
			
			JOptionPane.showMessageDialog(null, "Add Data");
			
		}else if(e.getSource() == updateBtn){
			   
			    EmployeePojo emp = new EmployeePojo();
			    int employeeId=Integer.parseInt(employeeidTextfield.getText());
				emp.setEmployeeId(employeeId);
	            emp.setEmployeeName(employeeNametextField.getText());
				emp.setfName(fNametextField.getText());
				emp.setSurname(surnameTextfield.getText());
				emp.setCnic(cnicNumbertextField.getText());
				emp.setContactNo(contactNotextField.getText());
				emp.setEmailId(emailIdtextField.getText());
				emp.setRemarks(remarksTextarea.getText());
				if (r1.isSelected()) {
					emp.setGender(r1.getText());
				}else{
					emp.setGender(r2.getText());
				}
			
				emp_dao.updateEmployee(emp);
			
				
			
			JOptionPane.showMessageDialog(null, "Update Action Event");
		
		}else if(e.getSource()==clearBtn){
			  
			 employeeidTextfield.setText(""); 
			 employeeNametextField.setText(""); 
			 fNametextField.setText(""); 
			 surnameTextfield.setText("");
			 cnicNumbertextField.setText("");
			 contactNotextField.setText(""); 
			 emailIdtextField.setText("");
			 remarksTextarea.setText("");
			 userNametextField.setText("");
			 userPasswordtextField.setText("");
			  
			
		}else if(e.getSource()==exitBtn){

			   System.exit(0);
			
		}else if(e.getSource()==deleteBtn) {
			
	         EmployeePojo  emp = new EmployeePojo ();
		
		    int employeeId=Integer.parseInt(employeeidTextfield.getText());
			emp.setEmployeeId(employeeId);

			JOptionPane.showMessageDialog(null, "Delete Data ");
			
			emp_dao.deleteEmployee(emp);
			
			
			
		}
		
}// end of actionPerformed  method  .		
private boolean isAnyFieldEmpty(EmployeePojo emp) {
	
		
	    boolean b=false;	
		
	    if(emp.getEmployeeName().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter EmployeeName");
	    else if(emp.getfName().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter FatherName");
	    else if(emp.getSurname().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Surname");
	    else if(emp.getCnic().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter CNIC No");
	    else if(emp.getContactNo().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Contact No");
	    else if(emp.getEmailId().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Email Id");
	    else if(emp.getGender().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Gender ");
	    else if(emp.getRemarks().isEmpty())
	    	JOptionPane.showMessageDialog(null, "Please Enter Remarks");
	    else
	    	b=true;
		
		   return b;
		
		
}// end of Validiation  method.


////////////////////////******************Start  of JTable Method*****************\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

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
	    
}// end of Jtable method.	


public static void main(String[] args) {
	
		
		new EmployeeFrame();

}// end of main method.


		
}