Palindromes happen in a few different cases. Basically 6:

Single digit 9 -> 8
Trivial case: invert the first half and append to the first half: 123 -> 121
Increase the center-character by 1 and do the inversion: 121 -> 131,11799 -> 11811(11711)
Decrease the center-character by 1 and do the inversion: 121 -> 111,99800 -> 99899(99799)
Palindrome needs to grow by 1 digit: 99 -> 101
Palindrome needs to shorten by 1 digit: 100 -> 99
Note::18 digit number can be stored in long data type

564. Find the Closest Palindrome

Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.
The closest is defined as the absolute difference minimized between two integers.

Example 1:

Input: n = "123"
Output: "121"
Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.

Constraints:
1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        int len = n.length();
        if (len == 1) return Long.toString(number - 1);//handels single digit

        int center = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        String firstHalf = n.substring(0, center + 1);

        List<Long> candidates = new ArrayList<>();
        candidates.add(getPalindrome(firstHalf, len % 2 == 0)); // 12321
        candidates.add(getPalindrome(Long.toString(Long.parseLong(firstHalf) + 1), len % 2 == 0)); // 12421
        candidates.add(getPalindrome(Long.toString(Long.parseLong(firstHalf) - 1), len % 2 == 0)); // 12221
        candidates.add((long) (Math.pow(10, len - 1) - 1)); // 9999
        candidates.add((long) (Math.pow(10, len) + 1)); // 100001

        candidates.removeIf(candidate -> candidate == number);

        Collections.sort(candidates, (a, b) -> {
            long diffA = Math.abs(a - number);
            long diffB = Math.abs(b - number);
            if (diffA != diffB) return Long.compare(diffA, diffB);
            return Long.compare(a, b);
        });

        return Long.toString(candidates.get(0));
    }

    private long getPalindrome(String firstHalf, boolean even) {
        StringBuilder palindrome = new StringBuilder(firstHalf);
        if (even) palindrome.append(new StringBuilder(firstHalf).reverse());
        else palindrome.append(new StringBuilder(firstHalf).deleteCharAt(firstHalf.length() - 1).reverse());
        return Long.parseLong(palindrome.toString());
    }
}
