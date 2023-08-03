-- 제약조건
-- employee | department 2개를 생성
-- CTAS(제약조건은 안따라온다...)

DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee
AS
(SELECT * FROM emp);

CREATE TABLE department
AS
(SELECT * FROM dept);

-- 테이블 구조 확인
DESC employee;
DESC department;

-- PK(기본키) 제약조건을 테이블에 추가...
-- CTAS로는 제약조건이 적용이 안됨
-- employee, department 테이블에 기본키 제약조건을 추가함...
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

-- FK(외래키) 제약조건을 테이블에 추가(X)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

-- FK(외래키) 제약조건을 테이블에 추가(O) ON DELETE CASCADE
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE employee WHERE empno=7369;
SELECT * FROM employee;

-- 20번 부서를 삭제하더라도 20번 부서에서 근무하는 직원은 그대로이다.
-- 이것은 employee테이블과 department테이블이 연관(Relational)되어져 있지 않기 때문이다.
-- FK제약조건을 추가해야 하는 이유이다.
DELETE department WHERE deptno=20;
SELECT * FROM department;
SELECT * FROM employee;

-- FK제약조건을 추가하면 자식을 가지고 있는 부모 테이블 삭제가 안된다...
-- 해결방법은 자식 레코드를 먼저 삭제한 후, 부모 레코드 삭제를 진행
-- 위와 같은 작업을 그대로 해주는 옵션 ON DELETE CASCADE
-- FK제약조건을 지정할 때 ON DELETE CASCADE 옵션을 함께 지정해야 한다.