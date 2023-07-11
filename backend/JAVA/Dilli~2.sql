select *from emp

select trunc(round(156.00,-1),-1) from dual;


select empno,ename from emp;

select empno,deptno from emp;

select job from emp;

select *from emp ename='BLAKE';

select empno,ename,sal as salary from emp;

select empo,sal,comm from emp;
select * from emp where ROWNUM <=5; 

select empno,ename,sal as "Annual salary" from emp;

select *from emp where job='MANAGER';

select empno, ename, sal from emp where Hiredate < DATE '1981-04-01';

select *from emp where hiredate<'01-01-81';

 select empno,ename,sal,hiredate from emp where experience >10; 

SELECT Empno, Ename, Job, Mgr, Hiredate, Sal, Comm, Deptno
FROM emp
WHERE job = 'CLERK' AND (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM Hiredate)) > 8;

select empno,ename,sal,job,annual,deptno,comm from(select empno,ename,sal,job,comm,nvl2(comm,(sal+comm)*12,(sal*12)) as annual,deptno from emp)where annual<34000 and deptno=30 and job='SALESMAN' and comm>0 and comm<sal;

select *from emp where sal<3500;

select *from emp where MGR=7839;

select empno,ename,sal "Annual salary" from emp;
--select with expression--
select empno,ename,sal,sal+200 Bonus from emp;

select empno,ename,sal,sal+20 Bonus where sal>3000;


select DISTINCT deptno from emp;

select distinct empno,ename from emp;

select distinct deptno,job from emp;

select distinct deptno,sal,ename from emp;
--adding string litral using' '.Concatination operator is ||
select ename ||'work for'|| mgr "manager Details" from emp;

select ename "manager Deatails" from emp

select ename ||q'[work's for]' || mgr "manager Details" from emp;

describe emp; --gives table structure
desc emp;
--where wil restrict the no.of rows in the table
--values are sentivie 

select empno,ename,sal as salary from emp where ename ='SMITH';
select empno,ename,sal as salary,job from emp where ename ='SMITH' and job='CLERK';
select empno,ename,sal as salary,job from emp where ename ='SMITH' or sal>2500;

select empno,ename,sal as salary,sal+20 Bonus from emp where sal>3000;

select empno,ename,sal as salary,sal*1.5 Bonus$ from emp;
select empno,sal,comm from emp;

select empno,ename,sal,job,comm from emp where COMM>sal ;
select empno,ename,sal,job,comm from emp where sal<=1600 ;
select empno,ename,sal,job,deptno from emp where job='CLERK' or DEPTNO=20 ;

select empno,ename,sal as salary,job from emp where sal between 1000 and 3000;

select empno,ename,sal as salary,job from emp where ename not like 'A%';
-- % is tells as i or more character
--_ only one char
select empno,ename,sal as salary,job from emp where ename like '_A%';
select empno,ename,sal as salary,job from emp where ename like '%N';


select empno,ename,sal as salary,job,deptno from emp where deptno in(10,20);
select empno,ename,sal as salary,job,deptno from emp where deptno not in(10,20);   --if we remove the not the down step is equal to this

select empno,ename,sal as salary,job,deptno from emp where deptno=10 or deptno=20;
select empno,ename,sal as salary,job,deptno from emp where deptno<>10 and deptno<>20;  --<> not equal to

select empno,ename,sal as salary,job,deptno,comm from emp where comm is null;
select empno,ename,sal as salary,job,deptno,comm from emp where comm is not null;

--sorting
select empno,ename,sal as salary,job,deptno,comm from emp order by ename ; --column name in order
select empno,ename,sal as salary,job,deptno,comm from emp order by ename desc; --it wil z to a

select empno,ename en,sal as salary,job,deptno,comm from emp order by 3; --column position in select list
select empno,ename en,sal as salary,job,deptno,comm from emp order by en; --alias name in order by
select empno,ename en,sal as salary,job,deptno,comm from emp where salary>1000 order by en;

select &enae from &etab where &s=&var; --substitution variables
select ename from emp where sal=&val;


