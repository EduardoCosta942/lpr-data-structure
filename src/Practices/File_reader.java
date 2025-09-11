package Practices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class File_reader {
    public static void main(String[] args) {
        try{
            identifyBalanced(new File("src/Practices/text_files/Expressions"), new File("src/Practices/text_files/Result"));
        } catch (IOException ioe){
            System.out.println("The path is incorrect or inexistent");
        }
    }
    public static void identifyBalanced(File toRead, File toWrite) throws IOException {
        // Declare variables
        List<String> balancedExList = new LinkedList<>();
        List<String> unbalancedExList = new LinkedList<>();
        Scanner reader = new Scanner(toRead);
        FileWriter writer = new FileWriter(toWrite);

        // Read and put expressions into lists.
        while (reader.hasNextLine()){
            String expression = reader.nextLine();
            if (MathematicalExpressions.isBalanced(expression)){
                balancedExList.add(expression);
            } else {
                unbalancedExList.add(expression);
            }
        }
        reader.close();

        // Write expressions
        for (String expression:balancedExList){
            writer.write(expression + "| Balanced\n");
        }
        for (String expression:unbalancedExList){
            writer.write(expression + "| Unbalanced\n");
        }
        writer.close();
    }
}
