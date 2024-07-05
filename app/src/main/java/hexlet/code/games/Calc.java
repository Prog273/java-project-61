package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static int THREE = 3;
    public static int HUNDRED = 100;

    public static void playCalc() {
        String userName = Engine.getUserName();
        System.out.println("What is the result of the expression?");
        String[] operands = {"+", "-", "*"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < THREE; i++) {
            String randomOperand = operands[random.nextInt(operands.length)];
            int randomNumber1 = random.nextInt(HUNDRED) + 1;
            int randomNumber2 = random.nextInt(HUNDRED) + 1;
            String expression = randomNumber1 + " " + randomOperand + " " + randomNumber2;
            System.out.println("Question: " + expression);
            int result;
            switch (randomOperand) {
                case "+":
                    result = randomNumber1 + randomNumber2;
                    break;
                case "-":
                    result = randomNumber1 - randomNumber2;
                    break;
                case "*":
                    result = randomNumber1 * randomNumber2;
                    break;
                default:
                    result = 0;
            }
            int answer = scanner.nextInt();
            System.out.println("Your answer: " + answer);
            if (answer == result) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result
                        + "'\nLet's try again, " + userName + "!");
                break;
            }
            if (i == 2) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }
}
