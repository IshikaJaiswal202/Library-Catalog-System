package com.library.dao;

import java.util.List;

import com.library.bean.Book;

public interface IBookDao
{
	   public Integer addBook(List<Book> book);
	   public void listofAllBook();
	   public void findByAuthorName(String name);
	   public void findByBookTitle(String title);
	   public boolean isbookIsExists(String name);

}
