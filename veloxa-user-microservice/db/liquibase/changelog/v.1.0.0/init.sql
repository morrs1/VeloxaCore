--liquibase formatted sql

--changeset morrs:1.1

CREATE TABLE users
(
    id                 UUID PRIMARY KEY,
    surname            VARCHAR(255) NOT NULL,
    name               VARCHAR(255) NOT NULL,
    patronymic         VARCHAR(255),
    user_status        VARCHAR(255),
    notification_way   VARCHAR(255) CHECK (notification_way IN ('GMAIL', 'TELEGRAM')),
    role               VARCHAR CHECK (role IN ('ADMIN', 'USER')),
    email              VARCHAR(255),
    password           VARCHAR,
    telegram_id        INT,
    profile_photo_link VARCHAR
);



