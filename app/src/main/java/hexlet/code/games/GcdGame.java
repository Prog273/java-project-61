package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.FIRST_ELEMENTS_NUMBER;
import static hexlet.code.Engine.SECOND_ELEMENTS_NUMBER;
import static hexlet.code.Engine.ROWS_NUMBER;

public class GcdGame {
    private static final int UPPER_BOUND = 101;
    private static final int LOWER_BOUND = 1;
    private static final String INITIAL_QUESTION = "Find the greatest common divisor of given numbers.";

    public static void playGcdGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];
        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            int randomNumber1 = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
            int randomNumber2 = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
            String question = "Question: " + randomNumber1 + " " + randomNumber2;
            Integer gcd = countGreatestCommonDivisor(randomNumber1, randomNumber2);
            String correctAnswer = gcd.toString();
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][SECOND_ELEMENTS_NUMBER] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
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
