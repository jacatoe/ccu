/* Joshua Catoe
 * CSCI 350
 * Prog3
*/

using System;
using System.IO;
using System.Collections.Generic;

namespace Prog3
{
    class Greenbox
    {
        private List<Movie> movies;  //  List of movie objects
        private int size;            //  Size of movie list

        static void Main(string[] args)
        {
            Greenbox greenbox = new Greenbox();

            greenbox.start();  //  Launch menu
        }

        public Greenbox()
        {
            movies = new List<Movie>();  //  Initialize empty movie list
            size = 0;                    //  Initialize size to 0
        }

        void start()
        {
            importMovies("movies.txt");

            if (size == 0)
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
                    Console.WriteLine("n) Sort by name\n");
                    Console.WriteLine("d) Sort by director\n");
                    Console.WriteLine("y) Sort by year\n");
                    Console.WriteLine("t) Sort by rating\n");
                    Console.WriteLine("e) Exit\n");
                    Console.WriteLine("Enter Selection:");

                    input = Console.ReadLine();  //  Store user input

                    switch (input)
                    {
                        //  Print list of movies
                        case "b":
                            printMovies();
                            break;

                        //  Search for movie by name
                        case "s":
                            Console.WriteLine("\nEnter name of movie: ");
                            name = Console.ReadLine();
                            if((index = findMovieByName(name)) == -1)
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
                                Console.WriteLine("Enter director of movie: ");
                                director = Console.ReadLine();  //  Director of new movie
                                Console.WriteLine("Enter year of release: ");
                                year = int.Parse(Console.ReadLine());  //  Release year of new movie
                                Console.WriteLine("Enter rating of movie: ");
                                rating = double.Parse(Console.ReadLine());  //  Rating of new movie

                                Movie new_movie = new Movie(name, director, year, rating);

                                if(addMovie(new_movie) == 1)
                                {
                                    Console.WriteLine($"\nAdded movie \"{name}\"\n");
                                }
                                else
                                {
                                    Console.WriteLine("\nAn error occurred - movie not added.\n");
                                }
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
                                if(removeMovieAt(index) == 1)
                                {
                                    Console.WriteLine($"\nRemoved movie \"{movies[index].getName()}\".\n");
                                }
                                else
                                {
                                    Console.WriteLine("\nAn error occurred - could not remove movie.\n");
                                }
                            }
                            catch(ArgumentOutOfRangeException e)
                            {
                                Console.WriteLine("\nCould not remove movie - movie not found.\n");
                            }
                            break;

                        //  Sort movies by name
                        case "n":
                            sortMoviesByName();
                            Console.WriteLine("\nMovies sorted by name.\n");
                            break;

                        //  Sort movies by director
                        case "d":
                            sortMoviesByDirector();
                            Console.WriteLine("\nMovies sorted by director.\n");
                            break;

                        //  Sort movies by year
                        case "y":
                            sortMoviesByYear();
                            Console.WriteLine("\nMovies sorted by year.\n");
                            break;

                        //  Sort movies by rating
                        case "t":
                            sortMoviesByRating();
                            Console.WriteLine("\nMovies sorted by rating.\n");
                            break;

                        //  Inform user that their choice is not an option
                        default:
                            Console.WriteLine("Invalid selection.\n");
                            break;
                    }

                } while (String.Equals(input, "e") != true);
            }
        }

        void importMovies(string filename)
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

                size = movies.Count;  //  Size is number of movies in list
            }
            catch(FileNotFoundException e)
            {
                size = 0;  //  Indicates import failure
            }
        }

        void printMovies()
        {
            for (int i = 0; i < movies.Count; i++)  
            {
                movies[i].toString();
            }
        }

        void printMovie(int index)
        {
            try
            {
                movies[index].toString();
            }
            catch (ArgumentOutOfRangeException e)
            {
                //  Print reason for error
                if (index < 0) { Console.WriteLine("\nIndex too small.\n"); }
                else if (index > size) { Console.WriteLine("\nIndex too large.\n"); }
            }
        }

        int addMovie(Movie movie)
        {
            //  Add new movie to movie list
            movies.Add(movie.clone());

            if(findMovieByName(movie.getName()) >= 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        int findMovieByName(string name)
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

        int removeMovieAt(int index)
        {
            //  Remove movie details from each list
            if(movies.Remove(movies[index]) == true)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        void sortMoviesByName()
        {
                       
        }

        void sortMoviesByDirector()
        {

        }

        void sortMoviesByYear()
        {

        }

        void sortMoviesByRating()
        {

        }
    }
}