# Joshua Catoe
# CSCI 473
# MPI06

CC=gcc
MPICC=mpicc
CFLAGS=-g -Wall -Wstrict-prototypes -std=gnu99
LFLAGS=-lm

all: mc-integration-serial mc-integration-parallel

mc-integration-serial: mc-integration-serial.o utilities.o
	$(CC) $(LFLAGS) -o mc-integration-serial mc-integration-serial.o utilities.o

mc-integration-parallel: mc-integration-parallel.o utilities.o
	$(MPICC) $(LFLAGS) -o mc-integration-parallel mc-integration-parallel.o utilities.o

mc-integration-serial.o: mc-integration-serial.c utilities.h
	$(CC) $(CFLAGS) -c mc-integration-serial.c

mc-integration-parallel.o: mc-integration-parallel.c utilities.h
	$(MPICC) $(CFLAGS) -c mc-integration-parallel.c

utilities.o: utilities.c utilities.h
	$(CC) $(CFLAGS) -c utilities.c

clean:
	rm -f *.o core* mc-integration-serial mc-integration-parallel