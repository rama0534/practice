package org.hackerrank.OneWeekPreparationKit.dayOne;

import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {
    /**
     * This method finds the minimum and maximum values that can be calculated
     * by summing exactly (n - 1 )of the n integers.
     * given a list of integers
     *
     * @param list The list of integers for which we need to find out
     * the respective minimum and maximum values.
     */
    public static void miniMaxSum(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        for (int val : list) {
            sum += val;
            if(val < min) min = val;
            if(val > max) max = val;
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum(list);
    }
}
