drop table Books;

create table Books (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title VARCHAR(128),
    author VARCHAR(128),
    isbn VARCHAR(16),
    review VARCHAR(1024),
    date DATE NOT NULL WITH DEFAULT CURRENT DATE
);

insert into Books(title, author, isbn, review) 
    values('The Hobbit', 'J.R.R. Tolkien', '978-0618968633', 'What can you say about a classic? Great book. Everyone should read it.');