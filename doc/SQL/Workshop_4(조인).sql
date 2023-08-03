-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

SELECT  d.deptno �μ���ȣ, d.dname �μ���, e.ename �̸�, e.sal �޿� 
FROM emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY 1;

-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.

SELECT  d.dname �μ���, e.ename �̸� 
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND
e.ename = 'SMITH'
ORDER BY 1;


-- ### outer join ###
-- 3.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.

SELECT e.ename, e.deptno, d.dname, e.sal 
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- ###self join###
-- 4.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�

SELECT  e1.ename || '�� �Ŵ�����' || e2.ename || '�̴�' 
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
AND
e1.ename = 'SMITH';


-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.
SELECT e1.ename �̸�, e1.empno �����ȣ, e1.mgr �����ڹ�ȣ, e2.ename �����ڸ� 
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno 
AND
e1.mgr = 7698;


-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
(e.job = 'MANAGER' OR e.job = 'CLERK')
ORDER BY 1;
