package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.FIRST_ELEMENTS_NUMBER;
import static hexlet.code.Engine.SECOND_ELEMENTS_NUMBER;
import static hexlet.code.Engine.ROWS_NUMBER;

public class EvenGame {
    private static final int UPPER_BOUND = 101;
    private static final int LOWER_BOUND = 1;
    private static final String INITIAL_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEvenGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            int numberToCheck = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
            String question = "Question: " + numberToCheck;
            String correctAnswer;
            if (isNumberEven(numberToCheck)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][SECOND_ELEMENTS_NUMBER] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }
}
