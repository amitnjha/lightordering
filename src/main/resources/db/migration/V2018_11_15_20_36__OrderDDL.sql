CREATE TABLE CUSTOMER_ORDER (
	ID INT AUTO_INCREMENT PRIMARY KEY,
    CUSTOMER_ID INT  REFERENCES CUSTOMER.ID,
    CREATED_DATE DATE,
    DUE_DATE DATE,
    COMPLETION_DATE DATE,
    PRODUCT_ID INT  REFERENCES PRODUCT.ID,
    STATUS VARCHAR(10),
    CREATED_BY INT REFERENCES USER.ID
    );