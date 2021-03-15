package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class BookRepo implements IBookRepo
{
	DatabaseConnection dbc;
	
	public BookRepo()
	{
		System.out.println("BOOKREPO_Constructor");
		dbc = new DatabaseConnection();
	}
	
	public void addBook(Book b)
	{
		String query = "INSERT INTO BOOK VALUES ('"+b.getBookId()+"','"+b.getName()+"','"+b.getWritter()+"',"+b.getPrice()+","+b.getNumberOfcopy()+");";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteBook(String bookId)
	{
		String query = "DELETE from BOOK WHERE `bookId`='"+bookId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateBookInfo(Book b)
	{
		String query = "UPDATE BOOK SET `name`='"+b.getName()+"', `writter` = '"+b.getWritter()+"', `price` = "+b.getPrice()+", `noOfcopy`="+b.getNumberOfcopy()+" WHERE `bookId`='"+b.getBookId()+"'";
		System.out.println(query);
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Book searchBook(String bookId)
	{
		Book b = null;
		String query = "SELECT `name`, `writter`,`price`, `noOfcopy` FROM `BOOK` WHERE `bookId`='"+bookId+"';";     
		System.out.println(query);
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
			    String name = dbc.result.getString("name");
				String writter = dbc.result.getString("writter");
				double price = dbc.result.getDouble("price");
				int numberOfcopy = dbc.result.getInt("noOfcopy");
				
				b = new Book();
				b.setBookId(bookId);
				b.setName(name);
				b.setWritter(writter);
				b.setPrice(price);
				b.setNumberOfcopy(numberOfcopy);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return b;
	}
	public String[][] getAllBook()
	{
		ArrayList<Book> ar = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String bookId = dbc.result.getString("bookId");
				String name = dbc.result.getString("name");
				String writter = dbc.result.getString("writter");
				double price = dbc.result.getDouble("price");
				int numberOfcopy = dbc.result.getInt("noOfcopy");
				Book b = new Book(bookId,name,writter,price,numberOfcopy);
				ar.add(b);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Book)obj[i]).getBookId();
			data[i][1] = ((Book)obj[i]).getName();
			data[i][2] = ((Book)obj[i]).getWritter();
			data[i][3] = (((Book)obj[i]).getPrice())+"";
			data[i][4] = (((Book)obj[i]).getNumberOfcopy())+"";
		}
		return data;
	}
}