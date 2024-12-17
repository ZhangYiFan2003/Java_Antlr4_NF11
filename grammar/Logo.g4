grammar Logo; 

@header {
  package logoparsing;
}

INT : '0' | [1-9][0-9]* ;
ID : [a-zA-Z][a-zA-Z0-9]* [^];
WS : [ \t\r\n]+ -> skip ;


programme : (procedure|fonction)* liste_instructions 
;

liste_instructions :
  (instruction)+   
;

procedure :
	'pour' ID (':'ID)*	liste_instructions 'fin';
	
rends :
	'rends' exp;	
	
fonction :
	'pour' ID (':'ID)*	liste_instructions? rends 'fin';
	
appel_fonc :
	ID exp* #appel
	;

instruction :
    'av' exp # av
  | 'td' exp # td
  | 'tg' exp # tg
  | 'lc' # lc
  | 'bc' # bc
  | 're' exp # re
  | 'fpos' exp exp # fpos
  | 'fcc' exp # fcc
  |	'repete' exp '['liste_instructions']'	#repete
  | 'donne' '"'ID exp #donne
  | 'si' condition '[' (liste_instructions | rends) ']' ('['liste_instructions']')? #si
  | 'tantque' condition '['liste_instructions']' #tantque
  | appel_fonc	#fonc
; 

exp :
	 
	  exp ('*'|'/') exp #mult
	| exp ('+'|'-') exp #sum
	| atom 				#arule
	| 'hasard' exp		#hasard
	| 'loop' #loop 
	| ':' ID #var
	| appel_fonc	#exp_appel
;

atom :
	  INT		#int
	| '('exp')'	#parent
;

condition :
    exp '<' exp # inf
  | exp '<=' exp # inf_egal
  | exp '>' exp # sup
  | exp '>=' exp # sup_egal
  | exp '=' exp # egal
  | exp '!=' exp # diff
;

