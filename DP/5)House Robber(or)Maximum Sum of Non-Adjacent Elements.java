198. House Robber
Solved
Medium
Topics
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400




=======================================================Recursion===========================================
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        return helper(n-1,nums);
    }
    public int helper(int n,int nums[]){
        if(n==0){
            return nums[0];
        }

        if(n==1){
            return Math.max(nums[0],nums[1]);
        }

        return Math.max(helper(n-1,nums),helper(n-2,nums)+nums[n]);
    }
}

TC:(2^n)
SC:O(n) Stack space

===================================================Memoization=====================================================
class Solution {
    public int rob(int[] nums) {

        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
    public int helper(int n,int nums[],int[] dp){
        if(n==0){
            return nums[0];
        }

        if(n==1){
            return Math.max(nums[0],nums[1]);
        }

        if(dp[n]!=-1)return dp[n];

        return dp[n]=Math.max(helper(n-1,nums,dp),helper(n-2,nums,dp)+nums[n]);
    }
}

Tc:O(n)
Sc:O(n)
==================================================Tabulation=======================================================
class Solution {
    public int rob(int[] nums) {

        int n=nums.length;
        int dp[]=new int[n];

        dp[0]=nums[0];
        if(n==1)return dp[n-1];

        dp[1]=Math.max(nums[0],nums[1]);
        if(n==2)return dp[n-1];

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }


        return dp[n-1];
    }
}

Tc:O(n)
Sc:O(n)

=============================Space Optimization======================================================

class Solution {
    public int rob(int[] nums) {

        int n=nums.length;

        int secondLast=nums[0];
        if(n==1)return secondLast;

        int last=Math.max(nums[0],nums[1]);
        if(n==2)return last;

        for(int i=2;i<n;i++){
            int temp=Math.max(last,secondLast+nums[i]);
            secondLast=last;
            last=temp;
        }


        return last;
    }
}


Tc:O(n)
Sc:O(1)
