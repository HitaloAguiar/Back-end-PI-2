-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- password encripted is password
INSERT INTO users (`name`, cpf, email, `password`, `role`, phoneNumber) VALUES ('John Dev', '123.456.789-10', 'john_dev@hotmail.com', 'M4JbgkV7ojGWbcX0Z7Eqz2OU/3nKfMQ5jjhn0b4x2H5LXDa1/nuYto96t0JoMnHmG/tt9WyIrv7hXwYmx7aIAg==', '2', '(63) 99867-5467');
INSERT INTO users (`name`, cpf, email, `password`, `role`, phoneNumber) VALUES ('Julia Fernandes', '109.876.543-21', 'juh9876@gmail.com', 'M4JbgkV7ojGWbcX0Z7Eqz2OU/3nKfMQ5jjhn0b4x2H5LXDa1/nuYto96t0JoMnHmG/tt9WyIrv7hXwYmx7aIAg==', '1', '(63) 98756-0125');
INSERT INTO users (`name`, cpf, email, `password`, `role`, phoneNumber) VALUES ('Tom Reis', '777.777.777-77', 'tom_reis@hotmail.com', 'M4JbgkV7ojGWbcX0Z7Eqz2OU/3nKfMQ5jjhn0b4x2H5LXDa1/nuYto96t0JoMnHmG/tt9WyIrv7hXwYmx7aIAg==', '0', '(63) 94567-1020');