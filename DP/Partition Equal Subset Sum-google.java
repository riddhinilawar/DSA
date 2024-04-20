416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
===================================TLE==================RECURSION======================
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2==1)return false;
        int target=sum/2;

        return helper(0,nums,target,n);
    }
    public boolean helper(int idx,int nums[],int target,int n){
        if(target==0){
            return true;
        }
        if(idx==n){
            return false;
        }

        if(target>=nums[idx] && helper(idx+1,nums,target-nums[idx],n))return true;
        if(helper(idx+1,nums,target,n))return true;

        return false;
    }
}
============================================Accepted Memo========================================
class Solution {
    boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum+=num;
        }

        if(sum%2==1)return false;
        int target=sum/2;

        dp=new boolean[n][target+1];
        for(boolean[] d:dp)Arrays.fill(d,true);

        return helper(0,nums,target,n);
    }
    public boolean helper(int idx,int nums[],int target,int n){
        if(target==0){
            return true;
        }
        if(idx==n){
            return false;
        }
        if(dp[idx][target]==false){
            return false;
        }
        if(target>=nums[idx] && helper(idx+1,nums,target-nums[idx],n))return true;
        if(helper(idx+1,nums,target,n))return true;

        return dp[idx][target]=false;
    }
}
=============================================Tabulation=====================Accepted
  class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum+=num;
        }

        if(sum%2==1)return false;
        int targ=sum/2;

        boolean dp[][]=new boolean[n+1][targ+1];
        
        //base cases//
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=0;i<=targ;i++){
            dp[n][i]=false;
        }

        for(int idx=n-1;idx>=0;idx--){
            for(int target=1;target<=targ;target++){
                if(target>=nums[idx] && dp[idx+1][target-nums[idx]])
                    dp[idx][target]= true;
                if(dp[idx+1][target])
                    dp[idx][target]=true;
            }
        }


        return dp[0][targ];
        
    }
}
