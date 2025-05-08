// src/main/java/parser/Main.java
package parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.PythonSubsetLexer;
import parser.PythonSubsetParser;
import parser.ast.ASTNode;          // <— ASTNode
import codegen.CodeGenerator;      // <— CodeGenerator

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Uso: java parser.Main <archivo.py>");
            return;
        }
        // 1) Lee el .py
        CharStream input = CharStreams.fromFileName(args[0]);
        // 2) Tokeniza
        PythonSubsetLexer lexer = new PythonSubsetLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 3) Parsea
        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        ParseTree tree = parser.prog();  // regla inicial: prog
        // 4) Construye AST
        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(tree);
        // 5) Genera ensamblador
        CodeGenerator codegen = new CodeGenerator();
        String asm = codegen.generate(ast);
        // 6) Muestra por pantalla (o redirige a .asm)
        System.out.println(asm);
    }
}
