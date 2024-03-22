INSERT INTO WORKER
(ID,NAME,BIRTHDAY,LEVER,SALARY)
VALUES
(1,'Andrew','2000-01-22','Trainee',300),
(2,'Robert','2004-11-16','Senior',9000),
(3,'Andrew','2001-10-11','Junior',800),
(4,'John','1999-06-17','Trainee',250),
(5,'William','1995-03-29','Middle',2000),
(6,'Jennifer','2000-05-07','Junior',900),
(7,'Patricia','1991-09-05','Middle',3000),
(8,'Thomas','1984-12-31','Middle',4000),
(9,'Karen','1978-04-12','Trainee',300),
(10,'Christopher','1950-11-02','Senior',9000);

INSERT INTO CLIENT
(ID,NAME)
VALUES
(1,'Anthony'),
(2,'Donna'),
(3,'Joshua'),
(4,'Brian'),
(5,'Melissa');

INSERT INTO PROJECT
(ID,CLIENT_ID,START_DATE,FINISH_DATE)
VALUES
(1,2,'2023-01-01', '2025-05-01'),
(2,3,'2023-08-15', '2025-11-01'),
(3,5,'2022-04-10', '2024-06-01'),
(4,4,'2023-10-12', '2026-10-01'),
(5,4,'2023-06-15', '2027-07-01'),
(6,2,'2021-09-21', '2027-01-01'),
(7,3,'2022-03-30', '2025-02-01'),
(8,3,'2023-06-16', '2024-08-01'),
(9,2,'2019-11-26', '2024-09-01'),
(10,3,'2024-01-01', '2027-05-01');

INSERT INTO PROJECT_WORKER
(PROJECT_ID,WORKER_ID)
VALUES
(1,3),
(1,2),
(1,10),
(2,10),
(3,7),
(3,5),
(3,4),
(3,9),
(4,9),
(4,8),
(4,7),
(4,6),
(4,5),
(5,4),
(5,2);





