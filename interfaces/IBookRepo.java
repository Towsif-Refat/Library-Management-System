package interfaces;

import java.lang.*;
import entity.*;

public interface IBookRepo
{
	public void addBook(Book b);
	public void deleteBook(String BookId);
	public void updateBookInfo(Book BookId);
	public Book searchBook(String BookId);
	public String[][] getAllBook();

}
