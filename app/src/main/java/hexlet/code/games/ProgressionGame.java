package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class ProgressionGame {
    static final int THREE = 3;
    static final int TEN = 10;
    static final int HUNDRED = 100;
    private static String progressionWithMissedMember;
    private static Integer necessaryNumber;
    private static String initialQuestion;
    private static String question;
    private static String correctAnswer;

    public static void playProgressionGame() {
        initialQuestion = "What number is missing in the progression?";
        System.out.println(initialQuestion);
        ArrayList<String> gameData = new ArrayList<>();

        for (int i = 0; i < THREE; i++) {
            generateProgression();
            question = "Question: " + progressionWithMissedMember;
            correctAnswer = necessaryNumber.toString();
            gameData.add(question);
            gameData.add(correctAnswer);
        }
        Engine.playGame(gameData);
    }

    public static void generateProgression() {
        int numberOfElements = TEN;
        int[] elements = new int[numberOfElements];
        Random random = new Random();

        int firstElement = random.nextInt(HUNDRED) + 1;
        int difference = random.nextInt(TEN) + 1;
        elements[0] = firstElement;
        for (int k = 1; k < elements.length; k++) {
            elements[k] = elements[k - 1] + difference;
        }
        String[] elementsCopy = new String[numberOfElements];
        int index = random.nextInt(elementsCopy.length);
        necessaryNumber = elements[index];
        progressionWithMissedMember = "";
        for (int j = 0; j < elementsCopy.length; j++) {
            elementsCopy[j] = Integer.toString(elements[j]);
            elementsCopy[index] = "..";
            progressionWithMissedMember = progressionWithMissedMember + elementsCopy[j] + " ";
        }
    }
}
