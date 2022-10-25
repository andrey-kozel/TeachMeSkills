-- Отсутствие грязного чтения

-- Фаза 1
BEGIN;
SHOW transaction_isolation;
UPDATE accounts SET amount = amount - 200 WHERE id = 1;
SELECT * FROM accounts WHERE client = 'alice';


-- Переход к фазе 2


-- Фаза 3
COMMIT;


-- Переходим к фазе 4
