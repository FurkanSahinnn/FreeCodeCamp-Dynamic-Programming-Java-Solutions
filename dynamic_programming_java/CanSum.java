package dynamic_programming_java;

import java.util.Arrays;
import java.util.HashMap;

public class CanSum {
    public CanSum() {}

    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : numbers) {
            if (canSum(targetSum - num, numbers)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canSumMemoization(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum == 0) {
            return true;
        }

        if (targetSum < 0) {
            return false;
        }

        for (int num : numbers) {
            if (canSumMemoization(targetSum - num, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
    public static boolean canSumTabulation(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i <= targetSum; i++) {
            for (int number : numbers) {
                if ((i + number <= targetSum) && table[i]) {
                    table[i + number] = true;
                }
            }
        }

        return table[targetSum];
    }
}
