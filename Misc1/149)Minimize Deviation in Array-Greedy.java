1675. Minimize Deviation in Array

You are given an array nums of n positive integers.

You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
Example 2:

Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
Example 3:

Input: nums = [2,10,8]
Output: 3
 

Constraints:

n == nums.length
2 <= n <= 5 * 104
1 <= nums[i] <= 109

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans=Integer.MAX_VALUE;

        for(int num:nums){
            if(num%2==1)num*=2;
            set.add(num);
        }
        
        while(true){
            int min=set.first();
            int max=set.last();
            ans=Math.min(ans,max-min);
            if(max%2==0){
                set.remove(max);
                set.add(max/2);
            }
            else
                break;
        } 
        return ans;
    }
}


Note:For 2nd test case, [4,1,5,20,3]. If 20 can transform to 5 by two operations, why can't we mutiply 1 twice, it would become [4,4,5,5,3], then min dev would be 2. Isn't that allowed?
 -->Because only odd number can be multiply by 2. 1 can only turn in to 2, or back to 1, not 4
