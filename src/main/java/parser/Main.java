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

        // 2. Preprocesar indentación si es necesario
        String content = input.toString();
        CharStream processedInput = preprocessPythonIndentation(content);
        
        // 3. Lexer estándar con contenido preprocesado
        PythonSubsetLexer lexer = new PythonSubsetLexer(processedInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // System.out.println("==========[TOKENS]==========");
        // for (Token t : tokens.getTokens()) {
        //     String tokenText = t.getText().replace("\n", "\\n");
        //     System.out.printf("Línea %-3d | %-15s (%s)\n", t.getLine(), tokenText,
        //             lexer.getVocabulary().getSymbolicName(t.getType()));
        // }
        // System.out.println("============================\n");

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
    
    /**
     * Preprocesa texto Python convirtiendo indentación en tokens INDENT/DEDENT explícitos
     */
    private static CharStream preprocessPythonIndentation(String input) {
        String[] lines = input.split("\r?\n");
        StringBuilder result = new StringBuilder();
        
        java.util.Deque<Integer> indentStack = new java.util.ArrayDeque<>();
        indentStack.push(0); // Nivel base
        
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            
            // Líneas vacías o comentarios - mantener como están
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                result.append(line).append("\n");
                continue;
            }
            
            int indentLevel = getIndentationLevel(line);
            int currentIndent = indentStack.peek();
            
            // Generar tokens de indentación
            if (indentLevel > currentIndent) {
                // Aumento de indentación
                indentStack.push(indentLevel);
                result.append("INDENT ");
            } else if (indentLevel < currentIndent) {
                // Disminución de indentación
                while (!indentStack.isEmpty() && indentStack.peek() > indentLevel) {
                    indentStack.pop();
                    result.append("DEDENT ");
                }
            }
            
            // Agregar la línea sin indentación inicial
            result.append(line.trim());
            // Siempre agregar newline después de cada línea
            result.append("\n");
        }
        
        // Cerrar todos los bloques pendientes
        while (indentStack.size() > 1) {
            indentStack.pop();
            result.append(" DEDENT");
        }
        
        return CharStreams.fromString(result.toString());
    }
    
    /**
     * Calcula el nivel de indentación de una línea
     */
    private static int getIndentationLevel(String line) {
        int level = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                level++;
            } else if (c == '\t') {
                level += 4; // Tratar tab como 4 espacios
            } else {
                break;
            }
        }
        return level;
    }
}
