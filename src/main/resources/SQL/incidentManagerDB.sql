# CREATE SCHEMA inm;

CREATE TABLE inm.category
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    Level     INT         NOT NULL,
    leftkey   INT         NOT NULL,
    Rightkey  INT         NOT NULL,
    title     VARCHAR(45) NOT NULL,
    Parent_ID INT         NOT NULL,
    INDEX leftkey (leftkey, rightkey, level)
);

CREATE TABLE inm.department
(
    id    INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE inm.roles
(
    id   INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE inm.users
(
    id       INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    roles    INT          NOT NULL,
    contacts VARCHAR(255),
    email    VARCHAR(255),
    CONSTRAINT fk_roles FOREIGN KEY (ROLES)
        REFERENCES roles (id)
);

CREATE TABLE inm.status
(
    id    INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE inm.priority
(
    id          INT PRIMARY KEY,
    influence   INT          NOT NULL,
    urgency     INT          NOT NULL,
    description VARCHAR(100) NOT NULL,
    term        INT          NOT NULL
);

CREATE TABLE inm.incident
(
    id                  INT PRIMARY KEY AUTO_INCREMENT,
    date                TIMESTAMP    NOT NULL,
    category            INT          NOT NULL,
    priority            INT          NOT NULL,
    requesterdepartment INT          NOT NULL,
    requester           VARCHAR(255) NOT NULL,
    requestercontacts   VARCHAR(45)  NOT NULL,
    ipaddress           VARCHAR(16),
    duration            INT,
    description         VARCHAR(255),
    engineer            int,
    operator            INT          NOT NULL,
    status              int          NOT NULL,
    closedate           TIMESTAMP,
    journal             TEXT,
    CONSTRAINT fk_category FOREIGN KEY (category)
        REFERENCES category (id),
    CONSTRAINT fk_priority FOREIGN KEY (PRIORITY)
        REFERENCES priority (id),
    CONSTRAINT fk_department foreign key (requesterdepartment)
        references department (id),
    CONSTRAINT fk_engineer FOREIGN KEY (engineer)
        REFERENCES users (id),
    CONSTRAINT fk_operator FOREIGN KEY (operator)
        REFERENCES users (id),
    CONSTRAINT fk_status FOREIGN KEY (status)
        REFERENCES status (id)
);
