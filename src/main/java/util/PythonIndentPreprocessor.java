package util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

/**
 * Utilidad para preprocesar código Python y convertir indentación
 * en tokens INDENT/DEDENT explícitos para el parser ANTLR.
 */
public class PythonIndentPreprocessor {
    
    /**
     * Preprocesa texto Python convirtiendo indentación en tokens INDENT/DEDENT explícitos
     * 
     * @param input El código Python con indentación normal
     * @return CharStream con tokens INDENT/DEDENT insertados
     */
    public static CharStream preprocess(String input) {
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
     * 
     * @param line La línea a analizar
     * @return El número de espacios de indentación (tabs = 4 espacios)
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
