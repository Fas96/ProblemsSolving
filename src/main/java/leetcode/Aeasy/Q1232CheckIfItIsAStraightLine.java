package leetcode.Aeasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1232CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {

        int iniXCod = coordinates[1][0] - coordinates[0][0];
        int iniYCode = coordinates[1][1] - coordinates[0][1];
        for (int i = 1; i < coordinates.length; i++) {
            double ydif=coordinates[i][1]-coordinates[i-1][1];
            double xdif=coordinates[i][0]-coordinates[i-1][0];
            if((double) iniYCode /iniXCod !=  ydif/xdif) return false;
        }

        return true;
    }
}
