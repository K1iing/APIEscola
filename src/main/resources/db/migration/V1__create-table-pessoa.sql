create table pessoas (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade int not null,
    escola varchar(50) not null,
    classe varchar(50) not null,
    primary key (id)
);
