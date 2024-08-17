import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameTask1 {
    // ANSI escape codes for colors
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        // Title
        System.out.println(GREEN + "🔢 Number Guessing Game 🔢" + RESET);
        System.out.println("========================================");
        System.out.println("💡 Guess the number between 1 and 100 💡");
        System.out.println("========================================");

        // Description
        System.out.println("This is a simple number guessing game where you need to guess the number that has been randomly generated.");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int guess = 0;
        boolean hasWon = false;

        // Game logic
        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            // Feedback on Guess
            if (guess < numberToGuess) {
                System.out.println(YELLOW + "⬇️ Too low! Try again." + RESET);
            } else if (guess > numberToGuess) {
                System.out.println(YELLOW + "⬆️ Too high! Try again." + RESET);
            } else {
                hasWon = true;
                break;
            }
        }

        // Game Result
        if (hasWon) {
            System.out.println(GREEN + "\n🎉 Congratulations! You've guessed the correct number in " + numberOfTries + " attempts." + RESET);
        } else {
            System.out.println(RED + "\n😢 Sorry! You've used all 7 attempts. The correct number was " + numberToGuess + "." + RESET);
        }

        System.out.println("========================================");
        System.out.println(GREEN + "✨ Made By Viraj Tupe ✨" + RESET);
        scanner.close();
    }
}
