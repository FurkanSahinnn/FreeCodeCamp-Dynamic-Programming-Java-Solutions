package dynamic_programming_java;

import java.util.Arrays;
import java.util.HashMap;

public class CountConstruct {
    public static int countConstruct(String target, String[] wordBank) {
        int countTrueSolutions = 0;
        if (target.equals("")) {
            return 1;
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String subStr = target.substring(word.length());
                countTrueSolutions += countConstruct(subStr, wordBank);
            }
        }

        return countTrueSolutions;
    }

    public static int countConstructMemoization(String target, String[] wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.equals("")) {
            return 1;
        }

        int countTrueSolutions = 0;

        for (String word : wordBank) {
            if (target.length() >= word.length() && target.subSequence(0, word.length()).equals(word)) {
                String subStr = target.substring(word.length());
                countTrueSolutions += countConstructMemoization(subStr, wordBank, memo);
            }
        }

        memo.put(target, countTrueSolutions);
        return countTrueSolutions;
    }

    public static int countConstructTabulation(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        // 0  1  2  3  4  5  6
        // 1  0  0  0  0  0  0
        // p  u  r  p  l  e

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != 0) {
                for (String word : wordBank) {
                    if (target.startsWith(word, i) && (i + word.length()) <= target.length()) {
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }

        return table[target.length()];
    }
}
