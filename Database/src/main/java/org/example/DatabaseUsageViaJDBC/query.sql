SELECT * FROM Currency;
SELECT * FROM Currency WHERE abbreviation = 'EUR';
SELECT COUNT(*) AS num_currencies FROM Currency;
SELECT * FROM Currency ORDER BY conversion_rate DESC LIMIT 1;
