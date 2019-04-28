
grammar imgLang;

assignment
    : id EQUAL expression
    ;

expression
    : term                      #SingleTerm
    | expression PLUS term      #Plus
    | expression MINUS term     #Minus
    ;

term
    : id                    #Idenifier
    | term MULT id          #Mult
    | term DIV id           #Div
    ;

id
    : ID
    ;

ID
    : VALID_ID_START VALID_ID_CHAR* IMAGE_EXTENSION
    ;

fragment VALID_ID_START
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    | '.'
    | '/'
    ;

fragment VALID_ID_CHAR
    : VALID_ID_START
    | STRING
    ;

fragment IMAGE_EXTENSION
    : '.png'
    | '.PNG'
    | '.bmp'
    | '.BMP'
    | '.jpeg'
    | '.JPEG'
    ;

STRING
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