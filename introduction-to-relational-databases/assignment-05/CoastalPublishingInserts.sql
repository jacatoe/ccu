-- --------------------------------------------------------
-- CoastalPublishing Inserts: Initial Inserts
--
-- Author: Clint Fuchs
-- Course: CSCI 225
-- Assignment: 6
-- Date: 6/27/2018
-- Version: 1.0
-- --------------------------------------------------------


-- Agent Inserts
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Timothy', 'Burns', '488-348-3899');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Jason', 'Williamson', '583-829-5866');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Caroline', 'Hannon', '291-332-1485');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Melody', 'Woods', '920-588-3078');
INSERT INTO Agent (AgentFirstName, AgentLastName, AgentPhone) VALUES ('Eugene', 'Rosewood', '199-443-0912');


-- Author Inserts - depends on Agent.agentID Foreign Key
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName) VALUES (101,"John","Smith");
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (102,"Stephen","King",3);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (104,"JR","Tolken",2);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (105,"JK","Rowling", 4);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName) VALUES (106,"Mark","Twain");
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (107,"Jessica","Fletcher", 5);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (108,"Michael","Chrichton", 5);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (109,"Stephenie","Meyer", 2);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (110,"James","Patterson", 1);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName) VALUES (1077, 'William', 'Faulkner');
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (1057, 'Terrance', 'Wallace', 1);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName) VALUES (1083, 'Elizabeth', 'Ross');
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (1090, 'Kellen', 'Spelman', 2);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName, Agent_agentID) VALUES (1102, 'Thomas', 'Harmon', 3);
INSERT INTO Author (authorID, AuthorFirstName, AuthorLastName) VALUES (1046, 'Angela', 'Simmons');


-- Editor Inserts
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('James', 'Pattinson');
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Chandler', 'Dry');
INSERT INTO Editor (EditorFirstName, EditorLastName, mentorID) VALUES ('Austin', 'Tyler', 2);
INSERT INTO Editor (EditorFirstName, EditorLastName, mentorID) VALUES ('Taco', 'Patrick', 1);
INSERT INTO Editor (EditorFirstName, EditorLastName) VALUES ('Heather', 'Piper');
INSERT INTO Editor (EditorFirstName, EditorLastName, mentorID) VALUES ('Haley', 'Bass',1);



-- Book Inserts - depends on authorID and editorID - Foreign Keys
INSERT INTO Book VALUES ('How To Program In C++','Educational','01/05/1995', 1042, 101, 3);
INSERT INTO Book VALUES ("A Perfect Life","Drama","01/02/2014", 865, 109, 1);
INSERT INTO Book VALUES ("The Hobbit: An Unexpected Journey","Fantasy","02/28/1975", 975, 104, 5);
INSERT INTO Book VALUES ("Tom Sawyer","Adventure","02/13/1895", 565, 106, 1);
INSERT INTO Book VALUES ("Murder She Wrote","Mystery","06/29/1990", 650, 107, 2);
INSERT INTO Book VALUES ("Jurassic Park","Adventure","05/21/1992", 1058, 108, 4);
INSERT INTO Book VALUES ("Twilight","Fantasy","08/28/2008", 762, 110, 4);
INSERT INTO Book VALUES ("Cross","Drama","09/16/2006", 433, 109, 1);
INSERT INTO Book VALUES ("Jurassic World","Adventure","12/14/2013", 1439, 108, 4);
INSERT INTO Book VALUES ("New Moon","Fantasy","12/16.2009", 843, 110, 4);
INSERT INTO Book VALUES ("Harry Potter and the Sorcerer's Stone","Fantasy","11/06/2002", 1378, 105, 4);
INSERT INTO Book VALUES ("Harry Potter and the Prisoner From Azkaban","Fantasy","11/12/2004", 1982, 105, 4);
INSERT INTO Book VALUES ("Harry Potter and the Order of the Phoenix","Fantasy","12/16/2006", 980, 105, 4);
INSERT INTO Book VALUES ("Harry Potter and the Deathly Hallows","Fantasy","12/18.2009", 2016, 105, 4);
INSERT INTO Book VALUES ("Harry Potter and the Chamber Of Secrets","Fantasy","12/05/2003", 1621, 105, 4);
INSERT INTO Book VALUES ("How To Program In Java","Educational","09/16/2006", 1501, 101, 3);
INSERT INTO Book VALUES ("HTML and CSS","Educational","03/11/2006", 1420, 101, 3);
INSERT INTO Book VALUES ("The Hobbit: Desolation Of Smaug","Fantasy","02/28/1976", 2469, 104, 6);
INSERT INTO Book VALUES ("TLOTR: The Fellowship Of The Ring","Fantasy","10/09/2005", 2638, 104, 5);
INSERT INTO Book values ("TLOTR: The Return Of The King","Fantasy","10/07/2008", 3653, 104, 5);
INSERT INTO Book VALUES ('Cars and More', 'Educational', '04/28/1996', 412, 1102, 3);
INSERT INTO Book VALUES ('Information Technology', 'Educational', '07/23/1988', 850, 1046, 3);
INSERT INTO Book VALUES ('Brain Wars', 'Science Fiction', '09/16/2006', 744, 1090, 2);
INSERT INTO Book VALUES ('Battle of Ryan', 'History', '11/05/1922', 1222, 1057, 6);
INSERT INTO Book VALUES ('National World', 'History', '01/01/1955', 1166, 1057, 6);
INSERT INTO Book VALUES ('Pop Tarts', 'History', '04/05/1966',654, 1102, 1);
INSERT INTO Book VALUES ('Trailblazers', 'Science Fiction', '28/22/008', 755, 108, 3);
INSERT INTO Book VALUES ('History of the Camaro', 'History', '02/09/1972', 626, 1102, 1);
INSERT INTO Book VALUES ('Space Shuttles', 'History', '12/01/1952', 400, 1102, 6);
INSERT INTO Book VALUES ('Space Truckers', 'Science Fiction', '2/22/2004',399, 110, 3);
INSERT INTO Book VALUES ('Tesla: The Elon Musk Story', 'Biography', '08/08/2017', 555, 1090, 6);
INSERT INTO Book VALUES ('Gap Band', 'Biography', '02/01/2001', 345, 1046, 6);
INSERT INTO Book VALUES ('Drag Racing', 'History', '6/16/2016', 875, 1102, 2);
INSERT INTO Book VALUES ('US Murders', 'Mystery', '04/24/2017', 622, 1083, 2);
INSERT INTO Book VALUES ('DB Cooper', 'Mystery', '02/02/2000', 226, 107, 2);
INSERT INTO Book VALUES ('The American Indian', 'History', '11/22/2001', 989, 1057, 3);
INSERT INTO Book VALUES ('Rick Ross', 'Biography', '9/26/2006', 413, 1102, 4);
INSERT INTO Book VALUES ('The Life and Times of Michelle Obama', 'Biography', '3/14/2016', 842, 109, 1);
INSERT INTO Book VALUES ('JFK and the Modern Camelot', 'Biography', '07/08/1986', 714, 109, 6);
INSERT INTO Book VALUES ('2 Pac', 'Biography', '04/29/2001', 636, 1057, 6);
INSERT INTO Book VALUES ('President Donald Trump', 'Biography', '03/30/2017', 711, 1057, 6);
INSERT INTO Book VALUES ('President Obama', 'Biography', '02/01/2017', 1022, 109, 6);
INSERT INTO Book VALUES ('Prison Break', 'Mystery', '07/08/2012', 723, 110, 2);
