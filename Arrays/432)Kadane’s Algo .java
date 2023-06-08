Kadane’s Algo                                               LC-53
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and return its sum and print the subarray.
Examples:Example 1:
Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
Output: 6 
Explanation: [4,-1,2,1] has the largest sum = 6. 
Examples 2: 
Input: arr = [1] 
Output: 1 
Explanation: Array has only one element and which is giving positive sum of 1.
Solution 1: Naive Approach 
Approach: Using three for loops, we will get all possible subarrays in two loops and their sum in another loop, and then return the maximum of them.

Time Complexity: O(N^3)
Space Complexity: O(1) 

Solution 2: A better approach
Approach : 
We can also do this problem using only two for loops, we will avoid 3rd loop which was used in above approach, instead of that we will create new variable curr_sum, which stores the array sum from ith index to jth index.

Time Complexity: O(N^2) 
Space Complexity: O(1)

Solution : 3 Optimal Solution: Kadane’s Algorithm 
Intuition: Basically this problem can be done in linear time complexity with Kadane’s algorithm along with that will also get the subarray which is giving the largest positive-sum. 
Approach: 
-> We will have the following variables in the beginning : 
msf – max so far, meh – max sum ending at ith index, start – to get the starting index of ans’s subarray, end – to get the ending index of ans’s subarray. 
-> Traverse the array from starting and add the ith element to max_end_here(meh) , now we will check that adding the ith element gives greater value than max_so_far(msf) or not , if yes then we will update our msf and also update the starting and ending index(initially starting index is zero) . 
for(int i=0;i<nums.size();i++){ 
    meh+=nums[i]; 
    if(meh>msf){ msf=meh; start=s; end=i; } 
    if(meh<0){meh=0; s=i+1;} 
} 
->Now in this step, we will print the answer subarray using the start and end variables.
->Return the largest subarray sum that is:- msf. 

Approach 3:KADANE’S 
          int maxsum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
			if(sum<0)sum=0;
			maxsum=Math.max(maxsum, sum);
		}
		System.out.println(maxsum);
Approach 1: Find all possible sun aaray and then sum them
for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				for(int k=i;k<=j;k++)
				{
					System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
		}
Approach 2: Sum the elements 
public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum += nums[j];
                if (curr_sum > max_sum) {
                    subarray.clear();
                    max_sum = curr_sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }
