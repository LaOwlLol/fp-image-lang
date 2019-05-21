
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
    : 'canny' '(' image ',' floatValue ',' floatValue ')'                              #Canny
    | 'sobel' '(' image ',' floatValue ')'                                             #Sobel
    | 'chromaKey' '(' image ',' intValue ',' intValue ',' intValue ',' floatValue ')'  #ChromaKey
    | 'gaussianBlur' '(' image ',' intValue ',' floatValue ')'                         #GaussianBlur
    | 'grayScale' '(' image ')'                                                        #GrayScale
    | 'sharpen' '(' image ',' floatValue ')'                                           #Sharpen
    | 'translucent' '(' image ')'                                                      #Translucent
    ;

intValue
    : INT
    ;

floatValue
    : FLOAT
    ;

id
    : ID
    ;

path
    : PATH_LITERAL
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
    : '#' ~[\r\n]* ->skip
    ;

WS
   : [ t] + -> skip
   ;
