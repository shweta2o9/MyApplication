package com.example.DP;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/5/17.
 */
/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0’s) or contain magic orbs that increase the knight’s health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight’s minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path

RIGHT-> RIGHT -> DOWN -> DOWN.

The knight’s health has no upper bound.
Any room can contain threats or power-ups,
 even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
//We maintain a 2-D table.
// dp[i][j] is the minimum health value before he enters (i,j). h[0][0] is the value of the answer.
public class DungeonPrincess {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - a.get(m-1).get(n-1), 1);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - a.get(i).get(n-1), 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - a.get(m-1).get(j), 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - a.get(i).get(j), 1);
                int right = Math.max(dp[i][j + 1] - a.get(i).get(j), 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }
}
