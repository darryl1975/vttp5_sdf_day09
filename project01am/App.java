package project01am;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        int min = 111111;
        int max = 999999;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        List<Integer> guessedNumbers = new ArrayList<>();

        Console console = System.console();
        String keyboardInput = "";

        Integer lowerBound = 0;
        Integer higherBound = 999999;
        Boolean userWin = false;
        while (!keyboardInput.toLowerCase().equals("quit")) {
            System.out.println("Generated number: " + randomNumber);
            keyboardInput = console.readLine("Enter your guess number (111111 to 999999): ");

            if (keyboardInput.toLowerCase().equals("quit"))
                break;

            // assuming input all digits (no error)
            Integer guessValue = Integer.parseInt(keyboardInput);
            guessedNumbers.add(guessValue);
            Collections.sort(guessedNumbers);

            if (guessValue > lowerBound) 
                if (guessValue != randomNumber)
                    if (guessValue < randomNumber)
                        lowerBound = guessValue;

            if (guessValue > randomNumber)
                if (guessValue < higherBound)
                    higherBound = guessValue;

            if (guessValue < randomNumber) {
                System.out.println("Number guessed is lower. " + lowerBound + " and " + higherBound);
            } else if (guessValue > randomNumber) {
                System.out.println("Number guessed is higher. " + lowerBound + " and " + higherBound);
            } else {
                System.out.println("You guessed it correctly. ");
                userWin = true;
            }

            // restart game
            if (userWin) {
                userWin = false;
                lowerBound = 0;
                higherBound = 999999;
                randomNumber = random.nextInt(max - min + 1) + min;
                guessedNumbers.clear();
            }

        }

    }
}