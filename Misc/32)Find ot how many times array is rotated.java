Find ot how many times array is rotated,gfg                      
Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value of K.
Example 1:
Input: N = 5 Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4.  The original sorted array is 1 2 3 4 5.  We can see that the array was rotated 
1 times to the right.
Example 2:Input: N = 5 Arr[] = {1, 2, 3, 4, 5}
Output: 0
Explanation: The given array is not rotated.
Constraints:
1 <= N <=105
1 <= Arri <= 107
Same as of – find minimum in rotated sorted array – return index of the lowest element
class Solution {
    public int findMin(int[] arr) {
        int start=0,end=arr.length-1,ans=Integer.MAX_VALUE;        
        while(start<=end)
        {
            if(arr[start]<=arr[end])
            {
                ans=Math.min(ans,arr[start]);
                break;
            }
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[mid])
            {
                ans=Math.min(ans,arr[start]);
                start=mid+1;
            }
            else
            {
                ans=Math.min(ans,arr[mid]);
                end=mid-1;
            }
        }
        return ans;
    }
}
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
