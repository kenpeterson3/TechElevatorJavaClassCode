DROP TABLE IF EXISTS reviews;
DROP SEQUENCE IF EXISTS seq_review_id;

CREATE SEQUENCE seq_review_id;

CREATE TABLE reviews
(
	review_id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_review_id'),
	username VARCHAR(100) NOT NULL,
	rating INTEGER NOT NULL,
	review_title VARCHAR(200) NOT NULL,
	review_text VARCHAR(1000) NOT NULL,
	review_date TIMESTAMP DEFAULT NOW()
);

INSERT INTO REVIEWS(username, rating, review_title, review_text) VALUES ('dwintrich', 5, 'Changed my life', 'Before reading this book, my squirrel parties were always lackluster (I never had enough cigars!).  Thanks to Craig''s insightful advice, my squirrel parties are now at the top of everyone''s social calendar!');
INSERT INTO REVIEWS(username, rating, review_title, review_text) VALUES ('jtucholski', 4, 'No party complete without it', 'There''s no way to hold a succesful party without first looking at this book!');
INSERT INTO REVIEWS(username, rating, review_title, review_text) VALUES ('ccastelaz', 2, 'Slow read', 'I fell asleep a few times because it was a slow read');
INSERT INTO REVIEWS(username, rating, review_title, review_text) VALUES ('cborders', 5, 'I knew nothing about squirrel parties', 'After reading this, I am not the master on squirrel parties!');
INSERT INTO REVIEWS(username, rating, review_title, review_text) VALUES ('jerickson', 4, 'Tried this with some taxidermied squirrels', 'I was the life of the party!');