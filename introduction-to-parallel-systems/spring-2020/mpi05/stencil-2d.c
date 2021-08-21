/*
     Joshua Catoe
     CSCI 473
     MPI05
     stencil-2d.c - Performs a stencil operation on data from a file and outputs the result into a new file
*/

#include <stdio.h>
#include <stdlib.h>
#include "utilities.h"

int main(int argc, char* argv[]) {

     // Convert iteration argument to integer
     int iterations=atoi(argv[1]);

     // Open input file stream
     // File name stored in argv[2]
     FILE* in_file=fopen(argv[2], "r");  // Pointer to file to be read from

     // Exit program if other than three arguments entered or input file does not exist
     if(argc!=4) {printf("Usage: ./stencil-2d [ITERATIONS] [FILE] [FILE]\n");}
     else if(argc==4 && iterations==0) {

          printf("Usage: ./stencil-2d [ITERATIONS] [FILE] [FILE]\n"
                 "ITERATIONS must be an integer value greater than zero.\n");
     }
     else if(argc==4 && in_file==NULL) {printf("File \"%s\" not found.\n", argv[2]);}
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
          
          // Print pre-stencil array
          print2D(not_processed, dimensions[0], dimensions[1]); 

          // Do stencil operation 
          double** temp;  // Temporary variable for array pointer swapping
          int i;
          // Iterations is increased by one so that the last iteration of the loop will only swap pointers
          for(i=0; i<iterations+1; i++) {

               if(i!=iterations) {

                    stencil2D(not_processed, processed, dimensions[0], dimensions[1]);
     
                    // Print processed array for each stencil iteration
                    printf("\n");
                    print2D(processed, dimensions[0], dimensions[1]);

                    // Swap array pointers to avoid copying data
                    temp=not_processed;
                    not_processed=processed;
                    processed=temp;
               }
               else {

                    // Swap one last time to ensure correct output data      
                    temp=not_processed;
                    not_processed=processed;
                    processed=temp;   
               }     
          }
          
          // Open output file stream
          // File name stored in argv[3]
          // File created if not found
          FILE* out_file=fopen(argv[3], "w+");  // Pointer to file to be written to

          // Write dimensions and processed data from processed array out to file
          fwrite(dimensions, sizeof(int), 2, out_file);
          fwrite(*processed, sizeof(double), (dimensions[0]*dimensions[1]), out_file);

          // Close output file stream
          fclose(out_file);
     }

     return 0;
}