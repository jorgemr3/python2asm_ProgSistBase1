package util;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorHandler extends BaseErrorListener {
    private final List<String> errors = new ArrayList<>();
    private final String sourceName;

    public ErrorHandler(String sourceName) {
        this.sourceName = sourceName;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        String kind = (recognizer instanceof Lexer) ? "LEX" : "SYN";
        addError(kind, line, charPositionInLine + 1, msg);
    }

    public void reportIndentationError(int line, int column, String message) {
        addError("INDENT", line, column, message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public void printErrors() {
        for (String error : errors) {
            System.err.println(error);
        }
    }

    private void addError(String kind, int line, int column, String message) {
        String source = (sourceName == null || sourceName.trim().isEmpty())
                ? "<entrada>"
                : sourceName;
        errors.add("[" + kind + "] " + source + ":" + line + ":" + column + " " + message);
    }
}
