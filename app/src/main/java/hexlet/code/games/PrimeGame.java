package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.THREE;

public class PrimeGame {
    private static final int NINETY_NINE = 99;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void playPrimeGame() {
        String initialQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        System.out.println(initialQuestion);
        Random random = new Random();
        String[][] gameData = new String[THREE][TWO];

        for (int i = 0; i < THREE; i++) {
            int numberToCheck = random.nextInt(NINETY_NINE) + 2;
            String question = "Question: " + numberToCheck;
            String correctAnswer;
            if (isNumberPrime(numberToCheck)) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            gameData[i][ZERO] = question;
            gameData[i][ONE] = correctAnswer;
        }
        Engine.playGame(gameData);
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
