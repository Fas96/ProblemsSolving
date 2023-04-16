package leetcode.Y2023.daily.dmedium;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.format;

public class Q2405OptimalPartitionOfString {
    public int partitionString(String s) {
        int max =(s.isEmpty())? 0:1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.clear();
                max++;
            }
            map.put(s.charAt(i), 1);
        }
        return max;
    }
    @Test
    public void test(){
        assertEquals(4,partitionString("abacaba"));
        assertEquals(6,partitionString("ssssss"));
    }
}
