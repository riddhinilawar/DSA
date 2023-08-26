Longest K unique characters substring


Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with 3 distinct characters.
Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: 
There's no substring with 2 distinct characters.
Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 26
All characters are lowercase latin characters.

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int[] freq = new int[128]; // Array to store character frequencies
        int cnt = 0; // Count of unique characters in the current window
        int l = 0, max = 0;

        for (int i= 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 0) {
                cnt++;
            }
            freq[s.charAt(i)]++;

            while (cnt > k) {
                freq[s.charAt(l)]--;
                if (freq[s.charAt(l)] == 0) {
                    cnt--;
                }
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        if (max < k) return -1;
        return max;
    }
}
