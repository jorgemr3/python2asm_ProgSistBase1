package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.ast.ASTNode;
import parser.ast.ASTPrinter;
import codegen.CodeGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("[ERROR] Uso: java parser.Main <archivo.py>");
            return;
        }

        System.out.println("==========[INFO] Iniciando traduccion ==========\n");
        System.out.println("[INFO] Archivo de entrada: " + args[0]);

        // 1. Lectura del archivo
        CharStream input = CharStreams.fromFileName(args[0]);
        System.out.println("[INFO] Lectura completada.\n");

        // 2. Lexer
        PythonSubsetLexer lexer = new PythonSubsetLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println("==========[TOKENS]==========");
        for (Token t : tokens.getTokens()) {
            String tokenText = t.getText().replace("\n", "\\n");
            System.out.printf("Línea %-3d | %-15s (%s)\n", t.getLine(), tokenText,
                    lexer.getVocabulary().getSymbolicName(t.getType()));
        }
        System.out.println("============================\n");

        // 3. Parser
        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println("==========[PARSE TREE]==========");
        System.out.println(tree.toStringTree(parser));
        System.out.println("================================\n");

        // 4. AST
        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(tree);
        if (ast == null) {
            System.err.println("[ERROR] ASTBuilder devuelve null. Revisa la entrada.");
            return;
        }

        System.out.println("==========[AST IMPRESO]==========");
        ASTPrinter printer = new ASTPrinter();
        printer.print(ast);
        System.out.println("=================================\n");

        // 5. Generación de código ensamblador
        CodeGenerator codegen = new CodeGenerator();
        String asm = codegen.generate(ast);

        System.out.println("==========[ASM]==========");
        System.out.println(asm);
        System.out.println("=========================\n");

        System.out.println("[INFO] Traduccion completada exitosamente.");
    }
}
