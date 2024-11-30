package com.vichhaicoder.demo_mybatis.controller;

import com.vichhaicoder.demo_mybatis.modal.Author;
import com.vichhaicoder.demo_mybatis.service.AuthorService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAllAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author findByAuthorById(@PathVariable Integer authorId){
        return authorService.findByAuthorById(authorId);
    }

    @PutMapping("/update/{authorId}")
    public Author updateAuthorById(@PathVariable Integer authorId ,@RequestBody Author author){
        return authorService.updateAuthorById(authorId,author);
    }

    @DeleteMapping("/delete/by/{authorId}")
    public void deleteAuthorById(@PathVariable Integer authorId){
        authorService.deleteAuthorById(authorId);
    }

    @PostMapping("/create")
    public Author insertAuthor(@RequestBody Author author){
        return authorService.insertAuthor(author);
    }

}
