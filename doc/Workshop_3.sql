-- ##################  �׷� �Լ� �ǽ� ######################

-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT ROUND(AVG(SAL),2) ���, MIN(sal) ����, MAX(sal) �ְ�, COUNT(deptno) �ο��� 
FROM emp
WHERE deptno = 30
GROUP BY deptno; //Ʋ����

-- 2) �� �μ��� �޿��� ���(�Ҽ����� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal)) ���, MIN(sal) �ּ�, MAX(sal) �ִ�, count(-1) �ο��� 
FROM emp
GROUP BY deptno
ORDER BY 1;

-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno �μ���, job ������, COUNT(-1) �ο��� 
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT job ������, COUNT(-1) �ο���
FROM emp
GROUP BY job
HAVING COUNT(-1) >= 2;

-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT FLOOR(AVG(sal)) ��տ���, SUM(sal) ��ü����, MAX(sal) �ְ����, MIN(sal) ��������
FROM emp
GROUP BY deptno
ORDER BY ��տ��� DESC;

-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �޿��� �Ұ�� ������ ����϶�.
-- �μ��� �����Ѵ�.
SELECT deptno, job, SUM(sal) �޿���
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno;

-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno, COUNT(-1) �ο���  
FROM emp
GROUP BY deptno
HAVING COUNT(-1) >= 5;


-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧����    ��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal) �ִ�޿�, MIN(sal) �ּұ޿�, COUNT(*)
FROM emp
GROUP BY deptno
HAVING MAX(sal) != MIN(sal);

select deptno ,max(sal), min(sal), count(*)
from  emp
group by deptno
having max(sal) <> min(sal);


/* 9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�. */

SELECT deptno, ROUND(AVG(sal)) ��ձ޿�
FROM emp
WHERE deptno IN (10,20,30) AND (2500 <= sal AND sal <= 5000)
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000
ORDER BY ��ձ޿� DESC;
 
 select deptno, avg(sal) 
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having avg(sal) >= 2000 
 order by 2 desc  ;
