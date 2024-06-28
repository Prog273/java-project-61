package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class Engine {
    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n" + "2 - Even\n" + "3 - Calc\n"
                + "0 - Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                scanner.close();
                break;
            case 1:
                System.out.println("Your choice: " + choice);
                System.out.println("Welcome to the Brain Games!");
                Engine.getUserName();
                break;
            case 2:
                System.out.println("Your choice: " + choice);
                System.out.println("Welcome to the Brain Games!");
                Even.even();
                break;
            case 3:
                System.out.println("Your choice: " + choice);
                System.out.println("Welcome to the Brain Games!");
                Calc.calc();
                break;
        }
    }

    public static String userName;

    public static void getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        scanner.close();
    }
}
