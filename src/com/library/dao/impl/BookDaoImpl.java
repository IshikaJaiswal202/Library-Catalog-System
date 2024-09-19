package com.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.library.bean.Book;
import com.library.dao.IBookDao;
import com.library.util.DbConnection;

public class BookDaoImpl implements IBookDao 
{
	private PreparedStatement ps;
	private ResultSet rs;
    private String  DB_QUERY;
    private Connection con;
    public BookDaoImpl() {
    	super();
    	con=DbConnection.getConnection();

	}
	@Override
	public Integer addBook(List<Book> book) {
		DB_QUERY="Insert into BOOKS values(?,?,?)";
	    int count[] = null;
	    try 
	    {
		    ps=con.prepareStatement(DB_QUERY);
	     for(Book b:book)
	    {
	    ps.setString(1, UUID.randomUUID().toString());
		ps.setString(2, b.getBookTitle());
		ps.setString(3, b.getAuthorName());
		ps.addBatch();
	    }
		  count=ps.executeBatch();
		  if(count!=null)
		  {
			  return 1;
		  }

	   }
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return 0;

	}

	@Override
	public void listofAllBook() {
		DB_QUERY="Select * from Books";
		int f=0;
		try
		{
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				f=1;
				System.out.print(rs.getString("bookId")+"        ");
				System.out.print(rs.getString("bookTitle")+"     ");
				System.out.println(rs.getString("authorName")+"                ");
				System.out.println("-------------------------------------------------------------------");
			}
			if(f==0)
			{
				System.out.println("No Book is Available");
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void findByAuthorName(String name) {
		DB_QUERY="Select * from Books where AuthorName=?";
		try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.print(rs.getString("bookId")+"         ");
				System.out.print(rs.getString("bookTitle")+"         ");
				System.out.println(rs.getString("authorName")+"      ");
				System.out.println("------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}

	@Override
	public void findByBookTitle(String name) {
		System.out.println(name);
		DB_QUERY="Select * from Books where BookTitle=?";
		try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.print(rs.getString("bookId")+"         ");
				System.out.print(rs.getString("bookTitle")+"         ");
				System.out.println(rs.getString("authorName")+"      ");
				System.out.println("--------------------------------------------------------");
			}
			else
			{
				System.out.println("not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public boolean isbookIsExists(String name) {
		DB_QUERY="Select * from Books where BookTitle=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next())
			 return true;
		  } 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	
	}

}
