DROP DATABASE IF EXISTS currency_converter_db;
CREATE DATABASE currency_converter_db;
USE currency_converter_db;
CREATE TABLE Currency (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          abbreviation VARCHAR(10) NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          conversion_rate DECIMAL(18, 6) NOT NULL
);
INSERT INTO Currency (abbreviation, name, conversion_rate)
VALUES
    ('USD', 'US Dollar', 1.0),
    ('EUR', 'Euro', 0.88794),
    ('GBP', 'British Pound', 0.75785),
    ('JPY', 'Japanese Yen', 113.626),
    ('AUD', 'Australian Dollar', 1.37822),
    ('CAD', 'Canadian Dollar', 1.27536),
    ('CHF', 'Swiss Franc', 0.92624),
    ('CNY', 'Chinese Yuan', 6.36648);
DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT ON currency_converter_db.Currency TO 'appuser'@'localhost';
