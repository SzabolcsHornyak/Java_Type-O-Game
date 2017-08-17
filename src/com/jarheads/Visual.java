package com.jarheads;

public class Visual {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String NEW_LINE = "\n";
    public static final String TAB = "\t";

    public static String AddEmptyLines(String input_s, Integer line_count){
        for (int i = 0; i < (line_count+1); i++ ) {
            input_s += NEW_LINE;
        }
        return input_s;
    }

    public static String AddTabs(String input_s, Integer line_count){
        for (int i = 0; i < (line_count+1); i++ ) {
            input_s += TAB;
        }
        return input_s;
    }

    public static String AddSpaces(Integer space_count){
        String output_s = "";
        for (int i = 0; i < (space_count+1); i++ ) {
            output_s += " ";
        }
        return output_s;
    }


    public static String AddChar(String in_char, Integer space_count){
        String output_s = "";
        for (int i = 0; i < (space_count+1); i++ ) {
            output_s += in_char;
        }
        return output_s;
    }


    public static void screen(String title,String word, String score, String time_left){
        clearScreen();
        String output_s;
        output_s = ANSI_RED + title + " " + ANSI_WHITE + AddChar("-",19 ) + NEW_LINE;
        output_s = ANSI_RESET + AddEmptyLines(output_s,2) + NEW_LINE;
        output_s = AddTabs(output_s,1) + ANSI_GREEN + word + NEW_LINE;
        output_s = ANSI_RESET + AddEmptyLines(output_s,2) + NEW_LINE;
        output_s += ANSI_BLUE + "SCORE: " + ANSI_CYAN + score + " " + ANSI_WHITE + AddChar("=",5) + ANSI_YELLOW + " " + time_left + "sec left" + ANSI_RESET;

        System.out.println(output_s);

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
