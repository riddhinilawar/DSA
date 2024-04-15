
312. Burst Balloons

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
===================================Recursion =====Backtracking======TLE==================tc==n*(n*(n+1))/2*300=====goes around 10 pow 9==========
class Solution {
    //backtracking question
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int vis[]=new int[n];
        return helper(nums,vis,n,0);
    }
    public int helper(int nums[],int vis[],int n,int count){
        //count check how many non visited nodes are yet to traverse
        if(count==n){
            return 0;
        }

        int max=0;
        //check all non visited nodes
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                vis[i]=1;

                int currCost=nums[i];
                int leftCost=1;
                int rightCost=1;

                //get the left non visited node cost
                for(int j=i-1;j>=0;j--){
                    if(vis[j]!=1){
                        leftCost=nums[j];
                        break;
                    }
                }

                //get the right non visited node cost
                for(int j=i+1;j<n;j++){
                    if(vis[j]!=1){
                        rightCost=nums[j];
                        break;
                    }
                }

                //multiply them
                currCost=currCost*rightCost*leftCost;

                //pass it to the recursive function
                max=Math.max(max,currCost+helper(nums,vis,n,count+1));

                //unvisit the visited node
                vis[i]=0;
            }
        }
        return max;
    }
}
