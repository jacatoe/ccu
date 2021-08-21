-- ----------------------------------
-- StudentQueries: Part 1 of Quiz 5.2
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: Quiz 5.2
-- Date: 06/27/18
-- Version: 1.0
-- ----------------------------------

-- a
SELECT StudentLastName FROM Student;

-- b
SELECT DISTINCT StudentLastName FROM Student;

-- c
SELECT * FROM Student WHERE StudentFirstName LIKE 'C%' OR StudentLastName LIKE 'C%'; 

-- d
SELECT COUNT(StudentYear) FROM Student WHERE StudentYear='Senior';

-- e
SELECT * FROM Student WHERE StudentLastName IN ('Lewis', 'Roberts');

-- f
SELECT StudentLastName, StudentFirstName FROM Student ORDER BY StudentLastName;

-- g
SELECT StudentYear, StudentLastName, StudentFirstName FROM Student ORDER BY StudentYear, StudentLastName;

-- h
SELECT AVG(StudentGPA) FROM Student;