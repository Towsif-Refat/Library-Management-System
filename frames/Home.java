package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class Home extends JFrame implements ActionListener
{
	JButton logoutBtn, manageuserBtn, manageBookBtn, viewBookBtn, issueBookBtn,changePasswordBtn;
	JLabel imgLabel;
	JPanel panel;
	Color myColor;
	ImageIcon img;


	User user;
	
	public Home(User user)
	{
		super("Library Management System");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
	
		myColor = new Color(84, 127, 245);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 20, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.addActionListener(this);
		changePasswordBtn.setBounds(430, 20, 150, 30);
		panel.add(changePasswordBtn);
		
		
		manageuserBtn = new JButton("Manage User");
		manageuserBtn.setBounds(70, 130, 150, 30);
		manageuserBtn.addActionListener(this);
		panel.add(manageuserBtn);
		
		manageBookBtn = new JButton("Manage Book");
		manageBookBtn.setBounds(250, 130, 150, 30);
		manageBookBtn.addActionListener(this);
		panel.add(manageBookBtn);
		
		viewBookBtn = new JButton(" Book list");
		viewBookBtn.setBounds(70,200, 150, 30);
		viewBookBtn.addActionListener(this);
		panel.add(viewBookBtn);
		
		issueBookBtn = new JButton("Issue Book");
		issueBookBtn.setBounds(250, 200, 150, 30);
		issueBookBtn.addActionListener(this);
		panel.add(issueBookBtn);
	
		
		img = new ImageIcon("lib.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(693, 330, 100, 100);
		panel.add(imgLabel);
		
		img = new ImageIcon("back.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 450);
		panel.add(imgLabel);
				
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(viewBookBtn.getText()))
		{
			if(user.getStatus()==0 ||user.getStatus()==1)
			{
				BookList bl = new BookList(user);
				bl.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(manageBookBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManageBook mb= new ManageBook(user,this);
				mb.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(issueBookBtn.getText()))
		{
			if(user.getStatus()==1||user.getStatus()==0)
			{
				IssueBook i= new IssueBook(user);
				i.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			if(user.getStatus()==0 ||user.getStatus()==1)
			{
				PasswordChange pc = new PasswordChange(user);
				pc.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(manageuserBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManageStudent ms = new ManageStudent(user);
				ms.setVisible(true);
				this.setVisible(false);
			}
		}

		else{}
		
	}
}