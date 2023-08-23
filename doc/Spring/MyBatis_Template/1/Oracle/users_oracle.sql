DROP TABLE users;

CREATE TABLE users ( 
user_id      VARCHAR2(30)   PRIMARY KEY,
user_name   VARCHAR2(30)   NOT NULL,
password    VARCHAR2(30)    NOT NULL,
age         number(3),
grade       number(3),
reg_date     DATE  );

INSERT INTO users VALUES('user01','ȫ�浿','user01',10,1,'2019-10-11'); 
INSERT INTO users VALUES('user02','�̼���','user02',20,2, '2019-10-12');
INSERT INTO users VALUES('user03','������','user03',30,3, '2019-10-09'); 
INSERT INTO users VALUES('mybatis01','ȫ�浿iba','mybatis01',10,1,'2019-10-08');
INSERT INTO users VALUES('mybatis02','�̼���iba','mybatis02',20,2, '2019-10-07');
INSERT INTO users VALUES('mybatis03','������iba','mybatis03',30,3,'2019-10-02');

COMMIT;
