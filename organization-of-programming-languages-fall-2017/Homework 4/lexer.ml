open Printf;;
open Stream;;
open Sys;;

type atom = T | NIL | Int of int | Ident of string;;

type sign = Plus | Minus;;

type token = Lparen | Rparen | Atom of atom | Sign of sign | Dot;;

let rec spaces s = match s with parser [< ' ' | '\t' | '\n' | _ >] 
								       -> spaces s | [< >] 
                                       -> ();;

let rec lexid str s = match s with parser [< ''a'..'z' | 'A'..'Z' | '0'..'9' as c; _ >] 
								          -> lexid (str ^ (Char.escaped c)) s | [< >] 
								          -> str;;

let rec lexint n = match n with parser [< ''0'..'9' as c; (lexint(Char.int_of_char c)) r >] 
                                       -> r | [< >]
                                       -> n;;

let rec lexer l = match l with parser [< ''('; spaces _ >] -> [< 'Lparen; lexer l >] |
                                      [< '')'; spaces _ >] -> [< 'Rparen; lexer l >] |
                                      [< ''T'; spaces _ >] -> [< 'Atom(T); lexer l >] |
                                      [< '' '; spaces _ >] -> [< 'Atom(NIL); lexer l >] |
							          [< ''0'..'9' as c; lexint c; spaces _ >] -> [< 'Atom(Int); lexer l >] |
							          [< ''a'..'z' | 'A'..'Z' as c; lexid c; spaces _ >] -> [< 'Atom(Ident); lexer l >] |
							          [< ''+'; spaces _ >] -> [< 'Sign(Plus); lexer l >] |
							          [< ''-'; spaces _ >] -> [< 'Sign(Minus); lexer l >] |
							          [< ''.'; spaces _ >] -> [< 'Dot; lexer l >];;
															 
let filename = Sys.argv.(1);;
															
let in_channel = open_in filename;;

print_tokens(lexer (Stream.of_channel stdin));;
