/* Joshua Catoe
   CSCI 473
   HW 05
*/

#include <stdio.h> 
#include <stdlib.h>
#include <string.h>
#include "functions.h"

int main(int argc, char* argv[]) {

	if(argc==5 && strcmp(argv[1],"-n")==0 && atoi(argv[2])>0 && strcmp(argv[3],"-o")==0) {

		int* list;  //  List of integers in file

		make_list(atoi(argv[2]), &list);

		print_list(atoi(argv[2]), list);  //  Debugging
	}
	else {printf("Usage: make-list [-n] [INT>0] [-o] [FILE]\n");}

	return 0;
}