select &&enae from &etab where &s=&var; --will prompt only once when varia prefixed with &&

--Functions:

--1)single row functions
    --a)character based
    --b)date based
    --c)number based
    --d)conversion based
    --e)general based(null)
--2)multiple row functions


select lower(ename) from emp;
select upper('hello') from dual; --dual is a dummy table with one cell
select initcap(ename) from emp;

select concat('Sakshi','Shri') from dual;
select length('Sakshi') from dual;
select instr('sakshi','s') from dual;
select length(upper(trim('Dilli '))) from dual;
select ename,substr(ename,1,3) from emp;
select ename,substr(ename,3) from emp;

select replace('ambrtam','am','jj') from dual; --consider the string
select translate('ambrtam','amb','bo4') from dual; --consider the character

select length('  hei  ') from dual;
select length(trim('  hei  ')) from dual;
select lpad('Hello',10,'#') from dual;
select rpad('Hello',10,'#') from dual;

select chr(66) from dual;
select ascii('B') from dual;


select ROUND(45.926,2) from dual;
select ROUND(45.926,1) from dual;
select ROUND(45.926,0) from dual;
select ROUND(45.926,-2) from dual;
select ROUND(45.926,-1) from dual;

select trunc(45.926,2) from dual;
select trunc(45.926,1) from dual;
select trunc(45.926,0) from dual;
select trunc(45.926,-1) from dual;
select trunc(45.926,-2) from dual;
select mod(1600,300) from dual;


select trunc(to_date('16-Jul-21','dd-Mon-yy'),'month') from dual;

select  to_char(sysdate,'MONTH DD, YEAR') from dual;
select  to_char(sysdate,'MON DD, YYYY') from dual;
select  to_char(sysdate,'MON DD, YY DAY') from dual;
select  to_char(sysdate,'dd/mm/yy') from dual;
select  to_char(sysdate,'dd-mm-yy') from dual;
 
select  to_char(sysdate,'ddspth "of" Mon yy') from dual;
 
select  to_char(sysdate,'fmddth "of" Mon yy hh24:mi:ss') from dual;

select to_char(to_date('12-apr-1972'),'ddth "of" Mon YYYY') from dual;
 
select to_char(hiredate,'ddth "of" Mon YYYY') from emp;
 
select to_char(sal,'$99,999.000') from emp;
 
select to_number('1000') from dual;
 
select '10000'||'200' from dual;
select '10000'+'20' from dual;

select ADD_MONTHS(DATE '2016-02-29',1) FROM dual;

select MONTHS_BETWEEN(DATE '2017-07-01', DATE '2017-01-01' from dual;

select NEXT_DAY(DATE '2023-06-02','FRIDAY') from dual;

select LAST_DAY(DATE '2023-06-02') from dual;

NVL(expr1,expr2)   -- if e1=null then e2 else e1
NVL2(expr1,expr2,expr3)  -- if e1=null then  e3 else e2
NULLIF(expr1,expr2)  -- if e1=e2 then null else e1
 
 
select ename,comm,nvl(comm,100) from emp;
 

select ename,comm,nvl2(comm,comm+100,100) from emp;
 
select ename,comm,nullif(comm,300) from emp;

--case works with DB
select ename,job,sal,
      case job WHEN 'MANAGER' THEN SAL*10
               WHEN 'ANALYST' THEN SAL*5
               WHEN 'SSALESMAN' THEN SAL*2
     END "REVISED SALARY"
     from emp;
     
     
--Group function/aggregate function -ignores NULL values     
select sum(sal),count(*),min(sal),max(sal),avg(sal) from emp;
select count(comm),ename from emp;
 select count(nvl(comm,1)) from emp ;
 
 
 --group by clause
 1) The columns in the select list  must be available in the groupby clause
 select job,deptno from emp group by deptno,job;
 
2) The columns in the group by may or maynot available in the select list
 select job from emp group by deptno,job;

 3) Group by clause will not accept alias name
 select deptno dn from emp group by dn;

 4) When the select list has an aggregate function , along with column name , its illegal
 select ename, min(sal) from emp where sal>1000;  --illegal
 
