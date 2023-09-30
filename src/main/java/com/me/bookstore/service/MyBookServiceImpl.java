package com.me.bookstore.service;

import com.me.bookstore.entity.MyBook;
import com.me.bookstore.repo.MyBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookServiceImpl implements MyBookService {
     private MyBookRepository myBookRepository;

    public MyBookServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public void addBook(MyBook myBook) {
        myBookRepository.save(myBook);
    }

    @Override
    public List<MyBook> getMyBooks() {
       return myBookRepository.findAll();
    }

    @Override
    public void deleteBookById(int id) {
        myBookRepository.deleteById(id);
    }


}
