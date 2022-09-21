package com.example.anagram_java;

public final class StringUtils {
    private StringUtils() {
    }

    public static String getReverseString(String text, String textFilter) {
        StringBuilder result = new StringBuilder();
        String resultWord = "";
        for (String word : text.split(" ")) {
            resultWord = reverseWord(word.toCharArray(), textFilter.toCharArray()) + " ";
            result.append(resultWord);
        }
        return result.toString().trim();
    }

    public static String reverseWord(char[] text, char[] textFilter) {
        int right = text.length - 1, left = 0;

        while (left < right) {
            if (isCharacterIgnored(text[left], textFilter)) {
                left++;
            } else if (isCharacterIgnored(text[right], textFilter)) {
                right--;
            } else {
                char tmp = text[left];
                text[left] = text[right];
                text[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(text);
    }

    public static Boolean isCharacterIgnored(char character, char[] ignoredCharactersArray) {
        boolean charIsIgnored = false;

        if (ignoredCharactersArray.length == 0) {
            if (!Character.isAlphabetic(character)) {
                charIsIgnored = true;
            }
        } else {
            for (char symbol : ignoredCharactersArray) {
                if (character == symbol) {
                    charIsIgnored = true;
                }
            }
        }
        return charIsIgnored;
    }
}