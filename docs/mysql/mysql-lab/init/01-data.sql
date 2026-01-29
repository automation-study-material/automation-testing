-- ==========================
-- Customers Table
-- ==========================
CREATE TABLE customers (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    ContactName VARCHAR(100),
    Address VARCHAR(150),
    City VARCHAR(50),
    PostalCode VARCHAR(20),
    Country VARCHAR(50)
);

INSERT INTO customers VALUES
(1,'Alfreds Futterkiste','Maria Anders','Obere Str. 57','Berlin','12209','Germany'),
(2,'Ana Trujillo Emparedados y helados','Ana Trujillo',
 'Avda. de la Constitución 2222','México D.F.','05021','Mexico'),
(3,'Antonio Moreno Taquería','Antonio Moreno',
 'Mataderos 2312','México D.F.','05023','Mexico'),
(4,'Around the Horn','Thomas Hardy',
 '120 Hanover Sq.','London','WA1 1DP','UK'),
(5,'Berglunds snabbköp','Christina Berglund',
 'Berguvsvägen 8','Luleå','S-958 22','Sweden');

-- ==========================
-- Products Table
-- ==========================
CREATE TABLE products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100),
    SupplierID INT,
    CategoryID INT,
    Unit VARCHAR(50),
    Price DECIMAL(10,2)
);

INSERT INTO products VALUES
(1,'Chais',1,1,'10 boxes x 20 bags',18),
(2,'Chang',1,1,'24 - 12 oz bottles',19),
(3,'Aniseed Syrup',1,2,'12 - 550 ml bottles',10),
(4,'Chef Anton''s Cajun Seasoning',2,2,'48 - 6 oz jars',22),
(5,'Chef Anton''s Gumbo Mix',2,2,'36 boxes',21.35);
