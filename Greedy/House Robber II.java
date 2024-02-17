213. House Robber II

Note:Same as normal house robber problen ..just skip the first node and try to find the ans..skip last node and try to find tthe answer..return max of them
  
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


  class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        int withoutFirstIdx[]=new int[n];
        int withoutLastIdx[]=new int[n];

        if(n==1)return nums[0];
        int ans=0;

        withoutLastIdx[0]=nums[0];

        if(n>=2){
            withoutLastIdx[1]=Math.max(nums[0],nums[1]);
            withoutFirstIdx[1]=nums[1];
        }
        if(n==2)return withoutLastIdx[1];


        for(int i=2;i<n;i++){
            if(i<n-1)withoutLastIdx[i]=Math.max(withoutLastIdx[i-1],nums[i]+withoutLastIdx[i-2]);
            withoutFirstIdx[i]=Math.max(withoutFirstIdx[i-1],nums[i]+withoutFirstIdx[i-2]);
        }
        
        
        return Math.max(withoutLastIdx[n-2],Math.max(withoutLastIdx[n-3],Math.max(withoutFirstIdx[n-1],withoutFirstIdx[n-2])));
    }
}

=============================================================================================================================

class Solution {

    public int rob(int[] nums) {
        int n=nums.length;
        int start=0;
        int sec=0;
        if(n==1){return nums[0];}
        for(int i=0;i<n-1;i++){
            int temp=Math.max(sec,start+nums[i]);
            start=sec;
            sec=temp;
        }  
        int max=sec;
        start=0;
        sec=0;  
         for(int i=1;i<n;i++){
            int temp=Math.max(sec,start+nums[i]);
            start=sec;
            sec=temp;
        } 
        return Math.max(max,sec);
    }
}
