create table book(
isbn char(12) not null,
title varchar2(100) not null,
catalogue varchar2(50) not null,
nation varchar2(50),
publish_date date,
publisher varchar2(100),
author varchar2(100) not null,
price number(6,0) not null,
currency char(6),
description varchar2(4000),
 constraint "book_pk" primary key(isbn));

INSERT INTO book VALUES('1233-111-111','Java 완성','프로그래밍','국내도서',
         '2019.1.1','사무국','사무국',3000,'원','java를 마시자');
INSERT INTO book VALUES('1233-111-123','Spring 핵심정리','프로그래밍','국내도서',
         '2023.8.2','사무국','사무국',4000,'원','java와 동행');
INSERT INTO book VALUES('1233-111-222','AI정복','프로그래밍','국외도서',
         '2020.4.21','사무국','사무국',6000,'원',',,AI와 동행');
commit;