-- -- -------------------------------------------------------------------------------
-- -- Zadanie 2.5 Functions
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
-- Stwórz funkcję, która dla podanego pracownika, zwróci ciąg znaków, który zawiera informację na temat jego projektów (ilość oraz nazwy), nad którymi aktualnie pracuje. Przykładowo: „2: project1, project2” (gdzie „2” oznacza ilość projektów”)



DROP FUNCTION IF EXISTS info_project;

DELIMITER $$

CREATE FUNCTION info_project(employeeID INT)
	RETURNS VARCHAR(200) DETERMINISTIC
BEGIN
	

DECLARE @liczba_projektow INT;
SET @liczba_projektow =0;
DECLARE @nazwy_projektow VARCHAR(150);
SET @nazwy_projektow = '';

SET @liczba_projektow= (
SELECT
Liczba
FROM
(
SLECT
  COUNT(*) AS Liczba
FROM employee AS e
JOIN project_assignment AS as ON (as.employee_id =e.id )
JOIN project AS p ON (p.id = as.project_id)
WHERE e.id = employeeID and (as.start_date=<NOW() and as.end_date=>NOW())
)
);


SET @nazwy_projektow=
(SLECT
GROUP_CONCAT (DISTINCT p.name)
FROM employee AS e
JOIN project_assignment AS as ON (as.employee_id =e.id )
JOIN project AS p ON (p.id = as.project_id)
WHERE e.id = employeeID and (as.start_date=<NOW() and as.end_date=>NOW())
GROUP BY e.id
);

RETURN CONCAT(@liczba_projektow, ' ', @nazwy_projektow)
)


;
END
$$

DELIMITER ;
