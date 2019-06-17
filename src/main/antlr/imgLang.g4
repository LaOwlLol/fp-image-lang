
grammar imgLang;

script
    : NEWLINE* line ( NEWLINE+ line )* NEWLINE*
    ;

body
    : NEWLINE* '{' NEWLINE* line ( NEWLINE+ line )* NEWLINE* '}' NEWLINE*
    ;

line
    : assignment
    | expression
    | write
    | foreach
    ;

foreach
    : 'for' id 'in' dir body
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
//    | term DIV image        #Div
    ;

image
    : id                    #Var
    | path                  #Literal
    | operation             #Call
    ;

operation
    : 'canny' '(' expression ',' floatValue ',' floatValue ')'                              #Canny
    | 'sobel' '(' expression ',' floatValue (',' boolValue (',' boolValue )? )? ')'         #Sobel
    | 'chromaKey' '(' expression ',' intValue ',' intValue ',' intValue ',' floatValue ')'  #ChromaKey
    | 'gaussianBlur' '(' expression ',' intValue ',' floatValue ')'                         #GaussianBlur
    | 'grayScale' '(' expression (',' floatValue ',' floatValue ',' floatValue )? ')'       #GrayScale
    | 'redist' '(' expression ',' floatValue ')'                                            #Redist
    | 'translucent' '(' expression ')'                                                      #Translucent
    ;

write
    : path '<<' expression
    ;

intValue
    : INT
    ;

floatValue
    : FLOAT
    ;

boolValue
    : BOOL
    ;

id
    : ID
    ;

path
    : PATH_LITERAL
    ;

dir
    : DIR_LITERAL
    ;

ID
    : ID_LETTER (ID_LETTER | DIGIT)*
    ;

fragment ID_LETTER
    : 'a' .. 'z'
    | 'A' .. 'Z'
    | '_'
    ;

PATH_LITERAL
    : VALID_PATH_START (VALID_PATH_CHAR | DIGIT)* IMAGE_EXTENSION
    ;

DIR_LITERAL
    : VALID_PATH_START (VALID_PATH_CHAR | DIGIT)* DIV
    ;

fragment VALID_PATH_START
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | './'
    | '/'
    | ('a' .. 'z')':/'
    | ('A' .. 'Z')':/'
    ;

fragment VALID_PATH_CHAR
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    | '/'
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

fragment TRUELITERAL
    : 'true'
    ;

fragment FALSELITERAL
    : 'false'
    ;

BOOL
    : '#'(TRUELITERAL|FALSELITERAL)
    ;

NEWLINE
    : '\r\n'
    | 'r'
    | '\n'
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
    : ';' ~[\r\n]* ->skip
    ;

WS
   : [ \t] + -> skip
   ;
