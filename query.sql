create database librarymanagementsystem;
use librarymanagementsystem;

create table stafflogin(username varchar(20), password varchar(15));
-- insert into stafflogin values('Bhushan', 'Harode0246'), ('Nidhi', 'Sikarwar');
select * from stafflogin;

create table login(susername varchar(20), spassword varchar(15));
select * from login;

create table bookdetails(bookName varchar(50), authName varchar(40), pages varchar(4), publisher varchar(30), price varchar(5), edition varchar(15), bookId varchar(6));
select * from bookdetails;

create table staffdetails(memberName varchar(30), fatherName varchar(30), dob varchar(10), salary varchar(7), address varchar(100), education varchar(6), phone varchar(10), email varchar(35), staffId varchar(6));
select * from staffdetails;

create table studentdetails(firstname varchar(20), lastname varchar(20), phone varchar(10), email varchar(40), username varchar(20));
select * from studentdetails;

create table issuedbooks(bookId varchar(6), bookName varchar(50), authName varchar(40),pages varchar(4), publisher varchar(30), price varchar(5), edition varchar(15), issuedBy varchar(20));
select * from issuedbooks;

-- DROP TABLE issuedbooks;