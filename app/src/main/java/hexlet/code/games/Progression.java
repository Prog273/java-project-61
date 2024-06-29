package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    public static void progression() {
        String userName = Engine.getUserName();
        System.out.println("What number is missing in the progression?");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int[] elements = new int[10];
            int firstElement = random.nextInt(100) + 1;
            int difference = random.nextInt(10) + 1;
            elements[0] = firstElement;
            for (int k = 1; k < elements.length; k++) {
                elements[k] = elements[k - 1] + difference;
            }
            String[] elementsCopy = new String[10];
            int index = random.nextInt(10);
            int necessaryNumber = elements[index];
            String question = "";
            for (int j = 0; j < elementsCopy.length; j++) {
                elementsCopy[j] = Integer.toString(elements[j]);
                elementsCopy[index] = "..";
                question = question + elementsCopy[j] + " ";
            }
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
}
