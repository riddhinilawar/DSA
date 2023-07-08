Select Query

SELECT col1, col2 FROM tab1 JOIN tab2 ON tab1.col = tab2.col WHERE condition GROUP BY col HAVING condition ORDER BY col AESC|DESC 

Database Queries

CREATE DATABASE databasename;
CREATE DATABASE testDB;


DROP DATABASE databasename;
DROP DATABASE testDB;


BACKUP DATABASE databasename TO DISK = 'filepath';
BACKUP DATABASE testDB TO DISK = 'D:\backups\testDB.bak';


BACKUP DATABASE databasename TO DISK = 'filepath'WITH DIFFERENTIAL;
BACKUP DATABASE testDB TO DISK = 'D:\backups\testDB.bak'WITH DIFFERENTIAL;
DIFFERENTIAL : A differential back up only backs up the parts of the database that have changed since the last full database backup.

Data Definition Queries

CREATE TABLE tablename ( column_name data_type NOT NULL, CONSTRAINT pkname PRIMARY KEY (col), CONSTRAINT fkname FOREIGN KEY (col) REFERENCES other_table(col_in_other_table), CONSTRAINT ucname UNIQUE (col), CONSTRAINT ckname CHECK (conditions) );

CREATE TABLE table_name (column1 datatype,column2 datatype,column3 datatype);
CREATE TABLE Persons (PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255));
255 represents the length

CREATE TABLE new_table_name AS SELECT column1, column2 FROM existing_table_name WHERE ....;
CREATE TABLE Persons2 AS SELECT FirstName, LastName  FROM Persons;

DROP TABLE table_name;
DROP TABLE Persons2;

TRUNCATE TABLE table_name;
TRUNCATE TABLE Person2;
The TRUNCATE TABLE statement is used to delete the data inside a table, but not the table itself.

ALTER TABLE table_name ADD column_name datatype;
ALTER TABLE Persons ADD Email varchar(255);

ALTER TABLE table_name DROP COLUMN column_name;
ALTER TABLE Persons DROP COLUMN Email;

ALTER TABLE table_name RENAME COLUMN old_name to new_name;
ALTER TABLE Persons RENAME COLUMN Email to EmailAddress;

ALTER TABLE table_name MODIFY column_name datatype;
ALTER TABLE persons MODIFY address varchar(80) ;

ALTER TABLE table_name RENAME TO new_table_name;
ALTER TABLE persons RENAME TO person;

ALTER TABLE table_name ADD CONSTRAINT constraint_name constraint_type (columns);
ALTER TABLE person ADD CONSTRAINT PK_Person PRIMARY KEY(columns);

ALTER TABLE table_name DROP CONSTRAINT constraint_name;
ALTER TABLE person DROP CONSTRAINT PK_Person;

ALTER TABLE person ADD constraint_type (column);
ALTER TABLE person ADD PRIMARY KEY (ID);

ALTER TABLE table_name DROP PRIMARY KEY;
ALTER TABLE Person DROP PRIMARY KEY;


Data Manipulation Queries

INSERT INTO table_name (column1, column2, column3, … VALUES (value1, value2, value3, ...);
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country) VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');
INSERT INTO Customers (CustomerName, City, Country)VALUES ('Cardinal', 'Stavanger', 'Norway');
Inserting in specific columns

INSERT INTO table_name VALUES (value1, value2, value3, ...);
INSERT INTO Customers VALUES ('Riddhi', 'Nilawar', Hingoli, ...);

INSERT INTO table_name1 SELECT * FROM table_name2;
INSERT INTO TABLEC SELECT * FROM TABLEA;

