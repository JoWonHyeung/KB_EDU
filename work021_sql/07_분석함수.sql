--�м��Լ�
--OVER() �Լ��� ORDER BY�� �ڿ� �۵��Ѵ�... 
SELECT empno, ename, deptno, sal, 
RANK() OVER (ORDER BY sal DESC) "RANK" 
FROM emp;

SELECT empno, ename, deptno, sal, 
DENSE_RANK() OVER (ORDER BY sal DESC) "RANK" 
FROM emp;

SELECT empno, ename, deptno, sal, 
RANK() over (PARTITION BY deptno ORDER BY sal DESC) "RANK" 
FROM emp;

-- �м��Լ��� OVERHEAD�� �ٿ��ش�.. ������ ����.. JOIN/SUBQUERY�� �پ���...
-- step1.
SELECT ename, sal, rownum 
FROM emp 
ORDER BY sal DESC;

-- step2.
SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC);

-- step3. 
-- ROW_NUMBER() OVER() �Բ� ����ؼ� STEP2�� ������ ��� ���
SELECT ename, sal,
ROW_NUMBER() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

--ROW_NUMBER()
--GROUP BY��, ORDER BY������ ������ ���� ������ �Ҵ��ϴ� �м��Լ�
--rownum ���ĺ��� �� ��Ȯ�� ǥ���̴�... sal�� ���� ��쵵 ���...
SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) ����
FROM emp;



