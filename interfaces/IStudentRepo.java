package interfaces;

import java.lang.*;

import entity.*;

public interface IStudentRepo
{
	public void insertInDB(Student s);
	public void deleteFromDB(String studentId);
	public void updateInDB(Student s);
	public Student searchStudent(String studentId);
	public String[][] getAllStudent();
}