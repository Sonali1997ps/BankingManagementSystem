select * from dept;

 create table Atable (aid int primary key,name varchar(10));
insert into Atable values (1,'one');
insert into Atable values (2,'two'),(3,'three');

 create table Btable (bid int primary key,name varchar(10));
   insert into btable values (11,'eleven');
   insert into btable values (12,'twelve');
   insert into btable values (13,'twelve');

 create table ctable (aid int,bid int,foreign key(aid) references atable(aid),foreign key(bid) references btable(bid));

insert into ctable values(1,11);
insert into ctable values(2,12);
insert into ctable values(2,11);
select * from ctable;
#alias name
 select a.name as "A" ,c.aid,b.name "B",c.bid from atable a,btable b, ctable c where
 b.bid=c.bid and c.aid = a.aid;


truncate ctable;
truncate atable;
truncate btable;
drop table Btable;
alter table atable add name varchar(20);
alter table btable add name varchar(20);

insert into atable values (1,'one');
insert into btable values (11,'eleven');

insert into ctable values (1,11);
insert into ctable values (1,12);

select a.name,b.name from atable a,btable b, ctable c where b.bid=c.bid and c.aid = a.aid;