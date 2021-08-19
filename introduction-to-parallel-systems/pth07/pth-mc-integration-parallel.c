/*
    Joshua Catoe
    CSCI 473
    PTH07
    pth-mc-integration-parallel.c - Integrates a function using the Monte Carlo method (Pthread parallel version).
*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <math.h>
#include "timer.h"

int num_threads;        // Number of threads used in program
double a;               // Left function bound
double b;               // Right function bound
int n;                  // Number of points
int under;              // Total number of points below curve
pthread_mutex_t mutex;  // Mutex lock for thread critical section

/*
    f - Function to be integrated

    Parameters: x - Number to be squared

    Return Value: Square of a number
*/
double f(double x) {

    return x*x;
}

/*
    my_points - Calculates a thread's own number of points below the function curve

    Parameters: id - Thread id

    Return Value: NULL
*/
void* my_points(void* id) {

    long my_id=(long)id;  // Thread id
    int my_n=floor(n/num_threads);  // Process's portion of points
    if((n%num_threads)!=0 && my_id<(n%num_threads)) {my_n++;}  // If there are remaining points after dividing, distribute them evenly
    int my_under=0;  // Number of points below curve

    // Find number of points that fall below the function curve   
    unsigned short seed[3]={(time(0)+my_id), (time(0)+my_id+1), (time(0)+my_id+2)};  // Seed erand48() with thread id and current time
    int i;
    for(i=0; i<my_n; i++) {

        double x_i=((b-a)*erand48(seed))+a;  // X-coordinate for point
        double y_i=erand48(seed)*f(b);       // Y-coordinate for point

        // Take count of all points below curve
        if(y_i<=f(x_i)) {my_under++;}
    }

    // Add thread's points below curve to total points below curve
    pthread_mutex_lock(&mutex);
    under+=my_under;
    pthread_mutex_unlock(&mutex);
 
    return NULL;
}

int main(int argc, char* argv[]) {

    double start_time;    // Starting point of the timer
    double end_time;      // End point of the timer
    double elapsed_time;  // Total time the program took to run

    GET_TIME(start_time);

    // Check that arguments have been entered to avoid segmentation faults
    // In this case, zero is a valid parameter, so strtol() is used instead of atoi() for better error checking
    char* end_num_threads;  // Pointer to first invalid character in argv[1]  
    char* end_a;            // Pointer to first invalid character in argv[2]
    char* end_b;            // Pointer to first invalid character in argv[3]
    char* end_n;            // Pointer to first invalid character in argv[4]
    if(argv[1]!=NULL) {num_threads=(int)strtol(argv[1], &end_num_threads, 10);}
    if(argv[2]!=NULL) {a=strtod(argv[2], &end_a);}
    if(argv[3]!=NULL) {b=strtod(argv[3], &end_b);}
    if(argv[4]!=NULL) {n=(int)strtol(argv[4], &end_n, 10);}

    if(argc!=5) {printf("Usage: ./pth-mc-integration-parallel [THREADS] [LEFT BOUND] [RIGHT BOUND] [POINTS]\n");}
    else if(end_num_threads==argv[1] || end_a==argv[2] || end_b==argv[3] || end_n==argv[4]) {

        printf("Usage: ./pth-mc-integration-parallel [THREADS] [LEFT BOUND] [RIGHT BOUND] [POINTS]\n"
               "THREADS and POINTS must be integer values greater than zero.\n"
               "LEFT BOUND and RIGHT BOUND must be integers or floats.\n");
    }
    else {

        // Allocate space for threads
        pthread_t* threads=malloc(num_threads*(sizeof(pthread_t)));  // Array of thread objects

        // Initialize mutex
        pthread_mutex_init(&mutex, NULL);

        // Create threads
        // i serves the dual purpose of loop counter and thread ids
        long i;
        for(i=0; i<num_threads; i++) {pthread_create(&threads[i], NULL, my_points, (void*)i);}

        // Join threads back together
        for(i=0; i<num_threads; i++) {pthread_join(threads[i], NULL);}

        // Approximate area under function curve
        double total=(b-a)*(f(b));  // Total area of plane
        double area=((double)under*total)/(double)n;  // Area under function curve

        // Destroy mutex
        pthread_mutex_destroy(&mutex);

        // Free memory used by threads
        free(threads);

        GET_TIME(end_time);
        elapsed_time=end_time-start_time;

        printf("%f  %f  %i    %f    %f    %i\n", a, b, n, area, elapsed_time, num_threads);
    }

    return 0;
}