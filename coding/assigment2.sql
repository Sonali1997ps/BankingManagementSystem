create database assigment2;
use assigment2;
create table memberr(Member_Id	int(5)	, Member_Name	Varchar(30)	
,Acc_Open_Date	Date	,Fees_paid	int(4));
alter table memberr
drop column Acc_Open_Date;
insert into memberr values(1,'ayesha',25);
#DELETE FROM memberr WHERE Member_Name='ayesha';
insert into memberr values(2,'ayesha',20),(3,'ayesha',5),(4,'ayesha',55);

#issue
create table issue(	Book_No	int(6),	Member_Id	int(5)	);
insert into issue values(2,202),(3,505),(4,550);

#book
create table book(	Book_No	int(6),Book_Name VarChar(30));
insert into book values(1,'a'),(2,'b'),(3,'c');
drop table memberr;
drop table book;
drop table issue;





CREATE TABLE Book(
    bookno int(6),
    bookName varchar(30),
    authorname varchar(30),
    cost int(72),
    category char(10));
    #table book
create table Memberr(Member_Id	int(5),
Member_Name	Varchar(30),	 
Member_address	Varchar(50),	
Membership_type	Varchar(20),

Fees_paid	int(4)	,
Max_Books_Allowed	int(2),	
Penalty_Amount	int(7));
#table issue
create table issue(
Lib_Issue_Id int(10),
Book_No	int(6),
Member_Id	int(5),	
Issue_Date	Date,	
Return_date	Date	
);
alter table issue
drop column Issue_Date ;
alter table issue
drop column Return_date ;
 
 insert into memberr values(1,'Richa Sharma','Pune','Lifetime',2500,5,50),
 (2,'Garma Sen','Pune','Annual',1000,3,null),
(3,'Manasi K','Pune','Annual',1000,2,null),
(4,'Priyanka C','Mumbai','Quarterly',1000,3,12),
(5,'Madhuri A','Pune','Annual',1000,1,null),
(6,'Abha Khanna','Mumbai','Half Yearly',1000,3,11),
(7,'Mitali P','Pune','Annual',1000,null,10);

insert into Book values(101,"let us C","Denis ritchie",450,"System"),
(102,"Oracle - complete Ref","Loni",550,"Database"),
(103,"Matering SQL","Loni",250,"Database"),
(104,"PL SQL -Ref","Scott Urman",750,"Database");
  truncate book;

insert into issue values(7001,101,1),(7002,102,2),(7003,104,1),
(7004,101,1),(7005,104,2),(7006,101,3);
-- 1)	List all the books that are written by Author Loni and has price  
	-- 	less then 600.
select bookname from book where authorname='Loni' and cost<600;
-- 2)	List the Issue details for the books that are not returned yet.
-- 3)	Update all the blank return_date with 31-Dec-06 excluding 7005 and 7006.
update  book
set  bookname='ayesha'
where bookname='let us C'
;

-- 4)	List all the Issue details that have books issued for more then 30 days 
-- 5)	List all the books that have price in range of 500 to 750 and has category as Database.
select bookname from book where cost<=500 and cost >=750;
select bookname from book where cost  between 500 and 700;
-- 6)	List all the books that belong to any one of the following categories Science, Database, Fiction, Management.
select bookname from book where  (category='science'or category='database'
 or category='friction' or category='management');
 -- 7)	List all the members in the descending order of Penalty due on them.
select * from memberr order by member_id desc;
select * from memberr order by Penalty_Amount asc;
select * from memberr order by Penalty_Amount desc;
--  8)	List all the books in ascending order of category and descending order of price. 
select * from book order by category asc;
select * from book order by cost desc;
-- 9)	List all the books that contain word SQL in the name of the book.
select * from book where bookname like '%sql%';
-- 10)	List all the members whose name starts with R or G and contains letter I in it.
select * from memberr where Member_Name like 'r% ' or Member_Name like '%g' and Member_Name like'%i%';

-- 11)	List the entire book name in Init cap and author in upper case 
#in the descending order of the book name.
select * from book where bookname ;
select intcap(author_name),upper(book_name) from book order by bookname desc;

