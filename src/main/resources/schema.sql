-- CREATE TABLE IF NOT EXISTS jedi
-- (
--     id         SERIAL PRIMARY KEY,
--     created    date        NOT NULL,
--     name       varchar(30) NOT NULL,
--     side       varchar(20) NOT NULL,
--     lightsaber varchar(20) NOT NULL,
--     strength   integer     NOT NULL,
--     appearance varchar(20) NOT NULL,
--     jOrder     varchar(20) NOT NULL
-- );

CREATE TABLE IF NOT EXISTS warrior
(
    name       varchar(30) PRIMARY KEY,
    side       varchar(30) NOT NULL,
    orderName  varchar(30) NOT NULL,
    grade      varchar(30) NOT NULL,
    lightsaber varchar(30) NOT NULL,
    strength   integer     NOT NULL,
    appearance varchar(30) NOT NULL,
    homeWorld  varchar(30) NOT NULL,
    species    varchar(30) NOT NULL,
    gender     varchar(30) NOT NULL,
    master     varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    username   varchar(20)  NOT NULL,
    password   varchar(100) NOT NULL,
    firstName  varchar(20),
    secondName varchar(20),
    age        varchar(2)   NOT NULL,
    email      varchar(100) NOT NULL,
    phone      varchar(11)
)
