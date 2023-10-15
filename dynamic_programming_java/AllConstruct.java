package dynamic_programming_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class AllConstruct {
    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) {
            ArrayList<ArrayList<String>> emptyWays = new ArrayList<>();
            emptyWays.add(new ArrayList<>()); // target == "" -> emptyWays -> [[]]
            return emptyWays;
        }

        ArrayList<ArrayList<String>> solutions = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> ways = allConstruct(suffix, wordBank);
                ArrayList<String> way;
                for (ArrayList<String> strings : ways) {
                    way = new ArrayList<>(strings);
                    way.add(0, word);
                    solutions.add(way);
                }
            }
        }

        return solutions;
    }


    public static ArrayList<ArrayList<String>> allConstructMemoization(String target, String[] wordBank, HashMap<String,ArrayList<ArrayList<String>>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.isEmpty()) {
            ArrayList<ArrayList<String>> emptyWays = new ArrayList<>();
            emptyWays.add(new ArrayList<>()); // target == "" -> emptyWays -> [[]]
            return emptyWays;
        }

        ArrayList<ArrayList<String>> solutions = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> ways = allConstructMemoization(suffix, wordBank, memo);
                ArrayList<String> way;
                for (ArrayList<String> strings : ways) {
                    way = new ArrayList<>(strings);
                    way.add(0, word);
                    solutions.add(way);
                }
            }
        }

        memo.put(target, solutions);
        return solutions;
    }

    public static ArrayList<ArrayList<String>> allConstructTabulation(String target, String[] wordBank) {
        ArrayList<ArrayList<String>>[] table = new ArrayList[target.length() + 1];
        Arrays.fill(table, new ArrayList<>()); // [ ... ]
        table[0].add(new ArrayList<>()) ; // [[], ... ]

        for (int i = 0; i <= target.length(); i++) {
            if (!table[i].isEmpty()) {
                for (String word : wordBank) {
                    if ((i + word.length() <= target.length()) && target.startsWith(word, i)) {
                        for (ArrayList tableElement : table[i]) {
                            tableElement = new ArrayList(tableElement);
                            tableElement.add(word);
                            table[i + word.length()].add(tableElement);
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }
}
