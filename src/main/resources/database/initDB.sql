DROP TABLE IF EXISTS apartments;
DROP TABLE IF EXISTS houses;
DROP TABLE IF EXISTS streets;
DROP TABLE IF EXISTS cities;

CREATE TABLE IF NOT EXISTS cities
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS streets
(
    id    SERIAL PRIMARY KEY ,
    name  VARCHAR(100) NOT NULL ,
    city_id INT NOT NULL ,
    CONSTRAINT fk_cities FOREIGN KEY(city_id) REFERENCES cities(id)
);

CREATE TABLE IF NOT EXISTS houses
(
    id    SERIAL PRIMARY KEY ,
    number  VARCHAR(50) NOT NULL ,
    street_id INT NOT NULL ,
    CONSTRAINT fk_street FOREIGN KEY(street_id) REFERENCES streets(id)
);

CREATE TABLE IF NOT EXISTS apartments
(
    id    SERIAL PRIMARY KEY ,
    area  NUMERIC(15,2) NOT NULL ,
    house_id  INT NOT NULL ,
    CONSTRAINT fk_house FOREIGN KEY(house_id) REFERENCES houses(id)
);