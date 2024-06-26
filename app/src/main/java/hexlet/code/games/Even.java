package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void playEven() {
        String userName = Engine.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();

        int numberOfAttempts = 3;
        for (int i = 0; i < numberOfAttempts; i++) {
            int maxNumber = 100;
            int randomNumber = random.nextInt(maxNumber) + 1;
            System.out.println("Question: " + randomNumber);
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if (!isEven(randomNumber) && answer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'."
                        + "\nLet's try again, " + userName + "!");
                scanner.close();
                break;
            } else if (isEven(randomNumber) && answer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'."
                        + "\nLet's try again, " + userName + "!");
                scanner.close();
                break;
            } else if ((isEven(randomNumber) && answer.equals("yes"))
                    || (!isEven(randomNumber) && answer.equals("no"))) {
                System.out.println("Correct!");
            } else {
                System.out.println("wrong answer ;(.\nLet's try again, " + userName + "!");
                scanner.close();
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
