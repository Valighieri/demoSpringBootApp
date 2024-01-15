create table if not exists public.history
(
    id         serial
        primary key,
    user_id        integer
        constraint fk_history_user references public.users,
    book_id        integer
        constraint fk_history_book references public.books,
    borrow_date timestamp,
    return_date timestamp
);