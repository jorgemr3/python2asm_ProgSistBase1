package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.ast.ASTNode;
import parser.ast.ASTPrinter;
import codegen.CodeGenerator;
import util.PythonIndentPreprocessor;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("[ERROR] Uso: java parser.Main <archivo.py>");
            return;
        }

        System.err.println("==========[INFO] Iniciando traduccion ==========\n");
        System.err.println("[INFO] Archivo de entrada: " + args[0]);

        // 1. Lectura del archivo
        CharStream input = CharStreams.fromFileName(args[0]);
        System.err.println("[INFO] Lectura de entrada completada.\n");

        // 2. Preprocesar indentación y dedentación
        String content = input.toString();
        CharStream processedInput = PythonIndentPreprocessor.preprocess(content);
        System.err.println("[INFO] Preprocesamiento de indentación completado.\n");
        
        // 3. Lexer estándar con contenido preprocesado
        PythonSubsetLexer lexer = new PythonSubsetLexer(processedInput);
        System.err.println("[INFO] Lexer creado con contenido preprocesado.\n");

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.err.println("[INFO] Tokens generados a partir del lexer.\n");

        // System.out.println("==========[TOKENS]==========");
        // for (Token t : tokens.getTokens()) {
        //     String tokenText = t.getText().replace("\n", "\\n");
        //     System.out.printf("Línea %-3d | %-15s (%s)\n", t.getLine(), tokenText,
        //             lexer.getVocabulary().getSymbolicName(t.getType()));
        // }
        // System.out.println("============================\n");

        // 3. Parser
        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        System.err.println("[INFO] EJECUTAR COMANDO PARA VISUALIZAR ARBOL DE PARSEO EN README.MD\n");
        ParseTree tree = parser.prog();
        // System.out.println("==========[PARSE TREE]==========");
        // System.out.println(tree.toStringTree(parser));
        // System.out.println("================================\n");

        // 4. AST
        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(tree);
        if (ast == null) {
            System.err.println("[ERROR] ASTBuilder devuelve null. Revisa la entrada.");
            return;
        }

        System.err.println("==========[AST IMPRESO]==========");
        ASTPrinter printer = new ASTPrinter();
        printer.print(ast);
        System.err.println("=================================\n");

        // 5. Generación de código ensamblador
        CodeGenerator codegen = new CodeGenerator();
        String asm = codegen.generate(ast);

        System.out.println("==========[ASM]==========");
        System.out.println(asm);
        System.out.println("=========================\n");

        System.err.println("[INFO] Traduccion completada exitosamente.");
    }
}
