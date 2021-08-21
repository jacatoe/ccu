-- Joshua Catoe
-- 06/24/18
-- CSCI 225 
-- CompanyEmployee Inserts

INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Walmart',        "1970-04-20");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Target',         "1971-06-22");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Best Buy',       "1985-10-15");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Costco',         "1987-11-03");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('GameStop',       "1999-03-12");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('KFC',            "1971-06-22");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Sonic',          "1988-09-10");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Cracker Barrel', "1970-04-20");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Olive Garden',   "1985-10-15");
INSERT INTO Company (CompanyName, CompanyFoundingDate) VALUES ('Outback',        "1985-10-15");

INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-444-0617', '$70,000',  'Roger',   'Wilco',   4);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-006-7894', '$90,000',  'Jane',    'Smith',   9);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-256-5213', ''       ,  'Roger',   'Adams',   6);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-219-8895', '$100,000', 'John',    'Deere',   4);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-449-0145', '$50,000',  'Steve',   'Stevens', 3);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-665-9841', '$64,000',  'William', 'Smith',   3);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-555-6699', ''       ,  'Adam',    'Jones',   3);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-332-1568', '$78,000',  'Mary',    'Jane',    7);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-114-8523', '$59,000',  'John',    'Wilco',   1);
INSERT INTO Employee (EmployeePhoneNumber, EmployeeSalary, EmployeeFirstName, EmployeeLastName, Company_CompanyID) VALUES ('843-998-7412', ''       ,  'Vincent', 'Abbott',  10);

INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Stapling',        4);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Teamwork',        7);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Databases',       9);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Communication',   3);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Punctuality',     2);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Organization',    6);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Problem Solving', 5);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Cleanliness',     1);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Company Spirit',  8);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Loyalty',         10);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Typing',          3);
INSERT INTO EmployeeSkill (EmpSkill, Employee_EmployeeID) VALUES ('Efficiency',      7);