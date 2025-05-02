package org.hackerrank.OneWeekPreparationKit.dayFive;

import java.util.HashSet;
import java.util.List;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        int numberOfPairs = 0;
        HashSet<Integer> set = new HashSet<>(arr);
        for(int val : arr) {
            if (set.contains(val + k)) numberOfPairs++;
        }
        return numberOfPairs;
    }
}
