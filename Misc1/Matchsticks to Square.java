473. Matchsticks to Square

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108

class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum=0;
        for(int matchstick : matchsticks){
            sum+=matchstick;
        }

        if(sum%4!=0)return false;
        for(int matchstick : matchsticks){
            if(matchstick > sum/4){
                return false;
            }
        }

        int vis[]=new int[15];

        int all=(int)Math.pow(2,matchsticks.length);

        for(int i=0;i<all;i++){

            int temp=0,count=0;
            
			for(int j=0;j<15;j++){
                if((i&(1<<j))!=0){
                    
                    temp+=matchsticks[j];
                    if(temp>sum){
                        break;
                    }
                    if(temp==sum){
                        temp=0;
                        count++;
                    
                    }
                }
            }
            if(count==4)return true;
        }

        return false;
	}
}
