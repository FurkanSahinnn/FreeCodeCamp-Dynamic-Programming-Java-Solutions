package dynamic_programming_java;

import java.util.Arrays;
import java.util.HashMap;

public class GridTraveler {
    public GridTraveler() {}


    public static int gridTraveler(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        int right = gridTraveler(m, n - 1);
        int down = gridTraveler(m - 1, n);

        return right + down;
    }

    public static int gridTravelerMemoization(int m, int n, HashMap<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        int right = gridTravelerMemoization(m, n - 1, memo);
        int down = gridTravelerMemoization(m - 1, n, memo);

        memo.put(key, right + down);
        return memo.get(key);
    }
    public static int gridTravelerTabulation(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = 0;
            }
        }
        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = table[i][j];
                if (j + 1 <= n) {
                    table[i][j + 1] += current;
                }
                if (i + 1 <= m) {
                    table[i + 1][j] += current;
                }

            }
        }

        return table[m][n];

    }
}
