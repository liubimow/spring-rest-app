CREATE TABLE requests (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    message TEXT NOT NULL
);

INSERT INTO requests (name, message) VALUES ('Ilya', 'My First Spring project!')