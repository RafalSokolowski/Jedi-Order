CREATE TABLE IF NOT EXISTS jedi
(
    id         SERIAL PRIMARY KEY,
    created    date NOT NULL,
    name       varchar(30) NOT NULL,
    side       varchar(20) NOT NULL,
    lightsaber varchar(20) NOT NULL,
    strength   integer NOT NULL,
    appearance varchar(20) NOT NULL,
    jOrder     varchar(20) NOT NULL
);