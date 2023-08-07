--분석함수
--OVER() 함수는 ORDER BY절 뒤에 작동한다... 
SELECT empno, ename, deptno, sal, 
RANK() OVER (ORDER BY sal DESC) "RANK" 
FROM emp;

SELECT empno, ename, deptno, sal, 
DENSE_RANK() OVER (ORDER BY sal DESC) "RANK" 
FROM emp;

SELECT empno, ename, deptno, sal, 
RANK() over (PARTITION BY deptno ORDER BY sal DESC) "RANK" 
FROM emp;

-- 분석함수가 OVERHEAD를 줄여준다.. 성능이 좋다.. JOIN/SUBQUERY가 줄어든다...
-- step1.
SELECT ename, sal, rownum 
FROM emp 
ORDER BY sal DESC;

-- step2.
SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC);

-- step3. 
-- ROW_NUMBER() OVER() 함께 사용해서 STEP2와 동일한 결과 출력
SELECT ename, sal,
ROW_NUMBER() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

--ROW_NUMBER()
--GROUP BY절, ORDER BY절에서 지정된 행의 순서를 할당하는 분석함수
--rownum 정렬보다 더 정확한 표현이다... sal이 같을 경우도 대비...
SELECT ename, sal, hiredate,
ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) 순번
FROM emp;



