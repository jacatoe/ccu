/* Joshua Catoe
 * CSCI 350
 * Prog1
*/

using System;
using System.IO;
using System.Collections.Generic;

namespace Prog1
{
    class RedboxV1_1
    {
        static void Main(string[] args)
        {
            // Read input from file 

            FileStream file = new FileStream("movies.txt", FileMode.Open, FileAccess.Read, FileShare.Read);  //  Open file for reading

            StreamReader stream = new StreamReader("movies.txt");  // Create StreamReader to read from file

            string entry;  //  Variable to store each line of file

            string name;    //  Name of movie
            string year;    //  Year of movie's release
            string author;  //  Author of movie
            string rating;  //  Rating of movie

            List<string> names = new List<string>();    //  Names of all movies
            List<int> years = new List<int>();          //  Years of all movies
            List<string> authors = new List<string>();  //  Authors of all movies
            List<double> ratings = new List<double>();  //  Ratings of all movies

            while ((entry = stream.ReadLine()) != null)  //  Whenever a line is read, do the following
            {
                name = entry.Substring(0, entry.IndexOf("("));  //  Parse name from line

                names.Add(name);  //  Add name to names list

                year = entry.Substring(entry.IndexOf("(") + 1, (entry.IndexOf(")")) - (entry.IndexOf("(") + 1));  //  Parse year from line

                years.Add(int.Parse(year));  //  Add year to years list (convert from string to int while adding)

                author = entry.Substring(entry.IndexOf("\"") + 1, (entry.LastIndexOf("\"")) - (entry.IndexOf("\"") + 1));  //  Parse author from line

                authors.Add(author);  //  Add author to authors list

                rating = entry.Substring(entry.IndexOf(".") - 1, (entry.IndexOf(".") + 1) - (entry.IndexOf(".") - 2));  //  Parse rating from line

                ratings.Add(double.Parse(rating));  //  Add rating to ratings list                
            }

            file.Close();  //  Close file

            for (int i = 0; i < names.Count; i++)  //  All of the list sizes are equal, so one was arbitrarily chosen to compare i to 
            {
                Console.WriteLine($"Name: {names[i]}\nYear: {years[i]}\nAuthor: {authors[i]}\nRating: {ratings[i]}\n");  //  Print movie information to console
            }

            Console.WriteLine("Press any key to close.");  //  Prompt user to close program

            Console.Read(); //  Read input to close program
        }
    }
}
