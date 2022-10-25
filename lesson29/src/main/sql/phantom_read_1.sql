-- Отсутствие неповторяющегося чтения
BEGIN transaction isolation level repeatable read;
UPDATE accounts SET amount = 1000 WHERE id = 1;
UPDATE accounts SET amount = 3000 WHERE id = 2;
INSERT INTO accounts VALUES
    (4, '3001', 'charlie', 100.00);
SELECT * FROM accounts order by id desc;
-- Переход к Фазе 2
-- Фаза 3
COMMIT;
-- Переход к Фазе 4