5) The column in the select list within the group function, may or maynot be available in the group by
select min(sal),deptno from emp group by deptno;
 
6) Restrict the no. of rows within groups use having clause.
select min(sal),deptno from emp group by deptno having deptno=20;
 
7) The column in the having clause should be available in the groupby clause
select min(sal),deptno from emp group by deptno,sal having sal>1000;
select min(sal),deptno from emp group by deptno,sal having deptno>20;
 
8) The column in the having clause within the aggregate/group function  may or maynot be there in group by clause
select min(sal),deptno from emp group by deptno having min(sal)>900;
 
9) having clause wont acccpt alias name
select min(sal),deptno  from emp group by deptno dn having dn=30; -- illegal
 
10) sequence  -- select from where , group by, having, order by
select min(sal),deptno from emp where sal>=950 group by deptno having min(sal)>900 order by deptno;
 
11) where clause will not accept group function
select sal,deptno from emp where min(sal)>=950  -- illegal


--Joins
---------
  -- TO retrive columns from more than one table
  -- Types:
         -- Natural join
         -- Equi join/inner join
         -- Outer join -- fetch the matched entries from both table and also unmatched
               -- Left outer join
               -- Right outer join
               -- Full outer join
        -- self join  - joining the table with itself
        -- cross join - cartisean product axb

Oracle Properatory syntax
ANSI std syntax


Natural join  --  it is a type of equi join where the equality condition is taken implicity
--column used in NATURAL join cannot have qualifier
select ename,job,sal,deptno,dname from emp  natural join dept  where job ='MANAGER' ;
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e natural join dept d;
select ename,job,sal,deptno,did,dname from emp  natural join department


--Where clause shd be given after join condition. Dont use qualifier when you use using clause.
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  join dept d using(deptno);
select ename,job,sal,deptno,dname from emp join dept using(deptno) where job like 'MANAGER';


select e.ename,e.job,e.sal,d.deptno,d.dname from emp e inner join dept d on e.deptno=d.deptno
where job like 'MANAGER' order by ename;

-- For applying the join condition use on NOT where.
select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  join dept d on e.deptno=d.deptno where job like 'MANAGER';

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  join dept d on e.deptno>20;


select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  full outer join dept d on e.deptno=d.deptno;

select m.ename || '  is the manager of  ' || e.ename "Manager Details" from emp  e join emp m
on  m.empno = e.mgr;

select e.ename,e.deptno,d.dname from emp e cross join dept d;

---------------------------------
--Subquery

Inner Query -- sub query
Outer query

The result the inner query is passed as a value to the outer query
subquery will execute only once*
The result of subquery is passed as the input to the outer query.

Single row subquery -- one value/cell
Multiple row subquery -- multiple row
Multiple column subquery -- mutiple columns
Co-related subquery --

1) Write a query to find the salary of the employees whose salary is greater than the salary of the employee
whose id is 7566?
select ename,sal from emp where sal>(select sal from emp where empno=7566);

2) Write a query to find the employees who all are earning the highest salary?
select ename,sal from  emp where sal = (select max(sal) from emp);

second highest salary?
select max(sal) from  emp where sal< (select max(sal) from emp);

Multiple row subquery:
-- operators used here is IN , ANY, ALL

ANY and ALL shd be prefixed with any of the relational operator like < >, >+ ....

<ANY   => <MAX
> ANY => >MIN
=ANY  => IN
>ALL  =>  >MAX
<ALL  =>  <MIN

1) Write a query to find the employees whose salary is equal to the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal in(select distinct sal from emp where deptno=30);

2) Write a query to find the employees whose salary is greater than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal >ANY(select sal from emp where deptno=30);

select sal from emp where deptno=30;

3) Write a query to find the employees whose salary is less  than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ANY(select sal from emp where deptno=30);


4) Write a query to find the employees whose salary is less  than the salary of all of the employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ALL(select sal from emp where deptno=30);

