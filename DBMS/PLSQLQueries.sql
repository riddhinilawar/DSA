PLSQL Procedure

DECLARE 
   <declarations section> 
BEGIN 
   <executable command(s)> 
EXCEPTION 
   <exception handling goes here > 
   WHEN exception1 THEN  
      exception1-handling-statements  
    ........ 
   WHEN others THEN 
      exception3-handling-statements 
END;

Variable/Datatype/Constants

Variable Declaration and Initialization

SET SERVEROUTPUT ON;
DECLARE
    NAME VARCHAR(15);
BEGIN
    NAME := 'Hello';
    DBMS_OUTPUT.PUT_LINE(NAME);
END;

SET SERVEROUTPUT ON;
DECLARE
    NAME VARCHAR(15) := 'HELLO RIDDHI';
BEGIN
    DBMS_OUTPUT.PUT_LINE(NAME);
END;

Variable Declaration and Initialization through the query

SET SERVEROUTPUT ON;
DECLARE
    NAME VARCHAR(15) := 'HELLO RIDDHI';
BEGIN
    SELECT VALUE INTO NAME FROM TABLEA WHERE PK=1;
    DBMS_OUTPUT.PUT_LINE(NAME);
END;

SET SERVEROUTPUT ON;
DECLARE
    FNAME VARCHAR(15);
    LNAME VARCHAR(15);
BEGIN
    SELECT FIRSTNAME, LASTNAME INTO FNAME,LNAME FROM EMPLOYEE WHERE EMPLOYEEID=1;
    DBMS_OUTPUT.PUT_LINE(FNAME ||' '||LNAME);
END;

Anchored Datatype:  Data type which you assign to a variable based on a database object.

Syntax: VariableName TableName.ColumnName%TYPE 

SET SERVEROUTPUT ON;
DECLARE
    FNAME EMPLOYEE.FIRSTNAME%TYPE;
    LNAME EMPLOYEE.LASTNAME%TYPE;
 
BEGIN
    SELECT FIRSTNAME, LASTNAME INTO FNAME,LNAME FROM EMPLOYEE WHERE EMPLOYEEID=1;
    DBMS_OUTPUT.PUT_LINE(FNAME ||' '||LNAME);
END;

CONSTANTS

Syntax: Constant-Name CONSTANT Datatype(datatype-width) := value
Initialization of constants should be done in the DECLARE Section only.

SET SERVEROUTPUT ON;
DECLARE
    PI CONSTANT NUMBER(7,6) :=3.141592;
BEGIN
    DBMS_OUTPUT.PUT_LINE('PI VALUE: '||PI);
END;

DEFAULT & NOT NULL

SET SERVEROUTPUT ON;
DECLARE
    PI CONSTANT NUMBER(7,6) NOT NULL DEFAULT 3.141592;
BEGIN
    DBMS_OUTPUT.PUT_LINE('PI VALUE: '||PI);
END;

Conditional Statements



IF-THEN

SET SERVEROUTPUT ON;
DECLARE
  num NUMBER := 9;
BEGIN
IF num < 10 THEN
 DBMS_OUTPUT.PUT_LINE('Inside The IF');
 END IF;
 DBMS_OUTPUT.PUT_LINE('outside The IF');
END;

IF-THEN-ELSE

SET SERVEROUTPUT ON;
DECLARE
 v_num    NUMBER := &enter_a_number;
BEGIN
 IF MOD (v_num, 2) = 0 THEN
 DBMS_OUTPUT.PUT_LINE (v_num || ' Is Even');
ELSE
 DBMS_OUTPUT.PUT_LINE (v_num ||' is odd');
END IF;
 DBMS_OUTPUT.PUT_LINE ('IF THEN ELSE Construct complete ');
END;

IF-ELSIF-ELSE

DECLARE
 v_Place VARCHAR2(30) := '&Place';
BEGIN
 IF v_Place = 'Metropolis' THEN
 DBMS_OUTPUT.PUT_LINE('This City Is Protected By Superman');
ELSIF v_Place = 'Gotham' THEN
 DBMS_OUTPUT.PUT_LINE('This City is Protected By Batman');
ELSIF v_Place = 'Amazon' THEN
DBMS_OUTPUT.PUT_LINE('This City is protected by Wonder Woman');
ELSE
DBMS_OUTPUT.PUT_LINE('Please Call Avengers');
END IF;
DBMS_OUTPUT.PUT_LINE('Thanks For Contacting us');
END;

