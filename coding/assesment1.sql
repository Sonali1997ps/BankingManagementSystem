create database assesment1;
use assesment1;
#1)	Create the table Member, Books and Issue without any constraints as mentioned in the schema description above.
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
#2)	View the structure of the tables
desc memberr;
desc book;
desc issue;
#3)	Drop the Member table
drop table memberr;
/*4)	Create the table Member again as per the schema description with the following constraints.

a.	Member_Id – Primary Key
b.	Membership_type - ‘Lifetime’,’ Annual’, ‘Half Yearly’,’ Quarterly’
*/

create table Memberr(Member_Id	int(5) primary key,
Member_Name	Varchar(30),	 
Member_address	Varchar(50),	

Membership_type	Varchar(20) check (Membership_type='Lifetime'or Membership_type='Annual' or 
Membership_type='Half Yearly'or Membership_type='Quarterly' ),	 
Fees_paid	int(4)	,
Max_Books_Allowed	int(2),	
Penalty_Amount	int(7));
#5)	Modify the table Member increase the width of the member name to 30 characters.
alter table memberr
modify Member_Name	char(30);
#6)	Add a column named as Reference of Char(30) to Issue table.
#alter(change rename modify add drop)
alter table issue
add reference char(30);

#7)	Delete/Drop the column Reference from Issue.
alter table issue
drop column reference ;
#8)	Rename the table Issue to Lib_Issue.
alter table issue
rename lib_issue;
#9)	Insert following data in table Member
insert into  memberr (Member_Id, Member_Name,	 Member_address	,	Membership_type	,	
Fees_paid,Max_Books_Allowed	,	Penalty_Amount	)values(1,'Richa Sharma','Pune',
'Lifetime',	25000	,5	,50) ;
insert into memberr values(1,'Richa Sharma','Pune','Lifetime',2500,5,
50);
DROP TABLE MEMBERR;




insert into memberR values(2,'Garma Sen','Pune','Annual',1000,3,null);

#10)	Insert at least 5 records with suitable data and save it
insert into memberr values(3,'Manasi K','Pune','Annual',1000,2,null);
insert into memberr values(4,'Priyanka C','Mumbai','Quarterly',1000
,3,12);
insert into memberr values(5,'Madhuri A','Pune','Annual',1000,1,null);
insert into memberr values(6,'Abha Khanna','Mumbai','Half Yearly',1000,3,11);
insert into memberr values(7,'Mitali P','Pune','Annual',1000,null,10);

#Modify the column Member_name. Decrease the width of the member  name to 20 characters.
# (If it does not allow state the reason for that)
#Not posssible as modifications are done from lower to higher level of variable s
#ize.

#12)	Try to insert #a record with Max_Books_Allowed = 110, Observe   the error that comes. 
#Report the reason for this error.
 insert into memberr values(8,'Jinal P','Pune','Annual',1000,110,10);
insert into memberr values(8,'Jinal P','Pune','Annual',1000,110,10);
 /*
ERROR at line 1:
ORA-01438: value larger than specified precision allows for this column
Since the variable size is 2.*/
#13)	Generate another table named Member101 using a 
#Create command along with a simple SQL query on member table.
CREATE TABLE member1(
    maxbook int(6),
    penalty int(30)
    );



/*14)	Add the constraints on columns max_books_allowed  and penalty_amt as follows
a.	max_books_allowed  < 100
b.	penalty_amt maximum 1000
      Also give names to the constraints.
*/
alter table member1 
add constraint mmm check(maxbook
< 100 and penalty <= 1000);


#create table member101 as select * from member;

drop table book;
/*16)	Create table Books again as per the schema description with the following constraints.
a.	Book_No – Primary Key
b.	Book_Name – Not Null
c.	Category – Science, Fiction, Database, RDBMS, Others.
*/
create table Book(book_no int(101),Book_Name varchar(30),Author  varchar(20),Cost int (100),Category varchar(20));

