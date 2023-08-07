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