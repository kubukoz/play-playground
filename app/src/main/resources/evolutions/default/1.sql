# --- !Ups
CREATE TABLE books (
  id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO books (name) VALUES ('Test book 1'), ('Test book 2');

# --- !Downs
DROP TABLE books;
