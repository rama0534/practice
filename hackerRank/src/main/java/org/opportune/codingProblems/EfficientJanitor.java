package org.opportune.codingProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EfficientJanitor {
    public static void main(String[] args) {
        System.out.println("Efficient Janitor");
        List<Double> list = Arrays.asList(1.01, 1.99, 2.5, 1.5, 1.01);
        int count = minimumTrips(list);
        System.out.println("the minimum number of trips required : " + count);
    }

    private static int minimumTrips(List<Double> list) {
        int trips = 0;
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if((list.get(left) + list.get(right)) <= 3.00) {
                left++;
                right--;
            } else {
                right--;
            }
            trips++;
        }
        return trips;
    }
}
