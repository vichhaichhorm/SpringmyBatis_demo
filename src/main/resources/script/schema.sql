create database mybatis_demo;

create table author(
                       author_id SERIAL PRIMARY KEY ,
                       name VARCHAR(50),
                       gender VARCHAR(6)
);
drop table author;

CREATE TABLE book (
                      book_id SERIAL PRIMARY KEY,
                      title VARCHAR(80),
                      published_date timestamp,
                      author_id INT,
                      CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(author_id) ON DELETE CASCADE
);
drop table book;

INSERT INTO book (title, published_date, author_id) VALUES ('Book One', '2024-01-15', 1);
INSERT INTO book (title, published_date, author_id) VALUES ('Book Two', '2023-12-10', 2);


SELECT
    b.book_id,
    b.title,
    b.published_date,
    a.name AS author_name,
    a.gender AS author_gender
FROM
    book b
        JOIN
    author a ON b.author_id = a.author_id;


SELECT
    b.book_id,
    b.title,
    b.published_date,
    a.author_id,
    a.name AS author_name,
    a.gender AS author_gender
FROM
    book b
        JOIN
    author a ON b.author_id = a.author_id;
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



-- CONSTRAINT fk_author:
-- Names the foreign key constraint as fk_author.
-- Naming constraints is optional, but doing so helps in identifying and managing the constraint later (e.g., for debugging or dropping it).

-- FOREIGN KEY (author_id):
-- Specifies that the author_id column in the book table is a foreign key.
-- A foreign key is a column (or set of columns) in one table that refers to the primary key in another table.

-- REFERENCES author(author_id):
-- Establishes a relationship between the author_id column in the book table and the author_id column in the author table.
-- The foreign key author_id in the book table must match a valid author_id in the author table.

-- ON DELETE CASCADE:
-- Defines the action to take when a referenced record in the author table is deleted.
-- CASCADE means that if a row in the author table is deleted, all rows in the book table that reference that author_id will also be deleted automatically.
-- Ensures referential integrity by preventing orphan records in the book table.

drop table categories;

create table categories(
    categories_Id serial PRIMARY KEY ,
    name varchar(290)
);
INSERT INTO categories (name)
VALUES
    ('Fiction'),
    ('Non-Fiction'),
    ('Science Fiction'),
    ('Biography');




drop table book_categories;
create table book_categories(
    book_Id INT NOT NULL ,
    categories_id INT NOT NULL ,
    PRIMARY KEY (book_Id,categories_id),
    CONSTRAINT book_fk FOREIGN KEY (book_Id) REFERENCES book (book_Id) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT categories_fk FOREIGN KEY (categories_id) REFERENCES categories (categories_id) ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT
    bc.book_Id,
    bc.categories_id,
    b.title AS book_title,
    c.name AS category_name
FROM
    book_categories bc
        JOIN
    book b ON bc.book_Id = b.book_Id
        JOIN
    categories c ON bc.categories_id = c.categories_Id;
