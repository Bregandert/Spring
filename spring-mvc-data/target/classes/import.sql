DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigint, name VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (id, name, price) VALUES (1,'Model1', 10), (2,'Model2', 20), (3,'Model3', 20), (4,'Model4', 30), (5,'Model5', 30), (6,'Model6', 30), (7,'Model7', 40), (8,'Model8', 50), (9,'Model9', 60), (10,'Model10', 60), (11,'Model11', 40), (12,'Model12', 70), (13,'Model13', 80), (14,'Model14', 40), (15,'Model15', 50);