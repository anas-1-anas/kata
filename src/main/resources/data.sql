CREATE TABLE DELIVERY_METHOD (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    METHOD VARCHAR(255) NOT NULL
);

CREATE TABLE TIME_SLOT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    METHOD VARCHAR(255) NOT NULL,
    START_TIME TIMESTAMP NOT NULL,
    END_TIME TIMESTAMP NOT NULL
);

INSERT INTO DELIVERY_METHOD (METHOD) VALUES ('DRIVE');
INSERT INTO DELIVERY_METHOD (METHOD) VALUES ('DELIVERY');
INSERT INTO DELIVERY_METHOD (METHOD) VALUES ('DELIVERY_TODAY');
INSERT INTO DELIVERY_METHOD (METHOD) VALUES ('DELIVERY_ASAP');

INSERT INTO TIME_SLOT (METHOD, START_TIME, END_TIME) VALUES ('DRIVE', '2024-06-18T10:00:00', '2024-06-18T11:00:00');
INSERT INTO TIME_SLOT (METHOD, START_TIME, END_TIME) VALUES ('DELIVERY', '2024-06-19T09:00:00', '2024-06-19T11:00:00');
INSERT INTO TIME_SLOT (METHOD, START_TIME, END_TIME) VALUES ('DELIVERY_TODAY', '2024-06-18T13:00:00', '2024-06-18T14:00:00');
INSERT INTO TIME_SLOT (METHOD, START_TIME, END_TIME) VALUES ('DELIVERY_ASAP', '2024-06-18T10:30:00', '2024-06-18T12:00:00');