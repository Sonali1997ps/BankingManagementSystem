
delimiter $$
create procedure mypro()
begin
select *from cars_india_dataset;
end $$
call mypro

drop procedure mypro;

#in parameter
delimiter $$
create procedure newpro(in mkr varchar(40))
begin
select *from cars_india_dataset where maker= mkr;
end $$
call newpro('hyundai')
drop procedure newpro;
#out parameter
delimiter $$
create procedure newpro(out param1 varchar(40))
begin
select  count(*) into param1 from cars_india_dataset ;
end $$
call newpro(@tot);
select @tot;

#in out parameter
delimiter $$
create procedure gethundaitotal(in makername varchar(40), out total int)
begin
select  count(*) into total from cars_india_dataset  where maker=makername;
end $$
call gethundaitotal('hyundai', @tot);
select @tot;
 
 delimiter $$
create procedure getsumofseats(in makername varchar(40), out total int)
begin
select  sum(seats) into total from cars_india_dataset  ;
end $$
call getsumofseats('hyundai', @sum);
select @sum;

create procedure getmaxofseats(in makername varchar(40), out total int)
begin
select  max(seats) into total from cars_india_dataset where maker=makername  ;
end $$
call getmaxofseats('hyundai', @sum);
select @sum;

 create table empp(firtsname varchar(40) ,id int primary key);
 insert into empp values('hjk',1),
 ('abc',2),
 ('def',3);
drop table empp;
select *from empp;

delimiter $$
CREATE PROCEDURE sample_sp_no_param ()
BEGIN
UPDATE empp SET `firtsname`= 'ChangedHJK' where id = 1;
END $$
 call sample_sp_no_param ();
 
drop PROCEDURE sample_sp_no_param ;

DELIMITER $$
CREATE PROCEDURE sample_sp_with_params (IN empId INT UNSIGNED, OUT oldName VARCHAR(20), INOUT newName VARCHAR(20))
BEGIN
SELECT `firtsname` into oldName FROM empp where id = empId;
UPDATE empp SET `firtsname`= newName where id = empId;
END $$ 
set @inout='updatedhjks';
call sample_sp_with_params(1,@ab,@inout);
select @out,@inout;

drop PROCEDURE sample_sp_with_params ;

delimiter $$
CREATE PROCEDURE fact(IN x INT)
BEGIN
  DECLARE result INT; #declaration of variable
  DECLARE i INT;
  SET result = 1; #initialization  of variable
  SET i = 1;
  WHILE i <= x DO
    SET result = result * i;
    SET i = i + 1;
  END WHILE;
 SELECT x AS Number, result as Factorial;

END $$

CALL fact(1);
CALL fact(2) ;
CALL fact(4) ;
CALL fact(0) ;

#function

delimiter $$
create function fun(startv int)
returns int deterministic
begin
      declare income int;
      set income =0;
	  label1:while income <= 3000 do 
set income=income+startv ;
end  while label1 ;
return income;
end;
 $$ 
SELECT fun (1000);

drop table accounttt;

delimiter $$
 create function sample()
 returns int 
 deterministic
 begin 
 declare store int;
 select count(*) into store from empp ;
 return store;
 end
 $$
 select sample ();
 
 
 #trigger 
 SET @sum=0;


insert into accounttt values(1,10000.23);
insert into accounttt values(2,20000);

 create table accounttt(acno int, ammount decimal(10,2));
  create trigger tge before insert on accounttt for each row
  set @sum=@sum+new.ammount;
  select @sum;
  
  
CREATE TABLE test1(a1 INT);
CREATE TABLE test2(a2 INT);
CREATE TABLE test3(a3 INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
CREATE TABLE test4(
  a4 INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  b4 INT DEFAULT 0
);

delimiter |

CREATE TRIGGER testref BEFORE INSERT ON test1
  FOR EACH ROW
  BEGIN
    INSERT INTO test2 SET a2 = NEW.a1;
    DELETE FROM test3 WHERE a3 = NEW.a1;
    UPDATE test4 SET b4 = b4 + 1 WHERE a4 = NEW.a1;
  END;
|

delimiter ;

INSERT INTO test3 (a3) VALUES
  (NULL), (NULL), (NULL), (NULL), (NULL),
  (NULL), (NULL), (NULL), (NULL), (NULL);

INSERT INTO test4 (a4) VALUES
  (0), (0), (0), (0), (0), (0), (0), (0), (0), (0);
  
INSERT INTO test1 VALUES 
       (1), (3), (1), (7), (1), (8), (4), (4);

    
select *from test1;
select *from test2;
select *from test3;
