package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q2390RemovingStarsFromAString {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        for (int i = 1; i < n; i++) {
            if(s.charAt(i)=='*')sb.deleteCharAt(sb.length()-1);
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    @Test
    public void removeTest(){
        assertEquals("b",removeStars("a*b"));
        assertEquals("lecoe",removeStars("leet**cod*e"));
        assertEquals("",removeStars("erase*****"));
    }
}
