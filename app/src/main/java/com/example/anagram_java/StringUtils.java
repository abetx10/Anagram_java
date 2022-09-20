package com.example.anagram_java;

public final class StringUtils {
    public static String getReverseString(String text, String textFilter){
        String result = "";
        for (String word : text.split(" "))
        {
            result += reverseWord(word.toCharArray(), textFilter.toCharArray()) + " ";
        }
        return result.trim();
    }

    public static String reverseWord(char[] text, char[] textFilter) {
        int right = text.length - 1, left = 0;

        while (left < right) {
            if (isCharacterIgnored(text[left], textFilter)) left++;
            else if (isCharacterIgnored(text[right], textFilter)) right--;
            else {
                char tmp = text[left];
                text[left] = text[right];
                text[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(text);
    }

    public static Boolean isCharacterIgnored(char text, char[] textFilter) {
        boolean charIsIgnored = false;

        if (textFilter.length == 0) {
            if (!Character.isAlphabetic(text))
                charIsIgnored = true;

        } else {
            for (char symbol : textFilter) {
                if (text == symbol)
                    charIsIgnored = true;
            }
        }
        return charIsIgnored;
    }
}