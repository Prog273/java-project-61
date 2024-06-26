package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    public static void playPrime() {
        String userName = Engine.getUserName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberOfAttempts = 3;
        for (int i = 0; i < numberOfAttempts; i++) {
            int numberToCheck = random.nextInt(99) + 2;
            System.out.println("Question: " + numberToCheck);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if ((isNumberPrime(numberToCheck) && answer.equals("yes"))
                    || (!isNumberPrime(numberToCheck) && answer.equals("no"))) {
                System.out.println("Correct!");
            } else if (isNumberPrime(numberToCheck) && answer.equals("no")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'"
                        + "\nLet's try again, " + userName + "!");
                break;
            } else if (!isNumberPrime(numberToCheck) && answer.equals("yes")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'"
                        + "\nLet's try again, " + userName + "!");
                break;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(."
                        + "\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static boolean isNumberPrime(int number) {
        if (number == 1) {
            return false;
        }
        int divider = 2;
        while (Math.pow(divider, 2) <= number) {
            if (number % divider == 0) {
                return false;
            }
            divider++;
        }
        return true;
    }
}
