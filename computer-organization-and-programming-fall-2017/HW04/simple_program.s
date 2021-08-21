.text
.equ	LEDs,  0xFF200000
.equ	SWITCHES, 0xFF200040
.global _start

_start:

movia	r2, A
movia	r3, B

	movi	r10, 0		/* initi r10 to 0, for my index variable i */
	movi	r11, 4		/* to end the for loop */
FOR:
	beq		r10, r11, ENDFOR	
	ldw		r5, 0(r2) 	// grab element from A
	addi	r6, r5, 2   /* add 2 to it */		
	stw		r6, 0(r3)	// put answer back into B in memory 

	addi	r2, r2, 4	/* move the pointer to the next element */
	addi	r3, r3, 4	/* do the same thing for b */
	addi	r10, r10, 1	/* i++ */
	br		FOR

ENDFOR:	

END:
	br END


A: .word 5, 10, 15, 20
B: .skip 16
.end
