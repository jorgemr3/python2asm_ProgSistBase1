grammar PythonSubset;
// gramatica
prog
    : stmt+ EOF
    ;

stmt
    : assign_stmt
    | expr_stmt
    ;

assign_stmt
    : IDENTIFIER '=' expr (NEWLINE | EOF)
    ;

expr_stmt
    : expr (NEWLINE | EOF)
    ;

expr
    : IDENTIFIER '(' arg_list? ')'     # FuncCall
    | expr '^' expr                    # Pow
    | expr op=('*' | '/' | '%') expr   # MulDivMod
    | expr op=('+' | '-') expr         # AddSub
    | '(' expr ')'                     # Parens
    | INT                              # IntLiteral
    | IDENTIFIER                       # VarRef
    ;

comparison
    : expr comp=('==' | '!=' | '>=' | '<=' | '>' | '<') expr
    ;

// ------ Lexer ------

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

INT
    : [0-9]+
    ;

NEWLINE
    : ( '\r'? '\n' )+
    ;

WS
    : [ \t]+ -> skip
    ;

arg_list
    : expr (',' expr)* 
    ;



COMMENT
    : '#' ~[\r\n]* -> skip
    ;