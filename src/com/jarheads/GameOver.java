package com.jarheads;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GameOver {


    public static void gameOver(Integer score) {
        System.out.printf("The game is over :( , your score is: %d%n", score);
        isScoreEnough(score);
    }

    public static void isScoreEnough(Integer score) {
        Integer minScore;
        ArrayList<String> names = new ArrayList<>();
        List<ArrayList<String>> highScores = HighScore.getHighscorelist();

        minScore = Integer.valueOf(highScores.get(0).get(1));
        for(ArrayList<String> player: highScores) {
            names.add(player.get(0));
            Integer playerScore = Integer.valueOf(player.get(1));
            if(playerScore < minScore) minScore = playerScore;
        }
        if(score > minScore){
            enterName(names, score);
        } else {
            System.out.println("You didn't make it to the leaderboard, keep on trying!");
            Menu.promptEnterKey();
        }
    }

    public static void enterName(List names, Integer score){
        System.out.println("Your score made it to the high scores board, please enter your name:");
        Scanner inputName = new Scanner(System.in);
        String userName = inputName.next();
        while(names.contains(userName)){
            System.out.println("That name is already taken, please choose something different!");
            userName = inputName.next();
        }
        HighScore.saveHighscores(userName, score);
        HighScore.printHighscores();
    }
}
