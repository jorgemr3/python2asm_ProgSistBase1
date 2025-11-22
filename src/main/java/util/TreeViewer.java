package util;

import parser.PythonSubsetLexer;
import parser.PythonSubsetParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class TreeViewer {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Uso: java util.TreeViewer <archivo.py>");
            System.exit(1);
        }

        String inputFile = args[0];
        String input = new String(Files.readAllBytes(Paths.get(inputFile)));

        // Preprocesamiento de indentacion y dedentacion (igual que en Main.java)
        CharStream processedInput = PythonIndentPreprocessor.preprocess(input);
        
        // Usar lexer estándar con contenido preprocesado
        PythonSubsetLexer lexer = new PythonSubsetLexer(processedInput);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonSubsetParser parser = new PythonSubsetParser(tokens);
        
        // Obtener el parse tree
        ParseTree tree = parser.prog();
        
        // Crear y mostrar el viewer GUI
        org.antlr.v4.gui.TreeViewer viewer = new org.antlr.v4.gui.TreeViewer(
            Arrays.asList(parser.getRuleNames()), 
            tree
        );
        
        JFrame frame = new JFrame("Parse Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(viewer);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}