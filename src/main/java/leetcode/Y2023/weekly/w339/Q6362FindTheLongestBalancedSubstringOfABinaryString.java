package leetcode.Y2023.weekly.w339;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Q6362FindTheLongestBalancedSubstringOfABinaryString {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int longest = 0;
        int count = 0;
        int zero = 0;
        int one = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
           if(s.charAt(i) == '0') zero++;
           else one++;

        }

        return longest;
    }

    @Test
    public void test() {
        assertEquals(6, findTheLongestBalancedSubstring("01000111"));
        assertEquals(4, findTheLongestBalancedSubstring("00111"));
        assertEquals(0, findTheLongestBalancedSubstring("111"));
        assertEquals(0, findTheLongestBalancedSubstring("10"));
        assertEquals(2, findTheLongestBalancedSubstring("0001"));
        assertEquals(4, findTheLongestBalancedSubstring("00011"));
        assertEquals(2, findTheLongestBalancedSubstring("101"));
        assertEquals(0, findTheLongestBalancedSubstring("10"));
        assertEquals(4, findTheLongestBalancedSubstring("10011"));
        assertEquals(2, findTheLongestBalancedSubstring("1101"));
        assertEquals(2, findTheLongestBalancedSubstring("11011"));
        assertEquals(4, findTheLongestBalancedSubstring("110011"));
        assertEquals(4, findTheLongestBalancedSubstring("1100111"));
        assertEquals(4, findTheLongestBalancedSubstring("11100111"));
        assertEquals(2, findTheLongestBalancedSubstring("11101011"));
        assertEquals(2, findTheLongestBalancedSubstring("11111011"));
        assertEquals(0, findTheLongestBalancedSubstring("11111111"));
        assertEquals(2, findTheLongestBalancedSubstring("00101"));
    }
}
