package com.library.service;

import java.util.List;

import com.library.bean.Book;

public interface IBookService
{
   public Integer addBook(List<Book> books);
   public void listofAllBook();
   public void findByAuthorName(String name);
   public void findByBookTitle(String bookTitle);
   public boolean isbookIsExists(String name);
}
