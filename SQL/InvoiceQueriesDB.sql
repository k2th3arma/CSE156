#Finds all data in the Person table
select * from person;

select PersonContact from person where PersonCode = "ma12";

UPDATE `invoicedb`.`person` SET `PersonContact`=' here' WHERE `idPerson`='4';

UPDATE `invoicedb`.`person` SET `PersonContact`='there' WHERE `idPerson`='4';

delete from person where idPerson = '21';

select InvoiceProduct From invoice where InvoiceNum = '2';

select InvoiceProduct From invoice where InvoiceCustomer = '5';

INSERT INTO `invoicedb`.`invoice` (`idInvoice`, `InvoiceNum`, `InvoiceCustomer`, `InvoiceDate`, `InvoiceRepCode`, `InvoiceProduct`, `InvoiceAmount`) 
VALUES ('9', '4', '2', 'date', 'rep', 'product', 'amount');

select ProductUnitPrice From Products where ProductType = 'E';

select customer.CustomerCode, count(*) 
as invoiceNum from invoice 
join 
