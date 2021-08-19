CC=gcc
CFLAGS=-g -Wall -Wstrict-prototypes -std=gnu99
LFLAGS=-lm

all:	driver print-2d

driver: utilities.o driver.o
	$(CC) $(LFLAGS) -o driver utilities.o driver.o

print-2d: print-2d.o utilities.o
	$(CC) $(LFLAGS) -o print-2d print-2d.o utilities.o

utilities.o: utilities.c utilities.h
	$(CC) $(CFLAGS) -c utilities.c

driver.o: driver.c utilities.h
	$(CC) $(CFLAGS) -c driver.c

print-2d.o: print-2d.c utilities.h 
	$(CC) $(CFLAGS) -c print-2d.c

clean:
	rm -f *.o core* driver print-2d