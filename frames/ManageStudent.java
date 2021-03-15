
package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManageStudent extends JFrame implements ActionListener
{
	private JLabel studentIdLabel, studentNameLabel; //era attribute tai camelcase. 
	private JTextField studentIdTF, studentNameTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn,logoutBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable studentTable;
	private JScrollPane studentTableSP;
	

	private StudentRepo sr;  //reference create korlam. 
	private User user;
	private UserRepo ur;
	private Home h;
	
	public ManageStudent(User user)
	{
		super("ManageFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		this.h = h;
		
		sr = new StudentRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", ""}};
		
		String head[] = {"Id", "Name"};
		
		studentTable = new JTable(data,head);
		studentTableSP = new JScrollPane(studentTable);
		studentTableSP.setBounds(350, 100, 400, 150);
		studentTable.setEnabled(false);
		panel.add(studentTableSP);
		
		studentIdLabel = new JLabel("ID :");
		studentIdLabel.setBounds(100,100,100,30);
		panel.add(studentIdLabel);
		
		studentIdTF = new JTextField();
		studentIdTF.setBounds(220,100,100,30);
		panel.add(studentIdTF);
		
		studentNameLabel = new JLabel("Name :");
		studentNameLabel.setBounds(100,150,100,30);
		panel.add(studentNameLabel);
		
		studentNameTF = new JTextField();
		studentNameTF.setBounds(220,150,100,30);
		panel.add(studentNameTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn= new JButton("Log Out");
		logoutBtn.setBounds(700, 350, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!studentIdTF.getText().equals("") || !studentIdTF.getText().equals(null))
			{
				Student s = sr.searchStudent(studentIdTF.getText());
				if(s!= null)
				{
					studentNameTF.setText(s.getstudentName());
				
					
					studentIdTF.setEnabled(false);
					studentNameTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Student s = new Student();
			User u=new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			s.setstudentId(studentIdTF.getText());
			s.setstudentName(studentNameTF.getText());
			
			u.setUserId(studentIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(1);
			
			
			sr.insertInDB(s);
			
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+studentIdTF.getText()+" and Password: "+x);
			
			studentIdTF.setText("");
			studentNameTF.setText("");
		
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			studentIdTF.setText("");
			studentNameTF.setText("");
			
			
			studentIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Student s = new Student();
			
			s.setstudentId(studentIdTF.getText());
			s.setstudentName(studentNameTF.getText());
			
			
			sr.updateInDB(s);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			studentIdTF.setText("");
			studentNameTF.setText("");
		
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			
		}
		else if(command.equals(deleteBtn.getText()))
		{
			sr.deleteFromDB(studentIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			studentIdTF.setText("");
			studentNameTF.setText("");
		
			studentIdTF.setEnabled(true);
			studentNameTF.setEnabled(true);
		
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = sr.getAllStudent();
			String head[] = {"Id", "Name"};
			
			panel.remove(studentTableSP);
			
			studentTable = new JTable(data,head);
			studentTable.setEnabled(false);
			studentTableSP = new JScrollPane(studentTable);
			studentTableSP.setBounds(350, 100, 400, 150);
			panel.add(studentTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			Home h = new Home(user);
		 	h.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}