215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int mx = nums[0];//to get max value
        int mn = nums[0];//to get min value

        for(int i=1;i<nums.length;i++){
            mx = Math.max(mx, nums[i]);
            mn = Math.min(mn, nums[i]);
        }
        
        int size = Math.max(mx, -1*mn);//find largest absolute value
        int arrP[] = new int[size+1];//array for +ve numbers
        int arrN[] = new int[size+1];//array for -ve numbers

        /* arrP[i] denotes the total occurances of positive i, 
        where as arrN[i] denotes total occurances of -i value.*/

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                arrN[(-1*nums[i])]++;
            }else
                arrP[nums[i]]++;
        }
        int cur = 0;//to keep track of cur largest number

        //start finding the largest number from the last value of positive array follwing the negative array traversal from 1st index(largest -ve value) of arrN.


        for(int i=size;i>=0;i--){
            cur+= arrP[i];
            if(cur>=k)
            return i;
        }
        for(int i=1;i<=size;i++){
            cur += arrN[i];
            if(cur>=k)
            return (-1*i);
        }

        return -1;
    }
}
