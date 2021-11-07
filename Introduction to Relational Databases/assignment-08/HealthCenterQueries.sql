-- ---------------------------------------------------
-- HealthCenterQueries: Query answers for Assignment 08
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 08
-- Date: 07/05/18
-- Version: 1.0
-- ---------------------------------------------------

-- 1. Display the total number of Patients that have been treated by the Health Center (no duplicates).
 
SELECT DISTINCT COUNT(PatientID) FROM Patient;

-- 2. Display only once all of the insurance companies on record in alphabetical order.

SELECT * FROM Insurance_company ORDER BY InsuranceCoName;

-- 3. Display each Doctor’s unique ID and Name along with the name of each Patient treated, sorted by Doctor in descending alphabetical order and Patient Name in ascending alphabetical order.

SELECT DocID, DocName, PatientName FROM Appointment INNER JOIN Doctor ON Appointment.DOCTOR_DocID=Doctor.DocID
													INNER JOIN Patient ON Appointment.PATIENT_PatientID=Patient.PatientID 
														ORDER BY DocName DESC, PatientName ASC;
                                                    
-- 4. Display each Doctor’s ID and Name along with the total number of Patients with the Column header “Patient Total” only for Doctors that have less than the average number of patients.

SELECT DocID, DocName, COUNT(Appointment.PATIENT_PatientID) AS 'Patient Total' FROM Appointment INNER JOIN Doctor ON Doctor.DocID=Appointment.DOCTOR_DocID
																					              GROUP BY DocID HAVING COUNT(Appointment.PATIENT_PatientID)<1.5;

-- 5. Display each Doctor’s Name sorted alphabetically along with the total number of Patients that have appointments with that particular Doctor in a column named “Total Appointments”.

SELECT DocName, COUNT(Appointment.PATIENT_PatientID) AS 'Total Appointments' FROM Appointment INNER JOIN Doctor ON Doctor.DocID=Appointment.DOCTOR_DocID
																									GROUP BY DocID ORDER BY DocName;
                                                                                                    
-- 6. Display each Doctor’s Name, along with each of their Patient’s Name, the Patient’s Insurance Company’s Name and their Next appointment Date.   

SELECT DocName, PatientName, InsuranceCoName, NextAppointmentDate FROM Doctor, Patient, Insurance_company, Appointment WHERE Doctor.DocID=Appointment.DOCTOR_DocID AND Appointment.PATIENT_PatientID=Patient.PatientID AND Patient.INSURANCE_COMPANY_InsuranceCoID=Insurance_company.InsuranceCoID;		

-- 7. Add a new column to the Insurance Table that adds a new column named InsuranceCoRating, that is an integer variable in the range of 1 – 100.	

ALTER TABLE Insurance_company ADD InsuranceCoRating INT(100);

-- 8. From the previous problem, please populate the InsuranceCoRating with the value 50.

UPDATE Insurance_company SET InsuranceCoRating=50 WHERE InsuranceCoRating IS NULL;	

-- 9. Add a new column to the DOCTOR Table that adds a new column named PatientTotal, that is an integer value.	

ALTER TABLE Doctor ADD PatientTotal INT;

-- 10. Each Doctor has to populate the PatientTotal from the previous problem.	

-- WTF?