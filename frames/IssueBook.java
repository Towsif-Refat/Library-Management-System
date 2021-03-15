package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;

import repository.*;
import entity.*;


public class IssueBook extends JFrame implements ActionListener
{
	private JLabel userIdLabel, bookIdLabel, issueIdLabel, issueDateLabel,  returnDateLabel;
	private JTextField userIdTF, bookIdTF, issueIdTF, issueDateTF, returnDateTF;
	private JButton insertBtn, backBtn ,logoutBtn,refreshBtn ,getAllBtn;
	private JPanel panel;
	private JTable issueTable;
	private JScrollPane issueTableSP;
	
	private User user;
	private IssueRepo ir;
	private UserRepo ur;
	private Home h;
	
	public IssueBook(User user)
	{
		
		
		
		super("Issue Book");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		this.h = h;
		
		ir = new IssueRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Issue Id", "Book id", "User ID", "Issue Date" , "Return Date"};
		
		issueTable = new JTable(data,head);
		issueTableSP = new JScrollPane(issueTable);
		issueTableSP.setBounds(350, 100, 400, 150);
		issueTable.setEnabled(false);
		panel.add(issueTableSP);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 20, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		userIdLabel = new JLabel("User ID :");
		userIdLabel.setBounds(100,100,100,30);
		panel.add(userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(220,100,100,30);
		panel.add(userIdTF);
		
		 bookIdLabel = new JLabel("Book ID:");
		 bookIdLabel.setBounds(100,150,100,30);
		panel.add( bookIdLabel);
		
		bookIdTF = new JTextField();
		bookIdTF.setBounds(220,150,100,30);
		panel.add(bookIdTF);
		
		issueIdLabel = new JLabel("Issue ID ");
		issueIdLabel.setBounds(100,200,100,30);
		panel.add(issueIdLabel);
		
		issueIdTF = new JTextField();
		issueIdTF.setBounds(220,200,100,30);
		panel.add(issueIdTF);
		
		issueDateLabel = new JLabel("Issue Date: ");
		issueDateLabel.setBounds(100,250,100,30);
		panel.add(issueDateLabel);
		
		issueDateTF = new JTextField();
		issueDateTF.setBounds(220,250,100,30);
		panel.add(issueDateTF);
		
		returnDateLabel= new JLabel("Return Date[Exp.]: ");
		returnDateLabel.setBounds(100,300,100,30);
		panel.add(returnDateLabel);
		
		returnDateTF = new JTextField();
		returnDateTF.setBounds(220,300,100,30);
		panel.add(returnDateTF);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		
		panel.add(refreshBtn);
		
		insertBtn = new JButton("Submit");  //insert er naam submit disi 
		insertBtn.setBounds(200,350,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		getAllBtn = new JButton("Confirm");  // get all buttun k  confirm buttun hishebe dekhabo , confirm hoile full database show korbe
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(backBtn.getText()))
		{
			Home h= new Home(user);
			h.setVisible(true);
			this.setVisible(false);
		}
	
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
	
		else if(command.equals(insertBtn.getText()))
		{
			
			Issue i=new Issue();
			i.setIssueId(issueIdTF.getText());
			i.setBookId(bookIdTF.getText());
			i.setUserId(userIdTF.getText());
			i.setIssueDate( issueDateTF.getText()) ;
			i.setReturnDate(returnDateTF.getText());
			
			
			ir.issue(i);
		
			
			JOptionPane.showMessageDialog(this, "Issued ");
			
			
			insertBtn.setEnabled(true);
			
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			issueIdTF.setText("");
			bookIdTF.setText("");
			userIdTF.setText("");
			issueDateTF.setText("");
			returnDateTF.setText("");
			
			issueIdTF.setEnabled(true);
		
			insertBtn.setEnabled(true);
		
			refreshBtn.setEnabled(false);
		}
		
			if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ir.getAllIssue();
			String head[] = {"Issue Id", "Book id", "User ID", "Issue Date" , "Return Date"};
			
			panel.remove(issueTableSP);
			
			issueTable = new JTable(data,head);
			issueTable.setEnabled(false);
			issueTableSP = new JScrollPane(issueTable);
			issueTableSP.setBounds(350, 100, 400, 150);
			panel.add(issueTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else{}
	}
	
}