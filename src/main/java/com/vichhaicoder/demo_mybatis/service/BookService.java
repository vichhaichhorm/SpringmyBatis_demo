package com.vichhaicoder.demo_mybatis.service;

import com.vichhaicoder.demo_mybatis.dto.request.BookRequest;
import com.vichhaicoder.demo_mybatis.dto.response.BookResponse;
import com.vichhaicoder.demo_mybatis.modal.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();

    Book getBookById(Integer bookId);

    BookResponse insertBook(BookRequest request);

    BookResponse updateBook(Integer bookId, BookRequest request);

    String deleteBook(Integer bookId);
}
