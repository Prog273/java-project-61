package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    public static void playGCD() {
        String userName = Engine.getUserName();
        System.out.println("Find the greatest common divisor of given numbers.");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberOfAttempts = 3;
        for (int i = 0; i < numberOfAttempts; i++) {
            int maxNumber = 100;
            int randomNumber1 = random.nextInt(maxNumber) + 1;
            int randomNumber2 = random.nextInt(maxNumber) + 1;
            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            int gcd = countGreatestCommonDivisor(randomNumber1, randomNumber2);
            int answer = scanner.nextInt();
            System.out.println("Your answer: " + answer);
            if (answer == gcd) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + gcd
                        + "'\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static int countGreatestCommonDivisor(int a, int b) {
        while (a != 0 && b != 0) {
            if (a == b) {
                return a;
            }
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        int greatestCommonDivisor = a + b;
        return greatestCommonDivisor;
    }
}
