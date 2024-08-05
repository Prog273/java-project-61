package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.FIRST_ELEMENTS_NUMBER;
import static hexlet.code.Engine.SECOND_ELEMENTS_NUMBER;
import static hexlet.code.Engine.ROWS_NUMBER;

public class PrimeGame {
    private static final int HUNDRED_AND_ONE = 101;
    private static final int ONE = 1;
    private static final String INITIAL_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void playPrimeGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            int numberToCheck = Utils.getRandomInt(ONE, HUNDRED_AND_ONE);
            String question = "Question: " + numberToCheck;
            String correctAnswer;
            if (isNumberPrime(numberToCheck)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][SECOND_ELEMENTS_NUMBER] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
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
