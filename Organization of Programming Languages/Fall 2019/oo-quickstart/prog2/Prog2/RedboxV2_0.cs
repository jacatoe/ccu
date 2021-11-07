/* Joshua Catoe
 * CSCI 350
 * Prog2
*/

using System;
using System.IO;
using System.Collections.Generic;

namespace Prog2
{
    class RedboxV2_0
    {
        static void Main(string[] args)
        {
            //  Create lists for movie details
            List<Movie> movies = new List<Movie>();
            int size=0;  //  Number of movies in list

            startMenu(size, movies);  //  Launch menu
        }

        static void startMenu(int size, List<Movie> movies)
        {
            if (importMovies("movies.txt", movies) < 1)
            {
                Console.WriteLine("ERROR: File may be missing or corrupt.\n");
            }
            else
            {
                string input;     //  User input
                string name;      //  Name of movie
                string director;  //  Director of movie
                int year;         //  Movie release year
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
                            printMovies(size, movies);
                            break;

                        //  Search for movie by name
                        case "s":
                            Console.WriteLine("\nEnter name of movie: ");
                            name = Console.ReadLine();
                            if((index = findMovieByName(size, name, movies)) == -1)
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
                                size = addMovie(size, movies, name, director, year, rating);
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
                                Console.WriteLine($"\nRemoved movie \"{movies[index].getName()}\".\n");
                                size = removeMovieAt(size, movies, index);
                            }
                            catch(ArgumentOutOfRangeException e)
                            {
                                Console.WriteLine("\nCould not remove movie - movie not found.\n");
                            }
                            break;

                        //  Sort movies by name
                        case "o":
                            sortMoviesByName(size, movies);
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

        static int importMovies(string filename, List<Movie> movies)
        {
            try
            {
                FileStream file = new FileStream(filename, FileMode.Open, FileAccess.Read, FileShare.Read);  //  Open file for reading

                StreamReader stream = new StreamReader(filename);  // Create StreamReader to read from file

                string entry;   //  Stores each line of file        
                string name;    //  Name of movie
                string director;  //  Author of movie
                string year;    //  Year of movie's release
                string rating;  //  Rating of movie

                while ((entry = stream.ReadLine()) != null)  //  Whenever a line is read, do the following
                {
                    //  Read movie details from file
                    name = entry.Substring(0, entry.IndexOf("("));  //  Parse name from line
                    director = entry.Substring(entry.IndexOf("\"") + 1, (entry.LastIndexOf("\"")) - (entry.IndexOf("\"") + 1));  //  Parse author from line
                    year = entry.Substring(entry.IndexOf("(") + 1, (entry.IndexOf(")")) - (entry.IndexOf("(") + 1));  //  Parse year from line
                    rating = entry.Substring(entry.IndexOf(".") - 1, (entry.IndexOf(".") + 1) - (entry.IndexOf(".") - 2));  //  Parse rating from line

                    Movie new_movie = new Movie(name.Trim(), director, int.Parse(year), double.Parse(rating));  //  Create new movie from variables
                    movies.Add(new_movie);  //  Add movie to list
                }

                file.Close();  //  Close file

                return movies.Count;  //  Return number of movies
            }
            catch(FileNotFoundException e)
            {
                return movies.Count;  //  Return number of movies to let startMenu handle exception
            }
        }

        static void printMovies(int size, List<Movie> movies)
        {
            for (int i = 0; i < movies.Count; i++)  
            {
                Console.WriteLine($"{i}. ");  //  Couldn't figure out elegant solution to print index along with toString()
                movies[i].toString();
            }
        }

        static int findMovieByName(int size, string name, List<Movie> movies)
        {
            //  Retrieve index of movie name, if it exists
            for(int i=0; i<movies.Count; i++)
            {
                if (movies[i].getName() == name)
                {
                    return i;
                }
            }

            return -1;
        }

        static int addMovie(int size, List<Movie> movies, string name, string director, int year, double rating)
        {
            //  Add new movie to movie list
            Movie new_movie = new Movie(name, director, year, rating);
            movies.Add(new_movie);

            size++;  //  Increase size by 1 (i.e. add movie)

            return size;
        }

        static int removeMovieAt(int size, List<Movie> movies, int index)
        {
            //  Remove movie details from each list
            movies.Remove(movies[index]);

            size--;  //  Decrease size by 1 (i.e. delete movie)

            return size;
        }

        static void sortMoviesByName(int size, List<Movie> movies)
        {
            //  Sort names alphabetically             
        }
    }
}