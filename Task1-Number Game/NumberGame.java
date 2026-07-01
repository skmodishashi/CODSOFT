import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        char playAgain = 'y';
        int totalRoundsWon = 0;
        int roundNumber = 1;

        System.out.println("=========================================");
        System.out.println("        WELCOME TO NUMBER GUESS GAME");
        System.out.println("=========================================");

        while (playAgain == 'y' || playAgain == 'Y') {

            // step 1 - generate random number between 1 and 100
            int numberToGuess = rand.nextInt(100) + 1;

            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n----- Round " + roundNumber + " -----");
            System.out.println("I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // step 2,3,4 - take guesses and give feedback till correct or attempts finish
            while (attemptsUsed < maxAttempts && !guessedCorrectly) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsUsed++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    totalRoundsWon++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                int attemptsLeft = maxAttempts - attemptsUsed;
                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            // if user used all attempts without guessing
            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            // ask user to play again or not
            System.out.print("\nDo you want to play another round? (y/n): ");
            playAgain = sc.next().charAt(0);

            roundNumber++;
        }

        // step 7 - show score at the end
        System.out.println("\n=========================================");
        System.out.println("Game Over!");
        System.out.println("Total rounds played: " + (roundNumber - 1));
        System.out.println("Total rounds won: " + totalRoundsWon);
        System.out.println("=========================================");
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
