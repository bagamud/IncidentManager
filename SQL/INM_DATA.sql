INSERT INTO inm.category (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (1, 1, 1, 24, 'CATEGORY', 0),
       (2, 2, 2, 7, 'PC', 1),
       (3, 2, 8, 13, 'NETWORK', 1),
       (4, 2, 14, 23, 'SERVICES', 1),
       (5, 3, 3, 4, 'HARDWARE', 2),
       (6, 3, 5, 6, 'SOFTWARE', 2),
       (7, 3, 9, 10, 'NETWORK-CARD', 3),
       (8, 3, 11, 12, 'CABLE', 3),
       (9, 3, 15, 16, 'FIS-M', 4),
       (10, 3, 17, 18, 'SED', 4),
       (11, 3, 19, 20, 'SEP', 4),
       (12, 3, 21, 22, 'SUDIS', 4);

INSERT INTO inm.roles (ID, NAME)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'OPERATOR');

insert into inm.department (code, active, parent_code, short_title, title)
values (1, true, 160, 'ИЦ ГУ МВД России', null),
       (2, true, 160, 'Тыл ГУ МВД России', null),
       (3, true, 160, 'ГСУ ГУ МВД России', null);


insert into inm.post (id, title)
values (1, 'Заместитель начальника центра (вычислительного)');


INSERT INTO inm.status (ID, TITLE, DONE)
VALUES (1, 'В работе', false),
       (2, 'Отложен', false),
       (3, 'Решен', true);

INSERT INTO inm.users (ID, username, PASSWORD, NAME, role_id, CONTACTS, EMAIL)
VALUES (1, 'kponkratov', '$2a$10$atqierEGsn7HR01qW0jMkebgOiTbirlWv/udHUZlrWZbEs8hgM86G', 'Понкратов Кирилл', 1, '308',
        'kponkratov@'),
       (2, 'ashevelev12', '$2a$10$K5e6OPjkWp4YLWQzWigTXuXNVnwSvPVUfS030vpf3GQeoU07zLqkq', 'Шевелев Анатолий', 2, '179',
        'ashevelev12@'),
       (3, 'iefremov10', '$2a$10$2qav1OsfMgk2CoCONY5OOeTtoRwItgL7Kmdj7L32yjQePWkDgO6sC', 'Ефремов Иван', 1, '178',
        'iefremov10@'),
       (4, 'ttambovceva', '$2a$10$ysJ4M.eROavCKu/KMMo9FuA9x1hFSPlGmvg1E8XPuWd5Y5u6Ps2Xa', 'Тамбовцева Татьяна', 2,
        '322', 'ttambovceva@'),
       (5, 'nanokhin2', '$2a$10$iFC/FRdWQ0TV6/mDGe6dsODhRcB3agjpOTCQNc3rir8FMIk.TkvdO', 'Анохин Николай', 2, '130',
        'nanokhin2@');

INSERT INTO inm.priority (ID, /*INFLUENCE, URGENCY, */DESCRIPTION, TERM)
VALUES (1,/* 1, 1,*/ 'Critical', 1),
       (2, /*1, 2,*/ 'Hight', 8),
       (3,/* 2, 2,*/ 'Medium', 24),
       (4, /*2, 3, */'Low', 48),
       (5,/* 3, 3,*/ 'Plane', 2160);