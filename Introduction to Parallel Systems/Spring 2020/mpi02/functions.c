/* 
	Joshua Catoe
	CSCI 473
	MPI02
	functions.c - Definition of the global_sum() function found in functions.h.
*/

#include <stdio.h>
#include <math.h>
#include <mpi.h>
#include "functions.h"

/* 
	global_sum - Processes swap values with partner, add them and retain the sum

	Parameters: result   - Final sum of all values
			  rank     - Rank of process
			  size     - Number of processes
			  my_value - Process's own value

	Returns: N/A
*/
void global_sum(double* result, int rank, int size, double my_value) {

	int phases=log2(size);  // Number of phases (or tree levels) to step through
	int bitmask=001;        // Bitmask used to determine partner; set to 001 for Phase 0
	int partner;            // Process to communicate with 
	double p_value;         // Value received from partner

	// In each phase, send/receive value to/from different partner
	int i;
	for(i=0; i<phases; i++) {

		partner=rank^bitmask;  // Partner determined by XOR with bitmask

		printf("Phase %i - P %i sendrecv with P %i, val %.16f\n", i, rank, partner, my_value);

		// Send own value to partner and receive partner's value
		MPI_Sendrecv(&my_value, 1, MPI_DOUBLE, partner, 19, &p_value, 1, MPI_DOUBLE, partner, 19, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		
		my_value+=p_value;  // Add partner's value to own value

		bitmask=bitmask<<1;  // Shift bitmask left to determine new partner in next phase
	}

	*result=my_value;  // Store final sum
}