create table news_user(
id int(4) auto_increment ,
username varchar(20) not null unique,
password varchar(40) not null ,
level int(2),
primary key(id)
)ENGINE=INNODB;

create table news(
id int(4) auto_increment,
topic_id int(4) not null,
title varchar(40) not null ,
content varchar(400) ,
time date,
 primary key(id),
index(topic_id),
foreign key(topic_id)
references news_topic(id)
)ENGINE=INNODB;


create table news_topic(
id int(4) auto_increment,
name varchar(20) not null UNIQUE ,
level int(3),
primary key(id)
)ENGINE=INNODB;

