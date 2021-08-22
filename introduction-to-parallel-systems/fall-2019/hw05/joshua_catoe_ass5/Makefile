CFLAGS = -g -Wall -Wstrict-prototypes
PROGS = make-list
OBJECTS = make-list.o functions.o
LDFLAGS = -lm
CC = gcc
MCC = mpicc

all: $(PROGS)

make-list: $(OBJECTS)
	$(MCC) $(LDFLAGS) -o make-list $(OBJECTS)

make-list.o: make-list.c
	$(MCC) $(CFLAGS) -c make-list.c

functions.o: functions.c functions.h
	$(MCC) $(CFLAGS) -c functions.c

clean:
	rm -f $(PROGS) *.o core*
