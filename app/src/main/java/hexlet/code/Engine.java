package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class Engine {
    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n" + "2 - Even\n" + "3 - Calc\n" + "4 - GCD\n"
                + "5 - Progression\n" + "6 - Prime\n" + "0 - Exit");
        int choice = scanner.nextInt();
        System.out.println("Your choice: " + choice);
        System.out.println("Welcome to the Brain Games!");
        switch (choice) {
            case 0:
                scanner.close();
                break;
            case 1:
                Engine.getUserName();
                break;
            case 2:
                Even.playEven();
                break;
            case 3:
                Calc.playCalc();
                break;
            case 4:
                GCD.playGCD();
                break;
            case 5:
                Progression.playProgression();
                break;
            case 6:
                Prime.playPrime();
                break;
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
