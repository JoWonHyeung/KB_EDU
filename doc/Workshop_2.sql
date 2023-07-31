-- ##################  ���ڿ� �Լ� �ǽ� ######################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.
SELECT UPPER(ename) AS ename
FROM emp
WHERE ename LIKE '%S%';

-- 2) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename,3) AS ename , sal
FROM emp;

-- 3) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT LOWER(SUBSTR(ename,1,3)) AS ename
FROM emp
WHERE LENGTH(ename) >= 6;

-- 4) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.
SELECT ename, LPAD(sal,6,'*') FROM emp;


-- 5) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT * FROM emp
WHERE ename = '   PARK   ';

-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT * 
FROM emp
WHERE TRIM(ename) = 'PARK';

-- ##################  ���� �Լ� �ǽ� ######################
-- 1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, ROUND(sal * 0.15,3) AS ȸ�� 
FROM emp
WHERE sal BETWEEN 1500 AND 3000;
 
-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
SELECT ename, sal, FLOOR(sal * 0.05) AS "������" 
FROM emp
WHERE sal >= 2000;
  

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)
 SELECT empno, ename, sal, ROUND(comm * 1.5) AS "���ʽ�"
 FROM emp
 WHERE comm is not null AND comm != 0;

-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
SELECT ename, hiredate,hiredate + 100 AS "100�� ���� ��", sal FROM emp;

-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT hiredate, ADD_MONTHS(hiredate, 6) FROM emp;

-- 3) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT deptno, ename, LAST_DAY(hiredate) - hiredate AS "�ٹ��ϼ�" FROM emp;

-- 4) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� �̸�, �Ի���,��MONDAY���� ����϶�.
select ename, hiredate, next_day(hiredate+100,'������') as MONDAY  from emp; 

-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 1) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
SELECT ename, TO_CHAR(hiredate,'YYYY-MM-DD') AS �Ի��� FROM emp;

-- 2) ��� ������ �̸��� �Ի��� �Ի���� '1981.05' �������� ����϶�
SELECT ename, TO_CHAR(hiredate,'YYYY.MM') AS �Ի�� FROM emp;

-- 3) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿��տ� ȭ��ǥ��($), �׸��� õ����(,)ǥ��, �Ҽ������� 2�ڸ��� ǥ�õǵ��� �϶�.
select empno, ename, TO_CHAR(sal,'$99,999.99') �޿� from emp;

-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- 1)  ��� ������ �̸�, �޿�, Ŀ�̼��� ����϶�. ��, comm�� null�̸� '����'���� ����϶�.
SELECT ename, sal, NVL(TO_CHAR(comm),'����') FROM emp;

-- 2)  ��� ������ �̸�, �޿�, Ŀ�̼�, ������ ����϶�. 
-- comm�� null�̸� �������� ����
-- ���ʽ��� comm�� null�̸� 10
SELECT ename, sal, NVL(TO_CHAR(comm),'����') AS Ŀ�̼�, sal * 12 + NVL(comm,10) ���� FROM emp;

-- 3) ��� ������ �̸�, ����, �޿�, Ŀ�̼�, ���ʽ��� ����϶�. 
-- ���ʽ��� ������  MANAGER�̸� �޿��� 150%, �׿� ������ �޿��� 130% �̴�.
SELECT ename, sal, comm, 
    DECODE(job,
    'MANAGER', sal * 1.5,  
    sal * 1.3) as ���ʽ�
from emp;

select ename, job, sal, comm, 
    case job when 'MANAGER' then sal *1.5
             else sal*1.3
    end  ���ʽ�
from emp;

-- 4) 
-- mgr�� null�̸� ���������/ null�̸� mgr���� �������� �Ѵ�.
-- ��Ī�� mgr2�� ���� (2���� �̻� ��� ���)

select ename, mgr,
        CASE  WHEN mgr is null THEN '���������'  
        ELSE '�����'
        END MGR2
from emp;

SELECT ename, mgr,
    CASE WHEN mgr is null THEN '���������'
    ELSE '�����'
    END mgr2
FROM emp;






