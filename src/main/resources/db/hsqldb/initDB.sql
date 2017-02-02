DROP TABLE phonenumbers IF EXISTS;
DROP TABLE customers IF EXISTS;

CREATE TABLE customers (
  id INTEGER IDENTITY PRIMARY KEY,
  phonenumber_id INTEGER,
  name VARCHAR(30),
);

CREATE TABLE phonenumbers (
  id         INTEGER IDENTITY PRIMARY KEY,
  number VARCHAR(30),
  description VARCHAR(255),
  type VARCHAR(30)
);
