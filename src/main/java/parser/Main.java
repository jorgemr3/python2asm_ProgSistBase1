package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.ast.ASTNode;
import parser.ast.ASTPrinter;
import codegen.CodeGenerator;
import util.PythonIndentPreprocessor;
import util.ErrorHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("[ERROR] Uso: java parser.Main <archivo.py>");
            return;
        }

        System.err.println("==========[INFO] Iniciando traduccion ==========\n");
        System.err.println("[INFO] Archivo de entrada: " + args[0]);

        // ── FRONTEND ─────────────────────────────────────────────────────────────

        // FASE 1: Análisis Léxico
        // Preprocesa la indentación de Python a tokens INDENT/DEDENT,
        // luego tokeniza el código fuente con el Lexer generado por ANTLR.

        CharStream input = CharStreams.fromFileName(args[0]);
        String content = input.toString();
        ErrorHandler errorHandler = new ErrorHandler(args[0], content);

        CharStream processedInput = PythonIndentPreprocessor.preprocess(content, errorHandler);
        if (errorHandler.hasErrors()) {
            errorHandler.printErrors();
            return;
        }
        System.err.println("[INFO] Análisis Léxico — preprocesamiento de indentación completado.\n");

        PythonSubsetLexer lexer = new PythonSubsetLexer(processedInput);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorHandler);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.err.println("[INFO] Análisis Léxico — tokens generados.\n");

        // System.out.println("==========[TOKENS]==========");
        // for (Token t : tokens.getTokens()) {
        //     String tokenText = t.getText().replace("\n", "\\n");
        //     System.out.printf("Línea %-3d | %-15s (%s)\n", t.getLine(), tokenText,
        //             lexer.getVocabulary().getSymbolicName(t.getType()));
        // }
        // System.out.println("============================\n");

        // FASE 2: Análisis Sintáctico
        // El parser construye el árbol de parseo según la gramática formal (ANTLR).
        // El ASTBuilder lo transforma en un AST propio más limpio y estructurado.

        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorHandler);
        System.err.println("[INFO] EJECUTAR COMANDO PARA VISUALIZAR ARBOL DE PARSEO EN README.MD\n");

        ParseTree tree = parser.prog();
        if (errorHandler.hasErrors()) {
            errorHandler.printErrors();
            return;
        }
        System.err.println("[INFO] Análisis Sintáctico — árbol de parseo construido.\n");

        // System.out.println("==========[PARSE TREE]==========");
        // System.out.println(tree.toStringTree(parser));
        // System.out.println("================================\n");

        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(tree);
        if (ast == null) {
            System.err.println("[ERROR] ASTBuilder devuelve null. Revisa la entrada.");
            return;
        }
        System.err.println("[INFO] Análisis Sintáctico — AST construido.\n");

        // FASE 3: Análisis Semántico
        // Verifica tipos, variables definidas y uso correcto de funciones.
        // Solo si pasa esta fase, el AST se considera depurado y listo.

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        if (!analyzer.analyze(ast)) {
            for (String error : analyzer.getErrors()) {
                System.err.println(error);
            }
            return;
        }
        System.err.println("[INFO] Análisis Semántico — sin errores. AST verificado.\n");

        System.err.println("==========[AST IMPRESO]==========");
        ASTPrinter printer = new ASTPrinter();
        printer.print(ast);
        System.err.println("=================================\n");

        // ── BACKEND ──────────────────────────────────────────────────────────────

        // FASE 4: Generación de Código
        // El AST ya está completamente verificado por el frontend.
        // El generador emite instrucciones NASM x86_64 para Linux.

        CodeGenerator codegen = new CodeGenerator();
        String asm = codegen.generate(ast);

        // System.out.println("==========[ASM]==========");
        System.out.println(asm);
        // System.out.println("=========================\n");

        System.err.println("[INFO] Traduccion completada exitosamente.");
    }
}
