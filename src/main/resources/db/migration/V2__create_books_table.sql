create table if not exists public.books
(
    id         serial
        primary key,
    title       varchar(255),
    is_handled      boolean default false,
    user_id        integer
        constraint fk_book_user references public.users
);