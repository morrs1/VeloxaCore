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


--changeset morrs:1.2
CREATE TABLE meetings
(
    id           UUID PRIMARY KEY,
    organizer_id UUID REFERENCES users (id) ON DELETE SET NULL,
    title        VARCHAR(255),
    description  VARCHAR(255),
    start_time   TIMESTAMP,
    end_time     TIMESTAMP CHECK ( end_time > start_time )
);

--changeset morrs:1.3

CREATE TABLE tasks
(
    id             UUID PRIMARY KEY,
    title          VARCHAR(255),
    description    VARCHAR,
    start_time     TIMESTAMP,
    end_time       TIMESTAMP CHECK (end_time > start_time),
    creator_id     UUID REFERENCES users (id) ON DELETE SET NULL,
    assignee_id    UUID REFERENCES users (id) ON DELETE SET NULL,
    status         VARCHAR(255) CHECK (status IN ('CREATED', 'IN_PROCESS', 'COMPLETED', 'FAILED')),
    time_completed TIMESTAMP CHECK ( time_completed > start_time ),
    mark           INT CHECK ( mark >= 0 AND mark <= 10 )

);

--changeset morrs:1.4

CREATE TABLE meetings_users
(
    meetings_id UUID REFERENCES meetings (id) ON DELETE CASCADE,
    users_id    UUID REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (meetings_id, users_id)
)


