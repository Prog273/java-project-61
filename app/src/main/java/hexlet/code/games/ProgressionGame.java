package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.THREE;


public class ProgressionGame {
    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static String progressionWithMissedMember;
    private static Integer necessaryNumber;

    public static void playProgressionGame() {
        String initialQuestion = "What number is missing in the progression?";
        System.out.println(initialQuestion);
        String[][] gameData = new String[THREE][TWO];
        int numberOfElements = TEN;
        Random random = new Random();

        for (int i = 0; i < THREE; i++) {
            int firstElement = random.nextInt(HUNDRED) + 1;
            int difference = random.nextInt(TEN) + 1;

            int[] elements = generateProgression(numberOfElements, firstElement, difference);
            generateProgressionWithMissedElement(elements);
            String question = "Question: " + progressionWithMissedMember;
            String correctAnswer = necessaryNumber.toString();
            gameData[i][ZERO] = question;
            gameData[i][ONE] = correctAnswer;
        }
        Engine.playGame(gameData);
    }


    public static int[] generateProgression(int numberOfElements, int firstElement, int difference) {
        Random random = new Random();
        int[] elements = new int[numberOfElements];
        elements[0] = firstElement;
        for (int k = 1; k < elements.length; k++) {
            elements[k] = elements[k - 1] + difference;
        }
        return elements;
    }

    public static void generateProgressionWithMissedElement(int[] elements) {
        Random random = new Random();
        String[] elementsCopy = new String[elements.length];
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
