package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

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

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String userName = Engine.getUserName();
        for (int i = 0; i < THREE; i++) {

        }
    }
}
