package leetcode.Y2023.book.educative.a3TwoPointers;

import java.util.Arrays;

public class Q1a4_977SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        //bad solution
        return Arrays.stream(Arrays.stream(nums).map(i->i*i).toArray()).sorted().toArray();
    }
    public int[] makeSquares(int[] arr){
        int n=arr.length;
        int[] squares=new int[n];
        int highestSquareIdx=n-1;
        int left=0,right=n-1;
        while(left<=right){
            int leftSquare=arr[left]*arr[left];
            int rightSquare=arr[right]*arr[right];
            if(leftSquare>rightSquare){
                squares[highestSquareIdx--]=leftSquare;
                left++;
            }else{
                squares[highestSquareIdx--]=rightSquare;
                right--;
            }
        }

        return squares;
    }
}
