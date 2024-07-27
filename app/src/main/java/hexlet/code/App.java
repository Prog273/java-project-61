package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    public static void main(String[] args) {
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
}
