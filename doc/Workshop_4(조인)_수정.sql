-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.

SELECT  d.deptno 부서번호, d.dname 부서명, e.ename 이름, e.sal 급여 
FROM emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY 1;

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.

SELECT  d.dname 부서명, e.ename 이름 
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND
e.ename = 'SMITH'
ORDER BY 1;


-- ### outer join ###
-- 3.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.

SELECT e.ename, e.deptno, d.dname, e.sal 
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- ###self join###
-- 4.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’

SELECT  e1.ename || '의 매니저는' || e2.ename || '이다' 
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
AND
e1.ename = 'SMITH';


-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
SELECT e1.ename 이름, e1.empno 사원번호, e1.mgr 관리자번호, e2.ename 관리자명 
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno 
AND
e1.mgr = 7698;


-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
SELECT e.empno, e.ename, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
(e.job = 'MANAGER' OR e.job = 'CLERK')
ORDER BY 1;
