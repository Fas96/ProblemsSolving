package leetcode.Y2023.daily.deasy;

import java.util.Arrays;

public class Q58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
       return Arrays.stream(s.trim().split(" "))
               .reduce((first, second) -> second)
               .map(String::length)
               .orElse(0);

    }
}
