Distinct occurrences


Given two strings s and t of length n and m respectively. Find the count of distinct occurrences of t in s as a sub-sequence modulo 109 + 7.

Example 1:

Input:
s = "banana" , t = "ban"
Output: 
3
Explanation: 
There are 3 sub-sequences:[ban], [ba n], [b an].
Example 2:

Input:
s = "geeksforgeeks" , t = "ge"
Output: 
6
Explanation: 
There are 6 sub-sequences:[ge], [ge], [g e], [g e] [g e] and [g e].
Your Task:
You don't need to read input or print anything.Your task is to complete the function subsequenceCount() which takes two strings as argument s and t and returns the count of the sub-sequences modulo 109 + 7.

Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1 ≤ n,m ≤ 1000

==============================================MEMOIZATION==========================================
TC:O(n*m) SC:O(n*m)
  
  class Solution{
    int dp[][];
    int mod=1000000007;
    int  subsequenceCount(String sentence, String target){
        dp=new int[sentence.length()+1][target.length()+1];
        for(int temp[]:dp)Arrays.fill(temp,-1);
	    return helper(0,0,sentence,target,sentence.length(),target.length());
    }
    
    int helper(int sentenceIdx,int targetIdx,String sentence,String target,int sentenceLen,int targetLen){
        if(targetIdx==targetLen){
            return 1;
        }
        
        if(sentenceIdx==sentenceLen){
            return 0;
        }
        
        if(dp[sentenceIdx][targetIdx]!=-1){
            return dp[sentenceIdx][targetIdx];
        }
        
        int total=0;
        for(int i=sentenceIdx;i<sentenceLen;i++){
            
            if(sentence.charAt(i)==target.charAt(targetIdx)){
                total=((helper(i+1,targetIdx+1,sentence,target,sentenceLen,targetLen))%mod+total)%mod;
            }
            
        }
        return dp[sentenceIdx][targetIdx]=total%mod;
    }
}


=======================================TLE -SIMPLE RECURSION================================



/*You are required to complete this method*/

class Solution{
    int  subsequenceCount(String sentence, String target){
        
	    return helper(0,0,sentence,target,sentence.length(),target.length());
    }
    
    int helper(int sentenceIdx,int targetIdx,String sentence,String target,int sentenceLen,int targetLen){
        if(targetIdx==targetLen && sentence.charAt(sentenceIdx-1)==target.charAt(targetIdx-1)){
            return 1;
        }
        
        if(sentenceIdx==sentenceLen || targetIdx==targetLen){
            return 0;
        }
        
        int total=0;
        for(int i=sentenceIdx;i<sentenceLen;i++){
            
            if(sentence.charAt(i)==target.charAt(targetIdx)){
                total+=helper(i+1,targetIdx+1,sentence,target,sentenceLen,targetLen);
            }
            
        }
        return total;
    }
}


TC:exponential-->can be -->sumbmission of(n!)
Let's denote:

n as the length of the s string
m as the length of the t string
In the worst case scenario:

The recursive function explores all positions in the s string. This can happen n times.
For each position, it checks all characters to find matches with the t string. This can happen m times in the worst case.
Therefore, the overall time complexity of this algorithm is O(2^n * m), where n is the length of the s string and m is the length of the t string. However, this complexity can be reduced by memoization, which would cache the results of previous recursive calls and avoid redundant calculations.
SC:o(n)Stack space
