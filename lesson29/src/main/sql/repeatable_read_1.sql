-- Отсутствие неповторяющегося чтения
BEGIN transaction isolation level repeatable read;
UPDATE accounts SET amount = amount - 200 WHERE id = 1;
SELECT * FROM accounts WHERE client = 'alice';
-- Переход к Фазе 2
-- Фаза 3
COMMIT;
-- Переход к Фазе 4
