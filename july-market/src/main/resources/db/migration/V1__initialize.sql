drop table if exists products cascade;
drop table if exists categories cascade;
create table categories (id bigserial, title varchar(255), primary key(id));

create table products (id bigserial, title varchar(255), category bigserial, description varchar(5000), price int, primary key(id),FOREIGN KEY (category)  REFERENCES categories(id));


insert into categories (title) values ('food'), ('other');

insert into products
(title, category, description, price) values
('Cheese',1, 'Fresh cheese', 320),
('Milk',1, 'Fresh milk', 80),
('Apples',1, 'Fresh apples', 80),
('Bread',1, 'Fresh bread', 30),
('A1',2, '', 1),
('A2',2, '', 2),
('A3',2, '', 3),
('A4',2, '', 4),
('A5',2, '', 5),
('A6',2, '', 6),
('A7',2, '', 7),
('A8',2, '', 8),
('A9',2, '', 9),
('A10',2, '', 10),
('A11',2, '', 11),
('A12',2, '', 12),
('A13',2, '', 13),
('A14',2, '', 14),
('A15',2, '', 15),
('A16',2, '', 16),
('A17',2, '', 17),
('A18',2, '', 18),
('A19',2, '', 19),
('A20',2, '', 20);