CFLAGS=-g -Wall -Wstrict-prototypes
PROGS=driver
OBJECTS=cpi.o functions.o
LDFLAGS=-lm
CC=gcc
MCC=mpicc

all: $(PROGS)

driver: $(OBJECTS)
	$(MCC) $(LDFLAGS) -o driver $(OBJECTS)

cpi.o: cpi.c
	$(MCC) $(CFLAGS) -c cpi.c

functions.o: functions.c functions.h
	$(MCC) $(CFLAGS) -c functions.c

clean:
	rm -f $(PROGS) *.o core*