package com.me.bookstore.service;

import com.me.bookstore.entity.Book;

import java.util.List;

 public interface BookService {
    void save(Book book);
     List<Book> getAvailableBooks();


     Book getBookById(int id);
     void deleteBookById(int id);



}
