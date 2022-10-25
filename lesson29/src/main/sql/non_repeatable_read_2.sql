-- Отсутствие грязного чтения
-- Фаза 2
BEGIN;
SELECT *
FROM accounts
WHERE client = 'alice';
-- Фаза 4, будет другой результат, неповторяющееся чтение
SELECT *
FROM accounts
WHERE client = 'alice';
COMMIT;
