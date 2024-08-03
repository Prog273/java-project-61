package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.*;

public class CalcGame {
    private static final int HUNDRED_AND_ONE = 101;
    private static final int ONE = 1;
    private static final String INITIAL_QUESTION = "What is the result of the expression?";

    public static void playCalcGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            generateOperation();
            String[] expressionAndResult = generateOperation();
            String expression = expressionAndResult[FIRST_ELEMENTS_NUMBER];
            Integer result = Integer.valueOf(expressionAndResult[ONE]);
            String question = "Question: " + expression;
            String correctAnswer = result.toString();
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][ONE] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
    }

    public static String[] generateOperation() {
        String[] operands = {"+", "-", "*"};
        String randomOperand = operands[Utils.getRandomInt(operands.length)];
        int randomNumber1 = Utils.getRandomInt(ONE,HUNDRED_AND_ONE);
        int randomNumber2 = Utils.getRandomInt(ONE,HUNDRED_AND_ONE);
        String expression = randomNumber1 + " " + randomOperand + " " + randomNumber2;
        Integer result = solveProblem(randomNumber1, randomNumber2, randomOperand);
        String[] expressionAndResult = {expression, result.toString()};
        return expressionAndResult;
    }

    public static Integer solveProblem(int number1, int number2, String operand) {
        Integer resultOfOperation;
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
                resultOfOperation = null;
        }
        return resultOfOperation;
    }
}
