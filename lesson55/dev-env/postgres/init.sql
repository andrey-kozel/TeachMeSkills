CREATE TABLE users
(
    id          BIGSERIAL NOT NULL UNIQUE,
    name        VARCHAR   NOT NULL UNIQUE,
    password    VARCHAR   NOT NULL,
    description VARCHAR   NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT now()
);
