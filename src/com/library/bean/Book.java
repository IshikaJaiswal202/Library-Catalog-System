package com.library.bean;

public class Book
{

	// data member
	private String bookId;
	private String bookTitle;
	private String authorName;
	// zero argument constructor
	public Book() {
		super();
	}


	// all argument constructor
	public Book(String bookId, String bookTitle, String authorName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
	}


	//getter and setter method
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	//toString method
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", authorName=" + authorName +"]";
	}


}
