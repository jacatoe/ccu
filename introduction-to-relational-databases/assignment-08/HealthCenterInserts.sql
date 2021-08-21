-- ---------------------------------------------------------
-- HealthCenterInserts: Inserts table data for Assignment 08
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 08
-- Date: 07/05/18
-- Version: 1.0
-- ---------------------------------------------------------

INSERT INTO Doctor VALUES ( 1, 'Dr. Joe'   );
INSERT INTO Doctor VALUES ( 2, 'Dr. Sue'   );
INSERT INTO Doctor VALUES ( 3, 'Dr. Kim'   );
INSERT INTO Doctor VALUES ( 4, 'Dr. Joe'   );
INSERT INTO Doctor VALUES ( 5, 'Dr. Jack'  );
INSERT INTO Doctor VALUES ( 6, 'Dr. Hannah');
INSERT INTO Doctor VALUES ( 7, 'Dr. Sally' );
INSERT INTO Doctor VALUES ( 8, 'Dr. Suess' );
INSERT INTO Doctor VALUES ( 9, 'Dr. Olga'  );
INSERT INTO Doctor VALUES (10, 'Dr. Hugh'  );

INSERT INTO Insurance_company VALUES (10, 'Regressive'    );
INSERT INTO Insurance_company VALUES (11, 'ACME Insurance');
INSERT INTO Insurance_company VALUES (12, 'Purple Star'   );
INSERT INTO Insurance_company VALUES (13, 'Tower Block'   );
INSERT INTO Insurance_company VALUES (14, 'All Protect'   );
INSERT INTO Insurance_company VALUES (15, 'Federal Ranch' );

INSERT INTO Patient VALUES (100, 'Stuart', 15);
INSERT INTO Patient VALUES (111, 'Max'   , 11);
INSERT INTO Patient VALUES (222, 'Mia'   , 11);
INSERT INTO Patient VALUES (333, 'Pam'   , 12);
INSERT INTO Patient VALUES (444, 'Jeff'  , 10);
INSERT INTO Patient VALUES (555, 'Lee'   , 13);
INSERT INTO Patient VALUES (666, 'Alen'  , 14);
INSERT INTO Patient VALUES (777, 'Guy'   , 15);
INSERT INTO Patient VALUES (888, 'Alton' , 10);
INSERT INTO Patient VALUES (999, 'Phil'  , 14);

INSERT INTO Appointment VALUES ( 1, 111, '1-Dec' );
INSERT INTO Appointment VALUES ( 1, 222, '2-Dec' );
INSERT INTO Appointment VALUES ( 1, 333, '3-Dec' );
INSERT INTO Appointment VALUES ( 2, 333, '7-Dec' );
INSERT INTO Appointment VALUES ( 3, 555, '2-Dec' );
INSERT INTO Appointment VALUES ( 3, 111, '3-Dec' );
INSERT INTO Appointment VALUES ( 4, 666, '9-Dec' );
INSERT INTO Appointment VALUES ( 8, 888, '5-Dec' );
INSERT INTO Appointment VALUES ( 6, 100, '12-Dec');
INSERT INTO Appointment VALUES (10, 999, '20-Dec');
INSERT INTO Appointment VALUES ( 5, 666, '8-Dec' );
INSERT INTO Appointment VALUES ( 7, 444, '15-Dec');
INSERT INTO Appointment VALUES ( 9, 777, '6-Dec' );
INSERT INTO Appointment VALUES ( 5, 999, '22-Dec');
INSERT INTO Appointment VALUES ( 8, 555, '30-Dec');