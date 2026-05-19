# Especificación de la Gramática PythonSubset

## Visión General

La gramática `PythonSubset.g4` define un subconjunto simplificado del lenguaje Python que incluye las características esenciales para programación estructurada básica. Está diseñada para ser procesada por ANTLR4 y generar código ensamblador x86_64.

## Estructura de la Gramática

### Tokens Léxicos

#### Palabras Clave

```antlr
FOR     : 'for' ;
WHILE   : 'while' ;
IF      : 'if' ;
ELIF    : 'elif' ;
ELSE    : 'else' ;
IN      : 'in' ;
AND     : 'and' ;
OR      : 'or' ;
NOT     : 'not' ;
TRUE    : 'True' ;
FALSE   : 'False' ;
```

#### Tokens Especiales para Indentación

```antlr
INDENT  : 'INDENT' ;   // Generado por preprocesador
DEDENT  : 'DEDENT' ;   // Generado por preprocesador
```

#### Literales e Identificadores

```antlr
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

INT
    : [0-9]+
    ;

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
```

#### Operadores y Delimitadores

Estos símbolos se manejan como literales en las reglas del parser:

```
+  -  *  /  %  **
==  !=  <  >  <=  >=
=   (  )  ,  :
```

## Reglas de Producción

### Estructura Principal

```antlr
prog
    : stmt+ EOF
    ;
```

**Propósito**: Define un programa como secuencia de una o más declaraciones.

### Declaraciones (Statements)

```antlr
stmt
    : simple_stmt NEWLINE
    | compound_stmt
    | NEWLINE
    ;
```

**Tipos soportados**:

- `simple_stmt`: Asignaciones, expresiones, llamadas a función
- `compound_stmt`: Estructuras de control con bloques

#### Declaraciones Simples

```antlr
simple_stmt
    : assign_stmt
    | expr_stmt
    ;

assign_stmt
    : IDENTIFIER '=' expr
    ;

expr_stmt
    : expr
    ;
```

#### Declaraciones Compuestas

```antlr
compound_stmt
    : for_stmt
    | while_stmt
    | if_stmt
    ;
```

### Estructura de Control For

```antlr
for_stmt
    : FOR IDENTIFIER IN iterable ':' NEWLINE INDENT stmt+ DEDENT
    ;

iterable
    : range_call
    | expr
    ;

range_call
    : 'range' '(' range_args ')'
    ;

range_args
    : expr
    | expr ',' expr
    | expr ',' expr ',' expr
    ;
```

**Características**:

- Variable de iteración: `IDENTIFIER`
- Función range recomendada: `range(stop)`, `range(start, stop)` o `range(start, stop, step)`
- Cuerpo con indentación: `INDENT stmt+ DEDENT`

### Estructura de Control While

```antlr
while_stmt
    : WHILE expr ':' NEWLINE INDENT stmt+ DEDENT
    ;
```

**Características**:

- Condición: `expr` (debe evaluar a BOOL o INT)
- Cuerpo con indentación: `INDENT stmt+ DEDENT`

### Estructura de Control If/Elif/Else

```antlr
if_stmt
    : IF expr ':' NEWLINE INDENT stmt+ DEDENT elif_clause* else_clause?
    ;

elif_clause
    : ELIF expr ':' NEWLINE INDENT stmt+ DEDENT
    ;

else_clause
    : ELSE ':' NEWLINE INDENT stmt+ DEDENT
    ;
```

**Características**:

- Condición obligatoria en `if`: `expression`
- Cláusulas `elif` opcionales: Múltiples permitidas
- Cláusula `else` opcional: Máximo una
- Cuerpos con indentación: Cada bloque usa `INDENT stmt+ DEDENT`
- Evaluación secuencial: Se detiene en la primera condición verdadera

### Bloques de Código (Indentación)

Los bloques se representan directamente en cada sentencia compuesta con la forma:

```antlr
INDENT stmt+ DEDENT
```

**Manejo de Indentación**:

- `INDENT`: Incremento de nivel de indentación
- `DEDENT`: Decremento de nivel de indentación
- Generados por el preprocesador en `PythonIndentPreprocessor`

### Expresiones

#### Jerarquía de Precedencia

```antlr
expr
    : expr OR expr                         # LogicalOr
    | expr AND expr                        # LogicalAnd
    | comparison                           # ComparisonExpr
    ;

comparison
    : arith_expr (comp=('==' | '!=' | '>=' | '<=' | '>' | '<') arith_expr)?
    ;

arith_expr
    : arith_expr op=('+' | '-') arith_expr # AddSub
    | arith_expr op=('*' | '/' | '%') arith_expr # MulDivMod
    | unary_expr                           # ArithUnary
    ;

unary_expr
    : NOT unary_expr                       # LogicalNot
    | ('+' | '-') unary_expr               # UnaryOp
    | power_expr                           # PowerBase
    ;

power_expr
    : atom_expr ('**' unary_expr)?         # Power
    ;

atom_expr
    : IDENTIFIER '(' arg_list? ')'         # FuncCall
    | '(' expr ')'                         # Parens
    | INT                                  # IntLiteral
    | STRING                               # StringLiteral
    | TRUE                                 # TrueLiteral
    | FALSE                                # FalseLiteral
    | IDENTIFIER                           # VarRef
    ;

arg_list
    : expr (',' expr)*
    ;
```

**Precedencia** (mayor a menor):

1. Potencia: `**` (asociatividad derecha, un solo nivel)
2. Unarios: `+`, `-`, `not`
3. Multiplicativos: `*`, `/`, `%`
4. Aditivos: `+`, `-`
5. Relacionales: `<`, `>`, `<=`, `>=`
6. Igualdad: `==`, `!=`
7. AND lógico: `and`
8. OR lógico: `or`

#### Expresiones Primarias

Las expresiones atómicas están incluidas en `atom_expr` (ver regla anterior).

## Mapeo AST

### Correspondencia Reglas → Nodos

| Regla Gramática | Nodo AST | Responsabilidad |
|-----------------|----------|------------------|
| `prog` | `ProgNode` | Programa completo |
| `assign_stmt` | `AssignNode` | Asignaciones |
| `expr_stmt` | `ExprStmtNode` | Expresiones como sentencia |
| `for_stmt` | `ForNode` | Ciclos for |
| `while_stmt` | `WhileNode` | Ciclos while |
| `if_stmt` | `IfNode` | Condicionales if/elif/else |
| `func_call` | `FuncCallNode` | Llamadas a función |
| operadores binarios | `BinaryOpNode` | Operaciones +, -, *, /, %, **, <, >, <=, >=, ==, !=, and, or |
| operadores unarios | `UnaryOpNode` | Operaciones +, -, not |
| `INT` | `IntNode` | Números enteros |
| `STRING` | `StringNode` | Cadenas de texto |
| `TRUE`/`FALSE` | `BoolNode` | Valores booleanos |
| `IDENTIFIER` | `VarRefNode` | Referencias a variables |
| `range_call` | `RangeNode` | Función range() |

### Construcción del AST

El `ASTBuilder` implementa el patrón Visitor de ANTLR para transformar el parse tree en AST:

```java
// Ejemplo: visitFor_stmt()
@Override
public ASTNode visitFor_stmt(PythonSubsetParser.For_stmtContext ctx) {
    String variable = ctx.IDENTIFIER().getText();
    RangeNode iterable = (RangeNode) visit(ctx.iterable());
    List<ASTNode> body = new ArrayList<>();
    
    for (PythonSubsetParser.StmtContext stmt : ctx.stmt()) {
        body.add(visit(stmt));
    }
    
    return new ForNode(variable, iterable, body);
}
```

## Extensiones de la Gramática

### Proceso de Extensión

1. **Modificar gramática**

   ```antlr
   // Ejemplo: Agregar definición de funciones
   func_def
       : 'def' IDENTIFIER '(' param_list? ')' ':' NEWLINE INDENT stmt+ DEDENT
       ;
   
   param_list
       : IDENTIFIER (',' IDENTIFIER)*
       ;
   ```