#17)	Insert data in Book table as follows:18)	Insert more records in Book table using & operator in the insert 
#statement.
alter table books
add column Author varchar(20) after Book_Name;
alter table books
add column cost int(20) after  Author;
insert into Book(book_no,Book_Name,Author,Cost,Category) values(101,"let us C","Denis ritchie",450,"System");
insert into Book(book_no,Book_Name,Author,Cost,Category) values(102,"Oracle - complete Ref","Loni",550,"Database");
insert into Book(book_no,Book_Name,Author,Cost,Category) values(103,"Matering SQL","Loni",250,"Database");
insert into Book(book_no,Book_Name,Author,Cost,Category) values(104,"PL SQL -Ref","Scott Urman",750,"Database");
drop table books;
#20)	Insert into Book101 all the data in Book table using Select Statement.

 insert into book(select * from book);
#21)	Save all the data so far inserted in the tables.
commit;
#22)	View the data in the tables using simple SQL query.
select * from book;
#23)	Insert into Book following data.105,  National Geographic, Adis Scott, 1000,  Science

insert into book values(105, 'National Geographic', 'Adis Scott', 1000, 'Science');
#24)	Undo the last changes.
rollback;
#25)	Modify the price of book with id 103 to Rs 300 and category to RDBMS.

update book set category='RDBMS',cost=300 where book_no=103;
#25)	Modify the price of book with id 103 to Rs 300 and category to RDBMS.
alter table lib_issue
rename issue;
#27)	Drop table Issue.
drop table issue;
/*28)	As per the given structure Create table Issue again with following constraints.
	Lib_Issue
	_Id-Primary key
	Book_No-  foreign key
	Member_id - foreign key
	Issue_date < Return_date
*/
create table issue( lib_issue_id int(10) primary key,
book_no int(6) references books(book_no),
member_id int(5) references member1(member_id),

return_date date,
check(issue_date<return_date)
);
drop table issue;
/*In above example we can't process with system date or any system function in che
ck constraint
Insert following data into Issue table. Note leave the column 
Return_Date blank.
*/
insert into issue values(7001,101,1,null);
insert into issue values(7002,102,2,null);
insert into issue values(7003,104,1,'21-jan-06');
insert into issue values(7004,101,1,null);
insert into issue values(7005,104,2,'26-nov-06');
insert into issue values(7006,101,3,null);
#30)	Save the data.
savepoint a29;
#31)	Disable the constraints on Issue table
alter table issue disable constraint issue_id_pk;
#32)	Insert a record in Issue table. The member_id should not exist in 
#member table.

insert into issue_copy values(7007,101,21,'18-Feb-06',null);
 insert into issue_copy values(7007,101,21,'18-Feb-06',null);
/*
ERROR at line 1:
ORA-02291: integrity constraint (CS_2.SYS_C0013125) violated - parent key not
found
Q.No.35*/
#It will delete the corresponding child records in other table i.e issue table
#36)	Modify the Return_Date of 7004,7005 to 15 days after the   Issue_date.

update issue set return_date=issue_date+15 where lib_issue_id=7004;
update issue set return_date=issue_date+15 where lib_issue_id=7005;
#37)	Modify the Penalty_Amount for Garima Sen to Rs 100.


update member1 set penalty_amount=100 where member_name='Garma Sen';
#38)	Perform a save point X here.
savepoint x;
#41)	Undo the changes done after savepoint X.
rollback to savepoint x;
#42)	Save all the changes done before X.
savepoint b;
#43)	Remove the table Member101.
drop table member101;
#44)	Remove the table Book101
drop table books101;
#45)	View the data and structure of all the three tables Member, Issue, Book.

desc memberr;
desc books;
desc issue;
select * from member;
select * from books;
select * from issue;
#46)	Create a sequence no_seq of even numbers starting with 100 
         #and ending with 200.

create sequence no_seq
start with 100
increment by 2
maxvalue 200
NOCYCLE
NOCACHE;
#47)	Drop the above created sequence
drop sequence no_seq;
#48)	Create a sequence book_seq starting with 101 and ending with 1000And increamented by 1 without cycle.

create sequence book_seq
start with 101
increment by 1
maxvalue 1000
NOCYCLE
NOCACHE;
#49)	Create a sequence member_seq starting with 1 and ending with 100
       #And increamented by 1 without cycle.

create sequence member_seq
start with 1
increment by 1
maxvalue 100
NOCYCLE
NOCACHE;
#Drop the above created sequences.
drop sequence book_seq;
drop sequence member_seq;