#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <pthread.h>
#include <ctype.h>
#include <time.h>

const int SIZE=1024;

const char *smname="Throws";

int shm_fd;

void *ptr;

pthread_mutex_t lock;

void *write(void *arg){

	pthread_mutex_lock(&lock);

	srand(time(NULL));

	int throw1=rand()%3;
	int throw2=rand()%3;

	int throws[2]={throw1, throw2};

	/*Write to object*/
	shm_fd=shm_open(smname, O_CREAT | O_RDWR, 0666);

	ftruncate(shm_fd, SIZE);

	ptr=mmap(0, SIZE, PROT_WRITE, MAP_SHARED, shm_fd, 0);

	sprintf(ptr,"%u",throws);

	pthread_mutex_unlock(&lock);

	return NULL;
}

int main(int argc, char *argv[]){

	if(argc<2){printf("Too few arguments. \n");}
	else if(argc>2){printf("Too many arguments. \n");}
	else{

		if(isalpha(argv[1][0])){printf("Second argument must be an integer.");}
		else if(atoi(argv[1])<1){printf("Second argument too small.");}
		else{

			pthread_t child1;
			pthread_t child2;

			printf("Child 1 TID: %u \n", child1);
			printf("Child 2 TID: %u \n", child2);
			printf("Number of rounds: %u \n", atoi(argv[1]));
			printf("Begin \n");
			printf("................... \n\n");

			for(int i=0;i<atoi(argv[1]);i++){

				/*Create threads*/
				pthread_create(&child1, NULL, &write, NULL);
				pthread_create(&child2, NULL, &write, NULL);

				/*Process threads*/
				shm_fd=shm_open(smname, O_RDONLY, 0666);

				ptr=mmap(0, SIZE, PROT_READ, MAP_SHARED, shm_fd, 0);

				printf("Child 1 throws: %u \n",ptr);
				printf("Child 2 throws: %u \n\n",ptr);

				shm_unlink(smname);

				/*Join threads & destroy mutex*/
				pthread_join(child1, NULL);
				pthread_join(child2, NULL);
				pthread_mutex_destroy(&lock);

			}

		}

	}

	return 0;
}
