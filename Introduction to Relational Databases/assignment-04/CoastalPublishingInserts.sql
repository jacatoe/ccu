-- ---------------------------------------
-- CoastalPublishing Inserts: Inserts data
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 04
-- Date: 06/26/18
-- Version: 1.0
-- ---------------------------------------

INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Jane'    , 'Smith' , '843-555-0623');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('John'    , 'Doe'   , '843-898-7532');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Jim'     , 'Good'  , '843-213-5426');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Joe'     , 'Schmoe', '843-486-5198');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Jennifer', 'Hale'  , '843-318-9630');

INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Cormac'  , 'McCarthy' ,    2);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('James'   , 'Patterson',    5);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Agatha'  , 'Christie' , null);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Stephen' , 'King'     ,    4);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Ian'     , 'Fleming'  , null);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('John'    , 'Grisham'  ,    4);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Dean'    , 'Koontz'   ,    3);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Nora'    , 'Roberts'  , null);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Danielle', 'Steel'    ,    1);
INSERT INTO Author (AuthorFirstName, AuthorLastName, AgentID) VALUES ('Mario'   , 'Puzo'     , null);

INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('George'  , 'Stevens');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Greg'    ,   'Jones');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Gertrude', 'Jameson');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Guy'     , 'Dudeson');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Gretchen',  'Wilson');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Gloria'  ,  'Venice');
-- MentorID must be updated seperately since EditorID must exist before MentorID can be populated, otherwise an error occurs.
UPDATE Editor SET MentorID=3 WHERE EditorID=1;
UPDATE Editor SET MentorID=5 WHERE EditorID=3;
UPDATE Editor SET MentorID=3 WHERE EditorID=4;
UPDATE Editor SET MentorID=4 WHERE EditorID=6;

INSERT INTO Book VALUES ('The Stand'                     ,  4, 'Horror'  , '1978', '823', 6);
INSERT INTO Book VALUES ('No Country For Old Men'        ,  1, 'Thriller', '2005', '300', 1);
INSERT INTO Book VALUES ('Cross Country'                 ,  2,  null     , '2004', '500', 4);
INSERT INTO Book VALUES ('And Then There Were None'      ,  3, 'Mystery' , '1942', '215', 3);
INSERT INTO Book VALUES ('Diamonds Are Forever'          ,  5, 'Thriller', '1956', '200', 5);
INSERT INTO Book VALUES ('A Time To Kill'                ,  6,  null     , '1984', '300', 6);
INSERT INTO Book VALUES ('The Eyes Of Darkness'          ,  7,  null     , '1996', '250', 3);
INSERT INTO Book VALUES ('Year One'                      ,  8, 'Romance' , '2017', '300', 2);
INSERT INTO Book VALUES ('A Perfect Stranger'            ,  9,  null     , '1981', '400', 1);
INSERT INTO Book VALUES ('The Godfather'                 , 10, 'Drama'   , '1969', '500', 3);
INSERT INTO Book VALUES ('Night Shift'                   ,  4, 'Horror'  , '1979', '300', 6);
INSERT INTO Book VALUES ('The Road'                      ,  1, 'Thriller', '2008', '400', 1);
INSERT INTO Book VALUES ('Omerta'                        , 10, 'Drama'   , '1999', '350', 3);
INSERT INTO Book VALUES ('The Spy Who Loved Me'          ,  5, 'Thriller', '1966', '200', 5);
INSERT INTO Book VALUES ('The Chamber'                   ,  6, 'Drama'   , '1988', '500', 6);
INSERT INTO Book VALUES ('Murder On The Orient Express'  ,  3, 'Mystery' , '1948', '300', 3);
INSERT INTO Book VALUES ('The Dark Tower: The Gunslinger',  4, 'Fantasy' , '1982', '300', 6);
INSERT INTO Book VALUES ('Child Of God'                  ,  1, 'Horror'  , '1973', '200', 1);
INSERT INTO Book VALUES ('Live And Let Die'              ,  5, 'Thriller', '1968', '200', 5);
INSERT INTO Book VALUES ('The Last Don'                  , 10, 'Drama'   , '1994', '400', 3);
INSERT INTO Book VALUES ('Desperation'                   ,  4, 'Horror'  , '1996', '500', 6);
INSERT INTO Book VALUES ('Odd Thomas'                    ,  7, 'Thriller', '1985', '350', 3);
INSERT INTO Book VALUES ('The Firm'                      ,  6, 'Drama'   , '1992', '450', 6);
INSERT INTO Book VALUES ('Outer Dark'                    ,  1,  null     , '1968', '210', 1);
INSERT INTO Book VALUES ('Insomnia'                      ,  4, 'Horror'  , '1994', '700', 6);