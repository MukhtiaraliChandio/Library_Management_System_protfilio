package com.jframes.swing;




import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.ImageIcon;




public class MainFrame implements ActionListener {

	
	

	JFrame win;
	//JButton  dashboardBtn;
	JButton  bookFrameBtn;
    JButton  bookIssueframeBtn;
    JButton  employeeFrameBtn;
    JButton  memberFrameBtn;
    JButton  loginFrameBtn;
    JButton  exitBtn;

    ImageIcon image; 
    JLabel displayField;
    JLabel libraryManagementsystemLabel; 
	
    JLabel background;
	public MainFrame() {
		
           win=new JFrame();
		   win.setSize(950,730);//400 width and 500 height  
	
		   win.setLayout(null);//using no layout managers  
		   win.setVisible(true);//making the frame visible
	       
		   libraryManagementsystemLabel=new JLabel(" LIBARARY   MANAGEMENT  SYSTEM");
		   
		   libraryManagementsystemLabel.setBounds(350, 30, 800, 50);
		   libraryManagementsystemLabel.setFont(new Font("Verdana", Font.PLAIN, 40));

		   win.add(libraryManagementsystemLabel);
		   
			ImageIcon img=new  ImageIcon("libraryimage.jpg");
			
			background=new JLabel("",img,JLabel.CENTER);
		    background.setBounds(0, 0, 1200, 700);
			win.add(background);
		   
		   JLabel label = new JLabel("SUBJECT ");
		   ImageIcon image = new ImageIcon("file:///C:/Users/MUKHTIAR%20ALI%20CHANDIO/workspace/Laiquat%20Library%20Management%20System/src/com/jframes/swing/librarypic.jpg");
		  // label.setIcon(new ImageIcon("C:/Users/MUKHTIAR ALI CHANDIO/Desktop/Student Mangent System Pics/librarypic.jpg"));
		   
		  // dashboardBtn=new JButton("DASHBOARD");
		   loginFrameBtn=new JButton("LOGIN FRAME");
		   employeeFrameBtn=new JButton("EMPLOYEE FRAME");  
		   memberFrameBtn=new JButton("MEMBER FRAME");  
		   bookFrameBtn=new JButton("BOOK FRAME");  
		   bookIssueframeBtn=new JButton("BOOK ISSUE FRAME");
		   exitBtn=new JButton("EXIT BUTTON");

		   
		  // dashboardBtn.setBounds(80, 130, 150, 40);
		   //win.add(dashboardBtn);
		   
		   
		   loginFrameBtn.setBounds(550,180,150,40);  
		   win.add(loginFrameBtn);

		   
		   employeeFrameBtn.setBounds(550,230,150,40);  
		   win.add(employeeFrameBtn);
		     
		   memberFrameBtn.setBounds(550,280,150,40);  
		   win.add(memberFrameBtn);

			
		   bookFrameBtn.setBounds(550,330,150,40);  
           win.add(bookFrameBtn);

		   
		   bookIssueframeBtn.setBounds(550,380,150,40);  
		   win.add(bookIssueframeBtn);
			  
		   exitBtn.setBounds(550,430,150,40);  
		   win.add(exitBtn);
		   
	  
		   loginFrameBtn.addActionListener(this);
		   employeeFrameBtn.addActionListener(this);
	       memberFrameBtn.addActionListener(this);
		   bookFrameBtn.addActionListener(this);
		   bookIssueframeBtn.addActionListener(this);
		   exitBtn.addActionListener(this);
		   
		   //win.add(new JLabel(new ImageIcon("C:/Users/MUKHTIAR ALI CHANDIO/Desktop/Student Mangent System Pics/librarypic.jpg")));
		   //image =new ImageIcon(getClass.getResource("librarypic.jpg"));
		   //displayField=JLabel(image);
		   
		   try {
			BufferedImage bufferedImage = ImageIO.read(new File("C:\\librarypic.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}// end of constructor method.
	
	public void actionPerformed(ActionEvent e) {

	      if(e.getSource()== loginFrameBtn) {
	    	 LoginFrame  ob1=new LoginFrame();
	    	  
	      }else if(e.getSource()==employeeFrameBtn) {
	    	  
	       
	    	 EmployeeFrame ob2=new EmployeeFrame();
	    	  
	      }else if(e.getSource()==memberFrameBtn) {
	    	  
	    	  MemberFrame ob3=new  MemberFrame();

	      }else if(e.getSource()== bookFrameBtn) {
	    	  BookRegisterationForm ob4=new BookRegisterationForm();

	    	  
	      }else if(e.getSource()== bookIssueframeBtn) {
	    	  
	    	  BookIssueFrame ob5=new  BookIssueFrame();

	    	  
	      }else if(e.getSource()==exitBtn) {
	    	  
	    	  System.exit(0);
	    	  
	      }
	      
	
	}//	
	
	public static void main(String[] args) {
		
		new MainFrame();

	}// end of main method.

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}