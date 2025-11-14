package parser;

import java.io.*;
import java.util.*;

/**
 * Preprocesador que convierte sintaxis Python con indentación
 * a sintaxis con llaves para facilitar el parsing
 */
public class PythonIndentProcessor {
    
    public static String processFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        
        return processLines(lines);
    }
    
    public static String processLines(List<String> lines) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> indentStack = new ArrayDeque<>();
        indentStack.push(0); // Nivel base
        
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            
            // Saltar líneas vacías y comentarios
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                result.append(line).append("\n");
                continue;
            }
            
            int indentLevel = getIndentLevel(line);
            int currentIndent = indentStack.peek();
            
            // Manejar cambios de indentación
            if (indentLevel > currentIndent) {
                // Aumento de indentación - agregar {
                indentStack.push(indentLevel);
                result.append(line).append(" {\n");
            } else if (indentLevel < currentIndent) {
                // Disminución de indentación - agregar }
                while (!indentStack.isEmpty() && indentStack.peek() > indentLevel) {
                    indentStack.pop();
                    result.append("}\n");
                }
                result.append(line).append("\n");
            } else {
                // Mismo nivel de indentación
                result.append(line).append("\n");
            }
        }
        
        // Cerrar todos los bloques pendientes
        while (indentStack.size() > 1) {
            indentStack.pop();
            result.append("}\n");
        }
        
        return result.toString();
    }
    
    private static int getIndentLevel(String line) {
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