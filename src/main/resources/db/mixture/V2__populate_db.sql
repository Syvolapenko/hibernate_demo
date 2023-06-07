INSERT INTO client
(name) 
VALUES
    ('Vasiliy'),
	('Slava'),
	('Viktoria'),
	('Anton'),
	('Max'),
	('Juriy'),
	('Alina'),
	('Vitaly'),
	('Yulia'),
	('Olena');
	
INSERT INTO planet
(id, name)
VALUES
('SAT1','Saturn'),
('VEN2','Venus'),
('MAR3','Mars'),
('NEP4','Neptune'),
('EAR5','Earth');

INSERT INTO ticket
(created_at, client_id, from_planet_id, to_planet_id)
VALUES
('2032-04-15 10:18:35','3','VEN2','EAR5'),
('2047-08-05 14:38:10','8','SAT1','NEP4'),
('2038-02-25 18:50:18','5','MAR3','SAT1'),
('2042-06-02 15:12:50','10','NEP4','EAR5'),
('2050-03-10 12:32:10','2','SAT1','MAR3'),
('2040-05-14 11:28:21','4','EAR5','NEP4'),
('2052-01-22 17:37:05','1','NEP4','VEN2'),
('2044-07-12 13:05:47','7','MAR3','SAT1'),
('2035-09-26 16:42:34','9','VEN2','MAR3'),
('2047-12-08 11:53:23','6','EAR5','VEN2');
	