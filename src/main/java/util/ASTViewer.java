package util;

import parser.PythonSubsetLexer;
import parser.PythonSubsetParser;
import parser.ASTBuilder;
import parser.ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ASTViewer {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Uso: java util.ASTViewer <archivo.py>");
            System.exit(1);
        }

        String inputFile = args[0];
        String input = new String(Files.readAllBytes(Paths.get(inputFile)));

        // Preprocesamiento de indentación y dedentación
        CharStream processedInput = PythonIndentPreprocessor.preprocess(input);
        
        // Crear lexer y parser
        PythonSubsetLexer lexer = new PythonSubsetLexer(processedInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        
        // Obtener el parse tree
        ParseTree tree = parser.prog();
        
        // Construir el AST
        ASTBuilder builder = new ASTBuilder();
        ASTNode ast = builder.visit(tree);
        
        // Crear el árbol visual del AST
        DefaultMutableTreeNode rootNode = buildTreeNode(ast);
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        JTree jTree = new JTree(treeModel);
        
        // Expandir todos los nodos
        for (int i = 0; i < jTree.getRowCount(); i++) {
            jTree.expandRow(i);
        }
        
        // Crear y configurar la ventana
        JFrame frame = new JFrame("AST Viewer - " + inputFile);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear panel con scroll
        JScrollPane scrollPane = new JScrollPane(jTree);
        frame.add(scrollPane);
        
        // Configurar tamaño y mostrar
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static DefaultMutableTreeNode buildTreeNode(ASTNode node) {
        if (node == null) {
            return new DefaultMutableTreeNode("null");
        }
        
        DefaultMutableTreeNode treeNode;
        
        if (node instanceof ProgNode) {
            ProgNode prog = (ProgNode) node;
            treeNode = new DefaultMutableTreeNode("Program");
            for (ASTNode stmt : prog.getStatements()) {
                treeNode.add(buildTreeNode(stmt));
            }
        } else if (node instanceof AssignNode) {
            AssignNode assign = (AssignNode) node;
            treeNode = new DefaultMutableTreeNode("Assign: " + assign.getName());
            treeNode.add(buildTreeNode(assign.getExpr()));
        } else if (node instanceof ExprStmtNode) {
            ExprStmtNode exprStmt = (ExprStmtNode) node;
            treeNode = new DefaultMutableTreeNode("ExprStmt");
            treeNode.add(buildTreeNode(exprStmt.getExpr()));
        } else if (node instanceof BinaryOpNode) {
            BinaryOpNode binOp = (BinaryOpNode) node;
            treeNode = new DefaultMutableTreeNode("BinaryOp: " + binOp.getOp());
            treeNode.add(buildTreeNode(binOp.getLeft()));
            treeNode.add(buildTreeNode(binOp.getRight()));
        } else if (node instanceof UnaryOpNode) {
            UnaryOpNode unaryOp = (UnaryOpNode) node;
            treeNode = new DefaultMutableTreeNode("UnaryOp: " + unaryOp.getOp());
            treeNode.add(buildTreeNode(unaryOp.getOperand()));
        } else if (node instanceof IntNode) {
            IntNode intNode = (IntNode) node;
            treeNode = new DefaultMutableTreeNode("Int: " + intNode.getValue());
        } else if (node instanceof BoolNode) {
            BoolNode boolNode = (BoolNode) node;
            treeNode = new DefaultMutableTreeNode("Bool: " + boolNode.getValue());
        } else if (node instanceof StringNode) {
            StringNode strNode = (StringNode) node;
            treeNode = new DefaultMutableTreeNode("String: \"" + strNode.getValue() + "\"");
        } else if (node instanceof VarRefNode) {
            VarRefNode varRef = (VarRefNode) node;
            treeNode = new DefaultMutableTreeNode("VarRef: " + varRef.getName());
        } else if (node instanceof FuncCallNode) {
            FuncCallNode funcCall = (FuncCallNode) node;
            treeNode = new DefaultMutableTreeNode("FuncCall: " + funcCall.getName());
            for (ASTNode arg : funcCall.getArgs()) {
                treeNode.add(buildTreeNode(arg));
            }
        } else if (node instanceof ForNode) {
            ForNode forNode = (ForNode) node;
            treeNode = new DefaultMutableTreeNode("For: " + forNode.getVariable());
            
            DefaultMutableTreeNode iterableNode = new DefaultMutableTreeNode("Iterable");
            iterableNode.add(buildTreeNode(forNode.getIterable()));
            treeNode.add(iterableNode);
            
            DefaultMutableTreeNode bodyNode = new DefaultMutableTreeNode("Body");
            for (ASTNode stmt : forNode.getBody()) {
                bodyNode.add(buildTreeNode(stmt));
            }
            treeNode.add(bodyNode);
        } else if (node instanceof WhileNode) {
            WhileNode whileNode = (WhileNode) node;
            treeNode = new DefaultMutableTreeNode("While");
            
            DefaultMutableTreeNode condNode = new DefaultMutableTreeNode("Condition");
            condNode.add(buildTreeNode(whileNode.getCondition()));
            treeNode.add(condNode);
            
            DefaultMutableTreeNode bodyNode = new DefaultMutableTreeNode("Body");
            for (ASTNode stmt : whileNode.getBody()) {
                bodyNode.add(buildTreeNode(stmt));
            }
            treeNode.add(bodyNode);
        } else if (node instanceof IfNode) {
            IfNode ifNode = (IfNode) node;
            treeNode = new DefaultMutableTreeNode("If");
            
            DefaultMutableTreeNode condNode = new DefaultMutableTreeNode("Condition");
            condNode.add(buildTreeNode(ifNode.getCondition()));
            treeNode.add(condNode);
            
            DefaultMutableTreeNode thenNode = new DefaultMutableTreeNode("Then");
            for (ASTNode stmt : ifNode.getThenBody()) {
                thenNode.add(buildTreeNode(stmt));
            }
            treeNode.add(thenNode);
            
            // Agregar elif clauses
            for (int i = 0; i < ifNode.getElifClauses().size(); i++) {
                IfNode.ElifClause elifClause = ifNode.getElifClauses().get(i);
                DefaultMutableTreeNode elifNode = new DefaultMutableTreeNode("Elif " + (i + 1));
                
                DefaultMutableTreeNode elifCondNode = new DefaultMutableTreeNode("Condition");
                elifCondNode.add(buildTreeNode(elifClause.getCondition()));
                elifNode.add(elifCondNode);
                
                DefaultMutableTreeNode elifBodyNode = new DefaultMutableTreeNode("Body");
                for (ASTNode stmt : elifClause.getBody()) {
                    elifBodyNode.add(buildTreeNode(stmt));
                }
                elifNode.add(elifBodyNode);
                
                treeNode.add(elifNode);
            }
            
            // Agregar else clause si existe
            if (ifNode.getElseBody() != null) {
                DefaultMutableTreeNode elseNode = new DefaultMutableTreeNode("Else");
                for (ASTNode stmt : ifNode.getElseBody()) {
                    elseNode.add(buildTreeNode(stmt));
                }
                treeNode.add(elseNode);
            }
        } else if (node instanceof RangeNode) {
            RangeNode rangeNode = (RangeNode) node;
            treeNode = new DefaultMutableTreeNode("Range");
            for (int i = 0; i < rangeNode.getArgs().size(); i++) {
                String argName = i == 0 ? "start" : i == 1 ? "stop" : "step";
                if (rangeNode.getArgs().size() == 1) {
                    argName = "stop";
                } else if (rangeNode.getArgs().size() == 2) {
                    argName = i == 0 ? "start" : "stop";
                }
                DefaultMutableTreeNode argNode = new DefaultMutableTreeNode(argName);
                argNode.add(buildTreeNode(rangeNode.getArgs().get(i)));
                treeNode.add(argNode);
            }
        } else {
            treeNode = new DefaultMutableTreeNode("Unknown: " + node.getClass().getSimpleName());
        }
        
        return treeNode;
    }
}
