drop table if exists purchase_product cascade;
drop table if exists product cascade;
drop table if exists purchase cascade;
drop table if exists customer cascade;

create table if not exists customer
(
    id   uuid default random_uuid() primary key,
    name varchar not null
);

create table if not exists purchase
(
    id          bigint auto_increment primary key,
    customer_id uuid not null,
    foreign key (customer_id) references customer
);

create table if not exists product
(
    id   bigint auto_increment primary key,
    name varchar not null
);

create table if not exists purchase_product
(
    id          bigint auto_increment primary key,
    product_id  bigint not null,
    purchase_id bigint not null,
    unique (product_id, purchase_id),
    foreign key (product_id) references product,
    foreign key (purchase_id) references purchase
);