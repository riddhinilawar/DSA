class Solution {
    //In stack if any element below u, is greater than u & its not last occ of that element then pop it.

    public String removeDuplicateLetters(String inputString) {
        Stack<Character> stack = new Stack<>();  // Stack to build the result
        int[] lastIndex = new int[26];           // Store the last index of each character
        boolean[] visited = new boolean[26];     // Track visited characters

    // Find the last index of each character
    for (int i = 0; i < inputString.length(); i++) {
        lastIndex[inputString.charAt(i) - 'a'] = i; 
    }

    for (int i = 0; i < inputString.length(); i++) {
        char c = inputString.charAt(i);
        int index = c - 'a';

        if (visited[index]) { 
            continue; // Character already seen, skip it
        }

        // If stack has characters greater than 'c' and they occur later, pop them
        while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
            visited[stack.pop() - 'a'] = false;  // Mark as unvisited
        }

        stack.push(c);     // Add current character
        visited[index] = true; // Mark as visited
    }

    // Build the lexicographically smallest string from the stack
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }
    return result.reverse().toString(); 
    }
}

316. Remove Duplicate Letters

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
