package org.hackerrank.OneWeekPreparationKit.dayFour;

import java.util.Arrays;
import java.util.List;

public class MinimumBribes {
    public static void  main(String[]  args) {
//        List<Integer> q = Arrays.asList(2, 1, 5, 3, 4); // o/p 3
//       List<Integer> q = Arrays.asList(2, 5, 1, 3, 4); // o/p Too chaotic
        List<Integer> q = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
       int count =  minimumBribes(q);
       if(count > 0) {
           System.out.println(count);
       } else {
           System.out.println("Too chaotic");
       }

    }
    public static int minimumBribes(List<Integer> q) {
        int count = 0;
        for(int i = 0; i < q.size(); i++) {
            System.out.println(q.get(i));
            if(((q.get(i) - 1) - i) > 0) count += (q.get(i) - 1) - i;
            if(q.get(i) >  i + 3){
                count = 0;
                break;
            }
        }
        return count;
    }
 }
