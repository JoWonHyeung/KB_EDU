-- 1) emp ���̺� ������ Ȯ���ϼ���.
DESC emp;

-- 2) �μ���ȣ�� 20���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�
SELECT empno, ename, sal 
FROM emp
WHERE deptno = 20;

-- 3) �̸��� JONES�� ����� ��� ������ ����϶�.
SELECT * FROM emp
WHERE ename = 'JONES';

-- 4)������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
SELECT * 
FROM emp
WHERE job != 'MANAGER';

-- 5) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����϶�.
SELECT ename, job, sal
FROM emp
WHERE 1600 <= SAL AND SAL <= 3000;


-- 6) �Ի����� 80�⵵�� ����� ��� ������ ����϶�
SELECT * FROM emp
WHERE hiredate LIKE '80%';

-- 7) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
SELECT * FROM emp
WHERE hiredate < '81/12/09';


-- 8) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�.
SELECT * FROM emp
WHERE ename LIKE '%S%';


-- 9) comm�� null�� �ƴ� ������� �̸�, �޿�, comm, �μ���ȣ�� ��ȸ
-- comm�� ��Ī�� ���ʽ��� �ϰ� ���ʽ��� ���� ���������(desc) ����
SELECT ename, sal, comm AS "���ʽ�", deptno 
FROM emp
WHERE comm is not null
ORDER BY "���ʽ�" DESC;

-- 10) ����߿��� �������� SALESMAN�̰ų� ����(PRESIDENT)�̸鼭 ���ÿ� �޿��� 1500 �̻��� �Ǵ� ����� �˻�
SELECT * FROM emp
WHERE (job = 'SALESMAN' OR job = 'PRESIDENT') AND SAL >= 1500;


-- 11) �μ���ȣ�� �⺻ ��������, �μ���ȣ�� ������� �޿��� ���� ������ �����Ͽ� ���, �̸�, ����, �μ���ȣ,�޿��� ��ȸ
SELECT empno, ename, job, deptno, sal 
FROM emp
ORDER BY deptno, sal desc;


-- 12) �μ����� ����ϴ� ������ �ѹ��� ��ȸ�Ͻÿ�
-- ��, ���� �������� �����մϴ�.
SELECT DISTINCT deptno, job FROM emp
ORDER BY job;

-- 13) �Ի����� ���� ������ ��� 5�� ��ȸ�Ͻÿ�
SELECT ename, sal, job, rownum AS RANKING
FROM (SELECT * FROM emp ORDER BY hiredate)
WHERE rownum <= 3;

-- 14) emp Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(sal + comm)��  ���Ͽ� �Ѿ��� ���� ������ ����϶�. 
-- ��, Ŀ�̼��� NULL�� ����� �����Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100)
SELECT 
ename, sal, sal * comm / 100 AS Ŀ�̼Ǳݾ�, sal + comm AS �Ѿ� 
FROM emp
WHERE comm is not null
ORDER BY �Ѿ� DESC;

-- 15)  10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� ����϶�.
SELECT 
ename, sal, (sal + NVL(comm,0)) * 0.13 AS ���ʽ�, deptno
FROM emp;

