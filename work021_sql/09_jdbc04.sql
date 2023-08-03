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

create table company
       (name varchar(255) primary key,
       address varchar(255));
       
create table card
       (card_id varchar(255) primary key,
       customer_id varchar(255),
       expire date,
       name varchar(255),
       grade number);
       
create table customer
       (customer_id varchar(255) primary key,
       name varchar(255),
       address varchar(255),
       phone varchar(255));
       
create table purchase
       (id number primary key,
       customer_id varchar(255),
       card_id varchar(255),
       day date,
       price number,
       category varchar(255));
    
drop table purchase;
drop table card;
drop table customer;
drop table company;

ALTER TABLE card ADD CONSTRAINT fk_card_customer_id foreign key(customer_id) references customer(customer_id) ON DELETE CASCADE;
ALTER TABLE card ADD CONSTRAINT fk_card_company_name foreign key(name) references company(name) ON DELETE CASCADE;

ALTER TABLE purchase ADD CONSTRAINT fk_purchase_customer_id foreign key(customer_id) references customer(customer_id) ON DELETE CASCADE;
ALTER TABLE purchase ADD CONSTRAINT fk_purchase_card_id foreign key(card_id) references card(card_id) ON DELETE CASCADE;

CREATE SEQUENCE seq_purchase
START WITH 1
INCREMENT BY 1;

truncate table company; 
truncate table card;
truncate table purchase;
truncate table customer;

INSERT INTO company VALUES ('»ï¼º','aaa');
INSERT INTO company VALUES ('·Ôµ¥','bbb');
select * from company;

INSERT INTO customer VALUES ('mesh153','Á¶¿øÇü','23/01/23','01036493276');
INSERT INTO customer VALUES ('aaddee','±è°Ç¸ð','23/01/20','0102223333');
INSERT INTO customer VALUES ('bbccdd','¹Ì¹Ì¹Ì','23/12/02','0103332221');
INSERT INTO customer VALUES ('ffddww','¸ð¸ð¸ð','23/01/23','40599493');
select * from customer;

INSERT INTO card (card_id, customer_id, expire, name) VALUES ('999-999-999','mesh153','29/01/23','»ï¼º');
INSERT INTO card (card_id, customer_id, expire, name) VALUES ('888-888-888','aaddee','33/01/23','·Ôµ¥');
select * from card;

INSERT INTO purchase (id, customer_id, card_id, day, price, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/23', 302000, '±³Åë');
INSERT INTO purchase (id, customer_id, card_id, day, price, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/25', 34200, 'ºäÆ¼');
INSERT INTO purchase (id, customer_id, card_id, day, price, category) VALUES (seq_purchase.nextVal, 'mesh153', '999-999-999', '25/06/27', 25000, '½Ä»ç');
select * from purchase;       

//cascade test
delete customer where customer_id = 'mesh153';
delete company where name = '»ï¼º';
