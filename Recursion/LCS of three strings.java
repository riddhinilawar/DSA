LCS of three strings


Given 3 strings A, B and C, the task is to find the length of the longest sub-sequence that is common in all the three given strings.

Example 1:

Input:
A = "geeks"
B = "geeksfor", 
C = "geeksforgeeks"
Output: 5
Explanation: 
"geeks"is the longest common
subsequence with length 5.
Example 2:

Input: 
A = "abcd"
B = "efgh"
C = "ijkl"
Output: 0
Explanation: 
There's no subsequence common
in all the three strings.
Your Task:
You don't need to read input or print anything. Your task is to complete the function LCSof3() which takes the strings A, B, C and their lengths n1, n2, n3 as input and returns the length of the longest common subsequence in all the 3 strings.

Expected Time Complexity: O(n1*n2*n3).
Expected Auxiliary Space: O(n1*n2*n3).

Constraints:
1 <= n1, n2, n3 <= 20
Elements of the strings consitutes only of the lower case english alphabets.



class Solution { 
    int dp[][][];
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) { 
        dp=new int[A.length()][B.length()][C.length()];
        for(int i[][]:dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        return getSubSequence(0,0,0,A,B,C);
    }
    
    int getSubSequence(int i,int j,int k,String A, String B, String C){
       if(i>=A.length() || j>=B.length() || k>=C.length()){
           return 0;
       }
       if(dp[i][j][k]!=-1){
           return dp[i][j][k];
       }
       if(A.charAt(i)==B.charAt(j) && B.charAt(j)==C.charAt(k)){
           return 1+getSubSequence(i+1,j+1,k+1,A,B,C);
       }
       else{
           int total=0;
           total=Math.max(total,getSubSequence(i+1,j,k,A,B,C));
           total=Math.max(total,getSubSequence(i,j+1,k,A,B,C));
           total=Math.max(total,getSubSequence(i,j,k+1,A,B,C));
           total=Math.max(total,getSubSequence(i+1,j+1,k,A,B,C));
           total=Math.max(total,getSubSequence(i,j+1,k+1,A,B,C));
           total=Math.max(total,getSubSequence(i+1,j,k+1,A,B,C));
           return dp[i][j][k]=total;
       }
    }
    

}
