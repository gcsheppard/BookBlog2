DROP TABLE Books;

CREATE TABLE Books (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    title VARCHAR(128),
    author VARCHAR(128),
    genre VARCHAR(32),
    isbn VARCHAR(16),
    rating INTEGER,
    reviewer VARCHAR(32),
    review VARCHAR(1024),
    date DATE NOT NULL WITH DEFAULT CURRENT DATE
);

INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', '978-0618968633', 5, 'anna', 'What can you say about a classic? Great book. Everyone should read it. Dragons, elves, magic & more...');
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('The Black Echo', 'Michael Connelly', 'Mystery', '978-0316153614', 5, 'kinsey', 'LAPD Detective Harry Bosch likes order, contends that there are no coincidences, and keeps meticulous records in his murder book. A real page turner with gutty realism and an unusual twist.');
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('Shane', 'Jack Schaefer', 'Western', '978-0544239470', 5, 'arthur', 'Roland Smith said: If you read only one western in your life, this is the one. I can''t say it better.');

DROP TABLE Users;

CREATE TABLE Users (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(32) UNIQUE,
    password VARCHAR(512),
    userrole VARCHAR(32)
);