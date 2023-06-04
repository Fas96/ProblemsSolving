package leetcode.Y2023.daily.dmedium;

import java.util.ArrayList;
import java.util.List;

public class Q54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length-1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) list.add(matrix[rowStart][i]);
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) list.add(matrix[i][colEnd]);
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) list.add(matrix[rowEnd][i]);
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) list.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return list;
    }
    public List<Integer> spiralOrderGOOD(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();

        int rowSize=matrix.length;
        int colSize=matrix[0].length;
        // r-right d-down l-left u-up
        char direction='r';
        int top=0;
        int right=colSize-1;
        int bottom=rowSize-1;
        int left=0;
        // add top layer add right layer add bottom layer add left layer, then repeat
        while(top<=bottom && left<=right)
        {
            // add topmost row
            if(direction=='r')
            {
                for(int i=left;i<=right;i++)
                    result.add(matrix[top][i]);
                top++;
                direction='d';
            }

            // add rightmost col
            else if(direction=='d')
            {
                for(int i=top;i<=bottom;i++)
                    result.add(matrix[i][right]);
                right--;
                direction='l';
            }

            // add bottommost row
            else if(direction=='l')
            {
                for(int i=right;i>=left;i--)
                    result.add(matrix[bottom][i]);
                bottom--;
                direction='u';
            }

            // add leftmost col
            else if(direction=='u')
            {
                for(int i=bottom;i>=top;i--)
                    result.add(matrix[i][left]);
                left++;
                direction='r';
            }
            // go one layer inside
        }
        return result;
    }

    public List<Integer> spiralOrderSwitch(int[][] matrix) {

        if (matrix == null) {
            throw new IllegalArgumentException("Input matrix is null");
        }
        //  Arraylist to store the result of spiral Order traversal of the matrix
        List<Integer> list = new ArrayList<>();

        //  Edge case
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        //  Pointers to traverse the matrix
        int left = 0;
        int right = matrix[0].length -1;
        int top = 0;
        int bottom = matrix.length -1;

        //  Direction pointer to get the spiral traversal direction easily for switch condition
        int dir = 0;

        //  Base Condition
        while( top <= bottom && left <= right){

            switch(dir){
                case 0 :    //  Right traversal
                    for(int i=left; i<=right ; ++i)
                        list.add(matrix[top][i]);
                    ++top;
                    break;
                case 1 :    //  Downward traversal
                    for(int i=top; i<=bottom ; ++i)
                        list.add(matrix[i][right]);
                    --right;
                    break;
                case 2 :    //  Left traversal
                    for(int i=right; i>=left; --i)
                        list.add(matrix[bottom][i]);
                    --bottom;
                    break;
                case 3 :    //  Upward traversal
                    for(int i=bottom; i>=top; --i)
                        list.add(matrix[i][left]);
                    ++left;
                    break;
            }
            dir = (dir+1) % 4;      //  Updating the direction after each traversal
        }
        return list;
    }
}
