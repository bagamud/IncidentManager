# CREATE SCHEMA incidentManager DEFAULT CHARACTER SET utf8mb4;
CREATE TABLE incidentManager.CATEGORY (
                                          CATEGORY_ID INT PRIMARY KEY,
                                          CATEGORY_TITLE VARCHAR(255),
                                          CATEGORY_DESCRIPTION TEXT
);

CREATE TABLE incidentManager.DEPARTMENT (
                                            DEPARTMENT_ID INT PRIMARY KEY,
                                            DEPARTMENT_TITLE VARCHAR(255) NOT NULL
);

CREATE TABLE incidentManager.USERS (
                                       USER_ID INT AUTO_INCREMENT UNIQUE,
                                       USER_LOGIN VARCHAR(255) NOT NULL,
                                       USER_PASSWORD VARCHAR(255) NOT NULL,
                                       USER_NAME VARCHAR(255) NOT NULL,
                                       USER_GROUP ENUM ('administrator', 'operator', 'engineer', 'manager', 'user'),
                                       USER_EMAIL VARCHAR(255)
);

CREATE TABLE incidentManager.INC_STATUS (
                                            STATUS_ID INT PRIMARY KEY,
                                            STATUS_TITLE ENUM ('в работе', 'отложено', 'решено')
);
CREATE TABLE incidentManager.INCIDENT (
                                          INCIDENT_ID INT PRIMARY KEY AUTO_INCREMENT,
                                          INCIDENT_DATE TIMESTAMP NOT NULL,
                                          INCIDENT_CATEGORY INT(10) NOT NULL,
                                          INCIDENT_PRIORITY VARCHAR(20) NOT NULL,
                                          REQUESTER_DEPARTMENT INT NOT NULL,
                                          REQUESTER VARCHAR(255) NOT NULL,
                                          REQUESTER_CONTACTS VARCHAR(255) NOT NULL,
                                          IP_ADDRESS VARCHAR(16),
                                          INCIDENT_DURATION INT(10),
                                          INCIDENT_DESCRIPTION VARCHAR(255),
                                          ENGINEER INT(10),
                                          OPERATOR INT(10) NOT NULL,
                                          INCIDENT_STATUS INT(10) NOT NULL,
                                          INCIDENT_CLOSEDATE TIMESTAMP,
                                          INCIDENT_JOURNAL TEXT,
                                          CONSTRAINT FK_CATEGORY FOREIGN KEY (INCIDENT_CATEGORY)
                                              REFERENCES CATEGORY (CATEGORY_ID),
                                          CONSTRAINT FK_DEPARTMENT FOREIGN KEY (REQUESTER_DEPARTMENT)
                                              REFERENCES DEPARTMENT (DEPARTMENT_ID),
                                          CONSTRAINT FK_ENGINEER FOREIGN KEY (ENGINEER)
                                              REFERENCES USERS (USER_ID),
                                          CONSTRAINT FK_OPERATOR FOREIGN KEY (OPERATOR)
                                              REFERENCES USERS (USER_ID),
                                          CONSTRAINT FK_STATUS FOREIGN KEY (INCIDENT_STATUS)
                                              REFERENCES INC_STATUS (STATUS_ID)
) 