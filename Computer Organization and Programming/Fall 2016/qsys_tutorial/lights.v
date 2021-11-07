// Implements a simple Nios II system for the DE-series board.
// Inputs:	SW7¡0 are parallel port inputs to the Nios II system
//        	CLOCK_50 is the system clock
//        	KEY0 is the active-low system reset
// Outputs: LEDR7¡0 are parallel port outputs from the Nios II system
module lights (CLOCK_50, SW, KEY, LEDR);
	input CLOCK_50;
	input [7:0] SW;
	input [0:0] KEY;
	output [7:0] LEDR;
// Instantiate the Nios II system module generated by the Qsys tool:
nios_system NiosII (
	.clk_clk(CLOCK_50),
	.reset_reset_n(KEY),
	.switches_export(SW),
	.leds_export(LEDR));
endmodule