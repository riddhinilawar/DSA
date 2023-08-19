Subarray with given sum(no -ve numbers),gfg
Sliding window
Exception:  need to handel explicity if the target sum is 0 in the input
class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> a=new ArrayList<Integer>();
        
        //handling exception
        if(s==0)
        {
            a.add(-1);
            return a;
        }
        
        int end=-1;
        int start=0;
        int sum=0;
        while(start<n)
        {
            while(end+1<n && sum+arr[end+1]<=s)
            {
                sum+=arr[++end];
            }
            
            if(sum==s)
            {
                a.add(start+1);
                a.add(end+1);
                return a;
            }
            
            sum-=arr[start++];
        }
        a.add(-1);
        return a;
    }
}
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S. In case of multiple subarrays, return the subarray which comes first on moving from left to right.
Example 1:Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 Example 2:Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
Your Task:
You don't need to read input or print anything. The task is to complete the function subarraySum() which takes arr, N and S as input parameters and returns an arraylist containing the starting and ending positions of the first such occurring subarray from the left where sum equals to S. The two indexes in the array should be according to 1-based indexing. If no such subarray is found, return an array consisting only one element that is -1.
Constraints: 1 <= N <= 105 1 <= Ai <= 109
Solution 1: nested for loop
Intuition:
There is no special intuition needed for the brute force solution. We just need to generate all sub-arrays, check the sum, and update the max length we found so far.
Approach:
In order to generate all the subarrays, we need two nested loops. First loop decides the starting index of the subarray.
Second loop traverses from the starting index and generates all possible subarrays from that.
At each point we check whether we have reached the required sum.
If so, i and j are the starting and ending indexes of the subarray, now we check whether the length of the current subarray is greater than the value we found so far.
Else, we move on to the next possible one..
Output: Length of the longest subarray with sum K is 3
Time Complexity: O(n^2) time to generate all possible subarrays.
Space Complexity: O(1), we are not using any extra space.

Solution 2: Sliding window
Intuition 2:
A simple intuition for the optimal approach is that, while forming a subarray if the sum as already greater than k, we can stop there and increase the starting index
Because, already the sum has reached k, if we are still going to add more elements, it would definitely go up.
This method is called a sliding window technique. We can think of a window covering the subarray, and the ends slide towards right all the time.
Here we have 2 nested loops. The outer loop slides the starting index of the window towards the right. The inner loop slides the ending index of the window towards the right.
Here is the working. First we fix the starting index and increase the ending index which increases the window size. We do this until we get the sum greater than k or we go out of bounds.
If we get a greater sum, we come out of the inner loop. We check whether we have got the sum, if so, now we compare with the max length we found so far, and replace it with the greatest.
Now, it’s time for us to shift the starting index, therefore we subtract the current starting element from the sum(meaning that we don’t include that number hereafter).
And we increase the start index which in turn decreases the window size. Now we can go on increasing the ending index as we did earlier.
output: Length of the longest subarray with sum K is 3
Time Complexity: O(2n) ~ O(n), if we observe closely, the window only forwards to the right always. And every element is visited at most 2 times, one by the end variable and by the start variable.
Space Complexity: O(1), we are not using any extra space.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
