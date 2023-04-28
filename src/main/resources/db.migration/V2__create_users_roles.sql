CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists roles
(
    name        varchar     not null,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
create table if not exists users
(
    id          uuid         not null,
    firstname  varchar(100) not null,
    lastname   varchar(100) not null,
    role        varchar,
    UNIQUE      (id),
    PRIMARY KEY (id)
);
ALTER TABLE users ADD CONSTRAINT fk_roles FOREIGN KEY (role) references roles(name);

INSERT INTO  roles (name)
VALUES ('ADMIN');

INSERT INTO  roles (name)
VALUES ('USER');
