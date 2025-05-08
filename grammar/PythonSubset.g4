grammar PythonSubset;

// Entrada principal: una o más sentencias
prog
    : stmt+ EOF
    ;

// Sentencias soportadas: asignaciones y expresiones simples
stmt
    : assign_stmt
    | expr_stmt
    ;

// Asignación de variable: IDENT = expr NEWLINE
assign_stmt
    : IDENTIFIER '=' expr (NEWLINE | EOF)
    ;

// Expresión independiente (por ejemplo: llamar a print)
expr_stmt
    : expr (NEWLINE | EOF)
    ;

// Expresiones aritméticas con precedencia
expr
    : IDENTIFIER '(' arg_list? ')'     # FuncCall
    | expr '^' expr                    # Pow
    | expr op=('*' | '/' | '%') expr   # MulDivMod
    | expr op=('+' | '-') expr         # AddSub
    | '(' expr ')'                     # Parens
    | INT                              # IntLiteral
    | IDENTIFIER                       # VarRef
    ;

// Regla para comparación simple (opcional)
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


// Comentarios de línea
COMMENT
    : '#' ~[\r\n]* -> skip
    ;
