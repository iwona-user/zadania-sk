-- -- -------------------------------------------------------------------------------
-- -- Zadanie 2.2 SQL queries
-- -- -------------------------------------------------------------------------------

-- -- -------------------------------------------------------------------------------
-- Section: setting sql_mode
-- -- -------------------------------------------------------------------------------
SET sql_mode = 'ONLY_FULL_GROUP_BY, STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -- -------------------------------------------------------------------------------
-- Section: USE
-- -- -------------------------------------------------------------------------------
USE jsk_db_list2;

-- -- -------------------------------------------------------------------------------
-- Section: rozwiązanie zadania
-- -- -------------------------------------------------------------------------------

-- 1.	wyświetl listę wszystkich tabel w bazie danych

SHOW TABLES;



-- 2.	wyświetl informacje, na temat pól i typów danych w tabeli contract


-- Rozwiązanie nr 1:

SHOW FIELDS FROM contract;

-- Koniec




-- Rozwiązanie nr 2: alternatywne

SELECT
  COLUMN_NAME, DATA_TYPE 
FROM
  INFORMATION_SCHEMA.COLUMNS 
WHERE
  TABLE_SCHEMA = 'jsk_db_list2'
AND
  TABLE_NAME = 'contract';

-- Koniec



-- 3.	wyświetl liczbę wszystkich pracowników.

SELECT 
COUNT(*) AS 'Liczba pracowników'
FROM employee;



-- 4.	wyświetl liczbę wszystkich klientów

SELECT 
COUNT(*) AS 'Liczba klientów'
FROM client;



-- 5.	wyświetl klientów wraz z informacjami o projektach, które są dla nich realizowane


SELECT
c.name AS 'Nazwa klienta'
, p.name AS 'Nazwa projektu'
, p.start_date AS 'Data rozpoczęcia projektu'
, p.end_date AS 'Data zakończenia projektu'
, p.create_date AS 'Data utworzenia projektu'
, p.update_date AS ' Data ukończenia projektu'
, ptype.name AS 'Typ projektu'
FROM client AS c
LEFT JOIN project AS p ON (p.client_id = c.id)
LEFT JOIN project_type AS ptype ON (ptype.id = p.type_id);



-- 6.	wyświetl klientów, wraz z informacjami o ich Account Managerach. Uwzględnij sytuację, gdy klient nie ma przypisanego Account Managera

SELECT 
c.name AS 'Nazwa klienta'
, e.first_name AS 'Imię Acount Menagera'
, e.last_name AS 'Nazwisko Acount Menagera'
, p.name AS 'Nazwa projektu'
, poz.name AS 'Pozycja pracownika'
FROM client AS c
LEFT JOIN project  AS p ON (p.client_id = c.id)
LEFT JOIN project_assignment ON (project_assignment.project_id = p.id)
LEFT JOIN employee AS e ON (e.id = project_assignment.employee_id) 
LEFT JOIN contract ON (contract.employee_id = e.id)
Left JOIN position AS poz ON (poz.id = contract.position_id)
Where poz.name = 'Account manager' OR poz.name= 'Senior Account manager';

-- 7.	wyświetl projekty, które zaczęły się po/w 2010-02-01 dla klienta Fiserv


SELECT
 c.name as 'Nazwa projektu'
, p.start_date
FROM client AS c
JOIN project AS p ON (p.client_id = c.id)
WHERE c.name = 'Fiserv' AND (p.start_date>= DATE('2010-02-01'));

-- 8. wyświetl pracowników, którzy zostali zatrudnieni w poprzednim roku,  w raz z ich wszystkimi kontraktami. Uwzględnij tylko aktualnych pracowników (pomiń osoby, które nie są już zatrudnieni; uwzględnij osoby na okresie wypowiedzenia). Wyniki posortuj po ID pracownika i po dacie rozpoczęcia kontraktu.

SELECT
e.id
, e.first_name
, e.last_name
, e.hire_date
, e.termination_date
, c.start_date AS 'Początek kontraktu'
, c.end_date AS 'Koniec kontraktu'
FROM employee AS e
JOIN contract AS c ON (c.employee_id = e.id)
WHERE (e.hire_date>SUBDATE(NOW()-2) AND e.hire_date<=SUBDATE(NOW()-1) and e.termination_date < NOW()  
ORDER BY e.id, c.start_date;


-- 9.	wyświetl wszystkich pracowników (id, mail) oraz ilość projektów, do których byli przypisani. Uwzględnij pracowników, którzy nie byli przypisani do żadnego projektu


SELECT
e.id
, e.mail
, e.first_name
, e.last_name
, COUNT(p.name)
FROM employee AS e
LEFT JOIN project_assignment AS pss ON (pss.employee_id = e.id)
LEFT JOIN project AS p ON (p.id = pss.project_id)
GROUP BY e.id;



-- 10.	wyświetl wszystkich pracowników (id, mail), którzy nie byli przypisani do żadnego projektu oraz których imię zaczyna się na literę ‘A’


SELECT
e.id
, e.mail
FROM employee AS e
LEFT JOIN project_assignment AS ps ON (ps.employee_id = e.id)
LEFT JOIN project AS p ON (ps.project_id = p.id)
WHERE p.name IS NULL AND e.first_name LIKE 'A%';

