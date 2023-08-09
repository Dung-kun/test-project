use testproject;
create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
	code varchar(255) not null,
    createddate timestamp null,
    modiffieddate timestamp null,
    createdby varchar(255) null,
    modiffiedby varchar(255) null
);

create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
	fullname varchar(255) not null,
    password varchar(255) not null,
    status int not null,
    createddate timestamp null,
    modiffieddate timestamp null,
    createdby varchar(255) null,
    modiffiedby varchar(255) null
);

alter table user
add roleid bigint not null;
alter table user add constraint fk_user_role foreign key (roleid) references role(id);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(255) null,
    shortdescription text  null,
    content text null,
	categoryid bigint not null,
    createddate timestamp null,
    modiffieddate timestamp null,
    createdby varchar(255) null,
    modiffiedby varchar(255) null
);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
	code varchar(255) not null,
    createddate timestamp null,
    modiffieddate timestamp null,
    createdby varchar(255) null,
    modiffiedby varchar(255) null
);
alter table news add constraint fk_news_category foreign key (categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
    userid bigint not null,
    newid bigint not null,
    content varchar(255) not null,
    createddate timestamp null,
    modiffieddate timestamp null,
    createdby varchar(255) null,
    modiffiedby varchar(255) null
);
alter table comment add constraint fk_comment_news foreign key (newid) references news(id);
alter table comment add constraint fk_comment_user foreign key (userid) references user(id);


