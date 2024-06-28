insert into CUSTOMER(NAME)
values ('Brian'),
       ('Alex');

insert into PURCHASE(CUSTOMER_ID)
values (select id from CUSTOMER where name = 'Brian'),
       (select id from CUSTOMER where name = 'Alex'),
       (select id from CUSTOMER where name = 'Alex');

insert into PRODUCT(NAME, PURCHASE_ID)
values ('headphones', 1),
       ('smartphone', 1),
       ('notebook', 2),
       ('charger', 3);