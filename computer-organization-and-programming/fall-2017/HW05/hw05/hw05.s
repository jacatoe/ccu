.text
.equ	LEDs,     0xFF200000
.equ	SWITCHES, 0xFF200040
.global _start

_start:

    movia	r2, LEDs        # Address of LEDs         
    movia	r3, SWITCHES    # Address of switches
    
    LOOP:                   # Set inside loop to change switch states on the fly
	
        ldwio	r5, (r3)	# Read the state of switches (number entered)
        movui   r6, 960     # Mask set to 1111|00|0000
        and     r7, r5,r6   # AND the input and mask to retrieve X 
        srli    r8, r7,6    # Shift to minimize size of X
        
        ldwio   r10, (r3)    # Read the state of switches (repeated only for visualization in registers)
        movui   r11, 15      # Mask set to 0000|00|1111
        and     r12, r10,r11 # AND the input and mask to retrieve Y
        srli    r13, r12,0   # Shift to minimize size of Y
        
        movi    r15,0        # Initialize I to 0
        movi    r16,0        # Initialize J to 0
        
        stwio	r5, (r2)		# Display I & J on LEDs

        br LOOP
    
.end
