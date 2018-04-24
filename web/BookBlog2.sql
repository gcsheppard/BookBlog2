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
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('Off Armageddon Reef', 'David Weber', 'Science Fiction', '978-0765315007', 4, 'arthur', 'In the far future, the last remnant of humanity hides from the attacking Gbaba. A bit slow-moving, but a promising start to a series.' );
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('Undercurrents', 'Ridley Pearson', 'Mystery', '978-0312018412', 3, 'kinsey', 'Seattle detective Lou Boldt hunts a serial killer. The procedural stuff was good, but Lou is too angst-ridden to be likeable.' );
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('In Death Ground', 'David Weber & Steve White', 'Science Fiction', '978-0671877798', 5, 'anna', 'Wow--great space opera. A fantastic continuation of the Starfire Universe, this novel covers the first part of the battle with a new race--the Bugs. The Bugs don''t negotiate, don''t interact, all they want to do is eat--and their favorite food is of course those very races. Great space battles!' );
INSERT INTO Books(title, author, genre, isbn, rating, reviewer, review) 
    VALUES('Mr. Lincoln''s Army ', 'Bruce Catton', 'History', '978-1376191462', 5, 'anna', 'First of three volumes on the American Civil War. Catton brings the characters, from the President to the soldiers in the field, to life. A great read.' );

DROP TABLE Users;

CREATE TABLE Users (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(32) UNIQUE,
    password VARCHAR(512),
    userrole VARCHAR(32),
    show VARCHAR(16)
);
