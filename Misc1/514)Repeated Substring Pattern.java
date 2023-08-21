Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

-----------------------------------------------------------------------------------------------------------------------
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }
}
----------------------------------------------------------------------------------------------------------------------------
Approach 2/2: Clever String Manipulation
The idea behind this approach is that if a string s can be constructed by repeating a substring, then concatenating two copies of s together and removing the first and last character would still contain s as a substring.

Key Data Structures:
Concatenated String: A string formed by concatenating s with itself.
Enhanced Breakdown:
Initialization:

Concatenate string s with itself.
Check for Repeated Pattern:

Remove the first and last character from the concatenated string and check if the original string s is present.
Wrap-up:

Return True if the string is present, otherwise False.
Example:
Given the string "abab":

Concatenate to get "abababab".
Remove first and last characters to get "bababa".
Check if "abab" is present in "bababa" - It is. Hence, return True.