Multiple Column subquery:
select empno,ename,mgr,deptno from emp where (mgr,deptno) in
(select mgr,deptno from emp where empno in(7566,7788));


7566  7839
select mgr,deptno from emp where empno in(7566,7788)

Corelated subquery:
-----------------------
-- For each and every excution of the subquery , the outer query will be executed.
-- The sub query is executed for each row of the main query.

select ename , (select d.dname from dept d where d.deptno =e.deptno) dname from emp e;

1.Write a query to list the department names which have at least one employee.

select dname from dept d where not exists (select 1  from emp e where e.deptno=d.deptno);

__________________________________________________________________________

Set operator
-------------------
to merge the result of 2 queries

union  - returns all distinct rows selected by either query
union all -  returns all  rows selected by either query incl. duplicated
intersect - returns all distinct wows selected by both queries
minus  -- returns all distinct rowsselected by the first query but not the second

select deptno from emp union select deptno from dept;
select deptno from emp union all select deptno from dept;
select deptno from emp intersect select deptno from dept;
select deptno from dept minus select deptno from emp;

Index:
  -- improve speed while searching
  
   -- index automatically once Primary key constraint is enabled
   -- By defaut b-tree index
  Types:
    -- Btree    -- tree  -- lot of values
    -- Bitmap  -- table -- values are limited(gender)
    
    create index emp_index on emp(ename) compress;   -- btree
    drop  index emp_index;
    create bitmap index emp_index on emp(ename) compress;
    
    
 SELECT * FROM DICTIONARY ORDER BY TABLE_NAME;   -- to fetch all the data dictionary tables

desc User_TABLES
select * from user_tables where TABLE_NAME like 'E%';

desc all_indexes;
select INDEX_NAME, INDEX_TYPE,COMPRESSION from all_indexes where TABLE_NAME='EMP';

When rebuild of index is necessary?
1) High framentation  -- many insert,update, delete
2) Query performance is low
3) Index corruption
4) Database migration or upgrade
5) Bulk data loading







DDL , DML
-----------------
drop table memp;
create table memp(eno number(5),ename varchar2(10),sal number(20));

desc memp;

insert into memp values(10,'Ram',1000);
insert into memp values(20,'Ravi',2000);
savepoint A;
insert into memp values(30,'Akhil',3000);
savepoint B;
insert into memp(eno,ename) values(40,'Asha');
savepoint C;
update memp set sal=4500 where eno=40;
rollback to C;
delete from memp where eno=40 ;
update memp set sal=5000 where eno=40;
commit;



select * from memp;
rollback;
desc memp
alter table memp add phone number(5);
alter table memp modify phone number(10);
alter table memp drop column phone;
select * from memp;

truncate table memp;
alter table memp rename column phone to mobile;

delete from memp where eno=30;

Transaction : TCL
--- Begins with DML
--- Ends with TCL - commit,rollback ,savepoint(bookmark)
-- All the DDL stmt will have auto commit.
-- All DML requires explicit commit.
-- After commit rollback will not work
-- After commit savepoints will be deleted.

-------------------------------------------------
DCL

create role chiru identified by chiru;

Other DB Objects

view:
drop view myview;
create or replace view myview as select empno,ename,sal,deptno from emp;

select * from myview;

desc chiruview;
drop table gurutab;
create or replace force  view chiruview as select no,name from gurutab;
create table gurutab(no number, name varchar2(10));
insert into gurutab values(1,'asd');
insert into gurutab values(2,'asdf');
select * from chiruview;

insert into chiruview values(3,'hello');

create table abctab(dob number(5), mgr number(5));
insert into abctab values(11,222);
insert into abctab values(12,999);
select * from abctab;

create or replace  view chiruview as select max(a.dob),min(g.no) from gurutab g join abctab a on g.no<a.dob;
select * from chiruview;

create or replace view mview as select empno, ename,deptno from emp where deptno=20
with read only constraint wro_mview; 

insert into mview (empno,ename,deptno) values(4446,'Sharuk',30);
select * from mview;

