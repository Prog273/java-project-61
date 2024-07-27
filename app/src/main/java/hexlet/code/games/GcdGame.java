package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class GcdGame {
    private static final int THREE = 3;
    private static final int HUNDRED = 100;

    public static void playGcdGame() {
        String initialQuestion;
        String question;
        String correctAnswer;

        initialQuestion = "Find the greatest common divisor of given numbers.";
        System.out.println(initialQuestion);
        ArrayList<String> gameData = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < THREE; i++) {
            int randomNumber1 = random.nextInt(HUNDRED) + 1;
            int randomNumber2 = random.nextInt(HUNDRED) + 1;
            question = "Question: " + randomNumber1 + " " + randomNumber2;
            Integer gcd = countGreatestCommonDivisor(randomNumber1, randomNumber2);
            correctAnswer = gcd.toString();
            gameData.add(question);
            gameData.add(correctAnswer);
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
