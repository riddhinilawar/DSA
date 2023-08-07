Rotate Array,gfg -left rotation
Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 
Example 1:
Input:
N = 5, D = 2
arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated
by 2 elements, it becomes 3 4 5 1 2.
Input:
N = 10, D = 3
arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20 
when rotated by 3 elements, it becomes 
8 10 12 14 16 18 20 2 4 6.
Constraints:
1 <= N <= 106
1 <= D <= 106
0 <= arr[i] <= 105
class Solution
{   //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        if(d>=n)d=d%n;
        int j=d-1;
        //rotate first d elements of the array
        for(int i=0;i<d/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        j=n-1;
        //rotate last n-d elements in the array
        for(int i=d;i<j;i++)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        j=n-1;
        //rotate complete array
        for(int i=0;i<j;i++)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;  
        }
    }
}
Expected Time Complexity: O(N)   Expected Auxiliary Space: O(1)
