Move Zeros                             LC-283
class Solution {
    public void moveZeroes(int[] arr) {
        int curr=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                arr[curr]=arr[i];
                curr++;
            }
        }
        for(int i=curr;i<arr.length;i++)
        {
            arr[i]=0;
        }
    }
}
class Solution {
    public void moveZeroes(int[] arr) {
        int curr=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[curr];
                arr[curr]=temp;
                curr++;
            }
        }
    }
}
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]
Constraints:
•	1 <= nums.length <= 104
•	-231 <= nums[i] <= 231 - 1
 
Follow up: Could you minimize the total number of operations done?
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

