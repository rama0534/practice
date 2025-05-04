package org.leetcode.arrays;

import java.util.Scanner;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days");
        int size = sc.nextInt();
        int[] prices = new int[size];
        System.out.println("Enter prices");
        for (int i = 0; i < size; i++)
            prices[i] = sc.nextInt();
        System.out.println(maxProfit(prices));
        sc.close();
    }

    public static int maxProfit(int[] prices) {
        int leastValue = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            leastValue = Math.min(leastValue, price);
            int todayProfit = price - leastValue;
            maxProfit = Math.max(maxProfit, todayProfit);
        }
        return maxProfit;
    }
}
