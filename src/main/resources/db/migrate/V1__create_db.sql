CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE planet(
id VARCHAR(100) NOT NULL PRIMARY KEY,
name VARCHAR(500) NOT NULL
);

CREATE TABLE ticket (
    id IDENTITY PRIMARY KEY,
	created_at TIMESTAMP,
    client_id BIGINT,
    from_planet_id VARCHAR(100),
    to_planet_id VARCHAR(100),
    FOREIGN KEY (client_id) REFERENCES client(id),
	FOREIGN KEY (from_planet_id) REFERENCES planet(id),
	FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);