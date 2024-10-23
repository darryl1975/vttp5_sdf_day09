package project01am;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import project01am.Card.Card;
import project01am.Card.CardValue;
import project01am.Card.Suit;

public class App {

    public static void main(String[] args) {

        // Task09();

        // Task10();

        // Task11();

        Task11a();

    }

    public static void Task09() {
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

    public static void Task10() {
        Random random = new Random();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(random.nextInt(1, 100));
        }

        Console console = System.console();
        Boolean userInput = true;
        String guess = "";
        int currentPos = 1;
        List<String> correctList = new ArrayList<>();

        System.out.printf("\r\nFirst Number: %d\r\n", numberList.get(0));
        correctList.add("-");
        while (userInput) {
            guess = console.readLine("\r\nGuess the next number is higher 'H' or lower 'L':");

            int higher = 0;
            int lower = 0;
            for(int x = currentPos; x < (numberList.size() - 1); x++) {
                if (numberList.get(x) < numberList.get(x - 1)) {
                    lower++;
                } else {
                    higher++;
                }
            }

            String answer = "";
            String correct = "0";
            if (numberList.get(currentPos - 1) < numberList.get(currentPos)) 
                answer = "h";
            else 
                answer = "l";

            if (guess.trim().toLowerCase().equals(answer))
                correct = "1";
            else 
                correct = "0";
            correctList.add(correct);

            // print out the results
            for(int a = 0; a <= currentPos; a++) {
                if (a == 0){ 
                    System.out.printf("\r\n%d", numberList.get(a));
                }
                else {
                    System.out.printf("    %d:%s", numberList.get(a), correctList.get(a));
                }
            }
            System.out.printf("    h:%d    l:%d", higher, lower);

            // program terminates/ends
            if (currentPos == 9) {
                userInput = false;
            }

            currentPos++;
        }
        System.out.println("\r\n");
    }

    public static void Task11() {
        String[] suits = { "SPADE", "HEART", "CLUB", "DIAMOND" };
        String[] ranks = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        List<String> deck = new ArrayList<>();
        // Collections
        // Collections.shuffle(deck);

        // 52 cards in a deck
        int numberOfDeckCards = suits.length * ranks.length;
        // String[] decks = new String[numberOfDeckCards];

        // create the deck of 52 cards in sequence
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck.add(suits[i] + " " + ranks[j]);
            }
        }

        // shuffle
        Collections.shuffle(deck);

        // print the shuffled deck
        for (String card : deck) {
            System.out.println(card);
        }

    }

    public static void Task11a() {
        List<Card> deck = new ArrayList<>();

        for(int i = 0; i < 13; i++) {
            CardValue v = CardValue.values()[i];
            for (int j = 0; j < 4; j++) {
                Suit s = Suit.values()[j];
                
                Card c = new Card(s, v);
                deck.add(c);
            }
        }

        Collections.shuffle(deck);

        for(Card card: deck) {
            System.out.println(card.toString());
        }
    }

}