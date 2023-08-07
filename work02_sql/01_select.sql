--SELECT * FROM emp;

/*
    SELECT :: Projection | Selection
    Projection ���ϴ� �÷��� ������
    Selection ���ϴ� �ุ ������... ������ �ο�... where��
*/
SELECT empno, ename, job, deptno FROM emp;

--sql �ۼ� ���
--1. Ű����� �빮��
--2. Ű���� �������� ���� ������.

SELECT
empno, ename
FROM
emp;

--emp���̺��� ��� ����� �̸��� �Ի����� �˻�
SELECT ename, hiredate FROM emp;

SELECT ename, hiredate 
FROM emp
WHERE job = 'SALESMAN';

--emp ���̺��� �μ���ȣ�� 10���μ��� ����� �̸� ����, �޿�, �μ���ȣ�� �˻�
SELECT ename, job, SAL, deptno 
FROM emp 
WHERE deptno = 10;

--�޿������� ����...ORDER BY��... ���� �������� �´�
SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY sal;

SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY sal DESC;

--������ ���� ����
SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY 3 DESC;

--��Ī ���� ����
SELECT ename, job, sal AS �޿�, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY �޿� DESC;

--����߿��� �Ի����� ���� ���� ��������� �˻�
SELECT ename, job, hiredate
FROM emp
ORDER BY hiredate;

--����߿��� �޿��� ���� �޴� ������ ����, �̸�, �޿�, ������ �˻�
SELECT ename, sal, job 
FROM emp
ORDER BY SAL DESC;

--���� ��Ÿ���� Ű���� :: rownum
--���� ������ �� ���
--ORDER BY �� ����Ŭ������ ���� �������� ����(ROWNUM�� ������ ����ȴ�)
SELECT ename, sal, job, rownum 
FROM emp
ORDER BY SAL DESC;

-- �츮�� ���ϴ� �޿����� �޴� ���� 3���� ����� �ƴϴ�.
SELECT ename, sal, job, rownum 
FROM emp
WHERE rownum <= 3
ORDER BY SAL DESC;

--������ ���������� ���� ��Ų������ ROWNUM�� ����
SELECT ename, sal, job, rownum AS RANKING 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

/*
SELECT ������ ���� �ȿ��� �������
1. ����Ŭ ���� ����
   FROM(���̺�) ->> WHERE(������) ->> SELECT(�÷�����) ->> ROWNUM ->> ORDER BY(����)

2. MySQL ���� ����
   FROM(���̺�) ->> WHERE(������) ->> SELECT(�÷�����) ->> ORDER BY(����) ->> LIMIT

SQL ���� ���� ����
SELECT ->> FROM ->> WHERE ->> ORDER BY
*/

/*

Alias
�ַ� ��������� ����� �÷��� Alias�� �����Ѵ�.
1. �÷��� AS ��Ī | �÷��� ��Ī | �÷��� "��Ī"
2. "��Ī" ��Ī�� ������ �ְų� Ư�����ڰ� ���� ��, Ȥ�� ��ҹ��ڸ� ������ �� ����Ѵ�.
*/


-- ��� ����� �޿��� ���� �޿����� 100�� ���� ���� 2��� ����
-- 1
SELECT ename, sal, (sal + 100) * 2 AS "���� �޿�", job
FROM emp
ORDER BY "���� �޿�";

SELECT ename, sal, (sal + 100) * 2 �����޿�, job
FROM emp
ORDER BY �����޿�;

SELECT ename, sal, (sal + 100) * 2 �����޿�, job
FROM emp
ORDER BY 3;

--��� �޿����� ������ �����ϰ� ������ �޿��� �˻�(������ �޿��� 10%�� ����)
--�̸�, ����, �޿�, ���� ������ �޿�... ������ ���������� �޿�������
SELECT ename, job, sal, sal - sal * 0.1 AS ���������ѱ޿� FROM emp
ORDER BY 4;