Loops

SIMPLE LOOP

SET SERVEROUTPUT ON;
DECLARE
  v_counter   NUMBER :=0;
  v_result  NUMBER;
BEGIN
  LOOP
  v_counter := v_counter+1;
  v_result := 19*v_counter;
  DBMS_OUTPUT.PUT_LINE('19'||' x '||v_counter||' = '|| v_result);
    IF v_counter >=10 THEN
        EXIT;
    END IF;
  END LOOP;
END;

SET SERVEROUTPUT ON;
DECLARE
  v_counter   NUMBER :=0;
  v_result  NUMBER;
BEGIN
  LOOP
  v_counter := v_counter+1;
  v_result := 19*v_counter;
  DBMS_OUTPUT.PUT_LINE('19'||' x '||v_counter||' = '|| v_result);
  EXIT WHEN v_counter>=10;
  END LOOP;
END;

While Loop

SET SERVEROUTPUT ON;
DECLARE
  v_counter  NUMBER :=1;
  v_result NUMBER ;
BEGIN
  WHILE  v_counter <= 10
LOOP
  v_result := 9  *v_counter;
  DBMS_OUTPUT.PUT_LINE('9'||' x '||v_counter||' = '||v_result);
  v_counter  := v_counter+1;
END LOOP;
DBMS_OUTPUT.PUT_LINE('out');
END;

SET SERVEROUTPUT ON;
DECLARE
  v_test BOOLEAN := TRUE;
  v_counter NUMBER  := 0;
BEGIN
  WHILE v_test LOOP
  v_counter := v_counter+1;
  DBMS_OUTPUT.PUT_LINE( v_counter );
    IF v_counter = 10 THEN
      v_test := FALSE;
    END IF;
END LOOP;
DBMS_OUTPUT.PUT_LINE( 'This Statement is outside the loop and will always execute' );
END;

For Loop

SET SERVEROUTPUT ON;
BEGIN
  FOR v_counter IN 1..10 LOOP
    DBMS_OUTPUT.PUT_LINE(v_counter);
  END LOOP;
END;

SET SERVEROUTPUT ON;
BEGIN
  FOR v_counter IN REVERSE 1..10 LOOP
    DBMS_OUTPUT.PUT_LINE(v_counter);
  END LOOP;
END;

SET SERVEROUTPUT ON;
DECLARE
  v_result  NUMBER;
BEGIN
  FOR v_counter IN  1..10 LOOP
    v_result:= 19*v_counter;
    DBMS_OUTPUT.PUT_LINE(v_result);
  END LOOP;
END;

Triggers

Triggers are used to trigger the events.




Syntax:
CREATE [OR REPLACE] TRIGGER trigger_name
{BEFORE|AFTER} Triggering_event ON table_name
[FOR EACH ROW]
[FOLLOWS another_trigger_name]
[ENABLE/DISABLE]
[WHEN condition]
DECLARE
  declaration statements
BEGIN
  executable statements
EXCEPTION
  exception-handling statements
END;

Uses of Database triggers.
	1. Using database triggers we can enforce business rules that can’t be defined by using integrity constants.
	2. Using triggers we can gain strong control over the security.
	3. We can also collect statistical information on the table access.
	4. We can automatically generate values for derived columns such as auto increment numeric primary key.
	5. Using database triggers we can prevent the invalid transactions.
