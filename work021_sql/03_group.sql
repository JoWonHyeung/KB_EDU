-- �׷��Լ�

/*
    SUM,AVG : ����, ��¥ ������ ���� ���Ѵ�.
    MAX,MIN,COUNT 

*/

-- COUNT()
-- ��ü ������� ��ȸ
-- null���� ���Ե� column�� ��ü row�� �������� �ʴ´�.
SELECT COUNT(*) ��ü����� FROM emp;
select COUNT(empno) ��ü����� from emp; 
select COUNT(-1) ��ü����� from emp; //�� ������ row idx���� ��ȯ�Ѵ�.

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� �˻�
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- �μ���ȣ�� 10�� �̰ų� 20�� �μ��� ���
SELECT COUNT(-1) AS ����� FROM emp
WHERE deptno IN (10, 20);

-- emp ���̺��� �μ���ȣ ���� �˻� :: DISTINCT
SELECT COUNT(DISTINCT(deptno)) FROM emp;

-- ��� ����� ���ʽ��� ���
SELECT ROUND(AVG(NVL(comm,0))) FROM emp; //�׷��Լ��� NULL�� �ǳʶڴ�.

--����� �޿��� ��հ��� �˻�
--STEP1.
--�׷��Լ��� ���Ե��� ���� �÷��� SELECT���� ������ �� ����.
--GROUP BY�� �ڿ� ��õǾ�����
SELECT deptno, AVG(sal) FROM emp;

--STEP2.
--�μ��� ��ձ޿�
SELECT deptno, ROUND(AVG(sal)) 
FROM emp
GROUP BY deptno;

--STEP3.
SELECT deptno, ROUND(AVG(sal)) AS "AvgSalary"
FROM emp
GROUP BY deptno 
ORDER BY 2;

--STEP4.
SELECT deptno, ROUND(AVG(sal)) AS "AvgSalary" -- 3
FROM emp -- 1
GROUP BY "AvgSalary" -- 2 
ORDER BY 2; -- 4

--STEP5.
--�μ��� �޿��� ����� �˻�... 10�� �μ��� �����ϰ� �˻�... ������ �μ���ȣ
--1. from --> 2. where -> 3. group by --> 4. select --> 5. order by
SELECT deptno AS DNumber, ROUND(AVG(sal)) AS AVGSAL 
FROM emp
WHERE deptno != 10 // Alias �Ұ�
GROUP BY deptno
ORDER BY 1;

--�Ի�⵵�� ����� �˻�
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--STEP1.
SELECT EXTRACT(YEAR FROM hiredate) as �Ի�⵵, COUNT(*) �ο���
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--STEP2.
SELECT TO_CHAR(hiredate, 'YY') �⵵��, COUNT(empno) ����� 
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

--////////////////////////////////////////////////////////////////////////
--STEP1.
--Error
--SELECT deptno, ROUND(AVG(sal))
--FROM emp
--WHERE ROUND(AVG(sal)) >= 2000 //WHERE���� �׷��Լ� ��� ����, ���� ������ ���� ����
--GROUP BY deptno;

SELECT deptno, ROUND(AVG(sal))
FROM emp
HAVING ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- �ִ� �޿��� 2900�޷��� �Ѵ� �μ����� �ִ�޿��� ���
-- �׷��Լ��� ������ HAVING��!!!
-- 1) �μ��� �ִ� �޿�
-- 2) ���͸�

-- 1)
SELECT deptno, MAX(SAL) FROM emp
GROUP BY deptno;
 
-- 2)
SELECT deptno, MAX(SAL)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2900;

SELECT deptno, count(*), sum(sal) FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, job, SUM(sal) FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY 1;
 
SELECT job,deptno,SUM(sal) FROM emp
GROUP BY ROLLUP(job, deptno)
ORDER BY 1;

-- Grouping Sets
-- step1.
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

-- step2.
SELECT deptno, SUM(sal) 
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal) 
FROM emp
GROUP BY job;

-- step3.
SELECT TO_CHAR(deptno), SUM(sal) 
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal) 
FROM emp
GROUP BY job;

-- step4. --> �Լ�ȣ���ϴ� �ͺ��� ���������� �پ.
SELECT deptno || '', SUM(sal) 
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal) 
FROM emp
GROUP BY job;

-- step5.
SELECT deptno, NULL job, SUM(sal) 
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal) 
FROM emp
GROUP BY job;

/*
������� �ۼ��� ������ �������� Group by���� �ۼ��ϰ� ����Ǵ� �κе��� ������ �ۼ��� ��
UNION ALL�� �����ϴ� ��İ�(step3,4,5)
GROUPING SETS�� ����ϴ� ����� �ִµ�(step1)

Grouping sets ����� ����� �ξ� �ӵ��� ������.
*/
