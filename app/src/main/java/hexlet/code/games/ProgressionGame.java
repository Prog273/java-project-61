package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class ProgressionGame {
    private static final int THREE = 3;
    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static String progressionWithMissedMember;
    private static Integer necessaryNumber;

    public static void playProgressionGame() {
        String initialQuestion;
        String question;
        String correctAnswer;

        initialQuestion = "What number is missing in the progression?";
        System.out.println(initialQuestion);
        ArrayList<String> gameData = new ArrayList<>();
        int numberOfElements = TEN;
        Random random = new Random();

        for (int i = 0; i < THREE; i++) {
            int firstElement = random.nextInt(HUNDRED) + 1;
            int difference = random.nextInt(TEN) + 1;

            generateProgression(numberOfElements, firstElement, difference);
            question = "Question: " + progressionWithMissedMember;
            correctAnswer = necessaryNumber.toString();
            gameData.add(question);
            gameData.add(correctAnswer);
        }
        Engine.playGame(gameData);
    }


    public static void generateProgression(int numberOfElements, int firstElement, int difference) {
        Random random = new Random();
        int[] elements = new int[numberOfElements];
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