2. **Regenerar parser**

   ```bash
   antlr4 grammar/PythonSubset.g4 -o src/main/antlr4/parser/
   ```

3. **Crear nodo AST**

   ```java
   public class FuncDefNode implements ASTNode {
       private String name;
       private List<String> params;
       private List<ASTNode> body;
   }
   ```

4. **Implementar visitor**

   ```java
   @Override
   public ASTNode visitFunc_def(PythonSubsetParser.Func_defContext ctx) {
       String name = ctx.IDENTIFIER(0).getText();
       List<String> params = extractParams(ctx.param_list());
       List<ASTNode> body = visitStatements(ctx.stmt());
       return new FuncDefNode(name, params, body);
   }
   ```

### Limitaciones Actuales

#### No Soportado en la Gramática

- **Funciones def**: Sin definición de funciones de usuario
- **Listas y tuplas**: Solo escalares (int, string, bool)
- **Dictionaries**: No soportados
- **Import statements**: Sin módulos
- **Clases**: Programación solo procedimental
- **Exception handling**: try/except
- **Decoradores**: @decorator
- **Comprehensions**: List/dict/set comprehensions
- **Generators**: yield y funciones generadoras
- **Lambda**: Funciones lambda anónimas

#### Restricciones Sintácticas

- **Indentación fija**: Debe ser consistente (4 espacios o tabs)
- **Un statement por línea**: Sin `;` para múltiples
- **Strings**: Comillas dobles `""` o simples `''` soportadas
- **Range**: Sintaxis con 1, 2 o 3 argumentos; en la implementacion actual deben ser enteros literales
- **Print con un argumento**: `print(x)`, no `print(x, y)`
- **Potencia `**`**: Está en la gramática, pero la generación de código aún no la implementa
- **Sin asignación compuesta**: No `+=`, `-=`, etc.
- **Comentarios ignorados**: Permitidos con `#` pero no afectan el AST

## Ejemplos de Parsing

### Programa Simple

```python
x = 10
y = 20
print(x + y)
```

**Parse Tree Resultante**:

```
prog
├── stmt (assign_stmt: x = 10)
├── stmt (assign_stmt: y = 20)
└── stmt (expr_stmt: print(x + y))
```

### Ciclo For

```python
for i in range(3):
    print(i)
    x = i * 2
```

**Parse Tree**:

```
prog
└── stmt
    └── compound_stmt
        └── for_stmt
            ├── IDENTIFIER: i
            ├── iterable: range(3)
            ├── INDENT
            ├── stmt (print(i))
            ├── stmt (x = i * 2)
            └── DEDENT
```

### Condicional If/Elif/Else

```python
x = 15

if x > 20:
    print("Mayor que 20")
elif x > 10:
    print("Mayor que 10")
elif x > 5:
    print("Mayor que 5")
else:
    print("5 o menor")
```

**Parse Tree**:

```
prog
├── stmt (assign_stmt: x = 15)
└── stmt
    └── compound_stmt
        └── if_stmt
            ├── expr (x > 20)
            ├── INDENT ... DEDENT
            ├── elif_clause (x > 10) -> INDENT ... DEDENT
            ├── elif_clause (x > 5) -> INDENT ... DEDENT
            └── else_clause -> INDENT ... DEDENT
```

### Expresión Compleja

```python
resultado = (a + b) * 2 > 10 and not activo
```

**Árbol de Expresión**:

```
expr (LogicalAnd)
├── comparison ((a + b) * 2 > 10)
└── unary_expr (not activo)
```

## Herramientas de Depuración

### Visualizar Parse Tree

```bash
# Generar diagrama del árbol
antlr4 PythonSubset.g4 -gui
```

### Probar Lexer

```bash
# Ver tokens generados
antlr4 PythonSubset.g4 -tokens input.py
```

### Validar Gramática

```bash
# Verificar sintaxis de gramática
antlr4 PythonSubset.g4 -Werror
```