[bctt tweet=”We can use #Database Triggers to Prevent Invalid Transactions. Read more” username=”Rebellionrider”]
Restriction on The Database Triggers
	1. The maximum size of the database trigger body must not exceed 32,760 bytes. This is because triggers’ bodies are stored in LONG datatypes columns.
	2. A trigger may not issue transaction control statements or TCL statements such as COMMIT, ROLLBACK or SAVEPOINT. All operations performed when the trigger fires, become part of a transaction. Therefore whenever this transaction is rolled back or committed it leads to the respective rolling back or committing of the operations performed. 
	3. Any function or procedure called by a database trigger may not issue a transactional control statement. That is unless it contains an autonomous transaction.
	4. Declaring LONG or LONG RAW variable is not permissible in the body of the trigger.

Dummy Table

CREATE TABLE superheroes (
  sh_name VARCHAR2 (15)
);    

DROP TRIGGER triger_name; - query to drop the trigger

Trigger will invoke befor inserting rows in table

SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER bi_Superheroes
BEFORE INSERT ON superheroes
FOR EACH ROW
ENABLE
DECLARE
  v_user  VARCHAR2 (15);
BEGIN
 SELECT user INTO v_user FROM dual;
 DBMS_OUTPUT.PUT_LINE('You Just Inserted a Row Mr./Miss.'|| v_user); 
END;

INSERT INTO superheroes VALUES ('Ironman');

Trigger will invoke befor modifying rows in table

SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER bu_Superheroes
BEFORE UPDATE ON superheroes
FOR EACH ROW
ENABLE
DECLARE
  v_user  VARCHAR2 (15);
BEGIN
 SELECT user INTO v_user FROM dual;
 DBMS_OUTPUT.PUT_LINE('You Just Modifyed a Row Mr./Miss.'|| v_user); 
END;

UPDATE superheroes SET SH_NAME = 'Superman' WHERE SH_NAME='Ironman';

Trigger will invoke befor deleting rows in table

SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER bd_Superheroes
BEFORE DELETE ON superheroes
FOR EACH ROW
ENABLE
DECLARE
  v_user  VARCHAR2 (15);
BEGIN
 SELECT user INTO v_user FROM dual;
 DBMS_OUTPUT.PUT_LINE('You Just Deleted a Row Mr./Miss.'|| v_user); 
END;

DELETE FROM superheroes WHERE sh_name = 'Superman';

Trigger will invoke befor inserting/updating/deleting rows in table

Predicates : INSERTING, DELETING, UPDATING

SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER tr_superheroes
BEFORE INSERT OR DELETE OR UPDATE ON superheroes
FOR EACH ROW
ENABLE
DECLARE
  v_user  VARCHAR2(15);
BEGIN

  SELECT 
    user INTO v_user FROM dual;
  IF INSERTING THEN
    DBMS_OUTPUT.PUT_LINE('one line inserted by '||v_user);
  ELSIF DELETING THEN
    DBMS_OUTPUT.PUT_LINE('one line Deleted by '||v_user);
  ELSIF UPDATING THEN
    DBMS_OUTPUT.PUT_LINE('one line Updated by '||v_user);
  END IF;
END;

INSERT INTO superheroes VALUES ('Ironman');
UPDATE superheroes SET SH_NAME = 'Superman' WHERE SH_NAME='Ironman';
DELETE FROM superheroes WHERE sh_name = 'Superman';

Table Auditing using DML Triggers

Create Audit Table:

CREATE TABLE sh_audit(
  new_name varchar2(30),
  old_name varchar2(30),
  user_name varchar2(30),
  entry_date varchar2(30),
  operation  varchar2(30)
);

CREATE OR REPLACE trigger superheroes_audit
BEFORE INSERT OR DELETE OR UPDATE ON superheroes
FOR EACH ROW
ENABLE
DECLARE
  v_user varchar2 (30);
  v_date  varchar2(30);
BEGIN
  SELECT user, TO_CHAR(sysdate, 'DD/MON/YYYY HH24:MI:SS') INTO v_user, v_date  FROM dual;
  IF INSERTING THEN
    INSERT INTO sh_audit (new_name,old_name, user_name, entry_date, operation) 
    VALUES(:NEW.SH_NAME, Null , v_user, v_date, 'Insert');  
  ELSIF DELETING THEN
    INSERT INTO sh_audit (new_name,old_name, user_name, entry_date, operation)
    VALUES(NULL,:OLD.SH_NAME, v_user, v_date, 'Delete');
  ELSIF UPDATING THEN
    INSERT INTO sh_audit (new_name,old_name, user_name, entry_date, operation) 
    VALUES(:NEW.SH_NAME, :OLD.SH_NAME, v_user, v_date,'Update');
  END IF;
END;

Pseudo Records (New/Old)
‘:New’ or ‘:Old’ followed by the name of the column of our source table sh_name.
These Psuedo Records helps us in fetching data from the sh_name column of the underlying source table ‘Superheroes’ and storing it into the audit table sh_audit.
Pseudo Record ‘: NEW’, allows you to access a row currently being processed. In other words, when a row is being inserted or updated into the superheroes table. Whereas Pseudo Record ‘: OLD’ allows you to access a row which is already being either Updated or Deleted from the superheroes table.

INSERT INTO superheroes VALUES ('Superman');
UPDATE SUPERHEROES SET SH_NAME = 'Ironman' WHERE SH_NAME='Superman';
DELETE FROM superheroes WHERE SH_NAME = 'Ironman';

Make synchronized backup copy of a table using DML Trigger

Backup table gets automatically populated or updated with the main table simultaneously


Create table without inserting data:  CREATE TABLE superheroes_backup AS SELECT * FROM superheroes WHERE 1=2;

SET SERVEROUTPUT ON;
CREATE or REPLACE trigger Sh_Backup
BEFORE INSERT OR DELETE OR UPDATE ON superheroes
FOR EACH ROW
ENABLE 
BEGIN
  IF INSERTING THEN
    INSERT INTO superheroes_backup (SH_NAME) VALUES (:NEW.SH_NAME);  
  ELSIF DELETING THEN
    DELETE FROM superheroes_backup WHERE SH_NAME =:old.sh_name; 
  ELSIF UPDATING THEN
    UPDATE superheroes_backup 
    SET SH_NAME =:new.sh_name WHERE SH_NAME =:old.sh_name;
  END IF;
END;


INSERT INTO superheroes VALUES ('Superman');
UPDATE SUPERHEROES SET SH_NAME = 'Ironman' WHERE SH_NAME='Superman';
DELETE FROM superheroes WHERE SH_NAME = 'Ironman';

DDL Trigger with Schema Auditing Example

CREATE TABLE schema_audit
  (
    ddl_date       DATE,
    ddl_user       VARCHAR2(15),
    object_created VARCHAR2(15),
    object_name    VARCHAR2(15),
    ddl_operation  VARCHAR2(15)
  );

CREATE OR REPLACE TRIGGER hr_audit_tr 
AFTER DDL ON SCHEMA
BEGIN
INSERT INTO schema_audit VALUES (
sysdate, 
sys_context('USERENV','CURRENT_USER'), 
ora_dict_obj_type, 
ora_dict_obj_name, 
ora_sysevent);
END;

CREATE TABLE RIDDHI(NOTES VARCHAR(100));

System Events
System event triggers come into action when some system event occurs such as database log on, log off, start up or shut down

CREATE TABLE hr_evnt_audit
  (
    event_type VARCHAR2(30),
    logon_date DATE,
    logon_time VARCHAR2(15),
    logof_date DATE,
    logof_time VARCHAR2(15)
  );

CREATE OR REPLACE TRIGGER hr_lgon_audit
AFTER LOGON ON SCHEMA
BEGIN
  INSERT INTO hr_evnt_audit VALUES(
    ora_sysevent,
    sysdate,
    TO_CHAR(sysdate, 'hh24:mi:ss'),
    NULL,
    NULL
  );
  COMMIT;
END;

Logoff and Logon in database to see the record

CREATE OR REPLACE TRIGGER hr_lgof_audit
BEFORE LOGOFF ON SCHEMA
BEGIN
  INSERT INTO hr_evnt_audit VALUES(
    ora_sysevent,
    NULL,
    NULL,
    sysdate,
    TO_CHAR(sysdate, 'hh24:mi:ss')
  );
  COMMIT;
END;

Logoff and Logon in database to see the record


Instead-Of Triggers
Can be used only on views

Instead-of triggers in oracle database provide a way of modifying views that cannot be modified directly through the DML statements. By using Instead-of triggers, you can perform Insert, Update, Delete and Merge operations on a view in oracle database.


Cursors
Cursor is a pointer to a memory area called context area. This context area is a memory region inside the Process Global Area or PGA assigned to hold the information about the processing of a SELECT statement or DML Statement such as INSERT, DELETE, UPDATE or MERGE.

There are two types of cursors in oracle database:
	• Implicit cursor
	• Explicit cursor
Steps for creating an Explicit Cursor.To create an explicit cursor you need to follow 4 steps. These 4 steps are:
	• Declare
	• Open
	• Fetch
	• Close

DECLARE
	CURSOR cursor_name IS select_statement; 
BEGIN
	 OPEN cursor_name;
	 FETCH cursor_name INTO PL/SQL variable [PL/SQL record]; 
CLOSE cursor_name; 
END;

How To Create An Explicit Cursor In Oracle Database

SET SERVEROUTPUT ON;
DECLARE
  v_name VARCHAR2(30);
  --Declare Cursor 
  CURSOR cur_RebellionRider IS 
  SELECT firstname FROM EMPLOYEE
  WHERE EMPLOYEEID < 105;
BEGIN
  OPEN cur_RebellionRider; 
  LOOP 
    FETCH cur_RebellionRider INTO v_name; 
    DBMS_OUTPUT.PUT_LINE (v_name); 
    EXIT WHEN cur_RebellionRider%NOTFOUND; 
  END LOOP;--Simple Loop End
  CLOSE cur_RebellionRider;
END;

Cursor Parameter In Oracle Database

SET SERVEROUTPUT ON;
DECLARE
  v_name VARCHAR2 (30);
  --Declare Cursor 
  CURSOR p_cur_RebellionRider (var_e_id VARCHAR2) IS 
  SELECT firstname FROM EMPLOYEE
  WHERE employeeid < var_e_id;
BEGIN
  OPEN p_cur_RebellionRider (105); 
LOOP 
    FETCH p_cur_RebellionRider INTO v_name; 
    EXIT WHEN p_cur_RebellionRider%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE(v_name );  
  END LOOP;
  CLOSE p_cur_RebellionRider;
END;

How To Create Cursor Parameter With Default Value

SET SERVEROUTPUT ON;
DECLARE
  v_name VARCHAR2 (30);
  --Declare Cursor 
  CURSOR p_cur_RebellionRider (var_e_id VARCHAR2 :=190) IS 
  SELECT firstname FROM EMPLOYEE
  WHERE employeeid < var_e_id;
BEGIN
  OPEN p_cur_RebellionRider ; 
LOOP 
    FETCH p_cur_RebellionRider INTO v_name; 
    EXIT WHEN p_cur_RebellionRider%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE(v_name );  
  END LOOP;
  CLOSE p_cur_RebellionRider;
END;

Cursor FOR Loop In Oracle Database

FOR loop_index IN cursor_name 
	LOOP
		Statements…
	END LOOP;

SET SERVEROUTPUT ON;
DECLARE
 CURSOR cur_RebellionRider IS 
 SELECT firstname, lastname FROM employee
 WHERE employeeid < 200;
BEGIN
  FOR L_IDX IN cur_RebellionRider
  LOOP
    DBMS_OUTPUT.PUT_LINE(L_IDX.firstname||' '||L_IDX.lastname);
  END LOOP;
END;


Cursor For Loop With Parameterized Cursor

SET SERVEROUTPUT ON;
DECLARE
  CURSOR cur_RebellionRider( var_e_id NUMBER) IS 
  SELECT firstname, employeeid FROM employee
  WHERE employeeid < var_e_id;
BEGIN
  FOR l_idx IN cur_RebellionRider(200)
  LOOP
    DBMS_OUTPUT.PUT_LINE(l_idx.employeeid||' '||l_idx.firstname);
  END LOOP;
END;

Record Datatype

Records are composite data structures made up of different components called fields. These fields can have different data types. This means that you can store data of different data types in a single record variable. Similar to the way we define columns in a row of a table.

Types of Record datatype in Oracle database
In Oracle PL/SQL we have three types of Record datatype.
	Table Based Record
	Cursor Based Record, and
	User Defined Record.
	
Variable_ name   table_name%ROWTYPE;
Variable_ name   cursor_name%ROWTYPE;

Table Based Record Datatype

SET SERVEROUTPUT ON;
DECLARE
  v_emp employee%ROWTYPE;
BEGIN
  SELECT * INTO v_emp FROM employee WHERE employeeid = 1;
  DBMS_OUTPUT.PUT_LINE (v_emp.firstname ||' '||v_emp.city);
  DBMS_OUTPUT.PUT_LINE(v_emp.email);
END;


SET SERVEROUTPUT ON;
DECLARE
  v_emp employee%ROWTYPE;
BEGIN
  SELECT firstname INTO v_emp.firstname FROM employee
  WHERE employeeid = 1;
  DBMS_OUTPUT.PUT_LINE (v_emp.firstname);
END;

SET SERVEROUTPUT ON;
DECLARE
  v_emp employee%ROWTYPE;
BEGIN
  SELECT firstname,
    city
  INTO v_emp.firstname,
    v_emp.city
  FROM employee
  WHERE employeeid = 1;
  DBMS_OUTPUT.PUT_LINE (v_emp.firstname);
  DBMS_OUTPUT.PUT_LINE (v_emp.city);
END;


Cursor Based Record Datatype Variable

SET SERVEROUTPUT ON;
DECLARE
  CURSOR cur_RebellionRider
  IS 
  SELECT firstname, city FROM employee 
  WHERE employeeid = 1;
  --Cursor Based Record Variable Declare
  var_emp cur_RebellionRider%ROWTYPE;
BEGIN
  OPEN cur_RebellionRider;
  FETCH cur_RebellionRider INTO var_emp;
  DBMS_OUTPUT.PUT_LINE (var_emp.firstname);
  DBMS_OUTPUT.PUT_LINE (var_emp.city);
  CLOSE cur_RebellionRider;
END;

SET SERVEROUTPUT ON;
BEGIN
  FOR var_emp IN (SELECT firstname, city FROM employee
 WHERE employeeid < 200)
  LOOP
    DBMS_OUTPUT.PUT_LINE(var_emp.firstname||' '||var_emp.city);
  END LOOP;
END; 


User Defined Record Datatype variable

SET SERVEROUTPUT ON;
DECLARE
  TYPE rv_dept IS RECORD(
    f_name  VARCHAR2(20),
    d_name  departments.department_name%type 
  );
  var1 rv_dept;
BEGIN
  SELECT first_name , department_name 
  INTO var1.f_name, var1.d_name
  FROM employees  join departments
  Using (department_id) WHERE employee_id = 100;
  
  DBMS_OUTPUT.PUT_LINE(var1.f_name||' '||var1.d_name);
END;

Functions

There are two types of PL/SQL functions in Oracle Database, these are
	1. Pass-by-Value Functions and
	2. Pass-by-Reference functions

CREATE [OR REPLACE] FUNCTION function_name
(Parameter 1, Parameter 2…)
RETURN datatype
IS
	Declare variable, constant etc.  
BEGIN
	Executable Statements
	Return (Return Value);
END;

PL/SQL function for calculating “Area of the Circle”.

--Function Header
CREATE OR REPLACE FUNCTION circle_area (radius NUMBER) 
RETURN NUMBER IS
--Declare a constant and a variable
pi  	CONSTANT NUMBER(7,2) :=	3.141;
area 	NUMBER(7,2);
BEGIN
  --Area of Circle pi*r*r;
  area := pi * (radius * radius);
  RETURN area; 
END;

Function call - Type 1

SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(circle_area(25));
END;

Function call - Type 2

SET SERVEROUTPUT ON;
DECLARE
AREA NUMBER(7,2);
BEGIN
AREA:= circle_area(25);
DBMS_OUTPUT.PUT_LINE(AREA);
END;

Stored Procedures

CREATE [OR REPLACE] PROCEDURE pro_name (Parameter – List)
IS [AUTHID 	DEFINER | CURRENT_USER]
	Declare statements
BEGIN
	Executable statements 
END procedure name;
/ 

It does not return any value. PLSQL function return some value.

The AUTHID clause is used for setting the authority model for the PL/SQL Procedures. This clause has two flags. DEFINER and CURRENT_USER
As this clause is optional thus in case if you do not use AUTHID clause then Oracle Engine will set the authority (AUTHID) to the DEFINER by default for you. Now, you must be wondering what these DEFINER and CURRENT_USER rights are?
DEFINER right: Definer right is the default right assigned to the procedure by oracle engine. This right means anyone with Execution Privilege on the procedure acts as if they are the owner of the schema in which the privilege is created.   
CURRENT_USER right: Setting the authority level of a stored procedure to the current_user right overrides the default right which is definer and change it to the invoker rights.


SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE Pr_Riddhi IS
  var_name VARCHAR2 (30):= 'Nilawar';
  var_web VARCHAR2 (30) := 'Hitachi.com';
BEGIN
  DBMS_OUTPUT.PUT_LINE('Whats Up Internet? I am '||var_name||' from '||var_web);
END Pr_Riddhi ;

Calling stored procedures -Type 1

EXECUTE Hita;

Calling stored procedures -Type 2
EXEC Hita;

Calling stored procedures -Type 3

BEGIN
    Hita;
END;

Stored Proceduress with parameter
CREATE OR REPLACE PROCEDURE emp_sal( dep_id NUMBER, sal_raise NUMBER) 
IS
BEGIN
  UPDATE emp SET salary = salary * sal_raise WHERE department_id = dep_id;
END;

Packages
A package can hold multiple database objects such as
	• Stored Procedures
	• PL/SQL Functions
	• Database Cursors
	• Type declarations as well as
	• Variables

PL/SQL package is divided into two parts:
	1. The Package Specification, also known as the Header and(required)
	2. The Package Body(optional)

CREATE OR REPALCE PACKAGE BODY pkg_name IS
	Variable declaration;
	Type Declaration;
BEGIN
	Implementation of the package elements…
END [pkg_name];

--Package Header
CREATE OR REPLACE PACKAGE pkg_test IS
  FUNCTION prnt_strng RETURN VARCHAR2;
  PROCEDURE proc_superhero(name VARCHAR2);
END pkg_test;


--Package Body
CREATE OR REPLACE PACKAGE BODY pkg_test IS
  --Function Implimentation
  FUNCTION prnt_strng RETURN VARCHAR2 IS
    BEGIN
      RETURN 'hitachi.com';
    END prnt_strng;
  
  --Procedure Implimentation
   PROCEDURE proc_superhero(name VARCHAR2) IS
     BEGIN
      INSERT INTO superheroes (sh_name) VALUES(name);
     END;
  
END pkg_test;

--Package Calling Function
BEGIN
  DBMS_OUTPUT.PUT_LINE (pkg_test.PRNT_STRNG);
END;


Exception Handling

There are two types of PL/SQL exceptions in Oracle database.
	1. System-defined exceptions and
	2. User-defined exceptions

There are three ways of declaring user-define exceptions in Oracle Database.
	 By declaring a variable of EXCEPTION type in declaration section.
You can declare a user defined exception by declaring a variable of EXCEPTION datatype in your code and raise it explicitly in your program using RAISE statement and handle them in the Exception Section.
	 Declare user-defined exception using PRAGMA EXCEPTION_INIT function.
Using PRAGMA EXCEPTION_INIT function you can map a non-predefined error number with the variable of EXCEPTION datatype.  Means using the same function you can associate a variable of EXCEPTION datatype with a standard error.
	 RAISE_APPLICATION_ERROR method.
Using this method you can declare a user defined exception with your own customized error number and message.
Declaring a user-define exception using Exception variable is a three step process. These three steps are –
	1. Declare a variable of exception datatype – This variable is going to take the entire burden on its shoulders.
	2. Raise the Exception – This is the part where you tell the compiler about the condition which will trigger the exception.
	3. Handle the exception – This is the last section where you specify what will happen when the error which you raised will trigger.

Using Exception method
SET SERVEROUTPUT ON;
DECLARE
  var_dividend NUMBER := 24;
  var_divisor NUMBER := 0;
  var_result NUMBER;
  ex_DivZero EXCEPTION;
BEGIN
  IF var_divisor = 0 THEN
    RAISE ex_DivZero;
  END IF;
  var_result := var_dividend/var_divisor;
  DBMS_OUTPUT.PUT_LINE('Result = ' ||var_result);
  EXCEPTION WHEN ex_DivZero THEN
      DBMS_OUTPUT.PUT_LINE('Error Error - Your Divisor is Zero');
END;

Using Raise Application Error method 

SET SERVEROUTPUT ON;
ACCEPT var_age NUMBER PROMPT 'What is yor age';
DECLARE
  age   NUMBER := &var_age;
BEGIN
  IF age < 18 THEN
    RAISE_APPLICATION_ERROR (-20008, 'you should be 18 or above for the DRINK!');
  END IF; 
  DBMS_OUTPUT.PUT_LINE ('Sure, What would you like to have?'); 
  EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE (SQLERRM);
END;

Using PRAGMA EXCEPTION_INIT function

SET SERVEROUTPUT ON;
DECLARE
  ex_age    EXCEPTION;
  age       NUMBER    := 17;
  PRAGMA EXCEPTION_INIT(ex_age, -20008);
BEGIN
  IF age<18 THEN
    RAISE_APPLICATION_ERROR(-20008, 'You should be 18 or above for the drinks!');
  END IF;
  
  DBMS_OUTPUT.PUT_LINE('Sure! What would you like to have?');
  
  EXCEPTION WHEN ex_age THEN
    DBMS_OUTPUT.PUT_LINE(SQLERRM);   
END;
