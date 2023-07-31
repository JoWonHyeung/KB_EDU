-- Sub query

-- ?에 해당하는 부분을 ( )안에 쿼리를 먼저 수행하고, 그 결과가 main쿼리에서 실행..
-- CLARK의 급여보다 더 많은 급여를 받는 사원의 이름과 급여, 업무를 검색
-- WHERE절 뒤에 오는 서브쿼리

SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK'); // One row + One column ==> 스칼라 서브쿼리(현업에서 많이 쓰이는 용어)

//스칼라 값 : 단독값

SELECT empno, ename, job, hiredate, sal
FROM emp
WHERE job = (SELECT job FROM emp WHERE empno = 7521)
AND
sal > (SELECT sal FROM emp WHERE empno = 7934);

SELECT ename, deptno, sal, hiredate
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

--10번 부서에서 근무하는 사원중에서 사원의 전체평균 급여보다 더 많은 급여를 받는 사원을 검색
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 10 
AND 
sal > (SELECT AVG(sal) FROM emp);

--job별 가장 작은 평균급여를 검색...업무, 평균급여를 출력
--HAVING절 뒤에 오는 서브쿼리
--그룹함수 중첩
--MySQL은 그룹함수 중첩이 불가능하다... 중요!!!
--아래 쿼리는 MySQL에서 동작하지 않는다....
SELECT job, ROUND(AVG(sal)) 평균급여 
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--FROM절 뒤에 오는 서브쿼리
--사원중에서 급여를 가장 많이 받는 사원 랭킹 TOP3를 검색
--order by 먼저 돌릴 때 FROM 뒤에 서브퀴리를 쓴다...
SELECT empno, ename, job, sal, rownum 급여순위 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

-- ////////////////////////////////////////////////////////////////
--SCOTT의 급여보다 더 많은 급여를 받는 사원 검색(가장 전형적인 서브쿼리...?해결... WHERE 절)
--STEP1.
SELECT ename, job, sal 
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

--STEP2.
SELECT a.ename, a.job, a.sal 
FROM emp a,(SELECT sal FROM emp WHERE ename = 'SCOTT') b
WHERE a.sal > b.sal; 

--에러발생
--다중행 서브쿼리에서 단일행 연산자 사용
--다중행 서브쿼리에서는 다중행 연산자를 사용
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);//(다중행 서브쿼리) 

--아래 두개 똑같음...
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

--부서번호가 30번인 사원의 급여중에서 가장 낮은 급여(950)보다 더 높은 급여를 받는 사원의 이름, 급여, 부서번호 출력... 
--1) 그룹함수
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 30)
ORDER BY 2;

--2) 다중행 연산자
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY(SELECT sal FROM emp WHERE deptno = 30)
ORDER BY 2;

-- 서브쿼리에서의 NULL값
-- EMP 테이블에서 부하직원을 거느린 사원 검색
SELECT empno, mgr, ename 
FROM emp
WHERE empno IN (SELECT mgr FROM emp);

-- EMP 테이블에서 부하직원을 거느리지 않은 사원 검색(empno 가 mgr에 있는 사원)
-- NOT IN => != 이 and로 연결!!! 하나라도 false면 false이다!!
SELECT empno, mgr, ename 
FROM emp
WHERE empno NOT IN (SELECT mgr FROM emp WHERE mgr IS NOT NULL);
