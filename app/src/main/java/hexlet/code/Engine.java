package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    public static final int THREE = 3;
    private static String question;
    private static boolean checkingOfNumber;
    private static String answer;
    private static String correctAnswer;

    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void playGame(String[][] gameData) {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();

        for (int i = 0; i < THREE; i++) {
            question = gameData[i][ZERO];
            System.out.println(question);
            answer = scanner.next();
            System.out.println("Your answer: " + answer);
            correctAnswer = gameData[i][ONE];
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

    public static void playGame2(String[][] gameData) {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();

        for (int i = 0; i < THREE; i++) {
            question = gameData[i][ZERO];
            System.out.println(question);
            checkingOfNumber = stringToBoolean(gameData[i][ONE]);
            answer = scanner.next();
            System.out.println("Your answer: " + answer);
            if (checkingOfNumber && answer.equalsIgnoreCase("yes")
                    || !checkingOfNumber && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
            } else if (!checkingOfNumber && answer.equalsIgnoreCase("yes")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'"
                        + "\nLet's try again, " + userName + "!");
                break;
            } else if (checkingOfNumber && answer.equalsIgnoreCase("no")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'"
                        + "\nLet's try again, " + userName + "!");
                break;
            } else if (checkingOfNumber && !answer.equalsIgnoreCase("no")
                    && !answer.equalsIgnoreCase("yes")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'"
                        + "\nLet's try again, " + userName + "!");
                break;
            } else if (!checkingOfNumber && !answer.equalsIgnoreCase("no")
                    && !answer.equalsIgnoreCase("yes")) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'"
                        + "\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }

    public static boolean stringToBoolean(String str) {
        if (str.equalsIgnoreCase("true")) {
            return true;
        }
        return false;
    }
}