--INSERT INTO table_name(col1,col2,col3) VALUES (v1,v2,'v3'),((v1,v2,'v3'),(v1,v2,'v3');
--INSERT INTO Info (id,Cost,city) VALUES (1,200,'Pune'),(2,150,'USA'),(3,345,'France');

UPDATE table_name SET column1 = value1, column2 = value2, … WHERE condition;
UPDATE Customers SET ContactName = 'Alfred Schmidt', City= 'Frankfurt' WHERE CustomerID = 1;
UPDATE Customers SET ContactName='Juan' WHERE Country='Mexico';

DELETE FROM table_name WHERE condition;
DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';

DELETE FROM table_name;
DELETE FROM Customers;

DESC table_name -> shows the structure of table.

Data Control Queries

GRANT privilege_name ON objectname TO user;
GRANT SELECT, UPDATE ON employees TO Bhanu;
GRANT CONNECT, RESOURCE, CREATE SYNONYM, CREATE TABLE, CREATE PROCEDURE, CREATE SEQUENCE TO riddhi;

REVOKE privilege_name ON objectname FROM user;
REVOKE SELECT, UPDATE ON employees FROM Bhanu;

Data Transaction Queries

COMMIT;

ROLLBACK;

ROLLBACK TO savepoint_name;

SAVEPOINT savepoint_name;

RELASE SAVEPOINT savepoint_name;


Joins

Inner Join
SELECT * FROM TableA INNER JOIN TableB ON TableA.PK = TableB.Pk

SELECT * FROM TableA INNER JOIN TableB ON TableA.PK > TableB.Pk
SELECT * FROM TableA INNER JOIN TableB ON TableA.PK < TableB.Pk
SELECT * FROM TableA INNER JOIN TableB ON TableA.PK <> TableB.Pk

Equi Join
SELECT * FROM TableA INNER JOIN TableB ON TableA.PK = TableB.Pk

	1. Inner join can have equality (=) and other operators (like <,>,<>) in the join condition.
	2. Equi join only have an equality (=) operator in the join condition.
	3. Equi join can be an Inner join, Left Outer join, Right Outer join

Left(Outer) Join

SELECT * FROM TableA LEFT OUTER JOIN TableB ON TableA.PK = TableB.Pk

Right(Outer) Join

SELECT * FROM TableA RIGHT OUTER JOIN TableB ON TableA.PK = TableB.Pk

Full(Outer) Join

SELECT * FROM TableA FULL OUTER JOIN TableB ON TableA.PK = TableB.Pk

Left(Outer) Join excluding Inner Join

SELECT * FROM TableA LEFT OUTER JOIN TableB ON TableA.PK = TableB.Pk WHERE TableB.PK=NULL

Right(Outer) Join excluding Inner Join

SELECT * FROM TableA RIGHT OUTER JOIN TableB ON TableA.PK = TableB.Pk WHERE TableA.PK=NULL

Full(Outer) Join excluding Inner Join

SELECT * FROM TableA FULL OUTER JOIN TableB ON TableA.PK = TableB.Pk  WHERE TableA.PK=NULL OR TableB.PK=NULL

Cross Join/ Cartesian-Product Join

SELECT * FROM TableA, TableB
SELECT * FROM TableA CROSS JOIN TableB

Natural Join

SELECT column‑list FROM left-join-table NATURAL [ INNER | LEFT OUTER | RIGHT OUTER | FULL OUTER ] JOIN right-join-table
Natural joins are, by default, natural inner joins; however, there can also be natural left/right/full outer joins. The primary difference between an inner and natural join is that inner joins have an explicit join condition, whereas the natural join’s conditions are formed by matching all pairs of columns in the tables that have the same name and compatible data types, making natural joins equi-joins because join condition are equal between common columns. If there are no columns with the same names are found, then the result will be a "cross join"
Ref: https://www.dotnettricks.com/learn/sqlserver/difference-between-inner-join-and-equi-join-and-natural-join

Self Join
SELECT column_name(s) FROM table1 T1, table1 T2 WHERE condition;
SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City FROM Customers A, Customers B WHERE A.CustomerID <> B.CustomerID AND A.City = B.City ORDER BY A.City;



Views


CREATE VIEW view_name AS SELECT column1, column2, … FROM table_name WHERE condition;
CREATE VIEW  Brazil Customers AS SELECT CustomerName, ContactName FROM Customers WHERE Country = 'Brazil';

SELECT * FROM view_name;
SELECT * FROM Brazil Customers;

CREATE OR REPLACE VIEW view_name AS SELECT column1, column2, … FROM table_name WHERE condition;
CREATE OR REPLACE VIEW Brazil Customers AS SELECT CustomerName, ContactName, City FROM Customers WHERE Country = 'Brazil';

DROP VIEW view_name;
DROP VIEW Brazil Customers;

Set Operations

UNION: Shows unique rows from two result sets.

SELECT column_name(s) FROM table1 UNION SELECT column_name(s) FROM table2;
SELECT 'Customer' AS Type, ContactName, City, Country FROM Customers UNION 
SELECT 'Supplier', ContactName, City, Country FROM Suppliers;

UNION ALL: Shows all rows from two result sets.

SELECT column_name(s) FROM table1 UNION ALL SELECT column_name(s) FROM table2;
SELECT City, Country FROM Customers WHERE Country='Germany' UNION ALL 
SELECT City, Country FROM SuppliersWHERE Country='Germany' ORDER BY City;

The UNION operator selects only distinct values by default. To allow duplicate values, use UNION ALL

INTERSECT: Shows rows that exist in both result sets. 

SELECT column_name(s) FROM table1 INTERSECT SELECT column_name(s) FROM table2;
SELECT 'Customer' AS Type, ContactName, City, Country FROM Customers INTERSECT 
SELECT 'Supplier', ContactName, City, Country FROM Suppliers;

EXCEPT/MINUS: Shows rows that exist in the first result set but not the second.

SELECT column_name(s) FROM table1 MINUS SELECT column_name(s) FROM table2;
SELECT 'Customer' AS Type, ContactName, City, Country FROM Customers MINUS 
SELECT 'Supplier', ContactName, City, Country FROM Suppliers;



Clauses

HAVING :- The HAVING clause was added to SQL because the WHERE keyword cannot be used with aggregate functions.
SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country HAVING COUNT(CustomerID) > 5;
Only include countries with more than 5 customers

GROUP BY:-  It is often used with aggregate functions (COUNT(), MAX(), MIN(), SUM(), AVG()) to group the result-set by one or more columns.
SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country;

ORDER BY:- 
SELECT * FROM Customers ORDER BY Country, CustomerName;
SELECT * FROM Customers ORDER BY Country ASC, CustomerName DESC;
sorted ascending by the "Country" and if any record has same Country then descending by the "CustomerName" column

DISTINCT:- It is used to return only distinct (different) values.
SELECT DISTINCT column1, column2, ...FROM table_name;
SELECT DISTINCT Country FROM Customers;
SELECT COUNT(DISTINCT Country) FROM Customers;


Operators /Conditions

AND :  The AND operator displays a record if all the conditions separated by AND are TRUE.
SELECT column1, column2, … FROM table_name WHERE condition1 AND condition2 AND condition3 ...;
SELECT * FROM Customers WHERE Country='Germany' AND City='Berlin';

OR: The OR operator displays a record if any of the conditions separated by OR is TRUE.
SELECT column1, column2, … FROM table_name WHERE condition1 OR condition2 OR condition3 ...;
SELECT * FROM Customers WHERE City='Berlin' OR City='München';

NOT: The NOT operator displays a record if the condition(s) is NOT TRUE.
SELECT column1, column2, … FROM table_name WHERE NOT condition;
SELECT * FROM Customers WHERE NOT Country='Germany';

COMBINATION : 
SELECT * FROM Customers WHERE Country='Germany' AND (City='Berlin' OR City='München');
SELECT * FROM Customers WHERE NOT Country='Germany' AND  NOT Country='USA';

LIKE: The LIKE operator is used in a WHERE clause to search for a specified pattern in a column.
The percent sign (%) represents zero, one, or multiple characters
 The underscore sign (_) represents one, single character
SELECT column1, column2, … FROM table_name WHERE columnN LIKE pattern;
SELECT * FROM Customers WHERE CustomerName LIKE '%a';

IN:  The IN operator allows you to specify multiple values in a WHERE clause.The IN operator is a shorthand for multiple OR conditions.
SELECT column_name(s) FROM table_name WHERE column_name IN (value1, value2, ...);
SELECT column_name(s) FROM table_name WHERE column_name IN (SELECT STATEMENT);
SELECT * FROM Customers WHERE Country IN (SELECT Country FROM Suppliers);
SELECT * FROM Customers WHERE Country IN ('Germany', 'France', 'UK');

NOT IN
SELECT column_name(s) FROM table_name WHERE column_name NOT IN (value1, value2, ...);
SELECT column_name(s) FROM table_name WHERE column_name NOT IN (SELECT STATEMENT);
SELECT * FROM Customers WHERE Country NOT IN (SELECT Country FROM Suppliers);
SELECT * FROM Customers WHERE Country NOT IN ('Germany', 'France', 'UK');

IS NULL
SELECT column_names FROM table_name WHERE column_name IS NULL;
SELECT CustomerName, ContactName, Address FROM Customers WHERE Address IS NULL;

IS NOT NULL
SELECT column_names FROM table_name WHERE column_name IS NOT NULL;
SELECT CustomerName, ContactName, Address FROM Customers WHERE Address IS NOT NULL;

BETWEEN : The BETWEEN operator selects values within a given range. The values can be numbers, text, or dates.
The BETWEEN operator is inclusive: begin and end values are included. 
SELECT column_name(s) FROM table_name WHERE column_name BETWEEN value1 AND value2;
SELECT * FROM Products WHERE Price BETWEEN 10 AND 20;

EXISTS: The EXISTS operator is used to test for the existence of any record in a subquery.
The EXISTS operator returns TRUE if the subquery returns one or more records.
SELECT SupplierName FROM Suppliers WHERE EXISTS (SELECT ProductName FROM Products WHERE Products.SupplierID = Suppliers.supplierID AND Price < 20);

ANY:  ANY means that the condition will be true if the operation is true for any of the values in the range.
SELECT column_name(s) FROM table_name WHERE column_name operator ANY (SELECT column_name FROM table_name WHERE condition);
SELECT ProductName FROM Products WHERE ProductID = ANY (SELECT ProductID FROM OrderDetails  WHERE Quantity = 10);

ALL:
SELECT ProductName FROM Products WHERE ProductID = ALL (SELECT ProductID FROM OrderDetails WHERE Quantity = 10);



Constraints 

• NOT NULL - Ensures that a column cannot have a NULL value
• UNIQUE - Ensures that all values in a column are different
• PRIMARY KEY - A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table
• FOREIGN KEY - Prevents actions that would destroy links between tables
• CHECK - Ensures that the values in a column satisfies a specific condition
• DEFAULT - Sets a default value for a column if no value is specified
• CREATE INDEX - Used to create and retrieve data from the database very quickly

CREATE TABLE table_name ( column1 datatype constraint, column2 datatype constraint, column3 datatype constraint,....);
ALTER TABLE table_name MODIFY column1 datatype constraint, column2 datatype constraint, column3 datatype constraint,....;


NOT NULL
CREATE TABLE Persons (ID int NOT NULL, LastName varchar(255) NOT NULL ,FirstName varchar(255) NOT NULL ,Age int);
ALTER TABLE Persons MODIFY COLUMN Age int NOT NULL;
ALTER TABLE Persons MODIFY COLUMN Age int NULL;

UNIQUE
CREATE TABLE Persons (ID int NOT NULL UNIQUE);
CREATE TABLE Persons (ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255),Age int, CONSTRAINT UC_Person UNIQUE (ID, LastName));
ALTER TABLE Persons ADD UNIQUE (AGE);
ALTER TABLE Persons ADD CONSTRAINT UC_Person UNIQUE (ID, LastName);
ALTER TABLE Persons DROP CONSTRAINT UC_Person;

