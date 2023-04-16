package leetcode.Eweekly.w341;

public class Q6375MinimumAdditionsToMakeValidString {
    public int addMinimum(String word) {
        int count = 0;
        int i = 0;
        while (i < word.length()) {
            if (i + 2 < word.length() && word.charAt(i) == 'a' && word.charAt(i + 1) == 'b' && word.charAt(i + 2) == 'c') {
                i += 3;
            } else {
                if (i + 1 < word.length() && word.charAt(i) == 'a' && word.charAt(i + 1) == 'b') {
                    count++;
                    i += 2;
                } else if (i + 1 < word.length() && word.charAt(i) == 'b' && word.charAt(i + 1) == 'c') {
                    count++;
                    i += 2;
                } else if (i + 1 < word.length() && word.charAt(i) == 'a' && word.charAt(i + 1) == 'c') {
                    count += 1;
                    i += 2;
                } else {
                    count += 2;
                    i++;
                }
            }
        }
        return count;

    }

}
