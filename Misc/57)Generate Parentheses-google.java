Generate Parentheses ,gfg    - recursion                    LC-22                                                                     
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]
 
Constraints:
•	1 <= n <= 8
Expected Time Complexity: O(2Number of Digits in N)
Expected Auxiliary Space: O(2Number of Digits in N)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<String>();
        getAll("(",1,0,ans,n);
        return ans;
    }
    public void getAll(String curr, int open, int close, List<String> ans, int n)
    {
        if(curr.length()==(2*n))
        {
            ans.add(curr);
            return;
        }
        if(open<n)getAll(curr+'(',open+1,close,ans,n);
        if(close<open)getAll(curr+')',open,close+1,ans,n);
       
    }
}
Time Complexity: O(N*2)!
