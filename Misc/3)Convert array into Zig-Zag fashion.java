Convert array into Zig-Zag fashion,gfg
Given an array arr of distinct elements of size N, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form: 
arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n]. 

Example 1:
Input:
N = 7
Arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: 3 7 4 8 2 6 1
Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1
Example 2:
Input:
N = 4
Arr[] = {1, 4, 3, 2}
Output: 1 4 2 3
Explanation: 1 < 4 > 2 < 3
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
class Solution {
    void zigZag(int arr[], int n) {
        boolean flag=true; 
        for(int i=0;i<n-1;i++)
        {
            if(flag==true)
            {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         vvvvvvv
                if(arr[i]>arr[i+1])
                {
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
                flag=false;
            }
            else
            {
                if(arr[i]<arr[i+1])
                {
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
                flag=true;
            }
        }
    }
}

 

NOTE: In the mentioned complexity, only a unique solution will exist.
Constraints:
1 <= N <= 105
0 <= Arri <= 106
Asked In amazon


