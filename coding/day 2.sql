show databases;
SELECT * FROM learningmysql.cars_india_dataset order by MyUnknownColumn;
-- alter table  cars_india_dataset  change column 'sr.no' 'Sr.no' int not null;
select * from cars_india_dataset;

select count(*) as Tot_count, type from cars_india_dataset group by type order by count(*);

select * from cars_india_dataset ;

#SELECT * FROM learningmysql.cars_india_dataset order by MyUnknownColumn;
 
 
select * from cars_india_dataset;
select count(*) as Tot_count, type from cars_india_dataset;
select count(*) as Tot_count, type from cars_india_dataset group by type order by count(*);
select count(*) as Tot_count, type from cars_india_dataset group by type;

select * from cars_india_dataset where Displacement=(select max(Displacement) from cars_india_dataset);

#FK and PK
-- dept table
Create table dept(dept_id int primary key,dept_name varchar(40) not null);

insert into dept values(101,'Finance'),(102,'IT'),(103,'Admin');
insert into dept values(104,'Banking'),(105,'HR'),(106,'cosultant');
select * from dept;

-- employee table
Create table emp(id int Primary key, name varchar(20), 
age int,address varchar(50),dept_id int, foreign key(dept_id) references dept(dept_id));

select * from emp;
desc emp;

insert into emp values(1,'Niraj',22,'Ara,Bihar',101); 
insert into emp values(6,'ayesha',40,'pune',null); 
insert into emp values(2,'Akshay',23,'MH',105),(3,'Rupali',26,'Pune',106),(4,'Madhur',24,'Hadapsar',103),(5,'Nitin',30,'Jalgaon',104); 

#Inner join
select e.id, name, e.age,e.dept_id,d.dept_name from dept d inner join  emp e on e.dept_id=d.dept_id where id=5; 

#Right join
select e.id, name, e.age,e.dept_id,d.dept_name from dept d Right join  emp e on e.dept_id=d.dept_id ;

#left join
select e.id, name, e.age,e.dept_id,d.dept_name from dept d left join  emp e on d.dept_id=e.dept_id  order by id asc;


###Next task
Create table emp1(empid int primary key,name varchar(30),salary int);
Create table dept1(depid int primary key,deptname varchar(30));

Create table org(empid int, foreign key(empid) references emp1(empid), deptid int,foreign key(deptid) references dept1(depid) );


insert into emp1 values(1,'Niraj',500),(2,'Akshay',1000),(3,'Rupali',1500);
insert into dept1 values(101,'IT'),(102,'Data'),(103,'HR');

select * from org;
insert into org values(1,101),(2,102);

select e.name,d.deptname,o.deptid from emp1 e,dept1 d , org o  where e.empid=o.empid and d.depid=o.deptid;