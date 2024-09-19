package com.library.service.impl;

import java.util.List;

import com.library.bean.Book;
import com.library.dao.IBookDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.service.IBookService;

public class BookServiceImpl implements IBookService{
	private IBookDao bookDao=null;
	public BookServiceImpl() {
		bookDao=new BookDaoImpl();
	}

	@Override
	public Integer addBook(List<Book> book) {
		return bookDao.addBook(book);
	}

	@Override
	public void listofAllBook() {
		bookDao.listofAllBook();
	}

	@Override
	public void findByAuthorName(String name) {
		 bookDao.findByAuthorName(name);
	}

	@Override
	public void findByBookTitle(String bookTitle) {
		 bookDao.findByBookTitle(bookTitle);
	}

	@Override
	public boolean isbookIsExists(String name) {
		bookDao.isbookIsExists(name);
		return false;
	}

}
