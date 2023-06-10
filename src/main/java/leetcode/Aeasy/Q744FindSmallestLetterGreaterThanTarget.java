package leetcode.Aeasy;

public class Q744FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) if (letter > target) return letter;
        return letters[0];
    }
}
