#include <stdlib.h>
#include <stdio.h>
#include "utilities.h"

int main(int argc, char *argv[])
{
    int i, j;
   

    double **x;
 
    for(i=0; i<argc; i++) {
        printf("%s, ", argv[i]);
    } printf("\n");
    
    if(argc !=3) {
        printf("usage: ./driver <rows> <cols> \n");
        exit(1);
    }
    
    int imax= atoi(argv[2]);
    int jmax= atoi(argv[1]);
    
    
    malloc2D(&x, jmax,imax);

    fill2D(x, jmax, imax, 'n');
    print2D(x, jmax, imax);
    

   // 1D access of the contiguous 2D array
   double *x1d=x[0];
   for (i = 0; i< imax*jmax; i++){
      x1d[i] = (double)i;
   }

   // 2D access of the contiguous 2D array
   for (j = 0; j< jmax; j++){
      for (i = 0; i< imax; i++){
         x[j][i] = 0.0;
      }
   }

}