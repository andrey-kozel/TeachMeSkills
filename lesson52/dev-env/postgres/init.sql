CREATE TABLE users
(
    id         BIGSERIAL NOT NULL UNIQUE,
    name       VARCHAR   NOT NULL UNIQUE,
    role       VARCHAR   NOT NULL,
    password   VARCHAR   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO users (name, role, password)
SELECT 'Andrey' || id, 'EMPLOYEE' || id, '123' || id from generate_series(1, 5000) as id;
