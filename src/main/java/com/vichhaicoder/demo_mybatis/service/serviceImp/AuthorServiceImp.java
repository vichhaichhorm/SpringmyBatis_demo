package com.vichhaicoder.demo_mybatis.service.serviceImp;

import com.vichhaicoder.demo_mybatis.modal.Author;
import com.vichhaicoder.demo_mybatis.repository.AuthorRepository;
import com.vichhaicoder.demo_mybatis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public Author findByAuthorById(Integer authorId) {
        return authorRepository.findByAuthorById(authorId);
    }

    @Override
    public Author updateAuthorById(Integer authorId, Author author) {
        return authorRepository.updateAuthorById(authorId,author);
    }

    @Override
    public void deleteAuthorById(Integer authorId) {
        authorRepository.deleteAuthorById(authorId);
    }

    @Override
    public Author insertAuthor(Author author) {
        return authorRepository.insertAuthor(author);
    }
}
