package entity;

import java.lang.*;

public class Student
{
	private String studentId;
	private String studentName;
	
	public Student(){}
	public Student(String studentId, String studentName)
	{
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public void setstudentId(String studentId){this.studentId = studentId;}
	public void setstudentName(String studentName){this.studentName = studentName;}
	
	public String getstudentId(){return studentId;}
	public String getstudentName(){return studentName;}
}