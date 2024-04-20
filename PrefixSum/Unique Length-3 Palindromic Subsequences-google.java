1930. Unique Length-3 Palindromic Subsequences

Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")
 

Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.

class Solution {
    public int countPalindromicSubsequence(String inputString) {
        // Arrays to store the first and last occurrences of each character in the input string
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        for (int i = 0; i < 26; i++) {
            firstOcc[i] = Integer.MAX_VALUE;
            lastOcc[i] = Integer.MIN_VALUE;
        }

        // Populate firstOcc and lastOcc arrays
        for (int i = 0; i < inputString.length(); i++) {
            int charIndex = inputString.charAt(i) - 'a';
            firstOcc[charIndex] = Math.min(firstOcc[charIndex], i);
            lastOcc[charIndex] = Math.max(lastOcc[charIndex], i);
        }

        // Variable to store the final count of unique palindromic subsequences
        int uniqueCount = 0;

        // Iterate over each character in the alphabet
        for (int charIndex = 0; charIndex < 26; charIndex++) {
            // Check if the character has occurred in the input string
            if (firstOcc[charIndex] == Integer.MAX_VALUE || lastOcc[charIndex] == Integer.MIN_VALUE) {
                continue; // No occurrences, move to the next character
            }

            // Set to store unique characters between the minimum and maximum occurrences
            HashSet<Character> uniqueCharsBetween = new HashSet<>();

            // Iterate over the characters between the minimum and maximum occurrences
            for (int j = firstOcc[charIndex] + 1; j < lastOcc[charIndex]; j++) {
                uniqueCharsBetween.add(inputString.charAt(j));
            }

            // Add the count of unique characters between the occurrences to the final count
            uniqueCount += uniqueCharsBetween.size();
        }

        // Return the total count of unique palindromic subsequences
        return uniqueCount;
    }
}
