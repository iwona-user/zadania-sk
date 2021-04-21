-- -- -------------------------------------------------------------------------------
-- -- Zadanie 2.4 views
-- -- -------------------------------------------------------------------------------

-- -- -------------------------------------------------------------------------------
-- Section: setting sql_mode
-- -- -------------------------------------------------------------------------------
SET sql_mode = 'ONLY_FULL_GROUP_BY,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -- -------------------------------------------------------------------------------
-- Section: USE
-- -- -------------------------------------------------------------------------------
USE jsk_db_list2;

-- -- -------------------------------------------------------------------------------
-- Section: rozwiązanie zadania
-- -- -------------------------------------------------------------------------------
-- Przygotuj zapytania, które pozwolą na szybkie sprawdzenie wartości zwracanych przez Twoje widoki.
W zadaniu możesz używać Window functions.
Stwórz widok, który przedstawi wszystkie istniejące stanowiska w firmie, wraz z możliwymi dla nich stopniami oraz nazwami ścieżek kariery.
-- Rezultat powinien być posortowany wg ścieżki kariery oraz stopnia (grade)
-- Rezultat zawiera kolumnę, która w sposób jednoznaczny wskaże, który w kolejności grade jest pierwszym, drugim, trzecim itd. dla danej ścieżki kariery (np. „A1” jest pierwszym dla ścieżki „developer”, ale dla „business_analyst” pierwszym stopniem będzie „A2”)




CREATE OR REPLACE VIEW v_position_and_grade_and_path AS 
SELECT
  cp.name AS 'Ścieżka kariery'
, p.name AS 'Nazwa stanowiska'
, g.name AS 'Nazwa stopnia'
, DENSE_RANK() OVER (PARTITION BY cp.name ORDER BY g.name ASC) AS v_rank
FROM career_path AS cp
JOIN position AS p ON (p.career_path_id = cp.id)
JOIN grade AS g ON (g.id =p.grade_id)
WINDOW w AS (ORDER BY cp.name, g.name);


-- Zapytanie do widoku:

SELECT * FROM v_position_and_grade_and_path AS pgp;
