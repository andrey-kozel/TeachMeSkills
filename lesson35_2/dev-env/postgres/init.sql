CREATE TABLE users
(
    id         BIGSERIAL NOT NULL UNIQUE,
    name       VARCHAR   NOT NULL UNIQUE,
    role       VARCHAR   NOT NULL,
    password   VARCHAR   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO users (name, role, password)
VALUES ('Andrey', 'EMPLOYEE', '123');
INSERT INTO users (name, role, password)
VALUES ('Andrey1', 'EMPLOYEE', '123');
INSERT INTO users (name, role, password)
VALUES ('Andrey2', 'MANAGER', '123');
INSERT INTO users (name, role, password)
VALUES ('Andrey3', 'MANAGER', '123');
INSERT INTO users (name, role, password)
VALUES ('Andrey4', 'ADMIN', '123');