create sequence mphseq
  increment by 1
  start with 1
 maxvalue  10
 nocycle
 nocache;
 
 alter sequence mphseq
  maxvalue  10
 cycle
 cache 5 ;
 
 desc tab2;
 
 create table tab2(empno number(5),ename varchar2(10),deptno number(5));
 insert into  tab2(empno,ename,deptno) values(mphseq.NEXTVAL,'Sharuk',30);
 
 select * from tab2;
 
constrainst:
Primary key    --  NO null, NO duplicates
Unique key   -- No duplicates, accepts null
Notnull          -- No Null, accepts duplicates  cant give at the table level
check           -- only constraint with exptression 
foreign key - to cfreate r/s among tables


2types
Table level contr
Column level contr

drop table employee2;

create table dept2(dno number(5) constraint dep2_pk_dno primary key,dname varchar2(10));

create table employee2(empno number(5) constraint emp2_pk_empno primary key, ename varchar2(10) not null,phone number(5) unique,  
sal number(5), deptno number(5), constraint emp2_ck_sal check(sal>5000), 
constraint emp2_fk_deptno foreign key(deptno) references dept2(dno));

insert into employee2 values(1,'Raja',4444,6000,10);
insert into employee2 values(2,'Raja',4444,6000);

insert into dept2 values(10,'IT');

select * from employee2;



Data dictionary  -- meta data table
     user_
     all_
     dba_

desc user_tables;
desc user_constraints;

select * from emp;

 

--05-06-2023
--Joins      -- To retrieve data from more than one table

---------
Oracle Properitory syntax
ANSI std(followed now)

Types
1) Natural join
2) Inner Join / equi join
3) Non-equi join
3) Outer Join
      -- Left outer join
      -- right outer join
      -- full outer join
4) self join
5) cross join




Natural join  --  it is a type of equi join where the equality condition is taken implicity
--column used in NATURAL join cannot have qualifier

select ename,job,sal,deptno,dname from emp natural join dept;
select e.ename,e.job,e.sal,d.deptno,d.dname from emp e natural join dept d;  -- illegal

--Where clause shd be given after join condition. 
select e.ename,e.job,e.sal,e.deptno,d.dname from emp e join dept d using(deptno) where job like 'SALESMAN';  --illegal  USING clause cannot have qualifier

-- For applying the join condition use on NOT where.
select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  join dept d on e.deptno=d.deptno 
where job like 'MANAGER'; --Qualifiers are mandatory.

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  join dept d on e.deptno>20;

 

 

select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  full outer join dept d on e.deptno=d.deptno; --full outer join

select m.ename || '  is the manager of  ' || e.ename "Manager Details" from emp  e join emp m
on  m.empno = e.mgr;   --self join

select e.ename,e.deptno,d.dname from emp e cross join dept d; --cross join

 

 

-----REFER NEW FILE-----

 

 

CREATE TABLE Orders(orderNumber number(5) NOT NULL,paymentState VARCHAR(12),creationTime DATE,totalAmount number(5),PRIMARY KEY (orderNumber)
);

 

CREATE TABLE Customers(custId number(5)NOT NULL,cname VARCHAR(20),phone VARCHAR(20),PRIMARY KEY(custId));

 

CREATE TABLE Products(prodId number(5) NOT NULL,pname VARCHAR(20),price number(5),PRIMARY KEY(prodId));

 

CREATE TABLE OrderDetail(orderNumber number(5) NOT NULL,prodId number(5) NOT NULL,
            FOREIGN KEY(orderNumber) REFERENCES Orders(orderNumber),
            FOREIGN KEY(prodId) REFERENCES Products(prodId));

insert into Products values(101,'Watch',2000);
insert into Products values(102,'Laptop',40000);
insert into Products values(103,'Mobile',8000);
insert into Products values(104,'Teddy',1000);
insert into Products values(105,'Dress',1500);

 

select * from Products;

 

insert into Customers values(11,'Priya',9876543210);
insert into Customers values(12,'Shiva',8765432109);
insert into Customers values(13,'Lalitha',7654321098);
insert into Customers values(14,'Prem',9874563210);
insert into Customers values(15,'Vivek',98765432211);

 

