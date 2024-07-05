package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    final static int ZERO = 0;
    final static int ONE = 1;
    final static int TWO = 2;
    final static int THREE = 3;
    final static int FOUR = 4;
    final static int FIVE = 5;
    final static int SIX = 6;

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
                Even.playEven();
                break;
            case THREE:
                Calc.playCalc();
                break;
            case FOUR:
                GCD.playGCD();
                break;
            case FIVE:
                Progression.playProgression();
                break;
            case SIX:
                Prime.playPrime();
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
}
