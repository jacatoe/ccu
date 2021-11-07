/* Joshua Catoe
   CSCI 473
   HW 04
*/

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include "functions.h"

int main(int argc, char* argv[]) {
		
	MPI_Init(NULL, NULL);	

	int size;             // Size of communicator
	int my_rank;          // Rank of process
	int my_value;         // Process's value
	double sum;           // Global sum

	MPI_Comm_size(MPI_COMM_WORLD, &size);   // Get size of communicator

	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank); // Get rank of process

	// Check to see if number of processes is power of 2
	if((size&(size-1))!=0) {printf("Usage: number of processes should be a power of 2 (2,4,8,16,etc.).\n");}
	else {
	
		my_value=my_rank;		

		global_sum(&sum, my_rank, size, my_value);  //Compute global sum

		printf("FINAL IN MAIN: Process: %i has Sum = %f \n", my_rank, sum);
	}

	MPI_Finalize();

	return 0;
}
