-- -- -------------------------------------------------------------------------------
-- -- Zadanie 1
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
-- Section:  DROP TABLEs
-- -- -------------------------------------------------------------------------------
DROP TABLE IF EXISTS 'new_candidate'; -- FIXME

-- -- -------------------------------------------------------------------------------
-- Section: CREATE
-- -- -------------------------------------------------------------------------------
CREATE TABLE jsk_db_list2.new_candidate
(
	`id`					INT					unsigned NOT NULL AUTO_INCREMENT,
	`first_name`				VARCHAR(45)				NOT NULL,
	`last_name`				VARCHAR(45)				NOT NULL,
	`sex` 					enum('unknown', 'male','female','other') DEFAULT 'unknown',
	`mail` 					varchar(100) 				NOT NULL,
	`birth_date` 				date 					NOT NULL,
	`date_recruitment_interview` 		date 					DEFAULT NULL,
	`number_of_employees` 			enum('unknown', '1','2','3','other') 	DEFAULT 'unknown',
	`candidate_status` 			enum('Zaakceptowany', 'Odrzucony', 'brak decyzji') DEFAULT 'brak decyzji',
	`additional_description` 		varchar(45) 				DEFAULT NULL,
	`department_id` 			int unsigned				NOT NULL,
	PRIMARY KEY (`id`),
	KEY `new_candidate_department_fk` (`department_id`),
  	CONSTRAINT `new_candidate_department_fk` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- -- -------------------------------------------------------------------------------
-- Section: INSERT (dane testowe)
-- -- -------------------------------------------------------------------------------

INSERT INTO new_candidate(first_name, last_name, sex,mail, birth_date, date_recruitment_interview, number_of_employees, candidate_status, additional_description, department_id) 
VALUES ('Katarzyna','Wiśniewska','female','katarzyna.wiśniewska@o2.pl','1998-10-10','2019-02-04','1','Zaakceptowany','opis',1)
, ('Antoni','Kowalski','male','antoni.kowalski@o2.pl','1997-10-10','2019-02-05','2','Odrzucony','opis',2)
, ('Zuzana','Wójcik','female','zuzana.wojcik@o2.pl','1996-10-10','2019-02-10','3','Zaakceptowany','opis',3)
, ('Jan','kowalczyk','male','jan.kowalczyk@o2.pl','1995-10-10','2019-04-03','1','Odrzucony','opis',4)
, ('Julia','Kamińska','female','julia.kaminska@o2.pl','1994-10-10','2019-08-01','2','Zaakceptowany','opis',5)
, ('Jakub','Lewandowski','male','jakub.lewandowski@o2.pl','1993-10-10','2019-08-06','3','Odrzucony','opis',6)
, ('Zofia','Zielińska','female','zofia.zielinska@o2.pl','1992-10-10','2020-04-01','2','Zaakceptowany','opis',2)
, ('Aleksander','Szymański','male','aleksander.szymanski@o2.pl','1991-10-10','2020-04-04','2','Odrzucony','opis',3)
, ('Hanna','Nowak','female','hanna.nowak@o2.pl','1990-10-10','2020-05-05','1','Zaakceptowany','opis',4)
, ('Franciszek','Woźniak','male','franciszek.wozniak@o2.pl','1990-10-10','2020-05-09','2','Odrzucony','opis',5)
, ('Katarzyna','Dąbrowska','female','katarzyna.dabrowska@o2.pl','1989-10-10','2020-07-01','1','Zaakceptowany','opis',6)
, ('Szymon','Borowski','male','szymon.borowski@o2.pl','1988-10-10','2020-07-10','2','Odrzucony','opis',1)
, ('Lenna','Libera','female','lena.libera@o2.pl','1986-10-10','2021-02-01','2','Zaakceptowany','opis',1)
, ('Filip','Nowosielski','male','filip.nowosielki@o2.pl','1987-10-10','2021-02-10','1','Odrzucony','opis',2)
, ('Alicja','Szmaj','female','alicja.szmaj@o2.pl','1981-10-10','2021-04-04','2','Zaakceptowany','opis',3)
, ('Mikołaj','Święcicki','male','mikolaj.swiecicki@o2.pl','1982-10-10',NULL,'1','brak decyzji','opis',4);


SELECT * FROM new_candidate;






