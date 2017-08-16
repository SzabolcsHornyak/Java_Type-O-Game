package com.jarheads;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
    public static JSONArray getWordList() {
        JSONArray words = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
        Object object = parser.parse(new FileReader(System.getProperty("user.dir") + "/wordlist.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) object;

            //Reading the array
            words = (JSONArray) jsonObject.get("wordlist");

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return words;
    }
}
