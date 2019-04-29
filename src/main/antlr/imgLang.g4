
grammar imgLang;

script
    : assignment+
    ;

assignment
    : id EQUAL expression
    ;

expression
    : term                      #SingleTerm
    | expression PLUS term      #Plus
    | expression MINUS term     #Minus
    ;

term
    : image                 #ImageTerm
    | term MULT image       #Mult
    | term DIV image        #Div
    ;

image
    : id                    #Var
    | path                  #Literal
    ;

id
    : ID
    ;

path
    : PATH_LITERAL
    ;

ID
    : VALID_ID_START VALID_ID_CHAR*
    ;

fragment VALID_ID_START
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    ;

fragment VALID_ID_CHAR
    : VALID_ID_START
    | ID_STRING
    ;

ID_STRING
    : [a-zA-Z~0-9] [a-zA-Z0-9-]*
    ;

PATH_LITERAL
    : VALID_PATH_START VALID_PATH_CHAR* IMAGE_EXTENSION
    ;

fragment VALID_PATH_START
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    | '.'
    | '/'
    ;

fragment VALID_PATH_CHAR
    : VALID_PATH_START
    | PATH_STRING
    ;

fragment IMAGE_EXTENSION
    : '.png'
    | '.PNG'
    | '.bmp'
    | '.BMP'
    | '.jpeg'
    | '.JPEG'
    ;

PATH_STRING
    : [a-zA-Z~0-9] [a-zA-Z0-9.-]*
    ;

EQUAL
    : '='
    ;

MULT
    : '*'
    ;

DIV
    : '/'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

WS
   : [ \r\n\t] + -> skip
   ;