PRIMARY KEY
CREATE TABLE Persons ( ID int NOT NULL PRIMARY KEY, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int);
CREATE TABLE Persons (ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int, PRIMARY KEY (ID));
CREATE TABLE Persons (ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int, CONSTRAINT PK_Person PRIMARY KEY (ID, LastName));
In the example above there is only ONE PRIMARY KEY (PK_Person). However, the VALUE of the primary key is made up of TWO COLUMNS (ID + LastName).
ALTER TABLE Persons ADD PRIMARY KEY (ID);
ALTER TABLE Persons ADD CONSTRAINT PK_Person PRIMARY KEY (ID, LastName);
ALTER TABLE Persons DROP CONSTRAINT PK_Person;

FOREIGN KEY
CREATE TABLE Orders (OrderID int NOT NULL PRIMARY KEY, OrderNumber int NOT NULL, PersonID int FOREIGN KEY REFERENCES Persons(PersonID));
CREATE TABLE Orders (OrderID int NOT NULL, OrderNumber int NOT NULL, PersonID int, PRIMARY KEY (OrderID),
CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID) REFERENCES Persons(PersonID));
ALTER TABLE Orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
ALTER TABLE Orders ADD CONSTRAINT FK_PersonOrder FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
ALTER TABLE Orders DROP CONSTRAINT FK_PersonOrder;

