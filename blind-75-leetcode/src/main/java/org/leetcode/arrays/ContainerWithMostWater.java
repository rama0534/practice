package org.leetcode.arrays;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = scanner.nextInt();
        int[] height = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++)
            height[i] = scanner.nextInt();
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min( height[left], height[right]);
            int width = right - left;
            area = Math.max(area, minHeight * width);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
