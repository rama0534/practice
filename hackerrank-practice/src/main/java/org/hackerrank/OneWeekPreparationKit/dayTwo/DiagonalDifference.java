package org.hackerrank.OneWeekPreparationKit.dayTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagonalDifference {
    /**
     * This method calculates the absolute difference between the sums of its diagonals
     *
     * @param list the list of integers to find difference.
     */
    public static int diagonalDifference(List<List<Integer>> list) {
        int leftToRight = 0;
        int rightToLeft = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            leftToRight += list.get(i).get(i);
            rightToLeft += list.get(i).get(n - 1 - i);
        }
        return Math.abs(leftToRight - rightToLeft);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix(nxn)");
        int size = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();

        System.out.println("Enter the matrix row by row:");
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        sc.close();
        int result = diagonalDifference(matrix);
        System.out.println("Diagonal difference: " + result);
    }
}
