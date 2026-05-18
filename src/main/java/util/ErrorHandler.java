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
    private final String[] sourceLines;

    public ErrorHandler(String sourceName) {
        this.sourceName = sourceName;
        this.sourceLines = null;
    }

    public ErrorHandler(String sourceName, String sourceText) {
        this.sourceName = sourceName;
        this.sourceLines = sourceText == null ? null : sourceText.split("\\r?\\n", -1);
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
        StringBuilder entry = new StringBuilder();
        entry.append("[").append(kind).append("] ")
                .append(source).append(":")
                .append(line).append(":")
                .append(column).append(" ")
                .append(message);

        String lineText = getLineText(line);
        if (lineText != null) {
            entry.append(System.lineSeparator())
                    .append("  > ")
                    .append(lineText);
        }

        errors.add(entry.toString());
    }

    private String getLineText(int line) {
        if (sourceLines == null || line <= 0 || line > sourceLines.length) {
            return null;
        }
        return sourceLines[line - 1];
    }
}
