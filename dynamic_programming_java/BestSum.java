package dynamic_programming_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BestSum {
    public static ArrayList<Integer> bestSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if (targetSum < 0) {
            return null;
        }

        ArrayList<Integer> shortestCombination = null;
        for (int number : numbers) {
            ArrayList<Integer> combination = bestSum(targetSum - number, numbers);
            if (combination != null) {
                combination.add(number);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        return  shortestCombination;
    }

    public static ArrayList<Integer> bestSumMemoization(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if (targetSum < 0) {
            return null;
        }

        ArrayList<Integer> shortestCombination = null;
        for (int number : numbers) {
            ArrayList<Integer> combination = bestSumMemoization(targetSum - number, numbers, memo);
            if (combination != null) {
                combination.add(number);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return memo.get(targetSum);
    }

    public static ArrayList<Integer> bestSumTabulation(int targetSum, int[] numbers) {
        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int number : numbers) {
                    if (i + number <= targetSum) {
                        if (table[i + number] != null) {
                            if (table[i + number].size() >= table[i].size() + 1) {
                                table[i + number] = new ArrayList<>(table[i]);
                                table[i + number].add(number);
                            }
                        } else {
                            table[i + number] = new ArrayList<>(table[i]);
                            table[i + number].add(number);
                        }
                    }
                }
            }
        }

        return table[targetSum];
    }
}
