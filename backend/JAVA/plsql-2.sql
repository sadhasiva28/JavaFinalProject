-----------------------------------------------------------------
Named  PLSQL Blocks a.k.a SUB PRograms

1) Procedure
2) Functions

3) Packages
4) Triggers

Procedures:
----------------
set serveroutput on
Modes in procedure:   IN (default), OUT, INOUT

create or replace procedure pro11(num in number)
as
begin
   dbms_output.put_line(' Time Now is :' || num);
end;
/

show errors;


execute pro11(11);
exec pro11(3)

create or replace procedure pro12(num in number,enam out varchar2)
as
begin
   select ename into  enam from emp where empno=num;
   dbms_output.put_line(' Ename is :' || enam);
end pro12;
/
variable nam varchar2(20);
execute pro12(7369,:nam);
print nam;



create or replace procedure pro13(pnum in out varchar2)
as
begin
   pnum := '+91 '||substr(pnum,1,3) || ' - ' || substr(pnum,4,3) || ' - ' || substr(pnum,7) ;   
end pro13;
/

variable phnum varchar2(20);

begin
:phnum:='9845671234';
end;
/

execute pro13(:phnum);

print phnum;

----------------------------------------------

Define procedure within a procedure
       drop table mytracktime;
      create table mytracktime(tno number(5),trackedon date);
        select * from mytracktime;
        
create or replace procedure pro14(num in number,enam out varchar2)
as
   procedure tracktime is                                 -- defining a procedure
   begin
       insert into mytracktime values(mph210seq.nextval,sysdate);
   end;
begin
   select ename into  enam from emp where empno=num;
   tracktime;
   dbms_output.put_line(' Ename is :' || enam);
end pro14;
/
variable nam varchar2(20);
execute pro14(7499,:nam);
print nam;

drop sequence mph210seq;
create sequence mph210seq
  start with 1
  increment by 1
  nocycle
  nocache;

----------------------------------------------------------------------------------------------
Invoking/calling a procedure within a procedure:
----------------------------------------------------------------
create or replace procedure pro1(num in number)
as
begin
     dbms_output.put_line('My Lucky Number :' || num);
end pro1;
/

create or replace procedure pro2(num in number)
as
enm varchar2(10);
begin
   select ename into  enm from emp where empno=num;
   dbms_output.put_line(' Ename is :' || enm);
   pro1(100);     -- invoking a procedure
   
exception
    when NO_DATA_FOUND then
         dbms_output.put_line('Error from Procedure . Employee Number Does Not Exist :( ');
end pro2;
/

variable nam varchar2(20);
execute pro2(7369);
print nam;

drop procedure pro1;

show errors;
------------------------------------------------------------------

create or replace function tax(val  number)
return number
is
begin
    return (val*0.10);
end;
/

select sal,tax(sal) from emp;

Procedure                                         Function
DO NOT return any value             Do Return a value
Has 3 modes, in, out, inout           Has 1 mode, IN

create or replace function empfunc(eno in number)
return number
is
vsal emp.sal%type;
begin
     select sal into vsal from emp where empno=eno;
     return  vsal;  
end;
/

select empfunc(7788) from emp ;

Drop function empfunc;

-------------------------------------------------------
PACKAGES:

--> It will pack related procedures and functions together as a unit.
--> 2 sections
          i) the package specification --> have the proc / func declaration  ---> public in nature
          ii) the package body             --> have the proc /func  definition   ---> private in nature
--> the package spec and body shd be separatly created.
  
 create or replace package emppack
 as
      procedure pro12(num in number,enam out varchar2); 
      function tax(val in number) return number;
 end;
 /
 create or replace package body emppack
 as
    procedure pro12(num in number,enam out varchar2) is
    begin
     select ename into  enam from emp where empno=num;
      dbms_output.put_line(' Ename is :' || enam);
    end pro12;
    
    function tax(val in number) return number
    is
    begin
          return (val*0.10);
    end tax;
end emppack;
 /

variable nam varchar2(20);
execute emppack.pro12(7369,:nam);
print nam;
show errors;

select emppack.tax(sal) from emp;

drop package emppack;
drop package body emppack;
--------------------------------------------------

Eg 3: 		==> overloaded procedures  -- possible only within the package
####

create or replace package emppack 
as
procedure empproc(eno in number,empname out varchar);	
procedure empproc;	
end emppack;
/

create or replace package body emppack as 
empname varchar2(20);
procedure empproc(eno in number,empname out varchar) is
begin
select ename into empname from employee2 where empno=eno;
end;

procedure empproc is
begin
dbms_output.put_line('Overloaded procedure inside the package');
end;
end emppack;

/

exec emppack.empproc;
show errors;
--------------------------------------------
Eg 4:		==> cursor inside a package
#####

