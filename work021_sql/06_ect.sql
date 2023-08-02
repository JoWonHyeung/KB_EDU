-- �뷮�� ���õ����� ����
-- CTAS (Create Table AS Select)
-- emp / dept ���� �������� �����͸� �״�� ���÷� �޾ƿͼ� ���ο� ���̺��� ����
SELECT * FROM emp;

-- emp1 ���̺� ����
CREATE TABLE emp1
AS
(SELECT * FROM emp);

-- emp2 ���̺� ����
CREATE TABLE emp2
AS 
(SELECT empno, ename, sal, deptno FROM emp);

-- emp3 ���̺� ����
CREATE TABLE emp3
AS
(SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10);

-- INSERT / DELETE / UPDATE
SELECT empno, ename, sal, deptno FROM emp3;

-- 1.INSERT
INSERT INTO emp3 (empno, ename, sal, deptno) VALUES(1111, 'JAMES', 2800,20);

-- 2.UPDATE :: 1111 ����� ����� ������ ����/2800-->2900, 20->10
-- EMPNO(PK) Į���� ������ ����� �ƴϴ�... PK�� ������ ������ �÷��� ������ ����� �ȴ�.
UPDATE emp3 SET ename='JAMES',sal=2900, deptno=10 WHERE empno=1111;

-- 3.DELETE :: 1111 ����� ���� ����� ����  
-- 1) where �ο� 2) where ���� ���ϴ� ���
-- WHERE�� ������ ��ü ���ڵ� ���� 
DELETE emp3 WHERE empno = 1111; 

-- Suquence ����
CREATE SEQUENCE ora_seq
START WITH 1
INCREMENT BY 1;

SELECT ora_seq.nextVal FROM dual;//1����

SELECT ora_seq.currVal FROM dual; //���� �������� �� �� �ִ�.

SELECT ora_seq.nextVal FROM dual;//1����

CREATE SEQUENCE seq_mymember
START WITH 1
INCREMENT BY 1;

CREATE TABLE mymember(
no number primary key,
name varchar(30));

INSERT INTO mymember (no, name) VALUES(seq_mymember.nextVal, '������');

SELECT * FROM mymember;

/*
work01_JDBC
*/

CREATE SEQUENCE seq_id
START WITH 1
INCREMENT BY 1;

drop sequence seq_id;

truncate table member;

select * from member;