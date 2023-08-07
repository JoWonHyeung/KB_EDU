create table customer
       (ssn varchar2(30) primary key,
       cust_name varchar2(30) not null,
       address varchar2(50) not null ) ; 
 
create table stock
       (symbol varchar2(30) primary key,
       price number(10,2) not null) ; 
 
create table shares
       (ssn varchar2(30) not null,
       symbol varchar2(20) not null,
       quantity number(5) not null) ; 
 
insert into stock ( symbol,price) values( 'SUNW', 68.75);
insert into stock ( symbol,price) values( 'CyAs', 22.675);
insert into stock ( symbol,price) values( 'DUKE', 6.25);
insert into stock ( symbol,price) values( 'ABStk', 18.5);
insert into stock ( symbol,price) values( 'JSVco', 9.125);
insert into stock ( symbol,price) values( 'TMAs', 82.375);
insert into stock ( symbol,price) values( 'BWInc', 11.375);
insert into stock ( symbol,price) values( 'GMEnt', 44.625);
insert into stock ( symbol,price) values( 'PMLtd', 203.375);
insert into stock ( symbol,price) values( 'JDK', 33.5);
insert into customer values( '111-111', 'Yufirst1', 'Seoul');
insert into customer values( '111-112', 'Yufirst2', 'Seoul');
insert into customer values( '111-113', 'Yufirst3', 'Seoul');
insert into customer values( '111-114', 'Yufirst4', 'Seoul');
insert into customer values( '111-115', 'yufirst5', 'JeonJu');
insert into customer values( '111-116', 'Yufirst6', 'Seoul');
insert into customer values( '111-117', 'Yufirst7', 'Seoul');
insert into customer values( '111-118', 'Yufirst8', 'Seoul');
insert into customer values( '111-119', 'Yufirst9', 'Seoul');

commit;

ALTER TABLE shares ADD CONSTRAINT fk_shares_ssn foreign key(ssn) references customer(ssn) ON DELETE CASCADE;
ALTER TABLE shares ADD CONSTRAINT fk_shares_symbol foreign key(symbol) references stock(symbol) ON DELETE CASCADE;

SELECT * FROM shares;

/////////////////////////////////////////////////////

--create table company
--       (company_name varchar(255) primary key,
--       address varchar(255));
       
create table card
       (card_id varchar(255) primary key,
       expire_date date,
       company_name varchar(255),
       cust_grade varchar(255));
       
create table cust
       (ssn varchar(255) primary key,
       cust_name varchar(255),
       cust_address varchar(255),
       phone varchar(255));
       
create table purchase
       (id number primary key,
       ssn varchar(255),
       card_id varchar(255),
       day date,
       price number,
       company_name varchar(255),
       category varchar(255));
    
drop table purchase;
drop table card;
drop table cust;
//drop table company;


//ALTER TABLE card ADD CONSTRAINT fk_card_company_name foreign key(company_name) references company(company_name) ON DELETE CASCADE;

ALTER TABLE purchase ADD CONSTRAINT fk_purchase_cust_id foreign key(ssn) references cust(ssn) ON DELETE CASCADE;
ALTER TABLE purchase ADD CONSTRAINT fk_purchase_card_id foreign key(card_id) references card(card_id) ON DELETE CASCADE;

CREATE SEQUENCE seq_purchase
START WITH 1
INCREMENT BY 1;

truncate table card;
truncate table purchase;
truncate table cust;
--
--INSERT INTO company VALUES ('»ï¼º','aaa');
--INSERT INTO company VALUES ('·Ôµ¥','bbb');
--select * from company;

INSERT INTO cust VALUES ('mesh153','Á¶¿øÇü','23/01/23','01036493276');
INSERT INTO cust VALUES ('aaddee','±è°Ç¸ð','23/01/20','0102223333');
INSERT INTO cust VALUES ('bbccdd','¹Ì¹Ì¹Ì','23/12/02','0103332221');
INSERT INTO cust VALUES ('ffddww','¸ð¸ð¸ð','23/01/23','40599493');

INSERT INTO cust VALUES ('a1','aaabbbb','23/01/23','01036493276');
INSERT INTO cust VALUES ('b1','ddddd','23/01/23','01036493276');
INSERT INTO cust VALUES ('c1','cccccc','23/01/23','01036493276');
INSERT INTO cust VALUES ('d1','fffff','23/01/23','01036493276');
select * from cust;

INSERT INTO card (card_id, expire_date, company_name) VALUES ('123-456-789','29/01/23','»ï¼º');
INSERT INTO card (card_id, expire_date, company_name) VALUES ('234-567-890','29/01/23','·Ôµ¥');
INSERT INTO card (card_id, expire_date, company_name) VALUES ('888-888-888','33/01/23','');
select * from card;

INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/23', 302000, '»ï¼º', '±³Åë');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/20', 2000, '»ï¼º', '±³Åë');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/25', 34200, '»ï¼º', 'ºäÆ¼');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/05/25', 24200, '»ï¼º', '±â±â');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/27', 25000, '»ï¼º', '½Ä»ç');
INSERT INTO purchase (id, ssn, card_id, day, price, company_name, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/23', 302000, '·Ôµ¥', '±³Åë');
select * from purchase;       

commit;

//cascade test
delete cust where ssn = 'mesh153';
delete card where card_id = '999-999-999';
