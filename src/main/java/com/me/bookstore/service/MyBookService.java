package com.me.bookstore.service;

import com.me.bookstore.entity.MyBook;

import java.util.List;

public interface MyBookService {
        public void addBook(MyBook myBook);
        public List<MyBook> getMyBooks();
        public void deleteBookById(int id);


}
