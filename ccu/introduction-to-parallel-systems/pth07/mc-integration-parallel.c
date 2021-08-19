/*
    Joshua Catoe
    CSCI 473
    PTH07
    mc-integration-parallel.c - Integrates a function using the Monte Carlo method (MPI parallel version).
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include "mpi.h"

/*
    f - Function to be integrated

    Parameters: x - Number to be squared

    Returns: Square of a number
*/
double f(double x) {

    return x*x;
}

int main(int argc, char* argv[]) {

    double a;        // Left function bound
    double b;        // Right function bound
    int n;           // Number of points

    // Check that arguments have been entered to avoid segmentation faults
    // In this case, zero is a valid parameter, so strtol() is used instead of atoi() for better error checking
    char* end_a;  // Pointer to first invalid character in argv[1]
    char* end_b;  // Pointer to first invalid character in argv[2]
    char* end_n;  // Pointer to first invalid character in argv[3]
    if(argv[1]!=NULL) {a=strtod(argv[1], &end_a);}
    if(argv[2]!=NULL) {b=strtod(argv[2], &end_b);}
    if(argv[3]!=NULL) {n=(int)strtol(argv[3], &end_n, 10);} 

    if(argc!=4) {printf("Usage: ./mc-integration-parallel [LEFT BOUND] [RIGHT BOUND] [POINTS]\n");}
    else if(end_a==argv[1] || end_b==argv[2] || end_n==argv[3]) {

        printf("Usage: ./mc-integration-parallel [LEFT BOUND] [RIGHT BOUND] [POINTS]\n"
               "LEFT BOUND and RIGHT BOUND must be integers or floats.\n"
               "POINTS must be an integer value.");
    }
    else {

        MPI_Init(&argc, &argv);

        double start_time=MPI_Wtime();  // Starting point of the timer

        int size;     // Number of processes
        int my_rank;  // Rank of process

        MPI_Comm_size(MPI_COMM_WORLD, &size);     // Get number of processes
        MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);  // Get rank of process

        int my_n=floor(n/size);  // Process's portion of points
        if((n%size)!=0 && my_rank<(n%size)) {my_n++;}  // If there are remaining points after dividing, distribute them evenly
        int my_under=0;  // Number of points below curve

        // Find number of points that fall below the function curve
        srand48(time(0)+my_rank);  // Seed drand48() with process rank and current time
        int i;
        for(i=0; i<my_n; i++) {

            double x_i=((b-a)*drand48())+a;  // X-coordinate for point
            double y_i=drand48()*f(b);       // Y-coordinate for point

            // Take count of all points below curve
            if(y_i<=f(x_i)) {my_under++;}
        }

        int under; // Total number of points below curve
        
        // Process zero receives number of points under curve from each process and sums them
        MPI_Reduce(&my_under, &under, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD); 

        double area; // Area under function curve

        if(my_rank==0) {

            double total=(b-a)*(f(b));  // Total area of plane

            // Area of interest is calculated by multiplying the number of points under the curve by the total area and then dividing by the total number of points
            area=((double)under*total)/(double)n;
        }

        double end_time=MPI_Wtime();  // End point of the timer
        double elapsed_time=end_time-start_time;  // Total time the program took to run

        if(my_rank==0) {printf("%f  %f  %i    %f    %f    %i\n", a, b, n, area, elapsed_time, size);}

        MPI_Finalize();
    }

    return 0;
}