package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    static final int FIVE = 5;
    static final int SIX = 6;
    private static String question;
    private static boolean checkingOfNumber;
    private static String answer;
    private static String correctAnswer;

    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n" + "2 - Even\n" + "3 - Calc\n" + "4 - GCD\n"
                + "5 - Progression\n" + "6 - Prime\n" + "0 - Exit");
        int choice = scanner.nextInt();
        System.out.println("Your choice: " + choice);
        System.out.println("Welcome to the Brain Games!");
        switch (choice) {
            case ZERO:
                scanner.close();
                break;
            case ONE:
                Engine.getUserName();
                break;
            case TWO:
                EvenGame.playEvenGame();
                break;
            case THREE:
                CalcGame.playCalcGame();
                break;
            case FOUR:
                GcdGame.playGcdGame();
                break;
            case FIVE:
                ProgressionGame.playProgressionGame();
                break;
            case SIX:
                PrimeGame.playPrimeGame();
                break;
            default:
                scanner.close();
        }
    }

    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void playGame(ArrayList<String> gameData) {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();
        int index = 0;

        for (int i = 0; i < THREE; i++) {
            question = gameData.get(index);
            index++;
            System.out.println(question);
            answer = scanner.next();
            System.out.println("Your answer: " + answer);
            correctAnswer = gameData.get(index);
            index++;
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

    public static void playGame2(ArrayList<String> gameData) {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();
        int index = 0;

        for (int i = 0; i < THREE; i++) {
            question = gameData.get(index);
            index++;
            System.out.println(question);
            checkingOfNumber = stringToBoolean(gameData.get(index));
            index++;
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
