create table if not exists address
(
    id          uuid         not null,
    name  varchar(255) not null,
    x_coordinate   varchar(25) not null,
    y_coordinate   varchar(25) not null,
    city   varchar(25) not null,
    UNIQUE      (id),
    PRIMARY KEY (id)
);

create table if not exists category
(
    name  varchar(255) not null,
    UNIQUE      (name),
    PRIMARY KEY (name)
);

create table if not exists events
(
    id          uuid         not null,
    date  date not null,
    time time not null ,
    maximum int not null ,
    address uuid,
    users uuid,
    category varchar,
    UNIQUE      (id),
    PRIMARY KEY (id)
);

create table if not exists crowd
(
    id          uuid         not null,
    events uuid,
    users_id uuid,
    UNIQUE      (id),
    PRIMARY KEY (id)
);

ALTER TABLE events ADD CONSTRAINT fk_address FOREIGN KEY (address) references address(id);
ALTER TABLE events ADD CONSTRAINT fk_user FOREIGN KEY (users) references users(id);
ALTER TABLE events ADD CONSTRAINT fk_category FOREIGN KEY (category) references category(name);

ALTER TABLE crowd ADD CONSTRAINT fk_users_id FOREIGN KEY (users_id) references users(id);
ALTER TABLE crowd ADD CONSTRAINT fk_events FOREIGN KEY (events) references events(id);


INSERT INTO  category (name) VALUES ('Баскетбольная площадка');

INSERT INTO  category (name) VALUES ('Футбольная площадка');

INSERT INTO  category (name) VALUES ('Настольный клуб');

INSERT INTO  category (name) VALUES ('Настольный магазин с клубом');
