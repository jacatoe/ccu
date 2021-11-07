/* Joshua Catoe
 * CSCI 350
 * Prog1
*/

using System;
using System.IO;
using System.Collections.Generic;

namespace Prog1
{
    class RedboxV1_2
    {
        static void Main(string[] args)
        {
            //  Create lists for movie details
            List<string> names = new List<string>();    //  Names of all movies
            List<int> years = new List<int>();          //  Years of all movies
            List<string> directors = new List<string>();  //  Authors of all movies
            List<double> ratings = new List<double>();  //  Ratings of all movies

            int size = importMovies("movies.txt", names, years, directors, ratings);  //  Number of movies in list

            //  Test printMovies and importMovies methods (size will be correct if importMovies worked)
            printMovies(size, names, years, directors, ratings);  

            //  Test printMovie method
            Console.WriteLine("Enter index of movie to print (starts at 0): ");  
            int index = int.Parse(Console.ReadLine());  //  Index of movie in list
            printMovie(size, names, years, directors, ratings, index);  

            //  Test addMovie method
            Console.WriteLine("Enter name of new movie: ");
            string name = Console.ReadLine();  //  Name of new movie
            Console.WriteLine("Enter year of release: ");
            int year = int.Parse(Console.ReadLine());  //  Release year of new movie
            Console.WriteLine("Enter director of movie: ");
            string director = Console.ReadLine();  //  Director of new movie
            Console.WriteLine("Enter rating of movie: ");
            double rating = double.Parse(Console.ReadLine());  //  Rating of new movie
            size = addMovie(size, names, years, directors, ratings, name, year, director, rating);
            Console.WriteLine();
            printMovies(size, names, years, directors, ratings);

            //  Test findMovieByName method
            Console.WriteLine("\nEnter name of movie: ");
            name = Console.ReadLine();
            

            //  Test removeMovieAt method
            Console.WriteLine("\nEnter index of movie to delete (starts at 0): ");
            index = int.Parse(Console.ReadLine());
            size = removeMovieAt(size, names, years, directors, ratings, index);
            printMovies(size, names, years, directors, ratings);

            //  Test sortMovieByName method
            sortMoviesByName(size, names, years, directors, ratings);
            printMovies(size, names, years, directors, ratings);

            //  Close program with user input
            Console.WriteLine("\nPress any key to close.");  
            Console.Read(); 
        }

        static int importMovies(string filename, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            FileStream file = new FileStream(filename, FileMode.Open, FileAccess.Read, FileShare.Read);  //  Open file for reading

            StreamReader stream = new StreamReader(filename);  // Create StreamReader to read from file

            string entry;   //  Stores each line of file        
            string name;    //  Name of movie
            string year;    //  Year of movie's release
            string author;  //  Author of movie
            string rating;  //  Rating of movie
            int counter=0;  //  Keeps track of number of movies

            while ((entry = stream.ReadLine()) != null)  //  Whenever a line is read, do the following
            {
                name = entry.Substring(0, entry.IndexOf("("));  //  Parse name from line
                names.Add(name.Trim());  //  Add name to names list (trimmed for future printing)

                year = entry.Substring(entry.IndexOf("(") + 1, (entry.IndexOf(")")) - (entry.IndexOf("(") + 1));  //  Parse year from line
                years.Add(int.Parse(year));  //  Add year to years list (convert from string to int while adding)

                author = entry.Substring(entry.IndexOf("\"") + 1, (entry.LastIndexOf("\"")) - (entry.IndexOf("\"") + 1));  //  Parse author from line
                directors.Add(author);  //  Add author to authors list

                rating = entry.Substring(entry.IndexOf(".") - 1, (entry.IndexOf(".") + 1) - (entry.IndexOf(".") - 2));  //  Parse rating from line
                ratings.Add(double.Parse(rating));  //  Add rating to ratings list   

                counter++;  //  Increase movie count by 1
            }

            file.Close();  //  Close file

            return counter;  //  Return number of movies
        }

        static void printMovies(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            for (int i = 0; i < names.Count; i++)  //  All of the list sizes are equal, so one was arbitrarily chosen to compare i to 
            {
                Console.WriteLine($"\n{i+1}. {names[i]}, directed by {directors[i]} - {years[i]} - rated {ratings[i]}\n");  //  Print movie information to console
            }
        }

        static void printMovie(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings, int index)
        {
            try
            {
                Console.WriteLine($"\n{index + 1}. {names[index]}, directed by {directors[index]} - {years[index]} - rated {ratings[index]}\n");  //  Print movie information to console
            }
            catch(ArgumentOutOfRangeException e)
            {
                //  Print reason for error
                if(index<0) { Console.WriteLine("\nERROR: Index too small.\n"); }
                else if(index>size) { Console.WriteLine("\nERROR: Index too large.\n"); }
            }
        }

        static int addMovie(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings, string name, int year, string director, double rating)
        {
            //  Add moive details to each list
            names.Add(name);
            years.Add(year);
            directors.Add(director);
            ratings.Add(rating);

            size++;  //  Increase size by 1 (i.e. add movie)

            return size;  
        }

        static int findMovieByName(int size, string name, List<string> names)
        {
            //  Retrieve index of movie name, if it exists
            if (names.Contains(name)) { return names.IndexOf(name); }
            else { return -1; }
        }

        static int removeMovieAt(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings, int index)
        {
            //  Remove movie details from each list
            names.Remove(names[index]);
            years.Remove(years[index]);
            directors.Remove(directors[index]);
            ratings.Remove(ratings[index]);

            size--;  //  Decrease size by 1 (i.e. delete movie)

            return size;
        }

        static void sortMoviesByName(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            names.Sort();  //  Sort names alphabetically             
        }
    }
}