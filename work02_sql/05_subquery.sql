-- Sub query

-- ?�� �ش��ϴ� �κ��� ( )�ȿ� ������ ���� �����ϰ�, �� ����� main�������� ����..
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �̸��� �޿�, ������ �˻�
-- WHERE�� �ڿ� ���� ��������

SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK'); // One row + One column ==> ��Į�� ��������(�������� ���� ���̴� ���)

//��Į�� �� : �ܵ���

SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job = (SELECT job FROM emp WHERE empno = 7521)
AND
sal > (SELECT sal FROM emp WHERE empno = 7934);

SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

--10�� �μ����� �ٹ��ϴ� ����߿��� ����� ��ü��� �޿����� �� ���� �޿��� �޴� ����� �˻�
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 10 
AND 
sal > (SELECT AVG(sal) FROM emp);

--job�� ���� ���� ��ձ޿��� �˻�...����, ��ձ޿��� ���
--HAVING�� �ڿ� ���� ��������
--�׷��Լ� ��ø
--MySQL�� �׷��Լ� ��ø�� �Ұ����ϴ�... �߿�!!!
--�Ʒ� ������ MySQL���� �������� �ʴ´�....
SELECT job, ROUND(AVG(sal)) ��ձ޿� 
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--FROM�� �ڿ� ���� ��������
--����߿��� �޿��� ���� ���� �޴� ��� ��ŷ TOP3�� �˻�
--order by ���� ���� �� FROM �ڿ� ���������� ����...
SELECT empno, ename, job, sal, rownum �޿����� 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

-- ////////////////////////////////////////////////////////////////
--SCOTT�� �޿����� �� ���� �޿��� �޴� ��� �˻�(���� �������� ��������...?�ذ�... WHERE ��)
--STEP1.
SELECT ename, job, sal 
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

--STEP2.
SELECT a.ename, a.job, a.sal 
FROM emp a,(SELECT sal FROM emp WHERE ename = 'SCOTT') b
WHERE a.sal > b.sal; 

--�����߻�
--������ ������������ ������ ������ ���
--������ �������������� ������ �����ڸ� ���
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);//(������ ��������) 

--�Ʒ� �ΰ� �Ȱ���...
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN'
AND
sal > ANY(SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY 2;

SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN'
AND
sal > (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY 2;

--///////////////////////////////////////////////////////
SELECT ename, sal, job, hiredate, deptno 
FROM emp
WHERE job != 'SALESMAN'
AND
sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN');

--�μ���ȣ�� 30���� ����� �޿��߿��� ���� ���� �޿�(950)���� �� ���� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ ���... 
--1) �׷��Լ�
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 30)
ORDER BY 2;

--2) ������ ������
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE deptno = 30)
ORDER BY 2;

-- �������������� NULL��
-- EMP ���̺��� ���������� �Ŵ��� ��� �˻�
SELECT empno, mgr, ename 
FROM emp
WHERE empno IN (SELECT mgr FROM emp);

-- EMP ���̺��� ���������� �Ŵ����� ���� ��� �˻�(empno �� mgr�� �ִ� ���)
-- NOT IN => != �� and�� ����!!! �ϳ��� false�� false�̴�!!
SELECT empno, mgr, ename 
FROM emp
WHERE empno NOT IN (SELECT mgr FROM emp WHERE mgr IS NOT NULL);
