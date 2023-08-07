-- ��������
-- employee | department 2���� ����
-- CTAS(���������� �ȵ���´�...)

DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee
AS
(SELECT * FROM emp);

CREATE TABLE department
AS
(SELECT * FROM dept);

-- ���̺� ���� Ȯ��
DESC employee;
DESC department;

-- PK(�⺻Ű) ���������� ���̺� �߰�...
-- CTAS�δ� ���������� ������ �ȵ�
-- employee, department ���̺� �⺻Ű ���������� �߰���...
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

-- FK(�ܷ�Ű) ���������� ���̺� �߰�(X)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

-- FK(�ܷ�Ű) ���������� ���̺� �߰�(O) ON DELETE CASCADE
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;

DELETE employee WHERE empno=7369;
SELECT * FROM employee;

-- 20�� �μ��� �����ϴ��� 20�� �μ����� �ٹ��ϴ� ������ �״���̴�.
-- �̰��� employee���̺�� department���̺��� ����(Relational)�Ǿ��� ���� �ʱ� �����̴�.
-- FK���������� �߰��ؾ� �ϴ� �����̴�.
DELETE department WHERE deptno=20;
SELECT * FROM department;
SELECT * FROM employee;

-- FK���������� �߰��ϸ� �ڽ��� ������ �ִ� �θ� ���̺� ������ �ȵȴ�...
-- �ذ����� �ڽ� ���ڵ带 ���� ������ ��, �θ� ���ڵ� ������ ����
-- ���� ���� �۾��� �״�� ���ִ� �ɼ� ON DELETE CASCADE
-- FK���������� ������ �� ON DELETE CASCADE �ɼ��� �Բ� �����ؾ� �Ѵ�.