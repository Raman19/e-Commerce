use ecommercetest;
TRUNCATE TABLE product;
INSERT INTO product (productname,stocknumber,description,rating,reviews,listprice,discountpercentage,discountedamount,quantity,agerestrict,createddate,modifieddate)
VALUES ('Glass',125,'This is for testing only',4.0,524.0,125,20,100,5,21,'2015-03-15 00:00:00.000','2016-03-15 00:00:00.000');
