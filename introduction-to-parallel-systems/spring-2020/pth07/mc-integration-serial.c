/*
    Joshua Catoe
    CSCI 473
    PTH07
    mc-integration-serial.c - Integrates a function using the Monte Carlo method (serial version).
*/

#include <stdio.h>
#include <stdlib.h>
#include "utilities.h"
#include "timer.h"

/*
    f - Function to be integrated

    Parameters: x - Number to be squared

    Returns: Square of a number
*/
double f(double x) {

    return x*x;
}

int main(int argc, char* argv[]) {

    double start_time;    // Starting point of the timer
    double end_time;      // End point of the timer
    double elapsed_time;  // Total time the program took to run

    GET_TIME(start_time);

    double a;        // Left function bound
    double b;        // Right function bound
    int n;        // Number of points

    // Check that arguments have been entered to avoid segmentation faults
    // In this case, zero is a valid parameter, so strtol() and strtod() are used instead of atoi() for better error checking
    char* end_a;  // Pointer to first invalid character in argv[1]
    char* end_b;  // Pointer to first invalid character in argv[2]
    char* end_n;  // Pointer to first invalid character in argv[3]
    if(argv[1]!=NULL) {a=strtod(argv[1], &end_a);}
    if(argv[2]!=NULL) {b=strtod(argv[2], &end_b);}
    if(argv[3]!=NULL) {n=(int)strtol(argv[3], &end_n, 10);} 

    double area;  // Area under function curve
  
    if(argc!=4) {printf("Usage: ./mc-integration-serial [LEFT BOUND] [RIGHT BOUND] [POINTS]\n");}
    else if(end_a==argv[1] || end_b==argv[2] || end_n==argv[3]) {

        printf("Usage: ./mc-integration-serial [LEFT BOUND] [RIGHT BOUND] [POINTS]\n"
               "All parameters must be integer values.\n");
    }
    else {

        // Calculate Monte Carlo integration
        monte(a, b, n, &f, &area);

        GET_TIME(end_time);
        elapsed_time=end_time-start_time;

        printf("%f  %f  %i    %f    %f\n", a, b, n, area, elapsed_time);
    }

    return 0;
}