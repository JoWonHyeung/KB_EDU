CREATE TABLE USERINFO ( 
	userId varchar2(12) primary key, 
	password varchar2(12) NOT NULL,
	name varchar2(20) NOT NULL,
	email varchar2(50));

INSERT INTO USERINFO VALUES('admin', 'admin', '������', 'admin@jaen.com');
INSERT INTO USERINFO VALUES('java', 'java', '�ڹ�����', 'java@jaen.com');
INSERT INTO USERINFO VALUES('bnk', '1234', '������', 'bnk@jaen.com');
commit;