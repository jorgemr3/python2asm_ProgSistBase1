grammar PythonSubset;

// Entrada principal: una o más sentencias seguida de EOF
prog
    : stmt+ EOF
    ;

// Sentencias: asignaciones y expresiones (incluye llamadas)
stmt
    : assign_stmt
    | expr_stmt
    ;

// Asignación: variable = expresión, termina con NEWLINE o EOF
assign_stmt
    : IDENTIFIER '=' expr (NEWLINE | EOF)
    ;

// Expresión como sentencia: expr + NEWLINE/EOF
expr_stmt
    : expr (NEWLINE | EOF)
    ;

// Expresiones soportadas
expr
    : IDENTIFIER '(' arg_list? ')'         # FuncCall
    | expr '^' expr                        # Pow
    | expr op=('*' | '/' | '%') expr       # MulDivMod
    | expr op=('+' | '-') expr             # AddSub
    | '(' expr ')'                         # Parens
    | INT                                  # IntLiteral
    | STRING                               # StringLiteral
    | IDENTIFIER                           # VarRef
    ;

// Comparaciones (útil para if más adelante)
comparison
    : expr comp=('==' | '!=' | '>=' | '<=' | '>' | '<') expr
    ;

// Lista de argumentos para llamadas
arg_list
    : expr (',' expr)*
    ;

// ------ Lexer Rules ------

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

INT
    : [0-9]+
    ;

// Cadena entre comillas dobles o simples
STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

NEWLINE
    : ( '\r'? '\n' )+
    ;

WS
    : [ \t]+ -> skip
    ;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;
