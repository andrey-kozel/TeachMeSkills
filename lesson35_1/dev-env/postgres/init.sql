CREATE TABLE organization
(
    id         BIGSERIAL NOT NULL UNIQUE,
    name       VARCHAR   NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE employee
(
    id              BIGSERIAL NOT NULL UNIQUE,
    name            VARCHAR   NOT NULL,
    last_name       VARCHAR   NOT NULL,
    organization_id BIGINT    NOT NULL REFERENCES organization (id)
);

CREATE TABLE working_place
(
    id               BIGSERIAL NOT NULL,
    inventory_number TEXT      NOT NULL,
    employee_id      BIGINT    NOT NULL REFERENCES employee (id)
);

INSERT INTO organization (name)
VALUES ('Organization 1');

INSERT INTO employee (name, last_name, organization_id)
VALUES ('Andrey1', 'M', 1),
       ('Andrey2', 'M', 1);

INSERT INTO working_place (inventory_number, employee_id)
VALUES ('CP-1', 1),
       ('CP-2', 2);


INSERT INTO organization (name)
VALUES ('Organization 2');

INSERT INTO employee (name, last_name, organization_id)
VALUES ('Andrey3', 'K', 2),
       ('Andrey4', 'K', 2),
       ('Andrey5', 'L', 2);

INSERT INTO working_place (inventory_number, employee_id)
VALUES ('CP-3', 3),
       ('CP-4', 4);
