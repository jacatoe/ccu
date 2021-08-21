/* Joshua Catoe
 * CSCI 350
 * Prog1
*/

using System;
using System.IO;

namespace Prog1
{
    class RedboxV1_0
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

            while ((entry=stream.ReadLine()) != null)  //  Whenever a line is read, do the following
            {
                name = entry.Substring(0, entry.IndexOf("("));  //  Parse name from line

                year = entry.Substring(entry.IndexOf("(") + 1, (entry.IndexOf(")")) - (entry.IndexOf("(") + 1));  //  Parse year from line

                author = entry.Substring(entry.IndexOf("\"") + 1, (entry.LastIndexOf("\"")) - (entry.IndexOf("\"") + 1));  //  Parse author from line

                rating = entry.Substring(entry.IndexOf(".") - 1, (entry.IndexOf(".") + 1) - (entry.IndexOf(".") - 2));  //  Parse rating from line

                Console.WriteLine($"Name: {name}\nYear: {year}\nAuthor: {author}\nRating: {rating}\n");  //  Print movie information to console
            }

            file.Close();  //  Close file

            Console.WriteLine("Press any key to close.");  //  Prompt user to close program

            Console.Read(); //  Read input to close program

            
        }
    }
}
