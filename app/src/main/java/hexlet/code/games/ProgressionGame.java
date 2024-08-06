package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.FIRST_ELEMENTS_NUMBER;
import static hexlet.code.Engine.SECOND_ELEMENTS_NUMBER;
import static hexlet.code.Engine.ROWS_NUMBER;

public class ProgressionGame {
    private static final int TEN = 10;
    private static final int ELEVEN = 11;
    private static final int UPPER_BOUND = 101;
    private static final int LOWER_BOUND = 1;
    private static final String INITIAL_QUESTION = "What number is missing in the progression?";

    public static void playProgressionGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];
        int numberOfElements = TEN;

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            int firstElement = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
            int difference = Utils.getRandomInt(LOWER_BOUND, ELEVEN);
            int[] elements = generateProgression(numberOfElements, firstElement, difference);
            String[] progressionWithMissedMemberAndNecessaryNumber = generateProgressionWithMissedElement(elements);
            String progressionWithMissedMember = progressionWithMissedMemberAndNecessaryNumber[FIRST_ELEMENTS_NUMBER];
            Integer necessaryNumber
                    = Integer.valueOf(progressionWithMissedMemberAndNecessaryNumber[SECOND_ELEMENTS_NUMBER]);
            String question = "Question: " + progressionWithMissedMember;
            String correctAnswer = necessaryNumber.toString();
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][SECOND_ELEMENTS_NUMBER] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
    }

    public static int[] generateProgression(int numberOfElements, int firstElement, int difference) {
        int[] elements = new int[numberOfElements];
        elements[0] = firstElement;
        for (int i = 1; i < elements.length; i++) {
            elements[i] = elements[i - 1] + difference;
        }
        return elements;
    }

    public static String[] generateProgressionWithMissedElement(int[] elements) {
        String[] elementsCopy = new String[elements.length];
        int index = Utils.getRandomInt(elementsCopy.length);
        Integer necessaryNumber = elements[index];
        String progressionWithMissedMember = "";

        for (int i = 0; i < elementsCopy.length; i++) {
            elementsCopy[i] = Integer.toString(elements[i]);
            elementsCopy[index] = "..";
            progressionWithMissedMember = progressionWithMissedMember + elementsCopy[i] + " ";
        }
        String[] progressionWithMissedMemberAndNecessaryNumber
                = {progressionWithMissedMember, necessaryNumber.toString()};
        return progressionWithMissedMemberAndNecessaryNumber;
    }
}
