/* Joshua Catoe
 * CSCI 350
 * Prog1
*/

using System;
using System.IO;
using System.Collections.Generic;

namespace Prog1
{
    class RedboxV1_3
    {
        static void Main(string[] args)
        {
            //  Create lists for movie details
            List<string> names = new List<string>();    //  Names of all movies
            List<int> years = new List<int>();          //  Years of all movies
            List<string> directors = new List<string>();  //  Authors of all movies
            List<double> ratings = new List<double>();  //  Ratings of all movies
            int size=0;  //  Number of movies in list

            startMenu(size, names, years, directors, ratings);  //  Launch menu
        }

        static void startMenu(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            if (importMovies("movies.txt", names, years, directors, ratings) < 1)
            {
                Console.WriteLine("ERROR: File may be missing or corrupt.\n");
            }
            else
            {
                string input;     //  User input
                string name;      //  Name of movie
                int year;         //  Movie release year
                string director;  //  Director of movie
                double rating;    //  Rating of movie
                int index;        //  Index of moive in list

                //  Remain in menu system until user enters "e" for Exit
                do
                {
                    // Print menu text
                    Console.WriteLine("Menu\n");
                    Console.WriteLine("b) Browse\n");
                    Console.WriteLine("s) Search\n");
                    Console.WriteLine("a) Add\n");
                    Console.WriteLine("r) Remove\n");
                    Console.WriteLine("o) Sort\n");
                    Console.WriteLine("e) Exit\n");
                    Console.WriteLine("Enter Selection:");

                    input = Console.ReadLine();  //  Store user input

                    switch (input)
                    {
                        //  Print list of movies
                        case "b":
                            printMovies(size, names, years, directors, ratings);
                            break;

                        //  Search for movie by name
                        case "s":
                            Console.WriteLine("\nEnter name of movie: ");
                            name = Console.ReadLine();
                            if((index = findMovieByName(size, name, names)) == -1)
                            {
                                Console.WriteLine("\nMovie not found.\n");
                            }
                            else
                            {
                                Console.WriteLine($"\nThe movie's index is: {index}\n");
                            }
                            break;

                        //  Add movie to list        
                        case "a":
                            try
                            {
                                Console.WriteLine("Enter name of new movie: ");
                                name = Console.ReadLine();  //  Name of new movie
                                Console.WriteLine("Enter year of release: ");
                                year = int.Parse(Console.ReadLine());  //  Release year of new movie
                                Console.WriteLine("Enter director of movie: ");
                                director = Console.ReadLine();  //  Director of new movie
                                Console.WriteLine("Enter rating of movie: ");
                                rating = double.Parse(Console.ReadLine());  //  Rating of new movie
                                size = addMovie(size, names, years, directors, ratings, name, year, director, rating);
                                Console.WriteLine($"\nAdded movie \"{name}\"\n");
                            }
                            catch(FormatException e)
                            {
                                Console.WriteLine("\nInvalid year or rating format.\n");
                            }
                            break;
                
                        //  Remove movie from list
                        case "r":
                            try
                            {
                                Console.WriteLine("\nEnter index of movie to delete (starts at 0): ");
                                index = int.Parse(Console.ReadLine());
                                size = removeMovieAt(size, names, years, directors, ratings, index);
                                Console.WriteLine($"\nRemoved movie \"{names[index]}\".\n");
                            }
                            catch(ArgumentOutOfRangeException e)
                            {
                                Console.WriteLine("\nCould not remove movie - movie not found.\n");
                            }
                            break;

                        //  Sort movies by name
                        case "o":
                            sortMoviesByName(size, names, years, directors, ratings);
                            Console.WriteLine("\nMovies sorted by name.\n");
                            break;
                            
                        //  Inform user that their choice is not an option
                        default:
                            Console.WriteLine("Invalid selection.\n");
                            break;
                    }

                } while (String.Equals(input, "e") != true);
            }
        }

        static int importMovies(string filename, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            int counter=0;  //  Keeps track of number of movies

            try
            {
                FileStream file = new FileStream(filename, FileMode.Open, FileAccess.Read, FileShare.Read);  //  Open file for reading

                StreamReader stream = new StreamReader(filename);  // Create StreamReader to read from file

                string entry;   //  Stores each line of file        
                string name;    //  Name of movie
                string year;    //  Year of movie's release
                string author;  //  Author of movie
                string rating;  //  Rating of movie
                counter = 0;    //  Keeps track of number of movies

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
            catch(FileNotFoundException e)
            {
                return counter;  //  Return counter to let startMenu handle exception
            }
        }

        static void printMovies(int size, List<string> names, List<int> years, List<string> directors, List<double> ratings)
        {
            for (int i = 0; i < names.Count; i++)  //  All of the list sizes are equal, so one was arbitrarily chosen to compare i to 
            {
                Console.WriteLine($"\n{i + 1}. {names[i]}, directed by {directors[i]} - {years[i]} - rated {ratings[i]}\n");  //  Print movie information to console
            }
        }

        static int findMovieByName(int size, string name, List<string> names)
        {
            //  Retrieve index of movie name, if it exists
            if (names.Contains(name)) { return names.IndexOf(name); }
            else { return -1; }
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