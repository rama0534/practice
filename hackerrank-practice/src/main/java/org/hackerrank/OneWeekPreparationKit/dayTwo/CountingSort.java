package org.hackerrank.OneWeekPreparationKit.dayTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {
    /**
     * This method sort the given a list
     *
     * @param list The list of integers for which we need to sort.
     */
    public static List<Integer> countingSort(List<Integer> list) {
        int[] result = new int[100];
        for (int num : list) {
            result[num]++;
        }
        List<Integer> frequencyList = new ArrayList<>();
        for (int count : result) {
            frequencyList.add(count);
        }
        return frequencyList;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 3, 2, 1);
        System.out.println(countingSort(list));
    }
}
