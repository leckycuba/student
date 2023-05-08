create table if not exists STUDENT(
  id BIGINT primary key,
  name VARCHAR(255),
  last_name VARCHAR(255),
  status BOOLEAN,
  age SMALLINT
);

INSERT INTO STUDENT
(id,       name,   last_name, status, age) VALUES
( 1,      'Jon',      'Snow',   true,  23),
( 2, 'Daenerys', 'Targaryen',   true,  18),
( 3,   'Tyrion', 'Lannister',   true,  30),
( 4,    'Sansa',     'Stark',   true,  26),
( 5,   'Cersei', 'Lannister',   true,  25),
( 6,  'Joffrey', 'Baratheon',  false,  20),
( 7,     'Bran',     'Stark',  false,  28),
( 8,    'Jaime', 'Lannister',  false,  31),
( 9,  'Catelyn',     'Stark',   true,  22),
(10,    'Tywin', 'Lannister',  false,  27),
(11,     'Arya',     'Stark',  false,  29),
(12,    'Aemon', 'Targaryen',  false,  24),
(13,    'Petyr',   'Baelish',   true,  19),
(14,    'Theon',   'Greyjoy',  false,  21);
