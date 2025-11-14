package parser;

import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/**
 * Lexer que maneja indentación de Python procesando el archivo línea por línea
 * y generando tokens INDENT/DEDENT apropiados
 */
public class IndentationLexer extends PythonSubsetLexer {
    
    private final Queue<Token> pendingTokens = new LinkedList<>();
    private boolean tokensGenerated = false;
    
    public IndentationLexer(CharStream input) {
        super(input);
    }
    
    @Override
    public Token nextToken() {
        if (!tokensGenerated) {
            generateAllTokens();
            tokensGenerated = true;
        }
        
        if (pendingTokens.isEmpty()) {
            return new CommonToken(EOF, "<EOF>");
        }
        
        return pendingTokens.poll();
    }
    
    private void generateAllTokens() {
        try {
            String inputText = getInputStream().toString();
            String[] lines = inputText.split("\r?\n");
            processLines(lines);
        } catch (Exception e) {
            throw new RuntimeException("Error procesando indentación: " + e.getMessage(), e);
        }
    }
    
    private void processLines(String[] lines) {
        Deque<Integer> indentStack = new ArrayDeque<>();
        indentStack.push(0); // Nivel base
        
        // Crear un lexer temporal para obtener tokens de cada línea
        for (int lineNum = 0; lineNum < lines.length; lineNum++) {
            String line = lines[lineNum];
            
            // Saltar líneas vacías y comentarios
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                // Solo agregar NEWLINE si no es la última línea
                if (lineNum < lines.length - 1) {
                    addToken(NEWLINE, "\n", lineNum + 1, 0);
                }
                continue;
            }
            
            // Calcular indentación
            int indentLevel = getIndentationLevel(line);
            int currentIndent = indentStack.peek();
            
            // Generar tokens de indentación
            if (indentLevel > currentIndent) {
                // Aumento de indentación
                indentStack.push(indentLevel);
                addToken(INDENT, "INDENT", lineNum + 1, 0);
            } else if (indentLevel < currentIndent) {
                // Disminución de indentación - generar DEDENT(s)
                while (!indentStack.isEmpty() && indentStack.peek() > indentLevel) {
                    indentStack.pop();
                    addToken(DEDENT, "DEDENT", lineNum + 1, 0);
                }
                
                // Verificar que el nivel coincida
                if (indentStack.isEmpty() || indentStack.peek() != indentLevel) {
                    throw new RuntimeException("Error de indentación en línea " + (lineNum + 1));
                }
            }
            
            // Procesar tokens de la línea
            processLineTokens(line.trim(), lineNum + 1);
            
            // Agregar NEWLINE al final de la línea (excepto la última)
            if (lineNum < lines.length - 1) {
                addToken(NEWLINE, "\n", lineNum + 1, line.length());
            }
        }
        
        // Generar DEDENT para todos los niveles restantes
        while (indentStack.size() > 1) {
            indentStack.pop();
            // Agregar NEWLINE antes de cada DEDENT si es necesario
            addToken(NEWLINE, "\n", lines.length, 0);
            addToken(DEDENT, "DEDENT", lines.length, 0);
        }
        
        // Agregar NEWLINE final antes de EOF
        addToken(NEWLINE, "\n", lines.length, 0);
        // Agregar EOF
        addToken(EOF, "<EOF>", lines.length, 0);
    }
    
    private int getIndentationLevel(String line) {
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
    
    private void processLineTokens(String line, int lineNum) {
        if (line.isEmpty()) return;
        
        // Crear un lexer temporal para esta línea
        try {
            CharStream lineInput = CharStreams.fromString(line);
            PythonSubsetLexer tempLexer = new PythonSubsetLexer(lineInput);
            
            Token token;
            while ((token = tempLexer.nextToken()).getType() != EOF) {
                if (token.getChannel() == Token.DEFAULT_CHANNEL) {
                    // Crear nuevo token con la línea correcta
                    CommonToken newToken = new CommonToken(
                        token.getType(), 
                        token.getText()
                    );
                    newToken.setLine(lineNum);
                    newToken.setCharPositionInLine(token.getCharPositionInLine());
                    pendingTokens.offer(newToken);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error procesando línea " + lineNum + ": " + e.getMessage(), e);
        }
    }
    
    private void addToken(int type, String text, int line, int charPos) {
        CommonToken token = new CommonToken(type, text);
        token.setLine(line);
        token.setCharPositionInLine(charPos);
        pendingTokens.offer(token);
    }
}