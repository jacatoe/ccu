/* 
	Joshua Catoe
	CSCI 473
	MPI02
	cpi.c - Computes value of pi using a tree-based global sum.
*/

#include <stdio.h>
#include <mpi.h>
#include "functions.h"

/* 
	function - Function used to integrate pi
 
	Parameters: x - Width of each rectangle

	Returns: function evaluated with rectangle width
*/
double function(double x) {

	return 4/(1+(x*x));
}

int main() {

	MPI_Init(NULL, NULL);  // Open MPI environment

	int size;      // Number of processes
	int my_rank;   // Rank of process

	MPI_Comm_size(MPI_COMM_WORLD, &size);  // Get number of processes

	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);  // Get rank of process

	// Check to see if number of processes is power of 2
	if((size&(size-1))!=0) {printf("Usage: mpirun -np [INT] ./driver \nINT must be a power of 2. \n");}
	else {

		// Each process calculates paratial integration of pi
		int n=1000000000;            // Number of rectangles
		double delta_x=1/(double)n;  // Width of each rectangle
		double my_pi=0;              // Process's own partial integration of pi
		int i;
		for(i=my_rank+1; i<=n; i+=size) {

			my_pi+=function(delta_x*((double)i-0.5));
		}
		my_pi=delta_x*my_pi;

		double pi;  // Final pi value
		global_sum(&pi, my_rank, size, my_pi);  // Compute final pi integration

		printf("FINAL IN MAIN: Process: %i has Sum = %.16f\n", my_rank, pi);
	}

	MPI_Finalize();  // Close MPI environment

	return 0;
}