select * from Customers;

 

insert into Orders values(1,'Success','15-05-2022',2000,11);
insert into Orders values(2,'Success','05-12-2022',40000,12);
insert into Orders values(3,'Failed','21-09-2022',5000,13);
insert into Orders values(4,'Failed','25-07-2023',6000,14);
insert into Orders values(5,'Success','19-01-2022',4000,14);
select * from Orders;

 

alter table Orders add custId number(5) NOT NULL;

 

alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customers(custId);
desc Orders;

 

insert into OrderDetail values(1,101);
insert into OrderDetail values(1,102);
insert into OrderDetail values(2,101);
insert into OrderDetail values(3,102);
insert into OrderDetail values(4,104);
insert into OrderDetail values(5,105);

 

select * from OrderDetail;

 

drop table OrderDetail;
drop table Orders;
drop table Customers;
drop table Products;

 


--06-06-2022

 

1) Write a query to find the salary of the employees whose salary is greater than the salary of the employee
whose id is 7566?
select ename,sal from emp where sal>(select sal from emp where empno=7566);

2) Write a query to find the employees who all are earning the highest salary?
select ename,sal from  emp where sal = (select max(sal) from emp);

second highest salary?
select max(sal) from  emp where sal< (select max(sal) from emp);


 

Multiple row subquery:

 

-- operators used here is IN , ANY, ALL

<ANY   => <MAX
> ANY => >MIN
=ANY  => IN
>ALL  =>  >MAX
<ALL  =>  <MIN

1) Write a query to find the employees whose salary is equal to the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal in(select sal from emp where deptno=30);

2) Write a query to find the employees whose salary is greater than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal >ANY(select sal from emp where deptno=30);

select sal from emp where deptno=30;

3) Write a query to find the employees whose salary is less  than the salary of atleast one employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ANY(select sal from emp where deptno=30);


 

4) Write a query to find the employees whose salary is less  than the salary of all of the employee in depart 30?
select empno,ename,deptno,sal from emp where sal <ALL(select sal from emp where deptno=30);
has context menu

 

 

Multiple Column subquery:
select empno,ename,mgr,deptno from emp where (mgr,deptno) in
(select mgr,deptno from emp where empno in(7566,7788));

select mgr,deptno from emp where empno in(7566,7788)

Corelated subquery:
-----------------------
-- For each and every excution of the subquery , the outer query will be executed.
-- The sub query is executed for each row of the main query.

select ename , (select d.dname from dept d where d.deptno =e.deptno) DEPTNAME from emp e;

1.Write a query to list the department names which have at least one employee.

select dname from dept d where not exists (select 1  from emp e where e.deptno=d.deptno);

 

SELECT 'asha' FROM dual;

 

select * from emp;

 

Transaction : TCL
--- Begins with DML
--- Ends with TCL - commit,rollback ,savepoint(bookmark)
-- All the DDL stmt will have auto commit.
-- All DML requires explicit commit.
-- After commit rollback will not work
-- After commit savepoints will be deleted.

 

 

--------------------PL/SQL----------------
SET SERVEROUTPUT ON 
Pgm1:
BEGIN 
    DBMS_OUTPUT.PUT_LINE('wELCOME');
    END;
/

 

------
SET SERVEROUTPUT ON 
Pgm1:
DECLARE 
    x number:=10;
    nam varchar2(20):='Asha';
BEGIN 
    DBMS_OUTPUT.PUT_LINE(x||'---'||nam);
    END;
/

 

------------------

 

--pgm 3:Label and scope,nested blocks

 

<<outerr>>
declare
    x  number :=100;
begin
<<inner>>
     declare
            x  number :=200;
     begin
              dbms_output.put_line('  From inner block  ' ||x);
              dbms_output.put_line('  From inner block  ' ||outerr.x);    -- right
    end;
            dbms_output.put_line('  From outer block  ' ||x);
           --dbms_output.put_line('  From outer block  ' ||inner.x);      -- error
