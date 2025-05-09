package org.opportune.codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConferenceSchedule {
    public static void main(String[] args) {
        System.out.println("Conference Schedule");
        List<Integer> scheduleStart = Arrays.asList(1, 1, 2);
        List<Integer> scheduleEnd = Arrays.asList(3, 2, 4);
        System.out.println("The maximum number of presentations one person can attend is " + maxPresentations(scheduleStart, scheduleEnd));
    }

    private static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        int count = 0;
        int n = scheduleStart.size();
        List<int[]> presentations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            presentations.add(new int[]{scheduleStart.get(i), scheduleEnd.get(i)});
        }

        //sort by their end times
        presentations.sort(Comparator.comparingInt(a -> a[1]));
        int lastEndTime = 0;
        for (int[] presentation : presentations) {
            if (presentation[0] >= lastEndTime) {
                count++;
                lastEndTime = presentation[1];
            }
        }
        return count;
    }

}
