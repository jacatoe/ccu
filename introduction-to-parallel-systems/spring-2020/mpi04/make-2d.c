/*
     Joshua Catoe
     CSCI 473
     MPI04
     make-2d.c - Writes 2D array of user-specified size to a file.
*/

#include <stdio.h>
#include <stdlib.h>
#include "utilities.h"

int main(int argc, char* argv[]) {

     // Convert arguments to integers now for fewer atoi() calls
     // dimensions[0]==rows
     // dimensions[1]==columns
     int dimensions[2]={atoi(argv[1]), atoi(argv[2])};  // Dimensions of array

     // Exit program if other than four arguments entered or dimensions not given as integers
     if(argc!=4 || dimensions[0]==0 || dimensions[1]==0) {

          printf("Usage: ./make-2d [ROWS] [COLUMNS] [FILE]\n"
                 "ROWS and COLUMNS must be integer values.\n"
                 "FILE is created if it is not found.\n");
     }
     else {

          // Open file stream
          // File name stored in argv[3]
          // File created if not found
          FILE* file=fopen(argv[3], "w+");  // Pointer to file to be written to

          // Allocate space for and fill array
          double** array2d;  // Storage for array
          malloc2D(&array2d, dimensions[0], dimensions[1]);
          fill2D(array2d, dimensions[0], dimensions[1]);

          // Write dimensions and array to file
          fwrite(dimensions, sizeof(int), 2, file);
          fwrite(*array2d, sizeof(double), (dimensions[0]*dimensions[1]), file);

          // Close file stream
          fclose(file);
     }

     return 0;
}