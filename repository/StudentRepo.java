
package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class StudentRepo implements IStudentRepo
{
	DatabaseConnection dbc;
	
	public StudentRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Student s)
	{
		String query = "INSERT INTO STUDENT VALUES ('"+s.getstudentId()+"','"+s.getstudentName()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String studentId)
	{
		String query = "DELETE from student WHERE studentId='"+studentId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Student s)
	{
		String query = "UPDATE student SET studentName='"+s.getstudentName()+"' WHERE studentId='"+s.getstudentId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Student searchStudent(String studentId)
	{
		Student student = null;
		String query = "SELECT `studentName` FROM `student` WHERE `studentId`='"+studentId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String studentName = dbc.result.getString("studentName");
				//String studentId= dbc.result.getString("studentId");
				
				student = new Student();
				student.setstudentId(studentId);
			//	student.setstudentName(studentName);
			
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return student;
	}
	public String[][] getAllStudent()
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		String query = "SELECT * FROM STUDENT;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String studentId = dbc.result.getString("studentId");
				String studentName = dbc.result.getString("studentName");
				
				Student s = new Student(studentId,studentName);
				ar.add(s);
			}
		}
		catch(Exception s){System.out.println(s.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][2];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Student)obj[i]).getstudentId();
			data[i][1] = ((Student)obj[i]).getstudentName();
		}
		return data;
	}
}