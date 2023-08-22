Find the smallest divisor given a threshold            LC-1283
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
The test cases are generated so that there will be an answer.
Example 1:  Input: nums = [1,2,5,9], threshold = 6  Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
Example 2: Input: nums = [44,22,33,11,1], threshold = 5 Output: 44
Constraints:
•	1 <= nums.length <= 5 * 104
•	1 <= nums[i] <= 106
•	nums.length <= threshold <= 106
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)
class Solution {
     public int smallestDivisor(int[] A, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : A)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }
    /*public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = (int)1e6;
        //for(int i:nums)right+=i;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(sum(nums,threshold,mid)==true) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean sum(int[] nums, int threshold,int mid)
    {
        long sum = 0;
        for(int i : nums){
            int div = i / mid;
            sum += (long)div;
            if(i % mid != 0) sum++;
        }
        //System.out.println("hours-->"+hours);
        return sum <= (long)threshold;
    }*/    }
