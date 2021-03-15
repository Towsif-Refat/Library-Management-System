package entity;

import java.lang.*;

public class Issue
{
	private String issueId;
	private String bookId;
	private String userId;
	private String issueDate;
	private String returnDate;
	

	public Issue(){}
    public Issue(String issueId,String bookId,String userID,String issueDate,String returnDate)
	{
		this.issueId=issueId;
		this.bookId=bookId;
		this.userId=userId;
		this.issueDate=issueDate;
		this.returnDate=returnDate;
		
	}

	public void setIssueId(String issueId){this.issueId=issueId;}
	public void setBookId(String bookId){this.bookId=bookId;}
	public void setUserId(String userId){this.userId=userId;}
	public void setIssueDate(String issueDate){this.issueDate=issueDate;}
	public void setReturnDate(String returnDate){this.returnDate=returnDate;}
	


	public String getIssueId(){return issueId;}
	public String getBookId(){return bookId;}
	public String getUserId(){return userId;}
	public String getIssueDate(){return issueDate;}
	public String getReturnDate(){return returnDate;}

}