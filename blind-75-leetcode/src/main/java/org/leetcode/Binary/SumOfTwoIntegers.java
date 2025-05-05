package org.leetcode.Binary;

import java.util.Scanner;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first integer");
        int a = scanner.nextInt();
        System.out.println("Enter second integer");
        int b = scanner.nextInt();
        System.out.println(getSum(a, b));
    }
    private static int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
