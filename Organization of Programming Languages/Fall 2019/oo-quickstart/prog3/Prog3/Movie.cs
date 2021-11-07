/* Joshua Catoe
 * CSCI 350
 * Prog3
*/

using System;
using System.Collections.Generic;

namespace Prog3
{
    class Movie
    {
        static void Main(string[] args)
        {
            Movie movie1 = new Movie();  //  Instantiate Movie with default constructor

            Movie movie2 = new Movie("The Godfather", "Coppola, Francis Ford", 1972, 9.9);  //  Instantiate Movie with parameterized constructor

            //  Set properties of movie1
            movie1.setName("The Fog");
            movie1.setDirector("Carpenter, John");
            movie1.setYear(1980);
            movie1.setRating(9.0);

            movie2.setRating(9.5);  //  Change rating of movie2

            //  Print results of getter methods
            Console.WriteLine(movie1.getName());
            Console.WriteLine(movie1.getDirector());
            Console.WriteLine(movie1.getYear());
            Console.WriteLine(movie1.getRating());
            Console.WriteLine();
            Console.WriteLine(movie2.getName());
            Console.WriteLine(movie2.getDirector());
            Console.WriteLine(movie2.getYear());
            Console.WriteLine(movie2.getRating());

            //  Print results of toString()
            movie1.toString();
            movie2.toString();

            //  Print results of equals()
            if(movie1.equals(movie2) == 1)
            {
                Console.WriteLine("\nThe movies are equivalent.\n");
            }
            else
            {
                Console.WriteLine("\nThe movies are not equivalent.\n");
            }

            //  Print results of compareTo()
            if(movie1.compareTo(movie2) == -1)
            {
                Console.WriteLine($"\n\"{movie1.name}\" comes before \"{movie2.name}\"\n");
            }
            else if (movie1.compareTo(movie2) == 1)
            {
                Console.WriteLine($"\n\"{movie2.name}\" comes before \"{movie1.name}\"\n");
            }
            else
            {
                Console.WriteLine($"\n\"{movie1.name}\" is in the same position as \"{movie2.name}\"\n");
            }

            //  Create list to hold Movie objects
            List<Movie> movies = new List<Movie>();

            //  Copy movies in to list using clone()
            movies.Add(movie1.clone());
            movies.Add(movie2.clone());

            //  Print list of movie copies
            for(int i=0; i<movies.Count; i++)
            {
                movies[i].toString();
            }

            //  Close program with input
            Console.WriteLine("\nPress any key to close.");
            Console.ReadLine();
        }

        private string name;      //  Name of movie
        private string director;  //  Director of movie
        private int year;         //  Release year of movie
        private double rating;    //  Rating of movie

        //  Default movie constructor
        public Movie()
        {

        }

        //  Parameterized constructor
        public Movie(string name, string director, int year, double rating)
        {
            this.name = name;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }

        // Get name of movie
        public string getName()
        {
            return name;
        }

        //  Get director of movie
        public string getDirector()
        {
            return director;
        }

        //  Get release year of move
        public int getYear()
        {
            return year;
        }

        //  Get rating of movie
        public double getRating()
        {
            return rating;
        }

        //  Set name of movie
        public void setName(string name)
        {
            this.name = name;
        }

        //  Set director of movie
        public void setDirector(string director)
        {
            this.director = director;
        }

        //  Set release year of movie
        public void setYear(int year)
        {
            this.year = year;
        }

        //  Set rating of movie
        public void setRating(double rating)
        {
            this.rating = rating;
        }

        //  Print movie properties in formatted string
        public void toString()
        {
            Console.WriteLine($"\n{name}, directed by {director} - {year} - rated {rating}\n");
        }

        //  Check if compared movies are the same
        public int equals(Movie movie)
        {
            if (this.name==movie.name && this.director == movie.director && this.year == movie.year && this.rating == movie.rating)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        //  Compare sort order of movies
        public int compareTo(Movie movie)
        {
            int equal = this.name.CompareTo(movie.name);

            if(equal < 0)
            {
                return -1;
            } 
            else if(equal > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        //  Create copy of specified movie
        public Movie clone()
        {
            Movie copy = new Movie(name, director, year, rating);

            return copy;
        }
    }
}
