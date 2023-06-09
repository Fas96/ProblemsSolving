package leetcode.Bmedium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2405OptimalPartitionOfString {
    public int partitionString(String s) {
        int idx=0;
        int countPartition=1;
        Set<Character> chrHolders=new HashSet<>();
        while (idx<s.length()){
            if(!chrHolders.contains(s.charAt(idx))){
                chrHolders.add(s.charAt(idx));
            }else {
                countPartition++;
                chrHolders=new HashSet<>();
                chrHolders.add(s.charAt(idx));
            }
            idx++;
            System.out.println(chrHolders);
        }
        System.out.println(chrHolders);
        return countPartition;
    }

    public int partitionStringB(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1, substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i) - 'a'] >= substringStart) {
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        return count;
    }
}
