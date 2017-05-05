package com.lvonce;

/**
 * Created by WangWei on 2017/3/9.
 */
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

    public static void info(String format, Object ... args) {
        System.out.printf(format, args);
    }
    public static void warning(String format, Object ... args) {
        System.out.printf(format, args);
    }
}
