/* Joshua Catoe
   CSCI 473
   HW 04
*/

#include <stdio.h> 
#include <math.h>
#include <mpi.h>
#include "functions.h"

void global_sum(double* result, int rank, int size, double my_value) {

	int phases=log2(size);  // Number of phases to step through
	int bitmask=001; 	    // Bitmask used to determine partner; set to 001 for Phase 0
	int partner;            // Process that current process should communicate with
	double r_buf;           // Buffer for received message    
	
	// For every phase, XOR with bitmask, sendrecv with partner, add received message to my_value, shift bimask left
	int i;
	for(i=0; i<phases; i++) {
	
		partner=rank^bitmask;  // Partner determined by XOR with bitmask

		printf("Phase %i - P %i sendrecv with P %i, val %f\n", i, rank, partner, my_value);

		MPI_Sendrecv(&my_value, 1, MPI_DOUBLE, partner, 19, &r_buf, 1, MPI_DOUBLE, partner, 19, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

		my_value+=r_buf;  // Add value of message to own value

		bitmask=bitmask<<1;  // Shift bitmask left to determine new partner
	}

	*result=my_value;  // Store final sum to be printed in main
}
