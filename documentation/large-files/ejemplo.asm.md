# ejemplo.asm

Archivo copiado desde `build/ejemplo.asm`.

```
[CodeGen] visit(StringNode): "x es mayor que 5"
[CodeGen] visit(StringNode): "x es mayor que 3"
[CodeGen] visit(StringNode): "x es menor o igual a 3"
[CodeGen] visit(StringNode): "z es 15"
==========[ASM]==========
section .data
str253613748: db "x es mayor que 5", 0x0A, 0
str253613746: db "x es mayor que 3", 0x0A, 0
str1777276300: db "x es menor o igual a 3", 0x0A, 0
str1914133424: db "z es 15", 0x0A, 0

section .text
global _start

_start:
    mov rbp, rsp

    push 10

    pop rax
    mov [rbp-8], rax

    ; Evaluar condici¾n del if
    mov rax, [rbp-8]
    push rax

    push 5

    pop rbx
    pop rax
    cmp rax, rbx
    setg al
    movzx rax, al
    push rax

    pop rax
    test rax, rax
    jz elif_else_1

    ; Cuerpo del if (then)
    lea rdi, [rel str253613748]
    push rdi

    call print
    push rax

    pop rax

    push 20

    pop rax
    mov [rbp-16], rax

    jmp if_end_0

elif_else_1:
    ; Evaluar condici¾n del elif 1
    mov rax, [rbp-8]
    push rax

    push 3

    pop rbx
    pop rax
    cmp rax, rbx
    setg al
    movzx rax, al
    push rax

    pop rax
    test rax, rax
    jz elif_else_2

    ; Cuerpo del elif 1
    lea rdi, [rel str253613746]
    push rdi

    call print
    push rax

    pop rax

    jmp if_end_0

elif_else_2:
    ; Cuerpo del else
    lea rdi, [rel str1777276300]
    push rdi

    call print
    push rax

    pop rax

if_end_0:
    ; Fin del if

    push 15

    pop rax
    mov [rbp-24], rax

    ; Evaluar condici¾n del if
    mov rax, [rbp-24]
    push rax

    push 15

    pop rbx
    pop rax
    cmp rax, rbx
    sete al
    movzx rax, al
    push rax

    pop rax
    test rax, rax
    jz if_end_3

    ; Cuerpo del if (then)
    lea rdi, [rel str1914133424]
    push rdi

    call print
    push rax

    pop rax

    jmp if_end_3

if_end_3:
    ; Fin del if

_start_end:
    mov rax, 60
    mov rdi, 0
    syscall

=========================
```
