#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (int argc, char *argv[]) {
    
    if (strcmp("PSJF", argv[1])==0 || strcmp("psjf", argv[1])==0) {
     
        printf("Preemptive Shortest Job First");
        
        /*Implement PSJF*/
        
    }
    
    else if (strcmp("RR", argv[1])==0 || strcmp("rr", argv[1])==0) {
     
        printf("Round Robin \n");
        
        int q = atoi(argv[2]);
        
        if (q>=0) {
         
            printf("Quantam =  %d \n", q);
            
            /*Implement RR*/
            
        }
        
        else { printf("ERROR: Quantam must be a nonnegative integer. \n"); }
        
    }
    
    else if (strcmp("FCFS", argv[1])==0 || strcmp("fcfs", argv[1])==0) {
     
        printf("First Come First Serve");
        
        /*Implement FCFS*/
        
    }
    
    else { printf("ERROR: Invalid algorithm name. \n"); }
 
    return 0;
}