-- ����� �޿��� ����(AnnualSalary)�� �˻�
-- null���� ���꿡�� ���ܵȴ�.
SELECT sal, sal * 12 + comm AS "AnnualSalary" FROM emp;

/*
 null ����
 1. 0�� �ƴϰ� ���鵵 �ƴϴ�
 2. ������ �ǹ̸� ���̴�.
    "�ڰݾ���" Ȥ�� "��Ȯ��(Unknown)"�� ���ϴ� ���϶� �ַ� ���ȴ�.
 3. ��������(+,-,*,/)�� �ȵǰ� ��(=,!=,<,>,<=,>=)�� �Ұ����ϴ�
 4. null���� ������ ������ �ؾ��� ���� �ٸ� ������ ġȯ���Ѽ� �����Ѵ�...NVL() �Լ��� ���
 5. ORACLE�� NULL�� ���� ū ������ ��޵ȴ�... MYSQL�� NULL�� ���� ���� �۴�.
*/

SELECT job, comm FROM emp ORDER BY comm DESC;

--�ذ�
SELECT ename, sal, sal * 12 + NVL(comm,0) "AnnualSalary"
FROM emp;

--EMP ����߿��� COMM�� NULL�� ����� �̸��� ����, �޿��� �˻�
--Record ����. null���� �񱳺Ұ�

SELECT ename, job, sal 
FROM emp
WHERE comm is not null;

--emp���̺� ���� ������ SALESMAN�� ����� �̸�, �޿�, ������ �˻�
SELECT ename, sal, sal * 12 + NVL(comm, 0) AS "AnnualSalary" FROM emp
WHERE job = 'SALESMAN'
ORDER BY 3;

--COMM�� ���� ���� �޴� ��������� �˻�(���, �̸�, ����, COMM)
SELECT deptno, ename, job, comm FROM emp
WHERE comm is not null
ORDER BY comm DESC;

--emp���̺��� �μ�(��ȣ)�� �˻�
SELECT deptno FROM emp;

--step 1.
SELECT DISTINCT deptno FROM emp;

--step 2.
SELECT DISTINCT deptno FROM emp
ORDER BY 1;

SELECT DISTINCT(deptno) FROM emp
ORDER BY 1;

/*
DISTINCT
�ߺ��� ���ܳ��� Ű����

1. SELECT�� �ٷ� �ڿ� �´�
2. 10G�������� ���� ����� �����־ ������ ������ �ؾ� �Ѵ�.
3. �ߺ����� �����ϴ� ������ ���� �ð��� �ɸ���.
   ���࿡ �Ұ����ϰ� ����ؾ��ϴ� ��Ȳ�̶�� DISTINCT������ ��ü�ϴ� ����̳� Ȥ��
   ������ ����� �Ǵ� ���̺��� ũ�⸦ �ּ�ȭ�ϴ� ����� �����Ѵ�.
   
   ���� ��ǥ���� ��ü������� EXISTS�� Ȱ���ϴ� ����� �����Ѵ�.
*/
SELECT * FROM dept;

SELECT deptno FROM dept d
    WHERE EXISTS(
    SELECT * FROM emp e
    WHERE d.deptno = e.deptno);

/*
LIKE �����ڿ� ���ϵ�ī��(%, _)
Ư�� �ܾ ���ԵǾ� �ִ� �����͸� �˻��� �� ���� ���
*/

-- ����� �̸��߿��� S �� �����ϴ� ����� �˻�
SELECT ename FROM emp WHERE ename LIKE 'S%';

-- ����� �̸��߿��� S �� ���Ե� �̸��� ����� �˻�
SELECT ename FROM emp WHERE ename LIKE '%S%';

-- 2��° ���ڿ� A�� �� �ִ� �̸��� ����� �˻�
SELECT ename FROM emp WHERE ename LIKE '_A%';

--81�⵵�� �Ի��� ����� �˻�
SELECT ename FROM emp WHERE hiredate LIKE '81%';
