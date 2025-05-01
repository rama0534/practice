package org.hackerrank.OneWeekPreparationKit.dayOne;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    /**
     * This method calculate the ratios of its elements that are positive, negative, and zero.
     * given a list of integers
     *
     * @param list The list of integers for which we need to find the
     * ratios of positive, negative and zero.
     */
    public static void plusMinus(List<Integer> list) {
        int n = list.size();
        int  zero = 0, positive = 0,  negative = 0;
        for (int val : list) {
            if(val > 0) {
                positive++;
            }else if(val < 0) {
                negative++;
            }else {
                zero++;
            }
        }

        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 0, -1, -1);
        plusMinus(list);
    }

}
