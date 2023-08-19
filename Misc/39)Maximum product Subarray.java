Maximum product Subarray, gfg,LC-54
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.
 
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:
•	1 <= nums.length <= 2 * 104
•	-10 <= nums[i] <= 10
•	The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Approach:

Solution 1: nested for loop
Intuition:
There is no special intuition needed for the brute force solution. We just need to generate all sub-arrays, check the product, and update the max product found we found so far.
Approach:
In order to generate all the subarrays, we need two nested loops. First loop decides the starting index of the subarray.
Second loop traverses from the starting index and generates all possible subarrays from that.
At each point we check whether we have reached the required product. Store the max product among all in the result variable.

Time Complexity: O(n^2) time to generate all possible subarrays.
Space Complexity: O(1), we are not using any extra space.

Solution 2: Kadane’s Algorithm Application(Optimal)
The following approach is motivated by Kandane’s algorithm. To know Kadane’s Algorithm follow Kadane’s Algorithm
The pick point for this problem is that we can get the maximum product from the product of two negative numbers too.

Following are the steps for the approach:
•	Initially store 0th index value in ma, mi and result.
•	Traverse the array from 1st index till last.
•	For each element, if the element is -ve or 0 then swap ma with mi.
•	ma is maximum of current element, product of current element and ma.
•	mi is minimum of current element, product of current element and mi.

Time Complexity: O(n) time to generate all possible subarrays.
Space Complexity: O(1), we are not using any extra space.
Leetcode:
class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length==1)return nums[0];
        
        int ma=nums[0];
        int mi=nums[0];
        int result=nums[0];
      
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=0)
            {
                int temp=ma;
                ma=mi;
                mi=temp;
            }       
            ma=Math.max(nums[i],ma*nums[i]);
            mi=Math.min(nums[i],mi*nums[i]);
            
            result=Math.max(result,ma);
        }
        return result;
    }
}
GFG: 
class Solution {
    long maxProduct(int[] nums, int n) {
        if(nums.length==1)return nums[0];
        
        long ma=nums[0];
        long mi=nums[0];
        long result=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=0)
            {
                long temp=ma;
                ma=mi;
                mi=temp;
            }
            
            ma=Math.max(nums[i],ma*nums[i]);
            mi=Math.min(nums[i],mi*nums[i]);
            
            result=Math.max(result,ma);
        }
        return result;   } }
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
