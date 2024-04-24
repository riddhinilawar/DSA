300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing 
subsequence 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
=============================================================Type1)Recursion=================================2 power n===
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,helper(i,nums,n));
        }
        return ans+1;
    }
    public int helper(int idx,int nums[],int n){
        int max=0;
        for(int i=idx+1;i<n;i++){
            if(nums[idx]<nums[i]){
                max=Math.max(max,1+helper(i,nums,n));
            }
        }
        return max;
    }
}

=====================================================Type1)DP============================

  class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans=0;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,helper(i,nums,n,dp));
        }
        return ans+1;
    }
    public int helper(int idx,int nums[],int n,int dp[]){
        int max=0;
        if(dp[idx]!=-1)return dp[idx];
        for(int i=idx+1;i<n;i++){
            if(nums[idx]<nums[i]){
                max=Math.max(max,1+helper(i,nums,n,dp));
            }
        }
        return dp[idx]=max;
    }
}
=============================Type 1)Tabulation=============================

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int len : dp) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
====================================Tabulation exact same version of dp===========================
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int ans=0;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=n-1;i>=0;i--){
            ans=Math.max(ans,helper(i,nums,n,dp));
        }
        return ans+1;
    }
    public int helper(int idx,int nums[],int n,int dp[]){
        int max=0;
        if(dp[idx]!=-1)return dp[idx];
        for(int i=idx+1;i<n;i++){
            if(nums[idx]<nums[i]){
                max=Math.max(max,1+dp[i]);
            }
        }
        return dp[idx]=max;
    }
}
