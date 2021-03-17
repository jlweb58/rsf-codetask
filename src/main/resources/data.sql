
insert into station(id, name)
values (111, 'Munich'),
       (112, 'Berlin'),
       (113, 'Frankfurt');



insert into equipment_type(id, name)
values (111, 'Camping Table'),
       (112, 'Kitchen Box'),
       (113, 'Toilet'),
       (114, 'Camping Chair');

insert into campervan(id, name, platenumber)
values (111, 'Bulli', 'M RC 1111'),
       (112, 'Bulli', 'M RC 1112'),
       (113, 'Bulli', 'M RC 1113'),
       (114, 'Bulli', 'M RC 1114'),
       (115, 'Bulli', 'M RC 1115'),
       (116, 'Bulli', 'M RC 1116'),
       (117, 'Bulli', 'M RC 1117'),
       (118, 'Bulli', 'M RC 1118'),
       (119, 'Bulli', 'M RC 1119');


insert into rental_order(id, start_station_id, end_station_id, campervan_id, start_date, end_date)
values (111, 111, 111, 119, now(), now());

insert into equipment(id, equipment_type_id, station_id, rental_order_id)
values (111, 111, 111, 111),
       (112, 111, 112, null),
       (113, 111, 113, null),
       (114, 112, 111, 111),
       (115, 112, 112, null),
       (116, 112, 113, null),
       (117, 113, 111, null),
       (118, 113, 112, null);

