create table users(
    id bigint not null auto_increment,
    username varchar(100) not null unique,
    password varchar(255) not null,
    email varchar(100) not null unique,
    name varchar(100) not null,
    role varchar (10) not null default 'USER',
    phone varchar(20) not null,
    active tinyint(1) not null default 1,
    created_at datetime default current_timestamp,
    updated_at datetime default current_timestamp,

    primary key(id)
)