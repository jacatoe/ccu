/*
     Joshua Catoe
     CSCI 473
     MPI03
     print-2d.c - Prints the contents of a 2D array whose data is sourced from a text file
*/

#include <stdio.h>
#include "utilities.h"

int main(int argc, char* argv[]) {

     // Open file stream
     // File name stored in argv[1]
     FILE* file=fopen(argv[1], "r");  // Pointer to file to be read from
     
     // Exit program if other than two arguments entered or file does not exist
     if(argc!=2) {printf("Usage: ./print-2d [FILE]\n");}
     else if(argc==2 && file==NULL) {printf("File \"%s\" not found.\n", argv[1]);}
     else {

          // Read array dimensions from file
          // dimensions[0]=j
          // dimensions[1]=i
          int dimensions[2];  // Storage for dimensions
          fread(dimensions, sizeof(int), 2, file);

          // Allocate space for array
          double **a;  // Storage for array
          malloc2D(&a, dimensions[0], dimensions[1]);

          // Read data from file into array
          fread(*a, sizeof(double), (dimensions[0]*dimensions[1]), file);
          
          // Print array
          print2D(a, dimensions[0], dimensions[1]);

          // Close file stream
          fclose(file);  
     }

     return 0;
}