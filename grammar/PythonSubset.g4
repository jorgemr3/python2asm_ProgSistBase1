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

// Expresiones soportadas (precedencia de menor a mayor)
expr
    : expr OR expr                         # LogicalOr
    | expr AND expr                        # LogicalAnd
    | comparison                           # ComparisonExpr
    ;

// Comparaciones # Comparison
comparison
    : arith_expr (comp=('==' | '!=' | '>=' | '<=' | '>' | '<') arith_expr)?  
    ;

// Expresiones aritméticas
arith_expr
    : arith_expr op=('+' | '-') arith_expr # AddSub
    | arith_expr op=('*' | '/' | '%') arith_expr # MulDivMod
    | unary_expr                           # ArithUnary
    ;

// Expresiones unarias y potencia (asociatividad derecha)
unary_expr
    : NOT unary_expr                       # LogicalNot
    | ('+' | '-') unary_expr               # UnaryOp
    | power_expr                           # PowerBase
    ;

// Potencia con asociatividad derecha
power_expr
    : atom_expr ('**' unary_expr)?          # Power
    ;

// Expresiones atómicas (mayor precedencia)
atom_expr
    : IDENTIFIER '(' arg_list? ')'         # FuncCall
    | '(' expr ')'                         # Parens
    | INT                                  # IntLiteral
    | STRING                               # StringLiteral
    | IDENTIFIER                           # VarRef
    ;

// Lista de argumentos para llamadas
arg_list
    : expr (',' expr)*
    ;

// ------ Lexer Rules ------

// Palabras clave (deben ir antes de IDENTIFIER)
AND     : 'and' ;
OR      : 'or' ;
NOT     : 'not' ;

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
