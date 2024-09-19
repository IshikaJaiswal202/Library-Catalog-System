package com.library.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.library.Test;
import com.library.bean.Book;
import com.library.service.IBookService;
import com.library.service.impl.BookServiceImpl;

public class BookController
{ 
	private Scanner sc=null;
	private IBookService bookService=null;
	public BookController() 
	{
		sc=new Scanner(System.in);
		bookService=new BookServiceImpl();

	}
	public void bookMenu(int i)
	{
		while(true)
		{
			System.out.println("---------------------------------");
			System.out.println("|    Welcome To Book Section    |");
			System.out.println("|                               |");
			System.out.println("| 1. Save Book                  |");
			System.out.println("| 2. Search Book By BookTitle   |");
			System.out.println("| 3. Search Book By AuthorName  |");
			System.out.println("| 4. List Of Book               |");
			System.out.println("| 5. Go Back                    |");
			System.out.println("| 6. Logout                     |");
			System.out.println("---------------------------------");
			System.out.println("Please Enter Your Choice: ");
			int value=0;
			try 
			{
				if(i!=0)
					sc.nextLine();
				value=sc.nextInt();
			}
			catch (Exception e) {
				System.err.println("It Should Be in Numbers");
				bookMenu(1);
				return;
			}
			if(value==9)
			{
				break;
			}
			switch (value) {
			case 1:
				addBooks();
				break;
			case 2:
				sc.nextLine();
				System.out.println("Enter BookTitle");
				String bookTitle=sc.nextLine();
				bookService.findByBookTitle(bookTitle);
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter AuthorName");
				String authorName=sc.nextLine();
				bookService.findByAuthorName(authorName);
				break;
			case 4:
				sc.nextLine();
				bookService.listofAllBook();
				break;
			case 5:
				Test.main(null);
				break;
			case 6:
				System.err.println("You have Loged out");
				System.exit(0);
				break;
			default:
				System.err.println("Choice Should Be From given Choice");
				break;
			}		
		}
	}

// Adding the book 
	public Integer addBooks()
	{
		sc.nextLine();
		System.out.println("Enter Book Name  : ");
		String name=sc.nextLine();
		name=checkBookIsExists(name);
		System.out.println("Enter Author Name :");
		// because Of Unique Book Name
		String author=sc.nextLine();
		List<Book> books=Arrays.asList(new Book(null,name,author));
		return bookService.addBook(books);


	}
	// checking that book already present or not if present then you have to return because name is unique
	public String checkBookIsExists(String book_Name)
	{
		boolean is=bookService.isbookIsExists(book_Name);
		if(is)
		{
			System.out.println("Re-Enter Book Name" +"\n"+ "(Because With the Same Book Already Exixts )");
			String bookName=sc.nextLine();
			return checkBookIsExists(bookName);
		}
		return book_Name;
	}
}