/* Joshua Catoe
   CSCI 473
   HW 05
*/

#include <stdio.h> 
#include <string.h>
#include "functions.h"

int main(int argc, char* argv[]) {

	if(argc==3 && strcmp(argv[1],"-i")==0) {

		char* file=argv[2];  // Name of file that list will be read from
		int   elements;      // Number of elements in list
		int*  list;          // List of integers in file

		read_list(file, &elements, &list);  // Read list of integers in file

		print_list(elements, list);  // Print list of integers in file
	}
	else {

		printf("Usage: print-list [-i] [FILE]\n");
	}			

	return 0;
}
