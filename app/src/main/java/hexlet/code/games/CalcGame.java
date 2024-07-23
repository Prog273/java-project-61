package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    static final int THREE = 3;
    static final int HUNDRED = 100;
    static String expression;
    static int result;

    public static void playCalcGame() {
        Scanner scanner = new Scanner(System.in);
        String userName = Engine.getUserName();
        System.out.println("What is the result of the expression?");

        for (int i = 0; i < THREE; i++) {
            generateOperation();
            System.out.println("Question: " + expression);
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

    public static void generateOperation() {
        String[] operands = {"+", "-", "*"};
        Random random = new Random();
        String randomOperand = operands[random.nextInt(operands.length)];
        int randomNumber1 = random.nextInt(HUNDRED) + 1;
        int randomNumber2 = random.nextInt(HUNDRED) + 1;
        expression = randomNumber1 + " " + randomOperand + " " + randomNumber2;
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
    }
}