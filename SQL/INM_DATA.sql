INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (1, 1, 1, 24, 'CATEGORY', 0);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (2, 2, 2, 7, 'PC', 1);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (3, 2, 8, 13, 'NETWORK', 1);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (4, 2, 14, 23, 'SERVICES', 1);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (5, 3, 3, 4, 'HARDWARE', 2);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (6, 3, 5, 6, 'SOFTWARE', 2);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (7, 3, 9, 10, 'NETWORK-CARD', 3);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (8, 3, 11, 12, 'CABLE', 3);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (9, 3, 15, 16, 'FIS-M', 4);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (10, 3, 17, 18, 'SED', 4);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (11, 3, 19, 20, 'SEP', 4);
INSERT INTO INM.CATEGORY (ID, LEVEL, LEFTKEY, RIGHTKEY, TITLE, PARENT_ID)
VALUES (12, 3, 21, 22, 'SUDIS', 4);

INSERT INTO inm.usersgroup (ID, NAME)
VALUES (1, 'administrator');
INSERT INTO inm.usersgroup (ID, NAME)
VALUES (2, 'operator');
INSERT INTO inm.usersgroup (ID, NAME)
VALUES (3, 'system engineer');
INSERT INTO inm.usersgroup (ID, NAME)
VALUES (4, 'software engineer');

INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (1, '1 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (2, '2 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (3, '3 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (4, '4 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (5, '5 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (6, '6 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (7, '7 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (8, '8 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (9, '9 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (10, '10 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (11, '11 отдел УГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (12, 'ЦАФАП ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (13, 'РОИО ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (14, 'ЦТУДТ ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (15, 'МРЭО ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (16, 'МРЭО ГИБДД № 1');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (17, 'МРЭО ГИБДД № 2');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (18, 'МРЭО ГИБДД № 3');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (19, 'МРЭО ГИБДД № 4');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (20, 'МРЭО ГИБДД № 5');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (21, 'МРЭО ГИБДД № 6');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (22, 'МОТНиРАС ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (23, 'МРЭО ГИБДД № 8');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (24, 'МРЭО ГИБДД № 9');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (25, 'МРЭО ГИБДД № 10');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (26, 'МРЭО ГИБДД № 11');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (27, 'МРЭО ГИБДД № 12');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (28, 'МРЭО ГИБДД № 13');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (29, 'МРЭО ГИБДД № 14');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (30, 'МРЭО ГИБДД № 15');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (31, 'МРЭО ГИБДД № 16');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (32, 'МРЭО ГИБДД № 17');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (33, 'МРЭО ГИБДД № 18');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (34, 'ОСБ ДПС ГИБДД');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (35, 'ОБ ДПС ГИБДД № 1');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (36, 'ОБ ДПС ГИБДД № 2');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (37, 'ОБ ДПС ГИБДД № 3');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (38, 'ОБ ДПС ГИБДД № 4');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (39, 'ОБ ДПС ГИБДД № 5');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (40, 'ОР ДПС ГИБДД № 1');
INSERT INTO INM.DEPARTMENT (ID, TITLE)
VALUES (41, 'ОР ДПС ГИБДД № 2');

INSERT INTO inm.status (ID, TITLE)
VALUES (1, 'В работе');
INSERT INTO inm.status (ID, TITLE)
VALUES (2, 'Отложен');
INSERT INTO inm.status (ID, TITLE)
VALUES (3, 'Решен');

INSERT INTO inm.users (ID, LOGIN, PASSWORD, NAME, USERGROUP, CONTACTS, EMAIL)
VALUES (1, 'kponkratov', '12345', 'Понкратов Кирилл', 1, '308', 'kponkratov@');
INSERT INTO inm.users (ID, LOGIN, PASSWORD, NAME, USERGROUP, CONTACTS, EMAIL)
VALUES (2, 'ashevelev12', '12345', 'Шевелев Анатолий', 4, '179', 'ashevelev12@');
INSERT INTO inm.users (ID, LOGIN, PASSWORD, NAME, USERGROUP, CONTACTS, EMAIL)
VALUES (3, 'iefremov10', '12345', 'Ефремов Иван', 3, '178', 'iefremov10@');
INSERT INTO inm.users (ID, LOGIN, PASSWORD, NAME, USERGROUP, CONTACTS, EMAIL)
VALUES (4, 'ttambovceva', '12345', 'Тамбовцева Татьяна', 2, '322', 'ttambovceva@');

INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (1, 1, 1, 'Critical', 1);
INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (2, 1, 2, 'Hight', 8);
INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (3, 2, 2, 'Medium', 24);
INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (4, 2, 3, 'Low', 48);
INSERT INTO inm.priority (ID, INFLUENCE, URGENCY, DESCRIPTION, TERM)
VALUES (5, 3, 3, 'Plane', 2160);