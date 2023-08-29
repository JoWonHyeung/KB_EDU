CREATE TABLE USERINFO ( 
	userId varchar2(12) primary key, 
	password varchar2(12) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(50));

INSERT INTO USERINFO VALUES('admin', 'admin', '관리자', 'admin@jaen.com');
INSERT INTO USERINFO VALUES('java', 'java', '자바지기', 'java@jaen.com');
INSERT INTO USERINFO VALUES('bnk', '1234', '연수생', 'bnk@jaen.com');
commit;