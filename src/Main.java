import Practices.BalancedExpression;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Declare variables
        Scanner scanner = new Scanner(System.in);
        int option;

       // Menu
        do {
            // define and validate var option
            option = 0;
            menu();
            try{
                option = scanner.nextInt();
            } catch (InputMismatchException ime){
                ime.printStackTrace();
            }

            // Actions according to option
            switch (option){
                case 1 -> {
                    System.out.println("""
                            ---------------------------
                            What is the expression?
                            """);
                    scanner.nextLine(); // Clear buffer
                    System.out.println(BalancedExpression.isBalanced(scanner.nextLine()));
                }

                case 2 -> {
                    option = -1;
                }
            }
        } while (option != -1);
    }
    public static  void menu(){
        System.out.println("""
                ----------MENU----------
                [1] isBalanced(String expression)
                [2] Leave
                """);
    }
}