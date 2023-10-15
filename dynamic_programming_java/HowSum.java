package dynamic_programming_java;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class HowSum {
    public HowSum() {}

    public static ArrayList<Integer> howSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if (targetSum < 0) {
            return null;
        }

        for (int number : numbers) {
            ArrayList<Integer> result = howSum(targetSum - number, numbers);
            if (result != null) {
                result.add(number);
                return result;
            }
        }

        return null;
    }
    public static ArrayList<Integer> howSumMemoization(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if (targetSum < 0) {
            return null;
        }

        for (int number : numbers) {
            ArrayList<Integer> result = howSumMemoization(targetSum - number, numbers, memo);
            if (result != null) {
                result.add(number);
                memo.put(targetSum, result);
                return memo.get(targetSum);
            }
        }

        return null;
    }

    public static ArrayList<Integer> howSumTabulation(int targetSum, int[] numbers) {
        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];
        Arrays.fill(table, null);

        table[0] = new ArrayList<>();

        for(int i = 0 ; i <= targetSum ; i++){
            if(table[i] != null){
                for (int number : numbers) {
                    if (i + number <= targetSum) {
                        table[i + number] = new ArrayList<>(table[i]);
                        table[i + number].add(number);
                    }
                }
            }
        }

        return table[targetSum];
    }
}
