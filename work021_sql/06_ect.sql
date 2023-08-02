-- 대량의 샘플데이터 생성
-- CTAS (Create Table AS Select)
-- emp / dept 원본 데이터의 데이터를 그대로 샘플로 받아와서 새로운 테이블을 생성
SELECT * FROM emp;

-- emp1 테이블 생성
CREATE TABLE emp1
AS
(SELECT * FROM emp);

-- emp2 테이블 생성
CREATE TABLE emp2
AS 
(SELECT empno, ename, sal, deptno FROM emp);

-- emp3 테이블 생성
CREATE TABLE emp3
AS
(SELECT empno, ename, sal, deptno FROM emp WHERE deptno = 10);

-- INSERT / DELETE / UPDATE
SELECT empno, ename, sal, deptno FROM emp3;

-- 1.INSERT
INSERT INTO emp3 (empno, ename, sal, deptno) VALUES(1111, 'JAMES', 2800,20);

-- 2.UPDATE :: 1111 사번의 사원의 정보를 수정/2800-->2900, 20->10
-- EMPNO(PK) 칼럼은 수정의 대상이 아니다... PK를 제외한 나머지 컬럼이 수정의 대상이 된다.
UPDATE emp3 SET ename='JAMES',sal=2900, deptno=10 WHERE empno=1111;

-- 3.DELETE :: 1111 사번을 가진 사원을 삭제  
-- 1) where 부여 2) where 지정 안하는 경우
-- WHERE절 없으면 전체 레코드 삭제 
DELETE emp3 WHERE empno = 1111; 

-- Suquence 생성
CREATE SEQUENCE ora_seq
START WITH 1
INCREMENT BY 1;

SELECT ora_seq.nextVal FROM dual;//1증가

SELECT ora_seq.currVal FROM dual; //현재 시퀀스값 볼 수 있다.

SELECT ora_seq.nextVal FROM dual;//1증가

CREATE SEQUENCE seq_mymember
START WITH 1
INCREMENT BY 1;

CREATE TABLE mymember(
no number primary key,
name varchar(30));

INSERT INTO mymember (no, name) VALUES(seq_mymember.nextVal, '강감찬');

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