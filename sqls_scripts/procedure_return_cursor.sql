-- PROCEDURE--

-- get employee by id procedure example

create or replace procedure get_employee(
  id_employee in number,  
  pracownik out employees%rowtype)
is
begin
 
  select * into pracownik from hr.employees
    where EMPLOYEE_ID=id_employee;    
 
end;

-- get employees by name procedure with cursor example

create or replace procedure get_employees_by_name(
  imie in varchar2,  
  pracownicy out SYS_REFCURSOR)
is
begin
 OPEN pracownicy for
   select *
   from employees 
   where first_name = imie;  
end;


-- CALL PROCEDURE--

set serveroutput on;

declare 
  pracownik EMPLOYEES%rowtype;
  pracownicy_c SYS_REFCURSOR;
  
begin

GET_EMPLOYEE(144, pracownik);
dbms_output.put_line(pracownik.first_name);

GET_EMPLOYEES_BY_NAME(imie => 'Peter', pracownicy => pracownicy_c);

loop  
    FETCH pracownicy_c INTO  pracownik;
    EXIT WHEN pracownicy_c%NOTFOUND;
    dbms_output.put_line(pracownik.last_name ||' ' ||pracownik.first_name );
end loop;
CLOSE pracownicy_c;

end;