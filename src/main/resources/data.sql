insert into equipment_type(id, name)
values (1, 'Camping Table'),
       (2, 'Kitchen Box'),
       (3, 'Toilet'),
       (4, 'Camping Chair');

insert into equipment(id, equipment_type_id)
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 3),
       (8, 3);

insert into campervan(id, name, platenumber)
values (1, 'Bulli', 'M RC 1111'),
       (2, 'Bulli', 'M RC 1112'),
       (3, 'Bulli', 'M RC 1113'),
       (4, 'Bulli', 'M RC 1114'),
       (5, 'Bulli', 'M RC 1115'),
       (6, 'Bulli', 'M RC 1116'),
       (7, 'Bulli', 'M RC 1117'),
       (8, 'Bulli', 'M RC 1118'),
       (9, 'Bulli', 'M RC 1119');



    insert into station(id, name)
values (1, 'Munich'),
       (2, 'Berlin'),
       (3, 'Frankfurt');

insert into rental_order(id, start_station_id, end_station_id, campervan_id, start_date, end_date)
values (111, 1, 1, 9, now(), now());