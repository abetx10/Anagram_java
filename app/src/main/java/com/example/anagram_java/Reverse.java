package com.example.anagram_java;

public class Reverse {
    public static String getReverseString(String text, String strFilter){
        String resultWord = "";
        String result = "";
        for (String word : text.split(" "))
        {
            resultWord = reverseWord(word.toCharArray(), strFilter.toCharArray()) + " ";
            result += resultWord;
        }
        return result.trim();
    }

    public static String reverseWord(char[] str, char[] strFilter) {
        int right = str.length - 1, left = 0;

        while (left < right) {
            if (isCharacterIgnored(str[left], strFilter)) left++;
            else if (isCharacterIgnored(str[right], strFilter)) right--;
            else {
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }

    public static Boolean isCharacterIgnored(char str, char[] strFilter) {
        boolean check = false;

        if (strFilter.length == 0) {
            if (!Character.isAlphabetic(str))
                check = true;

        } else {
            for (char c : strFilter) {
                if (str == c)
                    check = true;
            }
        }
        return check;
    }
}