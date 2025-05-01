package org.hackerrank.OneWeekPreparationKit.dayTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlippingMatrix {
    /**
     *
     * The function is expected maximize the sum of the elements in
     * the n x n subMatrix located in the upper-left quadrant of the matrix.
     *  @param matrix the 2D_INTEGER_ARRAY matrix
     *
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val1 = matrix.get(i).get(j);
                int val2 = matrix.get(i).get(2 * n - 1 - j);
                int val3 = matrix.get(2 * n -1 -i).get(j);
                int val4 = matrix.get(2 * n - 1 - i). get(2 * n - 1 - j);
                total += Math.max(Math.max(val1, val2), Math.max(val3, val4));
            }
        }
        return total;
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
        int result = flippingMatrix(matrix);
        System.out.println("The sum of values in the"+ size + " x " + size  +"sub matrix in the upper-left quadrant is: " + result);
    }
}
