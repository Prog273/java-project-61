package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class EvenGame {
    static final int THREE = 3;
    static final int HUNDRED = 100;
    private static String initialQuestion;
    private static String question;

    public static void playEvenGame() {
        initialQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println(initialQuestion);
        Random random = new Random();
        ArrayList<String> gameData = new ArrayList<>();

        for (int i = 0; i < THREE; i++) {
            int numberToCheck = random.nextInt(HUNDRED) + 1;
            question = "Question: " + numberToCheck;
            gameData.add(question);
            String isEven = ((Boolean) isNumberEven(numberToCheck)).toString();
            gameData.add(isEven);
        }
        Engine.playGame2(gameData);
    }

    public static boolean isNumberEven(int number) {
        return number % 2 == 0;
    }
}
