CC=gcc
CFLAGS=-g -Wall -Wstrict-prototypes -std=gnu99
LFLAGS=-lm

all:	driver print-2d make-2d stencil-2d

driver: driver.o utilities.o
	$(CC) $(LFLAGS) -o driver driver.o utilities.o

print-2d: print-2d.o utilities.o
	$(CC) $(LFLAGS) -o print-2d print-2d.o utilities.o

make-2d: make-2d.o utilities.o
	$(CC) $(LFLAGS) -o make-2d make-2d.o utilities.o

stencil-2d: stencil-2d.o utilities.o
	$(CC) $(LFLAGS) -o stencil-2d stencil-2d.o utilities.o

driver.o: driver.c utilities.h
	$(CC) $(CFLAGS) -c driver.c

print-2d.o: print-2d.c utilities.h 
	$(CC) $(CFLAGS) -c print-2d.c

make-2d.o: make-2d.c utilities.h
	$(CC) $(CFLAGS) -c make-2d.c

stencil-2d.o: stencil-2d.c utilities.h
	$(CC) $(CFLAGS) -c stencil-2d.c

utilities.o: utilities.c utilities.h
	$(CC) $(CFLAGS) -c utilities.c

clean:
	rm -f *.o core* driver print-2d make-2d stencil-2d