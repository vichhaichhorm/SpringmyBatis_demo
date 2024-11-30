package com.vichhaicoder.demo_mybatis.service.serviceImp;


import com.vichhaicoder.demo_mybatis.dto.request.BookRequest;
import com.vichhaicoder.demo_mybatis.dto.response.AuthorResponse;
import com.vichhaicoder.demo_mybatis.dto.response.BookResponse;
import com.vichhaicoder.demo_mybatis.modal.Author;
import com.vichhaicoder.demo_mybatis.modal.Book;
import com.vichhaicoder.demo_mybatis.repository.BookRepository;
import com.vichhaicoder.demo_mybatis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.getBookList();
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public BookResponse insertBook(BookRequest request) {
        // Create a new Book object
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPublishedDate(request.getPublishedDate());
        book.setAuthors(new Author(request.getAuthorId(), null, null)); // Only set the authorId

        // Insert the book into the database
        bookRepository.insertBook(book);

        // Fetch the full details of the inserted book (with author details)
        Book insertedBook = bookRepository.getBookById(book.getBookId());

        // Construct the BookResponse
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setAuthorId(insertedBook.getAuthors().getAuthorId());
        authorResponse.setName(insertedBook.getAuthors().getName());
        authorResponse.setGender(insertedBook.getAuthors().getGender());

        BookResponse response = new BookResponse();
        response.setBookId(insertedBook.getBookId());
        response.setTitle(insertedBook.getTitle());
        response.setPublishedDate(insertedBook.getPublishedDate());
        response.setAuthors(authorResponse);

        return response;
    }

    @Override
    public BookResponse updateBook(Integer bookId, BookRequest request) {
        // Fetch the existing book by ID
        Book existingBook = bookRepository.getBookById(bookId);
        if (existingBook == null) {
            throw new RuntimeException("Book with ID " + bookId + " not found.");
        }

        // Update the fields with the new values from the request
        existingBook.setTitle(request.getTitle());
        existingBook.setPublishedDate(request.getPublishedDate());
        existingBook.setAuthors(new Author(request.getAuthorId(), null, null)); // Only update the authorId

        // Perform the update in the database
        bookRepository.updateBookById(existingBook);

        // Fetch the updated book to construct the response
        Book updatedBook = bookRepository.getBookById(bookId);

        // Build the response object
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setAuthorId(updatedBook.getAuthors().getAuthorId());
        authorResponse.setName(updatedBook.getAuthors().getName());
        authorResponse.setGender(updatedBook.getAuthors().getGender());

        BookResponse response = new BookResponse();
        response.setBookId(updatedBook.getBookId());
        response.setTitle(updatedBook.getTitle());
        response.setPublishedDate(updatedBook.getPublishedDate());
        response.setAuthors(authorResponse);

        return response;
    }

    @Override
    public String deleteBook(Integer bookId) {
        Book book = bookRepository.getBookById(bookId);
        if (Objects.isNull(book)){
            return "Book id is not found"+bookId;
        }
        return bookRepository.deleteBook(bookId);
    }


}
