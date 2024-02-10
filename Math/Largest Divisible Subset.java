368. Largest Divisible Subset

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        if(nums.length==1){
            subset.add(nums[0]);
            return subset;
        }

        Arrays.sort(nums);
        int n = nums.length;
        
        // DP array to store the size of the largest divisible subset ending at each index
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize all values to 1
        
        int maxSize = 0;
        int maxIndex = 0;
        
        // Build up the DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Track the maximum subset size and the index where it occurs
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        
        // Reconstruct the largest divisible subset
        
        int currSize = maxSize;
        int currNum = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (currSize == dp[i] && currNum % nums[i] == 0) {
                subset.add(nums[i]);
                currNum = nums[i];
                currSize--;
            }
        }
        
        return subset;
    }
}


==============================================Recursin gives tle===============================used taken not taken approach===========
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        helper(-1,0,nums,new ArrayList<Integer>());
        return ans;
    }
    public void helper(int prev,int idx,int nums[],List<Integer> temp){
        if(idx==nums.length){
            if(ans.size()<temp.size()){
                ans=new ArrayList<>(temp);
            }
            return;
        }
        if(prev==-1 || nums[idx]%prev==0){
            temp.add(nums[idx]);
            helper(nums[idx],idx+1,nums,temp);
            temp.remove(temp.size()-1);
        }
        helper(prev,idx+1,nums,temp);
    }
}
