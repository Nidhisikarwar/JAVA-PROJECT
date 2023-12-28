create database librarymanagementsystem;
use librarymanagementsystem;

create table login(username varchar(20), password varchar(15));
insert into login values('admin', '12345678');
select * from login;

create table bookdetails(bookName varchar(40), authName varchar(20), pages varchar(3), publisher varchar(30), price varchar(10), edition varchar(15), bookId varchar(10));
select * from bookdetails;

create table staffdetails(memberName varchar(30), fatherName varchar(30), dob varchar(10), salary varchar(7), address varchar(100), education varchar(6), phone varchar(10), email varchar(35), staffId varchar(10));
select * from staffdetails;

-- DROP TABLE name;