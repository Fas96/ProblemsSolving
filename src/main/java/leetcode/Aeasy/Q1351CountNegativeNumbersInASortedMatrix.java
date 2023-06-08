package leetcode.Aeasy;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q1351CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
       return (int) Arrays.stream(Stream.of(grid)
                .flatMapToInt(IntStream::of)
                .toArray()).filter(e->e<0).count();

    }
}
