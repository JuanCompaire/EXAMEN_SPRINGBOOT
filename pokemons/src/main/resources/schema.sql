CREATE TABLE IF NOT EXISTS REGION(
   id bigint auto_increment PRIMARY KEY,
   nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS POKEMON(
   id bigint auto_increment PRIMARY KEY,
   nombre varchar(50),
   region INT,
   FOREIGN KEY (region) REFERENCES REGION(id)
);
