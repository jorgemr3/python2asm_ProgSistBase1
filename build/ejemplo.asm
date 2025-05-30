==========[INFO] Iniciando traduccion ==========

[INFO] Archivo de entrada: src\test\ejemplo.py
[INFO] Lectura completada.

==========[PARSE TREE]==========
(prog 
  (stmt (assign_stmt a = (expr 5) \r\n)) 
  (stmt (assign_stmt b = (expr 6) \r\n)) 
  (stmt (assign_stmt c = (expr (expr a) + (expr b)) \r\n)) 
  (stmt (expr_stmt (expr print ( (arg_list (expr c)) )) \r\n)) 
  (stmt (expr_stmt (expr print ( (arg_list (expr "Hello World")) )) \r\n)) 
  (stmt (expr_stmt (expr print ( (arg_list (expr 'Hello bleh')) )) <EOF>)) 
  <EOF>)
================================

==========[AST IMPRESO]==========
ProgNode
  AssignNode: a
    IntNode: 5
  AssignNode: b
    IntNode: 6
  AssignNode: c
    BinaryOpNode: +
      VarRefNode: a
      VarRefNode: b
  ExprStmtNode
    FuncCallNode: print
      VarRefNode: c
  ExprStmtNode
    FuncCallNode: print
      StringNode: "Hello World"
  ExprStmtNode
    FuncCallNode: print
      StringNode: "Hello bleh"
=================================

[CodeGen] visit(StringNode): "Hello World"
[CodeGen] visit(StringNode): "Hello bleh"
==========[ASM]==========
section .data
str388142363: db "Hello bleh", 0x0A, 0

section .text
global _start

    push 5

    pop rax
    mov [rbp-8], rax

    push 6

    pop rax
    mov [rbp-16], rax

    mov rax, [rbp-8]
    push rax

    mov rax, [rbp-16]
    push rax

    pop rbx
    pop rax
    add rax, rbx
    push rax

    pop rax
    mov [rbp-24], rax

    mov rax, [rbp-24]
    push rax

    call print
    push rax

    pop rax

section .data
section .text
global _start

    push 5

    pop rax
    mov [rbp-8], rax

    push 6

    pop rax
    mov [rbp-16], rax

    mov rax, [rbp-8]
    push rax

    mov rax, [rbp-16]
    push rax

    pop rbx
    pop rax
    add rax, rbx
    push rax

    pop rax
    mov [rbp-24], rax

    mov rax, [rbp-24]
    push rax

    call print
    push rax

    pop rax

    lea rdi, [rel str862545276]
    ; llamada a print pendiente
    push rdi

    call print
    push rax

    pop rax

section .data
str862545276: db "Hello World", 0x0A, 0

section .text
global _start

    push 5

    pop rax
    mov [rbp-8], rax

    push 6

    pop rax
    mov [rbp-16], rax

    mov rax, [rbp-8]
    push rax

    mov rax, [rbp-16]
    push rax

    pop rbx
    pop rax
    add rax, rbx
    push rax

    pop rax
    mov [rbp-24], rax

    mov rax, [rbp-24]
    push rax

    call print
    push rax

    pop rax

section .data
section .text
global _start

    push 5

    pop rax
    mov [rbp-8], rax

    push 6

    pop rax
    mov [rbp-16], rax

    mov rax, [rbp-8]
    push rax

    mov rax, [rbp-16]
    push rax

    pop rbx
    pop rax
    add rax, rbx
    push rax

    pop rax
    mov [rbp-24], rax

    mov rax, [rbp-24]
    push rax

    call print
    push rax

    pop rax

    lea rdi, [rel str862545276]
    ; llamada a print pendiente
    push rdi

    call print
    push rax

    pop rax

    lea rdi, [rel str388142363]
    ; llamada a print pendiente
    push rdi

    call print
    push rax

    pop rax

_start_end:
    mov rax, 60
    mov rdi, 0
    syscall

=========================

[INFO] Traduccion completada exitosamente.
