package com.me.bookstore.controller;

import com.me.bookstore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    private final MyBookService myBookService;

    public MyBookController(MyBookService myBookService) {
        this.myBookService = myBookService;
    }

    @GetMapping("/my-books")
    public String getMyBooks(Model model) {
        model.addAttribute("myBooks", myBookService.getMyBooks());
        return "myBooks";
    }

    @RequestMapping("/delete-my-book/{id}")
    public String deleteFromMyBooks(@PathVariable("id") int id){
        myBookService.deleteBookById(id);
        return "redirect:/my-books";
    }
}
