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

INSERT INTO book VALUES('1233-111-111','Java �ϼ�','���α׷���','��������',
         '2019.1.1','�繫��','�繫��',3000,'��','java�� ������');
INSERT INTO book VALUES('1233-111-123','Spring �ٽ�����','���α׷���','��������',
         '2023.8.2','�繫��','�繫��',4000,'��','java�� ����');
INSERT INTO book VALUES('1233-111-222','AI����','���α׷���','���ܵ���',
         '2020.4.21','�繫��','�繫��',6000,'��',',,AI�� ����');
commit;