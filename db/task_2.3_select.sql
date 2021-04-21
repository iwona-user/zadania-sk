-- -- -------------------------------------------------------------------------------
-- -- Zadanie 2.3 SQL queries
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

-- 1.	policz ilu aktualnie zatrudnionych pracowników ma aktualnie pensję pomiędzy 5 000 a 9 500 (łącznie z tymi kwotami)
- having/podzapytanie 
- 13 rekordów

SELECT 
i.suma
, COUNT(i.suma)
FROM
(SELECT
e.id
, SUM(c.salary) AS suma
, c.start_date
, c.end_date
, e.termination_date
FROM employee AS e
LEFT JOIN contract AS c ON (c.employee_id=e.id)
WHERE e.termination_date>=NOW() AND c.start_date<NOW() AND c.end_date>NOW() 
GROUP BY e.id
ORDER BY e.id DESC
) AS i
WHERE i.suma>=5000 AND i.suma<=9500
GROUP BY i.suma;

-- 2.	znajdź dokładnie jednego klienta, którego imię zaczyna się na literę „D” (nie „d”). Podpowiedź: zapewnij, że zapytanie zwróci dokładnie jeden wiersz, nawet jeśli jest więcej pasujących rekordów.

SELECT
client.name
FROM client
WHERE BINARY(SUBSTRING(client.name, 1, 1)) = BINARY('D')
LIMIT 1;


-- 3.	znajdź pracowników, którzy pracują w firmie ponad 11 lat (i nadal pracują)

SELECT
e.first_name
, e.last_name
, e.hire_date
, e.termination_date
FROM employee AS e
WHERE e.hire_date < DATE_SUB(CURDATE(), INTERVAL 11 YEAR) AND e.termination_date>=NOW();



-- 4.	znadjdź liczbę pracowników, których imię jest długie na 5 znaków. Uwzględnij przy tym polskie znaki lub inne znaki specjalne

SELECT
COUNT(employee.first_name)
FROM employee
WHERE LENGTH(employee.first_name)=5; 

-- 5.	znajdź pracowników, w których nazwisku na trzecim miejscu występuje litera 'a' (litera ‘a’, nie litera ‘A’)

SELECT
employee.last_name
FROM employee
WHERE BINARY(SUBSTRING(employee.last_name, 3, 1)) = BINARY('a');

-- 6.	znajdź pracowników, którzy posiadają e-mail, w którym local-part (znak przed „@”) posiada znak kropki i na drugim miejscu za znakiem kropki znajduje się liczba, a domeną jest „.pl” lub „.eu”. Użyj wyrażeń regularnych.


SELECT
  employee.last_name
, employee.mail
FROM employee
WHERE employee.mail LIKE '%._[0-9]%@%.pl' OR employee.mail LIKE '%._[0-9]%@%.eu';


-- Podpowiedzi:
-- a)	Pasujący do kryteriów: „piotr.n0wak@wp.pl”, „mon1ka.g1l@test.eu”
-- b)	Nie pasujący do kryteriów: „adam@wp.pl”, „a2test@wp.eua”, „a3test@wp.opl”, „piotr.n0wak@wp.opl”, „piotr.n0wak@wp.eua”

-- 7.	dla każdego miesiąca podaj nazwę miesiąca oraz ile projektów rozpoczęło się w danym miesiącu.



SELECT i.* FROM
(
SELECT
DATE_FORMAT(p.start_date, '%M') 
, COUNT(p.name) AS liczba
FROM project AS p
GROUP BY DATE_FORMAT(p.start_date, '%M') 
ORDER BY DATE_FORMAT(p.start_date, '%M')
) AS i
WHERE i.liczba>1;

-- Cel: sprawdzenie, w którym miesiącu rozpoczynamy najwięcej projektów.
-- Podpowiedzi:
-- a)	Zbiór powinien być posortowany wg kolejności w roku miesięcy (styczeń, luty, marzec etc.)
-- b)	Nie interesują nas lata. Tylko miesiące.
-- c)	Uwzględnij tylko te miesiące, dla których mamy jakiekolwiek dane.



-- 8.	Sprawdź, ile jest osób, aktualnie pracujących, na każdej ze ścieżek kariery. Chcę zobaczyć także osoby, które są na okresie wypowiedzenia