end;
/

 

------------------------------------
pgm 4:

Variable : Place holder with a name
Types of variables:
1) Scalar var      ----   hold only one value/cell
2) Composite variable  -- hold one record

Non-plsql variable:
---------------------------
3) Bind variable   --> prefixed with colon  :


 

declare
   v_name varchar2(25);
   v_job varchar2(20);
begin
     select ename,job into v_name,v_job from emp where empno=7369;
      dbms_output.put_line(v_name||' '|| v_job);
end;
/

Early Binding- The code is compiled prior to execution(plsql follows)
Lazy Binding- The code is compiled at execution



variable v_ename varchar2;

 

begin
     select ename into :v_ename from emp where empno=7369;     
end;
/
print v_ename;

---------------------------------------------
if then else
----------------
declare 
     salary number(8);
begin 
    salary :=&saly;
    if(salary <7000) then
        salary := salary+4000;
       dbms_output.put_line(' Salary now : ' ||salary);    
    elsif salary >10000 then
         dbms_output.put_line(' Salary now : ' ||salary);   
    else
       salary := salary+1000;
       dbms_output.put_line(' Salary now : ' ||salary);   
    end if;
end;
/
switch(choice){
  case 1:
  {

 

  }
  case 2:

 

  default:
}


 

declare 
   grade char(3) := upper('&g');
   choice varchar2(20);
begin
    choice :=
     CASE grade
         when 'A' then 'Excellent'         
         when 'B' then 'Good'
         when 'C' then 'FAIR'
         else 'No such grade'
      end;
       dbms_output.put_line(' Grade  : ' ||grade || '  -------  ' || choice);   
end;
/

Loops:
---------
1) for
2) loop

for (int i=0;i<=10;i++)

begin
   for i in 1..10   loop
       dbms_output.put_line(' i  : ' || i);   
   end loop;
end;
/

declare 
   x number :=0;
begin
    loop
       dbms_output.put_line(' x : ' || x);  
       x:=x+1;
       if x=5 then exit;
       end if;    
    end loop;
end;
/

-------------------------------------------------------------
CREATE TABLE Orders(orderNumber number(5) NOT NULL,paymentState VARCHAR(12),creationTime DATE,totalAmount number(5),PRIMARY KEY (orderNumber)
);
CREATE TABLE Customers(custId number(5)NOT NULL,cname VARCHAR(20),phone VARCHAR(20),PRIMARY KEY(custId));


CREATE TABLE Products(prodId number(5) NOT NULL,pname VARCHAR(20),price number(5),PRIMARY KEY(prodId));


CREATE TABLE OrderDetail(orderNumber number(5) NOT NULL,prodId number(5) NOT NULL,
			FOREIGN KEY(orderNumber) REFERENCES Orders(orderNumber),
			FOREIGN KEY(prodId) REFERENCES Products(prodId));
            
insert into Products values(101,'Watch',2000);
insert into Products values(102,'Laptop',40000);
insert into Products values(103,'Mobile',8000);
insert into Products values(104,'Teddy',1000);
insert into Products values(105,'Dress',1500);

select * from Products;

insert into Customers values(11,'Priya',9876543210);
insert into Customers values(12,'Shiva',8765432109);
insert into Customers values(13,'Lalitha',7654321098);
insert into Customers values(14,'Prem',9874563210);
insert into Customers values(15,'Vivek',98765432211);
select * from Customer;

insert into Orders values(1,'Success','2022-05-15',2000);
insert into Orders values(2,'Success','2023-01-15',40000);
insert into Orders values(3,'Failed','2022-07-11',5000);
insert into Orders values(4,'Failed','2022-09-07',6000);
insert into Orders values(5,'Success','2021-03-21',4000);
select * from Orders;



alter table Orders add custId number(5) NOT NULL;


alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customer(custId);
desc Orders;
alter table Orders drop column custId;
truncate table Orders;
drop table OrderDetail;

