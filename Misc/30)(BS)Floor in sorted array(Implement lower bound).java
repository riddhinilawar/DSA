Floor in sorted array(Implement lower bound),gfg                          
Given a sorted array arr[] of size N without duplicates, and given a value x. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x. Find the index of K(0-based indexing).
Example 1:Input:
N = 7, x = 0 
arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less than 0 is found. So output is "-1".
Example 2:Input:
N = 7, x = 5 
arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is2 (i.e K = 2), whose index is 1(0-based indexing).
Constraints:
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

class Solution{
    static int findFloor(long arr[], int n, long x)
    {
        int temp= BS(arr,0,arr.length-1,x);
        if(temp==0)return -1;
        if(temp==n)return temp-1;
        if(arr[temp]==x)return temp;
        if(arr[temp]>x)return temp-1;
        else return temp;
    }
    static int BS(long arr[],int start,int end,long x)
    {
        int mid=start+(end-start)/2;    
        if(start>end)
        {
            return mid;
        }
        if(arr[mid]==x)return mid;
        else if(arr[mid]>x)
        {
            return BS(arr,start,mid-1,x);
        }
        else
        {
            return BS(arr,mid+1,end,x);
        }
    }
}
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
