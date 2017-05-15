package com.lvonce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BehaviorDebug {
    public static int level = 0;

    public static void debug(String format, Object ... args) {
        BehaviorDebug.debug(BehaviorDebug.level, format, args);
    }

    public static void incLevel(){
        ++ BehaviorDebug.level;
    }

    public static void decLevel(){
        -- BehaviorDebug.level;
    }

    public static void debug(int level, String format, Object ... args) {
        String formatString = "";
        for (int i =0; i<level; ++i) {
            formatString = formatString.concat("    ");
        }
        formatString = formatString.concat("- ");
        formatString = formatString.concat(format);
        formatString = formatString.concat(" -\n");
        System.out.printf(formatString, args);
    }

    public static void pause() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String format, Object ... args) {
        System.out.printf(format, args);
    }
    public static void warning(String format, Object ... args) {
        System.out.printf(format, args);
    }
}
