/*
    HWA: Computes the Hamming distance between two integers (specified by Switches), and prints the result out to the LEDs.

    Joshua Catoe
    11/18/18
    CSCI 210 FA18
*/

.equ SWITCH, 0x10000040  # Address of Switches
.equ LED, 0x10000010     # Address of LEDs

.global _start
_start:

    # r2 - Address of Switches
    # r3 - Address of LEDs
    # r4 - Switch input
    # r5 - First input number, "X"
    # r6 - Second input number, "Y"
    # r7 - XOR of "X" and "Y" (human-readable Hamming distance)
    # r8 - Storage for 1s found in r7
    # r9 - Hamming distance
    
    # Store addresses of Switches and LEDs for use

    movia r2, SWITCH
    movia r3, LED

    # Get input from Switches

    ldwio r4, 0(r2) 
    
    # Separate variables
    
    andi r5, r4, 0x1F  # Mask input with 0000011111 to obtain "Y"
     
    srli r6, r4, 0x5   # Shift input to obtain "X" from lower bits
    
    # Compute Hamming distance
    
    xor r7, r5, r6  # XOR for initial/human-readable Hamming distance
    
    mov r9, r0      # "Initialize" r9 to 0 to avoid re-compiling program or reloading CPUlator
    
    ONES:
	andi r8, r7, 0x1  # Mask r7 with 0000000001 to retrieve any 1s from least significant bit position
        add r9, r8, r9    # Sum of 1s from r7 is Hamming distance
    	srli r7, r7, 0x1  # Shift to test next bit position in r7
    	bne r7, r0, ONES  # Loop until all bit positions have been checked (i.e. r7==0)

    # Print result to LEDs
    
    stwio r9, 0(r3)
    
    END: br END    