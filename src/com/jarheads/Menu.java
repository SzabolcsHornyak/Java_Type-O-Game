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

    public static void printMainMenu(){
        Visual.clearScreen();
        System.out.println(Visual.ANSI_RED + "Type-O-Game" + Visual.NEW_LINE);
        System.out.println(Visual.ANSI_PURPLE + "Choose an option");
        System.out.println(Visual.ANSI_WHITE + Visual.AddChar("-=",7) + "-");
        System.out.println(Visual.ANSI_GREEN + "1" + Visual.ANSI_WHITE + " - " + Visual.ANSI_YELLOW + "New Game");
        System.out.println(Visual.ANSI_GREEN + "2" + Visual.ANSI_WHITE + " - " + Visual.ANSI_YELLOW + "Highscore");
        System.out.println(Visual.ANSI_WHITE + Visual.AddChar("-+", 7) + "-");
        System.out.println(Visual.ANSI_GREEN + "9" + Visual.ANSI_WHITE + " - " + Visual.ANSI_YELLOW + "Exit");

    }

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


}
