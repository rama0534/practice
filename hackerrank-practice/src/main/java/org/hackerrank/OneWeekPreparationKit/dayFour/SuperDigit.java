package org.hackerrank.OneWeekPreparationKit.dayFour;

import java.util.Scanner;

public class SuperDigit {
    public static void main(String[]  args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a ");
        String n = sc.next();
        int k = sc.nextInt();
        System.out.println(superDigit(n,k));
    }
    public static int superDigit(String n, int k) {
        long initialSum = 0;

        for(char c : n.toCharArray()) {
            initialSum += c - '0';
        }
        initialSum = initialSum * k;

        return (int) findDigitsSum(initialSum);
    }
    private static long findDigitsSum(long value) {
        if(value < 10) return value;

        long sum = 0;
        while (value > 0) {
            sum += value % 10;
            value = value / 10;
        }
        return findDigitsSum(sum);
    }
}
