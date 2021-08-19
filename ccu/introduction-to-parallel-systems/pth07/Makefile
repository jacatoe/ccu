#
#   Joshua Catoe
#   CSCI 473
#   PTH07
#

CC=gcc
MPICC=mpicc
CFLAGS=-g -Wall -Wstrict-prototypes -std=gnu99
LFLAGS=-lm
PLFLAGS=-lm -lpthread

all: mc-integration-serial mc-integration-parallel pth-mc-integration-parallel

mc-integration-serial: mc-integration-serial.o utilities.o
	$(CC) $(LFLAGS) -o mc-integration-serial mc-integration-serial.o utilities.o

mc-integration-parallel:
	$(MPICC) $(CFLAGS) $(LFLAGS) -o mc-integration-parallel mc-integration-parallel.c

pth-mc-integration-parallel:
	$(CC) $(CFLAGS) $(PLFLAGS) -o pth-mc-integration-parallel pth-mc-integration-parallel.c

mc-integration-serial.o: mc-integration-serial.c utilities.h
	$(CC) $(CFLAGS) -c mc-integration-serial.c

utilities.o: utilities.c utilities.h
	$(CC) $(CFLAGS) -c utilities.c

clean:
	rm -f *.o core* mc-integration-serial mc-integration-parallel pth-mc-integration-parallel