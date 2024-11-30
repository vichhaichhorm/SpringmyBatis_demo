package com.vichhaicoder.demo_mybatis.service;

import com.vichhaicoder.demo_mybatis.modal.Author;

import java.util.List;

public interface AuthorService {
    public List<Author> findAllAuthors();

    Author findByAuthorById(Integer authorId);

    Author updateAuthorById(Integer authorId, Author author);

    void deleteAuthorById(Integer authorId);

    Author insertAuthor(Author author);
}
