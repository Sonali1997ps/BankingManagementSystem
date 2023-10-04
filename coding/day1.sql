create database learningmysql;
use learningmysql;
create table Book;
insert into Book(BOOK_N,Book_Name,Author,Cost,Category) values(101,"let us C","Denis ritchie",450,"System");
insert into Book(BOOK_N,Book_Name,Author,Cost,Category) values(102,"Oracle - complete Ref","Loni",550,"Database");
insert into Book(BOOK_N,Book_Name,Author,Cost,Category) values(103,"Matering SQL","Loni",250,"Database");
insert into Book(BOOK_N,Book_Name,Author,Cost,Category) values(104,"PL SQL -Ref","Scott Urman",750,"Database");

SELECT *FROM Book;
SELECT *FROM Book where cost >=500 and cost <=700;
select *from Book where Book_Name like 'O%';
select  avg(Cost) from Book ;
select  max(Cost) from Book ;
select  min(Cost) from Book ;
select cost from book where cost < avg(Cost);

SET SQL_SAFE_UPDATES = 0;
update Book 
set Book_Name="ayesha"
where Book_Name="let us C";
update Book 
set Cost= cost+150
where Book_Name="let us C";
select Cost FROM Book where Cost<500;
select Book_Name  from Book where Category = "database";
select Book_Name , Cost from Book where Category in ("database", "system");
create table newbook like Book;
desc newbook;
Alter table Book add column published int;
update Book
set published=2003
where Book_N=101;
alter table Book add subcribed int  after Author;
#modify used to change datatype
alter table Book
modify Cost int(80);
#chnage used to chnage the column name
alter table Book
change column Author ABC varchar(30);
#rename used to change the table name
alter table Book 
rename Mbook;
alter table Mbook
change column ABC Author varchar(70);
select member_address, count(member_address)from memberr group by member_address;

select member_name from memberr where member_address in( 
select member_address, count(member_address)from memberr group by member_address );
select member_name from memberr where member_address in( 
select member_address from memberr group by member_address  having count(*)<5);
