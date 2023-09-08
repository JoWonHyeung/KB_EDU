
drop table phones purge;
drop table company purge;
drop table userinfo purge;


create table company(
	vcode char(2) primary key,
	vendor varchar2(20) not null
);

insert into company values('10', '»ï¼º');
insert into company values('20', 'LG');
insert into company values('30', '·¡ÇÃ');

create table phones(
	num char(5) primary key,
	model varchar2(30) not null,
	price number not null,
	vcode char(2),
	constraint fk_vcode foreign key(vcode) references company(vcode)
);
insert into phones values('S105G','°¶·°½Ã S10 5G',1397000,'10');
insert into phones values('V50SQ','LG V505 ThinQ',1199000,'20');

create table userinfo(
	id varchar2(20) primary key,
	pw varchar2(20) not null
);

insert into userinfo values('bnk','bnk');
insert into userinfo values('admin','admin');

commit;













