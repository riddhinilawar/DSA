Note::Same as previous need to apply the same logic but 2 times
1)excluding last element
2)excluding first element
return max of both the possibilities as both can't be in robbed due to adjacency


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000

For first 3 approaches refer previous file.
================================================space optimization=================================

  class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]); 
        return Math.max(helper(0,n-2,nums),helper(1,n-1,nums));
    }
    public int helper(int start, int end, int[] nums) {

        int secondLast=nums[start];
        int last=Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            int temp=Math.max(last,secondLast+nums[i]);
            secondLast=last;
            last=temp;
        }


        return last;
    }
}
