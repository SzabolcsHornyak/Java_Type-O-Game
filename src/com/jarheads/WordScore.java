package com.jarheads;

import java.util.ArrayList;
import java.util.Arrays;

public class WordScore {
    public static int Score(String word) {
        ArrayList<String> left_keys = new ArrayList<String>(
                Arrays.asList(
                        "1","2","3","4","5","6",
                        "Q", "W", "E","R","T","Z",
                        "A","S","D","F","G",
                        "Í", "Y","X","C","V","B"
                ));
        ArrayList<String> right_keys = new ArrayList<String>(
                Arrays.asList(
                        "7","8","9","Ö","Ü","ó",
                        "U", "I", "O","P","Ő","Ú",
                        "H","J","K","L","É","Á","Ű",
                        "N", "M",",",".","-"
                ));
        int side=0;
        int point=0;
        for (int i=0; i < word.length(); i++) {
            if (ListMatch(word.substring(i,i+1),left_keys)){
                if (side==0) {
                    point++;
                } else {
                    point += 2;
                }
                side = 0;
            }

            if (ListMatch(word.substring(i,i+1),right_keys)){
                if (side==1) {
                    point++;
                } else {
                    point += 2;
                }
                side = 1;
            }

        }
        return point;
    }

    public static boolean ListMatch(String word,ArrayList list){
        String search = word.toUpperCase();
        for(int i=0; i < list.size(); i++) {
            if(list.get(i).toString().toUpperCase().trim().contains(search))
                return true;
        }
        return false;
    }
}
