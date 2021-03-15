package entity;

import java.lang.*;

public class Book
{
	private String bookId;
	private String name;
	private String writter;
	private double price;
	private int numberOfcopy;

	public Book(){}
    public Book(String bookId,String name,String writter,double price,int numberOfcopy)
	{
		this.bookId=bookId;
		this.name=name;
		this.writter=writter;
		this.price=price;
		this.numberOfcopy=numberOfcopy;
	}

    public void setBookId(String bookId){this.bookId=bookId;}
	public void setName(String name){this.name=name;}
	public void setWritter(String writter){this.writter=writter;}
	public void setPrice(double price){this.price=price;}
	public void setNumberOfcopy(int numberOfcopy){this.numberOfcopy=numberOfcopy;}

    
    public String getBookId(){return bookId;}
	public String getName(){return name;}
	public String getWritter(){return writter;}
	public double getPrice(){return price;}
	public int getNumberOfcopy(){return numberOfcopy;}
}