CREATE OR REPLACE PACKAGE pack_cur
IS
CURSOR c1 IS SELECT empno FROM emp ORDER BY empno DESC;
PROCEDURE proc1_2rows;
PROCEDURE proc3_5rows;
END pack_cur;
/
CREATE OR REPLACE PACKAGE BODY pack_cur IS
v_empno NUMBER;
PROCEDURE proc1_2rows IS
BEGIN
OPEN c1;
LOOP
FETCH c1 INTO v_empno;
DBMS_OUTPUT.PUT_LINE('Id :' ||(v_empno));
EXIT WHEN c1%ROWCOUNT >= 2;
END LOOP;
END proc1_2rows;

PROCEDURE proc3_5rows IS
BEGIN
LOOP
FETCH c1 INTO v_empno;
DBMS_OUTPUT.PUT_LINE('Id :' ||(v_empno));
EXIT WHEN c1%ROWCOUNT >= 5;
END LOOP;
CLOSE c1;
END proc3_5rows;
END pack_cur;
/

EXECUTE pack_cur.proc1_2rows;
EXECUTE pack_cur.proc3_5rows;


variable nam varchar2(20);
execute emppack.empproc(02,:nam);
exec emppack.empproc;
print nam;


----------------------------------------------------
Triggers:
-------------

--What? A block which gets executed/called automatically when an event(insert, update,delete) occurs

Transaction
   - starts with DML
   - ends with commit/rollback

-- 2 types  
       i) Application trigger
                a) Statement level trigger
                b) Row level trigger
       ii) Database trigger
      iii) Instead of trigger  -- used with views  

CREATE [OR REPLACE ] TRIGGER trigger_name  
{BEFORE | AFTER | INSTEAD OF }          -- timing
{INSERT [OR] | UPDATE [OR] | DELETE}  - event
[OF col_name]                                           --specific columns
ON table_name                                          -- tablename
[REFERENCING OLD AS o NEW AS n]  
[FOR EACH ROW]                                          --- only for row level trigger
WHEN (condition)   
DECLARE 
   Declaration-statements 
BEGIN  
   Executable-statements 
EXCEPTION 
   Exception-handling-statements 
END; 

stmt level trigger

create or replace trigger trig1
before insert on emp
begin
        dbms_output.put_line(' Welcome ');
end;
/
drop trigger trig1

insert into emp(empno,ename) values(8002,'Sakshi');
rollback;
----------------------------------------------

create or replace trigger trig2
before update of sal on emp
FOR EACH ROW
when (new.sal  < old.sal)
begin
        dbms_output.put_line(' Do not decrease the salary ;(  ');
end;
/

update emp set sal=1000;
rollback;
----------------------------------------

Conditional Predicates:
create or replace trigger trig3
before insert or update of sal or delete on emp
begin
        if INSERTING THEN  
             dbms_output.put_line(' YOU ARE INSERTING ');
        elsif DELETING THEN  
             dbms_output.put_line(' YOU ARE DELETING ');
        elsif UPDATING('sal') THEN  
             dbms_output.put_line(' YOU ARE UPDATING SAL ');
        else
              dbms_output.put_line(' Do something  '); 
        end if;
end trig3;
/


delete from emp where empno=8002;
update emp set sal=1500 where empno=8001;
insert into emp(empno,ename) values(8002,'Sakshi');

--------------------------------------

instead of trigger
--------------------------
drop table tab1;
drop table tab2;
create table tab1(eno number, ename varchar2(10), did number(5));
create table tab2(dno number, dname varchar2(10));

insert into tab1 values(1,'Vinitha',10);
insert into tab2 values(10,'IT');
drop view myview;

create or replace view myview as select e.*,d.* from tab1 e , tab2 d where e.did=d.dno;
create or replace view myview as select eno,ename from tab1;
select * from myview;

create or replace trigger trig4
instead of   insert on myview
FOR EACH ROW
begin
        if INSERTING THEN  
             insert into tab1 values(:new.eno,:new.ename,:new.did);
             insert into tab2 values(:new.dno,:new.dname);
       end if;       
end trig4;
/

INSERT INTO MYVIEW VALUES(100,'DIVYA',11,11,'HR');


SELECT * FROM TAB1;
SELECT * FROM TAB2;
SELECT * FROM MYVIEW;
--------------------------------------------
Database trigger:
---------------------------
drop table log_trig_table;
select * from log_trig_table;

create table log_trig_table(user_id varchar2(20), log_date timestamp, action varchar2(30));

create or replace trigger logontrigger
after LOGON ON SCHEMA
begin
    insert into log_trig_table values(user,current_timestamp,'Logging ON');
end;
/

create or replace trigger logofftrigger
before LOGOFF ON SCHEMA
begin
    insert into log_trig_table values(user,current_timestamp,'Logging OFF');
end;
/
select * from log_trig_table

