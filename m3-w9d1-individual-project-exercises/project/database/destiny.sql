DROP TABLE IF EXISTS members;

create table members (
	id serial,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	wins INT,
	losses INT
	
	
);

insert into members (first_name, last_name, wins, losses) values ('Luke', 'Skywalker', 1, 0);
insert into members (first_name, last_name, wins, losses) values ('Darth', 'Vader', 0, 1);

