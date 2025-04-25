CREATE TABLE competition (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255),
                             country VARCHAR(255),
                             year INT,
                             winner VARCHAR(255),
                             runnerup VARCHAR(255)
);
