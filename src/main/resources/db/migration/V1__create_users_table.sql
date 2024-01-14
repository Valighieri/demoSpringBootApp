create table if not exists public.users
(
    id         serial
    primary key,
    name       varchar(255),
    email      varchar(255)
);