package com.example.anagram_java;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    @Test
    void isTextReversedWithFilter(){
        StringUtils text = new StringUtils();
        assertEquals("dexdnimoF oocl 7/42", text.getReverseString("Foxminded cool 24/7", "xl"));
    }

    @Test
    void isTextReversedWithOutFilter(){
        StringUtils text = new StringUtils();
        assertEquals("dednimxoF looc 24/7", text.getReverseString("Foxminded cool 24/7", ""));
    }

    @Test
    void isCharReversedWithFilter(){
        StringUtils text = new StringUtils();
        assertEquals("adcb",text.reverseWord(new char[]{'a', 'b', 'c', 'd'}, new char[]{'a'}));
    }

    @Test
    void isCharReversedWithOutFilter(){
        StringUtils text = new StringUtils();
        assertEquals("1dcb",text.reverseWord(new char[]{'1', 'b', 'c', 'd'}, new char[]{}));
    }

    @Test
    void isCharacterIgnoredWithFilter(){
        StringUtils text = new StringUtils();
        assertEquals(true,text.isCharacterIgnored('a', new char[]{'a'}));
    }

    @Test
    void isCharacterIgnoredWithOutFilter(){
        StringUtils text = new StringUtils();
        assertEquals(true,text.isCharacterIgnored('1', new char[]{}));
    }
}