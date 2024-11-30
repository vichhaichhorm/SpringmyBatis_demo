package com.vichhaicoder.demo_mybatis.controller;


import com.vichhaicoder.demo_mybatis.dto.request.BookRequest;
import com.vichhaicoder.demo_mybatis.dto.response.BookResponse;
import com.vichhaicoder.demo_mybatis.modal.Book;
import com.vichhaicoder.demo_mybatis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    @GetMapping("/getBy/{book_id}")
    public Book getBookById(@PathVariable Integer book_id){
        return bookService.getBookById(book_id);
    }

    @PostMapping("/insert")
    public BookResponse insertBook(@RequestBody BookRequest request){
        return bookService.insertBook(request);
    }

    @PutMapping("/updateBy/{book_id}")
    public BookResponse updateBook(@PathVariable Integer book_id,@RequestBody BookRequest request){
        return bookService.updateBook(book_id,request);
    }

    @DeleteMapping("/deleteBy/{book_id}")
    public String deleteBook(@PathVariable Integer book_id){
        return bookService.deleteBook(book_id);
    }


}
