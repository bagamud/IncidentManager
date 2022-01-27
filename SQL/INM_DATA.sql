insert into inm.category (id, parent_id, title)
values  (3, 0, 'Сервисы ИСОД'),
        (4, 0, 'Железо'),
        (1, 0, 'АРМ'),
        (5, 0, 'Прикладное ПО'),
        (2, 0, 'Сеть');

INSERT INTO inm.roles (ID, NAME)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'OPERATOR');

insert into inm.department (code, active, parent_code, short_title, title)
values (1, true, 160, 'OTO ИЦ ГУ МВД России', null),
       (2, true, 160, 'Тыл ГУ МВД России', null),
       (3, true, 160, 'ГСУ ГУ МВД России', null);


INSERT INTO inm.status (ID, TITLE, DONE)
VALUES (1, 'В работе', false),
       (2, 'Отложен', false),
       (3, 'Решен', true);

INSERT INTO inm.users (ID, username, PASSWORD, NAME, role_id, CONTACTS, EMAIL)
VALUES (1, 'kponkratov', '$2a$10$atqierEGsn7HR01qW0jMkebgOiTbirlWv/udHUZlrWZbEs8hgM86G', 'Понкратов Кирилл', 1, '308',
        'kponkratov@');

INSERT INTO inm.priority (ID, /*INFLUENCE, URGENCY, */DESCRIPTION, TERM)
VALUES (1,/* 1, 1,*/ '', 1),
       (2, /*1, 2,*/ 'Hight', 8),
       (3,/* 2, 2,*/ 'Medium', 24),
       (4, /*2, 3, */'Low', 48),
       (5,/* 3, 3,*/ 'Plane', 2160);