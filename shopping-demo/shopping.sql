drop table if exists shopping;
create table shopping(
    id int not null auto_increment,
    name varchar(32) not null,
    date varchar(32) not null,
    price int not null,
    num int not null,
    primary key (id)
)engine=InnoDB auto_increment=1 default charset=utf8;

insert into shopping(name,date,price,num) values ('小米','2020-4-5 11:23:40','4000','2');
