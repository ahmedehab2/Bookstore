package com.me.bookstore.service;

import com.me.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public List<Book> getAvailableBooks();


    public Book getBookById(int id);
    public void deleteBookById(int id);


}
