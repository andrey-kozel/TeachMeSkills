-- Отсутствие фантомного чтения
--Фаза 2
BEGIN transaction isolation level repeatable read;
SELECT *
FROM accounts;
-- Переход к фазе 3
-- Фаза 4
SELECT *
FROM accounts;
COMMIT;
SELECT *
FROM accounts;
