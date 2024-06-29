package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void even() {
        String userName = Engine.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(100) + 1;
            System.out.println("Question: " + randomNumber);
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if (answer.equals("yes") && randomNumber % 2 != 0) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'."
                        + "\nLet's try again, " + userName + "!");
                scanner.close();
                break;
            } else if (answer.equals("no") && randomNumber % 2 == 0) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'."
                        + "\nLet's try again, " + userName + "!");
                scanner.close();
                break;
            } else if ((answer.equals("yes") && randomNumber % 2 == 0)
                    || (answer.equals("no") && randomNumber % 2 != 0)) {
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
}
