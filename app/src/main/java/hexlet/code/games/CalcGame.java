package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS_NUMBER;
import static hexlet.code.Engine.FIRST_ELEMENTS_NUMBER;
import static hexlet.code.Engine.SECOND_ELEMENTS_NUMBER;
import static hexlet.code.Engine.ROWS_NUMBER;

public class CalcGame {
    private static final int UPPER_BOUND = 101;
    private static final int LOWER_BOUND = 1;
    private static final String INITIAL_QUESTION = "What is the result of the expression?";

    public static void playCalcGame() {
        String[][] gameData = new String[ROUNDS_NUMBER][ROWS_NUMBER];

        for (int i = 0; i < ROUNDS_NUMBER; i++) {
            generateOperation();
            String[] expressionAndResult = generateOperation();
            String expression = expressionAndResult[FIRST_ELEMENTS_NUMBER];
            Integer result = Integer.valueOf(expressionAndResult[SECOND_ELEMENTS_NUMBER]);
            String question = "Question: " + expression;
            String correctAnswer = result.toString();
            gameData[i][FIRST_ELEMENTS_NUMBER] = question;
            gameData[i][SECOND_ELEMENTS_NUMBER] = correctAnswer;
        }
        Engine.playGame(INITIAL_QUESTION, gameData);
    }

    public static String[] generateOperation() {
        String[] operands = {"+", "-", "*"};
        String randomOperand = operands[Utils.getRandomInt(operands.length)];
        int randomNumber1 = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
        int randomNumber2 = Utils.getRandomInt(LOWER_BOUND, UPPER_BOUND);
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
