package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;


import repository.*;
import entity.*;


public class ManageBook extends JFrame  implements ActionListener
{
	private JLabel bookIdLabel,bookNameLabel,writterNameLabel,priceLabel,numberOFcopyLabel;
	private JTextField bookIdTF, bookNameTF,writterNameTF,priceTF,numberOFcopyTF;
	private JButton loadBtn,insertBtn,updateBtn,deleteBtn,refreshBtn,getAllBtn,backBtn,logoutBtn;
	private JPanel panel;
	private JTable bookTable;
	private JScrollPane bookTableSP;
	
	private User user;
	private BookRepo br;
	private Home h;

	
	public ManageBook(User user, Home h)
	{
		super("Manage Book");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		br = new BookRepo();
		this.user = user;
		this.h = h;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Id", "Name", "Writter", "Price","No of Copy"};
		
		bookTable = new JTable(data,head);
		bookTableSP = new JScrollPane(bookTable);
		bookTableSP.setBounds(350,100,500,150);
		bookTableSP.setEnabled(false);
		panel.add(bookTableSP);
		
		bookIdLabel= new JLabel("ID :");
		bookIdLabel.setBounds(100,100,100,30);
		panel.add(bookIdLabel);
		
		bookIdTF = new JTextField();
		bookIdTF.setBounds(220,100,100,30);
		panel.add(bookIdTF);
		
		bookNameLabel= new JLabel("NAME :");
		bookNameLabel.setBounds(100,150,100,30);
		panel.add(bookNameLabel);
		
		bookNameTF = new JTextField();
		bookNameTF.setBounds(220,150,100,30);
		panel.add(bookNameTF);
		
		writterNameLabel= new JLabel("Writter : ");
		writterNameLabel.setBounds(100,200,100,30);
		panel.add(writterNameLabel);
		
	    writterNameTF = new JTextField();
		writterNameTF.setBounds(220,200,100,30);
		panel.add(writterNameTF);
		
		priceLabel = new JLabel("Price: ");
		priceLabel.setBounds(100,250,100,30);
		panel.add(priceLabel);
		
		priceTF = new JTextField();
	    priceTF.setBounds(220,250,100,30);
		panel.add(priceTF);
		
		numberOFcopyLabel= new JLabel("No Of Copy: ");
		numberOFcopyLabel.setBounds(100,300,100,30);
		panel.add(numberOFcopyLabel);
		
		numberOFcopyTF = new JTextField();
		numberOFcopyTF.setBounds(220,300,100,30);
		panel.add(numberOFcopyTF);
		
        
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,400,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,400,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,400,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,400,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,400,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(600,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(700, 400, 80, 30);
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
			if(!bookIdTF.getText().equals("") || !bookIdTF.getText().equals(null))
			{
				Book b=br.searchBook(bookIdTF.getText());
				if(b!=null)
				{
					bookNameTF.setText(b.getName());
					writterNameTF.setText(b.getWritter());
					priceTF.setText(b.getPrice()+"");
					numberOFcopyTF.setText(b.getNumberOfcopy()+"");
					
					bookIdTF.setEnabled(false);
					bookNameTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Book b=new Book();
			b.setBookId(bookIdTF.getText());
			b.setName(bookNameTF.getText());
			b.setWritter(writterNameTF.getText());
			b.setPrice(Double.parseDouble(priceTF.getText()) );
			b.setNumberOfcopy(Integer.parseInt(numberOFcopyTF.getText()));
			//u.setUserId(bookIdTF.getText());
			
			br.addBook(b);
			//ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+bookIdTF.getText());
			
			bookIdTF.setText("");
			bookNameTF.setText("");
			writterNameTF.setText("");
			priceTF.setText("");
			numberOFcopyTF.setText("");
			
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			bookIdTF.setText("");
			bookNameTF.setText("");
			writterNameTF.setText("");
			priceTF.setText("");
			numberOFcopyTF.setText("");
			
			
			bookIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		else if(command.equals(updateBtn.getText()))
		{
			Book b=new Book();
			b.setBookId(bookIdTF.getText());
			b.setName(bookNameTF.getText());
			b.setWritter(writterNameTF.getText());
			b.setPrice( Double.parseDouble(priceTF.getText()) );
			b.setNumberOfcopy(Integer.parseInt(numberOFcopyTF.getText()));
			
			br.updateBookInfo(b);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			bookIdTF.setText("");
			bookNameTF.setText("");
			writterNameTF.setText("");
			priceTF.setText("");
			numberOFcopyTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			bookIdTF.setEnabled(true);
			bookNameTF.setEnabled(true);
		}
		
		else if(command.equals(deleteBtn.getText()))
		{
			br.deleteBook(bookIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			bookIdTF.setText("");
			bookNameTF.setText("");
			writterNameTF.setText("");
			priceTF.setText("");
			numberOFcopyTF.setText("");
			
			bookIdTF.setEnabled(true);
			bookNameTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		
		if(command.equals(getAllBtn.getText()))
		{
			String data[][] = br.getAllBook();
			String head[] = {"Id", "Name", "Writter", "Price","No of Copy"};
			
			panel.remove(bookTableSP);
			
			bookTable = new JTable(data,head);
			bookTable.setEnabled(false);
			bookTableSP = new JScrollPane(bookTable);
			bookTableSP.setBounds(350,100,500,150);
			panel.add(bookTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else if(command.equals(backBtn.getText()))
		{
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