CHECK
CREATE TABLE Persons ( ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int CHECK (Age>=18) );
CREATE TABLE Persons (ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int, City varchar(255), CONSTRAINT CHK_Person CHECK (Age>=18 AND City='Sandnes'));
ALTER TABLE Persons ADD CHECK (Age>=18);
ALTER TABLE Persons ADD CONSTRAINT CHK_PersonAge CHECK (Age>=18 AND City='Sandnes');
ALTER TABLE Persons DROP CONSTRAINT CHK_PersonAge;

DEFAULT
CREATE TABLE Persons ( ID int NOT NULL, LastName varchar(255) NOT NULL, FirstName varchar(255), Age int, City varchar(255) DEFAULT 'Sandnes');
ALTER TABLE Persons MODIFY City DEFAULT 'Sandnes';
ALTER TABLE Persons ALTER COLUMN City DROP DEFAULT;

INDEX
CREATE INDEX index_name ON table_name (column1, column2, ...);
CREATE UNIQUE INDEX index_name ON table_name (column1, column2, ...);
CREATE INDEX idx_pname ON Persons (LastName, FirstName);
DROP INDEX index_name;
ALTER INDEX old_index RENAME TO new_index; 


COMMENTS

Single-line
-- SELECT * FROM Customers;

SELECT * FROM Customers -- WHERE City='Berlin';

