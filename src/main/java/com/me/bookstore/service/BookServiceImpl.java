package com.me.bookstore.service;

import com.me.bookstore.entity.Book;
import com.me.bookstore.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }
    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findAll();
    }



    @Override
    public Book getBookById(int id) {
       return bookRepository.findById(id).get();
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);

    }

}
