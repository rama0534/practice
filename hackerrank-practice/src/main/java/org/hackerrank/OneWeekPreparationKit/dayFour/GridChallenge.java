package org.hackerrank.OneWeekPreparationKit.dayFour;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static void main(String[] args) {
        List<String> grid  =  Arrays.asList( "abc", "ade", "efg"); //O/P YES
        System.out.println(gridChallenge(grid));
//        List<String> grid  =  Arrays.asList("eabcd", "fghij", "olkmn", "trpqs", "xywuv"); O/P YES
//        List<String> grid  =  Arrays.asList("abc","lmp", "qrt");   o/p YES
//        List<String> grid  =  Arrays.asList("mpxz", "abcd", "wlmf");   O/P NO
//        List<String> grid  =  Arrays.asList("abc", "hjk", "mpq", "rtv");O/P YES

    }
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int n = grid.size();

        for(int i = 0; i < n ; i++) {
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, new String(chars));
        }

        int m = grid.get(0).length();
        for(int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                if (grid.get(row).charAt(col) < grid.get(row -1).charAt(col)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
