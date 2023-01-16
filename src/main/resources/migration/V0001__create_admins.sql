DROP TABLE IF EXISTS admins;
CREATE TABLE admins
(
    id       serial NOT NULL,
    username text   NOT NULL,
    password text   NOT NULL,
    token    text   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id)
);