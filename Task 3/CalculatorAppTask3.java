import java.util.Scanner;

public class CalculatorAppTask3 {
    // ANSI escape codes for colors
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // Title
        System.out.println("==================================");
        System.out.println("🧮 CALCULATOR APP 🧮");
        System.out.println("==================================");

        // Description
        System.out.println("Perform basic arithmetic operations easily and quickly!");

        Scanner scanner = new Scanner(System.in);

        // Input Numbers
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Input Operator
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;
        boolean validOperation = true;

        try {
            // Arithmetic Operations
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println(RED + "❌ Invalid operator. Please use +, -, *, or /." + RESET);
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println(GREEN + "Result: " + result + RESET);
            }
        } catch (ArithmeticException e) {
            System.out.println(RED + "Error: " + e.getMessage() + RESET);
        }

        System.out.println("==================================");
        System.out.println("✨ Made By Viraj Tupe ✨");
        scanner.close();
    }
}
