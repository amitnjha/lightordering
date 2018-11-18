CREATE TABLE CUSTOMER (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(60),
    LAST_NAME VARCHAR(60),
    EMAIL VARCHAR(60),
    HOUSE_NUMBER INT,
    ADDRESS_LINE_1 VARCHAR(60),
    ADDRESS_LINE_2 VARCHAR(60),
    CITY VARCHAR(60),
    ZIP INT,
    STATE VARCHAR(2),
    SSN INT
    );