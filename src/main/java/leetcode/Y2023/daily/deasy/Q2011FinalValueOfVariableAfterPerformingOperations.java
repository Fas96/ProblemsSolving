package leetcode.Y2023.daily.deasy;

import java.util.Arrays;

public class Q2011FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int finalAnsAfterOpe=0;
        for (String operation : operations) {
            if (operation.contains("+")) finalAnsAfterOpe++;
            else finalAnsAfterOpe--;
        }

        return finalAnsAfterOpe;

    }
}
