alter table tokens drop constraint tokens_user_id_fkey;
alter table tokens add foreign key (user_id) references users(id) on delete cascade;
