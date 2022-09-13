package com.example.anagram_java;

public class Reverse {
    public static String reverseString(char[] str, char[] filterStr) {
        if (str.length == 0) {
            return null;

        } else if (filterStr.length == 0) {
            return filterIsEmpty(str);

        } else {
            return filterIsFill(str, filterStr);
        }
    }

    public static String filterIsEmpty(char[] str) {
        int right = str.length - 1, left = 0;

        while (left < right) {
            if (!Character.isAlphabetic(str[left])) left++;

            else if (!Character.isAlphabetic(str[right])) right--;

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

    public static String filterIsFill(char[] str, char[] filterStr) {
        int right = str.length - 1, left = 0;

        while (left < right) {
            for (char c : filterStr) {
                if (c == str[left]) left++;

                else if (c == str[right]) right--;

                else {
                    char tmp = str[left];
                    str[left] = str[right];
                    str[right] = tmp;
                    left++;
                    right--;
                }
            }
        }
        return String.valueOf(str);
    }

}

