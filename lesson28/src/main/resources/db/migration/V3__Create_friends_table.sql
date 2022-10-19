CREATE TABLE friends
(
    user_id BIGINT    NOT NULL,
    friend_id    BIGINT    NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),

    PRIMARY KEY (user_id, friend_id)
);
