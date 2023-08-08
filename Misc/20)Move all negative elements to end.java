Move all negative elements to end, gfg
Given an unsorted array arr[] of size N having both negative and positive integers. The task is place all negative element at the end of array without changing the order of positive element and negative element.
Example 1:Input : 
N = 8
arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 
1  3  2  11  6  -1  -7  -5
Example 2:Input : 
N=8
arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
Output :
7  9  10  11  -5  -3  -4  -1
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)- for storing -ve numbers.
class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        int neg[]=new int[n];
        int idx=0;
        int curr=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                arr[curr]=arr[i];
                curr++;
            }
            else
            {
                neg[idx]=arr[i];
                idx++;
                
            }
        }
        for(int i=curr,j=0;j<idx;j++,i++)
        {
            arr[i]=neg[j];
        }
    }
}
