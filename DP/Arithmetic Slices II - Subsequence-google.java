446. Arithmetic Slices II - Subsequence

Given an integer array nums, return the number of all the arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.

 

Example 1:

Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
Example 2:

Input: nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.
 

Constraints:

1  <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
==================================================Recursion===============================TLE===============TC:2 power n
class Solution {
    int ans=0;
    ArrayList<Integer> list = new ArrayList<>();
    public int numberOfArithmeticSlices(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //list.add(i);
            helper(i,nums,Long.MIN_VALUE,1);
            //list.remove(list.size()-1);
        }
        return ans;
    }
    public void helper(int idx,int nums[],long diff,int count){
        
        if(count>=3){
            //System.out.println(list);
            ans+=1;
        }
        
        for(int i=idx+1;i<nums.length;i++){
            if(diff==Long.MIN_VALUE || (long)nums[idx]-(long)nums[i] == diff){
                //list.add(i);
                helper(i,nums,(long)nums[idx]-(long)nums[i],count+1);
                //list.remove(list.size()-1);
            }
        }

    }
}

=============================================memo diff check======================Accepted==============((n*(n+1))/2)*n(mostly less )
class Solution {
    int ans=0;
    ArrayList<Integer> list = new ArrayList<>();
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int dp[]=new int[n];
                Arrays.fill(dp,-1);
                long diff=(long)nums[i]-(long)nums[j];
                ans+=helper(j,nums,diff,dp);
            }
        }
        return ans;
    }
    public int helper(int idx,int nums[],long diff,int dp[]){
        int ans=0;
        if(dp[idx]!=-1)return dp[idx];
        for(int i=idx+1;i<nums.length;i++){
            if((long)nums[idx]-(long)nums[i] == diff){
                //list.add(i);
                ans+=(1+helper(i,nums,diff,dp));
                //list.remove(list.size()-1);
            }
        }

        return dp[idx]=ans;
    }
}
