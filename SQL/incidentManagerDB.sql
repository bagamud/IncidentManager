CREATE TABLE INM.CATEGORY (
                              CATEGORY_ID INT PRIMARY KEY,
                              CATEGORY_TITLE VARCHAR(255),
                              CATEGORY_DESCRIPTION TEXT
);

CREATE TABLE INM.DEPARTMENT (
                                DEPARTMENT_ID INT PRIMARY KEY,
                                DEPARTMENT_TITLE VARCHAR(255) NOT NULL
);

CREATE TABLE INM.USERS_GROUP (
                                 GROUP_ID INT PRIMARY KEY,
                                 GROUP_NAME VARCHAR(255)
);

CREATE TABLE INM.USERS (
                           USER_ID INT PRIMARY KEY,
                           USER_LOGIN VARCHAR(255) NOT NULL,
                           USER_PASSWORD VARCHAR(255) NOT NULL,
                           USER_NAME VARCHAR(255) NOT NULL,
                           USER_GROUP INT(10),
                           USER_CONTACTS VARCHAR(45),
                           USER_EMAIL VARCHAR(255),
                           CONSTRAINT FK_USERGROUP FOREIGN KEY (USER_GROUP)
                               REFERENCES USERS_GROUP (GROUP_ID)
);

CREATE TABLE INM.INC_STATUS (
                                STATUS_ID INT PRIMARY KEY,
                                STATUS_TITLE VARCHAR(255)
);
CREATE TABLE INM.INCIDENT (
                              INCIDENT_ID INT PRIMARY KEY AUTO_INCREMENT,
                              INCIDENT_DATE TIMESTAMP NOT NULL,
                              INCIDENT_CATEGORY INT(10) NOT NULL,
                              INCIDENT_PRIORITY VARCHAR(20) NOT NULL,
                              REQUESTER_DEPARTMENT INT(10) NOT NULL,
                              REQUESTER VARCHAR(255) NOT NULL,
                              REQUESTER_CONTACTS VARCHAR(45) NOT NULL,
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