SELECT
cp.name
, COUNT(*) AS 'Liczba pracowników na ścieżce kariery'
FROM career_path AS cp
LEFT JOIN position AS pos ON (pos.career_path_id = cp.id)
LEFT JOIN contract AS c ON (c.position_id = pos.id)
LEFT JOIN employee AS e ON (e.id = c.employee_id)
WHERE e.hire_date<=NOW() AND e.termination_date>=NOW()
GROUP BY cp.id;

-- Rozwiązanie alternatywne: 

SELECT
cp.name
, COUNT(*) AS 'Liczba pracowników na ścieżce kariery'
FROM employee AS e
LEFT JOIN contract AS c ON (c.employee_id = e.id)
LEFT JOIN position AS pos ON (pos.id = c.position_id)
LEFT JOIN career_path AS cp ON (cp.id = pos.career_path_id)
WHERE e.hire_date<=NOW() AND e.termination_date>=NOW()
GROUP BY cp.id;



-- 9.	Sprawdź, ile jest osób aktualnie pracujących na każdej ze ścieżek kariery, z podziałem na stopień (grade). Raport posortuj wg nazwy ścieżki oraz nazwy stopnia.
- jak zrobić podział na grade?

SELECT
cp.name
, g.name
, COUNT(cp.name) AS 'Liczba pracowników na ścieżce kariery'
FROM career_path AS cp
LEFT JOIN position AS pos ON (pos.career_path_id = cp.id)
LEFT JOIN contract AS c ON (c.position_id = pos.id)
LEFT JOIN employee AS e ON (e.id = c.employee_id)
LEFT JOIN grade AS g ON (g.id = pos.grade_id)
WHERE e.hire_date<=NOW() AND e.termination_date>=NOW() 
GROUP BY cp.name, g.name
ORDER BY cp.name, g.name;



-- 10.	W jednym zapytaniu pokaż jakie było kiedykolwiek minimalne i maksymalne wynagrodzenie pracowników oraz jakie jest minimalne i maksymalne wynagrodzenie w ramach osób zatrudnionych w bieżącym roku (dla osób zakontraktowanych-start kontraktu, mógłbyć start w zeszłym roku ale musi być nadal ważny). Może to być np. dwa wiersze po dwie/trzy kolumny, cztery wiersze po 2 kolumny, 1 wiersz po 4 kolumn itd.

- nie ma osoby jako rok 21

-- union + podzapytanie/ lepiej 2 podzapytania
-- jak nie ma osób nowo zatrudnionych na nowy kontrakt

-- 11.	znajdź domeny, w której pracownicy najrzadziej posiadają adres e-mail (np. „gmail.com” itd.)

SELECT 
RIGHT(e.mail,POSITION('@' IN REVERSE(e.mail))-1) AS 'Domena'
, COUNT(RIGHT(e.mail,POSITION('@' IN REVERSE(e.mail))-1)) AS Liczba_maili_w_domenie
FROM employee AS e
GROUP BY RIGHT(e.mail,POSITION('@' IN REVERSE(e.mail))-1)
ORDER BY Liczba_maili_w_domenie DESC
Limit 3;



-- 12.	znajdź pracowników, którzy byli przypisani do co najmniej czterech projektów. Wyświetl dane projektu, pracownika oraz informacje na temat przypisania go do projektu (od kiedy, do kiedy, w jakim wymiarze czasowym etc.). Umieść także informacje o ilości projektów, w których pracownik brał udział. Użyj HAVING
-- podzapytanie?

SELECT i.* FROM
(
SELECT
e.id
, e.first_name
, e.last_name
, COUNT(p.name) AS liczba_projektow
, p.name
, ps.start_date
, ps.end_date
, ps.part_time
FROM employee AS e
LEFT JOIN project_assignment AS ps ON (ps.employee_id = e.id)
LEFT JOIN project AS p ON (p.id = ps.project_id)
GROUP BY e.id
) i
GROUP BY i.name
HAVING i.liczba_projektow>=4;
 

-- 13.	znajdź projekty, do których nie został przypisany jeszcze żaden pracownik. Wyświetl ich kierowników projektu oraz ich aktualne stanowiska. Mogą istnieć projekty, które nie mają przypisanego kierownika.

