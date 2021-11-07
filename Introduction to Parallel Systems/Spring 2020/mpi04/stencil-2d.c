/*
     Joshua Catoe
     CSCI 473
     MPI04
     stencil-2d.c - Performs a stencil operation on data from a file and outputs the result into a new file.
*/

#include <stdio.h>
#include "utilities.h"

int main(int argc, char* argv[]) {

     // Open input file stream
     // File name stored in argv[1]
     FILE* in_file=fopen(argv[1], "r");  // Pointer to file to be read from

     // Exit program if other than three arguments entered or input file does not exist
     if(argc!=3) {printf("Usage: ./stencil-2d [FILE] [FILE]\n");}
     else if(argc==3 && in_file==NULL) {printf("File \"%s\" not found.\n", argv[1]);}
     else {

          // Read array dimensions from file
          // dimensions[0]==rows
          // dimensions[1]==columns
          int dimensions[2];  // Storage for dimensions
          fread(dimensions, sizeof(int), 2, in_file);

          // Allocate space for unprocessed array
          double** not_processed;  // Storage for unprocessed array
          malloc2D(&not_processed, dimensions[0], dimensions[1]);

          // Read unprocessed data from file into unprocessed array
          fread(*not_processed, sizeof(double), (dimensions[0]*dimensions[1]), in_file);

          // Close input file stream
          fclose(in_file);

          // Allocate space for processed array
          double** processed;  // Storage for processed array
          malloc2D(&processed, dimensions[0], dimensions[1]);

          // Process input data and store in processed array
          // Stencil operation equation: x[j][i]=(x[j][i-1]+x[j-1][i]+x[j][i]+x[j][i+1]+x[j+1][i])/5.0
          int j;  // Outer loop counter
          int i;  // Inner loop counter
          for(j=0; j<dimensions[0]; j++) {
               for(i=0; i<dimensions[1]; i++) {

                    // Initialize boundary cells
                    if(j==0 || j==dimensions[0]-1 || i==0 || i==dimensions[1]-1) {processed[j][i]=not_processed[j][i];}

                    // Calculate inner cells
                    else {processed[j][i]=((not_processed[j][i-1]+not_processed[j-1][i]+not_processed[j][i]+not_processed[j][i+1]+not_processed[j+1][i])/5.0);}
               }
          }  

          // Open output file stream
          // File name stored in argv[2]
          // File created if not found
          FILE* out_file=fopen(argv[2], "w+");  // Pointer to file to be written to

          // Write dimensions and processed data from processed array out to file
          fwrite(dimensions, sizeof(int), 2, out_file);
          fwrite(*processed, sizeof(double), (dimensions[0]*dimensions[1]), out_file);

          // Close output file stream
          fclose(out_file);
     }

     return 0;
}