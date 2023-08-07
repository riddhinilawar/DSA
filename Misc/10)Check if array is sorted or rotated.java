Check if array is sorted or rotated            LC-1752
class Solution {
    public boolean check(int[] nums) {
        int c=0;
         for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[(i+1)%nums.length]){
                c++;
            }
        }
        return c > 1 ? false : true;
    }
}
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 
Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 
Constraints:
•	1 <= nums.length <= 100
•	1 <= nums[i] <= 100
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
