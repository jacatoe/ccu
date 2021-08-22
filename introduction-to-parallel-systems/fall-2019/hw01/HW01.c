/* Joshua Catoe
   09/01/19
   CSCI 473
   HW 01
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {	

	if(argc!=3) {printf("Error: Expected two arguments of type int.\n");}
	else {
	
		int n=atoi(argv[1]);
		int p=atoi(argv[2]);
		int r=n%p;

		printf("Number of elements: %i\n",n);
		printf("Number of processes: %i\n",p);
		printf("Number of extra elements: %i\n",r);
	}

	return 0;	
}
