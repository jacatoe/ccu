#include <stdlib.h>
#include <stdio.h>
#include "utilities.h"

void malloc2D(double*** a , int jmax, int imax)
{
   // first allocate a block of memory for the row pointers and the 2D array
   double **x = (double **)malloc(jmax*sizeof(double *) + jmax*imax*sizeof(double));

   // Now assign the start of the block of memory for the 2D array after the row pointers
   x[0] = (double *)x + jmax;

   // Last, assign the memory location to point to for each row pointer
   for (int j = 1; j < jmax; j++) {
      x[j] = x[j-1] + imax;
   }

    *a = x;
}

void fill2D(double** a, int jmax, int imax) {
    
    int count = 0.0;
    for(int j=0; j<jmax; j++) {
        for(int i=0; i<imax; i++) {
            a[j][i] = count;
            count++;
        }
    }
}

void print2D(double** a, int jmax, int imax) {
    
     printf("Array is a %i x %i matrix\n", jmax, imax);

     int i;
     int j;
    
     printf("    |        ");
     for(i=0; i<imax; i++) {

          printf("%i        ", i);     
     }  
     printf("\n    |");

     for(i=0; i<imax; i++) {

          printf("---------");     
     }  
     printf("\n");

     for(j=0; j<jmax; j++) {

          printf("  %i |\t", j);
          for(i=0; i<imax; i++) {
 
               printf("%6.2lf   ", a[j][i]);
          } 
          printf("\n");
     }
}