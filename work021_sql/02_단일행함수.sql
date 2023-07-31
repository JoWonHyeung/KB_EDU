-- IN ������
-- �������� �� �߿��� ��� �ϳ��� ���� ��ġ�ϴ����� ��

-- �����ȣ�� 7369 �̰ų� 7521 �̰ų� 7782���� ����� �˻�

-- 1STEP
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;

-- 2STEP
SELECT * FROM emp WHERE empno = 7369 OR empno = 7521 OR empno=7782;

-- 3STEP
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

-- ///////////////////////////////////////////////////////////////
-- �����ȣ�� 7369�� �ƴϰ� 7521�� �ƴϰ� 7782���� �ƴ� ����� �˻�

SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

SELECT * FROM emp WHERE empno != 7369 AND empno != 7521 AND empno != 7782;

-- �����Լ� :: SUBSTR()
-- SUB(���ڿ�, ����, ������ġ, ����)

SELECT SUBSTR('HelloWorld', 6) FROM dual;

-- Wor�� ����
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;

--emp���̺��� ����� �̸��� N���� ������ ����� �˻� :: SUBSTR(), LIKE
SELECT ename FROM emp WHERE SUBSTR(ename, -1, 1) = 'N';
SELECT ename FROM emp WHERE ename LIKE '%N';

-- emp���̺��� ������� �Ի�⵵�� �˻�
SELECT hiredate, SUBSTR(hiredate,1,2) AS �⵵ FROM emp;

-- TRIM() :: ������ �����ϴ� �Լ� :: ��� ���� ���Ŵ� �ȵȴ�.
SELECT RTRIM('James Gosling            ') NAME FROM dual;
SELECT LTRIM('            James Gosling') NAME FROM dual;
SELECT TRIM('     James Gosling       ') NAME FROM dual;

-- REPLACE() :
SELECT REPLACE(job,'MAN','PERSON') AS NewJop FROM emp
WHERE job = 'SALESMAN';

SELECT REPLACE('     James Gosling is good      ','  ',' ') Message FROM dual;

-- �����Լ�
-- ROUND

/*
2��° ���ڰ� 2�� �ǹ̴� �Ҽ��� ���� 2�ڸ����� ���ڸ� ��Ÿ����� ��
�̷��� �Ǳ� ���ؼ��� �Ҽ��� ���� 3�ڸ����� ���������� �ݿø��� ����ȴ�.
*/
SELECT ROUND(45.923, 2) FROM dual; //�Ҽ��� 3��° �ڸ����� �ݿø�

SELECT ROUND(45.923, 0) FROM dual; 
SELECT ROUND(45.923) FROM dual;

/*
2��° ���ڰ��� �����϶���
45   .   923
(��)�� �߽����� ��, ��, �� ... ������ �Ž��� �ö�

����϶��� �޸� �ش��ڸ����� �ٷ� �ݿø��� �Ͼ��.
*/
SELECT ROUND(45.923, -1) FROM dual; //50

-- FLOOR() :: ����(�Ҽ��� �Ʒ��� ����, �ڸ��� ������ �ȵ�)
SELECT FLOOR(45.923) FROM dual;

--SELECT FLOOR(45.923, 2) FROM dual;

SELECT FLOOR(7.6) FROM dual;

--TRUNC() :: �ڸ����� ����, ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923) FROM dual;

SELECT TRUNC(45.923, 0) FROM dual;

SELECT TRUNC(45.923, 2) FROM dual;

-- CEIL() :: �ø� / FLOOR()�� �ݴ� :: �ڸ��� ���� �ȵ�
-- FLOOR() �� CEIL()�� ������ �����.
SELECT CEIL(45.923) FROM dual; 

--SELECT CEIL(45.923,2) FROM dual; 
SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

-- ��¥ �Լ�
SELECT SYSDATE FROM dual;

SELECT SYSTIMESTAMP FROM dual;

-- ���̸� ������ 100��° �Ǵ� �� ����
SELECT SYSDATE+100 FROM dual;

-- ����
SELECT SYSDATE + 1 ���� FROM dual;
SELECT SYSDATE - 1 ���� FROM dual;

--�����е��� �׵��� ��ƿ��� ����
--���� - �������
SELECT FLOOR((SYSDATE - TO_DATE('97/01/03'))) "��ƿ»���" FROM dual;

SELECT 
EXTRACT(day from sysdate) AS ����,EXTRACT(month from sysdate) AS ��, EXTRACT(year from sysdate) AS �⵵ 
FROM dual;

SELECT 
ename, hiredate, EXTRACT(year from hiredate) "year", EXTRACT(day from hiredate) "day" 
FROM emp
WHERE deptno = 20;

SELECT ename, hiredate, sysdate, TRUNC(MONTHS_BETWEEN(sysdate, hiredate),0) �ٹ�����
FROM emp
WHERE deptno = 10
ORDER BY �ٹ����� DESC;

SELECT ename, hiredate, next_day(hiredate, '��') 
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

--��¥�� ��¥ ������ ������ :: MONTHS_BETWEEND(DAY1, DAY2)
--EMP���̺��� �Ի��� ���κ��� '2023/07/25' ������
SELECT hiredate, ABS(TRUNC(MONTHS_BETWEEN(hiredate, '2023/07/25'))) FROM emp; // String �� �־ �ڵ� �� ��ȯ ����

SELECT empno, ename, job, sal, to_char(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY"��" MM"��" DD"��"') t_kor 
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

SELECT '0001230' ���1, TO_NUMBER('0001230') ���2 FROM dual;

-- �Ϲ��Լ� :: DECODE() 
-- EMP���̺��� ������ PRESIDENT / ����
--                    MANAGER / ������,
--                    ANALYST / �м���,
--                    ��Ÿ   / ����
--                    AS �����з�
SELECT job, 
    DECODE(job, 
    'PRESIDENT', '����', 
    'MANAGER', '������', 
    'ANALYST', '�м���', 
    '����') AS �����з�
FROM emp;

--
SELECT job, sal
    ,DECODE(sal, 
    5000, 'OWNER �޿�', 
    3000, '��� �޿�', 
    '�Ϲ� �޿�') AS �޿�����
FROM emp;

SELECT job, sal,
    CASE WHEN sal = 5000 THEN 'OWNER �޿�'
         WHEN sal = 3000 THEN '��� �޿�'
         ELSE '�Ϲ� �޿�' // ELSE �Ⱦ��� NULL�� ä������
    END AS �޿�����
FROM emp;