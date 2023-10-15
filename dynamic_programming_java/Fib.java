package dynamic_programming_java;

import java.util.Arrays;
import java.util.HashMap;

public class Fib {
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
    public static int fibMemoization(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 2) {
            return 1;
        }
        memo.put(n, fibMemoization(n - 1, memo) + fibMemoization(n - 2, memo));
        return memo.get(n);
    }
    public static int fibTabulation(int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);
        table[1] = 1;

        for (int i = 0; i < n; i++) {
            if (i + 1 == n) {
                table[i + 1] += table[i];
            } else {
                table[i + 1] += table[i];
                table[i + 2] += table[i];
            }
        }

        return table[n];
    }
}
