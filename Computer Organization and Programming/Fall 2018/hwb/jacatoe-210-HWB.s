/*
	HWB: Computes the Hamming distance between two integers (specified by Switches), and prints the result out to the LEDs.

	Joshua Catoe
    11/30/18
    CSCI 210 FA18
*/

.equ SWITCH, 0x10000040  # Address of Switches
.equ LED, 0x10000010     # Address of LEDs

.global _start
_start:
		movia r2, SWITCH  # Store address of switches for use
        movia r3, LED     # Store address of LEDs for use
        
        movia sp, STACK  # Point to top of stack
        
        addi sp, sp, 28  # Allocate space for "main's" stack frame
        
        addi r4, sp, -12  # Compute and store address of "x"
        addi r5, sp, -8   # Compute and store address of "y"
        
        # Store needed data in "main's" stack frame
        
        stwio r2, -16(sp)  # Address of switches
        stw   r4, -12(sp)  # Address of "x"
        stw   r5,  -8(sp)  # Address of "y"
        stw   ra,  -4(sp)  # Return address
        
        call GETXY
        
        call HAMMING
        
        ldw r4, -20(sp)  # Pop hDist off stack
        
        stwio r4, 0(r3)  # Print hDist to LEDs
        
        END: br END
        
        GETXY: 
        		## Prologue
                
                # Get and store passed parameters from stack
                
                ldw   r6, -16(sp)  # Address of switches
                ldwio r6,   0(r6)  # Get actual input from switches
                ldw   r7, -12(sp)  # Address of "x"
                ldw   r8,  -8(sp)  # Address of "y"
                
                ## Work
                
                srli r9, r6, 0x5   # Shift input to obtain "x"
                
                andi r10, r6, 0x1F  # Mask input to obtain "y"
                
                stw r9,  -28(sp)  # Push "x" to stack
                stw r10, -24(sp) # Push "y" to stack
                
                ## Epilogue
                               
                ret
                
		HAMMING:
        
        		## Prologue
                
                # Get and store passed parameters from stack
                
                ldw r6, -28(sp)  # "x"
                ldw r7, -24(sp)  # "y"
                
                ## Work
                
                # Compute Hamming distance
    
    			xor r8, r6, r7  # XOR for initial/human-readable Hamming distance
    
    			mov r10, r0      # "Initialize" r9 to 0 to avoid re-compiling program or reloading CPUlator
    
   		 		ONES:
						andi r9, r8, 0x1   # Mask r8 with 0000000001 to retrieve any 1s from least significant bit position
       					add r10, r9, r10   # Sum of 1s from r8 is Hamming distance
    					srli r8, r8, 0x1   # Shift to test next bit position in r7
                        bne  r8, r0, ONES  # Loop until all bit positions have been checked (i.e. r8==0)
                        
				stw r10, -20(sp) # Push hamming distance (hDist) to stack
    					
                ## Epilogue
                
                ret
        
        STACK: .skip 256  # Create stack space