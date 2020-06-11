CREATE TABLE IF NOT EXISTS jedi
(
    id         SERIAL PRIMARY KEY,
    created    date        NOT NULL,
    name       varchar(30) NOT NULL,
    side       varchar(20) NOT NULL,
    lightsaber varchar(20) NOT NULL,
    strength   integer     NOT NULL,
    appearance varchar(20) NOT NULL,
    jOrder     varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id          SERIAL PRIMARY KEY,
    username    varchar(20)     NOT NULL,
    password    varchar(100)    NOT NULL,
    firstName   varchar(20)     NOT NULL,
    secondName  varchar(20)     NOT NULL,
    age         varchar(2)      NOT NULL,
    email       varchar(100)    NOT NULL,
    phone       varchar(11)     NOT NULL
)
