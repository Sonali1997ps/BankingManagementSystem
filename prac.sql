use learningmysql;
desc cars_india_dataset;
select count(type) from cars_india_dataset;
select count(type) from cars_india_dataset group by maker having maker='hyundai';

select count(type) FROM cars_india_dataset where maker='hyundai';
select count(*) from cars_india_dataset where maker ='Hyundai';
select max(sum) from (select count(type) as sum from cars_india_dataset group by type ) t1 ;
select count(type) as sum,maker from cars_india_dataset group by maker order by count(*) ;
#select max(count(type)) from cars_india_dataset where group by count(*);
#select max() from cars_india_dataset where (select count(type) from cars_india_dataset group by type );
select count(maker) as sum,maker from cars_india_dataset group by maker order by count(*) desc limit 1;

###############################################################
select max(sum) from (select count(type) as sum from cars_india_dataset group by type )t1;

create table abc(name varchar(30),id int,salary int) ;
insert into abc values('ayesha',1,20000),('shardha',2,30000),('nilam',3,40000);
show databases;
select * from abc;

create table pqr(name varchar(30),id int,salary int) ;
insert into pqr values('aye',1,20000),('shar',2,30000),('nil',3,40000);
  
alter table abc
add   primary key(id);
ALTER TABLE pqr
ADD  constraint f foreign  KEY (id) REFERENCES abc(id);
select abc.name,pqr.salary from abc right join pqr on abc.id=pqr.id;
