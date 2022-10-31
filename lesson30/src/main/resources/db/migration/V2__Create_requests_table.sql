CREATE TABLE invitations
(
    inviter_id BIGINT    NOT NULL,
    user_id    BIGINT    NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),

    PRIMARY KEY (inviter_id, user_id)
);
