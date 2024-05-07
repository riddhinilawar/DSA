Longest Repeating Subsequence

Given string str, find the length of the longest repeating subsequence such that it can be found twice in the given string.

The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B. For example, A = "xax" and B = "xax" then the index of first "x" must be different in the original string for A and B.

Example 1:

Input:
str = "axxzxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x z x y 
0 1 2 3 4 5

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 4  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.
Example 2:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.

subsequence A
x x
0 1  <-- index of subsequence A
------
1 2  <-- index of str 


subsequence B
x x
0 1  <-- index of subsequence B
------
2 3  <-- index of str 

We are able to use character 'x' 
(at index 2 in str) in both subsequences
as it appears on index 1 in subsequence A 
and index 0 in subsequence B.

Your Task:
You don't need to read or print anything. Your task is to complete the LongestRepeatingSubsequence() which takes str as input parameter and returns the length of the longest repeating subsequnece.


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n2)


Constraints:
1 <= |str| <= 103




//User function Template for Java

class Solution{
    Integer dp[][];
    public int LongestRepeatingSubsequence(String str){
        int n=str.length();
        dp=new Integer[n][n];
        return helper(str,0,0);
    }
    public int helper(String str,int idx1,int idx2){
        if(idx1==str.length() || idx2==str.length()){
            return 0;
        }
        if(dp[idx1][idx2]!=null){
            return dp[idx1][idx2];
        }
        if(idx1!=idx2 && str.charAt(idx1)==str.charAt(idx2)){
            return dp[idx1][idx2]= 1+helper(str,idx1+1,idx2+1);
        }
        
        return dp[idx1][idx2] = Math.max(helper(str,idx1+1,idx2),helper(str,idx1,idx2+1));
    }
}

============================================================================================

class Solution{
    Integer dp[][];
    public int LongestRepeatingSubsequence(String str){
        int n=str.length();
        dp=new Integer[n+1][n+1];
      
        for(int i=0;i<=n;i++){
            dp[i][n]=0;
            dp[n][i]=0;
        }
        
        for(int idx1=n-1;idx1>=0;idx1--){
            for(int idx2=n-1;idx2>=0;idx2--){
                    
                if(idx1!=idx2 && str.charAt(idx1)==str.charAt(idx2)){
                    dp[idx1][idx2]= 1+dp[idx1+1][idx2+1];
                }
                else{
                    dp[idx1][idx2] = Math.max(dp[idx1+1][idx2],dp[idx1][idx2+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
