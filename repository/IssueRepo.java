package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class IssueRepo implements IIssueRepo
{
	DatabaseConnection dbc;
	
	public IssueRepo()
	{
		System.out.println("IssueRepo_Constructor");
		dbc = new DatabaseConnection();
	}
	
	public void issue(Issue i)
	{
		String query = "INSERT INTO ISSUE VALUES ('"+i.getIssueId()+"','"+i.getBookId()+"','"+i.getUserId()+"','"+i.getIssueDate()+"','"+i.getReturnDate()+");";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public String[][] getAllIssue()
	{
		ArrayList<Issue> ar = new ArrayList<Issue>();
		String query = "SELECT * FROM ISSUE;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String issueId = dbc.result.getString("issueId");
				String bookId = dbc.result.getString("bookId");
				String userId = dbc.result.getString("userId");
				String issueDate= dbc.result.getString("issueDate");
				String returnDate= dbc.result.getString("returnDate");
				
				Issue i = new Issue(issueId,bookId,userId,issueDate,returnDate);
				ar.add(i);
			}
		}
			catch(Exception e){System.out.println(e.getMessage());}
			dbc.closeConnection();
		
			
			Object obj[] = ar.toArray();
			String data[][] = new String [ar.size()][5];
		
			for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Issue)obj[i]).getIssueId();
			data[i][1] = ((Issue)obj[i]).getBookId();
			data[i][2] = ((Issue)obj[i]).getUserId();
			data[i][3] = ((Issue)obj[i]).getIssueDate();
			data[i][4] = ((Issue)obj[i]).getReturnDate();
		}
		return data;
	}
	

}