Longest Palindromic substring- gfg                                     LC-5
Given a string s, return the longest palindromic substring in s.
A string is called a palindrome string if the reverse of that string is the same as the original string.
Example 1:         Input: s = "babad"                    Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:     Input: s = "cbbd"                  Output: "bb"
Constraints:
•	1 <= s.length <= 1000
•	s consist of only digits and English letters.
Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1)return s;
        boolean track[][]=new boolean[n][n];
        int maxlengthpalindrome=0,  left=0, right=0;

        for(int diag=n;diag>0;diag--)
        {
            for(int i=0,j=n-diag;i<diag;i++,j++)
            {//1st condition
                if(diag==n)
                    track[i][j]=true;//2nd condition
                else if(diag==(n-1))
                {   
                    if(s.charAt(i)==s.charAt(j))
                    {
                        track[i][j]=true;
                        if((j-i)>maxlengthpalindrome)
                        {
                            left=i;
                            right=j;
                        }
                    }
                }//3rd condition
                else
                {
                    if(((s.charAt(i)==s.charAt(j)) && (track[i+1][j-1]==true)) ==true)
                    {
                        track[i][j]=true;
                        if((j-i)>maxlengthpalindrome)
                        {
                            left=i;
                            right=j;
                        }
                    }   
                }
            }
        }
        String ans="";
        for(int k=left;k<=right;k++)
            ans+=s.charAt(k);
        return ans;
    }}