alter table Orders add custId number(5) NOT NULL;
alter table Orders add constraint fk_cust_orders FOREIGN KEY(custId) REFERENCES Customer(custId);
/*insert into orders table now*/
insert into Orders values(1,'Success','2022-05-15',2000,11);
insert into Orders values(2,'Success','2023-01-15',40000,11);
insert into Orders values(3,'Failed','2022-07-11',5000,12);
insert into Orders values(4,'Failed','2022-09-07',6000,14);
insert into Orders values(5,'Success','2021-03-21',4000,15);

select * from Orders;

/*Create Order Details table*/
drop table OrderDetail;
CREATE TABLE OrderDetail(orderNumber number(5) NOT NULL,prodId number(5) NOT NULL,
			FOREIGN KEY(orderNumber) REFERENCES Orders(orderNumber),
			FOREIGN KEY(prodId) REFERENCES Products(prodId));
insert into OrderDetails values(1,101);
insert into OrderDetails values(1,102);
insert into OrderDetails values(2,101);
insert into OrderDetails values(3,102);
insert into OrderDetails values(4,104);
insert into OrderDetails values(5,105);

select * from OrderDetails;

ALTER TABLE `table_name`
	DROP FOREIGN KEY `id_name_fk`;
-- -------
-- Natural Join
SELECT * FROM Orders NATURAL JOIN Products NATURAL JOIN Customer;
SELECT custId, orderNumber FROM Customer INNER JOIN Orders USING (custID);
SELECT c.custId,cname, orderNumber FROM Customer c INNER JOIN Orders o ON c.custId = o.custId;
SELECT c.custId,cname, orderNumber,paymentState FROM Customer c LEFT OUTER JOIN Orders o 
   ON c.custId = o.custId where c.custId=13;
  -- where paymentState='Success';
  
  /*Evaluation order
Multiple joins in a query are evaluated left-to-right in the order that you write them, 
unless you use parentheses to force a different evaluation order. */
SELECT c.custId,cname, orderNumber,paymentState FROM Customer c CROSS JOIN Orders o ;

use training2;
select m.ename "Manager" , e.ename 
from emp e join emp m
on e.mgr =m.empno;

use mydb;

-- Return a list of all orders and their associated product items.
SELECT Orders.*, Products.*
FROM Orders 
JOIN OrderDetail
ON Orders.orderNumber = OrderDetail.orderNumber
JOIN Products
ON OrderDetail.prodId = Products.prodId;

-- Return the orderid of any order that includes Laptop.
SELECT o.orderNumber,p.pname
FROM Orders AS o JOIN OrderDetail AS od
ON o.orderNumber = od.orderNumber
JOIN Products AS p
ON od.prodId = p.prodId
WHERE p.pname = 'Laptop';

-- Write a query to return the name of every product included in an order alongside the number of times 
-- it has been ordered.  Sort the results by product name, ascending.

SELECT p.pname, COUNT(od.prodId)
FROM Products AS p JOIN OrderDetail AS od
ON p.prodId = od.prodId
GROUP BY p.pname
ORDER BY p.pname ASC;

/*to return the name of any customer who ordered fries. Return this in a column called 
'Customers who like Laptop'. 
Don't repeat the same customer name more than once in the results.
*/

SELECT DISTINCT c.cname AS "Customers who like Laptop"
FROM Customer AS c JOIN Orders as o
ON c.custId = o.custId
JOIN OrderDetail AS od
ON o.orderNumber = od.orderNumber
JOIN Products AS p
ON od.prodId = p.prodId
WHERE p.pname = 'Laptop';
/*
To get the names of the customers who have ordered the same products as a given customer,
 you can use a self-join on the orders table and join it with the products and customers tables 

SELECT DISTINCT c.cname,p.pname
FROM OrderDetail o1
JOIN OrderDetail o2 ON o1.orderNumber = o2.orderNumber AND o1.prodId<> o2.prodId
JOIN Orders o ON o.custId=c.custId
JOIN Products p ON p.prodId=o2.prodId
JOIN customer c ON c.custId = o.custId
WHERE o.custId = 12;
*/








