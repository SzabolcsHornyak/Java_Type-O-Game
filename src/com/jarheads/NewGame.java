package com.jarheads;

import org.json.simple.JSONArray;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

public class NewGame {
    public static void new_game() {
        // same thing but instead of exit, break the while loop

        JSONArray words = JSONReader.getWordList();

        Scanner userInput = new Scanner(System.in);
        String randomWord;
        Integer userScore = 0;

        Thread timerThread = new Thread(new Timer());
        timerThread.start();

        while(Timer.counter > 0) {

            int randomNumber = (int) (Math.random() * words.size());
            randomWord = words.get(randomNumber).toString();
            System.out.println(randomWord + "   " + Timer.counter + " seconds remaining");
            words.remove(randomNumber);
            String enteredWord = userInput.next();
            if (enteredWord.equals(randomWord)) {
                userScore = userScore + WordScore.Score(randomWord);
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
