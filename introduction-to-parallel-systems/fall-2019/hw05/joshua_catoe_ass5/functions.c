/* Joshua Catoe
   CSCI 473
   HW 05
*/

#include <stdio.h> 
#include <stdlib.h>
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

void print_list(int n, int* A) {

	int i;
	for(i=0; i<n; i++) {printf("%i\n", A[i]);}
}

void read_list(char* out, int *n, int** A) {

	FILE* file=fopen(out, "r");  // Open file in read mode

	// Determine if file exists

	if(file==NULL) {printf("File not found.\n");}
	else {

		// Determine number of elements in list (read first integer)

		fread(n, sizeof(int), 1, file);  // Read first integer in file (number of elements)

		// Read rest of list and put into array

		fseek(file, sizeof(int), SEEK_SET);  // Set file pointer to second element (beginning of list)

		*A=malloc(sizeof(int)*(*n));  // Array to store elements

		fread(*A, sizeof(int), *n, file);  // Store elements in array

		fclose(file);  // Close file
	}
}

void make_list(int n, int** A) {

	*A=malloc(sizeof(int)*n);  //  Array of n integers

	int i;
	for(i=0; i<n; i++) {*A[i]=i;}  //  Fill array with integers
}
