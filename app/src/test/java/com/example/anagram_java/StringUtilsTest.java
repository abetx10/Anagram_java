package com.example.anagram_java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringUtilsTest {
    @Test
    void isTextReversedWithFilter() {
        assertEquals("dexdnimoF oocl 7/42", StringUtils.getReverseString("Foxminded cool 24/7", "xl"));
        assertEquals("dcba hgfe", StringUtils.getReverseString("abcd efgh", "xl"));
        assertEquals("dcb1a hgfle", StringUtils.getReverseString("a1bcd efglh", "xl"));
        assertNotNull(StringUtils.getReverseString("a1bcd efglh", "xl"));
    }

    @Test
    void isTextReversedWithOutFilter() {
        assertEquals("dednimxoF looc 24/7", StringUtils.getReverseString("Foxminded cool 24/7", ""));
        assertEquals("dcba hgfe", StringUtils.getReverseString("abcd efgh", ""));
        assertEquals("d1cba hgf!e", StringUtils.getReverseString("a1bcd efg!h", ""));
        assertFalse(("d1cba hgfe").equals(StringUtils.getReverseString("a1bcd efg!h", "")));
    }

    @Test
    void isWordReversedWithFilter() {
        assertEquals("adcb", StringUtils.reverseWord("abcd", "a"));
        assertEquals("dexdnimoF", StringUtils.reverseWord("Foxminded", "xl"));
        assertEquals("hgfe", StringUtils.reverseWord("efgh", "xl"));
        assertTrue(("hgfe").equals(StringUtils.reverseWord("efgh", "xl")));
    }

    @Test
    void isWordReversedWithOutFilter() {
        assertEquals("hgfe", StringUtils.reverseWord("efgh", ""));
        assertEquals("24/7", StringUtils.reverseWord("24/7", ""));
        assertEquals("dednimxoF", StringUtils.reverseWord("Foxminded", ""));
        assertNotSame(("dednimxoF"), StringUtils.reverseWord("Foxminded", ""));
    }

    @Test
    void isCharacterIgnoredWithFilter() {
        assertEquals(true, StringUtils.isCharacterIgnored('a', new char[]{'a'}));
        assertEquals(true, StringUtils.isCharacterIgnored('F', new char[]{'F'}));
        assertEquals(true, StringUtils.isCharacterIgnored('x', new char[]{'x'}));
        assertNotNull(StringUtils.isCharacterIgnored('x', new char[]{'x'}));
    }

    @Test
    void isCharacterIgnoredWithOutFilter() {
        assertEquals(true, StringUtils.isCharacterIgnored('1', new char[]{}));
        assertEquals(true, StringUtils.isCharacterIgnored('2', new char[]{}));
        assertEquals(true, StringUtils.isCharacterIgnored('0', new char[]{}));
        assertEquals(true, StringUtils.isCharacterIgnored('/', new char[]{}));
    }
}