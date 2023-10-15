package dynamic_programming_java;

import java.util.Arrays;
import java.util.HashMap;

public class CanConstruct {
    public static boolean canConstruct(String target, String[] wordBank) {
        if (target.equals("")) {
            return true;
        }

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String subStr = target.substring(word.length());
                if (canConstruct(subStr, wordBank)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canConstructMemoization(String target, String[] wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.equals("")) {
            return true;
        }

        for (String word : wordBank) {
            if (target.length() >= word.length() && target.subSequence(0, word.length()).equals(word)) {
                String subStr = target.substring(word.length());
                if (canConstructMemoization(subStr, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

    public static boolean canConstructTabulation(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        // 0  1  2  3  4  5  6
        // T  F  F  F  F  F  F
        // a  b  c  d  e  f


        for (int i = 0 ; i <= target.length(); i++) {
            if (table[i]) {
                for (String word : wordBank) {
                    if (target.startsWith(word, i) && (i + word.length()) <= target.length()) {
                        table[i + word.length()] = true;
                    }
                }
            }

        }

        return table[target.length()];
    }
}
