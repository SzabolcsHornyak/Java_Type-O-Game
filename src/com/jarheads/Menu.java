package com.jarheads;
import org.json.simple.JSONArray;

import java.util.Scanner;

public class Menu {
    public static void mainmenu() {
        Scanner input = new Scanner(System.in);
        String choice;


        while (true) {
            printMainMenu();
            choice = input.next();
            switch (choice) {
                case "1": NewGame.new_game(JSONReader.getWordList()); break;
                case "2": HighScore.printHighscores(); break;
                case "9": exit(); break;
                default: System.out.println("Wrong choice");
            }
        }
    }

    public static void exit() {
        // same thing but instead of exit, break the while loop
        System.exit(1);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printMainMenu(){
        clearScreen();
        System.out.println("Choose an option");
        System.out.println("================");
        System.out.println("1 - New Game");
        System.out.println("2 - Highscore");
        System.out.println("----------------");
        System.out.println("9 - Exit");

    }
}
