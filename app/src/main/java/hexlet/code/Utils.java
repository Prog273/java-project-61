package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int firstNumber, int lastNumber) {
        Random random = new Random();
        int randomNumber = random.nextInt(firstNumber, lastNumber);
        return randomNumber;
    }

    public static int getRandomInt(int lastNumber) {
        Random random = new Random();
        int randomNumber = random.nextInt(lastNumber);
        return randomNumber;
    }
}
