Variation of coin change.
we are given dp array that we created while finding number of ways to make the target sum. We need to find the coins array, using which this dp array is created.
Example:

target = 10
number of ways to make 10: 3
Input: [1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3]
Output: [2, 5, 6]

TC::N square
  
import java.util.ArrayList;
import java.util.List;

public class ConstructOriginalArray {
    public static List<Integer> constructOriginalArray(List<Integer> dp) {
        int target = dp.size() - 1;
        List<Integer> originalArr = new ArrayList<>();
        int n = dp.size();
        for (int i = 1; i < n; i++) {
            if (dp.get(i) == 1) {
                for (int j = n - 1; j >= i; j--) {
                    dp.set(j, dp.get(j) - dp.get(j - i));
                }
                originalArr.add(i);
            }
        }
        return originalArr;
    }

    public static void main(String[] args) {
        List<Integer> dp = List.of(1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3);
        List<Integer> originalArr = constructOriginalArray(dp);
        for (int num : originalArr) {
            System.out.print(num + " ");
        }
    }
}
===============leetcode playground=======================

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Integer> dp = List.of(1, 0, 1, 0, 1, 1, 2, 1, 2, 1, 3);
        List<Integer> originalArr = constructOriginalArray(new ArrayList<>(dp));
        for (int num : originalArr) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> constructOriginalArray(List<Integer> dp) {
        int target = dp.size() - 1;
        List<Integer> originalArr = new ArrayList<>();
        int n = dp.size();
        System.out.println(dp);
        for (int i = 1; i < n; i++) {
            if (dp.get(i) == 1) {
                for (int j = n - 1; j >= i; j--) {
                    dp.set(j, dp.get(j) - dp.get(j - i));
                }
                System.out.println(dp+" "+i);
                originalArr.add(i);
            }
        }
        return originalArr;
    }
}
