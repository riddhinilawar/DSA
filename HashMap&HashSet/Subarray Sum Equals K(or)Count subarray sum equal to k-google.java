class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            
            if(!map.isEmpty()&&map.containsKey(sum-k))
                count+=map.get(sum-k);
            
            if(sum==k)
                count+=1;
            
            if(map.containsKey(sum))
                map.put(sum,map.get(sum)+1);
            else
                map.put(sum,1);
        }
        return count;
    }
}

560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
