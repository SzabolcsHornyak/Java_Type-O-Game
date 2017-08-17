package com.jarheads;

import java.io.FileWriter;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class HighScore {

    public static JSONObject readHighscores() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/highscores.json"));
            jsonObject = (JSONObject) obj;
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    public static List getHighscorelist(){
        JSONObject jsonObject = readHighscores();
        Iterator<String> objectKeys = jsonObject.keySet().iterator();

        List<ArrayList<String>> scoreList = new ArrayList<>();

        while (objectKeys.hasNext()) {
            ArrayList<String> scorePairs = new ArrayList<>();
            String key = objectKeys.next();
            scorePairs.add(key);
            scorePairs.add(jsonObject.get(key).toString());
            scoreList.add(scorePairs);
        }
        return scoreList;
    }


    public static List sortScoreDesc(List<ArrayList<String>> scoreList){
        scoreList.sort((p1, p2) -> (new Integer(p1.get(1)).compareTo(new Integer(p2.get(1)))));
        Collections.reverse(scoreList);
        return scoreList;
    }


    public static void printHighscores() {
        List<ArrayList<String>> scoreList = getHighscorelist();

        scoreList = sortScoreDesc(scoreList);

        for (List result : scoreList) {
            System.out.print(result.get(0) + ": ");
            System.out.println(result.get(1));
        }
        System.out.println("\n");
        Menu.promptEnterKey();
        Menu.mainmenu();
    }


    public static void saveHighscores(String name, int score) {
        List<ArrayList<String>> scoreList = getHighscorelist();

        ArrayList<String> newScorePairs = new ArrayList<>();
        newScorePairs.add(name);
        newScorePairs.add(Integer.toString(score));
        scoreList.add(newScorePairs);

        scoreList = sortScoreDesc(scoreList);

        JSONObject newHighscores = new JSONObject();
        for (int i = 0; i < 10; i++) {
            newHighscores.put(scoreList.get(i).get(0), scoreList.get(i).get(1));
        }

        try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/highscores.json")) {
            file.write(newHighscores.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
