package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class ProgressionGame {
    static final int THREE = 3;
    static final int TEN = 10;
    static final int HUNDRED = 100;
    static String question;
    static int necessaryNumber;

    public static void playProgressionGame() {
        String userName = Engine.getUserName();
        System.out.println("What number is missing in the progression?");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < THREE; i++) {
            generateProgression();
            System.out.println("Question: " + question);
            int answer = scanner.nextInt();
            System.out.println("Your answer: " + answer);
            if (answer == necessaryNumber) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + necessaryNumber + "'\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
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
        question = "";
        for (int j = 0; j < elementsCopy.length; j++) {
            elementsCopy[j] = Integer.toString(elements[j]);
            elementsCopy[index] = "..";
            question = question + elementsCopy[j] + " ";
        }
    }
}
