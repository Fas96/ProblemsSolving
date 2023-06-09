package leetcode.Y2023.daily.deasy;

import java.util.List;
import java.util.stream.Collectors;

public class Q953VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        List<Character> orderList = order.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (int i = 0; i < n-1; i++) {
            if(!isAlienSorted(words[i], words[i+1], orderList)) return false;
        }
        return true;
    }
    private boolean isAlienSorted(String word1, String word2, List<Character> orderList) {
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        while(i < n && i < m) {
            if(word1.charAt(i) != word2.charAt(i)) {
                return orderList.indexOf(word1.charAt(i)) < orderList.indexOf(word2.charAt(i));
            }
            i++;
        }
        return n <= m;
    }

}
