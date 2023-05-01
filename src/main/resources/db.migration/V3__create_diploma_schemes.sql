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
    creator uuid,
    category varchar,
    FOREIGN KEY (creator) references users(id) on DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE      (id),
    PRIMARY KEY (id)
);

create table if not exists crowd
(
    id          uuid         not null,
    events uuid,
    teammate uuid,
    UNIQUE      (id),
    PRIMARY KEY (id),
    FOREIGN KEY (events) references events(id) on DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (teammate) references users(id) on DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE events ADD CONSTRAINT fk_address FOREIGN KEY (address) references address(id);
ALTER TABLE events ADD CONSTRAINT fk_creator FOREIGN KEY (creator) references users(id);
ALTER TABLE events ADD CONSTRAINT fk_category FOREIGN KEY (category) references category(name);

ALTER TABLE crowd ADD CONSTRAINT crowd_fk_teammate FOREIGN KEY (teammate) references users(id);
ALTER TABLE crowd ADD CONSTRAINT crowd_fk_events FOREIGN KEY (events) references events(id) on delete cascade on update cascade ;


INSERT INTO  category (name) VALUES ('Баскетбольная площадка');

INSERT INTO  category (name) VALUES ('Футбольная площадка');

INSERT INTO  category (name) VALUES ('Настольный клуб');

INSERT INTO  category (name) VALUES ('Настольный магазин с клубом');
