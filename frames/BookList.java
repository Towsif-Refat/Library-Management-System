package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


import repository.*;
import entity.*;

public class BookList extends JFrame implements ActionListener
{
	
	private JButton  backBtn,getAllBtn;
	private JPanel panel;
	private JTable bookTable;
	private JScrollPane bookTableSP;
	private JLabel imgLabel;
	private ImageIcon img;

	private User user;
    private BookRepo br;
	private UserRepo ur;
	
	public BookList(User user)
	{
		super("Book List");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
        br= new BookRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
	
	
		
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Id", "Name", "Writter", "Price","No of Copy"};
		
		bookTable = new JTable(data,head);
		bookTableSP = new JScrollPane(bookTable);
		bookTableSP.setBounds(30, 30, 700, 300);
		bookTableSP.setEnabled(false);
		panel.add(bookTableSP);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		getAllBtn = new JButton("View");
		getAllBtn.setBounds(500,350,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		
		img = new ImageIcon("back.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 450);
		panel.add(imgLabel);
		
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
		
			if(command.equals(getAllBtn.getText()))
		{
			String data[][] = br.getAllBook();
			String head[] = {"Id", "Name", "Writter", "Price","No of Copy"};
			
			panel.remove(bookTableSP);
			
			bookTable = new JTable(data,head);
			bookTable.setEnabled(false);
			bookTableSP = new JScrollPane(bookTable);
			bookTableSP.setBounds(30, 30, 700, 300);
			panel.add(bookTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		
		else{}
	}
	
}