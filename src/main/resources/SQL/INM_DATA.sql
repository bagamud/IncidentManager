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

INSERT INTO inm.department (ID, TITLE)
VALUES (1, '1 отдел УГИБДД'),
       (2, '2 отдел УГИБДД'),
       (3, '3 отдел УГИБДД'),
       (4, '4 отдел УГИБДД'),
       (5, '5 отдел УГИБДД'),
       (6, '6 отдел УГИБДД'),
       (7, '7 отдел УГИБДД'),
       (8, '8 отдел УГИБДД'),
       (9, '9 отдел УГИБДД'),
       (10, '10 отдел УГИБДД'),
       (11, '11 отдел УГИБДД'),
       (12, 'ЦАФАП ГИБДД'),
       (13, 'РОИО ГИБДД'),
       (14, 'ЦТУДТ ГИБДД'),
       (15, 'МРЭО ГИБДД'),
       (16, 'МРЭО ГИБДД № 1'),
       (17, 'МРЭО ГИБДД № 2'),
       (18, 'МРЭО ГИБДД № 3'),
       (19, 'МРЭО ГИБДД № 4'),
       (20, 'МРЭО ГИБДД № 5'),
       (21, 'МРЭО ГИБДД № 6'),
       (22, 'МОТНиРАС ГИБДД'),
       (23, 'МРЭО ГИБДД № 8'),
       (24, 'МРЭО ГИБДД № 9'),
       (25, 'МРЭО ГИБДД № 10'),
       (26, 'МРЭО ГИБДД № 11'),
       (27, 'МРЭО ГИБДД № 12'),
       (28, 'МРЭО ГИБДД № 13'),
       (29, 'МРЭО ГИБДД № 14'),
       (30, 'МРЭО ГИБДД № 15'),
       (31, 'МРЭО ГИБДД № 16'),
       (32, 'МРЭО ГИБДД № 17'),
       (33, 'МРЭО ГИБДД № 18'),
       (34, 'ОСБ ДПС ГИБДД'),
       (35, 'ОБ ДПС ГИБДД № 1'),
       (36, 'ОБ ДПС ГИБДД № 2'),
       (37, 'ОБ ДПС ГИБДД № 3'),
       (38, 'ОБ ДПС ГИБДД № 4'),
       (39, 'ОБ ДПС ГИБДД № 5'),
       (40, 'ОР ДПС ГИБДД № 1'),
       (41, 'ОР ДПС ГИБДД № 2');

INSERT INTO inm.status (ID, TITLE)
VALUES (1, 'В работе'),
       (2, 'Отложен'),
       (3, 'Решен');

INSERT INTO inm.users (ID, username, PASSWORD, NAME, role, CONTACTS, EMAIL)
VALUES (1, 'kponkratov', '$2a$10$iFC/FRdWQ0TV6/mDGe6dsODhRcB3agjpOTCQNc3rir8FMIk.TkvdO', 'Понкратов Кирилл', 1, '308',
        'kponkratov@'),
       (2, 'ashevelev12', '$2a$10$K5e6OPjkWp4YLWQzWigTXuXNVnwSvPVUfS030vpf3GQeoU07zLqkq', 'Шевелев Анатолий', 2, '179',
        'ashevelev12@'),
       (3, 'iefremov10', '$2a$10$2qav1OsfMgk2CoCONY5OOeTtoRwItgL7Kmdj7L32yjQePWkDgO6sC', 'Ефремов Иван', 1, '178',
        'iefremov10@'),
       (4, 'ttambovceva', '$2a$10$ysJ4M.eROavCKu/KMMo9FuA9x1hFSPlGmvg1E8XPuWd5Y5u6Ps2Xa', 'Тамбовцева Татьяна', 2,
        '322', 'ttambovceva@'),
       (5, 'nanokhin2', '$2a$10$iFC/FRdWQ0TV6/mDGe6dsODhRcB3agjpOTCQNc3rir8FMIk.TkvdO', 'Анохин Николай', 2, '130',
        'nanokhin2@');


INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (1, 1, 1, 'Critical', 1),
       (2, 1, 2, 'Hight', 8),
       (3, 2, 2, 'Medium', 24),
       (4, 2, 3, 'Low', 48),
       (5, 3, 3, 'Plane', 2160);