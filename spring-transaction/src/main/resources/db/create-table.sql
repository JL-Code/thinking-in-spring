CREATE TABLE IF NOT EXISTS tutorials_tbl (
    id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(20) NOT NULL,
    submission_date DATE
);

CREATE TABLE  IF NOT EXISTS def_person
(
    id       INT NOT NULL,
    username VARCHAR(20) NULL,
    age      INT NULL,
    sex      INT NULL
);