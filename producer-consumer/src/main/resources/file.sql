CREATE TABLE files (
                       id BIGINT PRIMARY KEY,
                       filename VARCHAR(255),
                       filetype VARCHAR(100),
                       data BYTEA
);
