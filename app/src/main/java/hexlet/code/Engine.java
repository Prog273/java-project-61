package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int FIRST_ELEMENTS_NUMBER = 0;
    public static final int SECOND_ELEMENTS_NUMBER = 1;
    public static final int ROWS_NUMBER = 2;
    public static final int ROUNDS_NUMBER = 3;

    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void playGame(String initialQuestion, String[][] gameData) {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();
        System.out.println(initialQuestion);

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            String question = gameData[i][FIRST_ELEMENTS_NUMBER];
            System.out.println(question);
            String answer = scanner.next();
            System.out.println("Your answer: " + answer);
            String correctAnswer = gameData[i][SECOND_ELEMENTS_NUMBER];
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer
                        + "'\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }
}