czyli wyświetlić projekty, które się już skończyły - wyświetlić

-- 14.	wyświetl projekty oraz liczbę osób w zespole (uwzględnij projekty, które nie mają jeszcze nikogo przypisanego)

SELECT
p.name
, COUNT(e.id)
FROM project AS p 
LEFT JOIN project_assignment AS ps ON (ps.project_id = p.id)
LEFT JOIN employee AS e ON (e.id = ps.employee_id)
GROUP BY p.id


-- 15.	wyświetl projekty, których nazwa zaczyna się od słowa „Oracle” oraz członków zespołu wraz z datą przypisania do projektu, procentowym udziałem w projekcie (part_time) oraz aktualne stanowisko, grade, dział i ścieżkę kariery

-- Albo pokazać włącznie z pracownikami zwolnionymi albo wyciągnąć najbardziej aktualne kontrakty


SELECT
p.name
, e.first_name
, e.last_name
, ps.start_date
, ps.part_time
, pos.name AS 'Stanowisko'
, g.name AS 'Stopień'
, d.name As 'Dział'
, cp.name AS 'Ścieżka kariery'
FROM project AS p 
LEFT JOIN project_assignment AS ps ON (ps.project_id = p.id)
LEFT JOIN employee AS e ON (e.id = ps.employee_id)
LEFT JOIN contract AS c ON (c.employee_id = e.id)
left JOIN department AS d ON (d.id = c.department_id)
LEFT JOIN position AS pos ON (pos.id = c.position_id)
LEFT JOIN grade AS g ON (g.id = pos.grade_id)
LEFT JOIN career_path AS cp ON (cp.id = pos.career_path_id)
WHERE c.start_date<=NOW() AND c.end_date>=NOW() AND BINARY(SUBSTRING(p.name, 1, 6)) = BINARY('Oracle')
GROUP BY p.id, e.first_name, e.last_name
ORDER BY p.id;



-- 16.	Znajdź pracowników, którzy w dniu 2020-10-10 byli przypisani do projektu (byli członkami grupy projektowej).


SELECT
e.first_name
, e.last_name
FROM employee AS e
JOIN project_assignment AS ps ON (ps.employee_id = e.id)
WHERE ps.start_date<=DATE('2020-10-10') AND ps.end_date>=DATE('2020-10-10')
;


-- 17.	Znajdź pracowników, którzy pracowali chociaż przez chwilę w okresie pomiędzy X a Y w projekcie. Wyświetl informacje na temat pracowników, nazwę projektu oraz przypisania do projektu (od kiedy, do kiedy, wymiar czasu).



-- X = 2021-01-01
-- Y = 2021-03-31
-- Podpowiedzi:
-- a)	Weź pod uwagę różne możliwości nakładania się terminów
-- b)	Weź pod uwagę, że pracownik mógł pracować chociaż przez chwilę w tym okresie

-- 18.	znajdź działy, które mają najwięcej przypisanych pracowników, którzy mają aktywny kontrakt


SELECT
d.name
, COUNT(e.id)
FRoM department AS d
LEFT JOIN contract AS c ON (c.department_id = d.id)
lEFT jOIN employee AS e ON (e.id = c.employee_id )
GROUP BY e.id
ORDER BY COUNT(e.id) DESC;

-- 19.	znajdź klientów, dla których jest prowadzona największa liczba projektów. Użyj WITH i/lub Window Functions



SELECT
c.name
, COUNT(p.name)
, DENSE_RANK() OVER (PARTITION BY c.name ORDER BY COUNT(p.name) ASC) AS v_rank
FROM client AS c
LEFT JOIN project AS p ON (p.client_id = p.id)
GROUP By c.name
WINDOW w AS (ORDER BY c.name);

-- 20.	Od jutra mianuj pracownika, który przedstawia się dowodem osobistym o numerze „83010172891” na stanowisko szefa działu „Testing”. Zadbaj o odpowiednie wpisy w jego kontraktach. Przygotuj zapytania SQL, które pozwolą sprawdzić wynik zapytania. Wszystkie operacje wykonaj w jednej transakcji.


