-- ------------------------------------------------
-- CoastalPublishing Queries: Assignment 05 Queries
-- Author: Joshua Catoe
-- Course: CSCI 225
-- Assignment: 05
-- Date: 06/30/18
-- Version: 1.0
-- ------------------------------------------------

-- 1
SELECT AgentFirstName, AgentLastName, AgentPhone FROM Agent;

-- 2
SELECT AuthorFirstName, AuthorLastName, BookTitle, BookNumberOfPages FROM Author, Book WHERE Author.authorID=Book.Author_authorID AND BookNumberOfPages>1000;

-- 3
SELECT AuthorLastName, AuthorFirstName FROM Author ORDER BY AuthorLastName, AuthorFirstName;

-- 4
SELECT COUNT(authorID) FROM Author WHERE Agent_agentID IS NULL;

-- 5
SELECT COUNT(BookTitle) FROM Book WHERE BookTitle LIKE '%Hobbit%';

-- 6
SELECT AuthorFirstName, AuthorLastName, AgentFirstName, AgentLastName FROM Author, Agent WHERE Author.Agent_agentID=Agent.agentID AND AuthorLastName LIKE 'C%';

-- 7
SELECT BookTitle, AuthorFirstName, AuthorLastName FROM Book, Author WHERE Book.Author_authorID=Author.authorID AND BookGenre IN ('Biography', 'History');

-- 8
SELECT AuthorFirstName, AuthorLastName, BookTitle, BookGenre, EditorFirstName, EditorLastName FROM Author, Book, Editor WHERE Author.authorID=Book.Author_authorID AND Book.Editor_editorID=Editor.editorID AND BookGenre='Science Fiction';

-- 9
SELECT E.EditorFirstName, E.EditorLastName, M.EditorFirstName AS MentorFirstName, M.EditorLastName AS MentorLastName FROM Editor AS E, Editor AS M WHERE E.editorID=M.mentorID;

-- 10
SELECT EditorFirstName, EditorLastName, BookTitle FROM Editor, Book WHERE Editor.editorID=Book.Editor_editorID AND BookPublishDate='09/26/2006' ORDER BY BookTitle, EditorLastName;

-- 11
SELECT EditorFirstName, EditorLastName, Editor_editorID FROM Editor, Book WHERE Editor.editorID=Book.Editor_editorID GROUP BY Editor_editorID ORDER BY (SELECT COUNT(Editor_editorID)) DESC;

-- 12
SELECT authorID, AuthorFirstName, AuthorLastName, SUM(BookNumberOfPages) FROM Author, Book WHERE Author.authorID=Book.Author_authorID GROUP BY authorID;

-- 13
SELECT Author_authorID, AuthorFirstName, AuthorLastName FROM Book, Author WHERE Book.Author_authorID=Author.authorID GROUP BY Author_authorID ORDER BY (SELECT COUNT(Author_authorID)) DESC;

-- 14
SELECT BookGenre, COUNT(BookGenre) AS 'Number Of Books' FROM Book GROUP BY BookGenre;

-- 15
SELECT AuthorFirstName, AuthorLastName, authorID, BookTitle, BookNumberOfPages FROM Author, Book WHERE Author.authorID=Book.Author_authorID AND BookNumberOfPages>(SELECT AVG(BookNumberOfPages) FROM Book) ORDER BY AuthorFirstName, AuthorLastName, BookTitle, BookNumberOfPages;