Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.

class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int totalPalindromicSubstring=0;

        for(int diag=0;diag<n;diag++){
            for(int i=0,j=diag;j<n;i++,j++){
                if(diag==0){
                    dp[i][j]=true;
                    totalPalindromicSubstring++;
                }
                else if(diag==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                        totalPalindromicSubstring++;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        totalPalindromicSubstring++;
                    }
                }
            }
        }

        return totalPalindromicSubstring;
    }
}

=============================================================================================================

public class Solution {
    private String t;
    
    private int check(int l, int r, int ans) {
        while (l >= 0 && r < t.length()) {
            if (t.charAt(l--) == t.charAt(r++)) 
                ans++;
            else 
                break;
        }
        return ans;
    }
    
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        t = s;
        
        for (int i = 0; i < n; i++) {
            ans += check(i, i, 0);    // odd length palindromes
            ans += check(i, i + 1, 0); // even length palindromes
        }
        
        return ans;
    }
}
