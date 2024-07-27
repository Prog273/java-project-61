package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Random;

public class CalcGame {
    static final int THREE = 3;
    static final int HUNDRED = 100;
    private static String expression;
    private static Integer result;

    public static void playCalcGame() {
        String initialQuestion;
        String question;
        String correctAnswer;
        initialQuestion = "What is the result of the expression?";
        System.out.println(initialQuestion);
        ArrayList<String> gameData = new ArrayList<>();

        for (int i = 0; i < THREE; i++) {
            generateOperation();
            question = "Question: " + expression;
            correctAnswer = result.toString();
            gameData.add(question);
            gameData.add(correctAnswer);
        }
        Engine.playGame(gameData);
    }

    public static void generateOperation() {
        String[] operands = {"+", "-", "*"};
        Random random = new Random();
        String randomOperand = operands[random.nextInt(operands.length)];
        int randomNumber1 = random.nextInt(HUNDRED) + 1;
        int randomNumber2 = random.nextInt(HUNDRED) + 1;
        expression = randomNumber1 + " " + randomOperand + " " + randomNumber2;
        result = solveProblem(randomNumber1, randomNumber2, randomOperand);
    }

    public static Integer solveProblem(int number1, int number2, String operand) {
        int result;
        switch (operand) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
