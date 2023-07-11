PLSQL : Procedural Language / Structured Query Language
-----------------

declare                         -- OPTIONAL
     -- Declaration block
begin                             -- MANDATORY
     -- executable block
exception                      -- OPTIONAL
    --  exception block

end;                               -- MANDATORY
/                                     -- EXECUTOR

Why PLSQL?
1) Modular code organization
2) Security privileges
3) Integrate with any java,.net Application
4) Extensibility
5) Tool support 




SET SERVEROUTPUT  ON
Pgm1 :
BEGIN
   DBMS_OUTPUT.PUT_LINE('WELCOME');
END;
/                   
Pgm2:
---------
int x=10

:=     assignment operator
||      concatenation operator

declare
    x number :=10;
    nam varchar2(20):='Asha';
begin
    dbms_output.put_line(x ||' -  -  - ' ||nam);
end;
/

pgm 3:  Label and scope, nested blocks
-----------
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
           dbms_output.put_line('  From outer block  ' ||inner.x);      -- error
end;
/

pgm 4:

Variable : Place holder with a name
Types of variables:
1) Scalar var      ----   hold only one value/cell
2) Composite variable  -- hold one record

Non-plsql variable:
---------------------------
3) BInd variable   --> prefixed with colon  :


declare
   v_name varchar2(25);
   v_job varchar2(20);
begin
     select ename,job into v_name,v_job from emp where empno=7369;
      dbms_output.put_line(v_name|| v_job);
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

composite variable
---------------------------

declare 
  type emprec is record(
       vid number(5),
       vname varchar2(20),
       vsal number(8,2));
  
   er  emprec;
begin
  -- er.vid :=100;
 --  er.vname :='John';
 --  er.vsal :=10000;
   
      select empno,ename,sal into er.vid,er.vname, er.vsal from emp where empno=7369;
    dbms_output.put_line(' Id : ' || er.vid);  
     dbms_output.put_line(' Name : ' || er.vname);  
      dbms_output.put_line(' Sal : ' || er.vsal);  
   
end;
/

------------------------------------------------------------
CURSOR: 
--> It is a named memory location which is under the developers control.

What can be done?
--> Load all your records as per your need
->> fetch and work on the records

Steps to be followed:
1) Declare the cursor   --> name the cursor and specifiy the set of records to be loaded in that area
2) open the cursor
3) Fetch records from the cursor
4) Close the cursor.

Cursor attributes:

declare
    eno emp.empno%type;
    enam emp.ename%type;
    job emp.job%type;
    manager emp.mgr%type;
    hdate emp.hiredate%type;
    salry emp.sal%type;
    commn emp.comm%type;
    dno emp.deptno%type;
    cursor mycur is select * from emp where deptno=10;
begin
    if not mycur%ISOPEN then
    open mycur;
    end if;
    loop
    fetch mycur into eno,enam,job,manager,hdate,salry, commn,dno;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(eno || '     ' || enam || '    ' ||dno); 
    end loop;
    close mycur;
end;
/


set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp where deptno=10;
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || emprec.job); 
    end loop;
    close mycur;
end;
/

-----------------------------------------------------
truncate table batch210;
select * from batch210;
----------------------------------------
Exception handling:
  --> Error which occurs during the runtime

declare
  eno emp.empno%type;
  enam emp.ename%type;
  salry emp.sal%type;
  
  v_error_code number(20);
  v_error_msg varchar2(235);
begin
    select empno,ename,sal into eno,enam,salry from emp where empno>&no;
    dbms_output.put_line('Empno :' || eno || ' Emp Name :   ' || enam  || ' Salary :   ' || salry);
    
   -- salry :=salry/0;
    --dbms_output.put_line(' Salary :   ' || salry);
    
   insert into batch210(stid,sname,deptno) values(100,'Karthik',1);
exception
     when NO_DATA_FOUND then
         dbms_output.put_line('Employee Number Does Not Exist :(');
    when ZERO_DIVIDE then
         dbms_output.put_line('Dont divide by 0');
    -- when others then
      --      v_error_code:=SQLCODE;
        --    v_error_msg :=SQLERRM;
          -- dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg);         
end;
/

set verify off;
--The functions SQLCODE and SQLERRM are especially useful in the OTHERS handler
--because they return the Oracle error code and message text. 

-----------------------------------------------------------
User Defined Exception:
-----------------------------------
1) Declare the Exception
2) Raise the exception
3) Handle the exception

declare
    eno emp.empno%type;
    enam emp.ename%type;
    emp_not_found EXCEPTION;   -- Declare
begin
    eno :=&no;
    if eno>9000 then
       RAISE emp_not_found;             -- Raise
    else
       select ename into enam from emp where empno=eno;
        dbms_output.put_line('Ename : '|| enam);
    end if;
exception
     when emp_not_found then            --handle
         dbms_output.put_line('Emp Number  : '|| eno || ' not found ');
end;
/
---------------------------
set serveroutput on
Procedure raise_application_error(error_number, message[, {TRUE | FALSE}]);

where error_number is a negative integer in the range -20000 .. -20999 and 
message is a character string up to 2048 bytes long.

declare
    eno emp.empno%type;
    enam emp.ename%type;
    emp_not_found EXCEPTION;   -- Declare
begin
    eno :=&no;
    if eno>9000 then
       RAISE_APPLICATION_ERROR(-20456,'NOT  A VALID EMPLOYEE NUMBER');             -- Raise
    else
       select ename into enam from emp where empno=eno;
        dbms_output.put_line('Ename : '|| enam);
    end if;
exception
     when emp_not_found then            --handle
         RAISE_APPLICATION_ERROR(-20456,'NOT  A VALID EMPLOYEE NUMBER');  
         dbms_output.put_line('Emp Number  : '|| eno || ' not found ');
end;
/
select * from emp;

---------------------------------------------------------------------
PRAGMA EXCEPTION
------------------------------------

declare
  eno emp.empno%type;
  enam emp.ename%type;
  salry emp.sal%type;
  
  v_error_code number(20);
  v_error_msg varchar2(235);
  Toooooooo_many_rooooows  EXCEPTION;                 -- Declare the exception
  PRAGMA EXCEPTION_INIT(Toooooooo_many_rooooows, -01422);  -- map the name of the exception with error code
  
begin
    select empno,ename,sal into eno,enam,salry from emp where empno>&no;
    dbms_output.put_line('Empno :' || eno || ' Emp Name :   ' || enam  || ' Salary :   ' || salry);    
    
exception
     when Toooooooo_many_rooooows then              --- handle the exception
         dbms_output.put_line('Fetching tooo many employees.');
 
     when others then
            v_error_code:=SQLCODE;
            v_error_msg :=SQLERRM;
           dbms_output.put_line('Plz contact Admin to resolve error with code ' || v_error_code || ' and msg ' ||  v_error_msg);         
end;
/




