/* Joshua Catoe
   CSCI 473
   HW 03
*/

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main(int argc, char* argv[]) {

	MPI_Init(NULL, NULL);

	int num_p;         // Number of processes
	int my_rank;       // Rank of process

	MPI_Comm_size(MPI_COMM_WORLD, &num_p);  // Get number of processes

	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);  // Get rank of process

	srand(my_rank);    // Seed rand() using my_rank
	int myNum=rand();  // Process's own random number

	// Determine right and left neighbor ranks

	int R_rank;  // Process's right neighbor
	int L_rank;  //            left neighbor

	if(my_rank==0) {

		R_rank=my_rank+1;
		L_rank=num_p-1;
	}
	else if(my_rank==num_p-1) {

		R_rank=0;
		L_rank=my_rank-1;
	}
	else {
	
		R_rank=my_rank+1;
		L_rank=my_rank-1;	 	
	}

	// Even ranks send, odd receive and vice versa until all messages passed

	MPI_Status status; // Status object for receives

	if(my_rank%2==0) {

		MPI_Send(&myNum,1,MPI_INT,R_rank,19,MPI_COMM_WORLD);
		MPI_Recv(&myNum,1,MPI_INT,R_rank,19,MPI_COMM_WORLD,&status);
		MPI_Send(&myNum,1,MPI_INT,L_rank,19,MPI_COMM_WORLD);
		MPI_Recv(&myNum,1,MPI_INT,L_rank,19,MPI_COMM_WORLD,&status);
	}
	else {

		MPI_Recv(&myNum,1,MPI_INT,L_rank,19,MPI_COMM_WORLD,&status);
		MPI_Send(&myNum,1,MPI_INT,L_rank,19,MPI_COMM_WORLD);
		MPI_Recv(&myNum,1,MPI_INT,R_rank,19,MPI_COMM_WORLD,&status);
		MPI_Send(&myNum,1,MPI_INT,R_rank,19,MPI_COMM_WORLD);
	}
	
	printf("Process [ %i] has myNum = %i, R_rank = %i, L_rank = %i\n", my_rank, myNum, R_rank, L_rank);

	printf("Process [ %i]: recv'd %i from R_rank = %i, recv'd %i from L_rank = %i\n",my_rank,myNum,R_rank,myNum,L_rank);

	MPI_Finalize();

	return 0;
}