Multi-line

/*Select all the columns
of all the records
in the Customers table:*/
SELECT * FROM Customers;

SELECT CustomerName, /*City,*/ Country FROM Customers;

SELECT * FROM Customers WHERE (CustomerName LIKE 'L%'
OR CustomerName LIKE 'R%' /*OR CustomerName LIKE 'S%'
OR CustomerName LIKE 'T%'*/ OR CustomerName LIKE 'W%')
AND Country='USA'
ORDER BY CustomerName;



Alias 

For Table

SELECT column_name(s) FROM table_name AS alias_name;
SELECT o.OrderID, o.OrderDate, c.CustomerName FROM Customers AS c, Orders AS o WHERE c.CustomerName='Around the Horn' AND c.CustomerID=o.CustomerID;

For Column

SELECT column_name AS alias_name FROM table_name;
SELECT CustomerName, Address + ', ' + PostalCode + ' ' + City + ', ' + Country AS Addres FROM Customers;




Wildcards



_  :- represents the single character
% :- represents zer or more character

WHERE CustomerName LIKE 'a%'	Finds any values that starts with "a"
WHERE CustomerName LIKE '%a'	Finds any values that ends with "a"
WHERE CustomerName LIKE '%or%'	Finds any values that have "or" in any position
WHERE CustomerName LIKE '_r%'	Finds any values that have "r" in the second position
WHERE CustomerName LIKE 'a__%'	Finds any values that starts with "a" and are at least 3 characters in length
WHERE ContactName LIKE 'a%o'	Finds any values that starts with "a" and ends with "o"


Functions

COUNT: 
SELECT COUNT(column_name) FROM table_name WHERE condition;
SELECT COUNT(ProductID) FROM Products;

