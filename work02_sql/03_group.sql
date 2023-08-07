-- 그룹함수

/*
    SUM,AVG : 문자, 날짜 데이터 적용 못한다.
    MAX,MIN,COUNT 

*/

-- COUNT()
-- 전체 사원수를 조회
-- null값이 포함된 column은 전체 row를 포함하지 않는다.
SELECT COUNT(*) 전체사원수 FROM emp;
select COUNT(empno) 전체사원수 from emp; 
select COUNT(-1) 전체사원수 from emp; //맨 마지막 row idx값을 반환한다.

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사한 사원의 입사일을 검색
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

-- 부서번호가 10번 이거나 20번 부서의 사원
SELECT COUNT(-1) AS 사원수 FROM emp
WHERE deptno IN (10, 20);

-- emp 테이블에서 부서번호 수를 검색 :: DISTINCT
SELECT COUNT(DISTINCT(deptno)) FROM emp;

-- 모든 사원의 보너스의 평균
SELECT ROUND(AVG(NVL(comm,0))) FROM emp; //그룹함수는 NULL을 건너뛴다.

--사원의 급여의 평균값을 검색
--STEP1.
--그룹함수에 포함되지 않은 컬럼이 SELECT절에 나열될 수 없다.
--GROUP BY절 뒤에 명시되어져야
SELECT deptno, AVG(sal) FROM emp;

--STEP2.
--부서별 평균급여
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
--부서별 급여의 평균을 검색... 10번 부서는 제외하고 검색... 정렬은 부서번호
--1. from --> 2. where -> 3. group by --> 4. select --> 5. order by
SELECT deptno AS DNumber, ROUND(AVG(sal)) AS AVGSAL 
FROM emp
WHERE deptno != 10 // Alias 불가
GROUP BY deptno
ORDER BY 1;

--입사년도별 사원수 검색
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--STEP1.
SELECT EXTRACT(YEAR FROM hiredate) as 입사년도, COUNT(*) 인원수
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--STEP2.
SELECT TO_CHAR(hiredate, 'YY') 년도별, COUNT(empno) 사원수 
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

--////////////////////////////////////////////////////////////////////////
--STEP1.
--Error
--SELECT deptno, ROUND(AVG(sal))
--FROM emp
--WHERE ROUND(AVG(sal)) >= 2000 //WHERE절에 그룹함수 사용 못함, 실행 순서가 맞지 않음
--GROUP BY deptno;

SELECT deptno, ROUND(AVG(sal))
FROM emp
HAVING ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- 최대 급여가 2900달러가 넘는 부서들의 최대급여를 출력
-- 그룹함수의 조건은 HAVING절!!!
-- 1) 부서별 최대 급여
-- 2) 필터링

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

-- step4. --> 함수호출하는 것보다 성능적으로 뛰어남.
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
통계쿼리 작성시 동일한 쿼리문을 Group by절에 작성하고 변경되는 부분들을 일일이 작성한 후
UNION ALL로 결합하는 방식과(step3,4,5)
GROUPING SETS를 사용하는 방식이 있는데(step1)

Grouping sets 사용한 방식이 훨씬 속도가 빠르다.
*/
