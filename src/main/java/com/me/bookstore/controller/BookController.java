package com.me.bookstore.controller;

import com.me.bookstore.entity.Book;
import com.me.bookstore.entity.MyBook;
import com.me.bookstore.service.BookService;
import com.me.bookstore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookService bookService;
    private final MyBookService myBookService;


    public BookController(BookService bookService, MyBookService myBookService) {
        this.bookService = bookService;

        this.myBookService = myBookService;
    }

    @GetMapping("/")
    public String home() {
        return "index";

    }

    @GetMapping("/add-book")
    public String addBook() {
        return "addBook";
    }

    @GetMapping("/available-books")
    public String getAvailableBooks(Model model) {
        model.addAttribute("books", bookService.getAvailableBooks());
        return "availableBooks";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/available-books";
    }
    @RequestMapping("/books/{id}")
    public String addToMyBookList(@PathVariable("id") int id){
         Book book = bookService.getBookById(id);
         MyBook myBook = new MyBook(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
         myBookService.addBook(myBook);
         return "redirect:/my-books";
    }
    @RequestMapping("/delete-book/{id}")
    public String deleteFromAvailableBooks(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/available-books";
    }



}

