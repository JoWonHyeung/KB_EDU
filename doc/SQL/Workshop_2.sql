-- ##################  문자열 함수 실습 ######################
-- 1) 직원의 이름에 대소문자 상관없이 s가 들어간 직원의 모든 정보를 출력하라.
SELECT UPPER(ename) AS ename
FROM emp
WHERE ename LIKE '%S%';

-- 2) 직원 정보 중 사원번호, 이름, 급여를 출력한다.  단, 이름은 앞에서 3글자씩만 출력하라.
SELECT empno, SUBSTR(ename,3) AS ename , sal
FROM emp;

-- 3) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 이름만을 출력하라.
SELECT LOWER(SUBSTR(ename,1,3)) AS ename
FROM emp
WHERE LENGTH(ename) >= 6;

-- 4) 직원의 이름과 급여를 출력하라, 단, 금액의 정확도를 위해 급여를 6자리로 출력하고, 앞 여백을 모두 * 로 채워 출력하라.
SELECT ename, LPAD(sal,6,'*') FROM emp;


-- 5) 직원정보를 입력하던중 아래와 같이 입력 되었다.(이름에 공백이 입력됨)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- 이름이 'PARK'인 직원의 정보를 출력하여 보자.
SELECT * FROM emp
WHERE ename = '   PARK   ';

-- 이름 좌우에 공백이 있더라도 공백을 제거하고 이름이 'PARK'인 직원의 정보를 출력하여 보자.
SELECT * 
FROM emp
WHERE TRIM(ename) = 'PARK';

-- ##################  숫자 함수 실습 ######################
-- 1) 급여가 $1,500부터 $3,000 사이의 사람은 급여의 15%를 회비로 지불하기로 하였다. 
-- 이를 이름, 급여, 회비(소수점 두 자리 아래에서 반올림)를 출력하라.
SELECT ename, sal, ROUND(sal * 0.15,3) AS 회비 
FROM emp
WHERE sal BETWEEN 1500 AND 3000;
 
-- 2) 급여가 $2,000 이상인 모든 사람은 급여의 5%를 경조비로 내기 로 하였다. 
-- 이름, 급여, 경조비(소수점 이하 절삭)를 출력하라.
SELECT ename, sal, FLOOR(sal * 0.05) AS "경조비" 
FROM emp
WHERE sal >= 2000;
  

 -- 3) 이익을 배분하기 위해 comm의 150%를 보너스로 지급하려 한다. comm이 있는 직원들을 대상으로 
 -- 직원번호, 직원명, 급여, comm의 150%를 소숫점이하 올림하여 출력하라. (comm이 0이거나, null이면 제외)
 SELECT empno, ename, sal, ROUND(comm * 1.5) AS "보너스"
 FROM emp
 WHERE comm is not null AND comm != 0;

-- ##################  날짜 함수 실습 ######################

-- 1)입사일로부터 100일이 지난 후를 구해보자. 사원이름, 입사일, 100일 후의 날, 급여를 출력하라.
SELECT ename, hiredate,hiredate + 100 AS "100일 후의 날", sal FROM emp;

-- 2) 입사일로부터 6개월이 지난 후의 날짜를 구하려고 한다.  입사일, 6개월 후의 날짜, 급여를 출력하라
SELECT hiredate, ADD_MONTHS(hiredate, 6) FROM emp;

-- 3) 입사한 달의 근무일수를 계산하여 부서번호, 이름, 근무일수를 출력하라.
SELECT deptno, ename, LAST_DAY(hiredate) - hiredate AS "근무일수" FROM emp;

-- 4) 모든 사원의 입사일 기준으로 100일이 지난 후의 월요일의 날짜를 구해서 이름, 입사일,’MONDAY’를 출력하라.
select ename, hiredate, next_day(hiredate+100,'월요일') as MONDAY  from emp; 

-- ##################  변환 함수 실습 ######################

-- 1) 모든 직원의 이름과 입사일을 ‘1996-05-14’의 형태로 출력 하라.
SELECT ename, TO_CHAR(hiredate,'YYYY-MM-DD') AS 입사일 FROM emp;

-- 2) 모든 직원의 이름과 입사년과 입사월만 '1981.05' 형식으로 출력하라
SELECT ename, TO_CHAR(hiredate,'YYYY.MM') AS 입사월 FROM emp;

-- 3) 모든 직원의 번호, 이름, 급여를 출력하라. 단, 급여앞에 화폐표시($), 그리고 천단위(,)표시, 소수점이하 2자리가 표시되도록 하라.
select empno, ename, TO_CHAR(sal,'$99,999.99') 급여 from emp;

-- ##################  일반 함수 실습 ######################

-- 1)  모든 직원의 이름, 급여, 커미션을 출력하라. 단, comm이 null이면 '없음'으로 출력하라.
SELECT ename, sal, NVL(TO_CHAR(comm),'없음') FROM emp;

-- 2)  모든 직원의 이름, 급여, 커미션, 연봉을 출력하라. 
-- comm이 null이면 없음으로 기입
-- 보너스는 comm이 null이면 10
SELECT ename, sal, NVL(TO_CHAR(comm),'없음') AS 커미션, sal * 12 + NVL(comm,10) 연봉 FROM emp;

-- 3) 모든 직원의 이름, 직무, 급여, 커미션, 보너스를 출력하라. 
-- 보너스는 직무가  MANAGER이면 급여의 150%, 그외 직원은 급여의 130% 이다.
SELECT ename, sal, comm, 
    DECODE(job,
    'MANAGER', sal * 1.5,  
    sal * 1.3) as 보너스
from emp;

select ename, job, sal, comm, 
    case job when 'MANAGER' then sal *1.5
             else sal*1.3
    end  보너스
from emp;

-- 4) 
-- mgr이 null이면 상위담당자/ null이면 mgr값을 가지도록 한다.
-- 별칭을 mgr2로 하자 (2가지 이상 방법 사용)

select ename, mgr,
        CASE  WHEN mgr is null THEN '상위담당자'  
        ELSE '담당자'
        END MGR2
from emp;

SELECT ename, mgr,
    CASE WHEN mgr is null THEN '상위담당자'
    ELSE '담당자'
    END mgr2
FROM emp;






