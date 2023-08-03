-- ### SubQuery ###
-- 1.  ��SMITH'�� ������ ���� ����� �̸�, �μ���, �޿�, ������  ����϶�.

SELECT e.ename, d.dname, e.sal, e.job 
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND 
e.job = (SELECT job FROM emp WHERE ename = 'SMITH');

-- 2.  ��JONES���� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի���, �޿��� ����϶�.
SELECT empno, ename, hiredate, sal FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'JONES');


-- 3.  ��ü ����� ��ձ޿����� �޿��� ���� ����� �����ȣ, �̸�,�μ���ȣ, �Ի���,�޿��� ����϶�.

SELECT empno, ename, deptno, hiredate, sal 
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);


-- 4. 10�� �μ��� ���� ���� �ϴ� ����� �����ȣ, �̸�, �޿��� �˻�..�޿��� ���� ������ ����϶�.
SELECT empno, ename, sal
FROM emp
WHERE 
job IN (SELECT job FROM emp WHERE deptno = 10)
ORDER BY sal DESC;

-- 5.  10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���ȣ,����, �Ի����� ����϶�.

SELECT empno, ename, hiredate, job, hiredate
FROM emp
WHERE deptno = 10
AND
job NOT IN (SELECT job FROM emp WHERE deptno = 30);

-- 6.  ��KING���̳� ��JAMES'�� �޿��� ���� ����� �����ȣ, �̸�,�޿��� ����϶�.

SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE ename IN ('KING','JAMES'));

-- 7.  �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ,�̸�, �޿��� ����϶�.

SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);


-- 8. SCOTT�� �޿����� ������ �޿��� �޴� ����� �˻�
-- 2���� ����� ��� 1) ��������  2) ���̺� �˸��߽��� ���
-- 1) 
SELECT * FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename = 'SCOTT') b
WHERE a.sal > b.sal;


-- 9. �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿��� �˻�
SELECT deptno, MIN(sal) 
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno = 20);

-- 10. �޿��� 10���μ��� ���� � ����� �޿����� �� ���� �޿��� �޴� ����� �˻�. 
-- �̶� 10�� �μ��� ���� ����� ���� 
-- ������ �����ȣ������ �Ѵ�. 
SELECT empno, ename, SAL
FROM emp
WHERE 
deptno != 10
AND
sal > (SELECT MIN(sal) FROM emp WHERE deptno = 10)
ORDER BY empno;


-- 11. 30�� �Ҽ� ����� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� �̸��� �޿��� �˻� 
-- 2���� ��� ���
-- 1)
SELECT max(sal) FROM emp WHERE deptno = 30; 

-- 2) ���� ����� ������ �ٽ� ���÷��� �ؾ��Ѵ�. having���� �ʿ�

SELECT ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);

-- 12. ���������� �Ŵ��� ����� �˻� . ����̸��� ����� �����ȣ�� �˻��ǵ���(�⸮�߽� ����̸�, �������ȣ)
-- 1)
SELECT e.ename ����̸�, e.empno �������ȣ
FROM emp e
WHERE empno IN (SELECT mgr FROM emp);

-- 2)

SELECT e.ename ����̸�, e.empno �������ȣ
FROM emp e
WHERE empno IN (SELECT DISTINCT(mgr) FROM emp);

