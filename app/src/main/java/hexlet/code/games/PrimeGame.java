package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class PrimeGame {
    static final int THREE = 3;
    static final int NINETY_NINE = 99;
    private static String initialQuestion;
    private static String question;

    public static void playPrimeGame() {
        initialQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        System.out.println(initialQuestion);
        Random random = new Random();
        ArrayList<String> gameData = new ArrayList<>();

        for (int i = 0; i < THREE; i++) {
            int numberToCheck = random.nextInt(NINETY_NINE) + 2;
            question = "Question: " + numberToCheck;
            gameData.add(question);
            String isPrime = ((Boolean) isNumberPrime(numberToCheck)).toString();
            gameData.add(isPrime);
        }
        Engine.playGame2(gameData);
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
