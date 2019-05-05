
grammar imgLang;

script
    : NEWLINE* line ( NEWLINE+ line )* NEWLINE*
    ;

line
    : assignment
    | expression
    ;

assignment
    : id EQUAL expression
    ;

expression
    : term                              #SingleTerm
    | expression PLUS term              #Plus
    | expression MINUS term             #Minus
    ;

term
    : image                 #ImageTerm
    | term MULT image       #Mult
    | term DIV image        #Div
    ;

image
    : id                    #Var
    | path                  #Literal
    | operation             #Call
    ;

operation
    : 'canny' '(' image ',' FLOAT ',' FLOAT ')'                         #Canny
    | 'sobel' '(' image ',' FLOAT ')'                                   #Sobel
    | 'chromaKey' '(' image ',' FLOAT ',' FLOAT ',' FLOAT ')'           #ChromaKey
    | 'gaussianBlur' '(' image ',' INT ',' FLOAT ')'                    #GaussianBlur
    | 'grayScale' '(' image ')'                                         #GrayScale
    | 'sharpen' '(' image ',' FLOAT ')'                                 #Sharpen
    | 'translucent' '(' image ')'                                       #Translucent
    ;

id
    : ID
    ;

path
    : PATH_LITERAL
    ;

value
    : INT
    | FLOAT
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
    | './'
    | '/'
    | ('a' .. 'z')':/'
    | ('A' .. 'Z')':/'
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
    | '.jpg'
    | '.JPG'
    ;

fragment DIGIT
    : '0' .. '9'
    ;

INT
    : DIGIT+
    ;

FLOAT
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

NEWLINE
    : '\r\n'
    | 'r'
    | '\n'
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

COMMENT
    : '#' ~[\r\n]* ->skip
    ;

WS
   : [ t] + -> skip
   ;
