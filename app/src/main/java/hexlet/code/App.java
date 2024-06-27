package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" + "2 - Even\n" +
                "0 - Exit");
        int choice = scanner.nextInt();
        if (choice == 0) {
            scanner.close();
        } else if (choice == 1) {
            System.out.println("Your choice: " + choice);
            System.out.println("Welcome to the Brain Games!");
            Cli.getUserName();
        } else if (choice == 2) {
            System.out.println("Your choice: " + choice);
            System.out.println("Welcome to the Brain Games!");
            Even.even();
        }
    }
}
