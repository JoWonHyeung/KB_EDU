-- ##################  그룹 함수 실습 ######################

-- 1)  30번 부서 월급의 평균(소수2자리 아래 올림), 최고, 최저, 인원수를 구하여 출력하라.
SELECT ROUND(AVG(SAL),2) 평균, MIN(sal) 최저, MAX(sal) 최고, COUNT(deptno) 인원수 
FROM emp
WHERE deptno = 30
GROUP BY deptno; //틀렷음

-- 2) 각 부서별 급여의 평균(소수이하 반올림), 최고, 최저, 인원수를 구하여 출력하라.
SELECT deptno, ROUND(AVG(sal)) 평균, MIN(sal) 최소, MAX(sal) 최대, count(-1) 인원수 
FROM emp
GROUP BY deptno
ORDER BY 1;

-- 3) 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 출력하라.
SELECT deptno 부서명, job 업무명, COUNT(-1) 인원수 
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 4) 같은 업무를 하는 사람의 수가 2명 이상인 업무와 인원수를  출력하라.
SELECT job 업무명, COUNT(-1) 인원수
FROM emp
GROUP BY job
HAVING COUNT(-1) >= 2;

-- 5) 각 부서별 평균 월급(소수이하 버림), 전체 월급, 최고 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하라. 
SELECT FLOOR(AVG(sal)) 평균월급, SUM(sal) 전체월급, MAX(sal) 최고월급, MIN(sal) 최저월급
FROM emp
GROUP BY deptno
ORDER BY 평균월급 DESC;

-- 6) 각 부서별 같은 업무를 하는 사람의 급여의 합계를 구하여 부서번호,업무명별 급여의 소계와 총합을 출력하라.
-- 부서별 정렬한다.
SELECT deptno, job, SUM(sal) 급여합
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno;

-- 7) 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
SELECT deptno, COUNT(-1) 인원수  
FROM emp
GROUP BY deptno
HAVING COUNT(-1) >= 5;


-- 8)  각 부서별 최대급여와 최소급여를 조회하시오.
--   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에    조회결과에서 제외시킨다.
SELECT deptno, MAX(sal) 최대급여, MIN(sal) 최소급여, COUNT(*)
FROM emp
GROUP BY deptno
HAVING MAX(sal) != MIN(sal);

select deptno ,max(sal), min(sal), count(*)
from  emp
group by deptno
having max(sal) <> min(sal);


/* 9) 부서가 10, 20, 30 번인 직원들 중에서 급여를 2500 이상 5000 이하를 받는
   직원들을 대상으로 부서별 평균 급여를 조회하시오.
   다, 평균급여가 2000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
   부서먼저 출력되도록 해야 한다. */

SELECT deptno, ROUND(AVG(sal)) 평균급여
FROM emp
WHERE deptno IN (10,20,30) AND (2500 <= sal AND sal <= 5000)
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000
ORDER BY 평균급여 DESC;
 
 select deptno, avg(sal) 
 from emp
 where  deptno in (10,20,30)
 and sal between 2500 and 5000 
 group by deptno 
 having avg(sal) >= 2000 
 order by 2 desc  ;
