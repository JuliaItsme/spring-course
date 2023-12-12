SELECT * FROM Person;

ALTER TABLE Person ADD COLUMN created_at TIMESTAMP,
                   ADD COLUMN updated_at TIMESTAMP,
                   ADD COLUMN created_who VARCHAR;

DROP TABLE Person;