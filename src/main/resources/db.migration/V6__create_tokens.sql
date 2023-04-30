create table if not exists tokens(
                                     user_id uuid not null,
                                     value varchar(255) not null,
                                     killed bool,
                                     primary key(user_id),
                                     unique (user_id),
                                     unique (value),
                                     FOREIGN KEY (user_id) references users(id) on DELETE CASCADE ON UPDATE CASCADE
);
alter table tokens add foreign key (user_id) references users(id) on delete cascade on update cascade