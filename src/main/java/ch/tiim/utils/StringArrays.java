package ch.tiim.utils;

import java.util.Arrays;

public class StringArrays {

    public static void trimArray(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
    }

    public static String[] skipFirst(String[] strings) {
        return Arrays.copyOfRange(strings, 1, strings.length);
    }

}
