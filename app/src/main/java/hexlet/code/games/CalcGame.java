package hexlet.code.games;

import hexlet.code.Engine;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;
import java.util.Random;

import static hexlet.code.Engine.THREE;

public class CalcGame {
    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static String expression;
    private static Integer result;

    public static void playCalcGame() {
        String initialQuestion = "What is the result of the expression?";
        System.out.println(initialQuestion);
        String[][] gameData = new String[THREE][TWO];

        for (int i = 0; i < THREE; i++) {
            generateOperation();
            String question = "Question: " + expression;
            String correctAnswer = result.toString();
            gameData[i][ZERO] = question;
            gameData[i][ONE] = correctAnswer;
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
        int resultOfOperation;
        switch (operand) {
            case "+":
                resultOfOperation = number1 + number2;
                break;
            case "-":
                resultOfOperation = number1 - number2;
                break;
            case "*":
                resultOfOperation = number1 * number2;
                break;
            default:
                resultOfOperation = 0;
        }
        return resultOfOperation;
    }
}
