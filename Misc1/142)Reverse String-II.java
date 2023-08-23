Reverse String-II                                                                    LC-541
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 
Example 1:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:
Input: s = "abcd", k = 2
Output: "bacd"
 
Constraints:
•	1 <= s.length <= 104
•	s consists of only lowercase English letters.
•	1 <= k <= 104
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    public String reverseStr(String S, int k) {
        
        char s[]=S.toCharArray();
        
        for(int i=0;i<S.length();i=i+k+k)
        {
            int l=i;
            int r=i+k-1;
            if(r>=S.length())r=S.length()-1;
        
            while(l<r)
            {
                char c=s[l];
                s[l]=s[r];
                s[r]=c;
            
                l++;
                r--;
            }
        }
        
        return String.valueOf(s);
    }
}
