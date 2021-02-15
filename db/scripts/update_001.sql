create table IF NOT EXISTS items (
    id serial primary key not null,
    name varchar(2000),
    created timestamp
);