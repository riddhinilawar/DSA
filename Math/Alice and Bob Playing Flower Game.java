3021. Alice and Bob Playing Flower Game

Alice and Bob are playing a turn-based game on a circular field surrounded by flowers. The circle represents the field, and there are x flowers in the clockwise direction between Alice and Bob, and y flowers in the anti-clockwise direction between them.

The game proceeds as follows:

Alice takes the first turn.
In each turn, a player must choose either the clockwise or anti-clockwise direction and pick one flower from that side.
At the end of the turn, if there are no flowers left at all, the current player captures their opponent and wins the game.
Given two integers, n and m, the task is to compute the number of possible pairs (x, y) that satisfy the conditions:

Alice must win the game according to the described rules.
The number of flowers x in the clockwise direction must be in the range [1,n].
The number of flowers y in the anti-clockwise direction must be in the range [1,m].
Return the number of possible pairs (x, y) that satisfy the conditions mentioned in the statement.

 

Example 1:

Input: n = 3, m = 2
Output: 3
Explanation: The following pairs satisfy conditions described in the statement: (1,2), (3,2), (2,1).
Example 2:

Input: n = 1, m = 1
Output: 0
Explanation: No pairs satisfy the conditions described in the statement.
 

Constraints:

1 <= n, m <= 105


class Solution {
    public long flowerGame(int n, int m) {
        
        //edge case
        if(n==1 && m==1)return 0;
        
        long ans=0;
        
        long mEven=m/2;
        long mOdd=(m%2==0)?m/2:(m/2)+1;
        
        long nEven=n/2;
        long nOdd=(n%2==0)?n/2:(n/2)+1;
     
        ans=(nOdd*mEven)+(nEven*mOdd);
        return ans;
    }
}
============================================================================================
class Solution {
    public long flowerGame(int n, int m) {
        
        //edge case
        if(n==1 && m==1)return 0;
        
        long ans=0;
        
        int mEven=m/2;
        int mOdd=(m%2==0)?m/2:(m/2)+1;
     
        for(int i=1;i<=n;i++){
            if(i%2==1){
                ans+=mEven;
            }
            else{
                ans+=mOdd;
            }
            //System.out.println(i+" "+ans);
        }
        return ans;
    }
}
