package org.hackerrank.OneWeekPreparationKit.dayFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> petrolPumps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            petrolPumps.add(Arrays.asList(petrol, distance));
        }
        int startPoint = truckTour(petrolPumps);
        System.out.println("The start point is : " + startPoint);

    }

    public static int truckTour(List<List<Integer>> petrolPumps) {
        // Write your code here
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, balance = 0;
        for (int i = 0; i < petrolPumps.size(); i++) {
            int petrol = petrolPumps.get(i).get(0);
            int distance = petrolPumps.get(i).get(1);
            totalPetrol += petrol;
            totalDistance += distance;

            balance += petrol - distance;
            if(balance < 0) {
                start = i + 1;
                balance = 0;

            }
        }
        return (totalPetrol >= totalDistance) ?  start: -1;
    }

}
