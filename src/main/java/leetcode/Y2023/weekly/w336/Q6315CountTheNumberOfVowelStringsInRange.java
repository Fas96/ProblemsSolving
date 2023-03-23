package leetcode.Y2023.weekly.w336;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q6315CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        List<Character> vowels= Arrays.asList('a','e','i','o','u');
        int count=0;
        for (int i = left; i <=right ; i++) {
            String word = words[i];
            if(vowels.contains(word.charAt(0))&&vowels.contains(word.charAt(word.length()-1))) {
                count++;
            }
        }
        return count;

    }
    @Test
    public void test_countVowelStrings(){
        String[] stringArr=new String[]{"are","amy","u"};
        int left=0,right=2;
        System.out.println(Arrays.toString(stringArr));
        assertEquals(2, vowelStrings(stringArr, left, right));
        stringArr=new String[]{"hey","aeo","mu","ooo","artro"};
        left=1;
        right=4;
        System.out.println(Arrays.toString(stringArr));
        assertEquals(3, vowelStrings(stringArr, left, right));
    }
}
