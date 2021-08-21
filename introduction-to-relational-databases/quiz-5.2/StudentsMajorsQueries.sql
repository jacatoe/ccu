-- -----------------------------------------
-- StudentsMajorsQueries: Part 2 of Quiz 5.2
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: Quiz 5.2
-- Date: 06/27/18
-- Version: 1.0
-- -----------------------------------------

-- a
SELECT SUM(MajorProfessorCount) FROM Major;

-- b
SELECT StudentFirstName, StudentLastName, MajorName FROM Student, Major WHERE Student.Major_MajorCode=Major.MajorCode;

-- c
UPDATE Major SET MajorName='Exploring' WHERE MajorName='Undecided';

SELECT StudentFirstName, StudentLastName, MajorName FROM Student, Major WHERE Student.Major_MajorCode=Major.MajorCode;

-- d
SELECT StudentFirstName, StudentLastName, MajorName FROM Student, Major WHERE Student.Major_MajorCode=Major.MajorCode AND MajorProfessorCount>20;

-- e
SELECT MajorName, COUNT(Major_MajorCode) FROM Student, Major WHERE Student.Major_MajorCode=Major.MajorCode GROUP BY Major_MajorCode;

-- f
SELECT StudentFirstName, StudentLastName, StudentGPA FROM Student WHERE StudentGPA<(SELECT AVG(StudentGPA) FROM Student);

-- g
SELECT MajorName, StudentLastName, StudentFirstName, StudentYear, StudentGPA FROM Student, Major WHERE Student.Major_MajorCode=Major.MajorCode ORDER BY MajorName, StudentLastName;