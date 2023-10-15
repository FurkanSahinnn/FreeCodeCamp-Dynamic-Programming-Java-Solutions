package dynamic_programming_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*
           ********************************
           * Testing Memoization Function *
           ********************************
         */

        // Fib
        HashMap<Integer, Integer> fibs_memo = new HashMap<Integer, Integer>();
        System.out.println(Fib.fib(6)); // 8
        System.out.println(Fib.fibMemoization(6, fibs_memo)); // 8
        System.out.println(fibs_memo); // {3=2, 4=3, 5=5, 6=8}

        // GridTraveller
        HashMap<String, Integer> travelers_memo = new HashMap<String, Integer>();
        System.out.println(GridTraveler.gridTravelerMemoization(3, 3, travelers_memo)); // 6
        System.out.println(travelers_memo); // {2,1=1, 1,2=1, 3,1=1, 2,2=2, 1,3=1, 3,2=3, 2,3=3, 3,3=6}

        // Cansum
        System.out.println(CanSum.canSum(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(CanSum.canSum(7, new int[]{2, 4})); // false

        HashMap<Integer, Boolean> canSum_memo = new HashMap<Integer, Boolean>();
        System.out.println(CanSum.canSumMemoization(7, new int[]{5, 3, 4, 7}, canSum_memo)); // true
        System.out.println(canSum_memo); // {1=false, 2=false, 4=true, 7=true}

        // HowSum
        System.out.println(HowSum.howSum(7, new ArrayList<>(Arrays. asList(5, 3, 4, 7)))); // [4, 3]
        System.out.println(HowSum.howSum(7, new ArrayList<>(Arrays. asList(2, 3, 5)))); // [3, 2, 2]
        System.out.println(HowSum.howSum(7, new ArrayList<>(Arrays. asList(2, 4)))); // null

        HashMap<Integer, ArrayList<Integer>> hs_memo = new HashMap<Integer, ArrayList<Integer>>();
        System.out.println(HowSum.howSumMemoization(7, new ArrayList<>(Arrays. asList(5, 3, 4, 7)), hs_memo)); // [4, 3]
        System.out.println(hs_memo); // {4=[4, 3], 7=[4, 3]}

        // BestSum
        HashMap<Integer, ArrayList<Integer>> bs_memo = new HashMap<Integer, ArrayList<Integer>>();
        System.out.println(BestSum.bestSum(8, new ArrayList<>(Arrays.asList(2, 3, 5)))); // [5, 3]
        System.out.println(BestSum.bestSumMemoization(8, new ArrayList<>(Arrays. asList(2, 3, 5)), bs_memo)); // [5, 3]
        System.out.println(bs_memo); // {1=null, 2=[2, 2, 2, 3], 3=[3, 3, 2, 2, 5], 4=[2, 2, 2, 3], 5=[5, 3], 6=[3, 3, 2, 2, 5], 8=[5, 3]}

        // CanConstruct
        HashMap<String, Boolean> canConstruct_memo = new HashMap<>();
        System.out.println(CanConstruct.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(CanConstruct.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(CanConstruct.canConstructMemoization("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, canConstruct_memo)); // false
        System.out.println(canConstruct_memo); // {teboard=false, ard=false, eboard=false, ateboard=false, skateboard=false, d=false, board=false}

        // CountConstruct
        System.out.println(CountConstruct.countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        System.out.println(CountConstruct.countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // 1
        System.out.println(CountConstruct.countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2

        HashMap<String, Integer> countConstruct_memo = new HashMap<>();
        System.out.println(CountConstruct.countConstructMemoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, countConstruct_memo)); // 1
        System.out.println(countConstruct_memo); // {ef=0, def=1, abcdef=1, cdef=0}

        // AllConstruct
        System.out.println(AllConstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"})); // [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
        System.out.println(AllConstruct.allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // [[purp, le], [p, ur, p, le]]

        HashMap<String, ArrayList<ArrayList<String>>> allConstruct_memo = new HashMap<>();
        System.out.println(AllConstruct.allConstructMemoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, allConstruct_memo)); // [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
        System.out.println(allConstruct_memo); // {ef=[[ef]], def=[[def]], abcdef=[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]], cdef=[[cd, ef], [c, def]]}

        /*
           ********************************
           * Testing Tabulation Function. *
           ********************************
        */

        // Fib
        System.out.println(Fib.fibTabulation(6)); // 8

        // GridTraveller
        System.out.println(GridTraveler.gridTravelerTabulation(3, 3)); // 6

        // CanSum
        System.out.println(CanSum.canSumTabulation(7, new int[]{5, 3, 4})); // true
        System.out.println(CanSum.canSumTabulation(7, new int[]{5, 2, 4})); // true
        System.out.println(CanSum.canSumTabulation(7, new int[]{5, 3, 3})); // false
        System.out.println(CanSum.canSumTabulation(7, new int[]{5, 1, 4})); // true
        System.out.println(CanSum.canSumTabulation(7, new int[]{5, 4, 4})); // false
        System.out.println(CanSum.canSumTabulation(7, new int[]{2, 4})); // false
        System.out.println(CanSum.canSumTabulation(300, new int[]{7, 14})); // false
        System.out.println(CanSum.canSumTabulation(8, new int[]{2, 3, 5})); // true

        // HowSum
        System.out.println(HowSum.howSumTabulation(7, new int[]{5, 3, 4})); // [3, 4]
        System.out.println(HowSum.howSumTabulation(7, new int[]{2, 3})); // [3, 2, 2]
        System.out.println(HowSum.howSumTabulation(7, new int[]{5, 3, 4, 7})); // [4, 3]
        System.out.println(HowSum.howSumTabulation(7, new int[]{2, 4})); // null
        System.out.println(HowSum.howSumTabulation(8, new int[]{2, 3, 5})); // [2, 2, 2, 2]

        // BestSum
        System.out.println(BestSum.bestSumTabulation(8, new int[]{2, 3, 5})); // [5, 3]

        // CanConstruct
        System.out.println(CanConstruct.canConstructTabulation("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(CanConstruct.canConstructTabulation("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false

        // CountConstruct
        System.out.println(CountConstruct.countConstructTabulation("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2
        System.out.println(CountConstruct.countConstructTabulation("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // 1
        System.out.println(CountConstruct.countConstructTabulation("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0

        // AllConstruct
        System.out.println(AllConstruct.allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"})); // [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
    }
}
