CREATE TABLE IF NOT EXISTS logs (id SERIAL PRIMARY KEY, datetime TIMESTAMP, level VARCHAR(255), message VARCHAR(4000));