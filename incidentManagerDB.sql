CREATE TABLE incidentManager.CATEGORY (
    CATEGORY_ID INT PRIMARY KEY UNIQUE,
    CATEGORY_TITLE VARCHAR(255)
);

CREATE TABLE incidentManager.DEPARTMENT (
    DEPARTMENT_ID INT PRIMARY KEY UNIQUE,
    DEPARTMENT_TITLE VARCHAR(255) NOT NULL
);

CREATE TABLE incidentManager.USERS (
    USER_ID INT PRIMARY KEY,
    LOGIN VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    USER_GROUP VARCHAR(255),
    USER_NAME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255)
);

CREATE TABLE incidentManager.INC_STATUS (
    STATUS_ID INT NOT NULL,
    STATUS_TITLE VARCHAR(255)
);
CREATE TABLE incidentManager.INCIDENT (
    INCIDENT_ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    INCIDENT_DATE TIMESTAMP NOT NULL,
    INCIDENT_CATEGORY VARCHAR(255) NOT NULL,
    INCIDENT_PRIORITY VARCHAR(20) NOT NULL,
    REQUESTER_DEPARTMENT VARCHAR(255) NOT NULL,
    REQUESTER VARCHAR(255) NOT NULL,
    REQUESTER_CONTACTS VARCHAR(255) NOT NULL,
    IP_ADDRESS VARCHAR(16),
    INCIDENT_DURATION INT,
    INCIDENT_DESCRIPTION VARCHAR(255),
    ENGINEER VARCHAR(255),
    OPERATOR VARCHAR(255) NOT NULL,
    INCIDENT_STATUS VARCHAR(20) NOT NULL,
    INCIDENT_CLOSEDATE TIMESTAMP-- ,
	-- CONSTRAINT FK_CATEGORY FOREIGN KEY (INCIDENT_CATEGORY)
--          REFERENCES CATEGORY (CATEGORY_TITLE),
--     CONSTRAINT FK_DEPARTMENT FOREIGN KEY (REQUESTER_DEPARTMENT)
--         REFERENCES DEPARTMENT (DEPARTMENT_TITLE),
--     CONSTRAINT FK_ENGINEER FOREIGN KEY (ENGINEER)
--         REFERENCES USERS (USER_NAME),
--     CONSTRAINT FK_OPERATOR FOREIGN KEY (OPERATOR)
--         REFERENCES USERS (USER_NAME),
--     CONSTRAINT FK_STATUS FOREIGN KEY (INCIDENT_STATUS)
--         REFERENCES INC_STATUS (STATUS_TITLE)
)