use ecommercetest;
TRUNCATE TABLE product;
INSERT INTO product (product_name,stock_number,description,rating,reviews,list_price,discount_percentage,discounted_amount,quantity,age_restrict,created_date,modified_date)
VALUES ('Glass',125,'This is for testing only',4.0,524.0,125,20,100,5,21,'2015-03-15 00:00:00.000','2016-03-15 00:00:00.000');
