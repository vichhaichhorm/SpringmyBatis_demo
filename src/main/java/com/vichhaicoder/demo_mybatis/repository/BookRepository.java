package com.vichhaicoder.demo_mybatis.repository;

import com.vichhaicoder.demo_mybatis.dto.request.BookRequest;
import com.vichhaicoder.demo_mybatis.modal.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BookRepository {

    @Select("""
        SELECT
            b.book_id,
            b.title,
            b.published_date,
            a.author_id,
            a.name AS author_name,
            a.gender AS author_gender,
            c.categories_id,
            c.name AS category_name
        FROM
            book b
                JOIN author a ON b.author_id = a.author_id
                LEFT JOIN book_categories cb ON b.book_id = cb.book_Id
                LEFT JOIN categories c ON cb.categories_id = c.categories_id;
    """)
    @Results(id = "bookMapper", value = {
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "publishedDate", column = "published_date"),
            @Result(property = "authors.authorId", column = "author_id"), // Map authorId to Author object
            @Result(property = "authors.name", column = "author_name"),   // Map author name
            @Result(property = "authors.gender", column = "author_gender")// Map author gender
    })

    List<Book> getBookList();

    @Select("""
        SELECT  b.book_id, 
                b.title, 
                b.published_date, 
                a.author_id, 
                a.name AS author_name, 
                a.gender AS author_gender
    FROM 
        book b
    JOIN 
        author a ON b.author_id = a.author_id
    WHERE 
        b.book_id = #{bookId};
""")
    @ResultMap("bookMapper")
    Book getBookById(Integer bookId);

    @Insert("""
    INSERT INTO book (title, published_date, author_id)
    VALUES (#{title}, #{publishedDate}, #{authors.authorId})
""")
    @Options(useGeneratedKeys = true, keyProperty = "bookId") // Ensure bookId is auto-generated
    @ResultMap("bookMapper")
    void insertBook(Book book);

    @Update("""
    UPDATE book
    SET title = #{title},
        published_date = #{publishedDate},
        author_id = #{authors.authorId}
    WHERE book_id = #{bookId}
""")
    @ResultMap("bookMapper")
    void updateBookById(Book existingBook);

    @Select("""
    DELETE FROM book
    WHERE book_id = #{bookId}
    """)
    String deleteBook(Integer bookId);
}
