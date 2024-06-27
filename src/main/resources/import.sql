-- This file allow to write SQL commands that will be emitted in test and dev.
INSERT INTO Beverage(id,name,flavour) VALUES (1,'Negroni','Happiness');
INSERT INTO Beverage(id,name,flavour) VALUES (2,'Mojito','Mint');
INSERT INTO Beverage(id,name,flavour) VALUES (3,'Moskow mule','Ginger');
ALTER SEQUENCE beverage_seq RESTART WITH 4;
INSERT INTO Fruit(id,name,season) VALUES (1,'Mango','Spring');
INSERT INTO Fruit(id,name,season) VALUES (2,'Strawberry','Spring');
INSERT INTO Fruit(id,name,season) VALUES (3,'Orange','Winter');
INSERT INTO Fruit(id,name,season) VALUES (4,'Lemon','Winter');
INSERT INTO Fruit(id,name,season) VALUES (5,'Blueberry','Summer');
INSERT INTO Fruit(id,name,season) VALUES (6,'Banana','Summer');
INSERT INTO Fruit(id,name,season) VALUES (7,'Watermelon','Summer');
INSERT INTO Fruit(id,name,season) VALUES (8,'Apple','Fall');
INSERT INTO Fruit(id,name,season) VALUES (9,'Pear','Fall');
ALTER SEQUENCE fruit_seq RESTART WITH 10;
