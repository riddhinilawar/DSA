673. Number of Longest Increasing Subsequence

Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106


class Solution {
    HashMap<Integer,int[]> dp;
    public int findNumberOfLIS(int[] nums) {
        dp=new HashMap<>();
        int n=nums.length;
        int max=0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            int temp[]= helper(i,nums,n);
            int negMax=temp[0];
            int negMaxCount=temp[1];

            if(max<negMax){
                max=negMax;
                maxCount=negMaxCount;
            }
            else if(max==negMax){
                maxCount+=negMaxCount;
            }
        }
        return maxCount;
    }
    public int[] helper(int idx,int nums[],int n){
        int max=0;
        int maxCount=0;

        if(dp.containsKey(idx)){
            return dp.get(idx);
        }

        for(int i=idx+1;i<n;i++){
            if(nums[idx]<nums[i]){
                int temp[]=helper(i,nums,n);
                int negMax=temp[0];
                int negMaxCount=temp[1];

                if(max<negMax){
                    max=negMax;
                    maxCount=negMaxCount;
                }
                else if(max==negMax){
                    maxCount+=negMaxCount;
                }
            }
        }

        //is the last number of sequence to incrementing the count//
        if(maxCount==0)maxCount=1;
        
        dp.put(idx,new int[]{max+1,maxCount});
        return new int[]{max+1,maxCount};
    }
}
