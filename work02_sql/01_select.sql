--SELECT * FROM emp;

/*
    SELECT :: Projection | Selection
    Projection 원하는 컬럼만 가져옴
    Selection 원하는 행만 가져옴... 조건을 부여... where절
*/
SELECT empno, ename, job, deptno FROM emp;

--sql 작성 요령
--1. 키워드는 대문자
--2. 키워드 기준으로 행을 나눈다.

SELECT
empno, ename
FROM
emp;

--emp테이블에서 모든 사원의 이름과 입사일을 검색
SELECT ename, hiredate FROM emp;

SELECT ename, hiredate 
FROM emp
WHERE job = 'SALESMAN';

--emp 테이블에서 부서번호가 10번부서인 사원의 이름 업무, 급여, 부서번호를 검색
SELECT ename, job, SAL, deptno 
FROM emp 
WHERE deptno = 10;

--급여순으로 정렬...ORDER BY절... 가장 마지막에 온다
SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY sal;

SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY sal DESC;

--정수로 정렬 가능
SELECT ename, job, sal, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY 3 DESC;

--별칭 정렬 가능
SELECT ename, job, sal AS 급여, deptno 
FROM emp 
WHERE deptno = 10
ORDER BY 급여 DESC;

--사원중에서 입사일이 가장 빠른 사원순으로 검색
SELECT ename, job, hiredate
FROM emp
ORDER BY hiredate;

--사원중에서 급여를 많이 받는 순으로 정렬, 이름, 급여, 업무를 검색
SELECT ename, sal, job 
FROM emp
ORDER BY SAL DESC;

--행을 나타내는 키워드 :: rownum
--행을 제한할 때 사용
--ORDER BY 가 오라클에서는 가장 마지막에 싱행(ROWNUM이 그전에 실행된다)
SELECT ename, sal, job, rownum 
FROM emp
ORDER BY SAL DESC;

-- 우리가 원하는 급여많이 받는 상위 3인의 결과가 아니다.
SELECT ename, sal, job, rownum 
FROM emp
WHERE rownum <= 3
ORDER BY SAL DESC;

--정렬을 강제적으로 먼저 시킨다음에 ROWNUM을 전용
SELECT ename, sal, job, rownum AS RANKING 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

/*
SELECT 구문의 서버 안에서 실행순서
1. 오라클 실행 순서
   FROM(테이블) ->> WHERE(행제한) ->> SELECT(컬럼제한) ->> ROWNUM ->> ORDER BY(정렬)

2. MySQL 실행 순서
   FROM(테이블) ->> WHERE(행제한) ->> SELECT(컬럼제한) ->> ORDER BY(정렬) ->> LIMIT

SQL 구문 문법 순서
SELECT ->> FROM ->> WHERE ->> ORDER BY
*/

/*

Alias
주로 산술연산이 적용된 컬럼에 Alias를 지정한다.
1. 컬럼명 AS 별칭 | 컬럼명 별칭 | 컬럼명 "별칭"
2. "별칭" 별칭에 공백이 있거나 특수문자가 있을 때, 혹은 대소문자를 구분할 때 사용한다.
*/


-- 모든 사원의 급여를 기존 급여에서 100을 더한 값의 2배로 증가
-- 1
SELECT ename, sal, (sal + 100) * 2 AS "증가 급여", job
FROM emp
ORDER BY "증가 급여";

SELECT ename, sal, (sal + 100) * 2 증가급여, job
FROM emp
ORDER BY 증가급여;

SELECT ename, sal, (sal + 100) * 2 증가급여, job
FROM emp
ORDER BY 3;

--사원 급여에서 세금을 제외하고 수령한 급여를 검색(세금을 급여의 10%로 간주)
--이름, 업무, 급여, 실제 수령한 급여... 정렬은 실제수령한 급여순으로
SELECT ename, job, sal, sal - sal * 0.1 AS 실제수령한급여 FROM emp
ORDER BY 4;

-- 사원의 급여와 연봉(AnnualSalary)을 검색
-- null값은 연산에서 제외된다.
SELECT sal, sal * 12 + comm AS "AnnualSalary" FROM emp;

/*
 null 정리
 1. 0도 아니고 공백도 아니다
 2. 나름의 의미를 값이다.
    "자격없음" 혹은 "미확정(Unknown)"을 뜻하는 값일때 주로 사용된다.
 3. 연산적용(+,-,*,/)이 안되고 비교(=,!=,<,>,<=,>=)가 불가능하다
 4. null값을 가지고 연산을 해야할 떄는 다른 값으로 치환시켜서 연산한다...NVL() 함수를 사용
 5. ORACLE은 NULL이 가장 큰 값으로 취급된다... MYSQL은 NULL이 가장 값이 작다.
*/

SELECT job, comm FROM emp ORDER BY comm DESC;

--해결
SELECT ename, sal, sal * 12 + NVL(comm,0) "AnnualSalary"
FROM emp;

--EMP 사원중에서 COMM이 NULL인 사원의 이름과 업무, 급여를 검색
--Record 없음. null값은 비교불가

SELECT ename, job, sal 
FROM emp
WHERE comm is not null;

--emp테이블 에서 업무가 SALESMAN인 사원의 이름, 급여, 연봉을 검색
SELECT ename, sal, sal * 12 + NVL(comm, 0) AS "AnnualSalary" FROM emp
WHERE job = 'SALESMAN'
ORDER BY 3;

--COMM을 가장 많이 받는 사원순으로 검색(사번, 이름, 업무, COMM)
SELECT deptno, ename, job, comm FROM emp
WHERE comm is not null
ORDER BY comm DESC;

--emp테이블에서 부서(번호)를 검색
SELECT deptno FROM emp;

--step 1.
SELECT DISTINCT deptno FROM emp;

--step 2.
SELECT DISTINCT deptno FROM emp
ORDER BY 1;

SELECT DISTINCT(deptno) FROM emp
ORDER BY 1;

/*
DISTINCT
중복을 벗겨내는 키워드

1. SELECT절 바로 뒤에 온다
2. 10G버전부터 정렬 기능이 빠져있어서 별도로 정렬을 해야 한다.
3. 중복값을 제거하는 연산은 많은 시간이 걸린다.
   만약에 불가피하게 사용해야하는 상황이라면 DISTINCT연산을 대체하는 방법이나 혹은
   연산의 대상이 되는 테이블의 크기를 최소화하는 방법을 제안한다.
   
   가장 대표적인 대체방법으로 EXISTS를 활용하는 방법을 제안한다.
*/
SELECT * FROM dept;

SELECT deptno FROM dept d
    WHERE EXISTS(
    SELECT * FROM emp e
    WHERE d.deptno = e.deptno);

/*
LIKE 연산자와 와일드카드(%, _)
특정 단어가 포함되어 있는 데이터를 검색할 때 많이 사용
*/

-- 사원의 이름중에서 S 로 시작하는 사원을 검색
SELECT ename FROM emp WHERE ename LIKE 'S%';

-- 사원의 이름중에서 S 가 포함된 이름의 사원을 검색
SELECT ename FROM emp WHERE ename LIKE '%S%';

-- 2번째 문자에 A가 들어가 있는 이름의 사원을 검색
SELECT ename FROM emp WHERE ename LIKE '_A%';

--81년도에 입사한 사원을 검색
SELECT ename FROM emp WHERE hiredate LIKE '81%';
