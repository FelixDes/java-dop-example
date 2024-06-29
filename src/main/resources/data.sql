insert into CUSTOMER(NAME)
values ('Brian'),
       ('Alex');

insert into PURCHASE(CUSTOMER_ID)
values (select id from CUSTOMER where name = 'Brian'),
       (select id from CUSTOMER where name = 'Alex'),
       (select id from CUSTOMER where name = 'Alex');

insert into PRODUCT(NAME)
values ('headphones'),
       ('smartphone'),
       ('notebook'),
       ('charger');

insert into PURCHASE_PRODUCT(PRODUCT_ID, PURCHASE_ID)
values (1, 1),
       (2, 1),
       (3, 2),
       (4, 3);