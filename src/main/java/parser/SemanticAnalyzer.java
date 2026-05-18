package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import parser.ast.*;

public class SemanticAnalyzer implements ASTVisitor<SemanticAnalyzer.ValueType> {
    public enum ValueType {
        INT,
        BOOL,
        STRING,
        UNKNOWN
    }

    private final Map<String, ValueType> varTypes = new HashMap<>();
    private final Set<String> definedVars = new HashSet<>();
    private final List<String> errors = new ArrayList<>();

    public boolean analyze(ASTNode root) {
        root.accept(this);
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    private void addError(String message) {
        errors.add("[SEMANTIC] " + message);
    }

    private boolean isUnknown(ValueType type) {
        return type == ValueType.UNKNOWN;
    }

    private boolean isInt(ValueType type) {
        return type == ValueType.INT;
    }

    private boolean isBool(ValueType type) {
        return type == ValueType.BOOL;
    }

    private ValueType expectIntBinary(String op, ValueType left, ValueType right) {
        if (isUnknown(left) || isUnknown(right)) {
            return ValueType.UNKNOWN;
        }
        if (!isInt(left) || !isInt(right)) {
            addError("Operador '" + op + "' requiere INT e INT");
            return ValueType.UNKNOWN;
        }
        return ValueType.INT;
    }

    private ValueType expectBoolBinary(String op, ValueType left, ValueType right) {
        if (isUnknown(left) || isUnknown(right)) {
            return ValueType.UNKNOWN;
        }
        if (!isBool(left) || !isBool(right)) {
            addError("Operador '" + op + "' requiere BOOL y BOOL");
            return ValueType.UNKNOWN;
        }
        return ValueType.BOOL;
    }

    @Override
    public ValueType visit(ProgNode node) {
        for (ASTNode stmt : node.getStatements()) {
            stmt.accept(this);
        }
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(AssignNode node) {
        ValueType exprType = node.getExpr().accept(this);
        definedVars.add(node.getName());
        varTypes.put(node.getName(), exprType);
        return exprType;
    }

    @Override
    public ValueType visit(ExprStmtNode node) {
        node.getExpr().accept(this);
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(BinaryOpNode node) {
        ValueType left = node.getLeft().accept(this);
        ValueType right = node.getRight().accept(this);
        String op = node.getOp();

        switch (op) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "**":
                return expectIntBinary(op, left, right);
            case "<":
            case ">":
            case "<=":
            case ">=":
                if (isUnknown(left) || isUnknown(right)) {
                    return ValueType.UNKNOWN;
                }
                if (!isInt(left) || !isInt(right)) {
                    addError("Comparacion '" + op + "' requiere INT e INT");
                    return ValueType.UNKNOWN;
                }
                return ValueType.BOOL;
            case "==":
            case "!=":
                if (isUnknown(left) || isUnknown(right)) {
                    return ValueType.UNKNOWN;
                }
                if (left != right) {
                    addError("Comparacion '" + op + "' requiere tipos compatibles");
                    return ValueType.UNKNOWN;
                }
                return ValueType.BOOL;
            case "and":
            case "or":
                return expectBoolBinary(op, left, right);
            default:
                addError("Operador no soportado: " + op);
                return ValueType.UNKNOWN;
        }
    }

    @Override
    public ValueType visit(UnaryOpNode node) {
        ValueType operand = node.getOperand().accept(this);
        String op = node.getOp();

        if (isUnknown(operand)) {
            return ValueType.UNKNOWN;
        }

        switch (op) {
            case "+":
            case "-":
                if (!isInt(operand)) {
                    addError("Operador unario '" + op + "' requiere INT");
                    return ValueType.UNKNOWN;
                }
                return ValueType.INT;
            case "not":
                if (!isBool(operand)) {
                    addError("Operador unario 'not' requiere BOOL");
                    return ValueType.UNKNOWN;
                }
                return ValueType.BOOL;
            default:
                addError("Operador unario no soportado: " + op);
                return ValueType.UNKNOWN;
        }
    }

    @Override
    public ValueType visit(IntNode node) {
        return ValueType.INT;
    }

    @Override
    public ValueType visit(BoolNode node) {
        return ValueType.BOOL;
    }

    @Override
    public ValueType visit(VarRefNode node) {
        String name = node.getName();
        if (!definedVars.contains(name)) {
            addError("Variable no definida: " + name);
            return ValueType.UNKNOWN;
        }
        return varTypes.getOrDefault(name, ValueType.UNKNOWN);
    }

    @Override
    public ValueType visit(FuncCallNode node) {
        if ("print".equals(node.getName())) {
            List<ASTNode> args = node.getArgs();
            if (args.size() != 1) {
                addError("print() solo acepta un argumento");
                return ValueType.UNKNOWN;
            }
            args.get(0).accept(this);
            return ValueType.INT;
        }

        addError("Funcion no soportada: " + node.getName());
        for (ASTNode arg : node.getArgs()) {
            arg.accept(this);
        }
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(parser.ast.StringNode node) {
        return ValueType.STRING;
    }

    @Override
    public ValueType visit(ForNode node) {
        if (!(node.getIterable() instanceof RangeNode)) {
            addError("Solo se soporta range() en ciclos for");
        } else {
            node.getIterable().accept(this);
        }

        definedVars.add(node.getVariable());
        varTypes.put(node.getVariable(), ValueType.INT);
        for (ASTNode stmt : node.getBody()) {
            stmt.accept(this);
        }
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(WhileNode node) {
        ValueType conditionType = node.getCondition().accept(this);
        if (!isUnknown(conditionType) && !(isBool(conditionType) || isInt(conditionType))) {
            addError("Condicion de while debe ser BOOL o INT");
        }
        for (ASTNode stmt : node.getBody()) {
            stmt.accept(this);
        }
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(IfNode node) {
        ValueType conditionType = node.getCondition().accept(this);
        if (!isUnknown(conditionType) && !(isBool(conditionType) || isInt(conditionType))) {
            addError("Condicion de if debe ser BOOL o INT");
        }

        for (ASTNode stmt : node.getThenBody()) {
            stmt.accept(this);
        }

        for (IfNode.ElifClause elifClause : node.getElifClauses()) {
            ValueType elifType = elifClause.getCondition().accept(this);
            if (!isUnknown(elifType) && !(isBool(elifType) || isInt(elifType))) {
                addError("Condicion de elif debe ser BOOL o INT");
            }
            for (ASTNode stmt : elifClause.getBody()) {
                stmt.accept(this);
            }
        }

        if (node.getElseBody() != null) {
            for (ASTNode stmt : node.getElseBody()) {
                stmt.accept(this);
            }
        }
        return ValueType.UNKNOWN;
    }

    @Override
    public ValueType visit(RangeNode node) {
        for (ASTNode arg : node.getArgs()) {
            ValueType argType = arg.accept(this);
            if (isUnknown(argType)) {
                continue;
            }
            if (!isInt(argType)) {
                addError("range() solo acepta argumentos INT");
            }
            if (!(arg instanceof IntNode)) {
                addError("range() solo acepta enteros literales");
            }
        }
        return ValueType.UNKNOWN;
    }
}
