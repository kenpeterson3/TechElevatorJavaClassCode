BEGIN TRANSACTION;

CREATE TABLE departments (
        id serial,
        name varchar(255) NOT NULL UNIQUE,
        CONSTRAINT pk_departments_id PRIMARY KEY (id)   
 );

CREATE TABLE job_titles (
        id serial,
        title varchar(255) NOT NULL UNIQUE,
        CONSTRAINT pk_job_titles_id PRIMARY KEY (id)       
);
 
CREATE TABLE employees (
        id serial,
        first_name varchar(255) NOT NULL,
        last_name varchar(255) NOT NULL,
        gender char(1),
        birthday date,
        hireday date NOT NULL,
        departments_id integer NOT NULL,
        job_titles_id integer NOT NULL,
        CONSTRAINT pk_employees_id PRIMARY KEY (id),
        CONSTRAINT fk_job_titles_id FOREIGN KEY (job_titles_id) REFERENCES job_titles(id)
);

CREATE TABLE projects (
        id serial,
        name varchar(255) NOT NULL UNIQUE,
        employees_id integer NOT NULL,
        startdate date NOT NULL,
        CONSTRAINT pk_projects_id PRIMARY KEY (id),
        CONSTRAINT fk_employees_id FOREIGN KEY (employees_id) REFERENCES employees(id)
);


 INSERT INTO department (name) VALUES ('department name goes here')
 
 ROLLBACK;
 
 COMMIT;