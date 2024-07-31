package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.THREE;

public class GcdGame {
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void playGcdGame() {
        String initialQuestion = "Find the greatest common divisor of given numbers.";
        System.out.println(initialQuestion);
        String[][] gameData = new String[THREE][TWO];
        Random random = new Random();
        for (int i = 0; i < THREE; i++) {
            int randomNumber1 = random.nextInt(HUNDRED) + 1;
            int randomNumber2 = random.nextInt(HUNDRED) + 1;
            String question = "Question: " + randomNumber1 + " " + randomNumber2;
            Integer gcd = countGreatestCommonDivisor(randomNumber1, randomNumber2);
            String correctAnswer = gcd.toString();
            gameData[i][ZERO] = question;
            gameData[i][ONE] = correctAnswer;
        }
        Engine.playGame(gameData);
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
