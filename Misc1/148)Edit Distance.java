72. Edit Distance


Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.



class Solution {
    public int minDistance(String str1, String str2) {
        int temp[][] = new int[str1.length()+1][str2.length()+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1;i <=str1.length(); i++){
            for(int j=1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + Math.min(temp[i-1][j-1], Math.min(temp[i-1][j], temp[i][j-1]));
                }
            }
        }
        
        return temp[str1.length()][str2.length()];
    }
}

-------------------------------------------------------------------------------------------------------------------------
  import java.util.*;

class TUF{
static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp){
    
    if(i<0)
        return j+1;
    if(j<0)
        return i+1;
        
    if(dp[i][j]!=-1) return dp[i][j];
        
    if(S1.charAt(i)==S2.charAt(j))
        return dp[i][j] =  0+editDistanceUtil(S1,S2,i-1,j-1,dp);
        
    // Minimum of three choices
    else return dp[i][j] = 1+Math.min(editDistanceUtil(S1,S2,i-1,j-1,dp),
    Math.min(editDistanceUtil(S1,S2,i-1,j,dp),editDistanceUtil(S1,S2,i,j-1,dp)));
    
}

static int editDistance(String S1, String S2){
    
    int n = S1.length();
    int m = S2.length();
    
    int[][] dp=new int[n][m];
    for(int row[]: dp)
    Arrays.fill(row,-1);
    return editDistanceUtil(S1,S2,n-1,m-1,dp);
    
}

public static void main(String args[]) {

  String s1 = "horse";
  String s2 = "ros";

  System.out.println("The minimum number of operations required is: "+
  editDistance(s1,s2));
}
}
