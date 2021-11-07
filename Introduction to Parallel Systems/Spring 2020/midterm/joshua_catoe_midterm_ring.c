/*
    Joshua Catoe
    CSCI 473
    Midterm Exam
    joshua_catoe_midterm_ring.c - Processes generate a random value and share it with their "neighbors" in a circular fashion
*/

#include <stdio.h>
#include <mpi.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char* argv[]) {

    MPI_Init(&argc, &argv);

    int size;            // Number of processes
    int my_rank;         // Process rank
    int myNum;           // Process's randomly generated number
    int left_neighbor;   // Process's left neighbor
    int right_neighbor;  // Process's right neighbor
    int leftNum;         // Number received from left neighbor
    int rightNum;        // Number received from right neighbor

    // Get number of processes and process rank
    MPI_Comm_size(MPI_COMM_WORLD, &size);  
    MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

    // Generate random number
    // Modulo is used to set random number range to 0-100
    srandom(time(0)+my_rank);
    myNum=random()%100;

    // Determine neighbors
    // Process zero's left neighbor is last process and last process's right neighbor is zero
    if(my_rank==0) {

        left_neighbor=size-1;
        right_neighbor=my_rank+1;
    }
    else if(my_rank==size-1) {

        left_neighbor=my_rank-1;
        right_neighbor=0;
    }
    else {

        left_neighbor=my_rank-1;
        right_neighbor=my_rank+1;
    }

    // If/else statement only for better looking output
    if(myNum<10) {printf("Process [ %i] has myNum =  %i, R_rank = %i, L_rank = %i\n", my_rank, myNum, right_neighbor, left_neighbor);}
    else {printf("Process [ %i] has myNum = %i, R_rank = %i, L_rank = %i\n", my_rank, myNum, right_neighbor, left_neighbor);}

    // Send/receive randomly generated number to/from neighbors
    MPI_Sendrecv(&myNum, 1, MPI_INT, left_neighbor, 19, &rightNum, 1, MPI_INT, right_neighbor, 19, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
    MPI_Sendrecv(&myNum, 1, MPI_INT, right_neighbor, 20, &leftNum, 1, MPI_INT, left_neighbor, 20, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
    
    // If/else statements only for better looking output
    if(rightNum<10 && leftNum>=10) {printf("Process [ %i]: recv'd  %i from R_rank = %i, recv'd %i from L_rank = %i\n", my_rank, rightNum, right_neighbor, leftNum, left_neighbor);}
    else if(leftNum<10 && rightNum>=10) {printf("Process [ %i]: recv'd %i from R_rank = %i, recv'd  %i from L_rank = %i\n", my_rank, rightNum, right_neighbor, leftNum, left_neighbor);}
    else {printf("Process [ %i]: recv'd %i from R_rank = %i, recv'd %i from L_rank = %i\n", my_rank, rightNum, right_neighbor, leftNum, left_neighbor);}

    MPI_Finalize();

    return 0;
}  