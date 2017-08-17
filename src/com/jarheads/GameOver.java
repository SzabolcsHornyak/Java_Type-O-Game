package com.jarheads;

import java.util.Scanner;
import org.json.simple.JSONObject;

public class GameOver {


    public static void gameOver(Integer score) {
        System.out.printf("The game is over :( , your score is: %d%n", score);
        if(score > 100) {
            Scanner inputName = new Scanner(System.in);
            String userName = inputName.next();
            System.out.println(userName);
        } else {
            //Menu.promptEnterKey();
        }
    }
}
