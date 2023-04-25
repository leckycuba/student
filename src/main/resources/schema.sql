create table if not exists STUDENT(
  id BIGINT primary key,
  name VARCHAR(255),
  last_name VARCHAR(255),
  status BOOLEAN,
  age SMALLINT
);

INSERT INTO STUDENT(id, name, last_name, status, age) VALUES
(1, 'Jon','Snow', true,  23),
(2, 'Daenerys','Targaryen', false, 18),
(3, 'Tyrion','Lannister', true,  9);