-- IN 연산자
-- 여러개의 값 중에서 어느 하나의 값과 일치하는지를 비교

-- 사원번호가 7369 이거나 7521 이거나 7782번인 사원을 검색

-- 1STEP
SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7782;

-- 2STEP
SELECT * FROM emp WHERE empno = 7369 OR empno = 7521 OR empno=7782;

-- 3STEP
SELECT * FROM emp WHERE empno IN(7369, 7521, 7782);

-- ///////////////////////////////////////////////////////////////
-- 사원번호가 7369가 아니고 7521도 아니고 7782번도 아닌 사원을 검색

SELECT * FROM emp WHERE empno NOT IN(7369, 7521, 7782);

SELECT * FROM emp WHERE empno != 7369 AND empno != 7521 AND empno != 7782;

-- 문자함수 :: SUBSTR()
-- SUB(문자열, 시작, 시작위치, 개수)

SELECT SUBSTR('HelloWorld', 6) FROM dual;

-- Wor을 추출
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;

--emp테이블에서 사원의 이름이 N으로 끝나는 사원을 검색 :: SUBSTR(), LIKE
SELECT ename FROM emp WHERE SUBSTR(ename, -1, 1) = 'N';
SELECT ename FROM emp WHERE ename LIKE '%N';

-- emp테이블에서 사원들의 입사년도만 검색
SELECT hiredate, SUBSTR(hiredate,1,2) AS 년도 FROM emp;

-- TRIM() :: 공백을 제거하는 함수 :: 가운데 공백 제거는 안된다.
SELECT RTRIM('James Gosling            ') NAME FROM dual;
SELECT LTRIM('            James Gosling') NAME FROM dual;
SELECT TRIM('     James Gosling       ') NAME FROM dual;

-- REPLACE() :
SELECT REPLACE(job,'MAN','PERSON') AS NewJop FROM emp
WHERE job = 'SALESMAN';

SELECT REPLACE('     James Gosling is good      ','  ',' ') Message FROM dual;

-- 숫자함수
-- ROUND

/*
2번째 인자값 2의 의미는 소수점 이하 2자리까지 숫자를 나타내라는 뜻
이렇게 되기 위해서는 소수점 이하 3자리에서 실질적으로 반올림이 진행된다.
*/
SELECT ROUND(45.923, 2) FROM dual; //소수점 3번째 자리에서 반올림

SELECT ROUND(45.923, 0) FROM dual; 
SELECT ROUND(45.923) FROM dual;

/*
2번째 인자값이 음수일때는
45   .   923
(점)을 중심으로 일, 십, 백 ... 단위로 거슬러 올라감

양수일때와 달리 해당자리에서 바로 반올림이 일어난다.
*/
SELECT ROUND(45.923, -1) FROM dual; //50

-- FLOOR() :: 내림(소수점 아래를 버림, 자릿수 지정이 안됨)
SELECT FLOOR(45.923) FROM dual;

--SELECT FLOOR(45.923, 2) FROM dual;

SELECT FLOOR(7.6) FROM dual;

--TRUNC() :: 자릿수를 지정, 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923) FROM dual;

SELECT TRUNC(45.923, 0) FROM dual;

SELECT TRUNC(45.923, 2) FROM dual;

-- CEIL() :: 올림 / FLOOR()의 반대 :: 자릿수 지정 안됨
-- FLOOR() 과 CEIL()는 정수로 만든다.
SELECT CEIL(45.923) FROM dual; 

--SELECT CEIL(45.923,2) FROM dual; 
SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

-- 날짜 함수
SELECT SYSDATE FROM dual;

SELECT SYSTIMESTAMP FROM dual;

-- 그이를 만난지 100일째 되는 날 계산법
SELECT SYSDATE+100 FROM dual;

-- 내일
SELECT SYSDATE + 1 내일 FROM dual;
SELECT SYSDATE - 1 어제 FROM dual;

--여러분들이 그동안 살아오신 생애
--오늘 - 생년원일
SELECT FLOOR((SYSDATE - TO_DATE('97/01/03'))) "살아온생애" FROM dual;

SELECT 
EXTRACT(day from sysdate) AS 일자,EXTRACT(month from sysdate) AS 월, EXTRACT(year from sysdate) AS 년도 
FROM dual;

SELECT 
ename, hiredate, EXTRACT(year from hiredate) "year", EXTRACT(day from hiredate) "day" 
FROM emp
WHERE deptno = 20;

SELECT ename, hiredate, sysdate, TRUNC(MONTHS_BETWEEN(sysdate, hiredate),0) 근무월수
FROM emp
WHERE deptno = 10
ORDER BY 근무월수 DESC;

SELECT ename, hiredate, next_day(hiredate, '금') 
FROM emp
WHERE deptno = 10
ORDER BY hiredate DESC;

--날짜와 날짜 사이의 개월수 :: MONTHS_BETWEEND(DAY1, DAY2)
--EMP테이블에서 입사한 날로부터 '2023/07/25' 개월수
SELECT hiredate, ABS(TRUNC(MONTHS_BETWEEN(hiredate, '2023/07/25'))) FROM emp; // String 값 넣어도 자동 형 변환 가능

SELECT empno, ename, job, sal, to_char(sal, '999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

SELECT ename, hiredate, TO_CHAR(hiredate, 'YYYY"년" MM"월" DD"일"') t_kor 
FROM emp
WHERE deptno = 20
ORDER BY hiredate DESC;

SELECT '0001230' 결과1, TO_NUMBER('0001230') 결과2 FROM dual;

-- 일반함수 :: DECODE() 
-- EMP테이블에서 업무가 PRESIDENT / 사장
--                    MANAGER / 관리자,
--                    ANALYST / 분석가,
--                    기타   / 직원
--                    AS 직원분류
SELECT job, 
    DECODE(job, 
    'PRESIDENT', '사장', 
    'MANAGER', '관리자', 
    'ANALYST', '분석가', 
    '직원') AS 직원분류
FROM emp;

--
SELECT job, sal
    ,DECODE(sal, 
    5000, 'OWNER 급여', 
    3000, '고액 급여', 
    '일반 급여') AS 급여구분
FROM emp;

SELECT job, sal,
    CASE WHEN sal = 5000 THEN 'OWNER 급여'
         WHEN sal = 3000 THEN '고액 급여'
         ELSE '일반 급여' // ELSE 안쓰면 NULL로 채워진다
    END AS 급여구분
FROM emp;