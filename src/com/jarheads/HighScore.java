package com.jarheads;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class HighScore {

    public static void highscore() {
        // same thing but instead of exit, break the while loop
        System.out.println("HighScore");
    }

    public static JSONObject readHighscores(){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/highscores.json"));
            jsonObject = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }

    public static void printHighscores(JSONObject jsonObject){
        Iterator<String> objectKeys = jsonObject.keySet().iterator();
        while (objectKeys.hasNext()) {
            String key = objectKeys.next();
            System.out.print(key + ": ");
            System.out.println(jsonObject.get(key));
        }
    }

    
}


