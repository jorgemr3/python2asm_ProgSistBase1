package parser;

import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/**
 * Lexer simplificado que procesa indentación Python de forma más robusta
 */
public class SimpleIndentationLexer extends PythonSubsetLexer {
    
    private final Queue<Token> tokens = new LinkedList<>();
    private boolean processed = false;
    
    public SimpleIndentationLexer(CharStream input) {
        super(input);
    }
    
    @Override
    public Token nextToken() {
        if (!processed) {
            processInput();
            processed = true;
        }
        
        return tokens.isEmpty() ? 
            createToken(EOF, "<EOF>") : 
            tokens.poll();
    }
    
    private void processInput() {
        String content = getInputStream().toString();
        String[] lines = content.split("\r?\n");
        
        Deque<Integer> indentStack = new ArrayDeque<>();
        indentStack.push(0);
        
        int lineNumber = 1;
        
        for (String line : lines) {
            if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                // Línea vacía o comentario - solo agregar NEWLINE
                tokens.offer(createToken(NEWLINE, "\n"));
                lineNumber++;
                continue;
            }
            
            int indent = getIndent(line);
            int currentIndent = indentStack.peek();
            
            // Manejar cambios de indentación
            if (indent > currentIndent) {
                indentStack.push(indent);
                tokens.offer(createToken(INDENT, "INDENT"));
            } else if (indent < currentIndent) {
                while (indentStack.peek() > indent) {
                    indentStack.pop();
                    tokens.offer(createToken(DEDENT, "DEDENT"));
                }
            }
            
            // Procesar tokens de la línea
            processLine(line.trim(), lineNumber);
            tokens.offer(createToken(NEWLINE, "\n"));
            
            lineNumber++;
        }
        
        // Cerrar todos los bloques
        while (indentStack.size() > 1) {
            indentStack.pop();
            tokens.offer(createToken(DEDENT, "DEDENT"));
        }
        
        tokens.offer(createToken(EOF, "<EOF>"));
    }
    
    private int getIndent(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') count++;
            else if (c == '\t') count += 4;
            else break;
        }
        return count;
    }
    
    private void processLine(String line, int lineNum) {
        if (line.isEmpty()) return;
        
        try {
            CharStream input = CharStreams.fromString(line);
            PythonSubsetLexer lexer = new PythonSubsetLexer(input);
            
            Token token;
            while ((token = lexer.nextToken()).getType() != EOF) {
                if (token.getChannel() == Token.DEFAULT_CHANNEL) {
                    tokens.offer(createTokenFromExisting(token, lineNum));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en línea " + lineNum + ": " + e.getMessage());
        }
    }
    
    private Token createToken(int type, String text) {
        CommonToken token = new CommonToken(type, text);
        token.setLine(1); // Línea por defecto
        token.setCharPositionInLine(0); // Posición por defecto
        return token;
    }
    
    private Token createTokenFromExisting(Token existing, int line) {
        CommonToken token = new CommonToken(existing.getType(), existing.getText());
        token.setLine(line);
        token.setCharPositionInLine(existing.getCharPositionInLine());
        return token;
    }
}