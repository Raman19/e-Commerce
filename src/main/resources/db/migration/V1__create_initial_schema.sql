CREATE TABLE `product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NOT NULL,
  `stocknumber` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `rating` DECIMAL(2,1) NULL,
  `reviews` INT(5) NULL,
  `listprice` INT(5) NULL,
  `discountpercentage` INT(3) NULL,
  `discountedamount` INT(5) NULL,
  `quantity` INT(3) NULL,
  `agerestrict` INT(2) NULL,
  `createddate` TIMESTAMP NULL DEFAULT now(),
  `modifieddate` TIMESTAMP NULL DEFAULT now(),
  `version` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `product_name_UNIQUE` (`productname` ASC),
  UNIQUE INDEX `stock_number_UNIQUE` (`stocknumber` ASC));
