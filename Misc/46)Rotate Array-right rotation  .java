Rotate Array-right rotation                 LC-189
My solution: 
class Solution {
    public void rotate(int[] arr, int k) {
        int n=arr.length;
        if(k>n)
        {
            k=k%n;
        }
        for(int i=0;i<(n-k)/2;i++)
        {
            //System.out.println(arr[i]+" "+arr[n-k-i-1]);
            int temp=arr[i];
            arr[i]=arr[n-k-i-1];
            arr[n-k-i-1]=temp;
        }
        int j=0;
        
        int t=n-k;
        
        for(int i=t;i<t+(n-t)/2;i++)
        {
            //System.out.println(arr[i]+" "+arr[n-k-i-1]);
            int temp=arr[i];
            arr[i]=arr[n-j-1];
            arr[n-j-1]=temp;
            j++;
        }
        
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}
Leetcode Discussion
class Solution {
    public void rotate(int[] nums, int k) {
       int n=nums.length;
        for(int i=0; i<n/2; i++){ //reverse the whole array
            int temp=nums[i];
            nums[i]=nums[n-1-i];
            nums[n-1-i]=temp;
            }
        
        int x=k%n; //figure this out!
        
        for(int i=0, j=x-1; i<j; i++, j--){ //reverse the first half
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            }
        
        for(int i=x, j=n-1; i<j; i++, j--){ //reverse the second half
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            }
    }
}
Given an array, rotate the array to the right by k steps, where k is non-negative.
 
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 
Constraints:
•	1 <= nums.length <= 105
•	-231 <= nums[i] <= 231 - 1
•	0 <= k <= 105
 
Follow up:
•	Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
•	Could you do it in-place with O(1) extra space?
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

