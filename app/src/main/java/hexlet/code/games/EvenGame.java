package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    static final int THREE = 3;
    static final int HUNDRED = 100;
    public static void playEvenGame() {
        String userName = Engine.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();

        for (int i = 0; i < THREE; i++) {
            int randomNumber = random.nextInt(HUNDRED) + 1;
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