SUM:
SELECT SUM(column_name) FROM table_name WHERE condition;
SELECT SUM(ProductID) FROM Products;

MIN:
SELECT MIN(column_name) FROM table_name WHERE condition;
SELECT MIN(ProductID) FROM Products;

MAX:
SELECT MAX(column_name) FROM table_name WHERE condition;
SELECT MAX(ProductID) FROM Products;

AVG:
SELECT AVG(column_name) FROM table_name WHERE condition;
SELECT AVG(ProductID) FROM Products;

Date and Time Functions
• DATE - format YYYY-MM-DD
• DATETIME - format: YYYY-MM-DD HH:MI:SS
• SMALLDATETIME - format: YYYY-MM-DD HH:MI:SS
• TIMESTAMP - format: a unique number

SELECT  TO_CHAR(hire_date, 'DD-MON-YYYY') from dual;

SQLCODE
• If SQLCODE = 0 and SQLWARN0 is blank, execution was successful.
• If SQLCODE = 100, "no data" was found. For example, a FETCH statement returned no data because the cursor was positioned after the last row of the result table.
• If SQLCODE > 0 and not = 100, execution was successful with a warning.
• If SQLCODE = 0 and SQLWARN0 = 'W', execution was successful with a warning.
• If SQLCODE < 0, execution was not successful.

From <https://www.ibm.com/docs/en/db2-for-zos/11?topic=applications-sqlcode> 


SQLERRM

GREATEST: select the greatest among all values
Select greatest(25, 26, 02, 58, 65, 41, 74) from dual;
Select greatest('java', 'phython', 'php', 'Asp.net') from dual;  

UPPER
TO_CHAR
TO_DATE
SYSDATE:
select sysdate from dual;
SYSTIMESTAMP
LOWER
TRIM
LTRIM
RTRIM
LENGTH
LPAD
RPAD
CHR
ASCII
INITCAP
INSTR

MOD:  This function is used to get the remainder of given values.
n: number to be divided by m
m: number that will divide n
MOD(n, m)  
Select mod(3,2) from dual;  
Select mod(45.2,12) from dual;  

NVL
REGEXP_COUNT
REGEXP_INSTR
REGEXP_REPLACE
REGEXP_SUBSTR
TRUNC: truncate the given number upto given certain decimal places.

Select trunc(145.236) from  dual;  
Select trunc(145.236,2) from  dual;  

TRANSLATE
DECODE
FLOOR:
select floor(11.3) from dual;
select floor(11.5) from dual;

CEIL:
select ceil(11.5) from dual;
select ceil(11.2)from dual;
select ceil(-12) from dual;

SUBSTR:

REPLACE
ROUND:
select round(172.41)from dual;
select round(172.411, 2)from dual;

ROWNUM :  It is used to specify the number of records to return

SELECT column_name(s) FROM table_name WHERE ROWNUM <= number;
SELECT * FROM TableA CROSS JOIN TableB WHERE ROWNUM<=5
TO_NUMBER

SQRT:
select sqrt(25)from dual;
select sqrt(27) from dual;

Case Statement

SELECT OrderID, Quantity,
CASE
    WHEN Quantity > 30 THEN 'The quantity is greater than 30'
    WHEN Quantity = 30 THEN 'The quantity is 30'
    ELSE 'The quantity is under 30'
END AS QuantityText
FROM OrderDetails;

SELECT CustomerName, City, Country
FROM Customers
ORDER BY
(CASE
    WHEN City IS NULL THEN Country
    ELSE City
END);

Sequence

CREATE SEQUENCE sequence_1
start with 1
increment by 1
minvalue 0
maxvalue 100
cycle;

CREATE SEQUENCE sequence_2
start with 100
increment by -1
minvalue 1
maxvalue 100
cycle;

CREATE TABLE students( 
ID number(10),
NAME char(20)
);
Now insert values into table:
INSERT into students VALUES(sequence_1.nextval,'Ramesh');
INSERT into students VALUES(sequence_1.nextval,'Suresh');

Synonym

CREATE SYNONYM synonymname 
FOR servername.databasename.schemaname.objectname;
