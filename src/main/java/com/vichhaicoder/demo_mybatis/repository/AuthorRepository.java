package com.vichhaicoder.demo_mybatis.repository;

import com.vichhaicoder.demo_mybatis.modal.Author;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {
    @Select("SELECT *FROM author")
    @Results(id = "authorMapper",value = {
            @Result(property = "authorId",column = "author_id"),
//            @Result(property = "name",column = "author_name")

    })
    List<Author> findAllAuthors();

    @Select("SELECT *FROM author WHERE author_id= #{authorId}")
    @ResultMap(value = "authorMapper")
    Author findByAuthorById(Integer authorId);


    @Select("""
        UPDATE author SET name=#{author.name}, gender=#{author.gender} WHERE author_id=#{authorId}
    """)
    Author updateAuthorById(@Param("authorId") Integer authorId,@Param("author") Author author);

    @Select("""
        DELETE FROM author where author_Id = #{authorId}
    """)
    void deleteAuthorById(Integer authorId);

    @Select("""
        INSERT INTO author (name, gender)
        VALUES ( #{author.name}, #{author.gender})
    """)
    Author insertAuthor(@Param("author") Author author);
}
