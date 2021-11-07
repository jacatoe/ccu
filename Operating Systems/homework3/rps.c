#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<stdlib.h>
#include<time.h>

int main(int argc, char *argv[]){

	srand(time(NULL));

	int throwa=rand()%3;
	int throwb=rand()%3;

	int i=0;
	int n=atoi(&argv[1]);

	int fd[2];
	int fd2[2];

	pid_t pida;
	pid_t pidb;

	if(pipe(fd)==-1||pipe(fd2)==-1){

		printf("Error");
	}

	pida=fork();

	if(pida==0){

		close(fd[0]);
		write(fd[1], throwa, throwa+1);
		close(fd[1]);
	}

	else if(pida>0){

		pidb=fork();

		if(pidb==0){

			close(fd2[0]);
			write(fd2[1], throwb, throwb+1);
			close(fd2[1]);
		}

		else if(pidb>0){

			printf("Child 1 PID: %d \n", pida);
			printf("Child 2 PID: %d \n\n", pidb);
			printf("Round to be played: %d \n", n);
			printf("................... \n\n");

			while(i<n){

				wait();

				close(fd[1]);
				read(fd[0], throwa, throwa+1);
				close(fd[0]);

				close(fd2[1]);
				read(fd2[0], throwb, throwb+1);
				close(fd2[0]);

				printf("Round _: \n");

				if(throwa==0){printf("Child 1 throws Rock \n");}
				else if (throwa==1){printf("Child 1 throws Paper \n");}
				else if (throwa==2){printf("Child 1 throws Scissors \n");}

				if(throwb==0){printf("Child 2 throws Rock \n\n");}
				else if (throwb==1){printf("Child 2 throws Paper \n\n");}
				else if (throwb==2){printf("Child 2 throws Scissors \n\n");}

				if(throwa==0 && throwb==2){printf("Winner: Child 1 \n\n");}
				else if(throwa==1 && throwb==0){printf("Winner: Child 1 \n\n");}
				else if(throwa==2 && throwb==1){printf("Winner: Child 1 \n\n");}
				else if(throwb==0 && throwa==2){printf("Winner: Child 2 \n\n");}
				else if(throwb==1 && throwa==0){printf("Winner: Child 2 \n\n");}
				else if(throwb==2 && throwa==1){printf("Winner: Child 2 \n\n");}
				else {printf("Tie \n\n");}

				i++;
			}
		}

		else{

			printf("Error");

			return 1;
		}
	}

	else{

		printf("Error");

		return 1;
	}

	return 0;
}
