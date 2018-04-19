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
    values('The Hobbit', 'J.R.R. Tolkien', '978-0618968633', 'What can you say about a classic? Great book. Everyone should read it. Dragons, elves, magic & more...');
insert into Books(title, author, isbn, review) 
    values('The Black Echo', 'Michael Connelly', '978-0316153614', 'LAPD Detective Harry Bosch likes order, contends that there are no coincidences, and keeps meticulous records in his murder book. A real page turner with gutty realism and an unusual twist.');
insert into Books(title, author, isbn, review) 
    values('Shane', 'Jack Schaefer', '978-0544239470', 'Roland Smith said: If you read only one western in your life, this is the one. I can''t say it better.');