package org.hackerrank.OneWeekPreparationKit.dayOne;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTheMedian {

    /**
     * This method finds the median for a given array
     * given a list
     *
     * @param list The list of integers for which we need to find out median.
     */
    public static int findMedian(List<Integer> list) {
        Collections.sort(list);
        int mid = list.size() / 2;
        return list.get(mid);
    }
    /**
     * This method finds the median for a given array
     * given an integer array
     *
     * @param arr The array of integers for which we need to find out median.
     */
    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length / 2;
        return arr[mid];
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 1, 2, 4);
        int[] arr =  {5, 3, 1, 2, 4};
        System.out.println(findMedian(list));
        System.out.println(findMedian(arr));
    }
}