-- List the Issue Details for all the books issue by member 101  with Issue_date and Return Date in following format. ‘Monday, July, 10, 2006’.
SELECT TO_CHAR(ISSUE_date, 'DY/MON/DD/YYYY'),TO_CHAR(RETURN_DATE,'DY/MON/DD/YYYY')FROM ISSUE_506917 WHERE LIB_ISSUE_ID=7001;
-- 13)List the data in the book table with category data displayed as  D for Database, S for Science, R for RDBMS and O for all the  others.
select category , decode(category,'database','D','rdbms','R','science','S','others','O') as types from book;
-- 14)List all the members that became the member in the year 2006.A)
SELECT MEMBER_NAME FROM MEMBERrWHERE TO_CHAR(ACC_OPEN_DATE,'YY')=06;
-- 15)List the Lib_Issue_Id, Issue_Date, Return_Date and No of days Book was issued.
SELECT LIB_ISSUE_ID,ISSUE_DATE,RETURN_DATE,(RETURN_DATE-ISSUE_DATE) AS NUMBER_OF_DAYS FROM ISSUE_506917;
-- 16)Find the details of the member of the Library in the order of their joining the library.A)
select * from issue_506917 order by issue_date ;
-- 17)Display the count of total no of books issued to Member 101.A)
SELECT  SUM(MAX_BOOKS_ALLOWED) FROM MEMBER_506917 WHERE MEMBER_ID=1 ;
-- 18)Display the total penalty due for all the members.A)
select  sum(penalty_amount) from member_506917 ;
-- 19)Display the total no of members A)
use assigment2;
SELECT COUNT(MEMBER_NAME) FROM MEMBERr;
-- 20)Display the total no of books issued A)
SELECT COUNT(member_id) FROM ISSUE;
-- 21)Display the average membership fees paid by all the membersA)
SELECT AVG(FEES_PAID) FROM MEMBER_506917;
-- 22)Display no of months between issue date and return date for all issueA)
SELECT ROUND((RETURN_DATE-ISSUE_DATE)/30) FROM ISSUE_506917;
-- 23)Display the length of member’s nameA)
SELECT LENGTH(MEMBER_NAME)AS LENGTH_OF_NAME FROM MEMBER_506917;
-- 24)Display the first 5 characters of  membership_type for all membersA)
SELECT SUBSTR(MEMBERSHIP_TYPE,1,5) FROM MEMBER_506917;
-- 25)Display the last day of the issue date A)
SELECT LAST_DAY(ISSUE_DATE) FROM ISSUE_506917;
-- 26)Using the regular expression function select name of book  beginning with LA)
SELECT BOOK_NAME FROM BOOKS_506917 WHERE REGEXP_LIKE(BOOK_NAME,'^L');
-- 27)Using regular expression replace using the string 
SELECT REGEXP_REPLACE('We are driving south by south east','south','north') FROM DUAL;
-- 28)  Display the member_name starting with R using regular expression A)SELECT MEMBER_NAME FROM MEMBER_506917 WHERE REGEXP_LIKE(MEMBER_NAME,'^R');29) Display the Book_name containing word SQL using regular expression A)  SELECT BOOK_NAME FROM BOOKS_506917 WHERE REGEXP_LIKE(BOOK_NAME,'SQL');30) Display the Author_name starting with "L" from first position using   regular expressionA)SELECT AUTHOR_NAME FROM BOOKS_506917 WHERE REGEXP_LIKE(AUTHOR_NAME,'^L');31) Display the member_name containing "Ga" from firstto second position using regular expression A)SELECT MEMBER_NAME FROM MEMBER_506917 WHERE REGEXP_LIKE(MEMBER_NAME,'^Ga');32) Replace the book_name "Mastering SQL" with "Advanced SQL" using regular expressionA)  SELECT BOOK_NAME, REGEXP_REPLACE(BOOK_NAME,'Mastering SQL','Advanced SQL') FROM BOOKS_506917;33) Replace the author_name "Scott Urman" with "Scott K Urman" using regular expression A)SELECT AUTHOR_NAME, REGEXP_REPLACE(AUTHOR_NAME,'Scott Urman','Scott R Urman') FROM BOOKS_506917;34) Display the value of book_name from position 1 to 5 containing "G" using the using regular expression A)  SELECT BOOK_NAME, REGEXP_SUBSTR(BOOK_NAME,'.....',1) FROM BOOKS_506917 WHERE REGEXP_LIKE(BOOK_NAME,'G');


