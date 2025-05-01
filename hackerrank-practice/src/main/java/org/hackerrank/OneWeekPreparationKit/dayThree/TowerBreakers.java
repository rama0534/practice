package org.hackerrank.OneWeekPreparationKit.dayThree;

public class TowerBreakers {
    public static int towerBreakers(int n, int m) {
        // Write your code here
        if (m == 1 || n % 2 == 0) {
            return 2; // Player 2 wins
        } else {
            return 1; // Player 1 wins
        }

    }
}

//🧠 Key Observations
//If the height m of all towers is 1, then no move is possible (because you can't reduce height 1 to anything smaller while maintaining a divisor).
//🔸 Player 1 loses immediately → Player 2 wins
//
//If m > 1 and the number of towers n is even, then:
//
//Player 2 can mirror every move Player 1 makes (since the number of towers is even),
//
//Which means Player 2 always wins if they play optimally.
//
//If m > 1 and the number of towers n is odd, Player 1 has a strategic advantage and can force a win.
