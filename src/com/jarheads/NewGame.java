package com.jarheads;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

public class NewGame {
    public static void new_game() {
        // same thing but instead of exit, break the while loop


        Scanner userInput = new Scanner(System.in);
        String randomWord;
        Integer userScore = 0;

        LinkedList<String> testWords = new LinkedList<String>();
        testWords.add("asd");
        testWords.add("sdf");
        testWords.add("dfg");
        testWords.add("fgh");
        testWords.add("ghj");

        System.out.println("New");

        for (int i = 0; i < testWords.size(); i++) {

            int randomNumber = (int) (Math.random() * testWords.size());
            randomWord = testWords.get(randomNumber);
            System.out.println(randomWord);
            testWords.remove(randomNumber);
            String enteredWord = userInput.next();
            if (enteredWord.equals(randomWord)) {
                userScore++;
            }
            System.out.println("Your score is: " + userScore);
            clearScreen();
        }

    }
    //So this doesn't work yet
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
