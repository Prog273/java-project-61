package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

import static hexlet.code.Engine.THREE;

public class EvenGame {
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void playEvenGame() {
        String initialQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(initialQuestion);
        Random random = new Random();
        String[][] gameData = new String[THREE][TWO];

        for (int i = 0; i < THREE; i++) {
            int numberToCheck = random.nextInt(HUNDRED) + 1;
            String question = "Question: " + numberToCheck;
            gameData[i][ZERO] = question;
            String isEven = ((Boolean) isNumberEven(numberToCheck)).toString();
            gameData[i][ONE] = isEven;
        }
        Engine.playGame2(gameData);
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }
}
