/*
     Joshua Catoe (Functions malloc2D, fill2D, print2D originally by Dr. William Jones.)
     CSCI 473
     MPI06
     utilities.c - Definitions of functions found in utilities.h
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "utilities.h"

/*
     malloc2D - Allocates memory for a two-dimensional array

     Parameters: array   - Pointer to array
                 rows    - Number of rows in array
                 columns - Number of columns in array

     Returns: N/A
*/
void malloc2D(double*** array, int rows, int columns) {

     // First, allocate a block of memory for the row pointers and the 2D array
     double** x=(double**)malloc((rows*sizeof(double*))+(rows*columns*sizeof(double)));

     // Now, assign the start of the block of memory for the 2D array after the row pointers
     x[0]=(double*)x+rows;

     // Last, assign the memory location to point to for each row pointer   
     int j;
     for(j=1; j<rows; j++) {

          x[j]=x[j-1]+columns;
     }

     *array = x;
}





/*
     fill2D - Fills a two-dimensional array with integers

     Parameters: array   - Array to be filled
                 rows    - Number of rows in array
                 columns - Number of columns in array
                 mode    - Fill mode to be used 
                           - 'n': Normal - Fill with integers starting from zero 
                           - 'h': Heat   - Fill with ones and zeros to simulate a non-heated metal plate

     Returns: N/A
*/
void fill2D(double** array, int rows, int columns, char mode) {
    
     int j;         // Counter for rows loop
     int i;         // Counter for columns loop

     if(mode=='n') {

          int element=0; // Number to insert into array

          for(j=0; j<rows; j++) {

               for(i=0; i<columns; i++) {
               
                    array[j][i]=element;
                    element++;
               }
          }
     }

     if(mode=='h') {

          for(j=0; j<rows; j++) {

               for(i=0; i<columns; i++) {
               
                    // Leftmost and rightmost columns filled with ones
                    if(i==0 || i==columns-1) {array[j][i]=1;}

                    // All other cells filled with zeros
                    else {array[j][i]=0;}
               }
          }
     }   
}





/*
     print2D - Prints a two-dimensional array to the screen

     Parameters: array   - Array to be printed
                 rows    - Number of rows in array
                 columns - Number of columns in array

     Returns: N/A
*/
void print2D(double** array, int rows, int columns) {
    
     printf("Array is a %i x %i matrix\n", rows, columns);

     int j;  // Counter for rows loop
     int i;  // Counter for columns loop
    
     printf("    |        ");
     for(i=0; i<columns; i++) {

          printf("%i        ", i);     
     }  
     printf("\n    |");

     for(i=0; i<columns; i++) {

          printf("---------");     
     }  
     printf("\n");

     for(j=0; j<rows; j++) {

          printf("  %i |\t", j);
          for(i=0; i<columns; i++) {
 
               printf("%6.2lf   ", array[j][i]);
          } 
          printf("\n");
     }
}





/*
     stencil2D - Performs a five-point stencil operation on an input array and stores result in an output array

     Parameters: input_array  - Array containing unprocessed source data
                 output_array - Array to store processed data
                 rows         - Number of rows in arrays
                 columns      - Number of columns in arrays

     Returns: N/A
*/
void stencil2D(double** input_array, double** output_array, int rows, int columns) {

     // Process input data and store in output array
     // Stencil operation equation: x[j][i]=(x[j][i-1]+x[j-1][i]+x[j][i]+x[j][i+1]+x[j+1][i])/5.0
     int j;  // Counter for rows loop
     int i;  // Counter for columns loop
     for(j=0; j<rows; j++) {

          for(i=0; i<columns; i++) {

               // Initialize boundary cells
               if(j==0 || j==rows-1 || i==0 || i==columns-1) {output_array[j][i]=input_array[j][i];}

               // Calculate inner cells
               else {output_array[j][i]=((input_array[j][i-1]+input_array[j-1][i]+input_array[j][i]+input_array[j][i+1]+input_array[j+1][i])/5.0);}
          }
     }  
}





/*
    monte - Performs Monte Carlo integration on a given function

    Parameters: a    - Left integration bound
                b    - Right integration bound
                n    - Number of points
                f    - Pointer to function to be integrated
                area - Pointer to storage for final area value

    Return Value: Writes final area value to location pointed to by area
*/
void monte(int a, int b, int n, double (*f)(double), double* area) {

    int total=(b-a)*(f(b));  // Total area of plane

    // Find number of points that fall below the function curve
    srand48(time(0));  // Seed drand48() with current time
    int under=0;  // Number of points below curve
    int i;
    for(i=0; i<n; i++) {

        double x_i=drand48();  // X-coordinate for point
        double y_i=drand48();  // Y-coordinate for point

        // Take count of all points below curve
        if(y_i<=f(x_i)) {under++;}
    }
        
    // Area of interest is calculated by multiplying the number of points under the curve by the total area and then dividing by the total number of points
    *area=((double)under*(double)total)/(double)n;
}