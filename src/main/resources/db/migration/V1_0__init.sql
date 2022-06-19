CREATE TABLE students (
    id VARCHAR PRIMARY KEY,
    last_name VARCHAR NOT NULL,
    first_name VARCHAR NOT NULL,
    patronymic VARCHAR,
    birth_date VARCHAR NOT NULL,
    group_number VARCHAR NOT NULL,
    student_number VARCHAR NOT NULL UNIQUE
);