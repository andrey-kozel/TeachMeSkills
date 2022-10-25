-- Отсутствие неповторяющегося чтения
--Фаза 2
BEGIN transaction isolation level repeatable read;
SELECT *
FROM accounts
WHERE client = 'alice';
-- Переход к фазе 3
-- Фаза 4
SELECT *
FROM accounts
WHERE client = 'alice';
COMMIT;
